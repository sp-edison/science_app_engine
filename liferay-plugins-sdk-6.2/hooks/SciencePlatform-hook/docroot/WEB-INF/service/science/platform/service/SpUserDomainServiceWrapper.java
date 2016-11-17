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
 * Provides a wrapper for {@link SpUserDomainService}.
 *
 * @author Jerry h. Seo
 * @see SpUserDomainService
 * @generated
 */
public class SpUserDomainServiceWrapper implements SpUserDomainService,
	ServiceWrapper<SpUserDomainService> {
	public SpUserDomainServiceWrapper(SpUserDomainService spUserDomainService) {
		_spUserDomainService = spUserDomainService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spUserDomainService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spUserDomainService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spUserDomainService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public science.platform.model.SpUserDomain createSpUserDomain(
		long spUserId, long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainService.createSpUserDomain(spUserId, spDomainId);
	}

	@Override
	public java.util.List<science.platform.model.SpUserDomain> createSpUserDomains(
		long spUserId, long[] spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainService.createSpUserDomains(spUserId, spDomainId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getDomainNames(
		long userId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainService.getDomainNames(userId, locale);
	}

	@Override
	public boolean isExist(long spUserId, long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainService.isExist(spUserId, spDomainId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SpUserDomainService getWrappedSpUserDomainService() {
		return _spUserDomainService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSpUserDomainService(
		SpUserDomainService spUserDomainService) {
		_spUserDomainService = spUserDomainService;
	}

	@Override
	public SpUserDomainService getWrappedService() {
		return _spUserDomainService;
	}

	@Override
	public void setWrappedService(SpUserDomainService spUserDomainService) {
		_spUserDomainService = spUserDomainService;
	}

	private SpUserDomainService _spUserDomainService;
}