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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.rivetlogic.ecommerce.model.Notification;
import com.rivetlogic.ecommerce.service.base.NotificationLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the notification local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.rivetlogic.ecommerce.service.NotificationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author rivetlogic
 * @see NotificationLocalServiceBaseImpl
 * @see com.rivetlogic.ecommerce.service.NotificationLocalServiceUtil
 */
@ProviderType
public class NotificationLocalServiceImpl extends NotificationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.rivetlogic.ecommerce.service.NotificationLocalServiceUtil} to access
	 * the notification local service.
	 */

	public Notification create(long orderId, String recipients, ServiceContext serviceContext) {
		long notificationId = counterLocalService.increment(Notification.class.getName());
		Notification newNotification = createNotification(notificationId);
		newNotification.setOrderId(orderId);
		newNotification.setRecipients(recipients);

		setAuditFields(newNotification, serviceContext);

		newNotification = addNotification(newNotification);

		return newNotification;
	}

	private void setAuditFields(Notification notification, ServiceContext serviceContext) {
		Date now = new Date();
		if (notification.isNew()) {
			notification.setCreateDate(now);
		}
		notification.setModifiedDate(now);
		notification.setCompanyId(serviceContext.getCompanyId());
		notification.setUserId(serviceContext.getUserId());
	}

	public void storeNotification(Notification notification, ServiceContext serviceContext) throws SystemException {
		setAuditFields(notification, serviceContext);
		updateNotification(notification);
	}

	public void removeByOrderId(long orderId) throws SystemException {
		List<Notification> list = findByOrderId(orderId);
		for (Notification n : list) {
			deleteNotification(n);
		}
	}

	public List<Notification> findByOrderId(long orderId) throws SystemException {
		return notificationPersistence.findByOrderId(orderId);
	}
}