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

import com.kisti.science.platform.app.model.PortType;
import com.kisti.science.platform.app.service.PortTypeService;
import com.kisti.science.platform.app.service.persistence.CommonLibraryPersistence;
import com.kisti.science.platform.app.service.persistence.CommonModulePersistence;
import com.kisti.science.platform.app.service.persistence.CommonPackagePersistence;
import com.kisti.science.platform.app.service.persistence.PortTypeAnalyzerLinkPersistence;
import com.kisti.science.platform.app.service.persistence.PortTypeEditorLinkPersistence;
import com.kisti.science.platform.app.service.persistence.PortTypeInputdeckFormPersistence;
import com.kisti.science.platform.app.service.persistence.PortTypePersistence;
import com.kisti.science.platform.app.service.persistence.ScienceAppCategoryLinkPersistence;
import com.kisti.science.platform.app.service.persistence.ScienceAppFinder;
import com.kisti.science.platform.app.service.persistence.ScienceAppInputPortsPersistence;
import com.kisti.science.platform.app.service.persistence.ScienceAppManagerPersistence;
import com.kisti.science.platform.app.service.persistence.ScienceAppOutputPortsPersistence;
import com.kisti.science.platform.app.service.persistence.ScienceAppPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the port type remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.kisti.science.platform.app.service.impl.PortTypeServiceImpl}.
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see com.kisti.science.platform.app.service.impl.PortTypeServiceImpl
 * @see com.kisti.science.platform.app.service.PortTypeServiceUtil
 * @generated
 */
