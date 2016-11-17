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

import science.platform.model.SpAffiliation;

/**
 * The persistence interface for the sp affiliation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpAffiliationPersistenceImpl
 * @see SpAffiliationUtil
 * @generated
 */
public interface SpAffiliationPersistence extends BasePersistence<SpAffiliation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SpAffiliationUtil} to access the sp affiliation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the sp affiliation where spRegionId = &#63; and spAffiliationCode = &#63; or throws a {@link science.platform.NoSuchSpAffiliationException} if it could not be found.
	*
	* @param spRegionId the sp region ID
	* @param spAffiliationCode the sp affiliation code
	* @return the matching sp affiliation
	* @throws science.platform.NoSuchSpAffiliationException if a matching sp affiliation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation findByAffiliationCode(
		long spRegionId, java.lang.String spAffiliationCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpAffiliationException;

	/**
	* Returns the sp affiliation where spRegionId = &#63; and spAffiliationCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spRegionId the sp region ID
	* @param spAffiliationCode the sp affiliation code
	* @return the matching sp affiliation, or <code>null</code> if a matching sp affiliation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation fetchByAffiliationCode(
		long spRegionId, java.lang.String spAffiliationCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sp affiliation where spRegionId = &#63; and spAffiliationCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spRegionId the sp region ID
	* @param spAffiliationCode the sp affiliation code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching sp affiliation, or <code>null</code> if a matching sp affiliation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation fetchByAffiliationCode(
		long spRegionId, java.lang.String spAffiliationCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the sp affiliation where spRegionId = &#63; and spAffiliationCode = &#63; from the database.
	*
	* @param spRegionId the sp region ID
	* @param spAffiliationCode the sp affiliation code
	* @return the sp affiliation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation removeByAffiliationCode(
		long spRegionId, java.lang.String spAffiliationCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpAffiliationException;

	/**
	* Returns the number of sp affiliations where spRegionId = &#63; and spAffiliationCode = &#63;.
	*
	* @param spRegionId the sp region ID
	* @param spAffiliationCode the sp affiliation code
	* @return the number of matching sp affiliations
	* @throws SystemException if a system exception occurred
	*/
	public int countByAffiliationCode(long spRegionId,
		java.lang.String spAffiliationCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sp affiliations where spCountryId = &#63;.
	*
	* @param spCountryId the sp country ID
	* @return the matching sp affiliations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<science.platform.model.SpAffiliation> findByCountryId(
		long spCountryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the sp affiliations where spCountryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpAffiliationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCountryId the sp country ID
	* @param start the lower bound of the range of sp affiliations
	* @param end the upper bound of the range of sp affiliations (not inclusive)
	* @return the range of matching sp affiliations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<science.platform.model.SpAffiliation> findByCountryId(
		long spCountryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the sp affiliations where spCountryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpAffiliationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCountryId the sp country ID
	* @param start the lower bound of the range of sp affiliations
	* @param end the upper bound of the range of sp affiliations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sp affiliations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<science.platform.model.SpAffiliation> findByCountryId(
		long spCountryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sp affiliation in the ordered set where spCountryId = &#63;.
	*
	* @param spCountryId the sp country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sp affiliation
	* @throws science.platform.NoSuchSpAffiliationException if a matching sp affiliation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation findByCountryId_First(
		long spCountryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpAffiliationException;

	/**
	* Returns the first sp affiliation in the ordered set where spCountryId = &#63;.
	*
	* @param spCountryId the sp country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sp affiliation, or <code>null</code> if a matching sp affiliation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation fetchByCountryId_First(
		long spCountryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sp affiliation in the ordered set where spCountryId = &#63;.
	*
	* @param spCountryId the sp country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sp affiliation
	* @throws science.platform.NoSuchSpAffiliationException if a matching sp affiliation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation findByCountryId_Last(
		long spCountryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpAffiliationException;

	/**
	* Returns the last sp affiliation in the ordered set where spCountryId = &#63;.
	*
	* @param spCountryId the sp country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sp affiliation, or <code>null</code> if a matching sp affiliation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation fetchByCountryId_Last(
		long spCountryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sp affiliations before and after the current sp affiliation in the ordered set where spCountryId = &#63;.
	*
	* @param spAffiliationId the primary key of the current sp affiliation
	* @param spCountryId the sp country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sp affiliation
	* @throws science.platform.NoSuchSpAffiliationException if a sp affiliation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation[] findByCountryId_PrevAndNext(
		long spAffiliationId, long spCountryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpAffiliationException;

	/**
	* Removes all the sp affiliations where spCountryId = &#63; from the database.
	*
	* @param spCountryId the sp country ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCountryId(long spCountryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sp affiliations where spCountryId = &#63;.
	*
	* @param spCountryId the sp country ID
	* @return the number of matching sp affiliations
	* @throws SystemException if a system exception occurred
	*/
	public int countByCountryId(long spCountryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sp affiliations where spRegionId = &#63;.
	*
	* @param spRegionId the sp region ID
	* @return the matching sp affiliations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<science.platform.model.SpAffiliation> findByRegionId(
		long spRegionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the sp affiliations where spRegionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpAffiliationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spRegionId the sp region ID
	* @param start the lower bound of the range of sp affiliations
	* @param end the upper bound of the range of sp affiliations (not inclusive)
	* @return the range of matching sp affiliations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<science.platform.model.SpAffiliation> findByRegionId(
		long spRegionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the sp affiliations where spRegionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpAffiliationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spRegionId the sp region ID
	* @param start the lower bound of the range of sp affiliations
	* @param end the upper bound of the range of sp affiliations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sp affiliations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<science.platform.model.SpAffiliation> findByRegionId(
		long spRegionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sp affiliation in the ordered set where spRegionId = &#63;.
	*
	* @param spRegionId the sp region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sp affiliation
	* @throws science.platform.NoSuchSpAffiliationException if a matching sp affiliation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation findByRegionId_First(
		long spRegionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpAffiliationException;

	/**
	* Returns the first sp affiliation in the ordered set where spRegionId = &#63;.
	*
	* @param spRegionId the sp region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sp affiliation, or <code>null</code> if a matching sp affiliation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation fetchByRegionId_First(
		long spRegionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sp affiliation in the ordered set where spRegionId = &#63;.
	*
	* @param spRegionId the sp region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sp affiliation
	* @throws science.platform.NoSuchSpAffiliationException if a matching sp affiliation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation findByRegionId_Last(
		long spRegionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpAffiliationException;

	/**
	* Returns the last sp affiliation in the ordered set where spRegionId = &#63;.
	*
	* @param spRegionId the sp region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sp affiliation, or <code>null</code> if a matching sp affiliation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation fetchByRegionId_Last(
		long spRegionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sp affiliations before and after the current sp affiliation in the ordered set where spRegionId = &#63;.
	*
	* @param spAffiliationId the primary key of the current sp affiliation
	* @param spRegionId the sp region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sp affiliation
	* @throws science.platform.NoSuchSpAffiliationException if a sp affiliation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation[] findByRegionId_PrevAndNext(
		long spAffiliationId, long spRegionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpAffiliationException;

	/**
	* Removes all the sp affiliations where spRegionId = &#63; from the database.
	*
	* @param spRegionId the sp region ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRegionId(long spRegionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sp affiliations where spRegionId = &#63;.
	*
	* @param spRegionId the sp region ID
	* @return the number of matching sp affiliations
	* @throws SystemException if a system exception occurred
	*/
	public int countByRegionId(long spRegionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the sp affiliation in the entity cache if it is enabled.
	*
	* @param spAffiliation the sp affiliation
	*/
	public void cacheResult(science.platform.model.SpAffiliation spAffiliation);

	/**
	* Caches the sp affiliations in the entity cache if it is enabled.
	*
	* @param spAffiliations the sp affiliations
	*/
	public void cacheResult(
		java.util.List<science.platform.model.SpAffiliation> spAffiliations);

	/**
	* Creates a new sp affiliation with the primary key. Does not add the sp affiliation to the database.
	*
	* @param spAffiliationId the primary key for the new sp affiliation
	* @return the new sp affiliation
	*/
	public science.platform.model.SpAffiliation create(long spAffiliationId);

	/**
	* Removes the sp affiliation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAffiliationId the primary key of the sp affiliation
	* @return the sp affiliation that was removed
	* @throws science.platform.NoSuchSpAffiliationException if a sp affiliation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation remove(long spAffiliationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpAffiliationException;

	public science.platform.model.SpAffiliation updateImpl(
		science.platform.model.SpAffiliation spAffiliation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sp affiliation with the primary key or throws a {@link science.platform.NoSuchSpAffiliationException} if it could not be found.
	*
	* @param spAffiliationId the primary key of the sp affiliation
	* @return the sp affiliation
	* @throws science.platform.NoSuchSpAffiliationException if a sp affiliation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation findByPrimaryKey(
		long spAffiliationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpAffiliationException;

	/**
	* Returns the sp affiliation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spAffiliationId the primary key of the sp affiliation
	* @return the sp affiliation, or <code>null</code> if a sp affiliation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public science.platform.model.SpAffiliation fetchByPrimaryKey(
		long spAffiliationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sp affiliations.
	*
	* @return the sp affiliations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<science.platform.model.SpAffiliation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the sp affiliations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpAffiliationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sp affiliations
	* @param end the upper bound of the range of sp affiliations (not inclusive)
	* @return the range of sp affiliations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<science.platform.model.SpAffiliation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the sp affiliations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpAffiliationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sp affiliations
	* @param end the upper bound of the range of sp affiliations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sp affiliations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<science.platform.model.SpAffiliation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sp affiliations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sp affiliations.
	*
	* @return the number of sp affiliations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}