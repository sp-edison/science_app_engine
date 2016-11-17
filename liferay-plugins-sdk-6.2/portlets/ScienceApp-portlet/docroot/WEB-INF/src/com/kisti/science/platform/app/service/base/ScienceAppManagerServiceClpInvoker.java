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

import com.kisti.science.platform.app.service.ScienceAppManagerServiceUtil;

import java.util.Arrays;

/**
 * @author Jerry H. Seo & Young Suh
 * @generated
 */
public class ScienceAppManagerServiceClpInvoker {
	public ScienceAppManagerServiceClpInvoker() {
		_methodName82 = "getBeanIdentifier";

		_methodParameterTypes82 = new String[] {  };

		_methodName83 = "setBeanIdentifier";

		_methodParameterTypes83 = new String[] { "java.lang.String" };

		_methodName88 = "addScienceAppManager";

		_methodParameterTypes88 = new String[] {
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName89 = "removeSicenceAppManager";

		_methodParameterTypes89 = new String[] { "long" };

		_methodName90 = "removeScienceAppManagerByManagerId";

		_methodParameterTypes90 = new String[] { "long" };

		_methodName91 = "removeScienceAppManagerByScienceAppId";

		_methodParameterTypes91 = new String[] { "long" };

		_methodName92 = "updateScienceAppManager";

		_methodParameterTypes92 = new String[] {
				"com.kisti.science.platform.app.model.ScienceAppManager"
			};

		_methodName93 = "getScienceAppIdsByManagerId";

		_methodParameterTypes93 = new String[] { "long" };

		_methodName94 = "getManagetIdsByScienceAppId";

		_methodParameterTypes94 = new String[] { "long" };

		_methodName95 = "saveToFile";

		_methodParameterTypes95 = new String[] {
				"java.io.InputStream", "java.lang.String"
			};

		_methodName96 = "unzipSciAppZipFile";

		_methodParameterTypes96 = new String[] {
				"java.lang.String", "java.lang.String", "java.io.File",
				"java.lang.String"
			};

		_methodName97 = "executeCommand";

		_methodParameterTypes97 = new String[] { "java.lang.String" };

		_methodName98 = "makeDir";

		_methodParameterTypes98 = new String[] { "java.lang.String" };

		_methodName99 = "checkAck";

		_methodParameterTypes99 = new String[] { "java.io.InputStream" };

		_methodName100 = "executeLibInstall";

		_methodParameterTypes100 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName101 = "remoteMakeDir";

		_methodParameterTypes101 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName102 = "installLibFile";

		_methodParameterTypes102 = new String[] {
				"java.lang.String", "java.io.File"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return ScienceAppManagerServiceUtil.getBeanIdentifier();
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			ScienceAppManagerServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return ScienceAppManagerServiceUtil.addScienceAppManager(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			ScienceAppManagerServiceUtil.removeSicenceAppManager(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			ScienceAppManagerServiceUtil.removeScienceAppManagerByManagerId(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			ScienceAppManagerServiceUtil.removeScienceAppManagerByScienceAppId(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			ScienceAppManagerServiceUtil.updateScienceAppManager((com.kisti.science.platform.app.model.ScienceAppManager)arguments[0]);

			return null;
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return ScienceAppManagerServiceUtil.getScienceAppIdsByManagerId(((Long)arguments[0]).longValue());
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return ScienceAppManagerServiceUtil.getManagetIdsByScienceAppId(((Long)arguments[0]).longValue());
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return ScienceAppManagerServiceUtil.saveToFile((java.io.InputStream)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return ScienceAppManagerServiceUtil.unzipSciAppZipFile((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.io.File)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return ScienceAppManagerServiceUtil.executeCommand((java.lang.String)arguments[0]);
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return ScienceAppManagerServiceUtil.makeDir((java.lang.String)arguments[0]);
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			return ScienceAppManagerServiceUtil.checkAck((java.io.InputStream)arguments[0]);
		}

		if (_methodName100.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
			return ScienceAppManagerServiceUtil.executeLibInstall((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName101.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
			return ScienceAppManagerServiceUtil.remoteMakeDir((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			return ScienceAppManagerServiceUtil.installLibFile((java.lang.String)arguments[0],
				(java.io.File)arguments[1]);
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
	private String _methodName93;
	private String[] _methodParameterTypes93;
	private String _methodName94;
	private String[] _methodParameterTypes94;
	private String _methodName95;
	private String[] _methodParameterTypes95;
	private String _methodName96;
	private String[] _methodParameterTypes96;
	private String _methodName97;
	private String[] _methodParameterTypes97;
	private String _methodName98;
	private String[] _methodParameterTypes98;
	private String _methodName99;
	private String[] _methodParameterTypes99;
	private String _methodName100;
	private String[] _methodParameterTypes100;
	private String _methodName101;
	private String[] _methodParameterTypes101;
	private String _methodName102;
	private String[] _methodParameterTypes102;
}