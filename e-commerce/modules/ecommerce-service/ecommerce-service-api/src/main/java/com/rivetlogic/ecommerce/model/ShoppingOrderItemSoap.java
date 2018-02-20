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
public class ShoppingOrderItemSoap implements Serializable {
	public static ShoppingOrderItemSoap toSoapModel(ShoppingOrderItem model) {
		ShoppingOrderItemSoap soapModel = new ShoppingOrderItemSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setItemId(model.getItemId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setOrderId(model.getOrderId());
		soapModel.setProductId(model.getProductId());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setPrice(model.getPrice());

		return soapModel;
	}

	public static ShoppingOrderItemSoap[] toSoapModels(
		ShoppingOrderItem[] models) {
		ShoppingOrderItemSoap[] soapModels = new ShoppingOrderItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ShoppingOrderItemSoap[][] toSoapModels(
		ShoppingOrderItem[][] models) {
		ShoppingOrderItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ShoppingOrderItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ShoppingOrderItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ShoppingOrderItemSoap[] toSoapModels(
		List<ShoppingOrderItem> models) {
		List<ShoppingOrderItemSoap> soapModels = new ArrayList<ShoppingOrderItemSoap>(models.size());

		for (ShoppingOrderItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ShoppingOrderItemSoap[soapModels.size()]);
	}

	public ShoppingOrderItemSoap() {
	}

	public long getPrimaryKey() {
		return _itemId;
	}

	public void setPrimaryKey(long pk) {
		setItemId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
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

	public long getOrderId() {
		return _orderId;
	}

	public void setOrderId(long orderId) {
		_orderId = orderId;
	}

	public String getProductId() {
		return _productId;
	}

	public void setProductId(String productId) {
		_productId = productId;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	private String _uuid;
	private long _itemId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _orderId;
	private String _productId;
	private int _quantity;
	private double _price;
}