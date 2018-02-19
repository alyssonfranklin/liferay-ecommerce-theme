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

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.notification.EmailNotificationUtil;
import com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil;
import com.rivetlogic.ecommerce.service.base.ShoppingOrderLocalServiceBaseImpl;
import com.rivetlogic.ecommerce.util.OrderStatusEnum;

import java.util.Date;
import java.util.List;
import java.util.Map;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the Shopping Order local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.rivetlogic.ecommerce.service.ShoppingOrderLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author rivetlogic
 * @see ShoppingOrderLocalServiceBaseImpl
 * @see com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil
 */
@ProviderType
public class ShoppingOrderLocalServiceImpl extends ShoppingOrderLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil} to access
	 * the Shopping Order local service.
	 */

	public ShoppingOrder createOrder(long orderId) {
		ShoppingOrder shoppingOrder = createShoppingOrder(orderId);
		return shoppingOrder;
	}

	private void setAuditFields(ShoppingOrder shoppingOrder, ServiceContext serviceContext) {
		Date now = new Date();
		if (shoppingOrder.isNew()) {
			shoppingOrder.setCreateDate(now);
		}
		shoppingOrder.setModifiedDate(now);
		shoppingOrder.setCompanyId(serviceContext.getCompanyId());
		shoppingOrder.setUserId(serviceContext.getUserId());
	}

	public ShoppingOrder updateOrder(ShoppingOrder shoppingOrder, ServiceContext serviceContext)
			throws SystemException {
		setAuditFields(shoppingOrder, serviceContext);
		return updateShoppingOrder(shoppingOrder);
	}

	public void placeOrder(ShoppingOrder shoppingOrder, Message[] notifyMessages, List<String> orderItemsProductIdsList,
			Map<String, Float> prices, boolean paypalEnabled, ServiceContext serviceContext) throws SystemException {
		shoppingOrder.setOrderStatus(paypalEnabled ? OrderStatusEnum.WAITING_FOR_PAYPAL.toString()
				: OrderStatusEnum.WAITING_FOR_PAYMENT.toString());
		updateOrder(shoppingOrder, serviceContext);
		shoppingOrderItemLocalService.saveOrderItemsByProductId(orderItemsProductIdsList, shoppingOrder, prices,
				serviceContext);
		if (!paypalEnabled && null != notifyMessages)
			for (Message message : notifyMessages) {
				if (message != null){
					EmailNotificationUtil.sendEmailNotification(message, serviceContext);
				}
			}
	}

	public ShoppingOrder getUserActiveOrder(long userId, long groupId, long companyId, boolean createIfNotFound)
			throws SystemException {
		List<ShoppingOrder> activeOrders = findByGroupOrderStatusAndUserId(groupId,
				OrderStatusEnum.IN_PROGRESS.toString(), userId);
		ShoppingOrder activeShoppingOrder = null;
		if (null != activeOrders && !activeOrders.isEmpty()) {
			activeShoppingOrder = activeOrders.get(0);
		} else if (createIfNotFound) {
			activeShoppingOrder = ShoppingOrderLocalServiceUtil
					.createShoppingOrder(CounterLocalServiceUtil.increment(ShoppingOrder.class.getName()));
			activeShoppingOrder.setOrderStatus(OrderStatusEnum.IN_PROGRESS.toString());
			activeShoppingOrder.setUserId(userId);
			activeShoppingOrder.setGroupId(groupId);
			activeShoppingOrder.setCompanyId(companyId);
			activeShoppingOrder.setCreateDate(DateUtil.newDate());
			activeShoppingOrder.setModifiedDate(DateUtil.newDate());
			ShoppingOrderLocalServiceUtil.addShoppingOrder(activeShoppingOrder);
		}

		return activeShoppingOrder;
	}

	public List<ShoppingOrder> findByGroupOrderStatusAndUserId(long groupId, String orderStatus, long userId)
			throws SystemException {
		return shoppingOrderPersistence.findByGroupOrderStatusAndUserId(groupId, orderStatus, userId);
	}

	public List<ShoppingOrder> findByOrderStatusAndUserId(String orderStatus, long userId) throws SystemException {
		return shoppingOrderPersistence.findByOrderStatusAndUserId(orderStatus, userId);
	}

	public List<ShoppingOrder> findByGroupIdAndOrderStatus(long groupId, String orderStatus, int start, int end)
			throws SystemException {
		return shoppingOrderPersistence.findByGroupIdAndOrderStatus(groupId, orderStatus, start, end);
	}

	public List<ShoppingOrder> findByGroupIdAndOrderStatus(long groupId, String orderStatus, int start, int end,
			OrderByComparator<ShoppingOrder> comparator) throws SystemException {
		return shoppingOrderPersistence.findByGroupIdAndOrderStatus(groupId, orderStatus, start, end, comparator);
	}

	public List<ShoppingOrder> findByGroupId(long groupId, int start, int end) throws SystemException {
		return shoppingOrderPersistence.findByGroupId(groupId, start, end);
	}

	public List<ShoppingOrder> findByGroupId(long groupId, int start, int end,
			OrderByComparator<ShoppingOrder> comparator) throws SystemException {
		return shoppingOrderPersistence.findByGroupId(groupId, start, end, comparator);
	}

	public int countByGroupId(long groupId) throws SystemException {
		return shoppingOrderPersistence.countByGroupId(groupId);
	}
}