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

import com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderException;
import com.rivetlogic.ecommerce.model.ShoppingOrder;

/**
 * The persistence interface for the Shopping Order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rivetlogic
 * @see com.rivetlogic.ecommerce.service.persistence.impl.ShoppingOrderPersistenceImpl
 * @see ShoppingOrderUtil
 * @generated
 */
@ProviderType
public interface ShoppingOrderPersistence extends BasePersistence<ShoppingOrder> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ShoppingOrderUtil} to access the Shopping Order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the Shopping Orders where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the Shopping Orders where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @return the range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the Shopping Orders where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns an ordered range of all the Shopping Orders where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first Shopping Order in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order
	* @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	*/
	public ShoppingOrder findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Returns the first Shopping Order in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	public ShoppingOrder fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns the last Shopping Order in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order
	* @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	*/
	public ShoppingOrder findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Returns the last Shopping Order in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	public ShoppingOrder fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns the Shopping Orders before and after the current Shopping Order in the ordered set where uuid = &#63;.
	*
	* @param orderId the primary key of the current Shopping Order
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Shopping Order
	* @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	*/
	public ShoppingOrder[] findByUuid_PrevAndNext(long orderId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Removes all the Shopping Orders where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of Shopping Orders where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching Shopping Orders
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the Shopping Order where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchShoppingOrderException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching Shopping Order
	* @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	*/
	public ShoppingOrder findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchShoppingOrderException;

	/**
	* Returns the Shopping Order where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	public ShoppingOrder fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the Shopping Order where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	public ShoppingOrder fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the Shopping Order where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the Shopping Order that was removed
	*/
	public ShoppingOrder removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchShoppingOrderException;

	/**
	* Returns the number of Shopping Orders where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching Shopping Orders
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the Shopping Orders where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the Shopping Orders where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @return the range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the Shopping Orders where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns an ordered range of all the Shopping Orders where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first Shopping Order in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order
	* @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	*/
	public ShoppingOrder findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Returns the first Shopping Order in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	public ShoppingOrder fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns the last Shopping Order in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order
	* @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	*/
	public ShoppingOrder findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Returns the last Shopping Order in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	public ShoppingOrder fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns the Shopping Orders before and after the current Shopping Order in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param orderId the primary key of the current Shopping Order
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Shopping Order
	* @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	*/
	public ShoppingOrder[] findByUuid_C_PrevAndNext(long orderId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Removes all the Shopping Orders where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of Shopping Orders where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching Shopping Orders
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the Shopping Orders where orderStatus = &#63; and userId = &#63;.
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @return the matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByOrderStatusAndUserId(
		java.lang.String orderStatus, long userId);

	/**
	* Returns a range of all the Shopping Orders where orderStatus = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @return the range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByOrderStatusAndUserId(
		java.lang.String orderStatus, long userId, int start, int end);

	/**
	* Returns an ordered range of all the Shopping Orders where orderStatus = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByOrderStatusAndUserId(
		java.lang.String orderStatus, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns an ordered range of all the Shopping Orders where orderStatus = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByOrderStatusAndUserId(
		java.lang.String orderStatus, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order
	* @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	*/
	public ShoppingOrder findByOrderStatusAndUserId_First(
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Returns the first Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	public ShoppingOrder fetchByOrderStatusAndUserId_First(
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns the last Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order
	* @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	*/
	public ShoppingOrder findByOrderStatusAndUserId_Last(
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Returns the last Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	public ShoppingOrder fetchByOrderStatusAndUserId_Last(
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns the Shopping Orders before and after the current Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	*
	* @param orderId the primary key of the current Shopping Order
	* @param orderStatus the order status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Shopping Order
	* @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	*/
	public ShoppingOrder[] findByOrderStatusAndUserId_PrevAndNext(
		long orderId, java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Removes all the Shopping Orders where orderStatus = &#63; and userId = &#63; from the database.
	*
	* @param orderStatus the order status
	* @param userId the user ID
	*/
	public void removeByOrderStatusAndUserId(java.lang.String orderStatus,
		long userId);

	/**
	* Returns the number of Shopping Orders where orderStatus = &#63; and userId = &#63;.
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @return the number of matching Shopping Orders
	*/
	public int countByOrderStatusAndUserId(java.lang.String orderStatus,
		long userId);

	/**
	* Returns all the Shopping Orders where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param userId the user ID
	* @return the matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByGroupOrderStatusAndUserId(
		long groupId, java.lang.String orderStatus, long userId);

	/**
	* Returns a range of all the Shopping Orders where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param userId the user ID
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @return the range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByGroupOrderStatusAndUserId(
		long groupId, java.lang.String orderStatus, long userId, int start,
		int end);

	/**
	* Returns an ordered range of all the Shopping Orders where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param userId the user ID
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByGroupOrderStatusAndUserId(
		long groupId, java.lang.String orderStatus, long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns an ordered range of all the Shopping Orders where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param userId the user ID
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByGroupOrderStatusAndUserId(
		long groupId, java.lang.String orderStatus, long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order
	* @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	*/
	public ShoppingOrder findByGroupOrderStatusAndUserId_First(long groupId,
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Returns the first Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	public ShoppingOrder fetchByGroupOrderStatusAndUserId_First(long groupId,
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns the last Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order
	* @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	*/
	public ShoppingOrder findByGroupOrderStatusAndUserId_Last(long groupId,
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Returns the last Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	public ShoppingOrder fetchByGroupOrderStatusAndUserId_Last(long groupId,
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns the Shopping Orders before and after the current Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	*
	* @param orderId the primary key of the current Shopping Order
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Shopping Order
	* @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	*/
	public ShoppingOrder[] findByGroupOrderStatusAndUserId_PrevAndNext(
		long orderId, long groupId, java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Removes all the Shopping Orders where groupId = &#63; and orderStatus = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param userId the user ID
	*/
	public void removeByGroupOrderStatusAndUserId(long groupId,
		java.lang.String orderStatus, long userId);

	/**
	* Returns the number of Shopping Orders where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param userId the user ID
	* @return the number of matching Shopping Orders
	*/
	public int countByGroupOrderStatusAndUserId(long groupId,
		java.lang.String orderStatus, long userId);

	/**
	* Returns all the Shopping Orders where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByGroupId(long groupId);

	/**
	* Returns a range of all the Shopping Orders where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @return the range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByGroupId(long groupId, int start,
		int end);

	/**
	* Returns an ordered range of all the Shopping Orders where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns an ordered range of all the Shopping Orders where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first Shopping Order in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order
	* @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	*/
	public ShoppingOrder findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Returns the first Shopping Order in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	public ShoppingOrder fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns the last Shopping Order in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order
	* @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	*/
	public ShoppingOrder findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Returns the last Shopping Order in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	public ShoppingOrder fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns the Shopping Orders before and after the current Shopping Order in the ordered set where groupId = &#63;.
	*
	* @param orderId the primary key of the current Shopping Order
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Shopping Order
	* @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	*/
	public ShoppingOrder[] findByGroupId_PrevAndNext(long orderId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Removes all the Shopping Orders where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of Shopping Orders where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching Shopping Orders
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the Shopping Orders where groupId = &#63; and orderStatus = &#63;.
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @return the matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByGroupIdAndOrderStatus(
		long groupId, java.lang.String orderStatus);

	/**
	* Returns a range of all the Shopping Orders where groupId = &#63; and orderStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @return the range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByGroupIdAndOrderStatus(
		long groupId, java.lang.String orderStatus, int start, int end);

	/**
	* Returns an ordered range of all the Shopping Orders where groupId = &#63; and orderStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByGroupIdAndOrderStatus(
		long groupId, java.lang.String orderStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns an ordered range of all the Shopping Orders where groupId = &#63; and orderStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findByGroupIdAndOrderStatus(
		long groupId, java.lang.String orderStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63;.
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order
	* @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	*/
	public ShoppingOrder findByGroupIdAndOrderStatus_First(long groupId,
		java.lang.String orderStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Returns the first Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63;.
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	public ShoppingOrder fetchByGroupIdAndOrderStatus_First(long groupId,
		java.lang.String orderStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns the last Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63;.
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order
	* @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	*/
	public ShoppingOrder findByGroupIdAndOrderStatus_Last(long groupId,
		java.lang.String orderStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Returns the last Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63;.
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	*/
	public ShoppingOrder fetchByGroupIdAndOrderStatus_Last(long groupId,
		java.lang.String orderStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns the Shopping Orders before and after the current Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63;.
	*
	* @param orderId the primary key of the current Shopping Order
	* @param groupId the group ID
	* @param orderStatus the order status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Shopping Order
	* @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	*/
	public ShoppingOrder[] findByGroupIdAndOrderStatus_PrevAndNext(
		long orderId, long groupId, java.lang.String orderStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException;

	/**
	* Removes all the Shopping Orders where groupId = &#63; and orderStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	*/
	public void removeByGroupIdAndOrderStatus(long groupId,
		java.lang.String orderStatus);

	/**
	* Returns the number of Shopping Orders where groupId = &#63; and orderStatus = &#63;.
	*
	* @param groupId the group ID
	* @param orderStatus the order status
	* @return the number of matching Shopping Orders
	*/
	public int countByGroupIdAndOrderStatus(long groupId,
		java.lang.String orderStatus);

	/**
	* Caches the Shopping Order in the entity cache if it is enabled.
	*
	* @param shoppingOrder the Shopping Order
	*/
	public void cacheResult(ShoppingOrder shoppingOrder);

	/**
	* Caches the Shopping Orders in the entity cache if it is enabled.
	*
	* @param shoppingOrders the Shopping Orders
	*/
	public void cacheResult(java.util.List<ShoppingOrder> shoppingOrders);

	/**
	* Creates a new Shopping Order with the primary key. Does not add the Shopping Order to the database.
	*
	* @param orderId the primary key for the new Shopping Order
	* @return the new Shopping Order
	*/
	public ShoppingOrder create(long orderId);

	/**
	* Removes the Shopping Order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderId the primary key of the Shopping Order
	* @return the Shopping Order that was removed
	* @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	*/
	public ShoppingOrder remove(long orderId)
		throws NoSuchShoppingOrderException;

	public ShoppingOrder updateImpl(ShoppingOrder shoppingOrder);

	/**
	* Returns the Shopping Order with the primary key or throws a {@link NoSuchShoppingOrderException} if it could not be found.
	*
	* @param orderId the primary key of the Shopping Order
	* @return the Shopping Order
	* @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	*/
	public ShoppingOrder findByPrimaryKey(long orderId)
		throws NoSuchShoppingOrderException;

	/**
	* Returns the Shopping Order with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orderId the primary key of the Shopping Order
	* @return the Shopping Order, or <code>null</code> if a Shopping Order with the primary key could not be found
	*/
	public ShoppingOrder fetchByPrimaryKey(long orderId);

	@Override
	public java.util.Map<java.io.Serializable, ShoppingOrder> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the Shopping Orders.
	*
	* @return the Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findAll();

	/**
	* Returns a range of all the Shopping Orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @return the range of Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findAll(int start, int end);

	/**
	* Returns an ordered range of all the Shopping Orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator);

	/**
	* Returns an ordered range of all the Shopping Orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Shopping Orders
	* @param end the upper bound of the range of Shopping Orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of Shopping Orders
	*/
	public java.util.List<ShoppingOrder> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShoppingOrder> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the Shopping Orders from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of Shopping Orders.
	*
	* @return the number of Shopping Orders
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}