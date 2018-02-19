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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.rivetlogic.ecommerce.model.ShoppingOrder;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ShoppingOrder in entity cache.
 *
 * @author rivetlogic
 * @see ShoppingOrder
 * @generated
 */
@ProviderType
public class ShoppingOrderCacheModel implements CacheModel<ShoppingOrder>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShoppingOrderCacheModel)) {
			return false;
		}

		ShoppingOrderCacheModel shoppingOrderCacheModel = (ShoppingOrderCacheModel)obj;

		if (orderId == shoppingOrderCacheModel.orderId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, orderId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", orderId=");
		sb.append(orderId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", orderStatus=");
		sb.append(orderStatus);
		sb.append(", customerEmail=");
		sb.append(customerEmail);
		sb.append(", customerName=");
		sb.append(customerName);
		sb.append(", customerPhone=");
		sb.append(customerPhone);
		sb.append(", shippingAddress1=");
		sb.append(shippingAddress1);
		sb.append(", shippingAddress2=");
		sb.append(shippingAddress2);
		sb.append(", shippingCity=");
		sb.append(shippingCity);
		sb.append(", shippingPostalCode=");
		sb.append(shippingPostalCode);
		sb.append(", shippingStateProvince=");
		sb.append(shippingStateProvince);
		sb.append(", shippingCountry=");
		sb.append(shippingCountry);
		sb.append(", total=");
		sb.append(total);
		sb.append(", notes=");
		sb.append(notes);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ShoppingOrder toEntityModel() {
		ShoppingOrderImpl shoppingOrderImpl = new ShoppingOrderImpl();

		if (uuid == null) {
			shoppingOrderImpl.setUuid(StringPool.BLANK);
		}
		else {
			shoppingOrderImpl.setUuid(uuid);
		}

		shoppingOrderImpl.setOrderId(orderId);
		shoppingOrderImpl.setGroupId(groupId);
		shoppingOrderImpl.setCompanyId(companyId);
		shoppingOrderImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			shoppingOrderImpl.setCreateDate(null);
		}
		else {
			shoppingOrderImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			shoppingOrderImpl.setModifiedDate(null);
		}
		else {
			shoppingOrderImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (orderStatus == null) {
			shoppingOrderImpl.setOrderStatus(StringPool.BLANK);
		}
		else {
			shoppingOrderImpl.setOrderStatus(orderStatus);
		}

		if (customerEmail == null) {
			shoppingOrderImpl.setCustomerEmail(StringPool.BLANK);
		}
		else {
			shoppingOrderImpl.setCustomerEmail(customerEmail);
		}

		if (customerName == null) {
			shoppingOrderImpl.setCustomerName(StringPool.BLANK);
		}
		else {
			shoppingOrderImpl.setCustomerName(customerName);
		}

		if (customerPhone == null) {
			shoppingOrderImpl.setCustomerPhone(StringPool.BLANK);
		}
		else {
			shoppingOrderImpl.setCustomerPhone(customerPhone);
		}

		if (shippingAddress1 == null) {
			shoppingOrderImpl.setShippingAddress1(StringPool.BLANK);
		}
		else {
			shoppingOrderImpl.setShippingAddress1(shippingAddress1);
		}

		if (shippingAddress2 == null) {
			shoppingOrderImpl.setShippingAddress2(StringPool.BLANK);
		}
		else {
			shoppingOrderImpl.setShippingAddress2(shippingAddress2);
		}

		if (shippingCity == null) {
			shoppingOrderImpl.setShippingCity(StringPool.BLANK);
		}
		else {
			shoppingOrderImpl.setShippingCity(shippingCity);
		}

		if (shippingPostalCode == null) {
			shoppingOrderImpl.setShippingPostalCode(StringPool.BLANK);
		}
		else {
			shoppingOrderImpl.setShippingPostalCode(shippingPostalCode);
		}

		if (shippingStateProvince == null) {
			shoppingOrderImpl.setShippingStateProvince(StringPool.BLANK);
		}
		else {
			shoppingOrderImpl.setShippingStateProvince(shippingStateProvince);
		}

		if (shippingCountry == null) {
			shoppingOrderImpl.setShippingCountry(StringPool.BLANK);
		}
		else {
			shoppingOrderImpl.setShippingCountry(shippingCountry);
		}

		shoppingOrderImpl.setTotal(total);

		if (notes == null) {
			shoppingOrderImpl.setNotes(StringPool.BLANK);
		}
		else {
			shoppingOrderImpl.setNotes(notes);
		}

		shoppingOrderImpl.resetOriginalValues();

		return shoppingOrderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		orderId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		orderStatus = objectInput.readUTF();
		customerEmail = objectInput.readUTF();
		customerName = objectInput.readUTF();
		customerPhone = objectInput.readUTF();
		shippingAddress1 = objectInput.readUTF();
		shippingAddress2 = objectInput.readUTF();
		shippingCity = objectInput.readUTF();
		shippingPostalCode = objectInput.readUTF();
		shippingStateProvince = objectInput.readUTF();
		shippingCountry = objectInput.readUTF();

		total = objectInput.readDouble();
		notes = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(orderId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (orderStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(orderStatus);
		}

		if (customerEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customerEmail);
		}

		if (customerName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customerName);
		}

		if (customerPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customerPhone);
		}

		if (shippingAddress1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingAddress1);
		}

		if (shippingAddress2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingAddress2);
		}

		if (shippingCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingCity);
		}

		if (shippingPostalCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingPostalCode);
		}

		if (shippingStateProvince == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingStateProvince);
		}

		if (shippingCountry == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingCountry);
		}

		objectOutput.writeDouble(total);

		if (notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes);
		}
	}

	public String uuid;
	public long orderId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String orderStatus;
	public String customerEmail;
	public String customerName;
	public String customerPhone;
	public String shippingAddress1;
	public String shippingAddress2;
	public String shippingCity;
	public String shippingPostalCode;
	public String shippingStateProvince;
	public String shippingCountry;
	public double total;
	public String notes;
}