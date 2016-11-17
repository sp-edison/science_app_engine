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
 * Provides a wrapper for {@link SpUserService}.
 *
 * @author Jerry h. Seo
 * @see SpUserService
 * @generated
 */
public class SpUserServiceWrapper implements SpUserService,
	ServiceWrapper<SpUserService> {
	public SpUserServiceWrapper(SpUserService spUserService) {
		_spUserService = spUserService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spUserService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spUserService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spUserService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public long countUsersByDomain(java.lang.String domainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserService.countUsersByDomain(domainCode);
	}

	@Override
	public java.util.List<science.platform.model.SpDomain> getDomainsByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserService.getDomainsByUserId(userId);
	}

	@Override
	public science.platform.model.SpUser addSpUser(
		science.platform.model.SpUser spUser, long[] domainIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserService.addSpUser(spUser, domainIds);
	}

	@Override
	public com.liferay.portal.model.User deleteUser(long spUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spUserService.deleteUser(spUserId);
	}

	@Override
	public science.platform.model.SpUser deleteSpUser(long spUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spUserService.deleteSpUser(spUserId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getUserInfo(long userId,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spUserService.getUserInfo(userId, locale);
	}

	@Override
	public science.platform.model.SpUser updateSpUser(
		science.platform.model.SpUser spUser, long[] domainIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserService.updateSpUser(spUser, domainIds);
	}

	@Override
	public science.platform.model.SpUser addUserWithWorkflow(long companyId,
		boolean autoPassword, java.lang.String password1,
		java.lang.String password2, boolean autoScreenName,
		java.lang.String screenName, java.lang.String emailAddress,
		long facebookId, java.lang.String openId, java.util.Locale locale,
		com.liferay.portal.kernel.json.JSONObject jsonFirstName,
		com.liferay.portal.kernel.json.JSONObject jsonMiddleName,
		com.liferay.portal.kernel.json.JSONObject jsonLastName, int prefixId,
		int suffixId, boolean male, int birthdayMonth, int birthdayDay,
		int birthdayYear, java.lang.String jobTitle, long[] groupIds,
		long[] organizationIds, long[] roleIds, long[] userGroupIds,
		boolean sendEmail, long countryId, long regionId, long affiliationId,
		long[] domainIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spUserService.addUserWithWorkflow(companyId, autoPassword,
			password1, password2, autoScreenName, screenName, emailAddress,
			facebookId, openId, locale, jsonFirstName, jsonMiddleName,
			jsonLastName, prefixId, suffixId, male, birthdayMonth, birthdayDay,
			birthdayYear, jobTitle, groupIds, organizationIds, roleIds,
			userGroupIds, sendEmail, countryId, regionId, affiliationId,
			domainIds, serviceContext);
	}

	@Override
	public com.liferay.portal.model.User getUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spUserService.getUser(userId);
	}

	@Override
	public com.liferay.portal.model.User getUser(
		science.platform.model.SpUser user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spUserService.getUser(user);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SpUserService getWrappedSpUserService() {
		return _spUserService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSpUserService(SpUserService spUserService) {
		_spUserService = spUserService;
	}

	@Override
	public SpUserService getWrappedService() {
		return _spUserService;
	}

	@Override
	public void setWrappedService(SpUserService spUserService) {
		_spUserService = spUserService;
	}

	private SpUserService _spUserService;
}