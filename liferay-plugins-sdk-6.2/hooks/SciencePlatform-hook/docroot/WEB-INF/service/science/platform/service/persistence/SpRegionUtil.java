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

import science.platform.model.SpRegion;

import java.util.List;

/**
 * The persistence utility for the sp region service. This utility wraps {@link SpRegionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpRegionPersistence
 * @see SpRegionPersistenceImpl
 * @generated
 */
public class SpRegionUtil {
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
	public static void clearCache(SpRegion spRegion) {
		getPersistence().clearCache(spRegion);
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
	public static List<SpRegion> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SpRegion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SpRegion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SpRegion update(SpRegion spRegion) throws SystemException {
		return getPersistence().update(spRegion);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SpRegion update(SpRegion spRegion,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spRegion, serviceContext);
	}

	/**
	* Returns the sp region where spCountryId = &#63; and spRegionCode = &#63; or throws a {@link science.platform.NoSuchSpRegionException} if it could not be found.
	*
	* @param spCountryId the sp country ID
	* @param spRegionCode the sp region code
	* @return the matching sp region
	* @throws science.platform.NoSuchSpRegionException if a matching sp region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion findByCountryRegionCode(
		long spCountryId, java.lang.String spRegionCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpRegionException {
		return getPersistence()
				   .findByCountryRegionCode(spCountryId, spRegionCode);
	}

	/**
	* Returns the sp region where spCountryId = &#63; and spRegionCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spCountryId the sp country ID
	* @param spRegionCode the sp region code
	* @return the matching sp region, or <code>null</code> if a matching sp region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion fetchByCountryRegionCode(
		long spCountryId, java.lang.String spRegionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryRegionCode(spCountryId, spRegionCode);
	}

	/**
	* Returns the sp region where spCountryId = &#63; and spRegionCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spCountryId the sp country ID
	* @param spRegionCode the sp region code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching sp region, or <code>null</code> if a matching sp region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion fetchByCountryRegionCode(
		long spCountryId, java.lang.String spRegionCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryRegionCode(spCountryId, spRegionCode,
			retrieveFromCache);
	}

	/**
	* Removes the sp region where spCountryId = &#63; and spRegionCode = &#63; from the database.
	*
	* @param spCountryId the sp country ID
	* @param spRegionCode the sp region code
	* @return the sp region that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion removeByCountryRegionCode(
		long spCountryId, java.lang.String spRegionCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpRegionException {
		return getPersistence()
				   .removeByCountryRegionCode(spCountryId, spRegionCode);
	}

	/**
	* Returns the number of sp regions where spCountryId = &#63; and spRegionCode = &#63;.
	*
	* @param spCountryId the sp country ID
	* @param spRegionCode the sp region code
	* @return the number of matching sp regions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountryRegionCode(long spCountryId,
		java.lang.String spRegionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCountryRegionCode(spCountryId, spRegionCode);
	}

	/**
	* Returns all the sp regions where spCountryId = &#63;.
	*
	* @param spCountryId the sp country ID
	* @return the matching sp regions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpRegion> findByCountryId(
		long spCountryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCountryId(spCountryId);
	}

	/**
	* Returns a range of all the sp regions where spCountryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCountryId the sp country ID
	* @param start the lower bound of the range of sp regions
	* @param end the upper bound of the range of sp regions (not inclusive)
	* @return the range of matching sp regions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpRegion> findByCountryId(
		long spCountryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCountryId(spCountryId, start, end);
	}

	/**
	* Returns an ordered range of all the sp regions where spCountryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCountryId the sp country ID
	* @param start the lower bound of the range of sp regions
	* @param end the upper bound of the range of sp regions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sp regions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpRegion> findByCountryId(
		long spCountryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryId(spCountryId, start, end, orderByComparator);
	}

	/**
	* Returns the first sp region in the ordered set where spCountryId = &#63;.
	*
	* @param spCountryId the sp country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sp region
	* @throws science.platform.NoSuchSpRegionException if a matching sp region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion findByCountryId_First(
		long spCountryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpRegionException {
		return getPersistence()
				   .findByCountryId_First(spCountryId, orderByComparator);
	}

	/**
	* Returns the first sp region in the ordered set where spCountryId = &#63;.
	*
	* @param spCountryId the sp country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sp region, or <code>null</code> if a matching sp region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion fetchByCountryId_First(
		long spCountryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryId_First(spCountryId, orderByComparator);
	}

	/**
	* Returns the last sp region in the ordered set where spCountryId = &#63;.
	*
	* @param spCountryId the sp country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sp region
	* @throws science.platform.NoSuchSpRegionException if a matching sp region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion findByCountryId_Last(
		long spCountryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpRegionException {
		return getPersistence()
				   .findByCountryId_Last(spCountryId, orderByComparator);
	}

	/**
	* Returns the last sp region in the ordered set where spCountryId = &#63;.
	*
	* @param spCountryId the sp country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sp region, or <code>null</code> if a matching sp region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion fetchByCountryId_Last(
		long spCountryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryId_Last(spCountryId, orderByComparator);
	}

	/**
	* Returns the sp regions before and after the current sp region in the ordered set where spCountryId = &#63;.
	*
	* @param spRegionId the primary key of the current sp region
	* @param spCountryId the sp country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sp region
	* @throws science.platform.NoSuchSpRegionException if a sp region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion[] findByCountryId_PrevAndNext(
		long spRegionId, long spCountryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpRegionException {
		return getPersistence()
				   .findByCountryId_PrevAndNext(spRegionId, spCountryId,
			orderByComparator);
	}

	/**
	* Removes all the sp regions where spCountryId = &#63; from the database.
	*
	* @param spCountryId the sp country ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCountryId(long spCountryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCountryId(spCountryId);
	}

	/**
	* Returns the number of sp regions where spCountryId = &#63;.
	*
	* @param spCountryId the sp country ID
	* @return the number of matching sp regions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountryId(long spCountryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCountryId(spCountryId);
	}

	/**
	* Returns the sp region where spCountryId = &#63; and spRegionId = &#63; or throws a {@link science.platform.NoSuchSpRegionException} if it could not be found.
	*
	* @param spCountryId the sp country ID
	* @param spRegionId the sp region ID
	* @return the matching sp region
	* @throws science.platform.NoSuchSpRegionException if a matching sp region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion findByCountryRegion(
		long spCountryId, long spRegionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpRegionException {
		return getPersistence().findByCountryRegion(spCountryId, spRegionId);
	}

	/**
	* Returns the sp region where spCountryId = &#63; and spRegionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spCountryId the sp country ID
	* @param spRegionId the sp region ID
	* @return the matching sp region, or <code>null</code> if a matching sp region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion fetchByCountryRegion(
		long spCountryId, long spRegionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCountryRegion(spCountryId, spRegionId);
	}

	/**
	* Returns the sp region where spCountryId = &#63; and spRegionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spCountryId the sp country ID
	* @param spRegionId the sp region ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching sp region, or <code>null</code> if a matching sp region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion fetchByCountryRegion(
		long spCountryId, long spRegionId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryRegion(spCountryId, spRegionId,
			retrieveFromCache);
	}

	/**
	* Removes the sp region where spCountryId = &#63; and spRegionId = &#63; from the database.
	*
	* @param spCountryId the sp country ID
	* @param spRegionId the sp region ID
	* @return the sp region that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion removeByCountryRegion(
		long spCountryId, long spRegionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpRegionException {
		return getPersistence().removeByCountryRegion(spCountryId, spRegionId);
	}

	/**
	* Returns the number of sp regions where spCountryId = &#63; and spRegionId = &#63;.
	*
	* @param spCountryId the sp country ID
	* @param spRegionId the sp region ID
	* @return the number of matching sp regions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountryRegion(long spCountryId, long spRegionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCountryRegion(spCountryId, spRegionId);
	}

	/**
	* Caches the sp region in the entity cache if it is enabled.
	*
	* @param spRegion the sp region
	*/
	public static void cacheResult(science.platform.model.SpRegion spRegion) {
		getPersistence().cacheResult(spRegion);
	}

	/**
	* Caches the sp regions in the entity cache if it is enabled.
	*
	* @param spRegions the sp regions
	*/
	public static void cacheResult(
		java.util.List<science.platform.model.SpRegion> spRegions) {
		getPersistence().cacheResult(spRegions);
	}

	/**
	* Creates a new sp region with the primary key. Does not add the sp region to the database.
	*
	* @param spRegionId the primary key for the new sp region
	* @return the new sp region
	*/
	public static science.platform.model.SpRegion create(long spRegionId) {
		return getPersistence().create(spRegionId);
	}

	/**
	* Removes the sp region with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spRegionId the primary key of the sp region
	* @return the sp region that was removed
	* @throws science.platform.NoSuchSpRegionException if a sp region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion remove(long spRegionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpRegionException {
		return getPersistence().remove(spRegionId);
	}

	public static science.platform.model.SpRegion updateImpl(
		science.platform.model.SpRegion spRegion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spRegion);
	}

	/**
	* Returns the sp region with the primary key or throws a {@link science.platform.NoSuchSpRegionException} if it could not be found.
	*
	* @param spRegionId the primary key of the sp region
	* @return the sp region
	* @throws science.platform.NoSuchSpRegionException if a sp region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion findByPrimaryKey(
		long spRegionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			science.platform.NoSuchSpRegionException {
		return getPersistence().findByPrimaryKey(spRegionId);
	}

	/**
	* Returns the sp region with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spRegionId the primary key of the sp region
	* @return the sp region, or <code>null</code> if a sp region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion fetchByPrimaryKey(
		long spRegionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spRegionId);
	}

	/**
	* Returns all the sp regions.
	*
	* @return the sp regions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpRegion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the sp regions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sp regions
	* @param end the upper bound of the range of sp regions (not inclusive)
	* @return the range of sp regions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpRegion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the sp regions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sp regions
	* @param end the upper bound of the range of sp regions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sp regions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<science.platform.model.SpRegion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the sp regions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sp regions.
	*
	* @return the number of sp regions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SpRegionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SpRegionPersistence)PortletBeanLocatorUtil.locate(science.platform.service.ClpSerializer.getServletContextName(),
					SpRegionPersistence.class.getName());

			ReferenceRegistry.registerReference(SpRegionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SpRegionPersistence persistence) {
	}

	private static SpRegionPersistence _persistence;
}