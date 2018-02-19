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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.rivetlogic.ecommerce.beans.ShoppingCartPrefsBean;
import com.rivetlogic.ecommerce.configuration.EcommerceGroupServiceConfiguration;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.web.config.EcommerceRequestHelper;

import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author joseross
 *
 */
public class PaypalUtil {

	private static final Log LOG = LogFactoryUtil.getLog(PaypalUtil.class);

	public static String getPaypalEndPoint(HttpServletRequest request) {
		EcommerceGroupServiceConfiguration conf = EcommerceRequestHelper.getEcommerceGroupServiceConfiguration(request);
		Locale locale = request.getLocale();
		ShoppingCartPrefsBean prefsBean = new ShoppingCartPrefsBean(conf, locale);
		String paypalEndpoint = getPaypalEndPoint(prefsBean.isUsePaypalSandbox());
		return paypalEndpoint;
	}

	public static String getPaypalEndPoint(boolean useSandbox) {
		if (useSandbox) {
			return PaypalConstants.PAYPAL_SANDBOX_ENDPOINT;
		} else {
			return PaypalConstants.PAYPAL_ENDPOINT;
		}
	}

	public static String getPaypalRedirect(ActionRequest request, ActionResponse response,
			ShoppingOrder shoppingOrder) {
		EcommerceGroupServiceConfiguration conf = EcommerceRequestHelper.getEcommerceGroupServiceConfiguration(request);
		Locale locale = request.getLocale();
		ShoppingCartPrefsBean prefsBean = new ShoppingCartPrefsBean(conf, locale);

		if (prefsBean.isPaypalEnabled()) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			String portalUrl = themeDisplay.getPortalURL();
			String returnUrl = portalUrl + request.getParameter(WebKeys.REDIRECT);
			String notifyUrl = portalUrl + PaypalConstants.NOTIFY_ACTION_PATH;
			String paypalEmail = prefsBean.getPaypalEmail();
			String orderId = Long.toString(shoppingOrder.getOrderId());
			double orderTotal = shoppingOrder.getTotal();
			String[] names = shoppingOrder.getCustomerName().split(StringPool.SPACE);
			String firstName = names[0];
			String lastName = names.length > 1 ? names[1] : StringPool.BLANK;
			String paypalEndpoint = getPaypalEndPoint(prefsBean.isUsePaypalSandbox());

			StringBuilder sb = new StringBuilder();
			sb.append(paypalEndpoint).append(StringPool.QUESTION);
			formatParam(sb, PaypalConstants.PARAM_CMD, PaypalConstants.CMD_XCLICK);
			formatParam(sb, PaypalConstants.PARAM_BUSINESS, paypalEmail);
			formatParam(sb, PaypalConstants.PARAM_ITEM_NAME, orderId);
			formatParam(sb, PaypalConstants.PARAM_ITEM_NUMBER, orderId);
			formatParam(sb, PaypalConstants.PARAM_INVOICE, orderId);
			formatParam(sb, PaypalConstants.PARAM_AMOUNT, orderTotal);
			formatParam(sb, PaypalConstants.PARAM_RETURN, returnUrl);
			formatParam(sb, PaypalConstants.PARAM_NOTIFY_URL, notifyUrl);
			formatParam(sb, PaypalConstants.PARAM_FIRST_NAME, firstName);
			formatParam(sb, PaypalConstants.PARAM_LAST_NAME, lastName);
			formatParam(sb, PaypalConstants.PARAM_EMAIL, shoppingOrder.getCustomerEmail());
			formatParam(sb, PaypalConstants.PARAM_ADDRESS1, shoppingOrder.getShippingAddress1());
			formatParam(sb, PaypalConstants.PARAM_CITY, shoppingOrder.getShippingCity());
			formatParam(sb, PaypalConstants.PARAM_STATE, shoppingOrder.getShippingStateProvince());
			formatParam(sb, PaypalConstants.PARAM_ZIP, shoppingOrder.getShippingPostalCode());
			formatParam(sb, PaypalConstants.PARAM_NO_NOTE, "1");
			formatParam(sb, PaypalConstants.PARAM_CURRENCY, PaypalConstants.CURRENCY_USD);

			if (LOG.isDebugEnabled())
				LOG.debug("Paypal URL: " + sb);

			return sb.toString();
		} else {
			return null;
		}
	}

	private static void formatParam(StringBuilder sb, String name, Object value) {
		if (!StringPool.QUESTION.equals(sb.subSequence(sb.length() - 1, sb.length() - 1)))
			sb.append(StringPool.AMPERSAND);
		sb.append(String.format("%s=%s", name, HttpUtil.encodeURL(value.toString())));
	}

}
