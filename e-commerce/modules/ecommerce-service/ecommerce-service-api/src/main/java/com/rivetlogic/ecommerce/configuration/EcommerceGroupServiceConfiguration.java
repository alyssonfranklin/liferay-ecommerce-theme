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

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.kernel.settings.LocalizedValuesMap;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
	    category = "shopping",
	    scope = ExtendedObjectClassDefinition.Scope.GROUP
)
@Meta.OCD(
	    id = EcommerceConfigurationKeys.SERVICE_CONFIGURATION_ID,
		localization = "content/Language",
	    name="com.rivetlogic.ecommerce.config.name"
)
public interface EcommerceGroupServiceConfiguration {
	
	@Meta.AD(
			deflt = EcommerceConfigurationKeys.STORE_NAME_DFTL,
	        required = false,
	        name = "com.rivetlogic.ecommerce.config.store.name.name",
	        description = "com.rivetlogic.ecommerce.config.store.name.description"
	)
	public String storeName();
	
	@Meta.AD(
			deflt = EcommerceConfigurationKeys.STORE_EMAIL_ADDRESS_DFTL,
	        required = false,
	        name = "com.rivetlogic.ecommerce.config.store.email.address.name",
	        description = "com.rivetlogic.ecommerce.config.store.email.address.description"
	)
	public String storeEmailAddress();

	@Meta.AD(
			deflt = "true",
	        required = false,
	        name = "com.rivetlogic.ecommerce.config.store.email.enabled.name",
	        description = "com.rivetlogic.ecommerce.config.store.email.enabled.description"
	)
	public boolean storeEmailEnabled();
	
	@Meta.AD(
			deflt = "${resource:com/rivetlogic/ecommerce/config/dependencies/store_email_subject.tmpl}",
	        required = false,
	        name = "com.rivetlogic.ecommerce.config.store.email.subject.name",
	        description = "com.rivetlogic.ecommerce.config.store.email.subject.description"
	)
	public LocalizedValuesMap storeEmailSubject();
	
	@Meta.AD(
			deflt = "${resource:com/rivetlogic/ecommerce/config/dependencies/store_email_body.tmpl}",
	        required = false,
	        name = "com.rivetlogic.ecommerce.config.store.email.body.name",
	        description = "com.rivetlogic.ecommerce.config.store.email.body.description"
	)
	public LocalizedValuesMap storeEmailBody();
	
	@Meta.AD(
			deflt = "true",
	        required = false,
	        name = "com.rivetlogic.ecommerce.config.customer.email.enabled.name",
	        description = "com.rivetlogic.ecommerce.config.customer.email.enabled.description"
	)
	public boolean customerEmailEnabled();
	
	@Meta.AD(
			deflt = "${resource:com/rivetlogic/ecommerce/config/dependencies/customer_email_subject.tmpl}",
	        required = false,
	        name = "com.rivetlogic.ecommerce.config.customer.email.subject.name",
	        description = "com.rivetlogic.ecommerce.config.customer.email.subject.description"
	)
	public LocalizedValuesMap customerEmailSubject();
	
	@Meta.AD(
			deflt = "${resource:com/rivetlogic/ecommerce/config/dependencies/customer_email_body.tmpl}",
	        required = false,
	        name = "com.rivetlogic.ecommerce.config.customer.email.body.name",
	        description = "com.rivetlogic.ecommerce.config.customer.email.body.description"
	)
	public LocalizedValuesMap customerEmailBody();
	
	@Meta.AD(
			deflt = EcommerceConfigurationKeys.MESSAGE_CHECKOUT_SUCCESS_DFTL,
	        required = false,
	        name = "com.rivetlogic.ecommerce.config.message.checkout.success.name",
	        description = "com.rivetlogic.ecommerce.config.message.checkout.success.description"
	)
	public String messageCheckoutSuccess();
	
	@Meta.AD(
			deflt = EcommerceConfigurationKeys.MESSAGE_CHECKOUT_ERROR_DFTL,
	        required = false,
	        name = "com.rivetlogic.ecommerce.config.message.checkout.error.name",
	        description = "com.rivetlogic.ecommerce.config.message.checkout.error.description"
	)
	public String messageCheckoutError();
	
	@Meta.AD(
			deflt = EcommerceConfigurationKeys.MESSAGE_CAR_EMPTY_DFTL,
	        required = false,
	        name = "com.rivetlogic.ecommerce.config.message.car.empty.name",
	        description = "com.rivetlogic.ecommerce.config.message.car.empty.description"
	)
	public String messageCartEmpty();
	
	@Meta.AD(
			deflt = "true",
	        required = false,
	        name = "com.rivetlogic.ecommerce.config.paypal.enabled.name",
	        description = "com.rivetlogic.ecommerce.config.paypal.enabled.description"
	)
	public boolean enablePaypal();
	
	@Meta.AD(
			deflt = "false",
	        required = false,
	        name = "com.rivetlogic.ecommerce.config.use.paypal.sandbox.name",
	        description = "com.rivetlogic.ecommerce.config.use.paypal.sandbox.description"
	)
	public boolean usePaypalSandbox();
	
	@Meta.AD(
			deflt = "",
	        required = false,
	        name = "com.rivetlogic.ecommerce.config.paypal.business.email.address.name",
	        description = "com.rivetlogic.ecommerce.config.paypal.business.email.address.description"
	)
	public String paypalBusinessEmailAddress();
}
