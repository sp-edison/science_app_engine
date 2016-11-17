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

import science.platform.service.SpUserServiceUtil;

import java.util.Arrays;

/**
 * @author Jerry h. Seo
 * @generated
 */
public class SpUserServiceClpInvoker {
	public SpUserServiceClpInvoker() {
		_methodName48 = "getBeanIdentifier";

		_methodParameterTypes48 = new String[] {  };

		_methodName49 = "setBeanIdentifier";

		_methodParameterTypes49 = new String[] { "java.lang.String" };

		_methodName54 = "countUsersByDomain";

		_methodParameterTypes54 = new String[] { "java.lang.String" };

		_methodName55 = "getDomainsByUserId";

		_methodParameterTypes55 = new String[] { "long" };

		_methodName56 = "addSpUser";

		_methodParameterTypes56 = new String[] {
				"science.platform.model.SpUser", "long[][]"
			};

		_methodName57 = "deleteUser";

		_methodParameterTypes57 = new String[] { "long" };

		_methodName58 = "deleteSpUser";

		_methodParameterTypes58 = new String[] { "long" };

		_methodName59 = "getUserInfo";

		_methodParameterTypes59 = new String[] { "long", "java.util.Locale" };

		_methodName60 = "updateSpUser";

		_methodParameterTypes60 = new String[] {
				"science.platform.model.SpUser", "long[][]"
			};

		_methodName61 = "addUserWithWorkflow";

		_methodParameterTypes61 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String",
				"boolean", "java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.util.Locale",
				"com.liferay.portal.kernel.json.JSONObject",
				"com.liferay.portal.kernel.json.JSONObject",
				"com.liferay.portal.kernel.json.JSONObject", "int", "int",
				"boolean", "int", "int", "int", "java.lang.String", "long[][]",
				"long[][]", "long[][]", "long[][]", "boolean", "long", "long",
				"long", "long[][]", "com.liferay.portal.service.ServiceContext"
			};

		_methodName62 = "getUser";

		_methodParameterTypes62 = new String[] { "long" };

		_methodName63 = "getUser";

		_methodParameterTypes63 = new String[] { "science.platform.model.SpUser" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return SpUserServiceUtil.getBeanIdentifier();
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			SpUserServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return SpUserServiceUtil.countUsersByDomain((java.lang.String)arguments[0]);
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return SpUserServiceUtil.getDomainsByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return SpUserServiceUtil.addSpUser((science.platform.model.SpUser)arguments[0],
				(long[])arguments[1]);
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return SpUserServiceUtil.deleteUser(((Long)arguments[0]).longValue());
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return SpUserServiceUtil.deleteSpUser(((Long)arguments[0]).longValue());
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return SpUserServiceUtil.getUserInfo(((Long)arguments[0]).longValue(),
				(java.util.Locale)arguments[1]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return SpUserServiceUtil.updateSpUser((science.platform.model.SpUser)arguments[0],
				(long[])arguments[1]);
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return SpUserServiceUtil.addUserWithWorkflow(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Boolean)arguments[4]).booleanValue(),
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8], (java.util.Locale)arguments[9],
				(com.liferay.portal.kernel.json.JSONObject)arguments[10],
				(com.liferay.portal.kernel.json.JSONObject)arguments[11],
				(com.liferay.portal.kernel.json.JSONObject)arguments[12],
				((Integer)arguments[13]).intValue(),
				((Integer)arguments[14]).intValue(),
				((Boolean)arguments[15]).booleanValue(),
				((Integer)arguments[16]).intValue(),
				((Integer)arguments[17]).intValue(),
				((Integer)arguments[18]).intValue(),
				(java.lang.String)arguments[19], (long[])arguments[20],
				(long[])arguments[21], (long[])arguments[22],
				(long[])arguments[23], ((Boolean)arguments[24]).booleanValue(),
				((Long)arguments[25]).longValue(),
				((Long)arguments[26]).longValue(),
				((Long)arguments[27]).longValue(), (long[])arguments[28],
				(com.liferay.portal.service.ServiceContext)arguments[29]);
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return SpUserServiceUtil.getUser(((Long)arguments[0]).longValue());
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return SpUserServiceUtil.getUser((science.platform.model.SpUser)arguments[0]);
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
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
}