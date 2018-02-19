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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingOrderLocalService}.
 *
 * @author rivetlogic
 * @see ShoppingOrderLocalService
 * @generated
 */
@ProviderType
public class ShoppingOrderLocalServiceWrapper
	implements ShoppingOrderLocalService,
		ServiceWrapper<ShoppingOrderLocalService> {
	public ShoppingOrderLocalServiceWrapper(
		ShoppingOrderLocalService shoppingOrderLocalService) {
		_shoppingOrderLocalService = shoppingOrderLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _shoppingOrderLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _shoppingOrderLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _shoppingOrderLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _shoppingOrderLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _shoppingOrderLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _shoppingOrderLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the Shopping Order to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrder the Shopping Order
	* @return the Shopping Order that was added
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder addShoppingOrder(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder) {
		return _shoppingOrderLocalService.addShoppingOrder(shoppingOrder);
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder createOrder(
		long orderId) {
		return _shoppingOrderLocalService.createOrder(orderId);
	}

	/**
	* Creates a new Shopping Order with the primary key. Does not add the Shopping Order to the database.
	*
	* @param orderId the primary key for the new Shopping Order
	* @return the new Shopping Order
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder createShoppingOrder(
		long orderId) {
		return _shoppingOrderLocalService.createShoppingOrder(orderId);
	}

	/**
	* Deletes the Shopping Order from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrder the Shopping Order
	* @return the Shopping Order that was removed
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder deleteShoppingOrder(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder) {
		return _shoppingOrderLocalService.deleteShoppingOrder(shoppingOrder);
	}

	/**
	* Deletes the Shopping Order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderId the primary key of the Shopping Order
	* @return the Shopping Order that was removed
	* @throws PortalException if a Shopping Order with the primary key could not be found
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder deleteShoppingOrder(
		long orderId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _shoppingOrderLocalService.deleteShoppingOrder(orderId);
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder fetchShoppingOrder(
		long orderId) {
		return _shoppingOrderLocalService.fetchShoppingOrder(orderId);
	}

	/**
	* Returns the Shopping Order matching the UUID and group.
	*
	* @param uuid the Shopping Order's UUID
	* @param groupId the primary key of the group
	* @return the matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder fetchShoppingOrderByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _shoppingOrderLocalService.fetchShoppingOrderByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the Shopping Order with the primary key.
	*
	* @param orderId the primary key of the Shopping Order
	* @return the Shopping Order
	* @throws PortalException if a Shopping Order with the primary key could not be found
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder getShoppingOrder(
		long orderId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _shoppingOrderLocalService.getShoppingOrder(orderId);
	}

	/**
	* Returns the Shopping Order matching the UUID and group.
	*
	* @param uuid the Shopping Order's UUID
	* @param groupId the primary key of the group
	* @return the matching Shopping Order
	* @throws PortalException if a matching Shopping Order could not be found
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder getShoppingOrderByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _shoppingOrderLocalService.getShoppingOrderByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder getUserActiveOrder(
		long userId, long groupId, long companyId, boolean createIfNotFound)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.getUserActiveOrder(userId, groupId,
			companyId, createIfNotFound);
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder updateOrder(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.updateOrder(shoppingOrder,
			serviceContext);
	}

	/**
	* Updates the Shopping Order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrder the Shopping Order
	* @return the Shopping Order that was updated
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder updateShoppingOrder(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder) {
		return _shoppingOrderLocalService.updateShoppingOrder(shoppingOrder);
	}

	@Override
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.countByGroupId(groupId);
	}

	/**
	* Returns the number of Shopping Orders.
	*
	* @return the number of Shopping Orders
	*/
	@Override
	public int getShoppingOrdersCount() {
		return _shoppingOrderLocalService.getShoppingOrdersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _shoppingOrderLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _shoppingOrderLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _shoppingOrderLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _shoppingOrderLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.findByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.rivetlogic.ecommerce.model.ShoppingOrder> comparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.findByGroupId(groupId, start, end,
			comparator);
	}

	@Override
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByGroupIdAndOrderStatus(
		long groupId, java.lang.String orderStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.findByGroupIdAndOrderStatus(groupId,
			orderStatus, start, end);
	}

	@Override
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByGroupIdAndOrderStatus(
		long groupId, java.lang.String orderStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.rivetlogic.ecommerce.model.ShoppingOrder> comparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.findByGroupIdAndOrderStatus(groupId,
			orderStatus, start, end, comparator);
	}

	@Override
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByGroupOrderStatusAndUserId(
		long groupId, java.lang.String orderStatus, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.findByGroupOrderStatusAndUserId(groupId,
			orderStatus, userId);
	}

	@Override
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByOrderStatusAndUserId(
		java.lang.String orderStatus, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.findByOrderStatusAndUserId(orderStatus,
			userId);
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
	@Override
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> getShoppingOrders(
		int start, int end) {
		return _shoppingOrderLocalService.getShoppingOrders(start, end);
	}

	/**
	* Returns all the Shopping Orders matching the UUID and company.
	*
	* @param uuid the UUID of the Shopping Orders
	* @param companyId the primary key of the company
	* @return the matching Shopping Orders, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> getShoppingOrdersByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _shoppingOrderLocalService.getShoppingOrdersByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> getShoppingOrdersByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.rivetlogic.ecommerce.model.ShoppingOrder> orderByComparator) {
		return _shoppingOrderLocalService.getShoppingOrdersByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _shoppingOrderLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _shoppingOrderLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public void placeOrder(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder,
		com.liferay.portal.kernel.messaging.Message[] notifyMessages,
		java.util.List<java.lang.String> orderItemsProductIdsList,
		java.util.Map<java.lang.String, java.lang.Float> prices,
		boolean paypalEnabled,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingOrderLocalService.placeOrder(shoppingOrder, notifyMessages,
			orderItemsProductIdsList, prices, paypalEnabled, serviceContext);
	}

	@Override
	public ShoppingOrderLocalService getWrappedService() {
		return _shoppingOrderLocalService;
	}

	@Override
	public void setWrappedService(
		ShoppingOrderLocalService shoppingOrderLocalService) {
		_shoppingOrderLocalService = shoppingOrderLocalService;
	}

	private ShoppingOrderLocalService _shoppingOrderLocalService;
}