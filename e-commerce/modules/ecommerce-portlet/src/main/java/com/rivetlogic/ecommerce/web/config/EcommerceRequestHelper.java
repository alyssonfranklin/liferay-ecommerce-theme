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
package com.rivetlogic.ecommerce.web.config;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.settings.GroupServiceSettingsLocator;
import com.liferay.portal.kernel.settings.ParameterMapSettingsLocator;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.rivetlogic.ecommerce.configuration.EcommerceGroupServiceConfiguration;
import com.rivetlogic.ecommerce.constants.ShoppingCartPortletKeys;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

public class EcommerceRequestHelper {

	public static EcommerceGroupServiceConfiguration getEcommerceGroupServiceConfiguration(
			PortletRequest portletRequest) {
		return getEcommerceGroupServiceConfiguration(PortalUtil.getHttpServletRequest(portletRequest));
	}

	public static EcommerceGroupServiceConfiguration getEcommerceGroupServiceConfiguration(HttpServletRequest request) {

		EcommerceGroupServiceConfiguration ecommerceGroupServiceConfiguration = null;

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			ecommerceGroupServiceConfiguration = ConfigurationProviderUtil.getConfiguration(
					EcommerceGroupServiceConfiguration.class,
					new ParameterMapSettingsLocator(request.getParameterMap(), new GroupServiceSettingsLocator(
							themeDisplay.getSiteGroupId(), ShoppingCartPortletKeys.SHOPPING_CART_ADMIN)));

			if (ecommerceGroupServiceConfiguration != null && ecommerceGroupServiceConfiguration.storeEmailAddress().isEmpty()){
				if (_log.isDebugEnabled()) {
					_log.debug("First time, configuration is coming from system settings.");
				}
				ecommerceGroupServiceConfiguration = ConfigurationProviderUtil
						.getGroupConfiguration(EcommerceGroupServiceConfiguration.class, themeDisplay.getSiteGroupId());
			}

			return ecommerceGroupServiceConfiguration;
		} catch (PortalException pe) {
			throw new SystemException(pe);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(EcommerceRequestHelper.class);
}
