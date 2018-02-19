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
<%@ include file="/shopping_cart_admin/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);	
	ShoppingOrder order = (ShoppingOrder) row.getObject();
	String currentStatus = order.getOrderStatus();
	pageContext.setAttribute("order", order);
%>

<liferay-ui:icon-menu>
	<c:if test="<%= !currentStatus.equals(OrderStatusEnum.IN_PROGRESS.toString()) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="orderId" value="${ order.orderId }" />
			<portlet:param name="mvcPath" value="/shopping_cart_admin/details.jsp" />
			<portlet:param name="redirect" value="<%= currentURL %>"/>
		</portlet:renderURL>
		<liferay-ui:icon image="view" message="ecommerce-order-details" url="<%= editURL %>" />
	</c:if>
	<c:choose>
		<c:when test="<%= currentStatus.equals(OrderStatusEnum.WAITING_FOR_PAYMENT.toString()) %>">
			<portlet:actionURL name="updateOrderStatus" var="updatePayedURL">
				<portlet:param name="orderId" value="<%= Long.toString(order.getOrderId()) %>" />
				<portlet:param name="newStatus" value="<%= OrderStatusEnum.PAID.toString() %>" />
				<portlet:param name="redirect" value="<%= currentURL %>"/>
			</portlet:actionURL>
			<liferay-ui:icon image="check" message="ecommerce-set-order-payed" url="<%= updatePayedURL %>"  />
		</c:when>
		<c:when test="<%= currentStatus.equals(OrderStatusEnum.PAID.toString()) %>">
			<portlet:actionURL name="updateOrderStatus" var="updateProcessingURL">
				<portlet:param name="orderId" value="<%= Long.toString(order.getOrderId()) %>" />
				<portlet:param name="newStatus" value="<%= OrderStatusEnum.PROCESSING_DELIVERY.toString() %>" />
				<portlet:param name="redirect" value="<%= currentURL %>"/>
			</portlet:actionURL>
			<liferay-ui:icon image="check" message="ecommerce-set-order-processing" url="<%= updateProcessingURL %>"  />
			<portlet:actionURL name="updateOrderStatus" var="updateShippedURL">
				<portlet:param name="orderId" value="<%= Long.toString(order.getOrderId()) %>" />
				<portlet:param name="newStatus" value="<%= OrderStatusEnum.SHIPPED.toString() %>" />
				<portlet:param name="redirect" value="<%= currentURL %>"/>
			</portlet:actionURL>
			<liferay-ui:icon image="check" message="ecommerce-set-order-shipped" url="<%= updateShippedURL %>"  />
		</c:when>
		<c:when test="<%= currentStatus.equals(OrderStatusEnum.PROCESSING_DELIVERY.toString()) %>">
			<portlet:actionURL name="updateOrderStatus" var="updateProcessingURL">
				<portlet:param name="orderId" value="<%= Long.toString(order.getOrderId()) %>" />
				<portlet:param name="newStatus" value="<%= OrderStatusEnum.SHIPPED.toString() %>" />
				<portlet:param name="redirect" value="<%= currentURL %>"/>
			</portlet:actionURL>
			<liferay-ui:icon image="check" message="ecommerce-set-order-shipped" url="<%= updateProcessingURL %>"  />
		</c:when>
	</c:choose>
	<c:if test="<%= currentStatus.equals(OrderStatusEnum.WAITING_FOR_PAYMENT.toString()) ||
			currentStatus.equals(OrderStatusEnum.WAITING_FOR_PAYPAL.toString()) %>">
		<portlet:actionURL name="updateOrderStatus" var="updateCancelURL">
			<portlet:param name="orderId" value="<%= Long.toString(order.getOrderId()) %>" />
			<portlet:param name="newStatus" value="<%= OrderStatusEnum.CANCELED.toString() %>" />
			<portlet:param name="redirect" value="<%= currentURL %>"/>
		</portlet:actionURL>
		<liferay-ui:icon image="delete" message="ecommerce-set-order-canceled" url="<%= updateCancelURL %>"  />
	</c:if>
</liferay-ui:icon-menu>