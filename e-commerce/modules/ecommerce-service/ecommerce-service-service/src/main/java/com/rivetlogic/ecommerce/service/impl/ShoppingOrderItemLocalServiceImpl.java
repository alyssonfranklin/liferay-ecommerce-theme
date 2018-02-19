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
package com.rivetlogic.ecommerce.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.model.ShoppingOrderItem;
import com.rivetlogic.ecommerce.service.base.ShoppingOrderItemLocalServiceBaseImpl;
import com.rivetlogic.ecommerce.service.persistence.ShoppingOrderItemUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the Shopping Order Item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author rivetlogic
 * @see ShoppingOrderItemLocalServiceBaseImpl
 * @see com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil
 */
@ProviderType
public class ShoppingOrderItemLocalServiceImpl extends ShoppingOrderItemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil} to
	 * access the Shopping Order Item local service.
	 */

	public ShoppingOrderItem createOrderItem(long orderId) {
		ShoppingOrderItem shoppingOrderItem = createShoppingOrderItem(orderId);
		return shoppingOrderItem;
	}

	private void setAuditFields(ShoppingOrderItem shoppingOrderItem, ServiceContext serviceContext) {
		Date now = new Date();
		if (shoppingOrderItem.isNew()) {
			shoppingOrderItem.setCreateDate(now);
		}
		shoppingOrderItem.setModifiedDate(now);
		shoppingOrderItem.setCompanyId(serviceContext.getCompanyId());
		shoppingOrderItem.setUserId(serviceContext.getUserId());
	}

	public ShoppingOrderItem updateOrderItem(ShoppingOrderItem shoppingOrderItem, ServiceContext serviceContext)
			throws SystemException {
		setAuditFields(shoppingOrderItem, serviceContext);
		return updateShoppingOrderItem(shoppingOrderItem);
	}

	private void saveOrderItem(String productId, long orderId, ServiceContext serviceContext) throws SystemException {
		float price = 0;
		saveOrderItem(productId, orderId, price, serviceContext);
	}

	private void saveOrderItem(String productId, long orderId, float price, ServiceContext serviceContext)
			throws SystemException {
		long orderItemId = counterLocalService.increment(ShoppingOrderItem.class.getName());
		ShoppingOrderItem shoppingOrderItem = createOrderItem(orderItemId);
		shoppingOrderItem.setOrderId(orderId);
		//Note: It's always adding one article, because from the front end the quantity is not sent but the items are repeated in a list
		shoppingOrderItem.setQuantity(1);
		shoppingOrderItem.setPrice(price);
		shoppingOrderItem.setProductId(productId);
		updateOrderItem(shoppingOrderItem, serviceContext);
	}

	public void saveOrderItemsByProductId(List<String> productIdsList, ShoppingOrder shoppingOrder,
			ServiceContext serviceContext) throws SystemException {
		if (null == productIdsList)
			return;
		for (String itemToAdd : productIdsList) {
			try {
				ShoppingOrderItem shoppingOrderItem = findByOrderAndProductId(shoppingOrder.getOrderId(), itemToAdd);
				if (null == shoppingOrderItem) {
					// meaning that there is db record for that item
					saveOrderItem(itemToAdd, shoppingOrder.getOrderId(), serviceContext);
				} else {
					// increase the count for that item and updates it
					shoppingOrderItem.setQuantity(shoppingOrderItem.getQuantity() + 1);
					updateShoppingOrderItem(shoppingOrderItem);
				}
			} catch (SystemException e) {
				throw new SystemException(String.format(ERROR_SAVING_ORDER_ITEM, itemToAdd, e.getMessage()));
			}
		}
	}

	public void saveOrderItemsByProductId(List<String> productIdsList, ShoppingOrder shoppingOrder,
			Map<String, Float> prices, ServiceContext serviceContext) throws SystemException {
		if (null == productIdsList)
			return;
		for (String itemToAdd : productIdsList) {
			try {
				ShoppingOrderItem shoppingOrderItem = findByOrderAndProductId(shoppingOrder.getOrderId(), itemToAdd);
				if (null == shoppingOrderItem) {
					// meaning that there is db record for that item
					saveOrderItem(itemToAdd, shoppingOrder.getOrderId(), prices.get(itemToAdd), serviceContext);
				} else {
					// increase the count for that item and updates it
					shoppingOrderItem.setQuantity(shoppingOrderItem.getQuantity() + 1);
					updateShoppingOrderItem(shoppingOrderItem);
				}
			} catch (SystemException e) {
				throw new SystemException(String.format(ERROR_SAVING_ORDER_ITEM, itemToAdd, e.getMessage()));
			}
		}
	}

	public void saveOrderItemByProductId(String productId, ShoppingOrder shoppingOrder, float price,
			ServiceContext serviceContext) throws SystemException {
		if (null == productId)
			return;

		try {
			ShoppingOrderItem shoppingOrderItem = findByOrderAndProductId(shoppingOrder.getOrderId(), productId);
			if (null == shoppingOrderItem) {
				// meaning that there is db record for that item
				saveOrderItem(productId, shoppingOrder.getOrderId(), price, serviceContext);
			} else {
				// increase the count for that item and updates it
				shoppingOrderItem.setQuantity(shoppingOrderItem.getQuantity() + 1);
				updateShoppingOrderItem(shoppingOrderItem);
			}
		} catch (SystemException e) {
			throw new SystemException(String.format(ERROR_SAVING_ORDER_ITEM, productId, e.getMessage()));
		}
	}

	public List<ShoppingOrderItem> findByOrderId(long orderId) throws SystemException {
		return ShoppingOrderItemUtil.findByOrderId(orderId);
	}

	public ShoppingOrderItem findByOrderAndProductId(long orderId, String productId) throws SystemException {
		try {
			return ShoppingOrderItemUtil.findByOrderAndProductId(orderId, productId);
		} catch (NoSuchShoppingOrderItemException e) {
			return null;
		}
	}

	private static final String ERROR_SAVING_ORDER_ITEM = "Error while saving order item with productId: %S. %S";

}