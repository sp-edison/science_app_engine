/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package science.platform.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SpRegionService}.
 *
 * @author Jerry h. Seo
 * @see SpRegionService
 * @generated
 */
public class SpRegionServiceWrapper implements SpRegionService,
	ServiceWrapper<SpRegionService> {
	public SpRegionServiceWrapper(SpRegionService spRegionService) {
		_spRegionService = spRegionService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spRegionService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spRegionService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spRegionService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public science.platform.model.SpRegion createSpRegion(long countryId,
		java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionService.createSpRegion(countryId, regionCode);
	}

	@Override
	public science.platform.model.SpRegion fetchSpRegion(long countryId,
		java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionService.fetchSpRegion(countryId, regionCode);
	}

	@Override
	public java.util.List<science.platform.model.SpRegion> fetchSpRegions(
		long countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionService.fetchSpRegions(countryId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getRegionNames(
		long countryId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionService.getRegionNames(countryId, locale);
	}

	@Override
	public boolean isExist(long countryId, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionService.isExist(countryId, regionCode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SpRegionService getWrappedSpRegionService() {
		return _spRegionService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSpRegionService(SpRegionService spRegionService) {
		_spRegionService = spRegionService;
	}

	@Override
	public SpRegionService getWrappedService() {
		return _spRegionService;
	}

	@Override
	public void setWrappedService(SpRegionService spRegionService) {
		_spRegionService = spRegionService;
	}

	private SpRegionService _spRegionService;
}