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
package com.rivetlogic.ecommerce.beans;

import com.rivetlogic.ecommerce.util.ShoppingCartItemUtil;

import java.text.DecimalFormat;

public class ShoppingCartItem {

	long itemId;
	long orderId;
	String productId;
	String itemStatus;
	int count;
	String salePrice;
	String listPrice;
	String itemTitle;
	String itemLink;
	String itemImage;

	public ShoppingCartItem() {
		init();
	}

	private void init() {
		itemId = 0l;
		orderId = 0l;
		productId = null;
		itemStatus = null;
		count = 1;
		salePrice = null;
		listPrice = null;
		itemTitle = null;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSalePrice() {
		Double price = Double.valueOf(salePrice);
		return new DecimalFormat(ShoppingCartItemUtil.DECIMAL_FORMAT).format(price);
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getListPrice() {
		Double price = 0.0;
		if (null != listPrice && !listPrice.isEmpty()) {
			price = Double.valueOf(listPrice);
		}
		return new DecimalFormat(ShoppingCartItemUtil.DECIMAL_FORMAT).format(price);
	}

	public void setListPrice(String listPrice) {
		this.listPrice = listPrice;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public String getPrice() {
		if (null != salePrice && !salePrice.isEmpty()) {
			return getSalePrice();
		}
		return getListPrice();
	}

	public String getItemLink() {
		return itemLink;
	}

	public void setItemLink(String itemLink) {
		this.itemLink = itemLink;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public Float getTotalPrice() {
		return Float.valueOf(getPrice()) * (float) getCount();
	}

	public static final String LIST_PRICE = "/root/dynamic-element[@name='ListPrice']/dynamic-content";
	public static final String SALE_PRICE = "/root/dynamic-element[@name='SalePrice']/dynamic-content";
	public static final String PRODUCT_TITLE = "/root/dynamic-element[@name='ProductTitle']/dynamic-content";
	public static final String PRODUCT_IMAGES = "/root/dynamic-element[@name='ProductImages']/dynamic-content";

}
