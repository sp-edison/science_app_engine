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

import science.platform.model.SpRegion;
import science.platform.service.base.SpRegionLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.RegionServiceUtil;

/**
 * The implementation of the sp region local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.localize.user.service.SpRegionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see com.kisti.localize.user.service.base.SpRegionLocalServiceBaseImpl
 * @see com.kisti.localize.user.service.SpRegionLocalServiceUtil
 */
public class SpRegionLocalServiceImpl extends SpRegionLocalServiceBaseImpl {
	public SpRegion createSpRegion(long countryId, String regionCode ) throws SystemException{
		if(this.isExist(countryId, regionCode))
			throw new SystemException();
		
		long newRegionId = super.counterLocalService.increment(Region.class.getName());
		SpRegion region = super.spRegionPersistence.create(newRegionId);
		
		region.setSpCountryId(countryId);
		region.setSpRegionCode(regionCode);
		
		return region;
	}
	
	public SpRegion fetchSpRegion(long countryId, String regionCode)  throws SystemException{
		return super.spRegionPersistence.fetchByCountryRegionCode(countryId, regionCode);
	}
	
	public List<SpRegion> fetchSpRegions(long countryId) throws SystemException{
		return super.spRegionPersistence.findByCountryId(countryId);
	}
	
	public JSONArray getRegionNames(long countryId, Locale locale) throws SystemException{
		JSONArray jsonRegionNames = JSONFactoryUtil.createJSONArray();

		System.out.println("Region Count: "+super.spRegionPersistence.countByCountryId(countryId));
		if(super.spRegionPersistence.countByCountryId(countryId)<=0){
			List<Region> regions = RegionServiceUtil.getRegions(countryId);
			for(Region region : regions ){
				JSONObject jsonRegionName = JSONFactoryUtil.createJSONObject();
				jsonRegionName.put("regionId", region.getRegionId());
				jsonRegionName.put("regionName", region.getName());
				jsonRegionNames.put(jsonRegionName);
			}
		}
		else{
			List<SpRegion> spRegions = this.fetchSpRegions(countryId);
			for(SpRegion spRegion : spRegions){
				JSONObject jsonRegionName = JSONFactoryUtil.createJSONObject();
				jsonRegionName.put("regionId", spRegion.getSpRegionId());
				System.out.println("Region Name:"+spRegion.getSpRegionName(locale));
				System.out.println("Locale:"+locale.getDisplayCountry());
				jsonRegionName.put("regionName", spRegion.getSpRegionName(locale));
				jsonRegionNames.put(jsonRegionName);
			}
		}
		
		return jsonRegionNames;
	}
	
	public boolean isExist(long countryId, String regionCode) throws SystemException{
		boolean exist = false;
		
		if(super.spRegionPersistence.countByCountryRegionCode(countryId, regionCode) > 0)
			exist = true;
		else{
			if( RegionServiceUtil.fetchRegion(countryId, regionCode) != null)
				exist = true;
		}

		return exist;
	}
}