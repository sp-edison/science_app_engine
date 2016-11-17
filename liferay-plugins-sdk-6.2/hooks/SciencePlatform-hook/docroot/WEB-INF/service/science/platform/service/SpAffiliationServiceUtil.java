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
 * Provides the remote service utility for SpAffiliation. This utility wraps
 * {@link science.platform.service.impl.SpAffiliationServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Jerry h. Seo
 * @see SpAffiliationService
 * @see science.platform.service.base.SpAffiliationServiceBaseImpl
 * @see science.platform.service.impl.SpAffiliationServiceImpl
 * @generated
 */
public class SpAffiliationServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link science.platform.service.impl.SpAffiliationServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static science.platform.model.SpAffiliation createSpAffiliation(
		long countryId, long regionId, java.lang.String affiliationCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .createSpAffiliation(countryId, regionId, affiliationCode);
	}

	public static java.util.List<science.platform.model.SpAffiliation> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAll();
	}

	public static com.liferay.portal.kernel.json.JSONArray getAllAffiliationsJSON(
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllAffiliationsJSON(locale);
	}

	public static java.util.List<science.platform.model.SpAffiliation> getSpAffiliationListByCountryId(
		long countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSpAffiliationListByCountryId(countryId);
	}

	public static java.util.List<science.platform.model.SpAffiliation> getSpAffiliationListByRegionId(
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSpAffiliationListByRegionId(regionId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getAffiliationNamesByCountryId(
		long countryId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAffiliationNamesByCountryId(countryId, locale);
	}

	public static com.liferay.portal.kernel.json.JSONArray getAffiliationNamesByRegionId(
		long regionId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAffiliationNamesByRegionId(regionId, locale);
	}

	public static boolean isExist(long regionId,
		java.lang.String affiliationCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().isExist(regionId, affiliationCode);
	}

	public static void clearService() {
		_service = null;
	}

	public static SpAffiliationService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SpAffiliationService.class.getName());

			if (invokableService instanceof SpAffiliationService) {
				_service = (SpAffiliationService)invokableService;
			}
			else {
				_service = new SpAffiliationServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SpAffiliationServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SpAffiliationService service) {
	}

	private static SpAffiliationService _service;
}