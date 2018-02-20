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
package com.rivetlogic.ecommerce.panel;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.rivetlogic.ecommerce.constants.ShoppingCartPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"panel.app.order:Integer=100",
			"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
		},
		service = PanelApp.class
)
public class ShoppingCartAdminPanel extends BasePanelApp {

	@Override
	public String getPortletId() {
		return ShoppingCartPortletKeys.SHOPPING_CART_ADMIN;
	}

	@Override
	@Reference(
			target = "(javax.portlet.name=" + ShoppingCartPortletKeys.SHOPPING_CART_ADMIN + ")", 
			unbind = "-")
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}
