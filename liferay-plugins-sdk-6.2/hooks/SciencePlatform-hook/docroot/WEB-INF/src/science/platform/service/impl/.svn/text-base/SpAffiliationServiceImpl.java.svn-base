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

import science.platform.model.SpAffiliation;
import science.platform.service.base.SpAffiliationServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * The implementation of the sp affiliation remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.localize.user.service.SpAffiliationService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Jerry H. Seo
 * @see com.kisti.localize.user.service.base.SpAffiliationServiceBaseImpl
 * @see com.kisti.localize.user.service.SpAffiliationServiceUtil
 */
public class SpAffiliationServiceImpl extends SpAffiliationServiceBaseImpl {
	public SpAffiliation createSpAffiliation(long countryId, long regionId, String affiliationCode) throws SystemException, PortalException {
		if(this.isExist(regionId, affiliationCode)){
			System.out.println("Affiliation already exist: "+regionId+","+affiliationCode);
			return null;
		};
		
		long newAffiliationId = 0;
		newAffiliationId = super.counterLocalService.increment();
		
		SpAffiliation affiliation = super.spAffiliationPersistence.create(newAffiliationId);
		affiliation.setSpAffiliationCode(affiliationCode);
		affiliation.setSpCountryId(countryId);
		affiliation.setSpRegionId(regionId);
		
		return affiliation;
	}
	
	public List<SpAffiliation> getAll() throws SystemException{
		return super.spAffiliationPersistence.findAll();
	}
	
	public JSONArray getAllAffiliationsJSON(Locale locale) throws SystemException{
		JSONArray jsonAffiliationNames = JSONFactoryUtil.createJSONArray();
		
		List<SpAffiliation> spAffiliations = super.spAffiliationPersistence.findAll();
		for(SpAffiliation affiliation : spAffiliations){
			JSONObject jsonAffiliation = JSONFactoryUtil.createJSONObject();
			jsonAffiliation.put("affiliationId", affiliation.getSpAffiliationId());
			jsonAffiliation.put("affiliationName", affiliation.getSpAffiliationName(locale));
			jsonAffiliationNames.put(jsonAffiliation);
		}
		
		return jsonAffiliationNames;
	}
	
	public List<SpAffiliation> getSpAffiliationListByCountryId(long countryId) throws SystemException{
		return super.spAffiliationPersistence.findByCountryId(countryId);
	}
	
	public List<SpAffiliation> getSpAffiliationListByRegionId(long regionId) throws SystemException{
		return super.spAffiliationPersistence.findByRegionId(regionId);
	}
	
	public JSONArray getAffiliationNamesByCountryId(long countryId, Locale locale) throws SystemException{
		JSONArray jsonAffiliationNames = JSONFactoryUtil.createJSONArray();
		
		List<SpAffiliation> spAffiliations = super.spAffiliationPersistence.findByCountryId(countryId);
		for(SpAffiliation affiliation : spAffiliations){
			JSONObject jsonAffiliation = JSONFactoryUtil.createJSONObject();
			jsonAffiliation.put("affiliationId", affiliation.getSpAffiliationId());
			jsonAffiliation.put("affiliationName", affiliation.getSpAffiliationName(locale));
			jsonAffiliationNames.put(jsonAffiliation);
		}
		
		return jsonAffiliationNames;
	}
	
	public JSONArray getAffiliationNamesByRegionId(long regionId, Locale locale) throws SystemException{
		JSONArray jsonAffiliationNames = JSONFactoryUtil.createJSONArray();
		
		List<SpAffiliation> spAffiliations = super.spAffiliationPersistence.findByRegionId(regionId);
		for(SpAffiliation affiliation : spAffiliations){
			JSONObject jsonAffiliation = JSONFactoryUtil.createJSONObject();
			jsonAffiliation.put("affiliationId", affiliation.getSpAffiliationId());
			jsonAffiliation.put("affiliationName", affiliation.getSpAffiliationName(locale));
			jsonAffiliationNames.put(jsonAffiliation);
		}
		
		return jsonAffiliationNames;
	}
	
	public boolean isExist(long regionId, String affiliationCode) throws SystemException{
		boolean exist = false;

		if(super.spAffiliationPersistence.countByAffiliationCode(regionId, affiliationCode) > 0)
			exist = true;
		
		System.out.println("Affiliation Count["+regionId+","+affiliationCode+"]: "+super.spAffiliationPersistence.countByAffiliationCode(regionId, affiliationCode));
		return exist;
	}
	
	public String AFFILIATION_NOT_READY = "NOT READY";
}