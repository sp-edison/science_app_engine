<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@ include file="/html/portlet/login/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

String openId = ParamUtil.getString(request, "openId");
boolean male = ParamUtil.getBoolean(request, "male", true);

Calendar birthdayCalendar = CalendarFactoryUtil.getCalendar();

birthdayCalendar.set(Calendar.MONTH, Calendar.JANUARY);
birthdayCalendar.set(Calendar.DATE, 1);
birthdayCalendar.set(Calendar.YEAR, 1970);
%>

<portlet:actionURL secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="createAccountURL">
	<portlet:param name="struts_action" value="/login/create_account" />
</portlet:actionURL>
<portlet:resourceURL var="resourceURL">
</portlet:resourceURL>	


<!-- aui:form action="<%= createAccountURL %>" method="post"  name="fm" id="fm" -->
<aui:form action="#"  name="fm" id="fm" >
	<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="openId" type="hidden" value="<%= openId %>" />

	<liferay-ui:error exception="<%= AddressCityException.class %>" message="please-enter-a-valid-city" />
	<liferay-ui:error exception="<%= AddressStreetException.class %>" message="please-enter-a-valid-street" />
	<liferay-ui:error exception="<%= AddressZipException.class %>" message="please-enter-a-valid-postal-code" />
	<liferay-ui:error exception="<%= CaptchaMaxChallengesException.class %>" message="maximum-number-of-captcha-attempts-exceeded" />
	<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
	<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-create-user-account-because-the-maximum-number-of-users-has-been-reached" />
	<liferay-ui:error exception="<%= ContactFirstNameException.class %>" message="please-enter-a-valid-first-name" />
	<liferay-ui:error exception="<%= ContactFullNameException.class %>" message="please-enter-a-valid-first-middle-and-last-name" />
	<liferay-ui:error exception="<%= ContactLastNameException.class %>" message="please-enter-a-valid-last-name" />
	<liferay-ui:error exception="<%= DuplicateOpenIdException.class %>" message="a-user-with-that-open-id-already-exists" />
	<liferay-ui:error exception="<%= DuplicateUserEmailAddressException.class %>" message="the-email-address-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= DuplicateUserIdException.class %>" message="the-user-id-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= DuplicateUserScreenNameException.class %>" message="the-screen-name-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= EmailAddressException.class %>" message="please-enter-a-valid-email-address" />

	<liferay-ui:error exception="<%= GroupFriendlyURLException.class %>">

		<%
		GroupFriendlyURLException gfurle = (GroupFriendlyURLException)errorException;
		%>

		<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.DUPLICATE %>">
			<liferay-ui:message key="the-screen-name-you-requested-is-associated-with-an-existing-friendly-url" />
		</c:if>
	</liferay-ui:error>

	<liferay-ui:error exception="<%= NoSuchCountryException.class %>" message="please-select-a-country" />
	<liferay-ui:error exception="<%= NoSuchListTypeException.class %>" message="please-select-a-type" />
	<liferay-ui:error exception="<%= NoSuchRegionException.class %>" message="please-select-a-region" />
	<liferay-ui:error exception="<%= PhoneNumberException.class %>" message="please-enter-a-valid-phone-number" />
	<liferay-ui:error exception="<%= RequiredFieldException.class %>" message="please-fill-out-all-required-fields" />
	<liferay-ui:error exception="<%= ReservedUserEmailAddressException.class %>" message="the-email-address-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= ReservedUserIdException.class %>" message="the-user-id-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= ReservedUserScreenNameException.class %>" message="the-screen-name-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= TermsOfUseException.class %>" message="you-must-agree-to-the-terms-of-use" />
	<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="please-enter-a-valid-email-address" />
	<liferay-ui:error exception="<%= UserIdException.class %>" message="please-enter-a-valid-user-id" />

	<liferay-ui:error exception="<%= UserPasswordException.class %>">

		<%
		UserPasswordException upe = (UserPasswordException)errorException;
		%>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_CONTAINS_TRIVIAL_WORDS %>">
			<liferay-ui:message key="that-password-uses-common-words-please-enter-in-a-password-that-is-harder-to-guess-i-e-contains-a-mix-of-numbers-and-letters" />
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_INVALID %>">
			<liferay-ui:message key="that-password-is-invalid-please-enter-in-a-different-password" />
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_LENGTH %>">

			<%
			PasswordPolicy passwordPolicy = PasswordPolicyLocalServiceUtil.getDefaultPasswordPolicy(company.getCompanyId());
			%>

			<%= LanguageUtil.format(pageContext, "that-password-is-too-short-or-too-long-please-make-sure-your-password-is-between-x-and-512-characters", String.valueOf(passwordPolicy.getMinLength()), false) %>
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_TOO_TRIVIAL %>">
			<liferay-ui:message key="that-password-is-too-trivial" />
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORDS_DO_NOT_MATCH %>">
			<liferay-ui:message key="the-passwords-you-entered-do-not-match-each-other-please-re-enter-your-password" />
		</c:if>
	</liferay-ui:error>

	<liferay-ui:error exception="<%= UserScreenNameException.class %>" message="please-enter-a-valid-screen-name" />
	<liferay-ui:error exception="<%= WebsiteURLException.class %>" message="please-enter-a-valid-url" />

	<c:if test='<%= SessionMessages.contains(request, "openIdUserInformationMissing") %>'>
		<div class="alert alert-info">
			<liferay-ui:message key="you-have-successfully-authenticated-please-provide-the-following-required-information-to-access-the-portal" />
		</div>
	</c:if>
	
	<aui:model-context model="<%= Contact.class %>" />

	<aui:fieldset column="<%= true %>">
		<aui:col width="<%= 30 %>">
			<aui:fieldset  label="science-platform-user-mandatorys">
				<c:if test="<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE) %>">
					<aui:input autoFocus="<%= true %>" model="<%= User.class %>" name="screenName"  label="science-platform-user-screen-name" id="screenName"/>
				</c:if>
	
				<%@ include file="/html/portlet/login/create_account_user_name.jspf" %>
	
				<aui:input model="<%= User.class %>" name="emailAddress" label="science-platform-user-email">
					<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED) %>">
						<aui:validator name="required" />
					</c:if>
				</aui:input>
			</aui:fieldset>
		</aui:col>
		<aui:col width="<%= 30 %>">
			<aui:fieldset  label="science-platform-user-options">
				<aui:select label="science-platform-user-country" name="countryId"  id="countryId" >
					<%
						List<Country> countryList = CountryServiceUtil.getCountries();
						
						for(int i = 0; i < countryList.size(); i++){ 
	        				Country option = countryList.get(i);
	        				boolean selected = false;
	        				//System.out.println(option.getA2()+":"+locale.getCountry());
	        				if(option.getA2().equalsIgnoreCase(locale.getCountry())){
	            				selected = true;
	        				}
	        		%>
	        				<aui:option value="<%=option.getCountryId()%>" selected="<%=selected %>" >
	        					<%=option.getName(locale) %> 
	        				</aui:option>
	    			<% } %>
				</aui:select>
				
				<div id="<portlet:namespace/>selectRegionDiv" >
				</div>
				
				<div id="<portlet:namespace/>selectAffiliationDiv" >
				</div>
	
				<c:if test="<%= PropsValues.CAPTCHA_CHECK_PORTAL_CREATE_ACCOUNT %>">
					<portlet:resourceURL var="captchaURL">
						<portlet:param name="struts_action" value="/login/captcha" />
					</portlet:resourceURL>
	
					<liferay-ui:captcha url="<%= captchaURL %>" />
				</c:if>
			</aui:fieldset>
		</aui:col>
		<aui:col width="<%= 30 %>">
			<div id="<portlet:namespace/>selectDomain" ></div>
		</aui:col>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" value="submit" id="submit"></aui:button>
	</aui:button-row>
