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

package com.rivetlogic.ecommerce.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Notification}.
 * </p>
 *
 * @author rivetlogic
 * @see Notification
 * @generated
 */
@ProviderType
public class NotificationWrapper implements Notification,
	ModelWrapper<Notification> {
	public NotificationWrapper(Notification notification) {
		_notification = notification;
	}

	@Override
	public Class<?> getModelClass() {
		return Notification.class;
	}

	@Override
	public String getModelClassName() {
		return Notification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("notificationId", getNotificationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("orderId", getOrderId());
		attributes.put("subject", getSubject());
		attributes.put("body", getBody());
		attributes.put("sender", getSender());
		attributes.put("recipients", getRecipients());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long notificationId = (Long)attributes.get("notificationId");

		if (notificationId != null) {
			setNotificationId(notificationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long orderId = (Long)attributes.get("orderId");

		if (orderId != null) {
			setOrderId(orderId);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}

		String sender = (String)attributes.get("sender");

		if (sender != null) {
			setSender(sender);
		}

		String recipients = (String)attributes.get("recipients");

		if (recipients != null) {
			setRecipients(recipients);
		}
	}

	@Override
	public Notification toEscapedModel() {
		return new NotificationWrapper(_notification.toEscapedModel());
	}

	@Override
	public Notification toUnescapedModel() {
		return new NotificationWrapper(_notification.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _notification.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _notification.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _notification.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _notification.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Notification> toCacheModel() {
		return _notification.toCacheModel();
	}

	@Override
	public int compareTo(Notification notification) {
		return _notification.compareTo(notification);
	}

	@Override
	public int hashCode() {
		return _notification.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _notification.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new NotificationWrapper((Notification)_notification.clone());
	}

	/**
	* Returns the body of this notification.
	*
	* @return the body of this notification
	*/
	@Override
	public java.lang.String getBody() {
		return _notification.getBody();
	}

	/**
	* Returns the recipients of this notification.
	*
	* @return the recipients of this notification
	*/
	@Override
	public java.lang.String getRecipients() {
		return _notification.getRecipients();
	}

	/**
	* Returns the sender of this notification.
	*
	* @return the sender of this notification
	*/
	@Override
	public java.lang.String getSender() {
		return _notification.getSender();
	}

	/**
	* Returns the subject of this notification.
	*
	* @return the subject of this notification
	*/
	@Override
	public java.lang.String getSubject() {
		return _notification.getSubject();
	}

	/**
	* Returns the user uuid of this notification.
	*
	* @return the user uuid of this notification
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _notification.getUserUuid();
	}

	/**
	* Returns the uuid of this notification.
	*
	* @return the uuid of this notification
	*/
	@Override
	public java.lang.String getUuid() {
		return _notification.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _notification.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _notification.toXmlString();
	}

	/**
	* Returns the create date of this notification.
	*
	* @return the create date of this notification
	*/
	@Override
	public Date getCreateDate() {
		return _notification.getCreateDate();
	}

	/**
	* Returns the modified date of this notification.
	*
	* @return the modified date of this notification
	*/
	@Override
	public Date getModifiedDate() {
		return _notification.getModifiedDate();
	}

	/**
	* Returns the company ID of this notification.
	*
	* @return the company ID of this notification
	*/
	@Override
	public long getCompanyId() {
		return _notification.getCompanyId();
	}

	/**
	* Returns the group ID of this notification.
	*
	* @return the group ID of this notification
	*/
	@Override
	public long getGroupId() {
		return _notification.getGroupId();
	}

	/**
	* Returns the notification ID of this notification.
	*
	* @return the notification ID of this notification
	*/
	@Override
	public long getNotificationId() {
		return _notification.getNotificationId();
	}

	/**
	* Returns the order ID of this notification.
	*
	* @return the order ID of this notification
	*/
	@Override
	public long getOrderId() {
		return _notification.getOrderId();
	}

	/**
	* Returns the primary key of this notification.
	*
	* @return the primary key of this notification
	*/
	@Override
	public long getPrimaryKey() {
		return _notification.getPrimaryKey();
	}

	/**
	* Returns the user ID of this notification.
	*
	* @return the user ID of this notification
	*/
	@Override
	public long getUserId() {
		return _notification.getUserId();
	}

	@Override
	public void persist() {
		_notification.persist();
	}

	/**
	* Sets the body of this notification.
	*
	* @param body the body of this notification
	*/
	@Override
	public void setBody(java.lang.String body) {
		_notification.setBody(body);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_notification.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this notification.
	*
	* @param companyId the company ID of this notification
	*/
	@Override
	public void setCompanyId(long companyId) {
		_notification.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this notification.
	*
	* @param createDate the create date of this notification
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_notification.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_notification.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_notification.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_notification.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this notification.
	*
	* @param groupId the group ID of this notification
	*/
	@Override
	public void setGroupId(long groupId) {
		_notification.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this notification.
	*
	* @param modifiedDate the modified date of this notification
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_notification.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_notification.setNew(n);
	}

	/**
	* Sets the notification ID of this notification.
	*
	* @param notificationId the notification ID of this notification
	*/
	@Override
	public void setNotificationId(long notificationId) {
		_notification.setNotificationId(notificationId);
	}

	/**
	* Sets the order ID of this notification.
	*
	* @param orderId the order ID of this notification
	*/
	@Override
	public void setOrderId(long orderId) {
		_notification.setOrderId(orderId);
	}

	/**
	* Sets the primary key of this notification.
	*
	* @param primaryKey the primary key of this notification
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_notification.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_notification.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the recipients of this notification.
	*
	* @param recipients the recipients of this notification
	*/
	@Override
	public void setRecipients(java.lang.String recipients) {
		_notification.setRecipients(recipients);
	}

	/**
	* Sets the sender of this notification.
	*
	* @param sender the sender of this notification
	*/
	@Override
	public void setSender(java.lang.String sender) {
		_notification.setSender(sender);
	}

	/**
	* Sets the subject of this notification.
	*
	* @param subject the subject of this notification
	*/
	@Override
	public void setSubject(java.lang.String subject) {
		_notification.setSubject(subject);
	}

	/**
	* Sets the user ID of this notification.
	*
	* @param userId the user ID of this notification
	*/
	@Override
	public void setUserId(long userId) {
		_notification.setUserId(userId);
	}

	/**
	* Sets the user uuid of this notification.
	*
	* @param userUuid the user uuid of this notification
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_notification.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this notification.
	*
	* @param uuid the uuid of this notification
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_notification.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificationWrapper)) {
			return false;
		}

		NotificationWrapper notificationWrapper = (NotificationWrapper)obj;

		if (Objects.equals(_notification, notificationWrapper._notification)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _notification.getStagedModelType();
	}

	@Override
	public Notification getWrappedModel() {
		return _notification;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _notification.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _notification.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_notification.resetOriginalValues();
	}

	private final Notification _notification;
}