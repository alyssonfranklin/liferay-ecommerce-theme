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
package com.rivetlogic.ecommerce.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.rivetlogic.ecommerce.configuration.EcommerceConfigurationKeys;
import com.rivetlogic.ecommerce.constants.ShoppingCartPortletKeys;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component(
		configurationPid = EcommerceConfigurationKeys.SERVICE_CONFIGURATION_ID,
		configurationPolicy = ConfigurationPolicy.OPTIONAL, 
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.hidden",
	        "com.liferay.portlet.instanceable=false",
	        "com.liferay.portlet.preferences-owned-by-group=true",
	        "com.liferay.portlet.preferences-unique-per-layout=false",
	        "com.liferay.portlet.render-weight=100",
			"com.liferay.portlet.scopeable=true",
			"com.liferay.portlet.use-default-template=true",
	        "javax.portlet.security-role-ref=power-user,user",
	        "javax.portlet.display-name=Shopping Orders",
	        "javax.portlet.init-param.config-template=/shopping_cart_admin/configuration.jsp",
	        "javax.portlet.init-param.template-path=/shopping_cart_admin/",
			"javax.portlet.init-param.view-template=/shopping_cart_admin/view.jsp",
			"javax.portlet.name=" + ShoppingCartPortletKeys.SHOPPING_CART_ADMIN,
	    },
		service = {ShoppingCartAdminPortlet.class, Portlet.class}

)
public class ShoppingCartAdminPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(ShoppingCartAdminPortlet.class);

	public void updateOrderNotes(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		long orderId = ParamUtil.getLong(request, ShoppingCartPortletKeys.ORDER_ID);
		String notes = ParamUtil.getString(request, ShoppingCartPortletKeys.NOTES_UPDATE);
		String redirect = ParamUtil.getString(request, "redirect");
		_log.debug(String.format("Updating notes for order %s", orderId));
		try {
			ShoppingOrder order = ShoppingOrderLocalServiceUtil.fetchShoppingOrder(orderId);
			order.setNotes(notes);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			ShoppingOrderLocalServiceUtil.updateOrder(order, serviceContext);
			SessionMessages.add(request, "success");
		} catch (PortalException e) {
			_log.error(e.getMessage());
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}
		}
		response.sendRedirect(redirect);
	}

	public void updateOrderStatus(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		long orderId = ParamUtil.getLong(request, ShoppingCartPortletKeys.ORDER_ID);
		String newStatus = ParamUtil.getString(request, ShoppingCartPortletKeys.STATUS_UPDATE);
		String redirect = ParamUtil.getString(request, "redirect");
		_log.debug(String.format("Updating order %s with status %s", orderId, newStatus));

		try {
			ShoppingOrder order = ShoppingOrderLocalServiceUtil.fetchShoppingOrder(orderId);
			order.setOrderStatus(newStatus);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			ShoppingOrderLocalServiceUtil.updateOrder(order, serviceContext);
			SessionMessages.add(request, "success");
		} catch (PortalException e) {
			_log.error(e.getMessage());
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}
		}
		response.sendRedirect(redirect);
	}
}