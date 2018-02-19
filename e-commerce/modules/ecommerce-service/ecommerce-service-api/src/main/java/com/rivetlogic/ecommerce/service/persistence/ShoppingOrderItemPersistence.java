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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException;
import com.rivetlogic.ecommerce.model.ShoppingOrderItem;

/**
 * The persistence interface for the Shopping Order Item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rivetlogic
 * @see com.rivetlogic.ecommerce.service.persistence.impl.ShoppingOrderItemPersistenceImpl
 * @see ShoppingOrderItemUtil
 * @generated
 */
@ProviderType
public interface ShoppingOrderItemPersistence extends BasePersistence<ShoppingOrderItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ShoppingOrderItemUtil} to access the Shopping Order Item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the Shopping Order Items where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching Shopping Order Items
	*/
	public java.util.List<ShoppingOrderItem> findByUuid(java.lang.String uuid);

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
	public java.util.List<ShoppingOrderItem> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<ShoppingOrderItem> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator);

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
	public java.util.List<ShoppingOrderItem> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first Shopping Order Item in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException;

	/**
	* Returns the first Shopping Order Item in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator);

	/**
	* Returns the last Shopping Order Item in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException;

	/**
	* Returns the last Shopping Order Item in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator);

	/**
	* Returns the Shopping Order Items before and after the current Shopping Order Item in the ordered set where uuid = &#63;.
	*
	* @param itemId the primary key of the current Shopping Order Item
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	*/
	public ShoppingOrderItem[] findByUuid_PrevAndNext(long itemId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException;

	/**
	* Removes all the Shopping Order Items where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of Shopping Order Items where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching Shopping Order Items
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the Shopping Order Item where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchShoppingOrderItemException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchShoppingOrderItemException;

	/**
	* Returns the Shopping Order Item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the Shopping Order Item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the Shopping Order Item where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the Shopping Order Item that was removed
	*/
	public ShoppingOrderItem removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchShoppingOrderItemException;

	/**
	* Returns the number of Shopping Order Items where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching Shopping Order Items
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the Shopping Order Items where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching Shopping Order Items
	*/
	public java.util.List<ShoppingOrderItem> findByUuid_C(
		java.lang.String uuid, long companyId);

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
	public java.util.List<ShoppingOrderItem> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end);

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
	public java.util.List<ShoppingOrderItem> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator);

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
	public java.util.List<ShoppingOrderItem> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first Shopping Order Item in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException;

	/**
	* Returns the first Shopping Order Item in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator);

	/**
	* Returns the last Shopping Order Item in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException;

	/**
	* Returns the last Shopping Order Item in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator);

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
	public ShoppingOrderItem[] findByUuid_C_PrevAndNext(long itemId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException;

	/**
	* Removes all the Shopping Order Items where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of Shopping Order Items where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching Shopping Order Items
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the Shopping Order Items where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the matching Shopping Order Items
	*/
	public java.util.List<ShoppingOrderItem> findByOrderId(long orderId);

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
	public java.util.List<ShoppingOrderItem> findByOrderId(long orderId,
		int start, int end);

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
	public java.util.List<ShoppingOrderItem> findByOrderId(long orderId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator);

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
	public java.util.List<ShoppingOrderItem> findByOrderId(long orderId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem findByOrderId_First(long orderId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException;

	/**
	* Returns the first Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem fetchByOrderId_First(long orderId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator);

	/**
	* Returns the last Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem findByOrderId_Last(long orderId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException;

	/**
	* Returns the last Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem fetchByOrderId_Last(long orderId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator);

	/**
	* Returns the Shopping Order Items before and after the current Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param itemId the primary key of the current Shopping Order Item
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	*/
	public ShoppingOrderItem[] findByOrderId_PrevAndNext(long itemId,
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException;

	/**
	* Removes all the Shopping Order Items where orderId = &#63; from the database.
	*
	* @param orderId the order ID
	*/
	public void removeByOrderId(long orderId);

	/**
	* Returns the number of Shopping Order Items where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the number of matching Shopping Order Items
	*/
	public int countByOrderId(long orderId);

	/**
	* Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or throws a {@link NoSuchShoppingOrderItemException} if it could not be found.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the matching Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem findByOrderAndProductId(long orderId,
		java.lang.String productId) throws NoSuchShoppingOrderItemException;

	/**
	* Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem fetchByOrderAndProductId(long orderId,
		java.lang.String productId);

	/**
	* Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	*/
	public ShoppingOrderItem fetchByOrderAndProductId(long orderId,
		java.lang.String productId, boolean retrieveFromCache);

	/**
	* Removes the Shopping Order Item where orderId = &#63; and productId = &#63; from the database.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the Shopping Order Item that was removed
	*/
	public ShoppingOrderItem removeByOrderAndProductId(long orderId,
		java.lang.String productId) throws NoSuchShoppingOrderItemException;

	/**
	* Returns the number of Shopping Order Items where orderId = &#63; and productId = &#63;.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the number of matching Shopping Order Items
	*/
	public int countByOrderAndProductId(long orderId, java.lang.String productId);

	/**
	* Caches the Shopping Order Item in the entity cache if it is enabled.
	*
	* @param shoppingOrderItem the Shopping Order Item
	*/
	public void cacheResult(ShoppingOrderItem shoppingOrderItem);

	/**
	* Caches the Shopping Order Items in the entity cache if it is enabled.
	*
	* @param shoppingOrderItems the Shopping Order Items
	*/
	public void cacheResult(
		java.util.List<ShoppingOrderItem> shoppingOrderItems);

	/**
	* Creates a new Shopping Order Item with the primary key. Does not add the Shopping Order Item to the database.
	*
	* @param itemId the primary key for the new Shopping Order Item
	* @return the new Shopping Order Item
	*/
	public ShoppingOrderItem create(long itemId);

	/**
	* Removes the Shopping Order Item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item that was removed
	* @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	*/
	public ShoppingOrderItem remove(long itemId)
		throws NoSuchShoppingOrderItemException;

	public ShoppingOrderItem updateImpl(ShoppingOrderItem shoppingOrderItem);

	/**
	* Returns the Shopping Order Item with the primary key or throws a {@link NoSuchShoppingOrderItemException} if it could not be found.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item
	* @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	*/
	public ShoppingOrderItem findByPrimaryKey(long itemId)
		throws NoSuchShoppingOrderItemException;

	/**
	* Returns the Shopping Order Item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item, or <code>null</code> if a Shopping Order Item with the primary key could not be found
	*/
	public ShoppingOrderItem fetchByPrimaryKey(long itemId);

	@Override
	public java.util.Map<java.io.Serializable, ShoppingOrderItem> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the Shopping Order Items.
	*
	* @return the Shopping Order Items
	*/
	public java.util.List<ShoppingOrderItem> findAll();

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
	public java.util.List<ShoppingOrderItem> findAll(int start, int end);

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
	public java.util.List<ShoppingOrderItem> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator);

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
	public java.util.List<ShoppingOrderItem> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrderItem> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the Shopping Order Items from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of Shopping Order Items.
	*
	* @return the number of Shopping Order Items
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}