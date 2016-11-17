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

import java.util.List;
import java.util.Locale;

import science.platform.model.SpDomain;
import science.platform.model.SpUserDomain;
import science.platform.service.base.SpDomainLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * The implementation of the sp domain local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.localize.user.service.SpDomainLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see com.kisti.localize.user.service.base.SpDomainLocalServiceBaseImpl
 * @see com.kisti.localize.user.service.SpDomainLocalServiceUtil
 */
public class SpDomainLocalServiceImpl extends SpDomainLocalServiceBaseImpl {
	public SpDomain createSpDomain(String domainCode) throws SystemException{
		
		if(this.isExist(domainCode)){
			throw new SystemException();
		}
		
		SpDomain domain = null;
		long newDomainId = 0;
		
		try {
			domain = super.spDomainPersistence.fetchByDomainCode(domainCode);
		} catch (SystemException e) {
			System.out.println("ERROR: domain code already exists - "+domainCode);
			throw e;
		}
		
		try {
			newDomainId = super.counterLocalService.increment();
		} catch (SystemException e) {
			System.out.println("ERROR: Getting new SpDomain primary key failed.");
			throw e;
		}
		
		domain = super.createSpDomain(newDomainId);
		domain.setSpDomainCode(domainCode);
		
		return domain;
	}
	
	public void addUserDomain(long userId, long domainId) throws SystemException{
		super.spUserDomainLocalService.createSpUserDomain(userId, domainId);
	}
	
	public void addUserDomains(long userId, long domainIds[]) throws SystemException{
		for(int i=0; i<domainIds.length; i++){
			super.spUserDomainLocalService.createSpUserDomain(userId, domainIds[i]);
		}
	}
	
	public List<SpDomain> getAll() throws SystemException{
		return super.spDomainPersistence.findAll();
	}
	
	public JSONArray getAllDomainsJSON(Locale locale) throws SystemException{
		JSONArray domainNames = JSONFactoryUtil.createJSONArray();
		List<SpDomain> domainList = super.spDomainPersistence.findAll();
		
		for(SpDomain domain : domainList){
			JSONObject jsonDomain = JSONFactoryUtil.createJSONObject();
			jsonDomain.put("domainId", domain.getSpDomainId());
			jsonDomain.put("domainName", domain.getSpDomainName(locale));
			domainNames.put(jsonDomain);
		}
		
		return domainNames;
	}
	
	public JSONArray getDomainNamesByUserId(long userId, Locale locale) throws SystemException{
		JSONArray domainNames = JSONFactoryUtil.createJSONArray();
		List<SpUserDomain> domainList = super.spUserDomainPersistence.findBySpUserId(userId);
		
		for(SpUserDomain userDomain : domainList){
			SpDomain domain = super.spDomainPersistence.fetchByPrimaryKey(userDomain.getSpDomainId());
			JSONObject jsonDomain = JSONFactoryUtil.createJSONObject();
			jsonDomain.put("domainId", domain.getSpDomainId());
			jsonDomain.put("domainName", domain.getSpDomainName(locale));
			domainNames.put(jsonDomain);
		}
		
		return domainNames;
	}
	
	public boolean isExist(String domainCode) throws SystemException{
		boolean exist = false;
		if(super.spDomainPersistence.countByDomainCode(domainCode) > 0)
			exist = true;
		
		return exist;
	}
}