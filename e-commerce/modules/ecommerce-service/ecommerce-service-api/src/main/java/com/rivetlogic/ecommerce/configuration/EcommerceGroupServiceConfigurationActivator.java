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

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

/**
 * This activator should resolve issues with required configuration fields, but it's not working.
 * I'm keeping the code for reference. the configuration fields will managed as not required.
 *
 */

@Component(
	configurationPid = EcommerceConfigurationKeys.SERVICE_CONFIGURATION_ID,
	configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
	property = {
		"storeName="+EcommerceConfigurationKeys.STORE_NAME_DFTL,
		"storeEmailAddress="+EcommerceConfigurationKeys.STORE_EMAIL_ADDRESS_DFTL,
		"messageCheckoutSuccess="+EcommerceConfigurationKeys.MESSAGE_CHECKOUT_SUCCESS_DFTL,
		"messageCheckoutError="+EcommerceConfigurationKeys.MESSAGE_CHECKOUT_ERROR_DFTL,
		"messageCartEmpty="+EcommerceConfigurationKeys.MESSAGE_CAR_EMPTY_DFTL
	},
	service = EcommerceGroupServiceConfigurationActivator.class
)
public class EcommerceGroupServiceConfigurationActivator {

	public EcommerceGroupServiceConfiguration getEcommerceGroupServiceConfiguration() {
		return _ecommerceGroupServiceConfiguration;
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_ecommerceGroupServiceConfiguration = ConfigurableUtil
				.createConfigurable(EcommerceGroupServiceConfiguration.class, properties);
	}

	@Deactivate
	protected void deactivate() {
		_ecommerceGroupServiceConfiguration = null;
	}

	private volatile EcommerceGroupServiceConfiguration _ecommerceGroupServiceConfiguration;

}
