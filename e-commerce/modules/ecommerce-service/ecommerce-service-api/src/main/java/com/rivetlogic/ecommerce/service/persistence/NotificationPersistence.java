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

import com.rivetlogic.ecommerce.exception.NoSuchNotificationException;
import com.rivetlogic.ecommerce.model.Notification;

/**
 * The persistence interface for the notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rivetlogic
 * @see com.rivetlogic.ecommerce.service.persistence.impl.NotificationPersistenceImpl
 * @see NotificationUtil
 * @generated
 */
@ProviderType
public interface NotificationPersistence extends BasePersistence<Notification> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotificationUtil} to access the notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the notifications where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching notifications
	*/
	public java.util.List<Notification> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the notifications where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @return the range of matching notifications
	*/
	public java.util.List<Notification> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the notifications where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notifications
	*/
	public java.util.List<Notification> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator);

	/**
	* Returns an ordered range of all the notifications where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching notifications
	*/
	public java.util.List<Notification> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first notification in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification
	* @throws NoSuchNotificationException if a matching notification could not be found
	*/
	public Notification findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException;

	/**
	* Returns the first notification in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification, or <code>null</code> if a matching notification could not be found
	*/
	public Notification fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator);

	/**
	* Returns the last notification in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification
	* @throws NoSuchNotificationException if a matching notification could not be found
	*/
	public Notification findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException;

	/**
	* Returns the last notification in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification, or <code>null</code> if a matching notification could not be found
	*/
	public Notification fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator);

	/**
	* Returns the notifications before and after the current notification in the ordered set where uuid = &#63;.
	*
	* @param notificationId the primary key of the current notification
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notification
	* @throws NoSuchNotificationException if a notification with the primary key could not be found
	*/
	public Notification[] findByUuid_PrevAndNext(long notificationId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException;

	/**
	* Removes all the notifications where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of notifications where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching notifications
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the notification where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchNotificationException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching notification
	* @throws NoSuchNotificationException if a matching notification could not be found
	*/
	public Notification findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchNotificationException;

	/**
	* Returns the notification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching notification, or <code>null</code> if a matching notification could not be found
	*/
	public Notification fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the notification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching notification, or <code>null</code> if a matching notification could not be found
	*/
	public Notification fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the notification where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the notification that was removed
	*/
	public Notification removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchNotificationException;

	/**
	* Returns the number of notifications where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching notifications
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the notifications where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching notifications
	*/
	public java.util.List<Notification> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the notifications where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @return the range of matching notifications
	*/
	public java.util.List<Notification> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the notifications where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notifications
	*/
	public java.util.List<Notification> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator);

	/**
	* Returns an ordered range of all the notifications where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching notifications
	*/
	public java.util.List<Notification> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first notification in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification
	* @throws NoSuchNotificationException if a matching notification could not be found
	*/
	public Notification findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException;

	/**
	* Returns the first notification in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification, or <code>null</code> if a matching notification could not be found
	*/
	public Notification fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator);

	/**
	* Returns the last notification in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification
	* @throws NoSuchNotificationException if a matching notification could not be found
	*/
	public Notification findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException;

	/**
	* Returns the last notification in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification, or <code>null</code> if a matching notification could not be found
	*/
	public Notification fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator);

	/**
	* Returns the notifications before and after the current notification in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param notificationId the primary key of the current notification
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notification
	* @throws NoSuchNotificationException if a notification with the primary key could not be found
	*/
	public Notification[] findByUuid_C_PrevAndNext(long notificationId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException;

	/**
	* Removes all the notifications where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of notifications where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching notifications
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the notifications where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the matching notifications
	*/
	public java.util.List<Notification> findByOrderId(long orderId);

	/**
	* Returns a range of all the notifications where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orderId the order ID
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @return the range of matching notifications
	*/
	public java.util.List<Notification> findByOrderId(long orderId, int start,
		int end);

	/**
	* Returns an ordered range of all the notifications where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orderId the order ID
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notifications
	*/
	public java.util.List<Notification> findByOrderId(long orderId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator);

	/**
	* Returns an ordered range of all the notifications where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orderId the order ID
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching notifications
	*/
	public java.util.List<Notification> findByOrderId(long orderId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first notification in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification
	* @throws NoSuchNotificationException if a matching notification could not be found
	*/
	public Notification findByOrderId_First(long orderId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException;

	/**
	* Returns the first notification in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification, or <code>null</code> if a matching notification could not be found
	*/
	public Notification fetchByOrderId_First(long orderId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator);

	/**
	* Returns the last notification in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification
	* @throws NoSuchNotificationException if a matching notification could not be found
	*/
	public Notification findByOrderId_Last(long orderId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException;

	/**
	* Returns the last notification in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification, or <code>null</code> if a matching notification could not be found
	*/
	public Notification fetchByOrderId_Last(long orderId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator);

	/**
	* Returns the notifications before and after the current notification in the ordered set where orderId = &#63;.
	*
	* @param notificationId the primary key of the current notification
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notification
	* @throws NoSuchNotificationException if a notification with the primary key could not be found
	*/
	public Notification[] findByOrderId_PrevAndNext(long notificationId,
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException;

	/**
	* Removes all the notifications where orderId = &#63; from the database.
	*
	* @param orderId the order ID
	*/
	public void removeByOrderId(long orderId);

	/**
	* Returns the number of notifications where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the number of matching notifications
	*/
	public int countByOrderId(long orderId);

	/**
	* Caches the notification in the entity cache if it is enabled.
	*
	* @param notification the notification
	*/
	public void cacheResult(Notification notification);

	/**
	* Caches the notifications in the entity cache if it is enabled.
	*
	* @param notifications the notifications
	*/
	public void cacheResult(java.util.List<Notification> notifications);

	/**
	* Creates a new notification with the primary key. Does not add the notification to the database.
	*
	* @param notificationId the primary key for the new notification
	* @return the new notification
	*/
	public Notification create(long notificationId);

	/**
	* Removes the notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationId the primary key of the notification
	* @return the notification that was removed
	* @throws NoSuchNotificationException if a notification with the primary key could not be found
	*/
	public Notification remove(long notificationId)
		throws NoSuchNotificationException;

	public Notification updateImpl(Notification notification);

	/**
	* Returns the notification with the primary key or throws a {@link NoSuchNotificationException} if it could not be found.
	*
	* @param notificationId the primary key of the notification
	* @return the notification
	* @throws NoSuchNotificationException if a notification with the primary key could not be found
	*/
	public Notification findByPrimaryKey(long notificationId)
		throws NoSuchNotificationException;

	/**
	* Returns the notification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notificationId the primary key of the notification
	* @return the notification, or <code>null</code> if a notification with the primary key could not be found
	*/
	public Notification fetchByPrimaryKey(long notificationId);

	@Override
	public java.util.Map<java.io.Serializable, Notification> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the notifications.
	*
	* @return the notifications
	*/
	public java.util.List<Notification> findAll();

	/**
	* Returns a range of all the notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @return the range of notifications
	*/
	public java.util.List<Notification> findAll(int start, int end);

	/**
	* Returns an ordered range of all the notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of notifications
	*/
	public java.util.List<Notification> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator);

	/**
	* Returns an ordered range of all the notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of notifications
	*/
	public java.util.List<Notification> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notification> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the notifications from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of notifications.
	*
	* @return the number of notifications
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}