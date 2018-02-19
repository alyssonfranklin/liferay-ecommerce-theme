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

import com.rivetlogic.ecommerce.model.ShoppingOrderItem;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ShoppingOrderItem in entity cache.
 *
 * @author rivetlogic
 * @see ShoppingOrderItem
 * @generated
 */
@ProviderType
public class ShoppingOrderItemCacheModel implements CacheModel<ShoppingOrderItem>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShoppingOrderItemCacheModel)) {
			return false;
		}

		ShoppingOrderItemCacheModel shoppingOrderItemCacheModel = (ShoppingOrderItemCacheModel)obj;

		if (itemId == shoppingOrderItemCacheModel.itemId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, itemId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", itemId=");
		sb.append(itemId);
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
		sb.append(", orderId=");
		sb.append(orderId);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", price=");
		sb.append(price);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ShoppingOrderItem toEntityModel() {
		ShoppingOrderItemImpl shoppingOrderItemImpl = new ShoppingOrderItemImpl();

		if (uuid == null) {
			shoppingOrderItemImpl.setUuid(StringPool.BLANK);
		}
		else {
			shoppingOrderItemImpl.setUuid(uuid);
		}

		shoppingOrderItemImpl.setItemId(itemId);
		shoppingOrderItemImpl.setGroupId(groupId);
		shoppingOrderItemImpl.setCompanyId(companyId);
		shoppingOrderItemImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			shoppingOrderItemImpl.setCreateDate(null);
		}
		else {
			shoppingOrderItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			shoppingOrderItemImpl.setModifiedDate(null);
		}
		else {
			shoppingOrderItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		shoppingOrderItemImpl.setOrderId(orderId);

		if (productId == null) {
			shoppingOrderItemImpl.setProductId(StringPool.BLANK);
		}
		else {
			shoppingOrderItemImpl.setProductId(productId);
		}

		shoppingOrderItemImpl.setQuantity(quantity);
		shoppingOrderItemImpl.setPrice(price);

		shoppingOrderItemImpl.resetOriginalValues();

		return shoppingOrderItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		itemId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		orderId = objectInput.readLong();
		productId = objectInput.readUTF();

		quantity = objectInput.readInt();

		price = objectInput.readDouble();
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

		objectOutput.writeLong(itemId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(orderId);

		if (productId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productId);
		}

		objectOutput.writeInt(quantity);

		objectOutput.writeDouble(price);
	}

	public String uuid;
	public long itemId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long orderId;
	public String productId;
	public int quantity;
	public double price;
}