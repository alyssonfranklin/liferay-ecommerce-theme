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

import com.liferay.portal.kernel.util.Validator;
import com.rivetlogic.ecommerce.configuration.EcommerceGroupServiceConfiguration;

import java.util.Locale;

public class ShoppingCartPrefsBean {

	private boolean isCustomerEmailEnabled;
	private String customerNotifSubjectTemplate;
	private String customerNotifBodyTemplate;

	private boolean isStoreEmailEnabled;
	private String storeNotifSubjectTemplate;
	private String storeNotifBodyTemplate;

	private String storeEmail;
	private String storeName;

	private String checkoutSuccessMessage;
	private String checkoutErrorMessage;
	private String cartIsEmptyMessage;

	private boolean paypalEnabled;
	private boolean usePaypalSandbox;
	private String paypalEmail;

	public ShoppingCartPrefsBean(EcommerceGroupServiceConfiguration ecommerceGroupServiceConfiguration, Locale locale) {
		setFields(ecommerceGroupServiceConfiguration, locale);
	}

	private void setFields(EcommerceGroupServiceConfiguration ecommerceGroupServiceConfiguration, Locale locale) {
		isCustomerEmailEnabled = ecommerceGroupServiceConfiguration.customerEmailEnabled();
		customerNotifSubjectTemplate = ecommerceGroupServiceConfiguration.customerEmailSubject().get(locale);
		customerNotifBodyTemplate = ecommerceGroupServiceConfiguration.customerEmailBody().get(locale);

		isStoreEmailEnabled = ecommerceGroupServiceConfiguration.storeEmailEnabled();
		storeNotifSubjectTemplate = ecommerceGroupServiceConfiguration.storeEmailSubject().get(locale);
		storeNotifBodyTemplate = ecommerceGroupServiceConfiguration.storeEmailBody().get(locale);

		storeEmail = ecommerceGroupServiceConfiguration.storeEmailAddress();
		storeName = ecommerceGroupServiceConfiguration.storeName();

		checkoutSuccessMessage = ecommerceGroupServiceConfiguration.messageCheckoutSuccess();
		checkoutErrorMessage = ecommerceGroupServiceConfiguration.messageCheckoutError();
		cartIsEmptyMessage = ecommerceGroupServiceConfiguration.messageCartEmpty();

		paypalEnabled = ecommerceGroupServiceConfiguration.enablePaypal();
		usePaypalSandbox = ecommerceGroupServiceConfiguration.usePaypalSandbox();
		paypalEmail = ecommerceGroupServiceConfiguration.paypalBusinessEmailAddress();
	}

	public boolean isCartPrefsValidForCheckout(boolean isPaypal) {
		boolean valid = ((null != getStoreEmail() && !getStoreEmail().isEmpty()) && (Validator.isNotNull(storeEmail))
				&& (Validator.isNotNull(storeName))
				&& (!isCustomerEmailEnabled || (Validator.isNotNull(customerNotifSubjectTemplate)
						&& Validator.isNotNull(customerNotifBodyTemplate)))
				&& (!isStoreEmailEnabled || (Validator.isNotNull(storeNotifSubjectTemplate)
						&& Validator.isNotNull(storeNotifBodyTemplate))));
		if (isPaypal) {
			valid = valid && (!paypalEnabled || Validator.isNotNull(paypalEmail));
		}
		return valid;
	}

	public String getStoreEmail() {
		return storeEmail;
	}

	public void setStoreEmail(String storeEmail) {
		this.storeEmail = storeEmail;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCustomerNotifSubjectTemplate() {
		return customerNotifSubjectTemplate;
	}

	public void setCustomerNotifSubjectTemplate(String customerNotifSubjectTemplate) {
		this.customerNotifSubjectTemplate = customerNotifSubjectTemplate;
	}

	public String getCustomerNotifBodyTemplate() {
		return customerNotifBodyTemplate;
	}

	public void setCustomerNotifBodyTemplate(String customerNotifBodyTemplate) {
		this.customerNotifBodyTemplate = customerNotifBodyTemplate;
	}

	public String getStoreNotifSubjectTemplate() {
		return storeNotifSubjectTemplate;
	}

	public void setStoreNotifSubjectTemplate(String storeNotifSubjectTemplate) {
		this.storeNotifSubjectTemplate = storeNotifSubjectTemplate;
	}

	public String getStoreNotifBodyTemplate() {
		return storeNotifBodyTemplate;
	}

	public void setStoreNotifBodyTemplate(String storeNotifBodyTemplate) {
		this.storeNotifBodyTemplate = storeNotifBodyTemplate;
	}

	public String getCheckoutSuccessMessage() {
		return checkoutSuccessMessage;
	}

	public void setCheckoutSuccessMessage(String checkoutSuccessMessage) {
		this.checkoutSuccessMessage = checkoutSuccessMessage;
	}

	public String getCheckoutErrorMessage() {
		return checkoutErrorMessage;
	}

	public void setCheckoutErrorMessage(String checkoutErrorMessage) {
		this.checkoutErrorMessage = checkoutErrorMessage;
	}

	public String getCartIsEmptyMessage() {
		return cartIsEmptyMessage;
	}

	public void setCartIsEmptyMessage(String cartIsEmptyMessage) {
		this.cartIsEmptyMessage = cartIsEmptyMessage;
	}

	public boolean isPaypalEnabled() {
		return paypalEnabled;
	}

	public void setPaypalEnabled(boolean enablePaypal) {
		this.paypalEnabled = enablePaypal;
	}

	public boolean isUsePaypalSandbox() {
		return usePaypalSandbox;
	}

	public void setUsePaypalSandbox(boolean usePaypalSandbox) {
		this.usePaypalSandbox = usePaypalSandbox;
	}

	public String getPaypalEmail() {
		return paypalEmail;
	}

	public void setPaypalEmail(String paypalEmail) {
		this.paypalEmail = paypalEmail;
	}

	public boolean isCustomerEmailEnabled() {
		return isCustomerEmailEnabled;
	}

	public void setCustomerEmailEnabled(boolean isCustomerEmailEnabled) {
		this.isCustomerEmailEnabled = isCustomerEmailEnabled;
	}

	public boolean isStoreEmailEnabled() {
		return isStoreEmailEnabled;
	}

	public void setStoreEmailEnabled(boolean isStoreEmailEnabled) {
		this.isStoreEmailEnabled = isStoreEmailEnabled;
	}

}