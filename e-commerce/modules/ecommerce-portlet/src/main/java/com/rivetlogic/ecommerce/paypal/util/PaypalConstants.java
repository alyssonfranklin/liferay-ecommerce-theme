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
package com.rivetlogic.ecommerce.paypal.util;

import com.rivetlogic.ecommerce.paypal.auth.AuthPublicPath;

public class PaypalConstants {

	// DEVELOPMENT ENDPOINT:
	protected static final String PAYPAL_SANDBOX_ENDPOINT = "https://www.sandbox.paypal.com/cgi-bin/webscr";

	// PRODUCTION ENDPOINT:
	protected static final String PAYPAL_ENDPOINT = "https://www.paypal.com/cgi-bin/webscr";

	public static final String NOTIFY_ACTION_PATH = AuthPublicPath.FULL_ACTION_URL;

	public static final String PAYMENT_STATUS = "payment_status";
	public static final String PAYMENT_COMPLETE = "Completed";

	public static final String TRANSACTION_VERIFIED = "VERIFIED";

	public static final String CURRENCY_USD = "USD";

	public static final String PARAM_CMD = "cmd";
	public static final String PARAM_BUSINESS = "business";
	public static final String PARAM_ITEM_NAME = "item_name";
	public static final String PARAM_ITEM_NUMBER = "item_number";
	public static final String PARAM_INVOICE = "invoice";
	public static final String PARAM_AMOUNT = "amount";
	public static final String PARAM_RETURN = "return";
	public static final String PARAM_NOTIFY_URL = "notify_url";
	public static final String PARAM_FIRST_NAME = "first_name";
	public static final String PARAM_LAST_NAME = "last_name";
	public static final String PARAM_ADDRESS1 = "address1";
	public static final String PARAM_CITY = "city";
	public static final String PARAM_STATE = "state";
	public static final String PARAM_ZIP = "zip";
	public static final String PARAM_NO_NOTE = "no_note";
	public static final String PARAM_CURRENCY = "currency";
	public static final String PARAM_EMAIL = "email";

	public static final String CMD_XCLICK = "_xclick";
	public static final String CMD_VALIDATE = "_notify-validate";
}
