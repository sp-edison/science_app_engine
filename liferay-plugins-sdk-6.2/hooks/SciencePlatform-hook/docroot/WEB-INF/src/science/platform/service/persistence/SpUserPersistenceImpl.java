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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import science.platform.NoSuchSpUserException;

import science.platform.model.SpUser;
import science.platform.model.impl.SpUserImpl;
import science.platform.model.impl.SpUserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the sp user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpUserPersistence
 * @see SpUserUtil
 * @generated
 */
public class SpUserPersistenceImpl extends BasePersistenceImpl<SpUser>
	implements SpUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SpUserUtil} to access the sp user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SpUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SpUserModelImpl.ENTITY_CACHE_ENABLED,
			SpUserModelImpl.FINDER_CACHE_ENABLED, SpUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SpUserModelImpl.ENTITY_CACHE_ENABLED,
			SpUserModelImpl.FINDER_CACHE_ENABLED, SpUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SpUserModelImpl.ENTITY_CACHE_ENABLED,
			SpUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SpUserPersistenceImpl() {
		setModelClass(SpUser.class);
	}

	/**
	 * Caches the sp user in the entity cache if it is enabled.
	 *
	 * @param spUser the sp user
	 */
	@Override
	public void cacheResult(SpUser spUser) {
		EntityCacheUtil.putResult(SpUserModelImpl.ENTITY_CACHE_ENABLED,
			SpUserImpl.class, spUser.getPrimaryKey(), spUser);

		spUser.resetOriginalValues();
	}

	/**
	 * Caches the sp users in the entity cache if it is enabled.
	 *
	 * @param spUsers the sp users
	 */
	@Override
	public void cacheResult(List<SpUser> spUsers) {
		for (SpUser spUser : spUsers) {
			if (EntityCacheUtil.getResult(
						SpUserModelImpl.ENTITY_CACHE_ENABLED, SpUserImpl.class,
						spUser.getPrimaryKey()) == null) {
				cacheResult(spUser);
			}
			else {
				spUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sp users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SpUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SpUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sp user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SpUser spUser) {
		EntityCacheUtil.removeResult(SpUserModelImpl.ENTITY_CACHE_ENABLED,
			SpUserImpl.class, spUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SpUser> spUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SpUser spUser : spUsers) {
			EntityCacheUtil.removeResult(SpUserModelImpl.ENTITY_CACHE_ENABLED,
				SpUserImpl.class, spUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sp user with the primary key. Does not add the sp user to the database.
	 *
	 * @param spUserId the primary key for the new sp user
	 * @return the new sp user
	 */
	@Override
	public SpUser create(long spUserId) {
		SpUser spUser = new SpUserImpl();

		spUser.setNew(true);
		spUser.setPrimaryKey(spUserId);

		return spUser;
	}

	/**
	 * Removes the sp user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spUserId the primary key of the sp user
	 * @return the sp user that was removed
	 * @throws science.platform.NoSuchSpUserException if a sp user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUser remove(long spUserId)
		throws NoSuchSpUserException, SystemException {
		return remove((Serializable)spUserId);
	}

	/**
	 * Removes the sp user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sp user
	 * @return the sp user that was removed
	 * @throws science.platform.NoSuchSpUserException if a sp user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUser remove(Serializable primaryKey)
		throws NoSuchSpUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SpUser spUser = (SpUser)session.get(SpUserImpl.class, primaryKey);

			if (spUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spUser);
		}
		catch (NoSuchSpUserException nsee) {
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
	protected SpUser removeImpl(SpUser spUser) throws SystemException {
		spUser = toUnwrappedModel(spUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spUser)) {
				spUser = (SpUser)session.get(SpUserImpl.class,
						spUser.getPrimaryKeyObj());
			}

			if (spUser != null) {
				session.delete(spUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spUser != null) {
			clearCache(spUser);
		}

		return spUser;
	}

	@Override
	public SpUser updateImpl(science.platform.model.SpUser spUser)
		throws SystemException {
		spUser = toUnwrappedModel(spUser);

		boolean isNew = spUser.isNew();

		Session session = null;

		try {
			session = openSession();

			if (spUser.isNew()) {
				session.save(spUser);

				spUser.setNew(false);
			}
			else {
				session.merge(spUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SpUserModelImpl.ENTITY_CACHE_ENABLED,
			SpUserImpl.class, spUser.getPrimaryKey(), spUser);

		return spUser;
	}

	protected SpUser toUnwrappedModel(SpUser spUser) {
		if (spUser instanceof SpUserImpl) {
			return spUser;
		}

		SpUserImpl spUserImpl = new SpUserImpl();

		spUserImpl.setNew(spUser.isNew());
		spUserImpl.setPrimaryKey(spUser.getPrimaryKey());

		spUserImpl.setSpUserId(spUser.getSpUserId());
		spUserImpl.setSpCountryId(spUser.getSpCountryId());
		spUserImpl.setSpRegionId(spUser.getSpRegionId());
		spUserImpl.setSpAffiliationId(spUser.getSpAffiliationId());
		spUserImpl.setSpUserFullName(spUser.getSpUserFullName());

		return spUserImpl;
	}

	/**
	 * Returns the sp user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sp user
	 * @return the sp user
	 * @throws science.platform.NoSuchSpUserException if a sp user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpUserException, SystemException {
		SpUser spUser = fetchByPrimaryKey(primaryKey);

		if (spUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spUser;
	}

	/**
	 * Returns the sp user with the primary key or throws a {@link science.platform.NoSuchSpUserException} if it could not be found.
	 *
	 * @param spUserId the primary key of the sp user
	 * @return the sp user
	 * @throws science.platform.NoSuchSpUserException if a sp user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUser findByPrimaryKey(long spUserId)
		throws NoSuchSpUserException, SystemException {
		return findByPrimaryKey((Serializable)spUserId);
	}

	/**
	 * Returns the sp user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sp user
	 * @return the sp user, or <code>null</code> if a sp user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SpUser spUser = (SpUser)EntityCacheUtil.getResult(SpUserModelImpl.ENTITY_CACHE_ENABLED,
				SpUserImpl.class, primaryKey);

		if (spUser == _nullSpUser) {
			return null;
		}

		if (spUser == null) {
			Session session = null;

			try {
				session = openSession();

				spUser = (SpUser)session.get(SpUserImpl.class, primaryKey);

				if (spUser != null) {
					cacheResult(spUser);
				}
				else {
					EntityCacheUtil.putResult(SpUserModelImpl.ENTITY_CACHE_ENABLED,
						SpUserImpl.class, primaryKey, _nullSpUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SpUserModelImpl.ENTITY_CACHE_ENABLED,
					SpUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spUser;
	}

	/**
	 * Returns the sp user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spUserId the primary key of the sp user
	 * @return the sp user, or <code>null</code> if a sp user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpUser fetchByPrimaryKey(long spUserId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spUserId);
	}

	/**
	 * Returns all the sp users.
	 *
	 * @return the sp users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sp users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sp users
	 * @param end the upper bound of the range of sp users (not inclusive)
	 * @return the range of sp users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpUser> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sp users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sp users
	 * @param end the upper bound of the range of sp users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sp users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpUser> findAll(int start, int end,
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

		List<SpUser> list = (List<SpUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPUSER;

				if (pagination) {
					sql = sql.concat(SpUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SpUser>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SpUser>(list);
				}
				else {
					list = (List<SpUser>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the sp users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SpUser spUser : findAll()) {
			remove(spUser);
		}
	}

	/**
	 * Returns the number of sp users.
	 *
	 * @return the number of sp users
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

				Query q = session.createQuery(_SQL_COUNT_SPUSER);

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
	 * Initializes the sp user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.science.platform.model.SpUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SpUser>> listenersList = new ArrayList<ModelListener<SpUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SpUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SpUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPUSER = "SELECT spUser FROM SpUser spUser";
	private static final String _SQL_COUNT_SPUSER = "SELECT COUNT(spUser) FROM SpUser spUser";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SpUser exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SpUserPersistenceImpl.class);
	private static SpUser _nullSpUser = new SpUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SpUser> toCacheModel() {
				return _nullSpUserCacheModel;
			}
		};

	private static CacheModel<SpUser> _nullSpUserCacheModel = new CacheModel<SpUser>() {
			@Override
			public SpUser toEntityModel() {
				return _nullSpUser;
			}
		};
}