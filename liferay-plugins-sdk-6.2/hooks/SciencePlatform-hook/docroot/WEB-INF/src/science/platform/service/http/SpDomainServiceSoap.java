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

import science.platform.service.SpDomainServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link science.platform.service.SpDomainServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link science.platform.model.SpDomainSoap}.
 * If the method in the service utility returns a
 * {@link science.platform.model.SpDomain}, that is translated to a
 * {@link science.platform.model.SpDomainSoap}. Methods that SOAP cannot
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
 * @see SpDomainServiceHttp
 * @see science.platform.model.SpDomainSoap
 * @see science.platform.service.SpDomainServiceUtil
 * @generated
 */
public class SpDomainServiceSoap {
	public static science.platform.model.SpDomainSoap createSpDomain(
		java.lang.String domainCode) throws RemoteException {
		try {
			science.platform.model.SpDomain returnValue = SpDomainServiceUtil.createSpDomain(domainCode);

			return science.platform.model.SpDomainSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addUserDomain(long userId, long domainId)
		throws RemoteException {
		try {
			SpDomainServiceUtil.addUserDomain(userId, domainId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addUserDomains(long userId, long[] domainIds)
		throws RemoteException {
		try {
			SpDomainServiceUtil.addUserDomains(userId, domainIds);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static science.platform.model.SpDomainSoap[] getAll()
		throws RemoteException {
		try {
			java.util.List<science.platform.model.SpDomain> returnValue = SpDomainServiceUtil.getAll();

			return science.platform.model.SpDomainSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getAllDomainsJSON(String locale)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SpDomainServiceUtil.getAllDomainsJSON(LocaleUtil.fromLanguageId(
						locale));

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getDomainNamesByUserId(long userId,
		String locale) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SpDomainServiceUtil.getDomainNamesByUserId(userId,
					LocaleUtil.fromLanguageId(locale));

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean isExist(java.lang.String domainCode)
		throws RemoteException {
		try {
			boolean returnValue = SpDomainServiceUtil.isExist(domainCode);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SpDomainServiceSoap.class);
}