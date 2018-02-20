<%-- 
/*
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
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.taglib.util.TagResourceBundleUtil"%>

<%@ page import="com.rivetlogic.ecommerce.beans.ShoppingCartItem" %>
<%@ page import="com.rivetlogic.ecommerce.configuration.EcommerceGroupServiceConfiguration" %>
<%@ page import="com.rivetlogic.ecommerce.constants.ShoppingCartPortletKeys" %>
<%@ page import="com.rivetlogic.ecommerce.model.ShoppingOrder" %>
<%@ page import="com.rivetlogic.ecommerce.model.ShoppingOrderItem" %>
<%@ page import="com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil" %>
<%@ page import="com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil" %>
<%@ page import="com.rivetlogic.ecommerce.web.config.EcommerceRequestHelper" %>

<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.logging.Logger"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ResourceBundle"%>
<%@ page import="java.util.Set" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<c:set var="pns" scope="request"><portlet:namespace /></c:set>

<%
String redirect = ParamUtil.getString(request, "redirect");
String currentURL = PortalUtil.getCurrentURL(request);
ResourceBundle resourceBundle = TagResourceBundleUtil.getResourceBundle(request, locale);
%>