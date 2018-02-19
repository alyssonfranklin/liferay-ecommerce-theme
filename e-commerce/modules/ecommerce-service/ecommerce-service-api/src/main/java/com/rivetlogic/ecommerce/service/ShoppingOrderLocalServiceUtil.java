/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.ecommerce.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ShoppingOrder. This utility wraps
 * {@link com.rivetlogic.ecommerce.service.impl.ShoppingOrderLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author rivetlogic
 * @see ShoppingOrderLocalService
 * @see com.rivetlogic.ecommerce.service.base.ShoppingOrderLocalServiceBaseImpl
 * @see com.rivetlogic.ecommerce.service.impl.ShoppingOrderLocalServiceImpl
 * @generated
 */
@ProviderType
public class ShoppingOrderLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rivetlogic.ecommerce.service.impl.ShoppingOrderLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the Shopping Order to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrder the Shopping Order
	* @return the Shopping Order that was added
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrder addShoppingOrder(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder) {
		return getService().addShoppingOrder(shoppingOrder);
	}

	public static com.rivetlogic.ecommerce.model.ShoppingOrder createOrder(
		long orderId) {
		return getService().createOrder(orderId);
	}

	/**
	* Creates a new Shopping Order with the primary key. Does not add the Shopping Order to the database.
	*
	* @param orderId the primary key for the new Shopping Order
	* @return the new Shopping Order
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrder createShoppingOrder(
		long orderId) {
		return getService().createShoppingOrder(orderId);
	}

	/**
	* Deletes the Shopping Order from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrder the Shopping Order
	* @return the Shopping Order that was removed
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrder deleteShoppingOrder(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder) {
		return getService().deleteShoppingOrder(shoppingOrder);
	}

	/**
	* Deletes the Shopping Order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderId the primary key of the Shopping Order
	* @return the Shopping Order that was removed
	* @throws PortalException if a Shopping Order with the primary key could not be found
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrder deleteShoppingOrder(
		long orderId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteShoppingOrder(orderId);
	}

	public static com.rivetlogic.ecommerce.model.ShoppingOrder fetchShoppingOrder(
		long orderId) {
		return getService().fetchShoppingOrder(orderId);
	}

	/**
	* Returns the Shopping Order matching the UUID and group.
	*
	* @param uuid the Shopping Order's UUID
	* @param groupId the primary key of the group
	* @return the matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrder fetchShoppingOrderByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchShoppingOrderByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the Shopping Order with the primary key.
	*
	* @param orderId the primary key of the Shopping Order
	* @return the Shopping Order
	* @throws PortalException if a Shopping Order with the primary key could not be found
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrder getShoppingOrder(
		long orderId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getShoppingOrder(orderId);
	}

	/**
	* Returns the Shopping Order matching the UUID and group.
	*
	* @param uuid the Shopping Order's UUID
	* @param groupId the primary key of the group
	* @return the matching Shopping Order
	* @throws PortalException if a matching Shopping Order could not be found
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrder getShoppingOrderByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getShoppingOrderByUuidAndGroupId(uuid, groupId);
	}

	public static com.rivetlogic.ecommerce.model.ShoppingOrder getUserActiveOrder(
		long userId, long groupId, long companyId, boolean createIfNotFound)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getUserActiveOrder(userId, groupId, companyId,
			createIfNotFound);
	}

	public static com.rivetlogic.ecommerce.model.ShoppingOrder updateOrder(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOrder(shoppingOrder, serviceContext);
	}

	/**
	* Updates the Shopping Order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrder the Shopping Order
	* @return the Shopping Order that was updated
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrder updateShoppingOrder(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder) {
		return getService().updateShoppingOrder(shoppingOrder);
	}

	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroupId(groupId);
	}

	/**
	* Returns the number of Shopping Orders.
	*
	* @return the number of Shopping Orders
	*/
	public static int getShoppingOrdersCount() {
		return getService().getShoppingOrdersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroupId(groupId, start, end);
	}

	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.rivetlogic.ecommerce.model.ShoppingOrder> comparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroupId(groupId, start, end, comparator);
	}

	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByGroupIdAndOrderStatus(
		long groupId, java.lang.String orderStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByGroupIdAndOrderStatus(groupId, orderStatus, start, end);
	}

	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByGroupIdAndOrderStatus(
		long groupId, java.lang.String orderStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.rivetlogic.ecommerce.model.ShoppingOrder> comparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByGroupIdAndOrderStatus(groupId, orderStatus, start,
			end, comparator);
	}

	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByGroupOrderStatusAndUserId(
		long groupId, java.lang.String orderStatus, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByGroupOrderStatusAndUserId(groupId, orderStatus, userId);
	}

	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByOrderStatusAndUserId(
		java.lang.String orderStatus, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByOrderStatusAndUserId(orderStatus, userId);
	}

	/**
	* Returns a range of all the Shopping Orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @return the range of Shopping Orders
	*/
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> getShoppingOrders(
		int start, int end) {
		return getService().getShoppingOrders(start, end);
	}

	/**
	* Returns all the Shopping Orders matching the UUID and company.
	*
	* @param uuid the UUID of the Shopping Orders
	* @param companyId the primary key of the company
	* @return the matching Shopping Orders, or an empty list if no matches were found
	*/
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> getShoppingOrdersByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getShoppingOrdersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of Shopping Orders matching the UUID and company.
	*
	* @param uuid the UUID of the Shopping Orders
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching Shopping Orders, or an empty list if no matches were found
	*/
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> getShoppingOrdersByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.rivetlogic.ecommerce.model.ShoppingOrder> orderByComparator) {
		return getService()
				   .getShoppingOrdersByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static void placeOrder(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder,
		com.liferay.portal.kernel.messaging.Message[] notifyMessages,
		java.util.List<java.lang.String> orderItemsProductIdsList,
		java.util.Map<java.lang.String, java.lang.Float> prices,
		boolean paypalEnabled,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.placeOrder(shoppingOrder, notifyMessages,
			orderItemsProductIdsList, prices, paypalEnabled, serviceContext);
	}

	public static ShoppingOrderLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ShoppingOrderLocalService, ShoppingOrderLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ShoppingOrderLocalService.class);
}