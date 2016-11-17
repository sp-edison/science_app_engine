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

import science.platform.model.SpUserDomain;

import java.util.List;

/**
 * The persistence utility for the sp user domain service. This utility wraps {@link SpUserDomainPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpUserDomainPersistence
 * @see SpUserDomainPersistenceImpl
 * @generated
 */
public class SpUserDomainUtil {
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
	public static void clearCache(SpUserDomain spUserDomain) {
		getPersistence().clearCache(spUserDomain);
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
	public static List<SpUserDomain> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SpUserDomain> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SpUserDomain> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SpUserDomain update(SpUserDomain spUserDomain)
		throws SystemException {
		return getPersistence().update(spUserDomain);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SpUserDomain update(SpUserDomain spUserDomain,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spUserDomain, serviceContext);
	}

	/**
	* Returns all the sp user domains where spUserId = &#63;.
	*
	* @param spUserId the sp user ID
	* @return the matching sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpUserDomain> findBySpUserId(
		long spUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySpUserId(spUserId);
	}

	/**
	* Returns a range of all the sp user domains where spUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpUserDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spUserId the sp user ID
	* @param start the lower bound of the range of sp user domains
	* @param end the upper bound of the range of sp user domains (not inclusive)
	* @return the range of matching sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpUserDomain> findBySpUserId(
		long spUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySpUserId(spUserId, start, end);
	}

	/**
	* Returns an ordered range of all the sp user domains where spUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpUserDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spUserId the sp user ID
	* @param start the lower bound of the range of sp user domains
	* @param end the upper bound of the range of sp user domains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpUserDomain> findBySpUserId(
		long spUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySpUserId(spUserId, start, end, orderByComparator);
	}

	/**
	* Returns the first sp user domain in the ordered set where spUserId = &#63;.
	*
	* @param spUserId the sp user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sp user domain
	* @throws science.platform.NoSuchSpUserDomainException if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain findBySpUserId_First(
		long spUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException {
		return getPersistence().findBySpUserId_First(spUserId, orderByComparator);
	}

	/**
	* Returns the first sp user domain in the ordered set where spUserId = &#63;.
	*
	* @param spUserId the sp user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain fetchBySpUserId_First(
		long spUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySpUserId_First(spUserId, orderByComparator);
	}

	/**
	* Returns the last sp user domain in the ordered set where spUserId = &#63;.
	*
	* @param spUserId the sp user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sp user domain
	* @throws science.platform.NoSuchSpUserDomainException if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain findBySpUserId_Last(
		long spUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException {
		return getPersistence().findBySpUserId_Last(spUserId, orderByComparator);
	}

	/**
	* Returns the last sp user domain in the ordered set where spUserId = &#63;.
	*
	* @param spUserId the sp user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain fetchBySpUserId_Last(
		long spUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySpUserId_Last(spUserId, orderByComparator);
	}

	/**
	* Returns the sp user domains before and after the current sp user domain in the ordered set where spUserId = &#63;.
	*
	* @param spUserDomainId the primary key of the current sp user domain
	* @param spUserId the sp user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sp user domain
	* @throws science.platform.NoSuchSpUserDomainException if a sp user domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain[] findBySpUserId_PrevAndNext(
		long spUserDomainId, long spUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException {
		return getPersistence()
				   .findBySpUserId_PrevAndNext(spUserDomainId, spUserId,
			orderByComparator);
	}

	/**
	* Removes all the sp user domains where spUserId = &#63; from the database.
	*
	* @param spUserId the sp user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySpUserId(long spUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySpUserId(spUserId);
	}

	/**
	* Returns the number of sp user domains where spUserId = &#63;.
	*
	* @param spUserId the sp user ID
	* @return the number of matching sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySpUserId(long spUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySpUserId(spUserId);
	}

	/**
	* Returns all the sp user domains where spDomainId = &#63;.
	*
	* @param spDomainId the sp domain ID
	* @return the matching sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpUserDomain> findBySpDomainId(
		long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySpDomainId(spDomainId);
	}

	/**
	* Returns a range of all the sp user domains where spDomainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpUserDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spDomainId the sp domain ID
	* @param start the lower bound of the range of sp user domains
	* @param end the upper bound of the range of sp user domains (not inclusive)
	* @return the range of matching sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpUserDomain> findBySpDomainId(
		long spDomainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySpDomainId(spDomainId, start, end);
	}

	/**
	* Returns an ordered range of all the sp user domains where spDomainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpUserDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spDomainId the sp domain ID
	* @param start the lower bound of the range of sp user domains
	* @param end the upper bound of the range of sp user domains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpUserDomain> findBySpDomainId(
		long spDomainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySpDomainId(spDomainId, start, end, orderByComparator);
	}

	/**
	* Returns the first sp user domain in the ordered set where spDomainId = &#63;.
	*
	* @param spDomainId the sp domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sp user domain
	* @throws science.platform.NoSuchSpUserDomainException if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain findBySpDomainId_First(
		long spDomainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException {
		return getPersistence()
				   .findBySpDomainId_First(spDomainId, orderByComparator);
	}

	/**
	* Returns the first sp user domain in the ordered set where spDomainId = &#63;.
	*
	* @param spDomainId the sp domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain fetchBySpDomainId_First(
		long spDomainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySpDomainId_First(spDomainId, orderByComparator);
	}

	/**
	* Returns the last sp user domain in the ordered set where spDomainId = &#63;.
	*
	* @param spDomainId the sp domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sp user domain
	* @throws science.platform.NoSuchSpUserDomainException if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain findBySpDomainId_Last(
		long spDomainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException {
		return getPersistence()
				   .findBySpDomainId_Last(spDomainId, orderByComparator);
	}

	/**
	* Returns the last sp user domain in the ordered set where spDomainId = &#63;.
	*
	* @param spDomainId the sp domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain fetchBySpDomainId_Last(
		long spDomainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySpDomainId_Last(spDomainId, orderByComparator);
	}

	/**
	* Returns the sp user domains before and after the current sp user domain in the ordered set where spDomainId = &#63;.
	*
	* @param spUserDomainId the primary key of the current sp user domain
	* @param spDomainId the sp domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sp user domain
	* @throws science.platform.NoSuchSpUserDomainException if a sp user domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain[] findBySpDomainId_PrevAndNext(
		long spUserDomainId, long spDomainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException {
		return getPersistence()
				   .findBySpDomainId_PrevAndNext(spUserDomainId, spDomainId,
			orderByComparator);
	}

	/**
	* Removes all the sp user domains where spDomainId = &#63; from the database.
	*
	* @param spDomainId the sp domain ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySpDomainId(long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySpDomainId(spDomainId);
	}

	/**
	* Returns the number of sp user domains where spDomainId = &#63;.
	*
	* @param spDomainId the sp domain ID
	* @return the number of matching sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySpDomainId(long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySpDomainId(spDomainId);
	}

	/**
	* Returns the sp user domain where spUserId = &#63; and spDomainId = &#63; or throws a {@link science.platform.NoSuchSpUserDomainException} if it could not be found.
	*
	* @param spUserId the sp user ID
	* @param spDomainId the sp domain ID
	* @return the matching sp user domain
	* @throws science.platform.NoSuchSpUserDomainException if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain findBySpUserDomainId(
		long spUserId, long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException {
		return getPersistence().findBySpUserDomainId(spUserId, spDomainId);
	}

	/**
	* Returns the sp user domain where spUserId = &#63; and spDomainId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spUserId the sp user ID
	* @param spDomainId the sp domain ID
	* @return the matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain fetchBySpUserDomainId(
		long spUserId, long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySpUserDomainId(spUserId, spDomainId);
	}

	/**
	* Returns the sp user domain where spUserId = &#63; and spDomainId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spUserId the sp user ID
	* @param spDomainId the sp domain ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain fetchBySpUserDomainId(
		long spUserId, long spDomainId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySpUserDomainId(spUserId, spDomainId,
			retrieveFromCache);
	}

	/**
	* Removes the sp user domain where spUserId = &#63; and spDomainId = &#63; from the database.
	*
	* @param spUserId the sp user ID
	* @param spDomainId the sp domain ID
	* @return the sp user domain that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain removeBySpUserDomainId(
		long spUserId, long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException {
		return getPersistence().removeBySpUserDomainId(spUserId, spDomainId);
	}

	/**
	* Returns the number of sp user domains where spUserId = &#63; and spDomainId = &#63;.
	*
	* @param spUserId the sp user ID
	* @param spDomainId the sp domain ID
	* @return the number of matching sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySpUserDomainId(long spUserId, long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySpUserDomainId(spUserId, spDomainId);
	}

	/**
	* Caches the sp user domain in the entity cache if it is enabled.
	*
	* @param spUserDomain the sp user domain
	*/
	public static void cacheResult(
		science.platform.model.SpUserDomain spUserDomain) {
		getPersistence().cacheResult(spUserDomain);
	}

	/**
	* Caches the sp user domains in the entity cache if it is enabled.
	*
	* @param spUserDomains the sp user domains
	*/
	public static void cacheResult(
		java.util.List<science.platform.model.SpUserDomain> spUserDomains) {
		getPersistence().cacheResult(spUserDomains);
	}

	/**
	* Creates a new sp user domain with the primary key. Does not add the sp user domain to the database.
	*
	* @param spUserDomainId the primary key for the new sp user domain
	* @return the new sp user domain
	*/
	public static science.platform.model.SpUserDomain create(
		long spUserDomainId) {
		return getPersistence().create(spUserDomainId);
	}

	/**
	* Removes the sp user domain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spUserDomainId the primary key of the sp user domain
	* @return the sp user domain that was removed
	* @throws science.platform.NoSuchSpUserDomainException if a sp user domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain remove(
		long spUserDomainId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException {
		return getPersistence().remove(spUserDomainId);
	}

	public static science.platform.model.SpUserDomain updateImpl(
		science.platform.model.SpUserDomain spUserDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spUserDomain);
	}

	/**
	* Returns the sp user domain with the primary key or throws a {@link science.platform.NoSuchSpUserDomainException} if it could not be found.
	*
	* @param spUserDomainId the primary key of the sp user domain
	* @return the sp user domain
	* @throws science.platform.NoSuchSpUserDomainException if a sp user domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain findByPrimaryKey(
		long spUserDomainId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException {
		return getPersistence().findByPrimaryKey(spUserDomainId);
	}

	/**
	* Returns the sp user domain with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spUserDomainId the primary key of the sp user domain
	* @return the sp user domain, or <code>null</code> if a sp user domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpUserDomain fetchByPrimaryKey(
		long spUserDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spUserDomainId);
	}

	/**
	* Returns all the sp user domains.
	*
	* @return the sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpUserDomain> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the sp user domains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpUserDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sp user domains
	* @param end the upper bound of the range of sp user domains (not inclusive)
	* @return the range of sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpUserDomain> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the sp user domains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpUserDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sp user domains
	* @param end the upper bound of the range of sp user domains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpUserDomain> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the sp user domains from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sp user domains.
	*
	* @return the number of sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SpUserDomainPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SpUserDomainPersistence)PortletBeanLocatorUtil.locate(science.platform.service.ClpSerializer.getServletContextName(),
					SpUserDomainPersistence.class.getName());

			ReferenceRegistry.registerReference(SpUserDomainUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SpUserDomainPersistence persistence) {
	}

	private static SpUserDomainPersistence _persistence;
}