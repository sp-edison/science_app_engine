/**
 * Copyright (c) 202016-present EDISON, KISTI. All rights reserved.
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

package science.platform.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import science.platform.model.SpAffiliation;
import science.platform.model.SpDomain;
import science.platform.model.SpRegion;
import science.platform.model.SpUser;
import science.platform.model.SpUserDomain;
import science.platform.service.SpUserLocalServiceUtil;
import science.platform.service.base.SpUserLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the sp user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.localize.user.service.SpUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see com.kisti.localize.user.service.base.SpUserLocalServiceBaseImpl
 * @see com.kisti.localize.user.service.SpUserLocalServiceUtil
 */
public class SpUserLocalServiceImpl extends SpUserLocalServiceBaseImpl {
	public long countUsersByDomain(String domainCode) throws SystemException{
		return super.spDomainPersistence.countByDomainCode(domainCode);
	}
	
	public List<SpDomain> getDomainsByUserId(long userId) throws SystemException{
		List<SpUserDomain> userDomains = super.spUserDomainPersistence.findBySpUserId(userId);
		
		List<SpDomain> domains = new ArrayList<SpDomain>();
		for(SpUserDomain userDomain : userDomains){
			SpDomain domain = super.spDomainPersistence.fetchByPrimaryKey(userDomain.getSpDomainId());
			
			domains.add(domain);
		}
		
		return domains;
	}
	
	public SpUser addSpUser(SpUser spUser, long[] domainIds) throws SystemException{
		for(long domainId : domainIds){
			SpUserDomain spUserDomain = super.spUserDomainLocalService.createSpUserDomain(spUser.getSpUserId(), domainId);
			super.spUserDomainLocalService.addSpUserDomain(spUserDomain);
		}
		
		return super.addSpUser(spUser);
	}
	
	public User deleteUser(long spUserId) throws PortalException, SystemException{
		super.deleteSpUser(spUserId);
		super.spUserDomainPersistence.removeBySpUserId(spUserId);
		return super.userLocalService.deleteUser(spUserId);
	}
	
	public SpUser deleteSpUser(long spUserId) throws PortalException, SystemException{
		super.spUserDomainPersistence.removeBySpUserId(spUserId);
		return super.spUserPersistence.remove(spUserId);
	}
	
	public JSONObject getUserInfo(long userId, Locale locale) throws PortalException, SystemException{
		JSONObject jsonUserInfo = JSONFactoryUtil.createJSONObject();
		User user = super.userPersistence.fetchByPrimaryKey(userId);	
		SpUser spUser = super.spUserPersistence.fetchByPrimaryKey(userId);
		
		jsonUserInfo.put("userId", userId);
		jsonUserInfo.put("fullNameXML", spUser.getSpUserFullName());
		jsonUserInfo.put("userFullName", spUser.getSpUserFullName(locale));
		jsonUserInfo.put("email", user.getEmailAddress());
		jsonUserInfo.put("screenName", user.getScreenName());
		
		Country country = CountryServiceUtil.getCountry(spUser.getSpCountryId());
		JSONObject jsonCountry = JSONFactoryUtil.createJSONObject();
		jsonCountry.put("countryId", country.getCountryId());
		jsonCountry.put("countryName", country.getName(locale));
		jsonUserInfo.put("country", jsonCountry);
		
		long regionId = spUser.getSpRegionId();
		JSONObject jsonRegion = JSONFactoryUtil.createJSONObject();
		jsonRegion.put("regionId", regionId);
		SpRegion spRegion = super.spRegionPersistence.fetchByPrimaryKey(regionId);
		if( spRegion != null )
			jsonRegion.put("regionName", spRegion.getSpRegionName(locale));
		else{
			Region region = RegionServiceUtil.getRegion(regionId);
			jsonRegion.put("regionName", region.getName());
		}
		jsonUserInfo.put("region", jsonRegion);
		
		SpAffiliation affiliation = super.spAffiliationPersistence.fetchByPrimaryKey(spUser.getSpAffiliationId());
		JSONObject jsonAffiliation = JSONFactoryUtil.createJSONObject();
		jsonAffiliation.put("affiliationId", affiliation.getSpAffiliationId());
		jsonAffiliation.put("affiliationName", affiliation.getSpAffiliationName(locale));
		jsonUserInfo.put("affiliation", jsonAffiliation);
		
		JSONArray domainList = super.spUserDomainLocalService.getDomainNames(spUser.getPrimaryKey(), locale);
		jsonUserInfo.put("domains", domainList);
		
		return jsonUserInfo;
	}
	
