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

<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ include file="/html/portlet/users_admin/init.jsp" %>

<portlet:resourceURL var="resourceURL">
</portlet:resourceURL>	

<%
User selUser = (User)request.getAttribute("user.selUser");
Contact selContact = (Contact)request.getAttribute("user.selContact");

Calendar birthday = CalendarFactoryUtil.getCalendar();

birthday.set(Calendar.MONTH, Calendar.JANUARY);
birthday.set(Calendar.DATE, 1);
birthday.set(Calendar.YEAR, 1970);

if (selContact != null) {
	birthday.setTime(selContact.getBirthday());
}

System.out.println("userInfo in JSP: "+request.getAttribute("userInfo"));
JSONObject userInfoJSON = JSONFactoryUtil.createJSONObject((String)request.getAttribute("userInfo"));

String userNameXML = "";
if( userInfoJSON.has("fullNameXML") )		userNameXML = userInfoJSON.getString("fullNameXML");
else		System.out.println("CRITICAL ERROR: user name does not exist.");

JSONObject countryJSON = null;
if( userInfoJSON.has("country"))	countryJSON = userInfoJSON.getJSONObject("country");
else countryJSON = JSONFactoryUtil.createJSONObject();

JSONObject regionJSON = null;
if( userInfoJSON.has("region"))		regionJSON =userInfoJSON.getJSONObject("region");
else regionJSON = JSONFactoryUtil.createJSONObject();

JSONObject affiliationJSON = null;
if( userInfoJSON.has("affiliation"))	affiliationJSON = userInfoJSON.getJSONObject("affiliation");
else affiliationJSON = JSONFactoryUtil.createJSONObject();

JSONArray domainsJSON = null;
int domainCount = 0;
if( userInfoJSON.has("domains")){
	domainsJSON =userInfoJSON.getJSONArray("domains");
	domainCount = domainsJSON.length();
}
else domainsJSON = JSONFactoryUtil.createJSONArray();
%>

<liferay-ui:error-marker key="errorSection" value="details" />

<aui:model-context bean="<%= selUser %>" model="<%= User.class %>" />

<h3><liferay-ui:message key="details" /></h3>

