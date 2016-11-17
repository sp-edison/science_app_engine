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

package com.kisti.science.platform.app.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommonModuleService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonModuleService
 * @generated
 */
public class CommonModuleServiceWrapper implements CommonModuleService,
	ServiceWrapper<CommonModuleService> {
	public CommonModuleServiceWrapper(CommonModuleService commonModuleService) {
		_commonModuleService = commonModuleService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _commonModuleService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_commonModuleService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _commonModuleService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Update the module table if any new module is found.
	*/
	@Override
	public java.lang.String updateModules() {
		return _commonModuleService.updateModules();
	}

	/**
	* Retrieve all modules already installed.
	*/
	@Override
	public java.util.List<com.kisti.science.platform.app.model.CommonModule> retrieveAllModules() {
		return _commonModuleService.retrieveAllModules();
	}

	/**
	* Retrieve installed modules by keyword
	*
	* @param mod_name
	module name
	* @return a list of modules found
	*/
	@Override
	public java.util.List<com.kisti.science.platform.app.model.CommonModule> retrieveModule(
		java.lang.String mod_name) {
		return _commonModuleService.retrieveModule(mod_name);
	}

	/**
	* Unload a specific module
	*
	* @param mod_name module name to be loaded
	* @return result message
	*/
	@Override
	public java.lang.String unloadModule(java.lang.String mod_name) {
		return _commonModuleService.unloadModule(mod_name);
	}

	/**
	* Loading a specific module
	*
	* @param mod_name module name to be loaded
	* @return result message
	*/
	@Override
	public java.lang.String loadModule(java.lang.String mod_name) {
		return _commonModuleService.loadModule(mod_name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CommonModuleService getWrappedCommonModuleService() {
		return _commonModuleService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCommonModuleService(
		CommonModuleService commonModuleService) {
		_commonModuleService = commonModuleService;
	}

	@Override
	public CommonModuleService getWrappedService() {
		return _commonModuleService;
	}

	@Override
	public void setWrappedService(CommonModuleService commonModuleService) {
		_commonModuleService = commonModuleService;
	}

	private CommonModuleService _commonModuleService;
}