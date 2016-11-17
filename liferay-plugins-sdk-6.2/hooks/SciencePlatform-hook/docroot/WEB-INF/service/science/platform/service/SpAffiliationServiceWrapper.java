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
 * Provides a wrapper for {@link SpAffiliationService}.
 *
 * @author Jerry h. Seo
 * @see SpAffiliationService
 * @generated
 */
public class SpAffiliationServiceWrapper implements SpAffiliationService,
	ServiceWrapper<SpAffiliationService> {
	public SpAffiliationServiceWrapper(
		SpAffiliationService spAffiliationService) {
		_spAffiliationService = spAffiliationService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spAffiliationService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spAffiliationService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spAffiliationService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public science.platform.model.SpAffiliation createSpAffiliation(
		long countryId, long regionId, java.lang.String affiliationCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationService.createSpAffiliation(countryId, regionId,
			affiliationCode);
	}

	@Override
	public java.util.List<science.platform.model.SpAffiliation> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationService.getAll();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getAllAffiliationsJSON(
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationService.getAllAffiliationsJSON(locale);
	}

	@Override
	public java.util.List<science.platform.model.SpAffiliation> getSpAffiliationListByCountryId(
		long countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationService.getSpAffiliationListByCountryId(countryId);
	}

	@Override
	public java.util.List<science.platform.model.SpAffiliation> getSpAffiliationListByRegionId(
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationService.getSpAffiliationListByRegionId(regionId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getAffiliationNamesByCountryId(
		long countryId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationService.getAffiliationNamesByCountryId(countryId,
			locale);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getAffiliationNamesByRegionId(
		long regionId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationService.getAffiliationNamesByRegionId(regionId,
			locale);
	}

	@Override
	public boolean isExist(long regionId, java.lang.String affiliationCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationService.isExist(regionId, affiliationCode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SpAffiliationService getWrappedSpAffiliationService() {
		return _spAffiliationService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSpAffiliationService(
		SpAffiliationService spAffiliationService) {
		_spAffiliationService = spAffiliationService;
	}

	@Override
	public SpAffiliationService getWrappedService() {
		return _spAffiliationService;
	}

	@Override
	public void setWrappedService(SpAffiliationService spAffiliationService) {
		_spAffiliationService = spAffiliationService;
	}

	private SpAffiliationService _spAffiliationService;
}