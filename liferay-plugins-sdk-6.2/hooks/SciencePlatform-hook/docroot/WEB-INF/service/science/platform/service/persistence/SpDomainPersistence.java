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

package science.platform.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import science.platform.model.SpDomain;

/**
 * The persistence interface for the sp domain service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpDomainPersistenceImpl
 * @see SpDomainUtil
 * @generated
 */
public interface SpDomainPersistence extends BasePersistence<SpDomain> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SpDomainUtil} to access the sp domain persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the sp domain where spDomainCode = &#63; or throws a {@link science.platform.NoSuchSpDomainException} if it could not be found.
	*
	* @param spDomainCode the sp domain code
	* @return the matching sp domain
	* @throws science.platform.NoSuchSpDomainException if a matching sp domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpDomain findByDomainCode(
		java.lang.String spDomainCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpDomainException;

	/**
	* Returns the sp domain where spDomainCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spDomainCode the sp domain code
	* @return the matching sp domain, or <code>null</code> if a matching sp domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpDomain fetchByDomainCode(
		java.lang.String spDomainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sp domain where spDomainCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spDomainCode the sp domain code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching sp domain, or <code>null</code> if a matching sp domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpDomain fetchByDomainCode(
		java.lang.String spDomainCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the sp domain where spDomainCode = &#63; from the database.
	*
	* @param spDomainCode the sp domain code
	* @return the sp domain that was removed
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpDomain removeByDomainCode(
		java.lang.String spDomainCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpDomainException;

	/**
	* Returns the number of sp domains where spDomainCode = &#63;.
	*
	* @param spDomainCode the sp domain code
	* @return the number of matching sp domains
	* @throws SystemException if a system exception occurred
	*/
	public int countByDomainCode(java.lang.String spDomainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the sp domain in the entity cache if it is enabled.
	*
	* @param spDomain the sp domain
	*/
	public void cacheResult(science.platform.model.SpDomain spDomain);

	/**
	* Caches the sp domains in the entity cache if it is enabled.
	*
	* @param spDomains the sp domains
	*/
	public void cacheResult(
		java.util.List<science.platform.model.SpDomain> spDomains);

	/**
	* Creates a new sp domain with the primary key. Does not add the sp domain to the database.
	*
	* @param spDomainId the primary key for the new sp domain
	* @return the new sp domain
	*/
	public science.platform.model.SpDomain create(long spDomainId);

	/**
	* Removes the sp domain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spDomainId the primary key of the sp domain
	* @return the sp domain that was removed
	* @throws science.platform.NoSuchSpDomainException if a sp domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpDomain remove(long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpDomainException;

	public science.platform.model.SpDomain updateImpl(
		science.platform.model.SpDomain spDomain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sp domain with the primary key or throws a {@link science.platform.NoSuchSpDomainException} if it could not be found.
	*
	* @param spDomainId the primary key of the sp domain
	* @return the sp domain
	* @throws science.platform.NoSuchSpDomainException if a sp domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpDomain findByPrimaryKey(long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpDomainException;

	/**
	* Returns the sp domain with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spDomainId the primary key of the sp domain
	* @return the sp domain, or <code>null</code> if a sp domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpDomain fetchByPrimaryKey(long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sp domains.
	*
	* @return the sp domains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<science.platform.model.SpDomain> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the sp domains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sp domains
	* @param end the upper bound of the range of sp domains (not inclusive)
	* @return the range of sp domains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<science.platform.model.SpDomain> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the sp domains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sp domains
	* @param end the upper bound of the range of sp domains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sp domains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<science.platform.model.SpDomain> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sp domains from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sp domains.
	*
	* @return the number of sp domains
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}