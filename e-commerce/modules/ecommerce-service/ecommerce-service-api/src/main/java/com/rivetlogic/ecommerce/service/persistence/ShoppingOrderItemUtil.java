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

package com.rivetlogic.ecommerce.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.rivetlogic.ecommerce.model.ShoppingOrderItem;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the Shopping Order Item service. This utility wraps {@link com.rivetlogic.ecommerce.service.persistence.impl.ShoppingOrderItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rivetlogic
 * @see ShoppingOrderItemPersistence
 * @see com.rivetlogic.ecommerce.service.persistence.impl.ShoppingOrderItemPersistenceImpl
 * @generated
 */
@ProviderType
public class ShoppingOrderItemUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ShoppingOrderItem shoppingOrderItem) {
		getPersistence().clearCache(shoppingOrderItem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ShoppingOrderItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ShoppingOrderItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ShoppingOrderItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ShoppingOrderItem update(ShoppingOrderItem shoppingOrderItem) {
		return getPersistence().update(shoppingOrderItem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ShoppingOrderItem update(
		ShoppingOrderItem shoppingOrderItem, ServiceContext serviceContext) {
		return getPersistence().update(shoppingOrderItem, serviceContext);
	}

	/**
	* Returns all the Shopping Order Items where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the Shopping Order Items where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of Shopping Order Items
	* @param end the upper bound of the range of Shopping Order Items (not inclusive)
	* @return the range of matching Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the Shopping Order Items where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of Shopping Order Items
	* @param end the upper bound of the range of Shopping Order Items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the Shopping Order Items where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of Shopping Order Items
	* @param end the upper bound of the range of Shopping Order Items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first Shopping Order Item in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem findByUuid_First(java.lang.String uuid,
		OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first Shopping Order Item in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last Shopping Order Item in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem findByUuid_Last(java.lang.String uuid,
		OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last Shopping Order Item in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the Shopping Order Items before and after the current Shopping Order Item in the ordered set where uuid = &#63;.
	*
	* @param itemId the primary key of the current Shopping Order Item
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	*/
	public static ShoppingOrderItem[] findByUuid_PrevAndNext(long itemId,
		java.lang.String uuid,
		OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(itemId, uuid, orderByComparator);
	}

	/**
	* Removes all the Shopping Order Items where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of Shopping Order Items where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching Shopping Order Items
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the Shopping Order Item where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchShoppingOrderItemException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the Shopping Order Item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the Shopping Order Item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the Shopping Order Item where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the Shopping Order Item that was removed
	*/
	public static ShoppingOrderItem removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of Shopping Order Items where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching Shopping Order Items
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the Shopping Order Items where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the Shopping Order Items where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of Shopping Order Items
	* @param end the upper bound of the range of Shopping Order Items (not inclusive)
	* @return the range of matching Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the Shopping Order Items where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of Shopping Order Items
	* @param end the upper bound of the range of Shopping Order Items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the Shopping Order Items where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of Shopping Order Items
	* @param end the upper bound of the range of Shopping Order Items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first Shopping Order Item in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first Shopping Order Item in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last Shopping Order Item in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last Shopping Order Item in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the Shopping Order Items before and after the current Shopping Order Item in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param itemId the primary key of the current Shopping Order Item
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	*/
	public static ShoppingOrderItem[] findByUuid_C_PrevAndNext(long itemId,
		java.lang.String uuid, long companyId,
		OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(itemId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the Shopping Order Items where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of Shopping Order Items where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching Shopping Order Items
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the Shopping Order Items where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the matching Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findByOrderId(long orderId) {
		return getPersistence().findByOrderId(orderId);
	}

	/**
	* Returns a range of all the Shopping Order Items where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orderId the order ID
	* @param start the lower bound of the range of Shopping Order Items
	* @param end the upper bound of the range of Shopping Order Items (not inclusive)
	* @return the range of matching Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findByOrderId(long orderId,
		int start, int end) {
		return getPersistence().findByOrderId(orderId, start, end);
	}

	/**
	* Returns an ordered range of all the Shopping Order Items where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orderId the order ID
	* @param start the lower bound of the range of Shopping Order Items
	* @param end the upper bound of the range of Shopping Order Items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findByOrderId(long orderId,
		int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return getPersistence()
				   .findByOrderId(orderId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the Shopping Order Items where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orderId the order ID
	* @param start the lower bound of the range of Shopping Order Items
	* @param end the upper bound of the range of Shopping Order Items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findByOrderId(long orderId,
		int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByOrderId(orderId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem findByOrderId_First(long orderId,
		OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException {
		return getPersistence().findByOrderId_First(orderId, orderByComparator);
	}

	/**
	* Returns the first Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem fetchByOrderId_First(long orderId,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return getPersistence().fetchByOrderId_First(orderId, orderByComparator);
	}

	/**
	* Returns the last Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem findByOrderId_Last(long orderId,
		OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException {
		return getPersistence().findByOrderId_Last(orderId, orderByComparator);
	}

	/**
	* Returns the last Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem fetchByOrderId_Last(long orderId,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return getPersistence().fetchByOrderId_Last(orderId, orderByComparator);
	}

	/**
	* Returns the Shopping Order Items before and after the current Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param itemId the primary key of the current Shopping Order Item
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	*/
	public static ShoppingOrderItem[] findByOrderId_PrevAndNext(long itemId,
		long orderId, OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException {
		return getPersistence()
				   .findByOrderId_PrevAndNext(itemId, orderId, orderByComparator);
	}

	/**
	* Removes all the Shopping Order Items where orderId = &#63; from the database.
	*
	* @param orderId the order ID
	*/
	public static void removeByOrderId(long orderId) {
		getPersistence().removeByOrderId(orderId);
	}

	/**
	* Returns the number of Shopping Order Items where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the number of matching Shopping Order Items
	*/
	public static int countByOrderId(long orderId) {
		return getPersistence().countByOrderId(orderId);
	}

	/**
	* Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or throws a {@link NoSuchShoppingOrderItemException} if it could not be found.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem findByOrderAndProductId(long orderId,
		java.lang.String productId)
		throws com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException {
		return getPersistence().findByOrderAndProductId(orderId, productId);
	}

	/**
	* Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem fetchByOrderAndProductId(long orderId,
		java.lang.String productId) {
		return getPersistence().fetchByOrderAndProductId(orderId, productId);
	}

	/**
	* Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public static ShoppingOrderItem fetchByOrderAndProductId(long orderId,
		java.lang.String productId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByOrderAndProductId(orderId, productId,
			retrieveFromCache);
	}

	/**
	* Removes the Shopping Order Item where orderId = &#63; and productId = &#63; from the database.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the Shopping Order Item that was removed
	*/
	public static ShoppingOrderItem removeByOrderAndProductId(long orderId,
		java.lang.String productId)
		throws com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException {
		return getPersistence().removeByOrderAndProductId(orderId, productId);
	}

	/**
	* Returns the number of Shopping Order Items where orderId = &#63; and productId = &#63;.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the number of matching Shopping Order Items
	*/
	public static int countByOrderAndProductId(long orderId,
		java.lang.String productId) {
		return getPersistence().countByOrderAndProductId(orderId, productId);
	}

	/**
	* Caches the Shopping Order Item in the entity cache if it is enabled.
	*
	* @param shoppingOrderItem the Shopping Order Item
	*/
	public static void cacheResult(ShoppingOrderItem shoppingOrderItem) {
		getPersistence().cacheResult(shoppingOrderItem);
	}

	/**
	* Caches the Shopping Order Items in the entity cache if it is enabled.
	*
	* @param shoppingOrderItems the Shopping Order Items
	*/
	public static void cacheResult(List<ShoppingOrderItem> shoppingOrderItems) {
		getPersistence().cacheResult(shoppingOrderItems);
	}

	/**
	* Creates a new Shopping Order Item with the primary key. Does not add the Shopping Order Item to the database.
	*
	* @param itemId the primary key for the new Shopping Order Item
	* @return the new Shopping Order Item
	*/
	public static ShoppingOrderItem create(long itemId) {
		return getPersistence().create(itemId);
	}

	/**
	* Removes the Shopping Order Item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item that was removed
	* @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	*/
	public static ShoppingOrderItem remove(long itemId)
		throws com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException {
		return getPersistence().remove(itemId);
	}

	public static ShoppingOrderItem updateImpl(
		ShoppingOrderItem shoppingOrderItem) {
		return getPersistence().updateImpl(shoppingOrderItem);
	}

	/**
	* Returns the Shopping Order Item with the primary key or throws a {@link NoSuchShoppingOrderItemException} if it could not be found.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	*/
	public static ShoppingOrderItem findByPrimaryKey(long itemId)
		throws com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException {
		return getPersistence().findByPrimaryKey(itemId);
	}

	/**
	* Returns the Shopping Order Item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item, or <code>null</code> if a Shopping Order Item with the primary key could not be found
	*/
	public static ShoppingOrderItem fetchByPrimaryKey(long itemId) {
		return getPersistence().fetchByPrimaryKey(itemId);
	}

	public static java.util.Map<java.io.Serializable, ShoppingOrderItem> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the Shopping Order Items.
	*
	* @return the Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the Shopping Order Items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Shopping Order Items
	* @param end the upper bound of the range of Shopping Order Items (not inclusive)
	* @return the range of Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the Shopping Order Items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Shopping Order Items
	* @param end the upper bound of the range of Shopping Order Items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findAll(int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the Shopping Order Items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Shopping Order Items
	* @param end the upper bound of the range of Shopping Order Items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of Shopping Order Items
	*/
	public static List<ShoppingOrderItem> findAll(int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the Shopping Order Items from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Shopping Order Items.
	*
	* @return the number of Shopping Order Items
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ShoppingOrderItemPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ShoppingOrderItemPersistence, ShoppingOrderItemPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ShoppingOrderItemPersistence.class);
}