</aui:form>

<liferay-util:include page="/html/portlet/login/navigation.jsp" />

<aui:script use="aui-base, aui-io-request, aui-node, aui-nodelist">
	var A = AUI();
	
	Liferay.provide(
		window,
		"<portlet:namespace/>getRegionStringList",
		function(countryId){
			//alert(countryId);
			var regionDiv = A.one("#<portlet:namespace/>selectRegionDiv");
			regionDiv.empty();
			
			A.io.request(
				'<%=resourceURL.toString()%>',
				{
					method:'post',
					dataType: 'json',
					data:{
						<portlet:namespace/>method:"getRegionStrList",
						<portlet:namespace/>countryId:countryId
					},
					on:{
						success: function(){
							var regionStrList = this.get("responseData");
							if(regionStrList.length > 0){
								//alert(regionStrList);
								var selectLavel = A.Node.create("<label for='<portlet:namespace/>regionId'><liferay-ui:message key='science-platform-user-region'/></label>");
								regionDiv.append(selectLavel);
								var select = A.Node.create('<select name="<portlet:namespace/>regionId" id="<portlet:namespace/>regionId"></select>');
								regionDiv.append(select);
	
								for(var  i=0; i < regionStrList.length; i++){
									var region = regionStrList[i];
									var option;
									if( i == 0)
										option= A.Node.create("<option selected value='"+region.regionId+"'>"+region.regionName+"</option>");
									else
									 	option= A.Node.create("<option value='"+region.regionId+"'>"+region.regionName+"</option>");
									select.append(option);
									//console.log("regionId:"+region.regionId);
								}
							}
						}
					}
				}
			);
		}
	);
	
	Liferay.provide(
		window,
		"<portlet:namespace/>getAffiliationStringList",
		function(countryId, regionId, target){
			//alert(countryId);
			A.io.request(
				'<%=resourceURL.toString()%>',
				{
					method:'post',
					dataType: 'json',
					data:{
						<portlet:namespace/>method:"getAffiliationStrList",
						<portlet:namespace/>countryId:countryId,
						<portlet:namespace/>regionId:regionId,
						<portlet:namespace/>target:target
					},
					on:{
						success: function(){
							var affiliationDiv = A.one("#<portlet:namespace/>selectAffiliationDiv");
							affiliationDiv.empty();
							var affiliationStrList = this.get("responseData");
							if(affiliationStrList.length > 0){
								//alert(affiliationStrList);
								var selectLavel = A.Node.create("<label for='<portlet:namespace/>affiliationId'><liferay-ui:message key='science-platform-user-affiliation'/></label>");
								affiliationDiv.append(selectLavel);
								var select = A.Node.create('<select name="<portlet:namespace/>affiliationId" id="<portlet:namespace/>affiliationId"></select>');
								affiliationDiv.append(select);
	
								for(var  i=0; i < affiliationStrList.length; i++){
									var affiliation = affiliationStrList[i];
									var option;
									if( i == 0)
										option= A.Node.create("<option selected value='"+affiliation.affiliationId+"'>"+affiliation.affiliationName+"</option>");
									else
									 	option= A.Node.create("<option value='"+affiliation.affiliationId+"'>"+affiliation.affiliationName+"</option>");
									//console.log("affiliationId:"+affiliation.affiliationId);
									select.append(option);
								}
							}
						}
					}
				}
			);
		}
	);
	
	Liferay.provide(
		window,
		"<portlet:namespace/>getDomainStringList",
		function(){
			//alert(countryId);
			A.io.request(
				'<%=resourceURL.toString()%>',
				{
					method:'post',
					dataType: 'json',
					data:{
						<portlet:namespace/>method:"getDomainStrList"
					},
					on:{
						success: function(){
							var domainDiv = A.one("#<portlet:namespace/>selectDomain");
							domainDiv.empty();
							var fieldSet = A.Node.create("<fieldset></fieldset>");
							fieldSet.append(A.Node.create("<legend class='fieldset-legend'><liferay-ui:message key='science-platform-user-domains'/></legend>"));
							var domainStrList = this.get("responseData");
							if(domainStrList.length > 0){
								for(var  i=0; i < domainStrList.length; i++){
									var domain = domainStrList[i];
									//alert(domain.domainName);
									var checkBox = A.Node.create("<input type='checkbox' name='<portlet:namespace/>domainId'  value='"+domain.domainId+"'>"+domain.domainName+"</input><br>");
									
									//Commented lines donot working and I don't know why! 
									//var checkBox = A.Node.create("<input type='checkbox'>"+domain.domainName+"</input><br>");
									//checkBox.attr("name", "<portlet:namespace/>domain_"+i);
									//checkBox.attr("value", domain.domainId);
									
									fieldSet.append(checkBox);
								}
							}
							domainDiv.append(fieldSet);
						}
					}
				}
			);
		}
	);
	
	Liferay.provide(
		window,
		"<portlet:namespace/>submit",
		function(){
			var domainDiv = A.one("#<portlet:namespace/>selectDomain");
			var checkedDomains = domainDiv.all(':checkbox:checked');
			var domainIds = [];
			var i=0;
			checkedDomains.each(function(checkbox){
				//alert(checkbox.attr("value"));
				domainIds[i] = checkbox.attr("value");
				i++;
			});
			
			//alert("Region: "+A.one('#<portlet:namespace/>regionId').attr("value"));
			//alert("Affiliation: "+A.one('#<portlet:namespace/>affiliationId').attr("value"));
			
			A.io.request(
				'<%= createAccountURL.toString() %>',
				{
					method:'post',
					form:{id:"<portlet:namespace/>fm"},
					data:{
						<portlet:namespace/>domainIds:domainIds
					}
				}
			);
		}
	);

	A.on("domready", function(event){
		window.<portlet:namespace/>getRegionStringList(A.one('#<portlet:namespace/>countryId').attr('value'));
		window.<portlet:namespace/>getAffiliationStringList( 0, 0, "all");
		window.<portlet:namespace/>getDomainStringList();
	});
		
	A.one('#<portlet:namespace/>countryId').on('change', function (){
		//alert(A.one('#<portlet:namespace/>countryCode').attr('value'));
		window.<portlet:namespace/>getRegionStringList(A.one('#<portlet:namespace/>countryId').attr('value'));
	});
	
	A.one('#submit').on('click', function (){
		window.<portlet:namespace/>submit();
	});	
</aui:script>

