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
 * Provides the remote service utility for SpDomain. This utility wraps
 * {@link science.platform.service.impl.SpDomainServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Jerry h. Seo
 * @see SpDomainService
 * @see science.platform.service.base.SpDomainServiceBaseImpl
 * @see science.platform.service.impl.SpDomainServiceImpl
 * @generated
 */
public class SpDomainServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link science.platform.service.impl.SpDomainServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static science.platform.model.SpDomain createSpDomain(
		java.lang.String domainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createSpDomain(domainCode);
	}

	public static void addUserDomain(long userId, long domainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addUserDomain(userId, domainId);
	}

	public static void addUserDomains(long userId, long[] domainIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addUserDomains(userId, domainIds);
	}

	public static java.util.List<science.platform.model.SpDomain> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAll();
	}

	public static com.liferay.portal.kernel.json.JSONArray getAllDomainsJSON(
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllDomainsJSON(locale);
	}

	public static com.liferay.portal.kernel.json.JSONArray getDomainNamesByUserId(
		long userId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDomainNamesByUserId(userId, locale);
	}

	public static boolean isExist(java.lang.String domainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().isExist(domainCode);
	}

	public static void clearService() {
		_service = null;
	}

	public static SpDomainService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SpDomainService.class.getName());

			if (invokableService instanceof SpDomainService) {
				_service = (SpDomainService)invokableService;
			}
			else {
				_service = new SpDomainServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SpDomainServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SpDomainService service) {
	}

	private static SpDomainService _service;
}