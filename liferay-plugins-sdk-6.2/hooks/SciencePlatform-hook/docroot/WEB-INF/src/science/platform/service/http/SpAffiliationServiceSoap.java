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

package science.platform.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;

import science.platform.service.SpAffiliationServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link science.platform.service.SpAffiliationServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link science.platform.model.SpAffiliationSoap}.
 * If the method in the service utility returns a
 * {@link science.platform.model.SpAffiliation}, that is translated to a
 * {@link science.platform.model.SpAffiliationSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpAffiliationServiceHttp
 * @see science.platform.model.SpAffiliationSoap
 * @see science.platform.service.SpAffiliationServiceUtil
 * @generated
 */
public class SpAffiliationServiceSoap {
	public static science.platform.model.SpAffiliationSoap createSpAffiliation(
		long countryId, long regionId, java.lang.String affiliationCode)
		throws RemoteException {
		try {
			science.platform.model.SpAffiliation returnValue = SpAffiliationServiceUtil.createSpAffiliation(countryId,
					regionId, affiliationCode);

			return science.platform.model.SpAffiliationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static science.platform.model.SpAffiliationSoap[] getAll()
		throws RemoteException {
		try {
			java.util.List<science.platform.model.SpAffiliation> returnValue = SpAffiliationServiceUtil.getAll();

			return science.platform.model.SpAffiliationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getAllAffiliationsJSON(String locale)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SpAffiliationServiceUtil.getAllAffiliationsJSON(LocaleUtil.fromLanguageId(
						locale));

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static science.platform.model.SpAffiliationSoap[] getSpAffiliationListByCountryId(
		long countryId) throws RemoteException {
		try {
			java.util.List<science.platform.model.SpAffiliation> returnValue = SpAffiliationServiceUtil.getSpAffiliationListByCountryId(countryId);

			return science.platform.model.SpAffiliationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static science.platform.model.SpAffiliationSoap[] getSpAffiliationListByRegionId(
		long regionId) throws RemoteException {
		try {
			java.util.List<science.platform.model.SpAffiliation> returnValue = SpAffiliationServiceUtil.getSpAffiliationListByRegionId(regionId);

			return science.platform.model.SpAffiliationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getAffiliationNamesByCountryId(
		long countryId, String locale) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SpAffiliationServiceUtil.getAffiliationNamesByCountryId(countryId,
					LocaleUtil.fromLanguageId(locale));

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getAffiliationNamesByRegionId(
		long regionId, String locale) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SpAffiliationServiceUtil.getAffiliationNamesByRegionId(regionId,
					LocaleUtil.fromLanguageId(locale));

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean isExist(long regionId,
		java.lang.String affiliationCode) throws RemoteException {
		try {
			boolean returnValue = SpAffiliationServiceUtil.isExist(regionId,
					affiliationCode);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SpAffiliationServiceSoap.class);
}