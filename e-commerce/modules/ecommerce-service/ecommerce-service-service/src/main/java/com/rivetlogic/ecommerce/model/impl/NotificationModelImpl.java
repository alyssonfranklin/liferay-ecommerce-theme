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

package com.rivetlogic.ecommerce.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.rivetlogic.ecommerce.model.Notification;
import com.rivetlogic.ecommerce.model.NotificationModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Notification service. Represents a row in the &quot;rivetlogic_ecommerce_Notification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link NotificationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NotificationImpl}.
 * </p>
 *
 * @author rivetlogic
 * @see NotificationImpl
 * @see Notification
 * @see NotificationModel
 * @generated
 */
@ProviderType
public class NotificationModelImpl extends BaseModelImpl<Notification>
	implements NotificationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a notification model instance should use the {@link Notification} interface instead.
	 */
	public static final String TABLE_NAME = "rivetlogic_ecommerce_Notification";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "notificationId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "orderId", Types.BIGINT },
			{ "subject", Types.VARCHAR },
			{ "body", Types.CLOB },
			{ "sender", Types.VARCHAR },
			{ "recipients", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("notificationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("orderId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("subject", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("body", Types.CLOB);
		TABLE_COLUMNS_MAP.put("sender", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("recipients", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table rivetlogic_ecommerce_Notification (uuid_ VARCHAR(75) null,notificationId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,orderId LONG,subject VARCHAR(75) null,body TEXT null,sender VARCHAR(75) null,recipients VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table rivetlogic_ecommerce_Notification";
	public static final String ORDER_BY_JPQL = " ORDER BY notification.notificationId DESC";
	public static final String ORDER_BY_SQL = " ORDER BY rivetlogic_ecommerce_Notification.notificationId DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.rivetlogic.ecommerce.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rivetlogic.ecommerce.model.Notification"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.rivetlogic.ecommerce.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rivetlogic.ecommerce.model.Notification"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.rivetlogic.ecommerce.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rivetlogic.ecommerce.model.Notification"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long ORDERID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long NOTIFICATIONID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.rivetlogic.ecommerce.service.util.ServiceProps.get(
				"lock.expiration.time.com.rivetlogic.ecommerce.model.Notification"));

	public NotificationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _notificationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNotificationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _notificationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getNotificationId() {
		return _notificationId;
	}

	@Override
	public void setNotificationId(long notificationId) {
		_columnBitmask = -1L;

		_notificationId = notificationId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getOrderId() {
		return _orderId;
	}

	@Override
	public void setOrderId(long orderId) {
		_columnBitmask |= ORDERID_COLUMN_BITMASK;

		if (!_setOriginalOrderId) {
			_setOriginalOrderId = true;

			_originalOrderId = _orderId;
		}

		_orderId = orderId;
	}

	public long getOriginalOrderId() {
		return _originalOrderId;
	}

	@Override
	public String getSubject() {
		if (_subject == null) {
			return StringPool.BLANK;
		}
		else {
			return _subject;
		}
	}

	@Override
	public void setSubject(String subject) {
		_subject = subject;
	}

	@Override
	public String getBody() {
		if (_body == null) {
			return StringPool.BLANK;
		}
		else {
			return _body;
		}
	}

	@Override
	public void setBody(String body) {
		_body = body;
	}

	@Override
	public String getSender() {
		if (_sender == null) {
			return StringPool.BLANK;
		}
		else {
			return _sender;
		}
	}

	@Override
	public void setSender(String sender) {
		_sender = sender;
	}

	@Override
	public String getRecipients() {
		if (_recipients == null) {
			return StringPool.BLANK;
		}
		else {
			return _recipients;
		}
	}

	@Override
	public void setRecipients(String recipients) {
		_recipients = recipients;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Notification.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Notification.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Notification toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Notification)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		NotificationImpl notificationImpl = new NotificationImpl();

		notificationImpl.setUuid(getUuid());
		notificationImpl.setNotificationId(getNotificationId());
		notificationImpl.setGroupId(getGroupId());
		notificationImpl.setCompanyId(getCompanyId());
		notificationImpl.setUserId(getUserId());
		notificationImpl.setCreateDate(getCreateDate());
		notificationImpl.setModifiedDate(getModifiedDate());
		notificationImpl.setOrderId(getOrderId());
		notificationImpl.setSubject(getSubject());
		notificationImpl.setBody(getBody());
		notificationImpl.setSender(getSender());
		notificationImpl.setRecipients(getRecipients());

		notificationImpl.resetOriginalValues();

		return notificationImpl;
	}

	@Override
	public int compareTo(Notification notification) {
		int value = 0;

		if (getNotificationId() < notification.getNotificationId()) {
			value = -1;
		}
		else if (getNotificationId() > notification.getNotificationId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Notification)) {
			return false;
		}

		Notification notification = (Notification)obj;

		long primaryKey = notification.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		NotificationModelImpl notificationModelImpl = this;

		notificationModelImpl._originalUuid = notificationModelImpl._uuid;

		notificationModelImpl._originalGroupId = notificationModelImpl._groupId;

		notificationModelImpl._setOriginalGroupId = false;

		notificationModelImpl._originalCompanyId = notificationModelImpl._companyId;

		notificationModelImpl._setOriginalCompanyId = false;

		notificationModelImpl._setModifiedDate = false;

		notificationModelImpl._originalOrderId = notificationModelImpl._orderId;

		notificationModelImpl._setOriginalOrderId = false;

		notificationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Notification> toCacheModel() {
		NotificationCacheModel notificationCacheModel = new NotificationCacheModel();

		notificationCacheModel.uuid = getUuid();

		String uuid = notificationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			notificationCacheModel.uuid = null;
		}

		notificationCacheModel.notificationId = getNotificationId();

		notificationCacheModel.groupId = getGroupId();

		notificationCacheModel.companyId = getCompanyId();

		notificationCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			notificationCacheModel.createDate = createDate.getTime();
		}
		else {
			notificationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			notificationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			notificationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		notificationCacheModel.orderId = getOrderId();

		notificationCacheModel.subject = getSubject();

		String subject = notificationCacheModel.subject;

		if ((subject != null) && (subject.length() == 0)) {
			notificationCacheModel.subject = null;
		}

		notificationCacheModel.body = getBody();

		String body = notificationCacheModel.body;

		if ((body != null) && (body.length() == 0)) {
			notificationCacheModel.body = null;
		}

		notificationCacheModel.sender = getSender();

		String sender = notificationCacheModel.sender;

		if ((sender != null) && (sender.length() == 0)) {
			notificationCacheModel.sender = null;
		}

		notificationCacheModel.recipients = getRecipients();

		String recipients = notificationCacheModel.recipients;

		if ((recipients != null) && (recipients.length() == 0)) {
			notificationCacheModel.recipients = null;
		}

		return notificationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", notificationId=");
		sb.append(getNotificationId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", orderId=");
		sb.append(getOrderId());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", body=");
		sb.append(getBody());
		sb.append(", sender=");
		sb.append(getSender());
		sb.append(", recipients=");
		sb.append(getRecipients());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.ecommerce.model.Notification");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notificationId</column-name><column-value><![CDATA[");
		sb.append(getNotificationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderId</column-name><column-value><![CDATA[");
		sb.append(getOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>body</column-name><column-value><![CDATA[");
		sb.append(getBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sender</column-name><column-value><![CDATA[");
		sb.append(getSender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recipients</column-name><column-value><![CDATA[");
		sb.append(getRecipients());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Notification.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Notification.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _notificationId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _orderId;
	private long _originalOrderId;
	private boolean _setOriginalOrderId;
	private String _subject;
	private String _body;
	private String _sender;
	private String _recipients;
	private long _columnBitmask;
	private Notification _escapedModel;
}