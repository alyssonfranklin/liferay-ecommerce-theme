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
package com.rivetlogic.ecommerce.portlet.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.rivetlogic.ecommerce.constants.ShoppingCartPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
	        "javax.portlet.name="+ShoppingCartPortletKeys.SHOPPING_CART,
	        "mvc.command.name="+ShoppingCartPortletKeys.RC_GET_CART_INFO
	    },
	    service = MVCResourceCommand.class
)
public class GetCartInfoResourceCommand extends BaseResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(GetCartInfoResourceCommand.class);

	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		if (_log.isDebugEnabled()){
			_log.debug(ShoppingCartPortletKeys.RC_GET_CART_INFO);
		}
		
		boolean error = false;
		try {
			addCartDetailsOnResponse(resourceRequest, resourceResponse, null);

		} catch (Exception e) {
			_log.error(String.format(ERROR_SERVING_RESOURCE, ShoppingCartPortletKeys.RC_GET_CART_INFO, e));
			error = printJsonResponse(ERROR_SERVING_RESOURCE, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
					resourceResponse);

		}
		return error;

	}

}