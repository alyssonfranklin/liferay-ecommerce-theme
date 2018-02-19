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
List<ShoppingCartItem>cartItemsIdsList = (List<ShoppingCartItem>) request.getAttribute(ShoppingCartPortletKeys.ATTR_CURRENT_ORDER_ITEMS);
DecimalFormat decimalFormat = new DecimalFormat(ShoppingCartPortletKeys.DECIMAL_FORMAT);
EcommerceGroupServiceConfiguration ecommerceGroupServiceConfiguration = EcommerceRequestHelper.getEcommerceGroupServiceConfiguration(request);
%>

<portlet:actionURL name="checkout" var="checkoutURL">
	<portlet:param name="<%= WebKeys.REDIRECT%>" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
</portlet:actionURL>

<portlet:actionURL name="checkout" var="paypalCheckoutURL">
	<portlet:param name="<%= ShoppingCartPortletKeys.CHECKOUT_PARAMETER_PAYPAL %>" value="true"/>
	<portlet:param name="<%= WebKeys.REDIRECT%>" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
</portlet:actionURL>

<liferay-ui:success key="<%=ShoppingCartPortletKeys.SUCCESS_MESSAGE_CHECKOUT %>" message="<%= ecommerceGroupServiceConfiguration.messageCheckoutSuccess() %>" />
<liferay-ui:error key="<%= ShoppingCartPortletKeys.ERROR_MESSAGE_CHECKOUT %>" message="<%= ecommerceGroupServiceConfiguration.messageCheckoutError() %>" />

<input type="hidden" id="page-reloaded" value="no" />

<liferay-ui:panel-container cssClass="metadata-panel-container" extended="true" markupView="lexicon">
	<liferay-ui:panel collapsible="false" cssClass="metadata" extended="true" markupView="lexicon" title="ecommerce-shopping-cart-title">
                  
	<div class="alert alert-warning <%= (null != cartItemsIdsList && !cartItemsIdsList.isEmpty() ? "hidden" : StringPool.BLANK)%>"id="cart-empty-msg">
		<%=ecommerceGroupServiceConfiguration.messageCartEmpty() %>
	</div>
	
	<% if(null != cartItemsIdsList && !cartItemsIdsList.isEmpty()){ %>
		<table class="table table-striped table-hover cart-items-details">
		<thead class="table-columns">
		<tr>
			<th class="table-header"><liferay-ui:message key="image" /></th>
			<th class="table-header"><liferay-ui:message key="title" /></th>
			<th class="table-header"><liferay-ui:message key="price" /></th>
			<th class="table-header"><liferay-ui:message key="quantity" /></th>
			<th class="table-header"><liferay-ui:message key="total" /></th>
		</tr>
		</thead>
		<tbody class="table-data">
		<%
		Double cartTotalPrice = 0d;
		for(ShoppingCartItem orderItem : cartItemsIdsList){		
		%>
			<portlet:resourceURL id="<%= ShoppingCartPortletKeys.RC_UPDATE_CART_ITEM %>" var="updateCartItemURL" >
				<portlet:param name="<%=ShoppingCartPortletKeys.WEB_CONTENT_ITEM_ID%>" value="<%= orderItem.getItemId() != 0l ? String.valueOf(orderItem.getItemId()): orderItem.getProductId()%>"/>
				<portlet:param name="<%=ShoppingCartPortletKeys.WEB_CONTENT_ITEM_COUNT%>" value=""/>
			</portlet:resourceURL>	
			<portlet:resourceURL id="<%= ShoppingCartPortletKeys.RC_REMOVE_ITEM_FROM_CART %>" var="removeCartItemURL" >									
				<portlet:param name="<%=ShoppingCartPortletKeys.WEB_CONTENT_ITEM_ID%>" value="<%= orderItem.getItemId() != 0l ? String.valueOf(orderItem.getItemId()): orderItem.getProductId()%>"/>
			</portlet:resourceURL>
			
			<tr class="item-data-row">
				<td class="table-cell product_image"><a href="<%=orderItem.getItemLink()%>"><img src="<%= orderItem.getItemImage() %>"></a></td>
				<td class="table-cell">
					<a href="<%=orderItem.getItemLink()%>"><%= orderItem.getItemTitle() %></a>
				</td>
				<td class="table-cell">$<%= orderItem.getPrice()%></td>
				<td class="table-cell">
					<aui:row>
						<aui:col width="<%= 80 %>">
							<aui:input name="Quantity" label="" type="number" value="<%= orderItem.getCount()%>" min="1" data-old-value="<%= orderItem.getCount()%>" placeholder="Enter quantity" cssClass="input-mini quantity-input" data-url="${updateCartItemURL}" />
						</aui:col>
						<aui:col width="<%= 20 %>">
							<button type="submit" class="btn btn-danger btn-mini btn-delete" data-url="${removeCartItemURL}"><i class="icon-remove icon-white"></i></button>
						</aui:col>
					</aui:row>
				</td>
				<td class="table-cell item-total-price">$<%= decimalFormat.format(orderItem.getTotalPrice())  %></td>
				<% cartTotalPrice += orderItem.getTotalPrice(); %>
			</tr>
		<%
		}
		%>
		<tr>
			<th colspan="4"></th>
			<th class="table-header" id="cart-total-price">$<%= decimalFormat.format(cartTotalPrice) %></th>
		</tr>
        </tbody>
        </table>
	<% } %>
	</liferay-ui:panel>
   
	<%@ include file="/shopping_cart/shopping_info.jspf" %>

</liferay-ui:panel-container>

<aui:script use="shopping-cart">
    A.ShoppingCart.setPortletNamespace('${pns}');
    A.all('.btn-delete').on('click', function(event){
    	A.ShoppingCart.removeCartItem(event.currentTarget);
    });
    A.all('.quantity-input').on('change', function(event){
    	A.ShoppingCart.updateCartItem(event.currentTarget);
    });
    A.all('#${pns}btn-checkout').on('click', function(event){
    	A.ShoppingCart.doCheckout('${checkoutURL}');
    });
    <c:if test="<%=ecommerceGroupServiceConfiguration.enablePaypal() %>">
    A.all('#${pns}btn-paypal-checkout').on('click', function(event){
    	A.ShoppingCart.doCheckout('${paypalCheckoutURL}');
    });
    </c:if>
    
    var pageReloaded = A.one('#page-reloaded');
    
    A.on('unload', function(){
    	pageReloaded.attr('value', 'yes');
    });
    
    A.ready(function(){
        if(pageReloaded.attr('value') == 'yes') {
        	A.all('#btn-checkout, #btn-paypal-checkout').attr('disabled', true);
        	A.all('#page-reload-warning').removeClass('hide');
        }
    });
</aui:script>