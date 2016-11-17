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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import science.platform.NoSuchSpRegionException;

import science.platform.model.SpRegion;
import science.platform.model.impl.SpRegionImpl;
import science.platform.model.impl.SpRegionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the sp region service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpRegionPersistence
 * @see SpRegionUtil
 * @generated
 */
public class SpRegionPersistenceImpl extends BasePersistenceImpl<SpRegion>
	implements SpRegionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SpRegionUtil} to access the sp region persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SpRegionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
			SpRegionModelImpl.FINDER_CACHE_ENABLED, SpRegionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
			SpRegionModelImpl.FINDER_CACHE_ENABLED, SpRegionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
			SpRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_COUNTRYREGIONCODE = new FinderPath(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
			SpRegionModelImpl.FINDER_CACHE_ENABLED, SpRegionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCountryRegionCode",
			new String[] { Long.class.getName(), String.class.getName() },
			SpRegionModelImpl.SPCOUNTRYID_COLUMN_BITMASK |
			SpRegionModelImpl.SPREGIONCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYREGIONCODE = new FinderPath(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
			SpRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCountryRegionCode",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the sp region where spCountryId = &#63; and spRegionCode = &#63; or throws a {@link science.platform.NoSuchSpRegionException} if it could not be found.
	 *
	 * @param spCountryId the sp country ID
	 * @param spRegionCode the sp region code
	 * @return the matching sp region
	 * @throws science.platform.NoSuchSpRegionException if a matching sp region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpRegion findByCountryRegionCode(long spCountryId,
		String spRegionCode) throws NoSuchSpRegionException, SystemException {
		SpRegion spRegion = fetchByCountryRegionCode(spCountryId, spRegionCode);

		if (spRegion == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spCountryId=");
			msg.append(spCountryId);

			msg.append(", spRegionCode=");
			msg.append(spRegionCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSpRegionException(msg.toString());
		}

		return spRegion;
	}

	/**
	 * Returns the sp region where spCountryId = &#63; and spRegionCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spCountryId the sp country ID
	 * @param spRegionCode the sp region code
	 * @return the matching sp region, or <code>null</code> if a matching sp region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpRegion fetchByCountryRegionCode(long spCountryId,
		String spRegionCode) throws SystemException {
		return fetchByCountryRegionCode(spCountryId, spRegionCode, true);
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
	@Override
	public SpRegion fetchByCountryRegionCode(long spCountryId,
		String spRegionCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { spCountryId, spRegionCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COUNTRYREGIONCODE,
					finderArgs, this);
		}

		if (result instanceof SpRegion) {
			SpRegion spRegion = (SpRegion)result;

			if ((spCountryId != spRegion.getSpCountryId()) ||
					!Validator.equals(spRegionCode, spRegion.getSpRegionCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPREGION_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYREGIONCODE_SPCOUNTRYID_2);

			boolean bindSpRegionCode = false;

			if (spRegionCode == null) {
				query.append(_FINDER_COLUMN_COUNTRYREGIONCODE_SPREGIONCODE_1);
			}
			else if (spRegionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYREGIONCODE_SPREGIONCODE_3);
			}
			else {
				bindSpRegionCode = true;

				query.append(_FINDER_COLUMN_COUNTRYREGIONCODE_SPREGIONCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCountryId);

				if (bindSpRegionCode) {
					qPos.add(spRegionCode);
				}

				List<SpRegion> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYREGIONCODE,
						finderArgs, list);
				}
				else {
					SpRegion spRegion = list.get(0);

					result = spRegion;

					cacheResult(spRegion);

					if ((spRegion.getSpCountryId() != spCountryId) ||
							(spRegion.getSpRegionCode() == null) ||
							!spRegion.getSpRegionCode().equals(spRegionCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYREGIONCODE,
							finderArgs, spRegion);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COUNTRYREGIONCODE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SpRegion)result;
		}
	}

	/**
	 * Removes the sp region where spCountryId = &#63; and spRegionCode = &#63; from the database.
	 *
	 * @param spCountryId the sp country ID
	 * @param spRegionCode the sp region code
	 * @return the sp region that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpRegion removeByCountryRegionCode(long spCountryId,
		String spRegionCode) throws NoSuchSpRegionException, SystemException {
		SpRegion spRegion = findByCountryRegionCode(spCountryId, spRegionCode);

		return remove(spRegion);
	}

	/**
	 * Returns the number of sp regions where spCountryId = &#63; and spRegionCode = &#63;.
	 *
	 * @param spCountryId the sp country ID
	 * @param spRegionCode the sp region code
	 * @return the number of matching sp regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryRegionCode(long spCountryId, String spRegionCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYREGIONCODE;

		Object[] finderArgs = new Object[] { spCountryId, spRegionCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPREGION_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYREGIONCODE_SPCOUNTRYID_2);

			boolean bindSpRegionCode = false;

			if (spRegionCode == null) {
				query.append(_FINDER_COLUMN_COUNTRYREGIONCODE_SPREGIONCODE_1);
			}
			else if (spRegionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYREGIONCODE_SPREGIONCODE_3);
			}
			else {
				bindSpRegionCode = true;

				query.append(_FINDER_COLUMN_COUNTRYREGIONCODE_SPREGIONCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCountryId);

				if (bindSpRegionCode) {
					qPos.add(spRegionCode);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COUNTRYREGIONCODE_SPCOUNTRYID_2 = "spRegion.spCountryId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYREGIONCODE_SPREGIONCODE_1 = "spRegion.spRegionCode IS NULL";
	private static final String _FINDER_COLUMN_COUNTRYREGIONCODE_SPREGIONCODE_2 = "spRegion.spRegionCode = ?";
	private static final String _FINDER_COLUMN_COUNTRYREGIONCODE_SPREGIONCODE_3 = "(spRegion.spRegionCode IS NULL OR spRegion.spRegionCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYID =
		new FinderPath(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
			SpRegionModelImpl.FINDER_CACHE_ENABLED, SpRegionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCountryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYID =
		new FinderPath(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
			SpRegionModelImpl.FINDER_CACHE_ENABLED, SpRegionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCountryId",
			new String[] { Long.class.getName() },
			SpRegionModelImpl.SPCOUNTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYID = new FinderPath(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
			SpRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCountryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the sp regions where spCountryId = &#63;.
	 *
	 * @param spCountryId the sp country ID
	 * @return the matching sp regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpRegion> findByCountryId(long spCountryId)
		throws SystemException {
		return findByCountryId(spCountryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SpRegion> findByCountryId(long spCountryId, int start, int end)
		throws SystemException {
		return findByCountryId(spCountryId, start, end, null);
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
	@Override
	public List<SpRegion> findByCountryId(long spCountryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYID;
			finderArgs = new Object[] { spCountryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYID;
			finderArgs = new Object[] { spCountryId, start, end, orderByComparator };
		}

		List<SpRegion> list = (List<SpRegion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SpRegion spRegion : list) {
				if ((spCountryId != spRegion.getSpCountryId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SPREGION_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYID_SPCOUNTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SpRegionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCountryId);

				if (!pagination) {
					list = (List<SpRegion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SpRegion>(list);
				}
				else {
					list = (List<SpRegion>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SpRegion findByCountryId_First(long spCountryId,
		OrderByComparator orderByComparator)
		throws NoSuchSpRegionException, SystemException {
		SpRegion spRegion = fetchByCountryId_First(spCountryId,
				orderByComparator);

		if (spRegion != null) {
			return spRegion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCountryId=");
		msg.append(spCountryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpRegionException(msg.toString());
	}

	/**
	 * Returns the first sp region in the ordered set where spCountryId = &#63;.
	 *
	 * @param spCountryId the sp country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sp region, or <code>null</code> if a matching sp region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpRegion fetchByCountryId_First(long spCountryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SpRegion> list = findByCountryId(spCountryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SpRegion findByCountryId_Last(long spCountryId,
		OrderByComparator orderByComparator)
		throws NoSuchSpRegionException, SystemException {
		SpRegion spRegion = fetchByCountryId_Last(spCountryId, orderByComparator);

		if (spRegion != null) {
			return spRegion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCountryId=");
		msg.append(spCountryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpRegionException(msg.toString());
	}

	/**
	 * Returns the last sp region in the ordered set where spCountryId = &#63;.
	 *
	 * @param spCountryId the sp country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sp region, or <code>null</code> if a matching sp region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpRegion fetchByCountryId_Last(long spCountryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCountryId(spCountryId);

		if (count == 0) {
			return null;
		}

		List<SpRegion> list = findByCountryId(spCountryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SpRegion[] findByCountryId_PrevAndNext(long spRegionId,
		long spCountryId, OrderByComparator orderByComparator)
		throws NoSuchSpRegionException, SystemException {
		SpRegion spRegion = findByPrimaryKey(spRegionId);

		Session session = null;

		try {
			session = openSession();

			SpRegion[] array = new SpRegionImpl[3];

			array[0] = getByCountryId_PrevAndNext(session, spRegion,
					spCountryId, orderByComparator, true);

			array[1] = spRegion;

			array[2] = getByCountryId_PrevAndNext(session, spRegion,
					spCountryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SpRegion getByCountryId_PrevAndNext(Session session,
		SpRegion spRegion, long spCountryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPREGION_WHERE);

		query.append(_FINDER_COLUMN_COUNTRYID_SPCOUNTRYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SpRegionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCountryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spRegion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SpRegion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sp regions where spCountryId = &#63; from the database.
	 *
	 * @param spCountryId the sp country ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountryId(long spCountryId) throws SystemException {
		for (SpRegion spRegion : findByCountryId(spCountryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spRegion);
		}
	}

	/**
	 * Returns the number of sp regions where spCountryId = &#63;.
	 *
	 * @param spCountryId the sp country ID
	 * @return the number of matching sp regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryId(long spCountryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYID;

		Object[] finderArgs = new Object[] { spCountryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPREGION_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYID_SPCOUNTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCountryId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COUNTRYID_SPCOUNTRYID_2 = "spRegion.spCountryId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_COUNTRYREGION = new FinderPath(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
			SpRegionModelImpl.FINDER_CACHE_ENABLED, SpRegionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCountryRegion",
			new String[] { Long.class.getName(), Long.class.getName() },
			SpRegionModelImpl.SPCOUNTRYID_COLUMN_BITMASK |
			SpRegionModelImpl.SPREGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYREGION = new FinderPath(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
			SpRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCountryRegion",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the sp region where spCountryId = &#63; and spRegionId = &#63; or throws a {@link science.platform.NoSuchSpRegionException} if it could not be found.
	 *
	 * @param spCountryId the sp country ID
	 * @param spRegionId the sp region ID
	 * @return the matching sp region
	 * @throws science.platform.NoSuchSpRegionException if a matching sp region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpRegion findByCountryRegion(long spCountryId, long spRegionId)
		throws NoSuchSpRegionException, SystemException {
		SpRegion spRegion = fetchByCountryRegion(spCountryId, spRegionId);

		if (spRegion == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spCountryId=");
			msg.append(spCountryId);

			msg.append(", spRegionId=");
			msg.append(spRegionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSpRegionException(msg.toString());
		}

		return spRegion;
	}

	/**
	 * Returns the sp region where spCountryId = &#63; and spRegionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spCountryId the sp country ID
	 * @param spRegionId the sp region ID
	 * @return the matching sp region, or <code>null</code> if a matching sp region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpRegion fetchByCountryRegion(long spCountryId, long spRegionId)
		throws SystemException {
		return fetchByCountryRegion(spCountryId, spRegionId, true);
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
	@Override
	public SpRegion fetchByCountryRegion(long spCountryId, long spRegionId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { spCountryId, spRegionId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COUNTRYREGION,
					finderArgs, this);
		}

		if (result instanceof SpRegion) {
			SpRegion spRegion = (SpRegion)result;

			if ((spCountryId != spRegion.getSpCountryId()) ||
					(spRegionId != spRegion.getSpRegionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPREGION_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYREGION_SPCOUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYREGION_SPREGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCountryId);

				qPos.add(spRegionId);

				List<SpRegion> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYREGION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SpRegionPersistenceImpl.fetchByCountryRegion(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SpRegion spRegion = list.get(0);

					result = spRegion;

					cacheResult(spRegion);

					if ((spRegion.getSpCountryId() != spCountryId) ||
							(spRegion.getSpRegionId() != spRegionId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYREGION,
							finderArgs, spRegion);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COUNTRYREGION,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SpRegion)result;
		}
	}

	/**
	 * Removes the sp region where spCountryId = &#63; and spRegionId = &#63; from the database.
	 *
	 * @param spCountryId the sp country ID
	 * @param spRegionId the sp region ID
	 * @return the sp region that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpRegion removeByCountryRegion(long spCountryId, long spRegionId)
		throws NoSuchSpRegionException, SystemException {
		SpRegion spRegion = findByCountryRegion(spCountryId, spRegionId);

		return remove(spRegion);
	}

	/**
	 * Returns the number of sp regions where spCountryId = &#63; and spRegionId = &#63;.
	 *
	 * @param spCountryId the sp country ID
	 * @param spRegionId the sp region ID
	 * @return the number of matching sp regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryRegion(long spCountryId, long spRegionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYREGION;

		Object[] finderArgs = new Object[] { spCountryId, spRegionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPREGION_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYREGION_SPCOUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYREGION_SPREGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCountryId);

				qPos.add(spRegionId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COUNTRYREGION_SPCOUNTRYID_2 = "spRegion.spCountryId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYREGION_SPREGIONID_2 = "spRegion.spRegionId = ?";

	public SpRegionPersistenceImpl() {
		setModelClass(SpRegion.class);
	}

	/**
	 * Caches the sp region in the entity cache if it is enabled.
	 *
	 * @param spRegion the sp region
	 */
	@Override
	public void cacheResult(SpRegion spRegion) {
		EntityCacheUtil.putResult(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
			SpRegionImpl.class, spRegion.getPrimaryKey(), spRegion);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYREGIONCODE,
			new Object[] { spRegion.getSpCountryId(), spRegion.getSpRegionCode() },
			spRegion);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYREGION,
			new Object[] { spRegion.getSpCountryId(), spRegion.getSpRegionId() },
			spRegion);

		spRegion.resetOriginalValues();
	}

	/**
	 * Caches the sp regions in the entity cache if it is enabled.
	 *
	 * @param spRegions the sp regions
	 */
	@Override
	public void cacheResult(List<SpRegion> spRegions) {
		for (SpRegion spRegion : spRegions) {
			if (EntityCacheUtil.getResult(
						SpRegionModelImpl.ENTITY_CACHE_ENABLED,
						SpRegionImpl.class, spRegion.getPrimaryKey()) == null) {
				cacheResult(spRegion);
			}
			else {
				spRegion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sp regions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SpRegionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SpRegionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sp region.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SpRegion spRegion) {
		EntityCacheUtil.removeResult(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
			SpRegionImpl.class, spRegion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spRegion);
	}

	@Override
	public void clearCache(List<SpRegion> spRegions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SpRegion spRegion : spRegions) {
			EntityCacheUtil.removeResult(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
				SpRegionImpl.class, spRegion.getPrimaryKey());

			clearUniqueFindersCache(spRegion);
		}
	}

	protected void cacheUniqueFindersCache(SpRegion spRegion) {
		if (spRegion.isNew()) {
			Object[] args = new Object[] {
					spRegion.getSpCountryId(), spRegion.getSpRegionCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COUNTRYREGIONCODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYREGIONCODE,
				args, spRegion);

			args = new Object[] {
					spRegion.getSpCountryId(), spRegion.getSpRegionId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COUNTRYREGION, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYREGION, args,
				spRegion);
		}
		else {
			SpRegionModelImpl spRegionModelImpl = (SpRegionModelImpl)spRegion;

			if ((spRegionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COUNTRYREGIONCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spRegion.getSpCountryId(), spRegion.getSpRegionCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COUNTRYREGIONCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYREGIONCODE,
					args, spRegion);
			}

			if ((spRegionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COUNTRYREGION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spRegion.getSpCountryId(), spRegion.getSpRegionId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COUNTRYREGION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYREGION,
					args, spRegion);
			}
		}
	}

	protected void clearUniqueFindersCache(SpRegion spRegion) {
		SpRegionModelImpl spRegionModelImpl = (SpRegionModelImpl)spRegion;

		Object[] args = new Object[] {
				spRegion.getSpCountryId(), spRegion.getSpRegionCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYREGIONCODE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COUNTRYREGIONCODE,
			args);

		if ((spRegionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COUNTRYREGIONCODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					spRegionModelImpl.getOriginalSpCountryId(),
					spRegionModelImpl.getOriginalSpRegionCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYREGIONCODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COUNTRYREGIONCODE,
				args);
		}

		args = new Object[] { spRegion.getSpCountryId(), spRegion.getSpRegionId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYREGION, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COUNTRYREGION, args);

		if ((spRegionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COUNTRYREGION.getColumnBitmask()) != 0) {
			args = new Object[] {
					spRegionModelImpl.getOriginalSpCountryId(),
					spRegionModelImpl.getOriginalSpRegionId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYREGION,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COUNTRYREGION,
				args);
		}
	}

	/**
	 * Creates a new sp region with the primary key. Does not add the sp region to the database.
	 *
	 * @param spRegionId the primary key for the new sp region
	 * @return the new sp region
	 */
	@Override
	public SpRegion create(long spRegionId) {
		SpRegion spRegion = new SpRegionImpl();

		spRegion.setNew(true);
		spRegion.setPrimaryKey(spRegionId);

		return spRegion;
	}

	/**
	 * Removes the sp region with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spRegionId the primary key of the sp region
	 * @return the sp region that was removed
	 * @throws science.platform.NoSuchSpRegionException if a sp region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpRegion remove(long spRegionId)
		throws NoSuchSpRegionException, SystemException {
		return remove((Serializable)spRegionId);
	}

	/**
	 * Removes the sp region with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sp region
	 * @return the sp region that was removed
	 * @throws science.platform.NoSuchSpRegionException if a sp region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpRegion remove(Serializable primaryKey)
		throws NoSuchSpRegionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SpRegion spRegion = (SpRegion)session.get(SpRegionImpl.class,
					primaryKey);

			if (spRegion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spRegion);
		}
		catch (NoSuchSpRegionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SpRegion removeImpl(SpRegion spRegion) throws SystemException {
		spRegion = toUnwrappedModel(spRegion);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spRegion)) {
				spRegion = (SpRegion)session.get(SpRegionImpl.class,
						spRegion.getPrimaryKeyObj());
			}

			if (spRegion != null) {
				session.delete(spRegion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spRegion != null) {
			clearCache(spRegion);
		}

		return spRegion;
	}

	@Override
	public SpRegion updateImpl(science.platform.model.SpRegion spRegion)
		throws SystemException {
		spRegion = toUnwrappedModel(spRegion);

		boolean isNew = spRegion.isNew();

		SpRegionModelImpl spRegionModelImpl = (SpRegionModelImpl)spRegion;

		Session session = null;

		try {
			session = openSession();

			if (spRegion.isNew()) {
				session.save(spRegion);

				spRegion.setNew(false);
			}
			else {
				session.merge(spRegion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SpRegionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spRegionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spRegionModelImpl.getOriginalSpCountryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYID,
					args);

				args = new Object[] { spRegionModelImpl.getSpCountryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYID,
					args);
			}
		}

		EntityCacheUtil.putResult(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
			SpRegionImpl.class, spRegion.getPrimaryKey(), spRegion);

		clearUniqueFindersCache(spRegion);
		cacheUniqueFindersCache(spRegion);

		return spRegion;
	}

	protected SpRegion toUnwrappedModel(SpRegion spRegion) {
		if (spRegion instanceof SpRegionImpl) {
			return spRegion;
		}

		SpRegionImpl spRegionImpl = new SpRegionImpl();

		spRegionImpl.setNew(spRegion.isNew());
		spRegionImpl.setPrimaryKey(spRegion.getPrimaryKey());

		spRegionImpl.setSpRegionId(spRegion.getSpRegionId());
		spRegionImpl.setSpCountryId(spRegion.getSpCountryId());
		spRegionImpl.setSpRegionCode(spRegion.getSpRegionCode());
		spRegionImpl.setSpRegionName(spRegion.getSpRegionName());
		spRegionImpl.setSpActive(spRegion.isSpActive());

		return spRegionImpl;
	}

	/**
	 * Returns the sp region with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sp region
	 * @return the sp region
	 * @throws science.platform.NoSuchSpRegionException if a sp region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpRegion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpRegionException, SystemException {
		SpRegion spRegion = fetchByPrimaryKey(primaryKey);

		if (spRegion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spRegion;
	}

	/**
	 * Returns the sp region with the primary key or throws a {@link science.platform.NoSuchSpRegionException} if it could not be found.
	 *
	 * @param spRegionId the primary key of the sp region
	 * @return the sp region
	 * @throws science.platform.NoSuchSpRegionException if a sp region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpRegion findByPrimaryKey(long spRegionId)
		throws NoSuchSpRegionException, SystemException {
		return findByPrimaryKey((Serializable)spRegionId);
	}

	/**
	 * Returns the sp region with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sp region
	 * @return the sp region, or <code>null</code> if a sp region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpRegion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SpRegion spRegion = (SpRegion)EntityCacheUtil.getResult(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
				SpRegionImpl.class, primaryKey);

		if (spRegion == _nullSpRegion) {
			return null;
		}

		if (spRegion == null) {
			Session session = null;

			try {
				session = openSession();

				spRegion = (SpRegion)session.get(SpRegionImpl.class, primaryKey);

				if (spRegion != null) {
					cacheResult(spRegion);
				}
				else {
					EntityCacheUtil.putResult(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
						SpRegionImpl.class, primaryKey, _nullSpRegion);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SpRegionModelImpl.ENTITY_CACHE_ENABLED,
					SpRegionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spRegion;
	}

	/**
	 * Returns the sp region with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spRegionId the primary key of the sp region
	 * @return the sp region, or <code>null</code> if a sp region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpRegion fetchByPrimaryKey(long spRegionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spRegionId);
	}

	/**
	 * Returns all the sp regions.
	 *
	 * @return the sp regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpRegion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SpRegion> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SpRegion> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SpRegion> list = (List<SpRegion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPREGION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPREGION;

				if (pagination) {
					sql = sql.concat(SpRegionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SpRegion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SpRegion>(list);
				}
				else {
					list = (List<SpRegion>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sp regions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SpRegion spRegion : findAll()) {
			remove(spRegion);
		}
	}

	/**
	 * Returns the number of sp regions.
	 *
	 * @return the number of sp regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SPREGION);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the sp region persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.science.platform.model.SpRegion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SpRegion>> listenersList = new ArrayList<ModelListener<SpRegion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SpRegion>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SpRegionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPREGION = "SELECT spRegion FROM SpRegion spRegion";
	private static final String _SQL_SELECT_SPREGION_WHERE = "SELECT spRegion FROM SpRegion spRegion WHERE ";
	private static final String _SQL_COUNT_SPREGION = "SELECT COUNT(spRegion) FROM SpRegion spRegion";
	private static final String _SQL_COUNT_SPREGION_WHERE = "SELECT COUNT(spRegion) FROM SpRegion spRegion WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spRegion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SpRegion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SpRegion exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SpRegionPersistenceImpl.class);
	private static SpRegion _nullSpRegion = new SpRegionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SpRegion> toCacheModel() {
				return _nullSpRegionCacheModel;
			}
		};

	private static CacheModel<SpRegion> _nullSpRegionCacheModel = new CacheModel<SpRegion>() {
			@Override
			public SpRegion toEntityModel() {
				return _nullSpRegion;
			}
		};
}