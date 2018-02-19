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

import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.rivetlogic.ecommerce.beans.ShoppingCartItem;
import com.rivetlogic.ecommerce.constants.ShoppingCartPortletKeys;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.portlet.ShoppingCartPortlet;
import com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil;
import com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil;
import com.rivetlogic.ecommerce.util.ShoppingCartItemUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
	        "javax.portlet.name="+ShoppingCartPortletKeys.SHOPPING_CART,
	        "mvc.command.name="+ShoppingCartPortletKeys.RC_ADD_CART_ITEM
	    },
	    service = MVCResourceCommand.class
)
public class AddCartItemResourceCommand extends BaseResourceCommand {


	private static final Log _log = LogFactoryUtil.getLog(AddCartItemResourceCommand.class);

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		String itemId = null;
		boolean error = false;
		
		try {
			itemId = ParamUtil.getString(resourceRequest,ShoppingCartPortletKeys.WEB_CONTENT_ITEM_ID);
			
			if (_log.isDebugEnabled()){
				_log.debug(ShoppingCartPortletKeys.RC_ADD_CART_ITEM+" "+itemId);
			}
			
			if (null == itemId || itemId.isEmpty()) {
				printJsonResponse(ERROR_MISSING_ITEM_ID_MESSAGE, HttpServletResponse.SC_BAD_REQUEST,
						resourceResponse);
				error = true;
			}
			else{
				doAddItemToCart(resourceRequest, resourceResponse);
				addCartDetailsOnResponse(resourceRequest, resourceResponse, itemId);
			}
		} catch (Exception e) {
			_log.error(String
					.format(ERROR_ADDING_ITEM_TO_CART_LOG, itemId, e));
			error = printJsonResponse(
					ERROR_ADDING_ITEM_TO_CART_MESSAGE,
					HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
					resourceResponse);
		}
		return error;
	}
	

	private boolean doAddItemToCart(ResourceRequest request, ResourceResponse response) throws SystemException, PortalException {
		
		boolean error = false;
		
		String itemId = ParamUtil.getString(request, ShoppingCartPortletKeys.WEB_CONTENT_ITEM_ID);
		int count = ParamUtil.getInteger(request, ShoppingCartPortletKeys.WEB_CONTENT_ITEM_COUNT, 1);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		float price = getItemPrice(itemId, themeDisplay.getScopeGroupId());
		
		if (isValidItemId(themeDisplay.getScopeGroupId(), itemId)) {
			List<String> itemsIdsList = new ArrayList<String>();
			for (int i = 0; i < count; i++) {
				itemsIdsList.add(itemId);
			}
			if (!themeDisplay.isSignedIn()) {
				if(null != ShoppingCartPortlet.getOrderItemsIdsFromSession(request))
					itemsIdsList.addAll(ShoppingCartPortlet.getOrderItemsIdsFromSession(request));
				setSessionOrderItemsIds(request, ListUtil.toString(itemsIdsList, StringPool.BLANK, StringPool.COMMA));
				setSessionOrderItemPrice(request, itemId, price);
			} else {
				ShoppingOrder activeShoppingOrder = ShoppingOrderLocalServiceUtil.getUserActiveOrder(
						themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(),
						themeDisplay.getCompanyId(),
						Boolean.TRUE);
				ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
				ShoppingOrderItemLocalServiceUtil.saveOrderItemByProductId(itemId, activeShoppingOrder, price, serviceContext);
			}
		} else {
			if (_log.isWarnEnabled()){
				_log.warn(String.format(ERROR_ITEM_ID_NOT_VALID_LOG, itemId,
					StringPool.BLANK));
			}
			error = printJsonResponse(ERROR_ITEM_ID_NOT_VALID_MESSAGE,
					HttpServletResponse.SC_NOT_FOUND, response);
		}
		
		return error;
	}
	
	private boolean isValidItemId(long groupId, String itemId) {
		boolean valid = false;
		try {
			JournalArticleLocalServiceUtil.getArticle(groupId, itemId);
			valid = true;
		} catch (PortalException | SystemException e) {
			_log.error(e);
		}
		return valid;
	}	
	
	private void setSessionOrderItemPrice(PortletRequest request, String itemId, float price) {
	    PortletSession portletSession = request.getPortletSession();
	    String value = "";
	    if(portletSession != null) {
	        Object current = portletSession.getAttribute(ShoppingCartPortletKeys.COOKIE_SHOPPING_CART_PRICES, PortletSession.APPLICATION_SCOPE);
	        if(current != null) {
	            value = (String) current;
	            value += ",";
	        }
	    }
	    value += String.format("%s=%s", itemId, price);
	    portletSession.setAttribute(ShoppingCartPortletKeys.COOKIE_SHOPPING_CART_PRICES, value, PortletSession.APPLICATION_SCOPE);
	}
	
	private float getItemPrice(String productId, long groupId) {
	    Document document = ShoppingCartItemUtil.getItemContent(productId, groupId);
	    if(document != null) {
	        Node itemListPriceNode = document
                    .selectSingleNode(ShoppingCartItem.LIST_PRICE);
            Node itemSalePriceNode = document
                    .selectSingleNode(ShoppingCartItem.SALE_PRICE);
            Float salePrice = !itemSalePriceNode.getStringValue().isEmpty() ? Float
                    .valueOf(itemSalePriceNode.getStringValue()) : 0;
            Float listPrice = !itemListPriceNode.getStringValue().isEmpty() ? Float
                    .valueOf(itemListPriceNode.getStringValue()) : 0;
            return salePrice != 0? salePrice : listPrice;
	    }
	    return 0;
	}
	
	
	

}