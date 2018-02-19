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
package com.rivetlogic.ecommerce.paypal.auth;

import com.rivetlogic.ecommerce.constants.ShoppingCartPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"auth.public.path=" + AuthPublicPath.ACTION_URL,
		},
		service = Object.class
)
public class AuthPublicPath {
	public static final String ACTION_URL="/"+ShoppingCartPortletKeys.PORTLET_STRUTS+"/notify";
	public static final String FULL_ACTION_URL="/c"+ACTION_URL;
}
