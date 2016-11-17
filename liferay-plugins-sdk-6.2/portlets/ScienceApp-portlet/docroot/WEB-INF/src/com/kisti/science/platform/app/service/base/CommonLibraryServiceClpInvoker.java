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

package com.kisti.science.platform.app.service.base;

import com.kisti.science.platform.app.service.CommonLibraryServiceUtil;

import java.util.Arrays;

/**
 * @author Jerry H. Seo & Young Suh
 * @generated
 */
public class CommonLibraryServiceClpInvoker {
	public CommonLibraryServiceClpInvoker() {
		_methodName82 = "getBeanIdentifier";

		_methodParameterTypes82 = new String[] {  };

		_methodName83 = "setBeanIdentifier";

		_methodParameterTypes83 = new String[] { "java.lang.String" };

		_methodName88 = "updateAllLibraries";

		_methodParameterTypes88 = new String[] {  };

		_methodName89 = "retrieveAllLibraries";

		_methodParameterTypes89 = new String[] {  };

		_methodName90 = "retrieveLibrary";

		_methodParameterTypes90 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return CommonLibraryServiceUtil.getBeanIdentifier();
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			CommonLibraryServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			CommonLibraryServiceUtil.updateAllLibraries();

			return null;
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return CommonLibraryServiceUtil.retrieveAllLibraries();
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return CommonLibraryServiceUtil.retrieveLibrary((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName88;
	private String[] _methodParameterTypes88;
	private String _methodName89;
	private String[] _methodParameterTypes89;
	private String _methodName90;
	private String[] _methodParameterTypes90;
}