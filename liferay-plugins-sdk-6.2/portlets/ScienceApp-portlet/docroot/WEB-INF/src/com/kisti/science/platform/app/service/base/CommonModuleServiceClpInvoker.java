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

import com.kisti.science.platform.app.service.CommonModuleServiceUtil;

import java.util.Arrays;

/**
 * @author Jerry H. Seo & Young Suh
 * @generated
 */
public class CommonModuleServiceClpInvoker {
	public CommonModuleServiceClpInvoker() {
		_methodName82 = "getBeanIdentifier";

		_methodParameterTypes82 = new String[] {  };

		_methodName83 = "setBeanIdentifier";

		_methodParameterTypes83 = new String[] { "java.lang.String" };

		_methodName88 = "updateModules";

		_methodParameterTypes88 = new String[] {  };

		_methodName89 = "retrieveAllModules";

		_methodParameterTypes89 = new String[] {  };

		_methodName90 = "retrieveModule";

		_methodParameterTypes90 = new String[] { "java.lang.String" };

		_methodName91 = "unloadModule";

		_methodParameterTypes91 = new String[] { "java.lang.String" };

		_methodName92 = "loadModule";

		_methodParameterTypes92 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return CommonModuleServiceUtil.getBeanIdentifier();
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			CommonModuleServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return CommonModuleServiceUtil.updateModules();
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return CommonModuleServiceUtil.retrieveAllModules();
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return CommonModuleServiceUtil.retrieveModule((java.lang.String)arguments[0]);
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return CommonModuleServiceUtil.unloadModule((java.lang.String)arguments[0]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return CommonModuleServiceUtil.loadModule((java.lang.String)arguments[0]);
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
	private String _methodName91;
	private String[] _methodParameterTypes91;
	private String _methodName92;
	private String[] _methodParameterTypes92;
}