<div class="row-fluid">
	<!-- aui:fieldset cssClass="span6" -->
	<aui:fieldset column="<%= true %>">
		<aui:col width="<%= 30 %>">
			<aui:fieldset  label="science-platform-user-mandatorys">
				<liferay-ui:success key="verificationEmailSent" message="your-email-verification-code-has-been-sent-and-the-new-email-address-will-be-applied-to-your-account-once-it-has-been-verified" />
		
				<liferay-ui:error exception="<%= DuplicateUserScreenNameException.class %>" focusField="screenName" message="the-screen-name-you-requested-is-already-taken" />
		
				<liferay-ui:error exception="<%= GroupFriendlyURLException.class %>" focusField="screenName">
		
					<%
					GroupFriendlyURLException gfurle = (GroupFriendlyURLException)errorException;
					%>
		
					<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.DUPLICATE %>">
						<liferay-ui:message key="the-screen-name-you-requested-is-associated-with-an-existing-friendly-url" />
					</c:if>
				</liferay-ui:error>
		
				<liferay-ui:error exception="<%= ReservedUserScreenNameException.class %>" focusField="screenName" message="the-screen-name-you-requested-is-reserved" />
		
				<liferay-ui:error exception="<%= UserFieldException.class %>">
		
					<%
					UserFieldException ufe = (UserFieldException)errorException;
		
					StringBundler sb = new StringBundler();
		
					List<String> fields = ufe.getFields();
		
					for (int i = 0; i < fields.size(); i++) {
						String field = fields.get(i);
		
						sb.append(LanguageUtil.get(pageContext, TextFormatter.format(field, TextFormatter.K)));
		
						if ((i + 1) < fields.size()) {
							sb.append(StringPool.COMMA_AND_SPACE);
						}
					}
					%>
		
					<liferay-ui:message arguments="<%= sb.toString() %>" key="your-portal-administrator-has-disabled-the-ability-to-modify-the-following-fields" />
				</liferay-ui:error>
		
				<liferay-ui:error exception="<%= UserScreenNameException.class %>" focusField="screenName" message="please-enter-a-valid-screen-name" />
		
				<c:if test="<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE) || (selUser != null) %>">
					<c:choose>
						<c:when test='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE) || !UsersAdminUtil.hasUpdateFieldPermission(permissionChecker, user, selUser, "screenName") %>'>
							<aui:input disabled="<%= true %>" name="screenName" />
						</c:when>
						<c:otherwise>
							<aui:input name="screenName" />
						</c:otherwise>
					</c:choose>
				</c:if>
		
				<liferay-ui:error exception="<%= DuplicateUserEmailAddressException.class %>" focusField="emailAddress" message="the-email-address-you-requested-is-already-taken" />
				<liferay-ui:error exception="<%= ReservedUserEmailAddressException.class %>" focusField="emailAddress" message="the-email-address-you-requested-is-reserved" />
				<liferay-ui:error exception="<%= UserEmailAddressException.class %>" focusField="emailAddress" message="please-enter-a-valid-email-address" />
		
				<c:choose>
					<c:when test='<%= !UsersAdminUtil.hasUpdateFieldPermission(permissionChecker, user, selUser, "emailAddress") %>'>
						<aui:input disabled="<%= true %>" name="emailAddress" />
					</c:when>
					<c:otherwise>
		
						<%
						User displayEmailAddressUser = null;
		
						if (selUser != null) {
							displayEmailAddressUser = (User)selUser.clone();
		
							displayEmailAddressUser.setEmailAddress(displayEmailAddressUser.getDisplayEmailAddress());
						}
						%>
		
						<aui:input bean="<%= displayEmailAddressUser %>" model="<%= User.class %>" name="emailAddress">
							<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED) %>">
								<aui:validator name="required" />
							</c:if>
						</aui:input>
					</c:otherwise>
				</c:choose>
		
				<%@ include file="/html/portlet/users_admin/user/details_user_name.jspf" %>
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
	        				if(countryJSON.has("countryId") && option.getCountryId() == countryJSON.getLong("countryId")){
	            				selected = true;
	        				}
	        				else if(option.getA2().equalsIgnoreCase(locale.getCountry())){
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
	
			</aui:fieldset>
		</aui:col>
		<aui:col width="<%= 30 %>">
			<div id="<portlet:namespace/>selectDomain" ></div>
		</aui:col>
	</aui:fieldset>

	<!-- aui:fieldset cssClass="span5"-->
	<aui:fieldset>
		<div>
			<c:if test="<%= selUser != null %>">
				<c:choose>
					<c:when test='<%= UsersAdminUtil.hasUpdateFieldPermission(permissionChecker, user, selUser, "portrait") %>'>
						<portlet:renderURL var="editUserPortraitURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
							<portlet:param name="struts_action" value="/users_admin/edit_user_portrait" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
							<portlet:param name="p_u_i_d" value="<%= String.valueOf(selUser.getUserId()) %>" />
							<portlet:param name="portrait_id" value="<%= String.valueOf(selUser.getPortraitId()) %>" />
						</portlet:renderURL>

						<liferay-ui:logo-selector
							currentLogoURL="<%= selUser.getPortraitURL(themeDisplay) %>"
							defaultLogoURL="<%= UserConstants.getPortraitURL(themeDisplay.getPathImage(), selUser.isMale(), 0) %>"
							editLogoURL="<%= editUserPortraitURL %>"
							imageId="<%= selUser.getPortraitId() %>"
							logoDisplaySelector=".user-logo"
						/>
					</c:when>
					<c:otherwise>
						<img alt="<liferay-ui:message key="portrait" />" src="<%= selUser.getPortraitURL(themeDisplay) %>" />
					</c:otherwise>
				</c:choose>
			</c:if>
		</div>

		<c:if test="<%= selUser != null %>">
			<liferay-ui:error exception="<%= DuplicateUserIdException.class %>" message="the-user-id-you-requested-is-already-taken" />
			<liferay-ui:error exception="<%= ReservedUserIdException.class %>" message="the-user-id-you-requested-is-reserved" />
			<liferay-ui:error exception="<%= UserIdException.class %>" message="please-enter-a-valid-user-id" />

			<aui:field-wrapper name="userId">
				<liferay-ui:input-resource url="<%= String.valueOf(selUser.getUserId()) %>" />

				<aui:input name="userId" type="hidden" value="<%= selUser.getUserId() %>" />
			</aui:field-wrapper>
		</c:if>

	</aui:fieldset>
</div>

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
									var myRegionId = '<%= regionJSON.getLong("regionId") %>';
									var option;
									if(region.regionId == myRegionId)
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
									var myAffiliationId = '<%= affiliationJSON.getLong("affiliationId") %>';
									var option;
									if( affiliation.affiliationId == myAffiliationId)
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
									var myDomains = JSON.parse('<%= domainsJSON.toString() %>');
									console.log("Domains: "+myDomains.length);
									var checkBox = null;
									for( var j = 0; j < myDomains.length; j++){
										var myDomain = myDomains[j];
										if(domain.domainId == myDomain.domainId){
											checkBox = A.Node.create("<input type='checkbox' name='<portlet:namespace/>domainId'  value='"+domain.domainId+"' checked='checked'>"+domain.domainName+"</input><br>");
											break;
										}
									}
									if(checkBox == null)
									 	checkBox = A.Node.create("<input type='checkbox' name='<portlet:namespace/>domainId'  value='"+domain.domainId+"'>"+domain.domainName+"</input><br>");
									
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
	
	A.on("domready", function(event){
		console.log("Set the options");
		window.<portlet:namespace/>getRegionStringList(A.one('#<portlet:namespace/>countryId').attr('value'));
		window.<portlet:namespace/>getAffiliationStringList( 0, 0, "all");
		window.<portlet:namespace/>getDomainStringList();
	});
		
	A.one('#<portlet:namespace/>countryId').on('change', function (){
		//alert(A.one('#<portlet:namespace/>countryCode').attr('value'));
		window.<portlet:namespace/>getRegionStringList(A.one('#<portlet:namespace/>countryId').attr('value'));
	});
	
</aui:script>
