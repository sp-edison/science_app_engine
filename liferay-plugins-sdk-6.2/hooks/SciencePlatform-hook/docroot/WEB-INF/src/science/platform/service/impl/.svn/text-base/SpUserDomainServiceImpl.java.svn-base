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
import java.util.List;
import java.util.Locale;

import science.platform.model.SpDomain;
import science.platform.model.SpUserDomain;
import science.platform.service.base.SpUserDomainServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * The implementation of the sp user domain remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.localize.user.service.SpUserDomainService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Jerry H. Seo
 * @see com.kisti.localize.user.service.base.SpUserDomainServiceBaseImpl
 * @see com.kisti.localize.user.service.SpUserDomainServiceUtil
 */
public class SpUserDomainServiceImpl extends SpUserDomainServiceBaseImpl {
	public SpUserDomain createSpUserDomain(long spUserId, long spDomainId) throws SystemException {
		if(this.isExist(spUserId, spDomainId)){
			throw new SystemException();
		}
		
		SpUserDomain userDomain = null;
		long newUserDomainId = 0;
		
		try {
			newUserDomainId = super.counterLocalService.increment();
		} catch (SystemException e) {
			System.out.println("ERROR: Getting new SpUserDomain primary key failed.");
			throw e;
		}
		
		userDomain = super.spUserDomainPersistence.create(newUserDomainId);
		userDomain.setSpUserId(spUserId);
		userDomain.setSpDomainId(spDomainId);
		
		return userDomain;
	}
	
	public List<SpUserDomain> createSpUserDomains(long spUserId, long[] spDomainId) throws SystemException {
		List<SpUserDomain> domainList = new ArrayList<SpUserDomain>();
		
		for(long domainId : spDomainId){
			domainList.add(this.createSpUserDomain(spUserId, domainId));
		}
		
		return domainList;
	}
	
	public JSONArray getDomainNames(long userId, Locale locale) throws SystemException{
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
	
	public boolean isExist(long spUserId, long spDomainId) throws SystemException{
		boolean exist = false;
		if(super.spUserDomainPersistence.countBySpUserDomainId(spUserId, spDomainId) > 0)
			exist = true;
		
		return exist;
	}
}