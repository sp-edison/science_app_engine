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

import science.platform.service.SpUserServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link science.platform.service.SpUserServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link science.platform.model.SpUserSoap}.
 * If the method in the service utility returns a
 * {@link science.platform.model.SpUser}, that is translated to a
 * {@link science.platform.model.SpUserSoap}. Methods that SOAP cannot
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
 * @see SpUserServiceHttp
 * @see science.platform.model.SpUserSoap
 * @see science.platform.service.SpUserServiceUtil
 * @generated
 */
public class SpUserServiceSoap {
	public static long countUsersByDomain(java.lang.String domainCode)
		throws RemoteException {
		try {
			long returnValue = SpUserServiceUtil.countUsersByDomain(domainCode);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static science.platform.model.SpDomainSoap[] getDomainsByUserId(
		long userId) throws RemoteException {
		try {
			java.util.List<science.platform.model.SpDomain> returnValue = SpUserServiceUtil.getDomainsByUserId(userId);

			return science.platform.model.SpDomainSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static science.platform.model.SpUserSoap addSpUser(
		science.platform.model.SpUserSoap spUser, long[] domainIds)
		throws RemoteException {
		try {
			science.platform.model.SpUser returnValue = SpUserServiceUtil.addSpUser(science.platform.model.impl.SpUserModelImpl.toModel(
						spUser), domainIds);

			return science.platform.model.SpUserSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.User deleteUser(long spUserId)
		throws RemoteException {
		try {
			com.liferay.portal.model.User returnValue = SpUserServiceUtil.deleteUser(spUserId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static science.platform.model.SpUserSoap deleteSpUser(long spUserId)
		throws RemoteException {
		try {
			science.platform.model.SpUser returnValue = SpUserServiceUtil.deleteSpUser(spUserId);

			return science.platform.model.SpUserSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getUserInfo(long userId, String locale)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = SpUserServiceUtil.getUserInfo(userId,
					LocaleUtil.fromLanguageId(locale));

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static science.platform.model.SpUserSoap updateSpUser(
		science.platform.model.SpUserSoap spUser, long[] domainIds)
		throws RemoteException {
		try {
			science.platform.model.SpUser returnValue = SpUserServiceUtil.updateSpUser(science.platform.model.impl.SpUserModelImpl.toModel(
						spUser), domainIds);

			return science.platform.model.SpUserSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static science.platform.model.SpUserSoap addUserWithWorkflow(
		long companyId, boolean autoPassword, java.lang.String password1,
		java.lang.String password2, boolean autoScreenName,
		java.lang.String screenName, java.lang.String emailAddress,
		long facebookId, java.lang.String openId, String locale,
		com.liferay.portal.kernel.json.JSONObject jsonFirstName,
		com.liferay.portal.kernel.json.JSONObject jsonMiddleName,
		com.liferay.portal.kernel.json.JSONObject jsonLastName, int prefixId,
		int suffixId, boolean male, int birthdayMonth, int birthdayDay,
		int birthdayYear, java.lang.String jobTitle, long[] groupIds,
		long[] organizationIds, long[] roleIds, long[] userGroupIds,
		boolean sendEmail, long countryId, long regionId, long affiliationId,
		long[] domainIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			science.platform.model.SpUser returnValue = SpUserServiceUtil.addUserWithWorkflow(companyId,
					autoPassword, password1, password2, autoScreenName,
					screenName, emailAddress, facebookId, openId,
					LocaleUtil.fromLanguageId(locale), jsonFirstName,
					jsonMiddleName, jsonLastName, prefixId, suffixId, male,
					birthdayMonth, birthdayDay, birthdayYear, jobTitle,
					groupIds, organizationIds, roleIds, userGroupIds,
					sendEmail, countryId, regionId, affiliationId, domainIds,
					serviceContext);

			return science.platform.model.SpUserSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.User getUser(long userId)
		throws RemoteException {
		try {
			com.liferay.portal.model.User returnValue = SpUserServiceUtil.getUser(userId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.User getUser(
		science.platform.model.SpUserSoap user) throws RemoteException {
		try {
			com.liferay.portal.model.User returnValue = SpUserServiceUtil.getUser(science.platform.model.impl.SpUserModelImpl.toModel(
						user));

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SpUserServiceSoap.class);
}