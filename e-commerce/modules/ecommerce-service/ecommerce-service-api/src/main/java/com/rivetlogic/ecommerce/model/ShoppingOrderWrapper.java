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
 * This class is a wrapper for {@link ShoppingOrder}.
 * </p>
 *
 * @author rivetlogic
 * @see ShoppingOrder
 * @generated
 */
@ProviderType
public class ShoppingOrderWrapper implements ShoppingOrder,
	ModelWrapper<ShoppingOrder> {
	public ShoppingOrderWrapper(ShoppingOrder shoppingOrder) {
		_shoppingOrder = shoppingOrder;
	}

	@Override
	public Class<?> getModelClass() {
		return ShoppingOrder.class;
	}

	@Override
	public String getModelClassName() {
		return ShoppingOrder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("orderId", getOrderId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("orderStatus", getOrderStatus());
		attributes.put("customerEmail", getCustomerEmail());
		attributes.put("customerName", getCustomerName());
		attributes.put("customerPhone", getCustomerPhone());
		attributes.put("shippingAddress1", getShippingAddress1());
		attributes.put("shippingAddress2", getShippingAddress2());
		attributes.put("shippingCity", getShippingCity());
		attributes.put("shippingPostalCode", getShippingPostalCode());
		attributes.put("shippingStateProvince", getShippingStateProvince());
		attributes.put("shippingCountry", getShippingCountry());
		attributes.put("total", getTotal());
		attributes.put("notes", getNotes());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long orderId = (Long)attributes.get("orderId");

		if (orderId != null) {
			setOrderId(orderId);
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

		String orderStatus = (String)attributes.get("orderStatus");

		if (orderStatus != null) {
			setOrderStatus(orderStatus);
		}

		String customerEmail = (String)attributes.get("customerEmail");

		if (customerEmail != null) {
			setCustomerEmail(customerEmail);
		}

		String customerName = (String)attributes.get("customerName");

		if (customerName != null) {
			setCustomerName(customerName);
		}

		String customerPhone = (String)attributes.get("customerPhone");

		if (customerPhone != null) {
			setCustomerPhone(customerPhone);
		}

		String shippingAddress1 = (String)attributes.get("shippingAddress1");

		if (shippingAddress1 != null) {
			setShippingAddress1(shippingAddress1);
		}

		String shippingAddress2 = (String)attributes.get("shippingAddress2");

		if (shippingAddress2 != null) {
			setShippingAddress2(shippingAddress2);
		}

		String shippingCity = (String)attributes.get("shippingCity");

		if (shippingCity != null) {
			setShippingCity(shippingCity);
		}

		String shippingPostalCode = (String)attributes.get("shippingPostalCode");

		if (shippingPostalCode != null) {
			setShippingPostalCode(shippingPostalCode);
		}

		String shippingStateProvince = (String)attributes.get(
				"shippingStateProvince");

		if (shippingStateProvince != null) {
			setShippingStateProvince(shippingStateProvince);
		}

		String shippingCountry = (String)attributes.get("shippingCountry");

		if (shippingCountry != null) {
			setShippingCountry(shippingCountry);
		}

		Double total = (Double)attributes.get("total");

		if (total != null) {
			setTotal(total);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}
	}

	@Override
	public ShoppingOrder toEscapedModel() {
		return new ShoppingOrderWrapper(_shoppingOrder.toEscapedModel());
	}

	@Override
	public ShoppingOrder toUnescapedModel() {
		return new ShoppingOrderWrapper(_shoppingOrder.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _shoppingOrder.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _shoppingOrder.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _shoppingOrder.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _shoppingOrder.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ShoppingOrder> toCacheModel() {
		return _shoppingOrder.toCacheModel();
	}

	/**
	* Returns the total of this Shopping Order.
	*
	* @return the total of this Shopping Order
	*/
	@Override
	public double getTotal() {
		return _shoppingOrder.getTotal();
	}

	@Override
	public int compareTo(ShoppingOrder shoppingOrder) {
		return _shoppingOrder.compareTo(shoppingOrder);
	}

	@Override
	public int hashCode() {
		return _shoppingOrder.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _shoppingOrder.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ShoppingOrderWrapper((ShoppingOrder)_shoppingOrder.clone());
	}

	/**
	* Returns the customer email of this Shopping Order.
	*
	* @return the customer email of this Shopping Order
	*/
	@Override
	public java.lang.String getCustomerEmail() {
		return _shoppingOrder.getCustomerEmail();
	}

	/**
	* Returns the customer name of this Shopping Order.
	*
	* @return the customer name of this Shopping Order
	*/
	@Override
	public java.lang.String getCustomerName() {
		return _shoppingOrder.getCustomerName();
	}

	/**
	* Returns the customer phone of this Shopping Order.
	*
	* @return the customer phone of this Shopping Order
	*/
	@Override
	public java.lang.String getCustomerPhone() {
		return _shoppingOrder.getCustomerPhone();
	}

	/**
	* Returns the notes of this Shopping Order.
	*
	* @return the notes of this Shopping Order
	*/
	@Override
	public java.lang.String getNotes() {
		return _shoppingOrder.getNotes();
	}

	/**
	* Returns the order status of this Shopping Order.
	*
	* @return the order status of this Shopping Order
	*/
	@Override
	public java.lang.String getOrderStatus() {
		return _shoppingOrder.getOrderStatus();
	}

	/**
	* Returns the shipping address1 of this Shopping Order.
	*
	* @return the shipping address1 of this Shopping Order
	*/
	@Override
	public java.lang.String getShippingAddress1() {
		return _shoppingOrder.getShippingAddress1();
	}

	/**
	* Returns the shipping address2 of this Shopping Order.
	*
	* @return the shipping address2 of this Shopping Order
	*/
	@Override
	public java.lang.String getShippingAddress2() {
		return _shoppingOrder.getShippingAddress2();
	}

	/**
	* Returns the shipping city of this Shopping Order.
	*
	* @return the shipping city of this Shopping Order
	*/
	@Override
	public java.lang.String getShippingCity() {
		return _shoppingOrder.getShippingCity();
	}

	/**
	* Returns the shipping country of this Shopping Order.
	*
	* @return the shipping country of this Shopping Order
	*/
	@Override
	public java.lang.String getShippingCountry() {
		return _shoppingOrder.getShippingCountry();
	}

	/**
	* Returns the shipping postal code of this Shopping Order.
	*
	* @return the shipping postal code of this Shopping Order
	*/
	@Override
	public java.lang.String getShippingPostalCode() {
		return _shoppingOrder.getShippingPostalCode();
	}

	/**
	* Returns the shipping state province of this Shopping Order.
	*
	* @return the shipping state province of this Shopping Order
	*/
	@Override
	public java.lang.String getShippingStateProvince() {
		return _shoppingOrder.getShippingStateProvince();
	}

	/**
	* Returns the user uuid of this Shopping Order.
	*
	* @return the user uuid of this Shopping Order
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _shoppingOrder.getUserUuid();
	}

	/**
	* Returns the uuid of this Shopping Order.
	*
	* @return the uuid of this Shopping Order
	*/
	@Override
	public java.lang.String getUuid() {
		return _shoppingOrder.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _shoppingOrder.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _shoppingOrder.toXmlString();
	}

	/**
	* Returns the create date of this Shopping Order.
	*
	* @return the create date of this Shopping Order
	*/
	@Override
	public Date getCreateDate() {
		return _shoppingOrder.getCreateDate();
	}

	/**
	* Returns the modified date of this Shopping Order.
	*
	* @return the modified date of this Shopping Order
	*/
	@Override
	public Date getModifiedDate() {
		return _shoppingOrder.getModifiedDate();
	}

	/**
	* Returns the company ID of this Shopping Order.
	*
	* @return the company ID of this Shopping Order
	*/
	@Override
	public long getCompanyId() {
		return _shoppingOrder.getCompanyId();
	}

	/**
	* Returns the group ID of this Shopping Order.
	*
	* @return the group ID of this Shopping Order
	*/
	@Override
	public long getGroupId() {
		return _shoppingOrder.getGroupId();
	}

	/**
	* Returns the order ID of this Shopping Order.
	*
	* @return the order ID of this Shopping Order
	*/
	@Override
	public long getOrderId() {
		return _shoppingOrder.getOrderId();
	}

	/**
	* Returns the primary key of this Shopping Order.
	*
	* @return the primary key of this Shopping Order
	*/
	@Override
	public long getPrimaryKey() {
		return _shoppingOrder.getPrimaryKey();
	}

	/**
	* Returns the user ID of this Shopping Order.
	*
	* @return the user ID of this Shopping Order
	*/
	@Override
	public long getUserId() {
		return _shoppingOrder.getUserId();
	}

	@Override
	public void persist() {
		_shoppingOrder.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_shoppingOrder.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this Shopping Order.
	*
	* @param companyId the company ID of this Shopping Order
	*/
	@Override
	public void setCompanyId(long companyId) {
		_shoppingOrder.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this Shopping Order.
	*
	* @param createDate the create date of this Shopping Order
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_shoppingOrder.setCreateDate(createDate);
	}

	/**
	* Sets the customer email of this Shopping Order.
	*
	* @param customerEmail the customer email of this Shopping Order
	*/
	@Override
	public void setCustomerEmail(java.lang.String customerEmail) {
		_shoppingOrder.setCustomerEmail(customerEmail);
	}

	/**
	* Sets the customer name of this Shopping Order.
	*
	* @param customerName the customer name of this Shopping Order
	*/
	@Override
	public void setCustomerName(java.lang.String customerName) {
		_shoppingOrder.setCustomerName(customerName);
	}

	/**
	* Sets the customer phone of this Shopping Order.
	*
	* @param customerPhone the customer phone of this Shopping Order
	*/
	@Override
	public void setCustomerPhone(java.lang.String customerPhone) {
		_shoppingOrder.setCustomerPhone(customerPhone);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_shoppingOrder.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_shoppingOrder.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_shoppingOrder.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this Shopping Order.
	*
	* @param groupId the group ID of this Shopping Order
	*/
	@Override
	public void setGroupId(long groupId) {
		_shoppingOrder.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this Shopping Order.
	*
	* @param modifiedDate the modified date of this Shopping Order
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_shoppingOrder.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_shoppingOrder.setNew(n);
	}

	/**
	* Sets the notes of this Shopping Order.
	*
	* @param notes the notes of this Shopping Order
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_shoppingOrder.setNotes(notes);
	}

	/**
	* Sets the order ID of this Shopping Order.
	*
	* @param orderId the order ID of this Shopping Order
	*/
	@Override
	public void setOrderId(long orderId) {
		_shoppingOrder.setOrderId(orderId);
	}

	/**
	* Sets the order status of this Shopping Order.
	*
	* @param orderStatus the order status of this Shopping Order
	*/
	@Override
	public void setOrderStatus(java.lang.String orderStatus) {
		_shoppingOrder.setOrderStatus(orderStatus);
	}

	/**
	* Sets the primary key of this Shopping Order.
	*
	* @param primaryKey the primary key of this Shopping Order
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_shoppingOrder.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_shoppingOrder.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the shipping address1 of this Shopping Order.
	*
	* @param shippingAddress1 the shipping address1 of this Shopping Order
	*/
	@Override
	public void setShippingAddress1(java.lang.String shippingAddress1) {
		_shoppingOrder.setShippingAddress1(shippingAddress1);
	}

	/**
	* Sets the shipping address2 of this Shopping Order.
	*
	* @param shippingAddress2 the shipping address2 of this Shopping Order
	*/
	@Override
	public void setShippingAddress2(java.lang.String shippingAddress2) {
		_shoppingOrder.setShippingAddress2(shippingAddress2);
	}

	/**
	* Sets the shipping city of this Shopping Order.
	*
	* @param shippingCity the shipping city of this Shopping Order
	*/
	@Override
	public void setShippingCity(java.lang.String shippingCity) {
		_shoppingOrder.setShippingCity(shippingCity);
	}

	/**
	* Sets the shipping country of this Shopping Order.
	*
	* @param shippingCountry the shipping country of this Shopping Order
	*/
	@Override
	public void setShippingCountry(java.lang.String shippingCountry) {
		_shoppingOrder.setShippingCountry(shippingCountry);
	}

	/**
	* Sets the shipping postal code of this Shopping Order.
	*
	* @param shippingPostalCode the shipping postal code of this Shopping Order
	*/
	@Override
	public void setShippingPostalCode(java.lang.String shippingPostalCode) {
		_shoppingOrder.setShippingPostalCode(shippingPostalCode);
	}

	/**
	* Sets the shipping state province of this Shopping Order.
	*
	* @param shippingStateProvince the shipping state province of this Shopping Order
	*/
	@Override
	public void setShippingStateProvince(java.lang.String shippingStateProvince) {
		_shoppingOrder.setShippingStateProvince(shippingStateProvince);
	}

	/**
	* Sets the total of this Shopping Order.
	*
	* @param total the total of this Shopping Order
	*/
	@Override
	public void setTotal(double total) {
		_shoppingOrder.setTotal(total);
	}

	/**
	* Sets the user ID of this Shopping Order.
	*
	* @param userId the user ID of this Shopping Order
	*/
	@Override
	public void setUserId(long userId) {
		_shoppingOrder.setUserId(userId);
	}

	/**
	* Sets the user uuid of this Shopping Order.
	*
	* @param userUuid the user uuid of this Shopping Order
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_shoppingOrder.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this Shopping Order.
	*
	* @param uuid the uuid of this Shopping Order
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_shoppingOrder.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShoppingOrderWrapper)) {
			return false;
		}

		ShoppingOrderWrapper shoppingOrderWrapper = (ShoppingOrderWrapper)obj;

		if (Objects.equals(_shoppingOrder, shoppingOrderWrapper._shoppingOrder)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _shoppingOrder.getStagedModelType();
	}

	@Override
	public ShoppingOrder getWrappedModel() {
		return _shoppingOrder;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _shoppingOrder.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _shoppingOrder.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_shoppingOrder.resetOriginalValues();
	}

	private final ShoppingOrder _shoppingOrder;
}