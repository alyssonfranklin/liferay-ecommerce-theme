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
	long orderId = ParamUtil.getLong(request, ShoppingCartPortletKeys.ORDER_ID);
	ShoppingOrder order = ShoppingOrderLocalServiceUtil.fetchShoppingOrder(orderId);
	List<ShoppingOrderItem> items = ShoppingOrderItemLocalServiceUtil.findByOrderId(orderId);
	pageContext.setAttribute("order", order);
	String statusKey = order.getOrderStatus().toLowerCase();
	pageContext.setAttribute("statusKey", statusKey);
	String status = LanguageUtil.get(resourceBundle, "ecommerce-order-status-" + statusKey);
	pageContext.setAttribute("status", status);
%>

<liferay-ui:success key="success" message="ecommerce-order-notes-update-success" />

<liferay-ui:header title="ecommerce-order-details" backURL="<%= redirect %>"/>

<aui:model-context model="<%= ShoppingOrder.class %>" bean="<%= order %>" />

<portlet:actionURL name="updateOrderNotes" var="updateNotesURL">
	<portlet:param name="orderId" value="<%= Long.toString(orderId) %>" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:actionURL>

<liferay-ui:panel-container cssClass="metadata-panel-container" extended="<%= true %>" markupView="lexicon" persistState="<%= true %>">
	<liferay-ui:panel collapsible="<%= true %>" cssClass="metadata" extended="<%= true %>" markupView="lexicon" persistState="<%= true %>" title="general">
		<aui:field-wrapper>
			<aui:input name="orderId" disabled="true" />
			<aui:input name="createDate" label="created" disabled="true" type="text" />
			<aui:input name="modifiedDate" label="last-modified" disabled="true" type="text" />
			<aui:input name="total" disabled="true" />
			<aui:input name="order-status" label="ecommerce-order-status" type="text" disabled="true" value="${ status }" helpMessage="ecommerce-help-status-${ statusKey }" />
			<aui:form action="<%= updateNotesURL %>">
			<aui:input name="notes" type="textarea"/>
			<aui:button-row>
				<aui:button type="submit" />
			</aui:button-row>
			</aui:form>
		</aui:field-wrapper>
	</liferay-ui:panel>
	<liferay-ui:panel collapsible="<%= true %>" cssClass="metadata" extended="<%= false %>" markupView="lexicon" persistState="<%= true %>" title="contact">
		<aui:field-wrapper>
			<aui:input name="customerName" label="name" disabled="true" inlineLabel="true" />
			<aui:input name="customerEmail" label="email" disabled="true" inlineLabel="true" />
			<aui:input name="customerPhone" label="phone" disabled="true" inlineLabel="true" />
		</aui:field-wrapper>		
	</liferay-ui:panel>
	<liferay-ui:panel collapsible="<%= true %>" cssClass="metadata" extended="<%= false %>" markupView="lexicon" persistState="<%= true %>" title="shipping">
		<aui:field-wrapper>
			<aui:input name="shippingCountry" label="country" disabled="true" />
			<aui:input name="shippingCity" label="city" disabled="true" />
			<aui:input name="shippingStateProvince" label="state" disabled="true" />
			<aui:input name="shippingPostalCode" label="postal-code" disabled="true" />
			<aui:field-wrapper label="address">
				<aui:input name="shippingAddress1" disabled="true" inlineField="true" label="" />
				<aui:input name="shippingAddress2" disabled="true" inlineField="true" label="" />
			</aui:field-wrapper>
		</aui:field-wrapper>
	</liferay-ui:panel>
	<liferay-ui:panel collapsible="<%= true %>" cssClass="metadata" extended="<%= false %>" markupView="lexicon" persistState="<%= true %>" title="items">		
			<table class="table table-bordered table-hover table-striped">
				<thead class="table-columns">
					<tr>
						<th class="table-header">
							 <liferay-ui:message key="ecommerce-product-id" />							
						</th>
						<th class="table-header">
							 <liferay-ui:message key="price" />							
						</th>
						<th class="table-header">
							 <liferay-ui:message key="quantity" />							
						</th>
                    </tr>
                </thead>
				<tbody class="table-data">
					<c:forEach items="<%= items %>" var="item">
                	<tr>
						<td class="table-cell">${ item.productId }
                	    </td>
                	    <td class="table-cell">${ item.price }
                	    </td>
                	    <td class="table-cell">${ item.quantity }
                	    </td>
               	     </tr>
               	     </c:forEach>
                </tbody>
			</table>
	</liferay-ui:panel>
</liferay-ui:panel-container>
