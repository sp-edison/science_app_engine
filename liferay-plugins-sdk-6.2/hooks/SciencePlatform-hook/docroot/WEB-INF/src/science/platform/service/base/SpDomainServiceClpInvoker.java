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

package science.platform.service.base;

import science.platform.service.SpDomainServiceUtil;

import java.util.Arrays;

/**
 * @author Jerry h. Seo
 * @generated
 */
public class SpDomainServiceClpInvoker {
	public SpDomainServiceClpInvoker() {
		_methodName48 = "getBeanIdentifier";

		_methodParameterTypes48 = new String[] {  };

		_methodName49 = "setBeanIdentifier";

		_methodParameterTypes49 = new String[] { "java.lang.String" };

		_methodName54 = "createSpDomain";

		_methodParameterTypes54 = new String[] { "java.lang.String" };

		_methodName55 = "addUserDomain";

		_methodParameterTypes55 = new String[] { "long", "long" };

		_methodName56 = "addUserDomains";

		_methodParameterTypes56 = new String[] { "long", "long[][]" };

		_methodName57 = "getAll";

		_methodParameterTypes57 = new String[] {  };

		_methodName58 = "getAllDomainsJSON";

		_methodParameterTypes58 = new String[] { "java.util.Locale" };

		_methodName59 = "getDomainNamesByUserId";

		_methodParameterTypes59 = new String[] { "long", "java.util.Locale" };

		_methodName60 = "isExist";

		_methodParameterTypes60 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return SpDomainServiceUtil.getBeanIdentifier();
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			SpDomainServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return SpDomainServiceUtil.createSpDomain((java.lang.String)arguments[0]);
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			SpDomainServiceUtil.addUserDomain(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			SpDomainServiceUtil.addUserDomains(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return SpDomainServiceUtil.getAll();
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return SpDomainServiceUtil.getAllDomainsJSON((java.util.Locale)arguments[0]);
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return SpDomainServiceUtil.getDomainNamesByUserId(((Long)arguments[0]).longValue(),
				(java.util.Locale)arguments[1]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return SpDomainServiceUtil.isExist((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
}