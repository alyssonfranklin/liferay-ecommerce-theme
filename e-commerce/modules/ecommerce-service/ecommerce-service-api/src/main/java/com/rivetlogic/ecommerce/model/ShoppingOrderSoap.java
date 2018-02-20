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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author rivetlogic
 * @generated
 */
@ProviderType
public class ShoppingOrderSoap implements Serializable {
	public static ShoppingOrderSoap toSoapModel(ShoppingOrder model) {
		ShoppingOrderSoap soapModel = new ShoppingOrderSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setOrderId(model.getOrderId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setOrderStatus(model.getOrderStatus());
		soapModel.setCustomerEmail(model.getCustomerEmail());
		soapModel.setCustomerName(model.getCustomerName());
		soapModel.setCustomerPhone(model.getCustomerPhone());
		soapModel.setShippingAddress1(model.getShippingAddress1());
		soapModel.setShippingAddress2(model.getShippingAddress2());
		soapModel.setShippingCity(model.getShippingCity());
		soapModel.setShippingPostalCode(model.getShippingPostalCode());
		soapModel.setShippingStateProvince(model.getShippingStateProvince());
		soapModel.setShippingCountry(model.getShippingCountry());
		soapModel.setTotal(model.getTotal());
		soapModel.setNotes(model.getNotes());

		return soapModel;
	}

	public static ShoppingOrderSoap[] toSoapModels(ShoppingOrder[] models) {
		ShoppingOrderSoap[] soapModels = new ShoppingOrderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ShoppingOrderSoap[][] toSoapModels(ShoppingOrder[][] models) {
		ShoppingOrderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ShoppingOrderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ShoppingOrderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ShoppingOrderSoap[] toSoapModels(List<ShoppingOrder> models) {
		List<ShoppingOrderSoap> soapModels = new ArrayList<ShoppingOrderSoap>(models.size());

		for (ShoppingOrder model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ShoppingOrderSoap[soapModels.size()]);
	}

	public ShoppingOrderSoap() {
	}

	public long getPrimaryKey() {
		return _orderId;
	}

	public void setPrimaryKey(long pk) {
		setOrderId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getOrderId() {
		return _orderId;
	}

	public void setOrderId(long orderId) {
		_orderId = orderId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getOrderStatus() {
		return _orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		_orderStatus = orderStatus;
	}

	public String getCustomerEmail() {
		return _customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		_customerEmail = customerEmail;
	}

	public String getCustomerName() {
		return _customerName;
	}

	public void setCustomerName(String customerName) {
		_customerName = customerName;
	}

	public String getCustomerPhone() {
		return _customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		_customerPhone = customerPhone;
	}

	public String getShippingAddress1() {
		return _shippingAddress1;
	}

	public void setShippingAddress1(String shippingAddress1) {
		_shippingAddress1 = shippingAddress1;
	}

	public String getShippingAddress2() {
		return _shippingAddress2;
	}

	public void setShippingAddress2(String shippingAddress2) {
		_shippingAddress2 = shippingAddress2;
	}

	public String getShippingCity() {
		return _shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		_shippingCity = shippingCity;
	}

	public String getShippingPostalCode() {
		return _shippingPostalCode;
	}

	public void setShippingPostalCode(String shippingPostalCode) {
		_shippingPostalCode = shippingPostalCode;
	}

	public String getShippingStateProvince() {
		return _shippingStateProvince;
	}

	public void setShippingStateProvince(String shippingStateProvince) {
		_shippingStateProvince = shippingStateProvince;
	}

	public String getShippingCountry() {
		return _shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		_shippingCountry = shippingCountry;
	}

	public double getTotal() {
		return _total;
	}

	public void setTotal(double total) {
		_total = total;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
	}

	private String _uuid;
	private long _orderId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _orderStatus;
	private String _customerEmail;
	private String _customerName;
	private String _customerPhone;
	private String _shippingAddress1;
	private String _shippingAddress2;
	private String _shippingCity;
	private String _shippingPostalCode;
	private String _shippingStateProvince;
	private String _shippingCountry;
	private double _total;
	private String _notes;
}