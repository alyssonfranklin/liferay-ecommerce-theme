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
 * Provides the local service utility for Notification. This utility wraps
 * {@link com.rivetlogic.ecommerce.service.impl.NotificationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author rivetlogic
 * @see NotificationLocalService
 * @see com.rivetlogic.ecommerce.service.base.NotificationLocalServiceBaseImpl
 * @see com.rivetlogic.ecommerce.service.impl.NotificationLocalServiceImpl
 * @generated
 */
@ProviderType
public class NotificationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rivetlogic.ecommerce.service.impl.NotificationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the notification to the database. Also notifies the appropriate model listeners.
	*
	* @param notification the notification
	* @return the notification that was added
	*/
	public static com.rivetlogic.ecommerce.model.Notification addNotification(
		com.rivetlogic.ecommerce.model.Notification notification) {
		return getService().addNotification(notification);
	}

	public static com.rivetlogic.ecommerce.model.Notification create(
		long orderId, java.lang.String recipients,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return getService().create(orderId, recipients, serviceContext);
	}

	/**
	* Creates a new notification with the primary key. Does not add the notification to the database.
	*
	* @param notificationId the primary key for the new notification
	* @return the new notification
	*/
	public static com.rivetlogic.ecommerce.model.Notification createNotification(
		long notificationId) {
		return getService().createNotification(notificationId);
	}

	/**
	* Deletes the notification from the database. Also notifies the appropriate model listeners.
	*
	* @param notification the notification
	* @return the notification that was removed
	*/
	public static com.rivetlogic.ecommerce.model.Notification deleteNotification(
		com.rivetlogic.ecommerce.model.Notification notification) {
		return getService().deleteNotification(notification);
	}

	/**
	* Deletes the notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationId the primary key of the notification
	* @return the notification that was removed
	* @throws PortalException if a notification with the primary key could not be found
	*/
	public static com.rivetlogic.ecommerce.model.Notification deleteNotification(
		long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteNotification(notificationId);
	}

	public static com.rivetlogic.ecommerce.model.Notification fetchNotification(
		long notificationId) {
		return getService().fetchNotification(notificationId);
	}

	/**
	* Returns the notification matching the UUID and group.
	*
	* @param uuid the notification's UUID
	* @param groupId the primary key of the group
	* @return the matching notification, or <code>null</code> if a matching notification could not be found
	*/
	public static com.rivetlogic.ecommerce.model.Notification fetchNotificationByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchNotificationByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the notification with the primary key.
	*
	* @param notificationId the primary key of the notification
	* @return the notification
	* @throws PortalException if a notification with the primary key could not be found
	*/
	public static com.rivetlogic.ecommerce.model.Notification getNotification(
		long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getNotification(notificationId);
	}

	/**
	* Returns the notification matching the UUID and group.
	*
	* @param uuid the notification's UUID
	* @param groupId the primary key of the group
	* @return the matching notification
	* @throws PortalException if a matching notification could not be found
	*/
	public static com.rivetlogic.ecommerce.model.Notification getNotificationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getNotificationByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the notification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param notification the notification
	* @return the notification that was updated
	*/
	public static com.rivetlogic.ecommerce.model.Notification updateNotification(
		com.rivetlogic.ecommerce.model.Notification notification) {
		return getService().updateNotification(notification);
	}

	/**
	* Returns the number of notifications.
	*
	* @return the number of notifications
	*/
	public static int getNotificationsCount() {
		return getService().getNotificationsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.rivetlogic.ecommerce.model.Notification> findByOrderId(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByOrderId(orderId);
	}

	/**
	* Returns a range of all the notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @return the range of notifications
	*/
	public static java.util.List<com.rivetlogic.ecommerce.model.Notification> getNotifications(
		int start, int end) {
		return getService().getNotifications(start, end);
	}

	/**
	* Returns all the notifications matching the UUID and company.
	*
	* @param uuid the UUID of the notifications
	* @param companyId the primary key of the company
	* @return the matching notifications, or an empty list if no matches were found
	*/
	public static java.util.List<com.rivetlogic.ecommerce.model.Notification> getNotificationsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getNotificationsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of notifications matching the UUID and company.
	*
	* @param uuid the UUID of the notifications
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching notifications, or an empty list if no matches were found
	*/
	public static java.util.List<com.rivetlogic.ecommerce.model.Notification> getNotificationsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.rivetlogic.ecommerce.model.Notification> orderByComparator) {
		return getService()
				   .getNotificationsByUuidAndCompanyId(uuid, companyId, start,
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

	public static void removeByOrderId(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeByOrderId(orderId);
	}

	public static void storeNotification(
		com.rivetlogic.ecommerce.model.Notification notification,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().storeNotification(notification, serviceContext);
	}

	public static NotificationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NotificationLocalService, NotificationLocalService> _serviceTracker =
		ServiceTrackerFactory.open(NotificationLocalService.class);
}