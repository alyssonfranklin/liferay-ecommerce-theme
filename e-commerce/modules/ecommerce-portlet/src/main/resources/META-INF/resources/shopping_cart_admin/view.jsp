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
<%@ include file="/init.jsp" %>

<%
	long groupId = themeDisplay.getScopeGroupId();

	String orderByCol = ParamUtil.getString(request, "orderByCol", "modifiedDate");
	String orderByType = ParamUtil.getString(request, "orderByType", "desc");
	
	OrderByComparator comparator = OrderByComparatorFactoryUtil.create(ShoppingCartPortletKeys.SHOPPING_ORDERS_TABLE_NAME, orderByCol, orderByType.equals("asc"));
	orderByType = orderByType.equals("asc")? "desc" : "asc";

	Map<String, Object> data = new HashMap<>();
	data.put("qa-id", "navigation");
%>

<aui:nav-bar cssClass="collapse-basic-search" data="<%= data %>" markupView="lexicon">
        <portlet:renderURL var="mainURL" />
        <aui:nav cssClass="navbar-nav">
                <aui:nav-item href="<%= mainURL.toString() %>" label="ecommerce-orders" selected="<%= true %>" />
        </aui:nav>
</aui:nav-bar>

<liferay-ui:success key="success" message="ecommerce-order-status-update-success" />

<liferay-ui:search-container emptyResultsMessage="ecommerce-no-orders-found" orderByType="<%= orderByType %>" total="<%= ShoppingOrderLocalServiceUtil.countByGroupId(groupId) %>">
	
	<liferay-ui:search-container-results 
		results="<%= ShoppingOrderLocalServiceUtil.findByGroupId(groupId, searchContainer.getStart(), searchContainer.getEnd(), comparator) %>" />
	
	<liferay-ui:search-container-row className="com.rivetlogic.ecommerce.model.ShoppingOrder" modelVar="order">
		
		<liferay-ui:search-container-column-text name="order-id" property="orderId" />
		
		<liferay-ui:search-container-column-text name="ecommerce-order-status" orderable="true" orderableProperty="orderStatus" >
			<liferay-ui:icon-help message="ecommerce-help-status-${ order.orderStatus.toLowerCase() }">
				<liferay-ui:message key="ecommerce-order-status-${ order.orderStatus.toLowerCase() }"/>
			</liferay-ui:icon-help>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-date name="ecommerce-order-last-updated" property="modifiedDate" orderable="true" orderableProperty="modifiedDate" />
		
		<liferay-ui:search-container-column-text name="ecommerce-order-customer-name" property="customerName" />
		
		<liferay-ui:search-container-column-text name="ecommerce-order-customer-email" property="customerEmail" />
		
		<liferay-ui:search-container-column-jsp  name="ecommerce-order-actions" path="/shopping_cart_admin/actions.jsp" />

	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator markupView="lexicon" />

</liferay-ui:search-container>