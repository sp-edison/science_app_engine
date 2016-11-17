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

import science.platform.service.SpAffiliationServiceUtil;

import java.util.Arrays;

/**
 * @author Jerry h. Seo
 * @generated
 */
public class SpAffiliationServiceClpInvoker {
	public SpAffiliationServiceClpInvoker() {
		_methodName48 = "getBeanIdentifier";

		_methodParameterTypes48 = new String[] {  };

		_methodName49 = "setBeanIdentifier";

		_methodParameterTypes49 = new String[] { "java.lang.String" };

		_methodName54 = "createSpAffiliation";

		_methodParameterTypes54 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName55 = "getAll";

		_methodParameterTypes55 = new String[] {  };

		_methodName56 = "getAllAffiliationsJSON";

		_methodParameterTypes56 = new String[] { "java.util.Locale" };

		_methodName57 = "getSpAffiliationListByCountryId";

		_methodParameterTypes57 = new String[] { "long" };

		_methodName58 = "getSpAffiliationListByRegionId";

		_methodParameterTypes58 = new String[] { "long" };

		_methodName59 = "getAffiliationNamesByCountryId";

		_methodParameterTypes59 = new String[] { "long", "java.util.Locale" };

		_methodName60 = "getAffiliationNamesByRegionId";

		_methodParameterTypes60 = new String[] { "long", "java.util.Locale" };

		_methodName61 = "isExist";

		_methodParameterTypes61 = new String[] { "long", "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return SpAffiliationServiceUtil.getBeanIdentifier();
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			SpAffiliationServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return SpAffiliationServiceUtil.createSpAffiliation(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return SpAffiliationServiceUtil.getAll();
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return SpAffiliationServiceUtil.getAllAffiliationsJSON((java.util.Locale)arguments[0]);
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return SpAffiliationServiceUtil.getSpAffiliationListByCountryId(((Long)arguments[0]).longValue());
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return SpAffiliationServiceUtil.getSpAffiliationListByRegionId(((Long)arguments[0]).longValue());
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return SpAffiliationServiceUtil.getAffiliationNamesByCountryId(((Long)arguments[0]).longValue(),
				(java.util.Locale)arguments[1]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return SpAffiliationServiceUtil.getAffiliationNamesByRegionId(((Long)arguments[0]).longValue(),
				(java.util.Locale)arguments[1]);
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return SpAffiliationServiceUtil.isExist(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
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
}