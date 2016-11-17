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

import science.platform.NoSuchSpAffiliationException;

import science.platform.model.SpAffiliation;
import science.platform.model.impl.SpAffiliationImpl;
import science.platform.model.impl.SpAffiliationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the sp affiliation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpAffiliationPersistence
 * @see SpAffiliationUtil
 * @generated
 */
public class SpAffiliationPersistenceImpl extends BasePersistenceImpl<SpAffiliation>
	implements SpAffiliationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SpAffiliationUtil} to access the sp affiliation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SpAffiliationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
			SpAffiliationModelImpl.FINDER_CACHE_ENABLED,
			SpAffiliationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
			SpAffiliationModelImpl.FINDER_CACHE_ENABLED,
			SpAffiliationImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
			SpAffiliationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_AFFILIATIONCODE = new FinderPath(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
			SpAffiliationModelImpl.FINDER_CACHE_ENABLED,
			SpAffiliationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByAffiliationCode",
			new String[] { Long.class.getName(), String.class.getName() },
			SpAffiliationModelImpl.SPREGIONID_COLUMN_BITMASK |
			SpAffiliationModelImpl.SPAFFILIATIONCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AFFILIATIONCODE = new FinderPath(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
			SpAffiliationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAffiliationCode",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the sp affiliation where spRegionId = &#63; and spAffiliationCode = &#63; or throws a {@link science.platform.NoSuchSpAffiliationException} if it could not be found.
	 *
	 * @param spRegionId the sp region ID
	 * @param spAffiliationCode the sp affiliation code
	 * @return the matching sp affiliation
	 * @throws science.platform.NoSuchSpAffiliationException if a matching sp affiliation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation findByAffiliationCode(long spRegionId,
		String spAffiliationCode)
		throws NoSuchSpAffiliationException, SystemException {
		SpAffiliation spAffiliation = fetchByAffiliationCode(spRegionId,
				spAffiliationCode);

		if (spAffiliation == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spRegionId=");
			msg.append(spRegionId);

			msg.append(", spAffiliationCode=");
			msg.append(spAffiliationCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSpAffiliationException(msg.toString());
		}

		return spAffiliation;
	}

	/**
	 * Returns the sp affiliation where spRegionId = &#63; and spAffiliationCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spRegionId the sp region ID
	 * @param spAffiliationCode the sp affiliation code
	 * @return the matching sp affiliation, or <code>null</code> if a matching sp affiliation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation fetchByAffiliationCode(long spRegionId,
		String spAffiliationCode) throws SystemException {
		return fetchByAffiliationCode(spRegionId, spAffiliationCode, true);
	}

	/**
	 * Returns the sp affiliation where spRegionId = &#63; and spAffiliationCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spRegionId the sp region ID
	 * @param spAffiliationCode the sp affiliation code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching sp affiliation, or <code>null</code> if a matching sp affiliation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation fetchByAffiliationCode(long spRegionId,
		String spAffiliationCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { spRegionId, spAffiliationCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_AFFILIATIONCODE,
					finderArgs, this);
		}

		if (result instanceof SpAffiliation) {
			SpAffiliation spAffiliation = (SpAffiliation)result;

			if ((spRegionId != spAffiliation.getSpRegionId()) ||
					!Validator.equals(spAffiliationCode,
						spAffiliation.getSpAffiliationCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPAFFILIATION_WHERE);

			query.append(_FINDER_COLUMN_AFFILIATIONCODE_SPREGIONID_2);

			boolean bindSpAffiliationCode = false;

			if (spAffiliationCode == null) {
				query.append(_FINDER_COLUMN_AFFILIATIONCODE_SPAFFILIATIONCODE_1);
			}
			else if (spAffiliationCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AFFILIATIONCODE_SPAFFILIATIONCODE_3);
			}
			else {
				bindSpAffiliationCode = true;

				query.append(_FINDER_COLUMN_AFFILIATIONCODE_SPAFFILIATIONCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spRegionId);

				if (bindSpAffiliationCode) {
					qPos.add(spAffiliationCode);
				}

				List<SpAffiliation> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_AFFILIATIONCODE,
						finderArgs, list);
				}
				else {
					SpAffiliation spAffiliation = list.get(0);

					result = spAffiliation;

					cacheResult(spAffiliation);

					if ((spAffiliation.getSpRegionId() != spRegionId) ||
							(spAffiliation.getSpAffiliationCode() == null) ||
							!spAffiliation.getSpAffiliationCode()
											  .equals(spAffiliationCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_AFFILIATIONCODE,
							finderArgs, spAffiliation);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_AFFILIATIONCODE,
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
			return (SpAffiliation)result;
		}
	}

	/**
	 * Removes the sp affiliation where spRegionId = &#63; and spAffiliationCode = &#63; from the database.
	 *
	 * @param spRegionId the sp region ID
	 * @param spAffiliationCode the sp affiliation code
	 * @return the sp affiliation that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation removeByAffiliationCode(long spRegionId,
		String spAffiliationCode)
		throws NoSuchSpAffiliationException, SystemException {
		SpAffiliation spAffiliation = findByAffiliationCode(spRegionId,
				spAffiliationCode);

		return remove(spAffiliation);
	}

	/**
	 * Returns the number of sp affiliations where spRegionId = &#63; and spAffiliationCode = &#63;.
	 *
	 * @param spRegionId the sp region ID
	 * @param spAffiliationCode the sp affiliation code
	 * @return the number of matching sp affiliations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAffiliationCode(long spRegionId, String spAffiliationCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AFFILIATIONCODE;

		Object[] finderArgs = new Object[] { spRegionId, spAffiliationCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPAFFILIATION_WHERE);

			query.append(_FINDER_COLUMN_AFFILIATIONCODE_SPREGIONID_2);

			boolean bindSpAffiliationCode = false;

			if (spAffiliationCode == null) {
				query.append(_FINDER_COLUMN_AFFILIATIONCODE_SPAFFILIATIONCODE_1);
			}
			else if (spAffiliationCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AFFILIATIONCODE_SPAFFILIATIONCODE_3);
			}
			else {
				bindSpAffiliationCode = true;

				query.append(_FINDER_COLUMN_AFFILIATIONCODE_SPAFFILIATIONCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spRegionId);

				if (bindSpAffiliationCode) {
					qPos.add(spAffiliationCode);
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

	private static final String _FINDER_COLUMN_AFFILIATIONCODE_SPREGIONID_2 = "spAffiliation.spRegionId = ? AND ";
	private static final String _FINDER_COLUMN_AFFILIATIONCODE_SPAFFILIATIONCODE_1 =
		"spAffiliation.spAffiliationCode IS NULL";
	private static final String _FINDER_COLUMN_AFFILIATIONCODE_SPAFFILIATIONCODE_2 =
		"spAffiliation.spAffiliationCode = ?";
	private static final String _FINDER_COLUMN_AFFILIATIONCODE_SPAFFILIATIONCODE_3 =
		"(spAffiliation.spAffiliationCode IS NULL OR spAffiliation.spAffiliationCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYID =
		new FinderPath(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
			SpAffiliationModelImpl.FINDER_CACHE_ENABLED,
			SpAffiliationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCountryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYID =
		new FinderPath(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
			SpAffiliationModelImpl.FINDER_CACHE_ENABLED,
			SpAffiliationImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCountryId", new String[] { Long.class.getName() },
			SpAffiliationModelImpl.SPCOUNTRYID_COLUMN_BITMASK |
			SpAffiliationModelImpl.SPAFFILIATIONNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYID = new FinderPath(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
			SpAffiliationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCountryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the sp affiliations where spCountryId = &#63;.
	 *
	 * @param spCountryId the sp country ID
	 * @return the matching sp affiliations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpAffiliation> findByCountryId(long spCountryId)
		throws SystemException {
		return findByCountryId(spCountryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<SpAffiliation> findByCountryId(long spCountryId, int start,
		int end) throws SystemException {
		return findByCountryId(spCountryId, start, end, null);
	}

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
	@Override
	public List<SpAffiliation> findByCountryId(long spCountryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<SpAffiliation> list = (List<SpAffiliation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SpAffiliation spAffiliation : list) {
				if ((spCountryId != spAffiliation.getSpCountryId())) {
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

			query.append(_SQL_SELECT_SPAFFILIATION_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYID_SPCOUNTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SpAffiliationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCountryId);

				if (!pagination) {
					list = (List<SpAffiliation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SpAffiliation>(list);
				}
				else {
					list = (List<SpAffiliation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first sp affiliation in the ordered set where spCountryId = &#63;.
	 *
	 * @param spCountryId the sp country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sp affiliation
	 * @throws science.platform.NoSuchSpAffiliationException if a matching sp affiliation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation findByCountryId_First(long spCountryId,
		OrderByComparator orderByComparator)
		throws NoSuchSpAffiliationException, SystemException {
		SpAffiliation spAffiliation = fetchByCountryId_First(spCountryId,
				orderByComparator);

		if (spAffiliation != null) {
			return spAffiliation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCountryId=");
		msg.append(spCountryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpAffiliationException(msg.toString());
	}

	/**
	 * Returns the first sp affiliation in the ordered set where spCountryId = &#63;.
	 *
	 * @param spCountryId the sp country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sp affiliation, or <code>null</code> if a matching sp affiliation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation fetchByCountryId_First(long spCountryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SpAffiliation> list = findByCountryId(spCountryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sp affiliation in the ordered set where spCountryId = &#63;.
	 *
	 * @param spCountryId the sp country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sp affiliation
	 * @throws science.platform.NoSuchSpAffiliationException if a matching sp affiliation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation findByCountryId_Last(long spCountryId,
		OrderByComparator orderByComparator)
		throws NoSuchSpAffiliationException, SystemException {
		SpAffiliation spAffiliation = fetchByCountryId_Last(spCountryId,
				orderByComparator);

		if (spAffiliation != null) {
			return spAffiliation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCountryId=");
		msg.append(spCountryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpAffiliationException(msg.toString());
	}

	/**
	 * Returns the last sp affiliation in the ordered set where spCountryId = &#63;.
	 *
	 * @param spCountryId the sp country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sp affiliation, or <code>null</code> if a matching sp affiliation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation fetchByCountryId_Last(long spCountryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCountryId(spCountryId);

		if (count == 0) {
			return null;
		}

		List<SpAffiliation> list = findByCountryId(spCountryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public SpAffiliation[] findByCountryId_PrevAndNext(long spAffiliationId,
		long spCountryId, OrderByComparator orderByComparator)
		throws NoSuchSpAffiliationException, SystemException {
		SpAffiliation spAffiliation = findByPrimaryKey(spAffiliationId);

		Session session = null;

		try {
			session = openSession();

			SpAffiliation[] array = new SpAffiliationImpl[3];

			array[0] = getByCountryId_PrevAndNext(session, spAffiliation,
					spCountryId, orderByComparator, true);

			array[1] = spAffiliation;

			array[2] = getByCountryId_PrevAndNext(session, spAffiliation,
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

	protected SpAffiliation getByCountryId_PrevAndNext(Session session,
		SpAffiliation spAffiliation, long spCountryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPAFFILIATION_WHERE);

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
			query.append(SpAffiliationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCountryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spAffiliation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SpAffiliation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sp affiliations where spCountryId = &#63; from the database.
	 *
	 * @param spCountryId the sp country ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountryId(long spCountryId) throws SystemException {
		for (SpAffiliation spAffiliation : findByCountryId(spCountryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spAffiliation);
		}
	}

	/**
	 * Returns the number of sp affiliations where spCountryId = &#63;.
	 *
	 * @param spCountryId the sp country ID
	 * @return the number of matching sp affiliations
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

			query.append(_SQL_COUNT_SPAFFILIATION_WHERE);

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

	private static final String _FINDER_COLUMN_COUNTRYID_SPCOUNTRYID_2 = "spAffiliation.spCountryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONID = new FinderPath(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
			SpAffiliationModelImpl.FINDER_CACHE_ENABLED,
			SpAffiliationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRegionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID =
		new FinderPath(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
			SpAffiliationModelImpl.FINDER_CACHE_ENABLED,
			SpAffiliationImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRegionId", new String[] { Long.class.getName() },
			SpAffiliationModelImpl.SPREGIONID_COLUMN_BITMASK |
			SpAffiliationModelImpl.SPAFFILIATIONNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REGIONID = new FinderPath(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
			SpAffiliationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRegionId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the sp affiliations where spRegionId = &#63;.
	 *
	 * @param spRegionId the sp region ID
	 * @return the matching sp affiliations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpAffiliation> findByRegionId(long spRegionId)
		throws SystemException {
		return findByRegionId(spRegionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<SpAffiliation> findByRegionId(long spRegionId, int start,
		int end) throws SystemException {
		return findByRegionId(spRegionId, start, end, null);
	}

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
	@Override
	public List<SpAffiliation> findByRegionId(long spRegionId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID;
			finderArgs = new Object[] { spRegionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONID;
			finderArgs = new Object[] { spRegionId, start, end, orderByComparator };
		}

		List<SpAffiliation> list = (List<SpAffiliation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SpAffiliation spAffiliation : list) {
				if ((spRegionId != spAffiliation.getSpRegionId())) {
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

			query.append(_SQL_SELECT_SPAFFILIATION_WHERE);

			query.append(_FINDER_COLUMN_REGIONID_SPREGIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SpAffiliationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spRegionId);

				if (!pagination) {
					list = (List<SpAffiliation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SpAffiliation>(list);
				}
				else {
					list = (List<SpAffiliation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first sp affiliation in the ordered set where spRegionId = &#63;.
	 *
	 * @param spRegionId the sp region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sp affiliation
	 * @throws science.platform.NoSuchSpAffiliationException if a matching sp affiliation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation findByRegionId_First(long spRegionId,
		OrderByComparator orderByComparator)
		throws NoSuchSpAffiliationException, SystemException {
		SpAffiliation spAffiliation = fetchByRegionId_First(spRegionId,
				orderByComparator);

		if (spAffiliation != null) {
			return spAffiliation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spRegionId=");
		msg.append(spRegionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpAffiliationException(msg.toString());
	}

	/**
	 * Returns the first sp affiliation in the ordered set where spRegionId = &#63;.
	 *
	 * @param spRegionId the sp region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sp affiliation, or <code>null</code> if a matching sp affiliation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation fetchByRegionId_First(long spRegionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SpAffiliation> list = findByRegionId(spRegionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sp affiliation in the ordered set where spRegionId = &#63;.
	 *
	 * @param spRegionId the sp region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sp affiliation
	 * @throws science.platform.NoSuchSpAffiliationException if a matching sp affiliation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation findByRegionId_Last(long spRegionId,
		OrderByComparator orderByComparator)
		throws NoSuchSpAffiliationException, SystemException {
		SpAffiliation spAffiliation = fetchByRegionId_Last(spRegionId,
				orderByComparator);

		if (spAffiliation != null) {
			return spAffiliation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spRegionId=");
		msg.append(spRegionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpAffiliationException(msg.toString());
	}

	/**
	 * Returns the last sp affiliation in the ordered set where spRegionId = &#63;.
	 *
	 * @param spRegionId the sp region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sp affiliation, or <code>null</code> if a matching sp affiliation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation fetchByRegionId_Last(long spRegionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRegionId(spRegionId);

		if (count == 0) {
			return null;
		}

		List<SpAffiliation> list = findByRegionId(spRegionId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public SpAffiliation[] findByRegionId_PrevAndNext(long spAffiliationId,
		long spRegionId, OrderByComparator orderByComparator)
		throws NoSuchSpAffiliationException, SystemException {
		SpAffiliation spAffiliation = findByPrimaryKey(spAffiliationId);

		Session session = null;

		try {
			session = openSession();

			SpAffiliation[] array = new SpAffiliationImpl[3];

			array[0] = getByRegionId_PrevAndNext(session, spAffiliation,
					spRegionId, orderByComparator, true);

			array[1] = spAffiliation;

			array[2] = getByRegionId_PrevAndNext(session, spAffiliation,
					spRegionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SpAffiliation getByRegionId_PrevAndNext(Session session,
		SpAffiliation spAffiliation, long spRegionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPAFFILIATION_WHERE);

		query.append(_FINDER_COLUMN_REGIONID_SPREGIONID_2);

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
			query.append(SpAffiliationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spRegionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spAffiliation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SpAffiliation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sp affiliations where spRegionId = &#63; from the database.
	 *
	 * @param spRegionId the sp region ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRegionId(long spRegionId) throws SystemException {
		for (SpAffiliation spAffiliation : findByRegionId(spRegionId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spAffiliation);
		}
	}

	/**
	 * Returns the number of sp affiliations where spRegionId = &#63;.
	 *
	 * @param spRegionId the sp region ID
	 * @return the number of matching sp affiliations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRegionId(long spRegionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REGIONID;

		Object[] finderArgs = new Object[] { spRegionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPAFFILIATION_WHERE);

			query.append(_FINDER_COLUMN_REGIONID_SPREGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_REGIONID_SPREGIONID_2 = "spAffiliation.spRegionId = ?";

	public SpAffiliationPersistenceImpl() {
		setModelClass(SpAffiliation.class);
	}

	/**
	 * Caches the sp affiliation in the entity cache if it is enabled.
	 *
	 * @param spAffiliation the sp affiliation
	 */
	@Override
	public void cacheResult(SpAffiliation spAffiliation) {
		EntityCacheUtil.putResult(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
			SpAffiliationImpl.class, spAffiliation.getPrimaryKey(),
			spAffiliation);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_AFFILIATIONCODE,
			new Object[] {
				spAffiliation.getSpRegionId(),
				spAffiliation.getSpAffiliationCode()
			}, spAffiliation);

		spAffiliation.resetOriginalValues();
	}

	/**
	 * Caches the sp affiliations in the entity cache if it is enabled.
	 *
	 * @param spAffiliations the sp affiliations
	 */
	@Override
	public void cacheResult(List<SpAffiliation> spAffiliations) {
		for (SpAffiliation spAffiliation : spAffiliations) {
			if (EntityCacheUtil.getResult(
						SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
						SpAffiliationImpl.class, spAffiliation.getPrimaryKey()) == null) {
				cacheResult(spAffiliation);
			}
			else {
				spAffiliation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sp affiliations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SpAffiliationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SpAffiliationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sp affiliation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SpAffiliation spAffiliation) {
		EntityCacheUtil.removeResult(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
			SpAffiliationImpl.class, spAffiliation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spAffiliation);
	}

	@Override
	public void clearCache(List<SpAffiliation> spAffiliations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SpAffiliation spAffiliation : spAffiliations) {
			EntityCacheUtil.removeResult(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
				SpAffiliationImpl.class, spAffiliation.getPrimaryKey());

			clearUniqueFindersCache(spAffiliation);
		}
	}

	protected void cacheUniqueFindersCache(SpAffiliation spAffiliation) {
		if (spAffiliation.isNew()) {
			Object[] args = new Object[] {
					spAffiliation.getSpRegionId(),
					spAffiliation.getSpAffiliationCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AFFILIATIONCODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_AFFILIATIONCODE,
				args, spAffiliation);
		}
		else {
			SpAffiliationModelImpl spAffiliationModelImpl = (SpAffiliationModelImpl)spAffiliation;

			if ((spAffiliationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_AFFILIATIONCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spAffiliation.getSpRegionId(),
						spAffiliation.getSpAffiliationCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AFFILIATIONCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_AFFILIATIONCODE,
					args, spAffiliation);
			}
		}
	}

	protected void clearUniqueFindersCache(SpAffiliation spAffiliation) {
		SpAffiliationModelImpl spAffiliationModelImpl = (SpAffiliationModelImpl)spAffiliation;

		Object[] args = new Object[] {
				spAffiliation.getSpRegionId(),
				spAffiliation.getSpAffiliationCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AFFILIATIONCODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_AFFILIATIONCODE, args);

		if ((spAffiliationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_AFFILIATIONCODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					spAffiliationModelImpl.getOriginalSpRegionId(),
					spAffiliationModelImpl.getOriginalSpAffiliationCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AFFILIATIONCODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_AFFILIATIONCODE,
				args);
		}
	}

	/**
	 * Creates a new sp affiliation with the primary key. Does not add the sp affiliation to the database.
	 *
	 * @param spAffiliationId the primary key for the new sp affiliation
	 * @return the new sp affiliation
	 */
	@Override
	public SpAffiliation create(long spAffiliationId) {
		SpAffiliation spAffiliation = new SpAffiliationImpl();

		spAffiliation.setNew(true);
		spAffiliation.setPrimaryKey(spAffiliationId);

		return spAffiliation;
	}

	/**
	 * Removes the sp affiliation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spAffiliationId the primary key of the sp affiliation
	 * @return the sp affiliation that was removed
	 * @throws science.platform.NoSuchSpAffiliationException if a sp affiliation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation remove(long spAffiliationId)
		throws NoSuchSpAffiliationException, SystemException {
		return remove((Serializable)spAffiliationId);
	}

	/**
	 * Removes the sp affiliation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sp affiliation
	 * @return the sp affiliation that was removed
	 * @throws science.platform.NoSuchSpAffiliationException if a sp affiliation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation remove(Serializable primaryKey)
		throws NoSuchSpAffiliationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SpAffiliation spAffiliation = (SpAffiliation)session.get(SpAffiliationImpl.class,
					primaryKey);

			if (spAffiliation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpAffiliationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spAffiliation);
		}
		catch (NoSuchSpAffiliationException nsee) {
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
	protected SpAffiliation removeImpl(SpAffiliation spAffiliation)
		throws SystemException {
		spAffiliation = toUnwrappedModel(spAffiliation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spAffiliation)) {
				spAffiliation = (SpAffiliation)session.get(SpAffiliationImpl.class,
						spAffiliation.getPrimaryKeyObj());
			}

			if (spAffiliation != null) {
				session.delete(spAffiliation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spAffiliation != null) {
			clearCache(spAffiliation);
		}

		return spAffiliation;
	}

	@Override
	public SpAffiliation updateImpl(
		science.platform.model.SpAffiliation spAffiliation)
		throws SystemException {
		spAffiliation = toUnwrappedModel(spAffiliation);

		boolean isNew = spAffiliation.isNew();

		SpAffiliationModelImpl spAffiliationModelImpl = (SpAffiliationModelImpl)spAffiliation;

		Session session = null;

		try {
			session = openSession();

			if (spAffiliation.isNew()) {
				session.save(spAffiliation);

				spAffiliation.setNew(false);
			}
			else {
				session.merge(spAffiliation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SpAffiliationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spAffiliationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spAffiliationModelImpl.getOriginalSpCountryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYID,
					args);

				args = new Object[] { spAffiliationModelImpl.getSpCountryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYID,
					args);
			}

			if ((spAffiliationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spAffiliationModelImpl.getOriginalSpRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID,
					args);

				args = new Object[] { spAffiliationModelImpl.getSpRegionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
			SpAffiliationImpl.class, spAffiliation.getPrimaryKey(),
			spAffiliation);

		clearUniqueFindersCache(spAffiliation);
		cacheUniqueFindersCache(spAffiliation);

		return spAffiliation;
	}

	protected SpAffiliation toUnwrappedModel(SpAffiliation spAffiliation) {
		if (spAffiliation instanceof SpAffiliationImpl) {
			return spAffiliation;
		}

		SpAffiliationImpl spAffiliationImpl = new SpAffiliationImpl();

		spAffiliationImpl.setNew(spAffiliation.isNew());
		spAffiliationImpl.setPrimaryKey(spAffiliation.getPrimaryKey());

		spAffiliationImpl.setSpAffiliationId(spAffiliation.getSpAffiliationId());
		spAffiliationImpl.setSpRegionId(spAffiliation.getSpRegionId());
		spAffiliationImpl.setSpCountryId(spAffiliation.getSpCountryId());
		spAffiliationImpl.setSpAffiliationCode(spAffiliation.getSpAffiliationCode());
		spAffiliationImpl.setSpAffiliationName(spAffiliation.getSpAffiliationName());
		spAffiliationImpl.setSpActive(spAffiliation.isSpActive());

		return spAffiliationImpl;
	}

	/**
	 * Returns the sp affiliation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sp affiliation
	 * @return the sp affiliation
	 * @throws science.platform.NoSuchSpAffiliationException if a sp affiliation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpAffiliationException, SystemException {
		SpAffiliation spAffiliation = fetchByPrimaryKey(primaryKey);

		if (spAffiliation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpAffiliationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spAffiliation;
	}

	/**
	 * Returns the sp affiliation with the primary key or throws a {@link science.platform.NoSuchSpAffiliationException} if it could not be found.
	 *
	 * @param spAffiliationId the primary key of the sp affiliation
	 * @return the sp affiliation
	 * @throws science.platform.NoSuchSpAffiliationException if a sp affiliation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation findByPrimaryKey(long spAffiliationId)
		throws NoSuchSpAffiliationException, SystemException {
		return findByPrimaryKey((Serializable)spAffiliationId);
	}

	/**
	 * Returns the sp affiliation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sp affiliation
	 * @return the sp affiliation, or <code>null</code> if a sp affiliation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SpAffiliation spAffiliation = (SpAffiliation)EntityCacheUtil.getResult(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
				SpAffiliationImpl.class, primaryKey);

		if (spAffiliation == _nullSpAffiliation) {
			return null;
		}

		if (spAffiliation == null) {
			Session session = null;

			try {
				session = openSession();

				spAffiliation = (SpAffiliation)session.get(SpAffiliationImpl.class,
						primaryKey);

				if (spAffiliation != null) {
					cacheResult(spAffiliation);
				}
				else {
					EntityCacheUtil.putResult(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
						SpAffiliationImpl.class, primaryKey, _nullSpAffiliation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SpAffiliationModelImpl.ENTITY_CACHE_ENABLED,
					SpAffiliationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spAffiliation;
	}

	/**
	 * Returns the sp affiliation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spAffiliationId the primary key of the sp affiliation
	 * @return the sp affiliation, or <code>null</code> if a sp affiliation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation fetchByPrimaryKey(long spAffiliationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spAffiliationId);
	}

	/**
	 * Returns all the sp affiliations.
	 *
	 * @return the sp affiliations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpAffiliation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<SpAffiliation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<SpAffiliation> findAll(int start, int end,
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

		List<SpAffiliation> list = (List<SpAffiliation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPAFFILIATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPAFFILIATION;

				if (pagination) {
					sql = sql.concat(SpAffiliationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SpAffiliation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SpAffiliation>(list);
				}
				else {
					list = (List<SpAffiliation>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the sp affiliations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SpAffiliation spAffiliation : findAll()) {
			remove(spAffiliation);
		}
	}

	/**
	 * Returns the number of sp affiliations.
	 *
	 * @return the number of sp affiliations
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

				Query q = session.createQuery(_SQL_COUNT_SPAFFILIATION);

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
	 * Initializes the sp affiliation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.science.platform.model.SpAffiliation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SpAffiliation>> listenersList = new ArrayList<ModelListener<SpAffiliation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SpAffiliation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SpAffiliationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPAFFILIATION = "SELECT spAffiliation FROM SpAffiliation spAffiliation";
	private static final String _SQL_SELECT_SPAFFILIATION_WHERE = "SELECT spAffiliation FROM SpAffiliation spAffiliation WHERE ";
	private static final String _SQL_COUNT_SPAFFILIATION = "SELECT COUNT(spAffiliation) FROM SpAffiliation spAffiliation";
	private static final String _SQL_COUNT_SPAFFILIATION_WHERE = "SELECT COUNT(spAffiliation) FROM SpAffiliation spAffiliation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spAffiliation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SpAffiliation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SpAffiliation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SpAffiliationPersistenceImpl.class);
	private static SpAffiliation _nullSpAffiliation = new SpAffiliationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SpAffiliation> toCacheModel() {
				return _nullSpAffiliationCacheModel;
			}
		};

	private static CacheModel<SpAffiliation> _nullSpAffiliationCacheModel = new CacheModel<SpAffiliation>() {
			@Override
			public SpAffiliation toEntityModel() {
				return _nullSpAffiliation;
			}
		};
}