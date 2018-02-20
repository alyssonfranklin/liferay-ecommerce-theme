/**
 * Copyright (C) 2005-present Rivet Logic Corporation.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package com.rivetlogic.ecommerce.portlet.command;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.rivetlogic.ecommerce.beans.ShoppingCartItem;
import com.rivetlogic.ecommerce.constants.ShoppingCartPortletKeys;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.model.ShoppingOrderItem;
import com.rivetlogic.ecommerce.portlet.ShoppingCartPortlet;
import com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil;
import com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil;
import com.rivetlogic.ecommerce.util.ShoppingCartItemUtil;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseResourceCommand implements MVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(BaseResourceCommand.class);

	protected static boolean printJsonResponse(JSONObject jsonObject, ResourceResponse resourceResponse) {
		return printJsonResponse(jsonObject.toJSONString(), null, resourceResponse);
	}

	protected static boolean printJsonResponse(String response, Integer statusCode, ResourceResponse resourceResponse) {
		boolean error = false;
		try {
			if (null == statusCode) {
				statusCode = HttpServletResponse.SC_OK;
			}
			resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, String.valueOf(statusCode));
			resourceResponse.getWriter().write(response);
		} catch (IOException e) {
			_log.error(e.getMessage(), e);
			error = true;
		}
		return error;
	}

	protected void addCartDetailsOnResponse(ResourceRequest request, ResourceResponse response, String itemId)
			throws SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, Integer> cartItemsCountMap = new HashMap<String, Integer>();
		String itemToDetailProductId = itemId;
		boolean returnItemDetails = (null != itemId && !itemId.isEmpty());

		if (!themeDisplay.isSignedIn()) {
			List<String> itemsProductIdsList = ShoppingCartPortlet.getOrderItemsIdsFromSession(request);
			if (itemsProductIdsList == null && returnItemDetails) {
				itemsProductIdsList = new ArrayList<String>();
				itemsProductIdsList.add(itemId);
			}
			if (null != itemsProductIdsList) {
				for (String productId : itemsProductIdsList) {
					if (!cartItemsCountMap.containsKey(productId)) {
						cartItemsCountMap.put(productId, 1);
					} else {
						cartItemsCountMap.put(productId, cartItemsCountMap.get(productId) + 1);
					}
				}
			}
		} else {
			ShoppingOrder activeShoppingOrder = ShoppingOrderLocalServiceUtil.getUserActiveOrder(
					themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(),
					Boolean.FALSE);
			if (null != activeShoppingOrder) {
				List<ShoppingOrderItem> orderItemsList = ShoppingOrderItemLocalServiceUtil
						.findByOrderId(activeShoppingOrder.getOrderId());
				if (null != orderItemsList) {
					for (ShoppingOrderItem shoppingOrderItem : orderItemsList) {
						cartItemsCountMap.put(shoppingOrderItem.getProductId(), shoppingOrderItem.getQuantity());
						if (returnItemDetails && itemId.equals(String.valueOf(shoppingOrderItem.getItemId()))) {
							itemToDetailProductId = shoppingOrderItem.getProductId();
						}
					}
				}
			}
		}
		double total = 0;
		float itemTotal = 0;
		int quantity = 0, itemQuantity = 0;
		for (Entry<String, Integer> mapEntry : cartItemsCountMap.entrySet()) {
			Document document = ShoppingCartItemUtil.getItemContent(mapEntry.getKey(), themeDisplay.getScopeGroupId());
			if (null != document) {
				Node itemListPriceNode = document.selectSingleNode(ShoppingCartItem.LIST_PRICE);
				Node itemSalePriceNode = document.selectSingleNode(ShoppingCartItem.SALE_PRICE);
				Float salePrice = !itemSalePriceNode.getStringValue().isEmpty()
						? Float.valueOf(itemSalePriceNode.getStringValue()) : 0;
				Float listPrice = !itemListPriceNode.getStringValue().isEmpty()
						? Float.valueOf(itemListPriceNode.getStringValue()) : 0;
				total += (salePrice != 0 ? salePrice * (float) mapEntry.getValue()
						: listPrice * (float) mapEntry.getValue());
				quantity += mapEntry.getValue();
				if (returnItemDetails && itemToDetailProductId.equals(mapEntry.getKey())) {
					itemQuantity = mapEntry.getValue();
					itemTotal = (salePrice != 0 ? salePrice * (float) mapEntry.getValue()
							: listPrice * (float) mapEntry.getValue());
				}
			}
		}
		DecimalFormat totalFormat = new DecimalFormat(ShoppingCartPortletKeys.DECIMAL_FORMAT);
		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		JSONObject cartDetailsJson = JSONFactoryUtil.createJSONObject();
		cartDetailsJson.put(ShoppingCartPortletKeys.CART_DETAILS_TOTAL, totalFormat.format(total));
		cartDetailsJson.put(ShoppingCartPortletKeys.CART_DETAILS_QUANTITY, quantity);
		jsonResponse.put(ShoppingCartPortletKeys.CART_DETAILS, cartDetailsJson);
		if (returnItemDetails) {
			JSONObject itemDetailsJson = JSONFactoryUtil.createJSONObject();
			itemDetailsJson.put(ShoppingCartPortletKeys.CART_DETAILS_TOTAL, totalFormat.format(itemTotal));
			itemDetailsJson.put(ShoppingCartPortletKeys.CART_DETAILS_QUANTITY, itemQuantity);
			jsonResponse.put(ShoppingCartPortletKeys.ITEM_DETAILS, itemDetailsJson);
		}
		printJsonResponse(jsonResponse, response);
	}

	protected void setSessionOrderItemsIds(PortletRequest request, String value) {
		PortletSession portletSession = request.getPortletSession();
		portletSession.setAttribute(ShoppingCartPortletKeys.COOKIE_SHOPPING_CART_ITEMS, value, PortletSession.APPLICATION_SCOPE);
	}

	// Error response messages
	protected static final String ERROR_MISSING_ITEM_ID_MESSAGE = "The item id must be specified.";
	protected static final String ERROR_ADDING_ITEM_TO_CART_MESSAGE = "Error while adding the item to the cart.";
	protected static final String ERROR_REMOVING_ITEM_FROM_CART_MESSAGE = "Error while removing the item from the cart.";
	protected static final String ERROR_UPDATING_CART_ITEM_MESSAGE = "Error while updating the cart item.";
	protected static final String ERROR_ITEM_ID_NOT_VALID_MESSAGE = "The specified itemId is not valid.";
	protected static final String ERROR_BAD_PARAMETER_VALUE = "Bad value for parameter: %S.";
	protected static final String ERROR_SERVING_RESOURCE = "Error while serving resource. Command: %S. %S";
	// Log messages
	protected static final String ERROR_ADDING_ITEM_TO_CART_LOG = "Error while adding an item with id %S. %S";
	protected static final String ERROR_REMOVING_ITEM_FROM_CART_LOG = "Error while removing cart item with id: %S. %S";
	protected static final String ERROR_UPDATING_CART_ITEM_LOG = "Error while updating cart item with id: %S. %S";
	protected static final String ERROR_ITEM_ID_NOT_VALID_LOG = "The item id with id %S was not found.";
	protected static final String ERROR_CHECKING_PORTLET_CONFIG = "Error while checking the portlet configuration. %S";

}