public abstract class PortTypeServiceBaseImpl extends BaseServiceImpl
	implements PortTypeService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.kisti.science.platform.app.service.PortTypeServiceUtil} to access the port type remote service.
	 */

	/**
	 * Returns the app test history local service.
	 *
	 * @return the app test history local service
	 */
	public com.kisti.science.platform.app.service.AppTestHistoryLocalService getAppTestHistoryLocalService() {
		return appTestHistoryLocalService;
	}

	/**
	 * Sets the app test history local service.
	 *
	 * @param appTestHistoryLocalService the app test history local service
	 */
	public void setAppTestHistoryLocalService(
		com.kisti.science.platform.app.service.AppTestHistoryLocalService appTestHistoryLocalService) {
		this.appTestHistoryLocalService = appTestHistoryLocalService;
	}

	/**
	 * Returns the app test history remote service.
	 *
	 * @return the app test history remote service
	 */
	public com.kisti.science.platform.app.service.AppTestHistoryService getAppTestHistoryService() {
		return appTestHistoryService;
	}

	/**
	 * Sets the app test history remote service.
	 *
	 * @param appTestHistoryService the app test history remote service
	 */
	public void setAppTestHistoryService(
		com.kisti.science.platform.app.service.AppTestHistoryService appTestHistoryService) {
		this.appTestHistoryService = appTestHistoryService;
	}

	/**
	 * Returns the common library local service.
	 *
	 * @return the common library local service
	 */
	public com.kisti.science.platform.app.service.CommonLibraryLocalService getCommonLibraryLocalService() {
		return commonLibraryLocalService;
	}

	/**
	 * Sets the common library local service.
	 *
	 * @param commonLibraryLocalService the common library local service
	 */
	public void setCommonLibraryLocalService(
		com.kisti.science.platform.app.service.CommonLibraryLocalService commonLibraryLocalService) {
		this.commonLibraryLocalService = commonLibraryLocalService;
	}

	/**
	 * Returns the common library remote service.
	 *
	 * @return the common library remote service
	 */
	public com.kisti.science.platform.app.service.CommonLibraryService getCommonLibraryService() {
		return commonLibraryService;
	}

	/**
	 * Sets the common library remote service.
	 *
	 * @param commonLibraryService the common library remote service
	 */
	public void setCommonLibraryService(
		com.kisti.science.platform.app.service.CommonLibraryService commonLibraryService) {
		this.commonLibraryService = commonLibraryService;
	}

	/**
	 * Returns the common library persistence.
	 *
	 * @return the common library persistence
	 */
	public CommonLibraryPersistence getCommonLibraryPersistence() {
		return commonLibraryPersistence;
	}

	/**
	 * Sets the common library persistence.
	 *
	 * @param commonLibraryPersistence the common library persistence
	 */
	public void setCommonLibraryPersistence(
		CommonLibraryPersistence commonLibraryPersistence) {
		this.commonLibraryPersistence = commonLibraryPersistence;
	}

	/**
	 * Returns the common module remote service.
	 *
	 * @return the common module remote service
	 */
	public com.kisti.science.platform.app.service.CommonModuleService getCommonModuleService() {
		return commonModuleService;
	}

	/**
	 * Sets the common module remote service.
	 *
	 * @param commonModuleService the common module remote service
	 */
	public void setCommonModuleService(
		com.kisti.science.platform.app.service.CommonModuleService commonModuleService) {
		this.commonModuleService = commonModuleService;
	}

	/**
	 * Returns the common module persistence.
	 *
	 * @return the common module persistence
	 */
	public CommonModulePersistence getCommonModulePersistence() {
		return commonModulePersistence;
	}

	/**
	 * Sets the common module persistence.
	 *
	 * @param commonModulePersistence the common module persistence
	 */
	public void setCommonModulePersistence(
		CommonModulePersistence commonModulePersistence) {
		this.commonModulePersistence = commonModulePersistence;
	}

	/**
	 * Returns the common package local service.
	 *
	 * @return the common package local service
	 */
	public com.kisti.science.platform.app.service.CommonPackageLocalService getCommonPackageLocalService() {
		return commonPackageLocalService;
	}

	/**
	 * Sets the common package local service.
	 *
	 * @param commonPackageLocalService the common package local service
	 */
	public void setCommonPackageLocalService(
		com.kisti.science.platform.app.service.CommonPackageLocalService commonPackageLocalService) {
		this.commonPackageLocalService = commonPackageLocalService;
	}

	/**
	 * Returns the common package remote service.
	 *
	 * @return the common package remote service
	 */
	public com.kisti.science.platform.app.service.CommonPackageService getCommonPackageService() {
		return commonPackageService;
	}

	/**
	 * Sets the common package remote service.
	 *
	 * @param commonPackageService the common package remote service
	 */
	public void setCommonPackageService(
		com.kisti.science.platform.app.service.CommonPackageService commonPackageService) {
		this.commonPackageService = commonPackageService;
	}

	/**
	 * Returns the common package persistence.
	 *
	 * @return the common package persistence
	 */
	public CommonPackagePersistence getCommonPackagePersistence() {
		return commonPackagePersistence;
	}

	/**
	 * Sets the common package persistence.
	 *
	 * @param commonPackagePersistence the common package persistence
	 */
	public void setCommonPackagePersistence(
		CommonPackagePersistence commonPackagePersistence) {
		this.commonPackagePersistence = commonPackagePersistence;
	}

	/**
	 * Returns the port type local service.
	 *
	 * @return the port type local service
	 */
	public com.kisti.science.platform.app.service.PortTypeLocalService getPortTypeLocalService() {
		return portTypeLocalService;
	}

	/**
	 * Sets the port type local service.
	 *
	 * @param portTypeLocalService the port type local service
	 */
	public void setPortTypeLocalService(
		com.kisti.science.platform.app.service.PortTypeLocalService portTypeLocalService) {
		this.portTypeLocalService = portTypeLocalService;
	}

	/**
	 * Returns the port type remote service.
	 *
	 * @return the port type remote service
	 */
	public com.kisti.science.platform.app.service.PortTypeService getPortTypeService() {
		return portTypeService;
	}

	/**
	 * Sets the port type remote service.
	 *
	 * @param portTypeService the port type remote service
	 */
	public void setPortTypeService(
		com.kisti.science.platform.app.service.PortTypeService portTypeService) {
		this.portTypeService = portTypeService;
	}

	/**
	 * Returns the port type persistence.
	 *
	 * @return the port type persistence
	 */
	public PortTypePersistence getPortTypePersistence() {
		return portTypePersistence;
	}

	/**
	 * Sets the port type persistence.
	 *
	 * @param portTypePersistence the port type persistence
	 */
	public void setPortTypePersistence(PortTypePersistence portTypePersistence) {
		this.portTypePersistence = portTypePersistence;
	}

	/**
	 * Returns the port type analyzer link local service.
	 *
	 * @return the port type analyzer link local service
	 */
	public com.kisti.science.platform.app.service.PortTypeAnalyzerLinkLocalService getPortTypeAnalyzerLinkLocalService() {
		return portTypeAnalyzerLinkLocalService;
	}

	/**
	 * Sets the port type analyzer link local service.
	 *
	 * @param portTypeAnalyzerLinkLocalService the port type analyzer link local service
	 */
	public void setPortTypeAnalyzerLinkLocalService(
		com.kisti.science.platform.app.service.PortTypeAnalyzerLinkLocalService portTypeAnalyzerLinkLocalService) {
		this.portTypeAnalyzerLinkLocalService = portTypeAnalyzerLinkLocalService;
	}

	/**
	 * Returns the port type analyzer link remote service.
	 *
	 * @return the port type analyzer link remote service
	 */
	public com.kisti.science.platform.app.service.PortTypeAnalyzerLinkService getPortTypeAnalyzerLinkService() {
		return portTypeAnalyzerLinkService;
	}

	/**
	 * Sets the port type analyzer link remote service.
	 *
	 * @param portTypeAnalyzerLinkService the port type analyzer link remote service
	 */
	public void setPortTypeAnalyzerLinkService(
		com.kisti.science.platform.app.service.PortTypeAnalyzerLinkService portTypeAnalyzerLinkService) {
		this.portTypeAnalyzerLinkService = portTypeAnalyzerLinkService;
	}

	/**
	 * Returns the port type analyzer link persistence.
	 *
	 * @return the port type analyzer link persistence
	 */
	public PortTypeAnalyzerLinkPersistence getPortTypeAnalyzerLinkPersistence() {
		return portTypeAnalyzerLinkPersistence;
	}

	/**
	 * Sets the port type analyzer link persistence.
	 *
	 * @param portTypeAnalyzerLinkPersistence the port type analyzer link persistence
	 */
	public void setPortTypeAnalyzerLinkPersistence(
		PortTypeAnalyzerLinkPersistence portTypeAnalyzerLinkPersistence) {
		this.portTypeAnalyzerLinkPersistence = portTypeAnalyzerLinkPersistence;
	}

	/**
	 * Returns the port type editor link local service.
	 *
	 * @return the port type editor link local service
	 */
	public com.kisti.science.platform.app.service.PortTypeEditorLinkLocalService getPortTypeEditorLinkLocalService() {
		return portTypeEditorLinkLocalService;
	}

	/**
	 * Sets the port type editor link local service.
	 *
	 * @param portTypeEditorLinkLocalService the port type editor link local service
	 */
	public void setPortTypeEditorLinkLocalService(
		com.kisti.science.platform.app.service.PortTypeEditorLinkLocalService portTypeEditorLinkLocalService) {
		this.portTypeEditorLinkLocalService = portTypeEditorLinkLocalService;
	}

	/**
	 * Returns the port type editor link remote service.
	 *
	 * @return the port type editor link remote service
	 */
	public com.kisti.science.platform.app.service.PortTypeEditorLinkService getPortTypeEditorLinkService() {
		return portTypeEditorLinkService;
	}

	/**
	 * Sets the port type editor link remote service.
	 *
	 * @param portTypeEditorLinkService the port type editor link remote service
	 */
	public void setPortTypeEditorLinkService(
		com.kisti.science.platform.app.service.PortTypeEditorLinkService portTypeEditorLinkService) {
		this.portTypeEditorLinkService = portTypeEditorLinkService;
	}

	/**
	 * Returns the port type editor link persistence.
	 *
	 * @return the port type editor link persistence
	 */
	public PortTypeEditorLinkPersistence getPortTypeEditorLinkPersistence() {
		return portTypeEditorLinkPersistence;
	}

	/**
	 * Sets the port type editor link persistence.
	 *
	 * @param portTypeEditorLinkPersistence the port type editor link persistence
	 */
	public void setPortTypeEditorLinkPersistence(
		PortTypeEditorLinkPersistence portTypeEditorLinkPersistence) {
		this.portTypeEditorLinkPersistence = portTypeEditorLinkPersistence;
	}

	/**
	 * Returns the port type inputdeck form local service.
	 *
	 * @return the port type inputdeck form local service
	 */
	public com.kisti.science.platform.app.service.PortTypeInputdeckFormLocalService getPortTypeInputdeckFormLocalService() {
		return portTypeInputdeckFormLocalService;
	}

	/**
	 * Sets the port type inputdeck form local service.
	 *
	 * @param portTypeInputdeckFormLocalService the port type inputdeck form local service
	 */
	public void setPortTypeInputdeckFormLocalService(
		com.kisti.science.platform.app.service.PortTypeInputdeckFormLocalService portTypeInputdeckFormLocalService) {
		this.portTypeInputdeckFormLocalService = portTypeInputdeckFormLocalService;
	}

	/**
	 * Returns the port type inputdeck form persistence.
	 *
	 * @return the port type inputdeck form persistence
	 */
	public PortTypeInputdeckFormPersistence getPortTypeInputdeckFormPersistence() {
		return portTypeInputdeckFormPersistence;
	}

	/**
	 * Sets the port type inputdeck form persistence.
	 *
	 * @param portTypeInputdeckFormPersistence the port type inputdeck form persistence
	 */
	public void setPortTypeInputdeckFormPersistence(
		PortTypeInputdeckFormPersistence portTypeInputdeckFormPersistence) {
		this.portTypeInputdeckFormPersistence = portTypeInputdeckFormPersistence;
	}

	/**
	 * Returns the science app local service.
	 *
	 * @return the science app local service
	 */
	public com.kisti.science.platform.app.service.ScienceAppLocalService getScienceAppLocalService() {
		return scienceAppLocalService;
	}

	/**
	 * Sets the science app local service.
	 *
	 * @param scienceAppLocalService the science app local service
	 */
	public void setScienceAppLocalService(
		com.kisti.science.platform.app.service.ScienceAppLocalService scienceAppLocalService) {
		this.scienceAppLocalService = scienceAppLocalService;
	}

	/**
	 * Returns the science app remote service.
	 *
	 * @return the science app remote service
	 */
	public com.kisti.science.platform.app.service.ScienceAppService getScienceAppService() {
		return scienceAppService;
	}

	/**
	 * Sets the science app remote service.
	 *
	 * @param scienceAppService the science app remote service
	 */
	public void setScienceAppService(
		com.kisti.science.platform.app.service.ScienceAppService scienceAppService) {
		this.scienceAppService = scienceAppService;
	}

	/**
	 * Returns the science app persistence.
	 *
	 * @return the science app persistence
	 */
	public ScienceAppPersistence getScienceAppPersistence() {
		return scienceAppPersistence;
	}

	/**
	 * Sets the science app persistence.
	 *
	 * @param scienceAppPersistence the science app persistence
	 */
	public void setScienceAppPersistence(
		ScienceAppPersistence scienceAppPersistence) {
		this.scienceAppPersistence = scienceAppPersistence;
	}

	/**
	 * Returns the science app finder.
	 *
	 * @return the science app finder
	 */
	public ScienceAppFinder getScienceAppFinder() {
		return scienceAppFinder;
	}

	/**
	 * Sets the science app finder.
	 *
	 * @param scienceAppFinder the science app finder
	 */
	public void setScienceAppFinder(ScienceAppFinder scienceAppFinder) {
		this.scienceAppFinder = scienceAppFinder;
	}

	/**
	 * Returns the science app category link local service.
	 *
	 * @return the science app category link local service
	 */
	public com.kisti.science.platform.app.service.ScienceAppCategoryLinkLocalService getScienceAppCategoryLinkLocalService() {
		return scienceAppCategoryLinkLocalService;
	}

	/**
	 * Sets the science app category link local service.
	 *
	 * @param scienceAppCategoryLinkLocalService the science app category link local service
	 */
	public void setScienceAppCategoryLinkLocalService(
		com.kisti.science.platform.app.service.ScienceAppCategoryLinkLocalService scienceAppCategoryLinkLocalService) {
		this.scienceAppCategoryLinkLocalService = scienceAppCategoryLinkLocalService;
	}

	/**
	 * Returns the science app category link remote service.
	 *
	 * @return the science app category link remote service
	 */
	public com.kisti.science.platform.app.service.ScienceAppCategoryLinkService getScienceAppCategoryLinkService() {
		return scienceAppCategoryLinkService;
	}

	/**
	 * Sets the science app category link remote service.
	 *
	 * @param scienceAppCategoryLinkService the science app category link remote service
	 */
	public void setScienceAppCategoryLinkService(
		com.kisti.science.platform.app.service.ScienceAppCategoryLinkService scienceAppCategoryLinkService) {
		this.scienceAppCategoryLinkService = scienceAppCategoryLinkService;
	}

	/**
	 * Returns the science app category link persistence.
	 *
	 * @return the science app category link persistence
	 */
	public ScienceAppCategoryLinkPersistence getScienceAppCategoryLinkPersistence() {
		return scienceAppCategoryLinkPersistence;
	}

	/**
	 * Sets the science app category link persistence.
	 *
	 * @param scienceAppCategoryLinkPersistence the science app category link persistence
	 */
	public void setScienceAppCategoryLinkPersistence(
		ScienceAppCategoryLinkPersistence scienceAppCategoryLinkPersistence) {
		this.scienceAppCategoryLinkPersistence = scienceAppCategoryLinkPersistence;
	}

	/**
	 * Returns the science app input ports local service.
	 *
	 * @return the science app input ports local service
	 */
	public com.kisti.science.platform.app.service.ScienceAppInputPortsLocalService getScienceAppInputPortsLocalService() {
		return scienceAppInputPortsLocalService;
	}

	/**
	 * Sets the science app input ports local service.
	 *
	 * @param scienceAppInputPortsLocalService the science app input ports local service
	 */
	public void setScienceAppInputPortsLocalService(
		com.kisti.science.platform.app.service.ScienceAppInputPortsLocalService scienceAppInputPortsLocalService) {
		this.scienceAppInputPortsLocalService = scienceAppInputPortsLocalService;
	}

	/**
	 * Returns the science app input ports persistence.
	 *
	 * @return the science app input ports persistence
	 */
	public ScienceAppInputPortsPersistence getScienceAppInputPortsPersistence() {
		return scienceAppInputPortsPersistence;
	}

	/**
	 * Sets the science app input ports persistence.
	 *
	 * @param scienceAppInputPortsPersistence the science app input ports persistence
	 */
	public void setScienceAppInputPortsPersistence(
		ScienceAppInputPortsPersistence scienceAppInputPortsPersistence) {
		this.scienceAppInputPortsPersistence = scienceAppInputPortsPersistence;
	}

	/**
	 * Returns the science app manager local service.
	 *
	 * @return the science app manager local service
	 */
	public com.kisti.science.platform.app.service.ScienceAppManagerLocalService getScienceAppManagerLocalService() {
		return scienceAppManagerLocalService;
	}

	/**
	 * Sets the science app manager local service.
	 *
	 * @param scienceAppManagerLocalService the science app manager local service
	 */
	public void setScienceAppManagerLocalService(
		com.kisti.science.platform.app.service.ScienceAppManagerLocalService scienceAppManagerLocalService) {
		this.scienceAppManagerLocalService = scienceAppManagerLocalService;
	}

	/**
	 * Returns the science app manager remote service.
	 *
	 * @return the science app manager remote service
	 */
	public com.kisti.science.platform.app.service.ScienceAppManagerService getScienceAppManagerService() {
		return scienceAppManagerService;
	}

	/**
	 * Sets the science app manager remote service.
	 *
	 * @param scienceAppManagerService the science app manager remote service
	 */
	public void setScienceAppManagerService(
		com.kisti.science.platform.app.service.ScienceAppManagerService scienceAppManagerService) {
		this.scienceAppManagerService = scienceAppManagerService;
	}

	/**
	 * Returns the science app manager persistence.
	 *
	 * @return the science app manager persistence
	 */
	public ScienceAppManagerPersistence getScienceAppManagerPersistence() {
		return scienceAppManagerPersistence;
	}

	/**
	 * Sets the science app manager persistence.
	 *
	 * @param scienceAppManagerPersistence the science app manager persistence
	 */
	public void setScienceAppManagerPersistence(
		ScienceAppManagerPersistence scienceAppManagerPersistence) {
		this.scienceAppManagerPersistence = scienceAppManagerPersistence;
	}

	/**
	 * Returns the science app output ports local service.
	 *
	 * @return the science app output ports local service
	 */
	public com.kisti.science.platform.app.service.ScienceAppOutputPortsLocalService getScienceAppOutputPortsLocalService() {
		return scienceAppOutputPortsLocalService;
	}

	/**
	 * Sets the science app output ports local service.
	 *
	 * @param scienceAppOutputPortsLocalService the science app output ports local service
	 */
	public void setScienceAppOutputPortsLocalService(
		com.kisti.science.platform.app.service.ScienceAppOutputPortsLocalService scienceAppOutputPortsLocalService) {
		this.scienceAppOutputPortsLocalService = scienceAppOutputPortsLocalService;
	}

	/**
	 * Returns the science app output ports persistence.
	 *
	 * @return the science app output ports persistence
	 */
	public ScienceAppOutputPortsPersistence getScienceAppOutputPortsPersistence() {
		return scienceAppOutputPortsPersistence;
	}

	/**
	 * Sets the science app output ports persistence.
	 *
	 * @param scienceAppOutputPortsPersistence the science app output ports persistence
	 */
	public void setScienceAppOutputPortsPersistence(
		ScienceAppOutputPortsPersistence scienceAppOutputPortsPersistence) {
		this.scienceAppOutputPortsPersistence = scienceAppOutputPortsPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return PortType.class;
	}

	protected String getModelClassName() {
		return PortType.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = portTypePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.kisti.science.platform.app.service.AppTestHistoryLocalService.class)
	protected com.kisti.science.platform.app.service.AppTestHistoryLocalService appTestHistoryLocalService;
	@BeanReference(type = com.kisti.science.platform.app.service.AppTestHistoryService.class)
	protected com.kisti.science.platform.app.service.AppTestHistoryService appTestHistoryService;
	@BeanReference(type = com.kisti.science.platform.app.service.CommonLibraryLocalService.class)
	protected com.kisti.science.platform.app.service.CommonLibraryLocalService commonLibraryLocalService;
	@BeanReference(type = com.kisti.science.platform.app.service.CommonLibraryService.class)
	protected com.kisti.science.platform.app.service.CommonLibraryService commonLibraryService;
	@BeanReference(type = CommonLibraryPersistence.class)
	protected CommonLibraryPersistence commonLibraryPersistence;
	@BeanReference(type = com.kisti.science.platform.app.service.CommonModuleService.class)
	protected com.kisti.science.platform.app.service.CommonModuleService commonModuleService;
	@BeanReference(type = CommonModulePersistence.class)
	protected CommonModulePersistence commonModulePersistence;
	@BeanReference(type = com.kisti.science.platform.app.service.CommonPackageLocalService.class)
	protected com.kisti.science.platform.app.service.CommonPackageLocalService commonPackageLocalService;
	@BeanReference(type = com.kisti.science.platform.app.service.CommonPackageService.class)
	protected com.kisti.science.platform.app.service.CommonPackageService commonPackageService;
	@BeanReference(type = CommonPackagePersistence.class)
	protected CommonPackagePersistence commonPackagePersistence;
	@BeanReference(type = com.kisti.science.platform.app.service.PortTypeLocalService.class)
	protected com.kisti.science.platform.app.service.PortTypeLocalService portTypeLocalService;
	@BeanReference(type = com.kisti.science.platform.app.service.PortTypeService.class)
	protected com.kisti.science.platform.app.service.PortTypeService portTypeService;
	@BeanReference(type = PortTypePersistence.class)
	protected PortTypePersistence portTypePersistence;
	@BeanReference(type = com.kisti.science.platform.app.service.PortTypeAnalyzerLinkLocalService.class)
	protected com.kisti.science.platform.app.service.PortTypeAnalyzerLinkLocalService portTypeAnalyzerLinkLocalService;
	@BeanReference(type = com.kisti.science.platform.app.service.PortTypeAnalyzerLinkService.class)
	protected com.kisti.science.platform.app.service.PortTypeAnalyzerLinkService portTypeAnalyzerLinkService;
	@BeanReference(type = PortTypeAnalyzerLinkPersistence.class)
	protected PortTypeAnalyzerLinkPersistence portTypeAnalyzerLinkPersistence;
	@BeanReference(type = com.kisti.science.platform.app.service.PortTypeEditorLinkLocalService.class)
	protected com.kisti.science.platform.app.service.PortTypeEditorLinkLocalService portTypeEditorLinkLocalService;
	@BeanReference(type = com.kisti.science.platform.app.service.PortTypeEditorLinkService.class)
	protected com.kisti.science.platform.app.service.PortTypeEditorLinkService portTypeEditorLinkService;
	@BeanReference(type = PortTypeEditorLinkPersistence.class)
	protected PortTypeEditorLinkPersistence portTypeEditorLinkPersistence;
	@BeanReference(type = com.kisti.science.platform.app.service.PortTypeInputdeckFormLocalService.class)
	protected com.kisti.science.platform.app.service.PortTypeInputdeckFormLocalService portTypeInputdeckFormLocalService;
	@BeanReference(type = PortTypeInputdeckFormPersistence.class)
	protected PortTypeInputdeckFormPersistence portTypeInputdeckFormPersistence;
	@BeanReference(type = com.kisti.science.platform.app.service.ScienceAppLocalService.class)
	protected com.kisti.science.platform.app.service.ScienceAppLocalService scienceAppLocalService;
	@BeanReference(type = com.kisti.science.platform.app.service.ScienceAppService.class)
	protected com.kisti.science.platform.app.service.ScienceAppService scienceAppService;
	@BeanReference(type = ScienceAppPersistence.class)
	protected ScienceAppPersistence scienceAppPersistence;
	@BeanReference(type = ScienceAppFinder.class)
	protected ScienceAppFinder scienceAppFinder;
	@BeanReference(type = com.kisti.science.platform.app.service.ScienceAppCategoryLinkLocalService.class)
	protected com.kisti.science.platform.app.service.ScienceAppCategoryLinkLocalService scienceAppCategoryLinkLocalService;
	@BeanReference(type = com.kisti.science.platform.app.service.ScienceAppCategoryLinkService.class)
	protected com.kisti.science.platform.app.service.ScienceAppCategoryLinkService scienceAppCategoryLinkService;
	@BeanReference(type = ScienceAppCategoryLinkPersistence.class)
	protected ScienceAppCategoryLinkPersistence scienceAppCategoryLinkPersistence;
	@BeanReference(type = com.kisti.science.platform.app.service.ScienceAppInputPortsLocalService.class)
	protected com.kisti.science.platform.app.service.ScienceAppInputPortsLocalService scienceAppInputPortsLocalService;
	@BeanReference(type = ScienceAppInputPortsPersistence.class)
	protected ScienceAppInputPortsPersistence scienceAppInputPortsPersistence;
	@BeanReference(type = com.kisti.science.platform.app.service.ScienceAppManagerLocalService.class)
	protected com.kisti.science.platform.app.service.ScienceAppManagerLocalService scienceAppManagerLocalService;
	@BeanReference(type = com.kisti.science.platform.app.service.ScienceAppManagerService.class)
	protected com.kisti.science.platform.app.service.ScienceAppManagerService scienceAppManagerService;
	@BeanReference(type = ScienceAppManagerPersistence.class)
	protected ScienceAppManagerPersistence scienceAppManagerPersistence;
	@BeanReference(type = com.kisti.science.platform.app.service.ScienceAppOutputPortsLocalService.class)
	protected com.kisti.science.platform.app.service.ScienceAppOutputPortsLocalService scienceAppOutputPortsLocalService;
	@BeanReference(type = ScienceAppOutputPortsPersistence.class)
	protected ScienceAppOutputPortsPersistence scienceAppOutputPortsPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private PortTypeServiceClpInvoker _clpInvoker = new PortTypeServiceClpInvoker();
}