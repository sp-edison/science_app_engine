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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import science.platform.model.SpDomain;

import java.util.List;

/**
 * The persistence utility for the sp domain service. This utility wraps {@link SpDomainPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpDomainPersistence
 * @see SpDomainPersistenceImpl
 * @generated
 */
public class SpDomainUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SpDomain spDomain) {
		getPersistence().clearCache(spDomain);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SpDomain> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SpDomain> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SpDomain> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SpDomain update(SpDomain spDomain) throws SystemException {
		return getPersistence().update(spDomain);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SpDomain update(SpDomain spDomain,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spDomain, serviceContext);
	}

	/**
	* Returns the sp domain where spDomainCode = &#63; or throws a {@link science.platform.NoSuchSpDomainException} if it could not be found.
	*
	* @param spDomainCode the sp domain code
	* @return the matching sp domain
	* @throws science.platform.NoSuchSpDomainException if a matching sp domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpDomain findByDomainCode(
		java.lang.String spDomainCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpDomainException {
		return getPersistence().findByDomainCode(spDomainCode);
	}

	/**
	* Returns the sp domain where spDomainCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spDomainCode the sp domain code
	* @return the matching sp domain, or <code>null</code> if a matching sp domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpDomain fetchByDomainCode(
		java.lang.String spDomainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDomainCode(spDomainCode);
	}

	/**
	* Returns the sp domain where spDomainCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spDomainCode the sp domain code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching sp domain, or <code>null</code> if a matching sp domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpDomain fetchByDomainCode(
		java.lang.String spDomainCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDomainCode(spDomainCode, retrieveFromCache);
	}

	/**
	* Removes the sp domain where spDomainCode = &#63; from the database.
	*
	* @param spDomainCode the sp domain code
	* @return the sp domain that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpDomain removeByDomainCode(
		java.lang.String spDomainCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpDomainException {
		return getPersistence().removeByDomainCode(spDomainCode);
	}

	/**
	* Returns the number of sp domains where spDomainCode = &#63;.
	*
	* @param spDomainCode the sp domain code
	* @return the number of matching sp domains
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDomainCode(java.lang.String spDomainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDomainCode(spDomainCode);
	}

	/**
	* Caches the sp domain in the entity cache if it is enabled.
	*
	* @param spDomain the sp domain
	*/
	public static void cacheResult(science.platform.model.SpDomain spDomain) {
		getPersistence().cacheResult(spDomain);
	}

	/**
	* Caches the sp domains in the entity cache if it is enabled.
	*
	* @param spDomains the sp domains
	*/
	public static void cacheResult(
		java.util.List<science.platform.model.SpDomain> spDomains) {
		getPersistence().cacheResult(spDomains);
	}

	/**
	* Creates a new sp domain with the primary key. Does not add the sp domain to the database.
	*
	* @param spDomainId the primary key for the new sp domain
	* @return the new sp domain
	*/
	public static science.platform.model.SpDomain create(long spDomainId) {
		return getPersistence().create(spDomainId);
	}

	/**
	* Removes the sp domain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spDomainId the primary key of the sp domain
	* @return the sp domain that was removed
	* @throws science.platform.NoSuchSpDomainException if a sp domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpDomain remove(long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpDomainException {
		return getPersistence().remove(spDomainId);
	}

	public static science.platform.model.SpDomain updateImpl(
		science.platform.model.SpDomain spDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spDomain);
	}

	/**
	* Returns the sp domain with the primary key or throws a {@link science.platform.NoSuchSpDomainException} if it could not be found.
	*
	* @param spDomainId the primary key of the sp domain
	* @return the sp domain
	* @throws science.platform.NoSuchSpDomainException if a sp domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpDomain findByPrimaryKey(
		long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpDomainException {
		return getPersistence().findByPrimaryKey(spDomainId);
	}

	/**
	* Returns the sp domain with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spDomainId the primary key of the sp domain
	* @return the sp domain, or <code>null</code> if a sp domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpDomain fetchByPrimaryKey(
		long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spDomainId);
	}

	/**
	* Returns all the sp domains.
	*
	* @return the sp domains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpDomain> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<science.platform.model.SpDomain> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<science.platform.model.SpDomain> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the sp domains from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sp domains.
	*
	* @return the number of sp domains
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SpDomainPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SpDomainPersistence)PortletBeanLocatorUtil.locate(science.platform.service.ClpSerializer.getServletContextName(),
					SpDomainPersistence.class.getName());

			ReferenceRegistry.registerReference(SpDomainUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SpDomainPersistence persistence) {
	}

	private static SpDomainPersistence _persistence;
}