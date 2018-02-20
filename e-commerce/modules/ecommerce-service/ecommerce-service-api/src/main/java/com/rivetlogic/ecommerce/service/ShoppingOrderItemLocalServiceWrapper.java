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
 * Provides a wrapper for {@link ShoppingOrderItemLocalService}.
 *
 * @author rivetlogic
 * @see ShoppingOrderItemLocalService
 * @generated
 */
@ProviderType
public class ShoppingOrderItemLocalServiceWrapper
	implements ShoppingOrderItemLocalService,
		ServiceWrapper<ShoppingOrderItemLocalService> {
	public ShoppingOrderItemLocalServiceWrapper(
		ShoppingOrderItemLocalService shoppingOrderItemLocalService) {
		_shoppingOrderItemLocalService = shoppingOrderItemLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _shoppingOrderItemLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _shoppingOrderItemLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _shoppingOrderItemLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _shoppingOrderItemLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _shoppingOrderItemLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _shoppingOrderItemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the Shopping Order Item to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrderItem the Shopping Order Item
	* @return the Shopping Order Item that was added
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem addShoppingOrderItem(
		com.rivetlogic.ecommerce.model.ShoppingOrderItem shoppingOrderItem) {
		return _shoppingOrderItemLocalService.addShoppingOrderItem(shoppingOrderItem);
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem createOrderItem(
		long orderId) {
		return _shoppingOrderItemLocalService.createOrderItem(orderId);
	}

	/**
	* Creates a new Shopping Order Item with the primary key. Does not add the Shopping Order Item to the database.
	*
	* @param itemId the primary key for the new Shopping Order Item
	* @return the new Shopping Order Item
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem createShoppingOrderItem(
		long itemId) {
		return _shoppingOrderItemLocalService.createShoppingOrderItem(itemId);
	}

	/**
	* Deletes the Shopping Order Item from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrderItem the Shopping Order Item
	* @return the Shopping Order Item that was removed
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem deleteShoppingOrderItem(
		com.rivetlogic.ecommerce.model.ShoppingOrderItem shoppingOrderItem) {
		return _shoppingOrderItemLocalService.deleteShoppingOrderItem(shoppingOrderItem);
	}

	/**
	* Deletes the Shopping Order Item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item that was removed
	* @throws PortalException if a Shopping Order Item with the primary key could not be found
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem deleteShoppingOrderItem(
		long itemId) throws com.liferay.portal.kernel.exception.PortalException {
		return _shoppingOrderItemLocalService.deleteShoppingOrderItem(itemId);
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem fetchShoppingOrderItem(
		long itemId) {
		return _shoppingOrderItemLocalService.fetchShoppingOrderItem(itemId);
	}

	/**
	* Returns the Shopping Order Item matching the UUID and group.
	*
	* @param uuid the Shopping Order Item's UUID
	* @param groupId the primary key of the group
	* @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem fetchShoppingOrderItemByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _shoppingOrderItemLocalService.fetchShoppingOrderItemByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem findByOrderAndProductId(
		long orderId, java.lang.String productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderItemLocalService.findByOrderAndProductId(orderId,
			productId);
	}

	/**
	* Returns the Shopping Order Item with the primary key.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item
	* @throws PortalException if a Shopping Order Item with the primary key could not be found
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem getShoppingOrderItem(
		long itemId) throws com.liferay.portal.kernel.exception.PortalException {
		return _shoppingOrderItemLocalService.getShoppingOrderItem(itemId);
	}

	/**
	* Returns the Shopping Order Item matching the UUID and group.
	*
	* @param uuid the Shopping Order Item's UUID
	* @param groupId the primary key of the group
	* @return the matching Shopping Order Item
	* @throws PortalException if a matching Shopping Order Item could not be found
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem getShoppingOrderItemByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _shoppingOrderItemLocalService.getShoppingOrderItemByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem updateOrderItem(
		com.rivetlogic.ecommerce.model.ShoppingOrderItem shoppingOrderItem,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderItemLocalService.updateOrderItem(shoppingOrderItem,
			serviceContext);
	}

	/**
	* Updates the Shopping Order Item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrderItem the Shopping Order Item
	* @return the Shopping Order Item that was updated
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem updateShoppingOrderItem(
		com.rivetlogic.ecommerce.model.ShoppingOrderItem shoppingOrderItem) {
		return _shoppingOrderItemLocalService.updateShoppingOrderItem(shoppingOrderItem);
	}

	/**
	* Returns the number of Shopping Order Items.
	*
	* @return the number of Shopping Order Items
	*/
	@Override
	public int getShoppingOrderItemsCount() {
		return _shoppingOrderItemLocalService.getShoppingOrderItemsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _shoppingOrderItemLocalService.getOSGiServiceIdentifier();
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
		return _shoppingOrderItemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _shoppingOrderItemLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _shoppingOrderItemLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> findByOrderId(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderItemLocalService.findByOrderId(orderId);
	}

	/**
	* Returns a range of all the Shopping Order Items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Shopping Order Items
	* @param end the upper bound of the range of Shopping Order Items (not inclusive)
	* @return the range of Shopping Order Items
	*/
	@Override
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> getShoppingOrderItems(
		int start, int end) {
		return _shoppingOrderItemLocalService.getShoppingOrderItems(start, end);
	}

	/**
	* Returns all the Shopping Order Items matching the UUID and company.
	*
	* @param uuid the UUID of the Shopping Order Items
	* @param companyId the primary key of the company
	* @return the matching Shopping Order Items, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> getShoppingOrderItemsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _shoppingOrderItemLocalService.getShoppingOrderItemsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of Shopping Order Items matching the UUID and company.
	*
	* @param uuid the UUID of the Shopping Order Items
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of Shopping Order Items
	* @param end the upper bound of the range of Shopping Order Items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching Shopping Order Items, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> getShoppingOrderItemsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.rivetlogic.ecommerce.model.ShoppingOrderItem> orderByComparator) {
		return _shoppingOrderItemLocalService.getShoppingOrderItemsByUuidAndCompanyId(uuid,
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
		return _shoppingOrderItemLocalService.dynamicQueryCount(dynamicQuery);
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
		return _shoppingOrderItemLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public void saveOrderItemByProductId(java.lang.String productId,
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder,
		float price,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingOrderItemLocalService.saveOrderItemByProductId(productId,
			shoppingOrder, price, serviceContext);
	}

	@Override
	public void saveOrderItemsByProductId(
		java.util.List<java.lang.String> productIdsList,
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingOrderItemLocalService.saveOrderItemsByProductId(productIdsList,
			shoppingOrder, serviceContext);
	}

	@Override
	public void saveOrderItemsByProductId(
		java.util.List<java.lang.String> productIdsList,
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder,
		java.util.Map<java.lang.String, java.lang.Float> prices,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingOrderItemLocalService.saveOrderItemsByProductId(productIdsList,
			shoppingOrder, prices, serviceContext);
	}

	@Override
	public ShoppingOrderItemLocalService getWrappedService() {
		return _shoppingOrderItemLocalService;
	}

	@Override
	public void setWrappedService(
		ShoppingOrderItemLocalService shoppingOrderItemLocalService) {
		_shoppingOrderItemLocalService = shoppingOrderItemLocalService;
	}

	private ShoppingOrderItemLocalService _shoppingOrderItemLocalService;
}