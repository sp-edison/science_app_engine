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

import science.platform.model.SpUserDomain;

/**
 * The persistence interface for the sp user domain service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpUserDomainPersistenceImpl
 * @see SpUserDomainUtil
 * @generated
 */
public interface SpUserDomainPersistence extends BasePersistence<SpUserDomain> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SpUserDomainUtil} to access the sp user domain persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the sp user domains where spUserId = &#63;.
	*
	* @param spUserId the sp user ID
	* @return the matching sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<science.platform.model.SpUserDomain> findBySpUserId(
		long spUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<science.platform.model.SpUserDomain> findBySpUserId(
		long spUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<science.platform.model.SpUserDomain> findBySpUserId(
		long spUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sp user domain in the ordered set where spUserId = &#63;.
	*
	* @param spUserId the sp user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sp user domain
	* @throws science.platform.NoSuchSpUserDomainException if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpUserDomain findBySpUserId_First(
		long spUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException;

	/**
	* Returns the first sp user domain in the ordered set where spUserId = &#63;.
	*
	* @param spUserId the sp user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpUserDomain fetchBySpUserId_First(
		long spUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sp user domain in the ordered set where spUserId = &#63;.
	*
	* @param spUserId the sp user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sp user domain
	* @throws science.platform.NoSuchSpUserDomainException if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpUserDomain findBySpUserId_Last(
		long spUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException;

	/**
	* Returns the last sp user domain in the ordered set where spUserId = &#63;.
	*
	* @param spUserId the sp user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpUserDomain fetchBySpUserId_Last(
		long spUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public science.platform.model.SpUserDomain[] findBySpUserId_PrevAndNext(
		long spUserDomainId, long spUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException;

	/**
	* Removes all the sp user domains where spUserId = &#63; from the database.
	*
	* @param spUserId the sp user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySpUserId(long spUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sp user domains where spUserId = &#63;.
	*
	* @param spUserId the sp user ID
	* @return the number of matching sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public int countBySpUserId(long spUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sp user domains where spDomainId = &#63;.
	*
	* @param spDomainId the sp domain ID
	* @return the matching sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<science.platform.model.SpUserDomain> findBySpDomainId(
		long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<science.platform.model.SpUserDomain> findBySpDomainId(
		long spDomainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<science.platform.model.SpUserDomain> findBySpDomainId(
		long spDomainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sp user domain in the ordered set where spDomainId = &#63;.
	*
	* @param spDomainId the sp domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sp user domain
	* @throws science.platform.NoSuchSpUserDomainException if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpUserDomain findBySpDomainId_First(
		long spDomainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException;

	/**
	* Returns the first sp user domain in the ordered set where spDomainId = &#63;.
	*
	* @param spDomainId the sp domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpUserDomain fetchBySpDomainId_First(
		long spDomainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sp user domain in the ordered set where spDomainId = &#63;.
	*
	* @param spDomainId the sp domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sp user domain
	* @throws science.platform.NoSuchSpUserDomainException if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpUserDomain findBySpDomainId_Last(
		long spDomainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException;

	/**
	* Returns the last sp user domain in the ordered set where spDomainId = &#63;.
	*
	* @param spDomainId the sp domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpUserDomain fetchBySpDomainId_Last(
		long spDomainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public science.platform.model.SpUserDomain[] findBySpDomainId_PrevAndNext(
		long spUserDomainId, long spDomainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException;

	/**
	* Removes all the sp user domains where spDomainId = &#63; from the database.
	*
	* @param spDomainId the sp domain ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySpDomainId(long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sp user domains where spDomainId = &#63;.
	*
	* @param spDomainId the sp domain ID
	* @return the number of matching sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public int countBySpDomainId(long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sp user domain where spUserId = &#63; and spDomainId = &#63; or throws a {@link science.platform.NoSuchSpUserDomainException} if it could not be found.
	*
	* @param spUserId the sp user ID
	* @param spDomainId the sp domain ID
	* @return the matching sp user domain
	* @throws science.platform.NoSuchSpUserDomainException if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpUserDomain findBySpUserDomainId(
		long spUserId, long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException;

	/**
	* Returns the sp user domain where spUserId = &#63; and spDomainId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spUserId the sp user ID
	* @param spDomainId the sp domain ID
	* @return the matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpUserDomain fetchBySpUserDomainId(
		long spUserId, long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sp user domain where spUserId = &#63; and spDomainId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spUserId the sp user ID
	* @param spDomainId the sp domain ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpUserDomain fetchBySpUserDomainId(
		long spUserId, long spDomainId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the sp user domain where spUserId = &#63; and spDomainId = &#63; from the database.
	*
	* @param spUserId the sp user ID
	* @param spDomainId the sp domain ID
	* @return the sp user domain that was removed
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpUserDomain removeBySpUserDomainId(
		long spUserId, long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException;

	/**
	* Returns the number of sp user domains where spUserId = &#63; and spDomainId = &#63;.
	*
	* @param spUserId the sp user ID
	* @param spDomainId the sp domain ID
	* @return the number of matching sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public int countBySpUserDomainId(long spUserId, long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the sp user domain in the entity cache if it is enabled.
	*
	* @param spUserDomain the sp user domain
	*/
	public void cacheResult(science.platform.model.SpUserDomain spUserDomain);

	/**
	* Caches the sp user domains in the entity cache if it is enabled.
	*
	* @param spUserDomains the sp user domains
	*/
	public void cacheResult(
		java.util.List<science.platform.model.SpUserDomain> spUserDomains);

	/**
	* Creates a new sp user domain with the primary key. Does not add the sp user domain to the database.
	*
	* @param spUserDomainId the primary key for the new sp user domain
	* @return the new sp user domain
	*/
	public science.platform.model.SpUserDomain create(long spUserDomainId);

	/**
	* Removes the sp user domain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spUserDomainId the primary key of the sp user domain
	* @return the sp user domain that was removed
	* @throws science.platform.NoSuchSpUserDomainException if a sp user domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpUserDomain remove(long spUserDomainId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException;

	public science.platform.model.SpUserDomain updateImpl(
		science.platform.model.SpUserDomain spUserDomain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sp user domain with the primary key or throws a {@link science.platform.NoSuchSpUserDomainException} if it could not be found.
	*
	* @param spUserDomainId the primary key of the sp user domain
	* @return the sp user domain
	* @throws science.platform.NoSuchSpUserDomainException if a sp user domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpUserDomain findByPrimaryKey(
		long spUserDomainId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpUserDomainException;

	/**
	* Returns the sp user domain with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spUserDomainId the primary key of the sp user domain
	* @return the sp user domain, or <code>null</code> if a sp user domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpUserDomain fetchByPrimaryKey(
		long spUserDomainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sp user domains.
	*
	* @return the sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<science.platform.model.SpUserDomain> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<science.platform.model.SpUserDomain> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<science.platform.model.SpUserDomain> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sp user domains from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sp user domains.
	*
	* @return the number of sp user domains
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}