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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for SpUser. This utility wraps
 * {@link science.platform.service.impl.SpUserServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Jerry h. Seo
 * @see SpUserService
 * @see science.platform.service.base.SpUserServiceBaseImpl
 * @see science.platform.service.impl.SpUserServiceImpl
 * @generated
 */
public class SpUserServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link science.platform.service.impl.SpUserServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static long countUsersByDomain(java.lang.String domainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countUsersByDomain(domainCode);
	}

	public static java.util.List<science.platform.model.SpDomain> getDomainsByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDomainsByUserId(userId);
	}

	public static science.platform.model.SpUser addSpUser(
		science.platform.model.SpUser spUser, long[] domainIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSpUser(spUser, domainIds);
	}

	public static com.liferay.portal.model.User deleteUser(long spUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUser(spUserId);
	}

	public static science.platform.model.SpUser deleteSpUser(long spUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSpUser(spUserId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getUserInfo(
		long userId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserInfo(userId, locale);
	}

	public static science.platform.model.SpUser updateSpUser(
		science.platform.model.SpUser spUser, long[] domainIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSpUser(spUser, domainIds);
	}

	public static science.platform.model.SpUser addUserWithWorkflow(
		long companyId, boolean autoPassword, java.lang.String password1,
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
		return getService()
				   .addUserWithWorkflow(companyId, autoPassword, password1,
			password2, autoScreenName, screenName, emailAddress, facebookId,
			openId, locale, jsonFirstName, jsonMiddleName, jsonLastName,
			prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear,
			jobTitle, groupIds, organizationIds, roleIds, userGroupIds,
			sendEmail, countryId, regionId, affiliationId, domainIds,
			serviceContext);
	}

	public static com.liferay.portal.model.User getUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUser(userId);
	}

	public static com.liferay.portal.model.User getUser(
		science.platform.model.SpUser user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUser(user);
	}

	public static void clearService() {
		_service = null;
	}

	public static SpUserService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SpUserService.class.getName());

			if (invokableService instanceof SpUserService) {
				_service = (SpUserService)invokableService;
			}
			else {
				_service = new SpUserServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SpUserServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SpUserService service) {
	}

	private static SpUserService _service;
}