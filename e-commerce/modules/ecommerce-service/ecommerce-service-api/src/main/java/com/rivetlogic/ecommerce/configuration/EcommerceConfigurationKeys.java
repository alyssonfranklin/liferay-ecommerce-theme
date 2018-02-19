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
package com.rivetlogic.ecommerce.configuration;

public class EcommerceConfigurationKeys {

	public static final String SERVICE_CONFIGURATION_ID = "com.rivetlogic.ecommerce.configuration.EcommerceGroupServiceConfiguration";
	public static final String SERVICE_NAME = "com.rivetlogic.ecommerce";
	public static final String STORE_NAME_DFTL = "My Store";
	public static final String STORE_EMAIL_ADDRESS_DFTL = "${server-property://com.liferay.portal/admin.email.from.address}";
	public static final String MESSAGE_CHECKOUT_SUCCESS_DFTL = "Your order has been placed!";
	public static final String MESSAGE_CHECKOUT_ERROR_DFTL = "Your order could not be processed!";
	public static final String MESSAGE_CAR_EMPTY_DFTL = "Your cart is empty.";
}
