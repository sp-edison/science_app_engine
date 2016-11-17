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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for ScienceAppManager. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppManagerServiceUtil
 * @see com.kisti.science.platform.app.service.base.ScienceAppManagerServiceBaseImpl
 * @see com.kisti.science.platform.app.service.impl.ScienceAppManagerServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ScienceAppManagerService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScienceAppManagerServiceUtil} to access the science app manager remote service. Add custom service methods to {@link com.kisti.science.platform.app.service.impl.ScienceAppManagerServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public com.kisti.science.platform.app.model.ScienceAppManager addScienceAppManager(
		long managerId, long scienceAppId,
		com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void removeSicenceAppManager(long scienceAppManagerId)
		throws com.kisti.science.platform.app.NoSuchManagerException,
			com.liferay.portal.kernel.exception.SystemException;

	public void removeScienceAppManagerByManagerId(long managerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void removeScienceAppManagerByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateScienceAppManager(
		com.kisti.science.platform.app.model.ScienceAppManager appManager)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getScienceAppIdsByManagerId(long managerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getManagetIdsByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Save uploaded file to new location
	*
	* @param uploadedInputStream
	* @param uploadedFileLocation
	* @return
	*/
	public java.io.File saveToFile(java.io.InputStream uploadedInputStream,
		java.lang.String uploadedFileLocation);

	public java.lang.String unzipSciAppZipFile(java.lang.String strSciAppName,
		java.lang.String strSciAppVer, java.io.File zipFile,
		java.lang.String strZipRootDirName);

	/**
	* Execute a given command
	*
	* @param command a given command
	* @return install message
	*/
	public java.lang.String executeCommand(java.lang.String command);

	/**
	* Create a directory
	*
	* @param givenPath a given path
	* @return install message
	*/
	public java.lang.String makeDir(java.lang.String givenPath);

	public int checkAck(java.io.InputStream in) throws java.io.IOException;

	public java.lang.String executeLibInstall(
		java.lang.String uploadedLibFileLocation, java.lang.String fileName);

	public java.lang.String remoteMakeDir(java.lang.String hostName,
		java.lang.String portNumber, java.lang.String userID,
		java.lang.String password);

	/**
	* Install a library
	*
	* @param libName library name
	* @param libFile library file
	* @return
	*/
	public java.lang.String installLibFile(java.lang.String libFileName,
		java.io.File libFile);
}