	public SpUser updateSpUser(SpUser spUser, long[] domainIds) throws SystemException{
		super.updateSpUser(spUser);
		
		List<SpUserDomain> spUserDomains = super.spUserDomainPersistence.findBySpUserId(spUser.getSpUserId());
		for(SpUserDomain spUserDomain : spUserDomains){
			boolean unchecked = true;
			for(long domainId : domainIds){
				if(domainId == spUserDomain.getSpDomainId()){
					unchecked = false;
					break;
				}
			}
			
			if(unchecked){
				super.spUserDomainPersistence.remove(spUserDomain);
			}
		}
		
		for(long domainId : domainIds){
			boolean exist = false;
			for(SpUserDomain spUserDomain : spUserDomains){
				if(spUserDomain.getSpDomainId() == domainId){
					exist = true;
					break;
				}
			}
			
			if(exist == false){
				SpUserDomain spUserDomain = super.spUserDomainLocalService.createSpUserDomain(spUser.getSpUserId(), domainId);
				super.spUserDomainLocalService.addSpUserDomain(spUserDomain);
			}
		}
		
		return spUser;
	}
	
	public SpUser addUserWithWorkflow(
				long companyId,
				boolean autoPassword, 
				String password1, 
				String password2,
				boolean autoScreenName, 
				String screenName, 
				String emailAddress, 
				long facebookId, 
				String openId,
				Locale locale, 
				JSONObject jsonFirstName, 
				JSONObject jsonMiddleName, 
				JSONObject jsonLastName, 
				int prefixId,
				int suffixId, 
				boolean male, 
				int birthdayMonth, 
				int birthdayDay, 
				int birthdayYear, 
				String jobTitle,
				long[] groupIds, 
				long[] organizationIds, 
				long[] roleIds, 
				long[] userGroupIds, 
				boolean sendEmail,
				long countryId,
				long regionId,
				long affiliationId,
				long[] domainIds,
				ServiceContext serviceContext
			) throws PortalException, SystemException {
		
			String languageId = serviceContext.getLanguageId();
			User user = super.userLocalService.addUserWithWorkflow(
					0, //creator user id
				companyId, autoPassword, password1, password2,
				autoScreenName, screenName, emailAddress, facebookId, openId,
				locale, jsonFirstName.getString(languageId), "","", prefixId,
				suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle,
				groupIds, organizationIds, roleIds, userGroupIds, sendEmail,
				serviceContext);

			SpUser spUser = super.spUserPersistence.create(user.getUserId());
			Iterator<String> keys = jsonFirstName.keys();
			while(keys.hasNext()){
				String key = keys.next();
				spUser.setSpUserFullName(jsonFirstName.getString(key), new Locale(key));
			}
			spUser.setSpCountryId(countryId);
			spUser.setSpRegionId(regionId);
			spUser.setSpAffiliationId(affiliationId);
			System.out.println("countryId: "+countryId);
			System.out.println("regionId: "+regionId);
			System.out.println("affiliationId: "+affiliationId);
			
			SpUserLocalServiceUtil.addSpUser(spUser);
			
			for(int i=0; i<domainIds.length; i++){
				System.out.println("SelectedDomainId: "+domainIds[i]);
				SpUserDomain userDomain = super.spUserDomainLocalService.createSpUserDomain(spUser.getSpUserId(), domainIds[i]);
				super.spUserDomainLocalService.addSpUserDomain(userDomain);
			}
			
			return spUser;
		}
	
		public User getUser(long userId) throws PortalException, SystemException {
			return super.userLocalService.getUser(userId);
		}
		
		public User getUser(SpUser user) throws PortalException, SystemException{
			return super.userLocalService.getUser(user.getSpUserId());
		}
}