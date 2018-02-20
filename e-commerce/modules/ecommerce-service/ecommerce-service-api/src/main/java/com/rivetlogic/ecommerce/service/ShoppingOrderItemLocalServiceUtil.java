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
 * Provides the local service utility for ShoppingOrderItem. This utility wraps
 * {@link com.rivetlogic.ecommerce.service.impl.ShoppingOrderItemLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author rivetlogic
 * @see ShoppingOrderItemLocalService
 * @see com.rivetlogic.ecommerce.service.base.ShoppingOrderItemLocalServiceBaseImpl
 * @see com.rivetlogic.ecommerce.service.impl.ShoppingOrderItemLocalServiceImpl
 * @generated
 */
@ProviderType
public class ShoppingOrderItemLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rivetlogic.ecommerce.service.impl.ShoppingOrderItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the Shopping Order Item to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrderItem the Shopping Order Item
	* @return the Shopping Order Item that was added
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem addShoppingOrderItem(
		com.rivetlogic.ecommerce.model.ShoppingOrderItem shoppingOrderItem) {
		return getService().addShoppingOrderItem(shoppingOrderItem);
	}

	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem createOrderItem(
		long orderId) {
		return getService().createOrderItem(orderId);
	}

	/**
	* Creates a new Shopping Order Item with the primary key. Does not add the Shopping Order Item to the database.
	*
	* @param itemId the primary key for the new Shopping Order Item
	* @return the new Shopping Order Item
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem createShoppingOrderItem(
		long itemId) {
		return getService().createShoppingOrderItem(itemId);
	}

	/**
	* Deletes the Shopping Order Item from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrderItem the Shopping Order Item
	* @return the Shopping Order Item that was removed
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem deleteShoppingOrderItem(
		com.rivetlogic.ecommerce.model.ShoppingOrderItem shoppingOrderItem) {
		return getService().deleteShoppingOrderItem(shoppingOrderItem);
	}

	/**
	* Deletes the Shopping Order Item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item that was removed
	* @throws PortalException if a Shopping Order Item with the primary key could not be found
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem deleteShoppingOrderItem(
		long itemId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteShoppingOrderItem(itemId);
	}

	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem fetchShoppingOrderItem(
		long itemId) {
		return getService().fetchShoppingOrderItem(itemId);
	}

	/**
	* Returns the Shopping Order Item matching the UUID and group.
	*
	* @param uuid the Shopping Order Item's UUID
	* @param groupId the primary key of the group
	* @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem fetchShoppingOrderItemByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchShoppingOrderItemByUuidAndGroupId(uuid, groupId);
	}

	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem findByOrderAndProductId(
		long orderId, java.lang.String productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByOrderAndProductId(orderId, productId);
	}

	/**
	* Returns the Shopping Order Item with the primary key.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item
	* @throws PortalException if a Shopping Order Item with the primary key could not be found
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem getShoppingOrderItem(
		long itemId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getShoppingOrderItem(itemId);
	}

	/**
	* Returns the Shopping Order Item matching the UUID and group.
	*
	* @param uuid the Shopping Order Item's UUID
	* @param groupId the primary key of the group
	* @return the matching Shopping Order Item
	* @throws PortalException if a matching Shopping Order Item could not be found
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem getShoppingOrderItemByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getShoppingOrderItemByUuidAndGroupId(uuid, groupId);
	}

	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem updateOrderItem(
		com.rivetlogic.ecommerce.model.ShoppingOrderItem shoppingOrderItem,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOrderItem(shoppingOrderItem, serviceContext);
	}

	/**
	* Updates the Shopping Order Item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrderItem the Shopping Order Item
	* @return the Shopping Order Item that was updated
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem updateShoppingOrderItem(
		com.rivetlogic.ecommerce.model.ShoppingOrderItem shoppingOrderItem) {
		return getService().updateShoppingOrderItem(shoppingOrderItem);
	}

	/**
	* Returns the number of Shopping Order Items.
	*
	* @return the number of Shopping Order Items
	*/
	public static int getShoppingOrderItemsCount() {
		return getService().getShoppingOrderItemsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> findByOrderId(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByOrderId(orderId);
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
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> getShoppingOrderItems(
		int start, int end) {
		return getService().getShoppingOrderItems(start, end);
	}

	/**
	* Returns all the Shopping Order Items matching the UUID and company.
	*
	* @param uuid the UUID of the Shopping Order Items
	* @param companyId the primary key of the company
	* @return the matching Shopping Order Items, or an empty list if no matches were found
	*/
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> getShoppingOrderItemsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService()
				   .getShoppingOrderItemsByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> getShoppingOrderItemsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.rivetlogic.ecommerce.model.ShoppingOrderItem> orderByComparator) {
		return getService()
				   .getShoppingOrderItemsByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
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

	public static void saveOrderItemByProductId(java.lang.String productId,
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder,
		float price,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.saveOrderItemByProductId(productId, shoppingOrder, price,
			serviceContext);
	}

	public static void saveOrderItemsByProductId(
		java.util.List<java.lang.String> productIdsList,
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.saveOrderItemsByProductId(productIdsList, shoppingOrder,
			serviceContext);
	}

	public static void saveOrderItemsByProductId(
		java.util.List<java.lang.String> productIdsList,
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder,
		java.util.Map<java.lang.String, java.lang.Float> prices,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.saveOrderItemsByProductId(productIdsList, shoppingOrder, prices,
			serviceContext);
	}

	public static ShoppingOrderItemLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ShoppingOrderItemLocalService, ShoppingOrderItemLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ShoppingOrderItemLocalService.class);
}