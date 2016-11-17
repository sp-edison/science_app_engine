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
 * Provides the remote service utility for SpUserDomain. This utility wraps
 * {@link science.platform.service.impl.SpUserDomainServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Jerry h. Seo
 * @see SpUserDomainService
 * @see science.platform.service.base.SpUserDomainServiceBaseImpl
 * @see science.platform.service.impl.SpUserDomainServiceImpl
 * @generated
 */
public class SpUserDomainServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link science.platform.service.impl.SpUserDomainServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static science.platform.model.SpUserDomain createSpUserDomain(
		long spUserId, long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createSpUserDomain(spUserId, spDomainId);
	}

	public static java.util.List<science.platform.model.SpUserDomain> createSpUserDomains(
		long spUserId, long[] spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createSpUserDomains(spUserId, spDomainId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getDomainNames(
		long userId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDomainNames(userId, locale);
	}

	public static boolean isExist(long spUserId, long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().isExist(spUserId, spDomainId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SpUserDomainService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SpUserDomainService.class.getName());

			if (invokableService instanceof SpUserDomainService) {
				_service = (SpUserDomainService)invokableService;
			}
			else {
				_service = new SpUserDomainServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SpUserDomainServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SpUserDomainService service) {
	}

	private static SpUserDomainService _service;
}