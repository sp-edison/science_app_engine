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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import science.platform.NoSuchSpUserDomainException;

import science.platform.model.SpUserDomain;
import science.platform.model.impl.SpUserDomainImpl;
import science.platform.model.impl.SpUserDomainModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the sp user domain service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpUserDomainPersistence
 * @see SpUserDomainUtil
 * @generated
 */
public class SpUserDomainPersistenceImpl extends BasePersistenceImpl<SpUserDomain>
	implements SpUserDomainPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SpUserDomainUtil} to access the sp user domain persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SpUserDomainImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
			SpUserDomainModelImpl.FINDER_CACHE_ENABLED, SpUserDomainImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
			SpUserDomainModelImpl.FINDER_CACHE_ENABLED, SpUserDomainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
			SpUserDomainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPUSERID = new FinderPath(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
			SpUserDomainModelImpl.FINDER_CACHE_ENABLED, SpUserDomainImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySpUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPUSERID =
		new FinderPath(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
			SpUserDomainModelImpl.FINDER_CACHE_ENABLED, SpUserDomainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySpUserId",
			new String[] { Long.class.getName() },
			SpUserDomainModelImpl.SPUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPUSERID = new FinderPath(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
			SpUserDomainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySpUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the sp user domains where spUserId = &#63;.
	 *
	 * @param spUserId the sp user ID
	 * @return the matching sp user domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpUserDomain> findBySpUserId(long spUserId)
		throws SystemException {
		return findBySpUserId(spUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<SpUserDomain> findBySpUserId(long spUserId, int start, int end)
		throws SystemException {
		return findBySpUserId(spUserId, start, end, null);
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
	@Override
	public List<SpUserDomain> findBySpUserId(long spUserId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPUSERID;
			finderArgs = new Object[] { spUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPUSERID;
			finderArgs = new Object[] { spUserId, start, end, orderByComparator };
		}

		List<SpUserDomain> list = (List<SpUserDomain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SpUserDomain spUserDomain : list) {
				if ((spUserId != spUserDomain.getSpUserId())) {
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

			query.append(_SQL_SELECT_SPUSERDOMAIN_WHERE);

			query.append(_FINDER_COLUMN_SPUSERID_SPUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SpUserDomainModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spUserId);

				if (!pagination) {
					list = (List<SpUserDomain>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SpUserDomain>(list);
				}
				else {
					list = (List<SpUserDomain>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first sp user domain in the ordered set where spUserId = &#63;.
	 *
	 * @param spUserId the sp user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sp user domain
	 * @throws science.platform.NoSuchSpUserDomainException if a matching sp user domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUserDomain findBySpUserId_First(long spUserId,
		OrderByComparator orderByComparator)
		throws NoSuchSpUserDomainException, SystemException {
		SpUserDomain spUserDomain = fetchBySpUserId_First(spUserId,
				orderByComparator);

		if (spUserDomain != null) {
			return spUserDomain;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spUserId=");
		msg.append(spUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpUserDomainException(msg.toString());
	}

	/**
	 * Returns the first sp user domain in the ordered set where spUserId = &#63;.
	 *
	 * @param spUserId the sp user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUserDomain fetchBySpUserId_First(long spUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SpUserDomain> list = findBySpUserId(spUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SpUserDomain findBySpUserId_Last(long spUserId,
		OrderByComparator orderByComparator)
		throws NoSuchSpUserDomainException, SystemException {
		SpUserDomain spUserDomain = fetchBySpUserId_Last(spUserId,
				orderByComparator);

		if (spUserDomain != null) {
			return spUserDomain;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spUserId=");
		msg.append(spUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpUserDomainException(msg.toString());
	}

	/**
	 * Returns the last sp user domain in the ordered set where spUserId = &#63;.
	 *
	 * @param spUserId the sp user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUserDomain fetchBySpUserId_Last(long spUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySpUserId(spUserId);

		if (count == 0) {
			return null;
		}

		List<SpUserDomain> list = findBySpUserId(spUserId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SpUserDomain[] findBySpUserId_PrevAndNext(long spUserDomainId,
		long spUserId, OrderByComparator orderByComparator)
		throws NoSuchSpUserDomainException, SystemException {
		SpUserDomain spUserDomain = findByPrimaryKey(spUserDomainId);

		Session session = null;

		try {
			session = openSession();

			SpUserDomain[] array = new SpUserDomainImpl[3];

			array[0] = getBySpUserId_PrevAndNext(session, spUserDomain,
					spUserId, orderByComparator, true);

			array[1] = spUserDomain;

			array[2] = getBySpUserId_PrevAndNext(session, spUserDomain,
					spUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SpUserDomain getBySpUserId_PrevAndNext(Session session,
		SpUserDomain spUserDomain, long spUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPUSERDOMAIN_WHERE);

		query.append(_FINDER_COLUMN_SPUSERID_SPUSERID_2);

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
			query.append(SpUserDomainModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spUserDomain);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SpUserDomain> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sp user domains where spUserId = &#63; from the database.
	 *
	 * @param spUserId the sp user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySpUserId(long spUserId) throws SystemException {
		for (SpUserDomain spUserDomain : findBySpUserId(spUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spUserDomain);
		}
	}

	/**
	 * Returns the number of sp user domains where spUserId = &#63;.
	 *
	 * @param spUserId the sp user ID
	 * @return the number of matching sp user domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySpUserId(long spUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPUSERID;

		Object[] finderArgs = new Object[] { spUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPUSERDOMAIN_WHERE);

			query.append(_FINDER_COLUMN_SPUSERID_SPUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spUserId);

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

	private static final String _FINDER_COLUMN_SPUSERID_SPUSERID_2 = "spUserDomain.spUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPDOMAINID =
		new FinderPath(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
			SpUserDomainModelImpl.FINDER_CACHE_ENABLED, SpUserDomainImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySpDomainId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPDOMAINID =
		new FinderPath(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
			SpUserDomainModelImpl.FINDER_CACHE_ENABLED, SpUserDomainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySpDomainId",
			new String[] { Long.class.getName() },
			SpUserDomainModelImpl.SPDOMAINID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPDOMAINID = new FinderPath(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
			SpUserDomainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySpDomainId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the sp user domains where spDomainId = &#63;.
	 *
	 * @param spDomainId the sp domain ID
	 * @return the matching sp user domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpUserDomain> findBySpDomainId(long spDomainId)
		throws SystemException {
		return findBySpDomainId(spDomainId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SpUserDomain> findBySpDomainId(long spDomainId, int start,
		int end) throws SystemException {
		return findBySpDomainId(spDomainId, start, end, null);
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
	@Override
	public List<SpUserDomain> findBySpDomainId(long spDomainId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPDOMAINID;
			finderArgs = new Object[] { spDomainId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPDOMAINID;
			finderArgs = new Object[] { spDomainId, start, end, orderByComparator };
		}

		List<SpUserDomain> list = (List<SpUserDomain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SpUserDomain spUserDomain : list) {
				if ((spDomainId != spUserDomain.getSpDomainId())) {
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

			query.append(_SQL_SELECT_SPUSERDOMAIN_WHERE);

			query.append(_FINDER_COLUMN_SPDOMAINID_SPDOMAINID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SpUserDomainModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spDomainId);

				if (!pagination) {
					list = (List<SpUserDomain>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SpUserDomain>(list);
				}
				else {
					list = (List<SpUserDomain>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first sp user domain in the ordered set where spDomainId = &#63;.
	 *
	 * @param spDomainId the sp domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sp user domain
	 * @throws science.platform.NoSuchSpUserDomainException if a matching sp user domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUserDomain findBySpDomainId_First(long spDomainId,
		OrderByComparator orderByComparator)
		throws NoSuchSpUserDomainException, SystemException {
		SpUserDomain spUserDomain = fetchBySpDomainId_First(spDomainId,
				orderByComparator);

		if (spUserDomain != null) {
			return spUserDomain;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spDomainId=");
		msg.append(spDomainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpUserDomainException(msg.toString());
	}

	/**
	 * Returns the first sp user domain in the ordered set where spDomainId = &#63;.
	 *
	 * @param spDomainId the sp domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUserDomain fetchBySpDomainId_First(long spDomainId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SpUserDomain> list = findBySpDomainId(spDomainId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SpUserDomain findBySpDomainId_Last(long spDomainId,
		OrderByComparator orderByComparator)
		throws NoSuchSpUserDomainException, SystemException {
		SpUserDomain spUserDomain = fetchBySpDomainId_Last(spDomainId,
				orderByComparator);

		if (spUserDomain != null) {
			return spUserDomain;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spDomainId=");
		msg.append(spDomainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpUserDomainException(msg.toString());
	}

	/**
	 * Returns the last sp user domain in the ordered set where spDomainId = &#63;.
	 *
	 * @param spDomainId the sp domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUserDomain fetchBySpDomainId_Last(long spDomainId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySpDomainId(spDomainId);

		if (count == 0) {
			return null;
		}

		List<SpUserDomain> list = findBySpDomainId(spDomainId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SpUserDomain[] findBySpDomainId_PrevAndNext(long spUserDomainId,
		long spDomainId, OrderByComparator orderByComparator)
		throws NoSuchSpUserDomainException, SystemException {
		SpUserDomain spUserDomain = findByPrimaryKey(spUserDomainId);

		Session session = null;

		try {
			session = openSession();

			SpUserDomain[] array = new SpUserDomainImpl[3];

			array[0] = getBySpDomainId_PrevAndNext(session, spUserDomain,
					spDomainId, orderByComparator, true);

			array[1] = spUserDomain;

			array[2] = getBySpDomainId_PrevAndNext(session, spUserDomain,
					spDomainId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SpUserDomain getBySpDomainId_PrevAndNext(Session session,
		SpUserDomain spUserDomain, long spDomainId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPUSERDOMAIN_WHERE);

		query.append(_FINDER_COLUMN_SPDOMAINID_SPDOMAINID_2);

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
			query.append(SpUserDomainModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spDomainId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spUserDomain);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SpUserDomain> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sp user domains where spDomainId = &#63; from the database.
	 *
	 * @param spDomainId the sp domain ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySpDomainId(long spDomainId) throws SystemException {
		for (SpUserDomain spUserDomain : findBySpDomainId(spDomainId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spUserDomain);
		}
	}

	/**
	 * Returns the number of sp user domains where spDomainId = &#63;.
	 *
	 * @param spDomainId the sp domain ID
	 * @return the number of matching sp user domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySpDomainId(long spDomainId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPDOMAINID;

		Object[] finderArgs = new Object[] { spDomainId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPUSERDOMAIN_WHERE);

			query.append(_FINDER_COLUMN_SPDOMAINID_SPDOMAINID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spDomainId);

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

	private static final String _FINDER_COLUMN_SPDOMAINID_SPDOMAINID_2 = "spUserDomain.spDomainId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_SPUSERDOMAINID = new FinderPath(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
			SpUserDomainModelImpl.FINDER_CACHE_ENABLED, SpUserDomainImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySpUserDomainId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SpUserDomainModelImpl.SPUSERID_COLUMN_BITMASK |
			SpUserDomainModelImpl.SPDOMAINID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPUSERDOMAINID = new FinderPath(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
			SpUserDomainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySpUserDomainId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the sp user domain where spUserId = &#63; and spDomainId = &#63; or throws a {@link science.platform.NoSuchSpUserDomainException} if it could not be found.
	 *
	 * @param spUserId the sp user ID
	 * @param spDomainId the sp domain ID
	 * @return the matching sp user domain
	 * @throws science.platform.NoSuchSpUserDomainException if a matching sp user domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUserDomain findBySpUserDomainId(long spUserId, long spDomainId)
		throws NoSuchSpUserDomainException, SystemException {
		SpUserDomain spUserDomain = fetchBySpUserDomainId(spUserId, spDomainId);

		if (spUserDomain == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spUserId=");
			msg.append(spUserId);

			msg.append(", spDomainId=");
			msg.append(spDomainId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSpUserDomainException(msg.toString());
		}

		return spUserDomain;
	}

	/**
	 * Returns the sp user domain where spUserId = &#63; and spDomainId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spUserId the sp user ID
	 * @param spDomainId the sp domain ID
	 * @return the matching sp user domain, or <code>null</code> if a matching sp user domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUserDomain fetchBySpUserDomainId(long spUserId, long spDomainId)
		throws SystemException {
		return fetchBySpUserDomainId(spUserId, spDomainId, true);
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
	@Override
	public SpUserDomain fetchBySpUserDomainId(long spUserId, long spDomainId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { spUserId, spDomainId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SPUSERDOMAINID,
					finderArgs, this);
		}

		if (result instanceof SpUserDomain) {
			SpUserDomain spUserDomain = (SpUserDomain)result;

			if ((spUserId != spUserDomain.getSpUserId()) ||
					(spDomainId != spUserDomain.getSpDomainId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPUSERDOMAIN_WHERE);

			query.append(_FINDER_COLUMN_SPUSERDOMAINID_SPUSERID_2);

			query.append(_FINDER_COLUMN_SPUSERDOMAINID_SPDOMAINID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spUserId);

				qPos.add(spDomainId);

				List<SpUserDomain> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPUSERDOMAINID,
						finderArgs, list);
				}
				else {
					SpUserDomain spUserDomain = list.get(0);

					result = spUserDomain;

					cacheResult(spUserDomain);

					if ((spUserDomain.getSpUserId() != spUserId) ||
							(spUserDomain.getSpDomainId() != spDomainId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPUSERDOMAINID,
							finderArgs, spUserDomain);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SPUSERDOMAINID,
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
			return (SpUserDomain)result;
		}
	}

	/**
	 * Removes the sp user domain where spUserId = &#63; and spDomainId = &#63; from the database.
	 *
	 * @param spUserId the sp user ID
	 * @param spDomainId the sp domain ID
	 * @return the sp user domain that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUserDomain removeBySpUserDomainId(long spUserId, long spDomainId)
		throws NoSuchSpUserDomainException, SystemException {
		SpUserDomain spUserDomain = findBySpUserDomainId(spUserId, spDomainId);

		return remove(spUserDomain);
	}

	/**
	 * Returns the number of sp user domains where spUserId = &#63; and spDomainId = &#63;.
	 *
	 * @param spUserId the sp user ID
	 * @param spDomainId the sp domain ID
	 * @return the number of matching sp user domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySpUserDomainId(long spUserId, long spDomainId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPUSERDOMAINID;

		Object[] finderArgs = new Object[] { spUserId, spDomainId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPUSERDOMAIN_WHERE);

			query.append(_FINDER_COLUMN_SPUSERDOMAINID_SPUSERID_2);

			query.append(_FINDER_COLUMN_SPUSERDOMAINID_SPDOMAINID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spUserId);

				qPos.add(spDomainId);

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

	private static final String _FINDER_COLUMN_SPUSERDOMAINID_SPUSERID_2 = "spUserDomain.spUserId = ? AND ";
	private static final String _FINDER_COLUMN_SPUSERDOMAINID_SPDOMAINID_2 = "spUserDomain.spDomainId = ?";

	public SpUserDomainPersistenceImpl() {
		setModelClass(SpUserDomain.class);
	}

	/**
	 * Caches the sp user domain in the entity cache if it is enabled.
	 *
	 * @param spUserDomain the sp user domain
	 */
	@Override
	public void cacheResult(SpUserDomain spUserDomain) {
		EntityCacheUtil.putResult(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
			SpUserDomainImpl.class, spUserDomain.getPrimaryKey(), spUserDomain);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPUSERDOMAINID,
			new Object[] {
				spUserDomain.getSpUserId(), spUserDomain.getSpDomainId()
			}, spUserDomain);

		spUserDomain.resetOriginalValues();
	}

	/**
	 * Caches the sp user domains in the entity cache if it is enabled.
	 *
	 * @param spUserDomains the sp user domains
	 */
	@Override
	public void cacheResult(List<SpUserDomain> spUserDomains) {
		for (SpUserDomain spUserDomain : spUserDomains) {
			if (EntityCacheUtil.getResult(
						SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
						SpUserDomainImpl.class, spUserDomain.getPrimaryKey()) == null) {
				cacheResult(spUserDomain);
			}
			else {
				spUserDomain.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sp user domains.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SpUserDomainImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SpUserDomainImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sp user domain.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SpUserDomain spUserDomain) {
		EntityCacheUtil.removeResult(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
			SpUserDomainImpl.class, spUserDomain.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spUserDomain);
	}

	@Override
	public void clearCache(List<SpUserDomain> spUserDomains) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SpUserDomain spUserDomain : spUserDomains) {
			EntityCacheUtil.removeResult(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
				SpUserDomainImpl.class, spUserDomain.getPrimaryKey());

			clearUniqueFindersCache(spUserDomain);
		}
	}

	protected void cacheUniqueFindersCache(SpUserDomain spUserDomain) {
		if (spUserDomain.isNew()) {
			Object[] args = new Object[] {
					spUserDomain.getSpUserId(), spUserDomain.getSpDomainId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SPUSERDOMAINID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPUSERDOMAINID,
				args, spUserDomain);
		}
		else {
			SpUserDomainModelImpl spUserDomainModelImpl = (SpUserDomainModelImpl)spUserDomain;

			if ((spUserDomainModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SPUSERDOMAINID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserDomain.getSpUserId(), spUserDomain.getSpDomainId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SPUSERDOMAINID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPUSERDOMAINID,
					args, spUserDomain);
			}
		}
	}

	protected void clearUniqueFindersCache(SpUserDomain spUserDomain) {
		SpUserDomainModelImpl spUserDomainModelImpl = (SpUserDomainModelImpl)spUserDomain;

		Object[] args = new Object[] {
				spUserDomain.getSpUserId(), spUserDomain.getSpDomainId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPUSERDOMAINID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SPUSERDOMAINID, args);

		if ((spUserDomainModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SPUSERDOMAINID.getColumnBitmask()) != 0) {
			args = new Object[] {
					spUserDomainModelImpl.getOriginalSpUserId(),
					spUserDomainModelImpl.getOriginalSpDomainId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPUSERDOMAINID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SPUSERDOMAINID,
				args);
		}
	}

	/**
	 * Creates a new sp user domain with the primary key. Does not add the sp user domain to the database.
	 *
	 * @param spUserDomainId the primary key for the new sp user domain
	 * @return the new sp user domain
	 */
	@Override
	public SpUserDomain create(long spUserDomainId) {
		SpUserDomain spUserDomain = new SpUserDomainImpl();

		spUserDomain.setNew(true);
		spUserDomain.setPrimaryKey(spUserDomainId);

		return spUserDomain;
	}

	/**
	 * Removes the sp user domain with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spUserDomainId the primary key of the sp user domain
	 * @return the sp user domain that was removed
	 * @throws science.platform.NoSuchSpUserDomainException if a sp user domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUserDomain remove(long spUserDomainId)
		throws NoSuchSpUserDomainException, SystemException {
		return remove((Serializable)spUserDomainId);
	}

	/**
	 * Removes the sp user domain with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sp user domain
	 * @return the sp user domain that was removed
	 * @throws science.platform.NoSuchSpUserDomainException if a sp user domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUserDomain remove(Serializable primaryKey)
		throws NoSuchSpUserDomainException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SpUserDomain spUserDomain = (SpUserDomain)session.get(SpUserDomainImpl.class,
					primaryKey);

			if (spUserDomain == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpUserDomainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spUserDomain);
		}
		catch (NoSuchSpUserDomainException nsee) {
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
	protected SpUserDomain removeImpl(SpUserDomain spUserDomain)
		throws SystemException {
		spUserDomain = toUnwrappedModel(spUserDomain);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spUserDomain)) {
				spUserDomain = (SpUserDomain)session.get(SpUserDomainImpl.class,
						spUserDomain.getPrimaryKeyObj());
			}

			if (spUserDomain != null) {
				session.delete(spUserDomain);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spUserDomain != null) {
			clearCache(spUserDomain);
		}

		return spUserDomain;
	}

	@Override
	public SpUserDomain updateImpl(
		science.platform.model.SpUserDomain spUserDomain)
		throws SystemException {
		spUserDomain = toUnwrappedModel(spUserDomain);

		boolean isNew = spUserDomain.isNew();

		SpUserDomainModelImpl spUserDomainModelImpl = (SpUserDomainModelImpl)spUserDomain;

		Session session = null;

		try {
			session = openSession();

			if (spUserDomain.isNew()) {
				session.save(spUserDomain);

				spUserDomain.setNew(false);
			}
			else {
				session.merge(spUserDomain);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SpUserDomainModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spUserDomainModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserDomainModelImpl.getOriginalSpUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPUSERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPUSERID,
					args);

				args = new Object[] { spUserDomainModelImpl.getSpUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPUSERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPUSERID,
					args);
			}

			if ((spUserDomainModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPDOMAINID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserDomainModelImpl.getOriginalSpDomainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPDOMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPDOMAINID,
					args);

				args = new Object[] { spUserDomainModelImpl.getSpDomainId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPDOMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPDOMAINID,
					args);
			}
		}

		EntityCacheUtil.putResult(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
			SpUserDomainImpl.class, spUserDomain.getPrimaryKey(), spUserDomain);

		clearUniqueFindersCache(spUserDomain);
		cacheUniqueFindersCache(spUserDomain);

		return spUserDomain;
	}

	protected SpUserDomain toUnwrappedModel(SpUserDomain spUserDomain) {
		if (spUserDomain instanceof SpUserDomainImpl) {
			return spUserDomain;
		}

		SpUserDomainImpl spUserDomainImpl = new SpUserDomainImpl();

		spUserDomainImpl.setNew(spUserDomain.isNew());
		spUserDomainImpl.setPrimaryKey(spUserDomain.getPrimaryKey());

		spUserDomainImpl.setSpUserDomainId(spUserDomain.getSpUserDomainId());
		spUserDomainImpl.setSpDomainId(spUserDomain.getSpDomainId());
		spUserDomainImpl.setSpUserId(spUserDomain.getSpUserId());
		spUserDomainImpl.setApActive(spUserDomain.isApActive());

		return spUserDomainImpl;
	}

	/**
	 * Returns the sp user domain with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sp user domain
	 * @return the sp user domain
	 * @throws science.platform.NoSuchSpUserDomainException if a sp user domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUserDomain findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpUserDomainException, SystemException {
		SpUserDomain spUserDomain = fetchByPrimaryKey(primaryKey);

		if (spUserDomain == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpUserDomainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spUserDomain;
	}

	/**
	 * Returns the sp user domain with the primary key or throws a {@link science.platform.NoSuchSpUserDomainException} if it could not be found.
	 *
	 * @param spUserDomainId the primary key of the sp user domain
	 * @return the sp user domain
	 * @throws science.platform.NoSuchSpUserDomainException if a sp user domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUserDomain findByPrimaryKey(long spUserDomainId)
		throws NoSuchSpUserDomainException, SystemException {
		return findByPrimaryKey((Serializable)spUserDomainId);
	}

	/**
	 * Returns the sp user domain with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sp user domain
	 * @return the sp user domain, or <code>null</code> if a sp user domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUserDomain fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SpUserDomain spUserDomain = (SpUserDomain)EntityCacheUtil.getResult(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
				SpUserDomainImpl.class, primaryKey);

		if (spUserDomain == _nullSpUserDomain) {
			return null;
		}

		if (spUserDomain == null) {
			Session session = null;

			try {
				session = openSession();

				spUserDomain = (SpUserDomain)session.get(SpUserDomainImpl.class,
						primaryKey);

				if (spUserDomain != null) {
					cacheResult(spUserDomain);
				}
				else {
					EntityCacheUtil.putResult(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
						SpUserDomainImpl.class, primaryKey, _nullSpUserDomain);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SpUserDomainModelImpl.ENTITY_CACHE_ENABLED,
					SpUserDomainImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spUserDomain;
	}

	/**
	 * Returns the sp user domain with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spUserDomainId the primary key of the sp user domain
	 * @return the sp user domain, or <code>null</code> if a sp user domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUserDomain fetchByPrimaryKey(long spUserDomainId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spUserDomainId);
	}

	/**
	 * Returns all the sp user domains.
	 *
	 * @return the sp user domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpUserDomain> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SpUserDomain> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SpUserDomain> findAll(int start, int end,
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

		List<SpUserDomain> list = (List<SpUserDomain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPUSERDOMAIN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPUSERDOMAIN;

				if (pagination) {
					sql = sql.concat(SpUserDomainModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SpUserDomain>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SpUserDomain>(list);
				}
				else {
					list = (List<SpUserDomain>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the sp user domains from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SpUserDomain spUserDomain : findAll()) {
			remove(spUserDomain);
		}
	}

	/**
	 * Returns the number of sp user domains.
	 *
	 * @return the number of sp user domains
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

				Query q = session.createQuery(_SQL_COUNT_SPUSERDOMAIN);

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
	 * Initializes the sp user domain persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.science.platform.model.SpUserDomain")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SpUserDomain>> listenersList = new ArrayList<ModelListener<SpUserDomain>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SpUserDomain>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SpUserDomainImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPUSERDOMAIN = "SELECT spUserDomain FROM SpUserDomain spUserDomain";
	private static final String _SQL_SELECT_SPUSERDOMAIN_WHERE = "SELECT spUserDomain FROM SpUserDomain spUserDomain WHERE ";
	private static final String _SQL_COUNT_SPUSERDOMAIN = "SELECT COUNT(spUserDomain) FROM SpUserDomain spUserDomain";
	private static final String _SQL_COUNT_SPUSERDOMAIN_WHERE = "SELECT COUNT(spUserDomain) FROM SpUserDomain spUserDomain WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spUserDomain.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SpUserDomain exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SpUserDomain exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SpUserDomainPersistenceImpl.class);
	private static SpUserDomain _nullSpUserDomain = new SpUserDomainImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SpUserDomain> toCacheModel() {
				return _nullSpUserDomainCacheModel;
			}
		};

	private static CacheModel<SpUserDomain> _nullSpUserDomainCacheModel = new CacheModel<SpUserDomain>() {
			@Override
			public SpUserDomain toEntityModel() {
				return _nullSpUserDomain;
			}
		};
}