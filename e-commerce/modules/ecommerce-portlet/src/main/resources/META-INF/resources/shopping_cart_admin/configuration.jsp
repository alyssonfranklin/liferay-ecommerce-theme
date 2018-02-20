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
EcommerceGroupServiceConfiguration ecommerceGroupServiceConfiguration = EcommerceRequestHelper.getEcommerceGroupServiceConfiguration(request);

String storeName = ParamUtil.getString(request, "preferences--storeName--", ecommerceGroupServiceConfiguration.storeName());
String storeEmailAddress = ParamUtil.getString(request, "preferences--storeEmailAddress--", ecommerceGroupServiceConfiguration.storeEmailAddress());
String messageCheckoutSuccess = ParamUtil.getString(request, "preferences--messageCheckoutSuccess--", ecommerceGroupServiceConfiguration.messageCheckoutSuccess());
String messageCheckoutError = ParamUtil.getString(request, "preferences--messageCheckoutError--", ecommerceGroupServiceConfiguration.messageCheckoutError());
String messageCartEmpty = ParamUtil.getString(request, "preferences--messageCartEmpty--", ecommerceGroupServiceConfiguration.messageCartEmpty());
boolean enablePaypal = ParamUtil.getBoolean(request, "preferences--enablePaypal--", ecommerceGroupServiceConfiguration.enablePaypal());
boolean usePaypalSandbox = ParamUtil.getBoolean(request, "preferences--usePaypalSandbox--", ecommerceGroupServiceConfiguration.usePaypalSandbox());
String paypalBusinessEmailAddress = ParamUtil.getString(request, "preferences--paypalBusinessEmailAddress--", ecommerceGroupServiceConfiguration.paypalBusinessEmailAddress());
%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL">
	<portlet:param name="serviceName" value="<%= EcommerceConfigurationKeys.SERVICE_NAME %>" />
	<portlet:param name="settingsScope" value="group" />
</liferay-portlet:actionURL>

<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />

	<%
	String tabs1Names = "email-from,ecommerce-config-store-email,ecommerce-config-customer-email,messages,paypal";
	%>

	<div class="portlet-configuration-body-content">
		<liferay-ui:tabs
			names="<%= tabs1Names %>"
			refresh="<%= false %>"
			type="tabs nav-tabs-default"
		>
		
		<liferay-ui:error key="storeName" message="please-enter-a-valid-name" />
		<liferay-ui:error key="storeEmailAddress" message="please-enter-a-valid-email-address" />
		
			<liferay-ui:section>
				<div class="container-fluid-1280">
					<aui:fieldset-group markupView="lexicon">
						<aui:fieldset>
							<aui:input cssClass="lfr-input-text-container" label="name" name="preferences--storeName--" type="text" value="<%= storeName %>" required="true"/>
							<aui:input cssClass="lfr-input-text-container" label="address" name="preferences--storeEmailAddress--" type="text" value="<%= storeEmailAddress %>" required="true"/>

						</aui:fieldset>
					</aui:fieldset-group>
				</div>
			</liferay-ui:section>
			
			<%
			Map<String, String> emailDefinitionTerms =  EmailNotificationUtil.getEmailDefinitionTerms(locale, storeEmailAddress, storeName);
			%>

			<liferay-ui:section>
				<div class="container-fluid-1280">
					<aui:fieldset-group markupView="lexicon">
						<liferay-frontend:email-notification-settings
							emailBodyLocalizedValuesMap="<%= ecommerceGroupServiceConfiguration.storeEmailBody() %>"
							emailDefinitionTerms="<%= emailDefinitionTerms %>"
							emailEnabled="<%= ecommerceGroupServiceConfiguration.storeEmailEnabled() %>"
							emailParam="storeEmail"
							emailSubjectLocalizedValuesMap="<%= ecommerceGroupServiceConfiguration.storeEmailSubject() %>"
						/>
					</aui:fieldset-group>
				</div>
			</liferay-ui:section>
			
			<liferay-ui:section>
				<div class="container-fluid-1280">
					<aui:fieldset-group markupView="lexicon">
						<liferay-frontend:email-notification-settings
							emailBodyLocalizedValuesMap="<%= ecommerceGroupServiceConfiguration.customerEmailBody() %>"
							emailDefinitionTerms="<%= emailDefinitionTerms %>"
							emailEnabled="<%= ecommerceGroupServiceConfiguration.customerEmailEnabled() %>"
							emailParam="customerEmail"
							emailSubjectLocalizedValuesMap="<%= ecommerceGroupServiceConfiguration.customerEmailSubject() %>"
						/>
					</aui:fieldset-group>
				</div>
			</liferay-ui:section>
			
			<liferay-ui:section>
				<div class="container-fluid-1280">
					<aui:fieldset-group markupView="lexicon">
						<aui:fieldset>
							<aui:input cssClass="lfr-input-text-container" label="ecommerce-config-checkout-success-message" name="preferences--messageCheckoutSuccess--" type="text" value="<%= messageCheckoutSuccess %>" required="true"/>
							<aui:input cssClass="lfr-input-text-container" label="ecommerce-config-checkout-error-message" name="preferences--messageCheckoutError--" type="text" value="<%= messageCheckoutError %>" required="true"/>
							<aui:input cssClass="lfr-input-text-container" label="ecommerce-config-car-empty-message" name="preferences--messageCartEmpty--" type="text" value="<%= messageCartEmpty %>" required="true"/>
						</aui:fieldset>
					</aui:fieldset-group>
				</div>
			</liferay-ui:section>
						<liferay-ui:section>
				<div class="container-fluid-1280">
					<aui:fieldset-group markupView="lexicon">
						<aui:fieldset>
							<aui:input cssClass="lfr-input-text-container" label="ecommerce-config-enable-paypal" name="preferences--enablePaypal--" type="checkbox" value="<%= enablePaypal %>" />
							<aui:input cssClass="lfr-input-text-container" label="ecommerce-config-enable-usePaypalSandbox" name="preferences--usePaypalSandbox--" type="checkbox" value="<%= usePaypalSandbox %>" />
							<aui:input cssClass="lfr-input-text-container" label="ecommerce-config-paypal-business-email" name="preferences--paypalBusinessEmailAddress--" type="text" value="<%= paypalBusinessEmailAddress %>" >
								<aui:validator name="required">
					                function() {
					                        return AUI.$('#<portlet:namespace />enablePaypal').prop('checked');
					                }
						        </aui:validator>
							</aui:input>

						</aui:fieldset>
					</aui:fieldset-group>
				</div>
			</liferay-ui:section>
		
		</liferay-ui:tabs>
	</div>

	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" />
	</aui:button-row>
</aui:form>