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
package com.rivetlogic.ecommerce.constants;

public class ShoppingCartPortletKeys {

	public static final String SHOPPING_CART = "com_rivetlogic_ecommerce_portlet_ShoppingCart";
	public static final String SHOPPING_CART_ADMIN = "com_rivetlogic_ecommerce_portlet_ShoppingCartAdminPortlet";
	public static final String SHOPPING_ORDERS_TABLE_NAME = "rivetlogic_ecommerce_ShoppingOrder";

	// referenced from main.js in theme
	public static final String RC_ADD_CART_ITEM = "addCartItem";
	public static final String RC_GET_CART_INFO = "getCartInfo";

	public static final String RC_REMOVE_ITEM_FROM_CART = "removeCartItem";
	public static final String RC_UPDATE_CART_ITEM = "updateCartItem";
	public static final String ACTION_UPDATE_CONFIG = "updateCartConfig";

	public static final String ATTR_CURRENT_ORDER_ITEMS = "currentOrderItems";

	public static final String WEB_CONTENT_ITEM_ID = "itemId";
	public static final String WEB_CONTENT_ITEM_NAME = "itemName";
	public static final String WEB_CONTENT_ITEM_PRICE = "itemPrice";
	public static final String WEB_CONTENT_ITEM_COUNT = "itemCount";

	public static final String ORDER_ID = "orderId";
	public static final String NOTES_UPDATE = "notes";
	public static final String STATUS_UPDATE = "newStatus";

	public static final String COOKIE_SHOPPING_CART_ITEMS = "SHOPPING_CART_ITEMS";
	public static final String COOKIE_SHOPPING_CART_PRICES = "SHOPPING_CART_PRICES";

	public static final String CART_DETAILS = "cartDetails";
	public static final String CART_DETAILS_TOTAL = "total";
	public static final String CART_DETAILS_QUANTITY = "quantity";
	public static final String ITEM_DETAILS = "itemDetails";

	public static final String CHECKOUT_PARAMETER_NAME = "name";
	public static final String CHECKOUT_PARAMETER_EMAIL = "email";
	public static final String CHECKOUT_PARAMETER_ADDRESS_1 = "address1";
	public static final String CHECKOUT_PARAMETER_ADDRESS_2 = "address2";
	public static final String CHECKOUT_PARAMETER_CITY = "city";
	public static final String CHECKOUT_PARAMETER_STATE_PROVINCE = "stateProvince";
	public static final String CHECKOUT_PARAMETER_POSTAL_CODE = "postalCode";
	public static final String CHECKOUT_PARAMETER_COUNTRY = "country";
	public static final String CHECKOUT_PARAMETER_PHONE = "phone";
	public static final String CHECKOUT_PARAMETER_PAYPAL = "paypalCheckout";

	public static final String DECIMAL_FORMAT = "0.00";

	public static final String SUCCESS_MESSAGE_CHECKOUT = "success-message-checkout";
	public static final String ERROR_MESSAGE_CHECKOUT = "error-message-checkout";
	public static final String MESSAGE_MISSING_REQUIRED_CHECKOUT_INFO = "error-information-required";

	public static final String PORTLET_STRUTS = "ecommerce";
}