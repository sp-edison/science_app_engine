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

package science.platform.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import science.platform.model.SpAffiliation;

import science.platform.service.SpAffiliationLocalService;
import science.platform.service.persistence.SpAffiliationPersistence;
import science.platform.service.persistence.SpDomainPersistence;
import science.platform.service.persistence.SpRegionPersistence;
import science.platform.service.persistence.SpUserDomainPersistence;
import science.platform.service.persistence.SpUserPersistence;
import science.platform.service.persistence.SystemPropertiesPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the sp affiliation local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link science.platform.service.impl.SpAffiliationLocalServiceImpl}.
 * </p>
 *
 * @author Jerry h. Seo
 * @see science.platform.service.impl.SpAffiliationLocalServiceImpl
 * @see science.platform.service.SpAffiliationLocalServiceUtil
 * @generated
 */
public abstract class SpAffiliationLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SpAffiliationLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link science.platform.service.SpAffiliationLocalServiceUtil} to access the sp affiliation local service.
	 */

	/**
	 * Adds the sp affiliation to the database. Also notifies the appropriate model listeners.
	 *
	 * @param spAffiliation the sp affiliation
	 * @return the sp affiliation that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SpAffiliation addSpAffiliation(SpAffiliation spAffiliation)
		throws SystemException {
		spAffiliation.setNew(true);

		return spAffiliationPersistence.update(spAffiliation);
	}

	/**
	 * Creates a new sp affiliation with the primary key. Does not add the sp affiliation to the database.
	 *
	 * @param spAffiliationId the primary key for the new sp affiliation
	 * @return the new sp affiliation
	 */
	@Override
	public SpAffiliation createSpAffiliation(long spAffiliationId) {
		return spAffiliationPersistence.create(spAffiliationId);
	}

	/**
	 * Deletes the sp affiliation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spAffiliationId the primary key of the sp affiliation
	 * @return the sp affiliation that was removed
	 * @throws PortalException if a sp affiliation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SpAffiliation deleteSpAffiliation(long spAffiliationId)
		throws PortalException, SystemException {
		return spAffiliationPersistence.remove(spAffiliationId);
	}

	/**
	 * Deletes the sp affiliation from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spAffiliation the sp affiliation
	 * @return the sp affiliation that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SpAffiliation deleteSpAffiliation(SpAffiliation spAffiliation)
		throws SystemException {
		return spAffiliationPersistence.remove(spAffiliation);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SpAffiliation.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return spAffiliationPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpAffiliationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return spAffiliationPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpAffiliationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return spAffiliationPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return spAffiliationPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return spAffiliationPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public SpAffiliation fetchSpAffiliation(long spAffiliationId)
		throws SystemException {
		return spAffiliationPersistence.fetchByPrimaryKey(spAffiliationId);
	}

	/**
	 * Returns the sp affiliation with the primary key.
	 *
	 * @param spAffiliationId the primary key of the sp affiliation
	 * @return the sp affiliation
	 * @throws PortalException if a sp affiliation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpAffiliation getSpAffiliation(long spAffiliationId)
		throws PortalException, SystemException {
		return spAffiliationPersistence.findByPrimaryKey(spAffiliationId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return spAffiliationPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<SpAffiliation> getSpAffiliations(int start, int end)
		throws SystemException {
		return spAffiliationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of sp affiliations.
	 *
	 * @return the number of sp affiliations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSpAffiliationsCount() throws SystemException {
		return spAffiliationPersistence.countAll();
	}

	/**
	 * Updates the sp affiliation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param spAffiliation the sp affiliation
	 * @return the sp affiliation that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SpAffiliation updateSpAffiliation(SpAffiliation spAffiliation)
		throws SystemException {
		return spAffiliationPersistence.update(spAffiliation);
	}

	/**
	 * Returns the sp affiliation local service.
	 *
	 * @return the sp affiliation local service
	 */
	public science.platform.service.SpAffiliationLocalService getSpAffiliationLocalService() {
		return spAffiliationLocalService;
	}

	/**
	 * Sets the sp affiliation local service.
	 *
	 * @param spAffiliationLocalService the sp affiliation local service
	 */
	public void setSpAffiliationLocalService(
		science.platform.service.SpAffiliationLocalService spAffiliationLocalService) {
		this.spAffiliationLocalService = spAffiliationLocalService;
	}

	/**
	 * Returns the sp affiliation remote service.
	 *
	 * @return the sp affiliation remote service
	 */
	public science.platform.service.SpAffiliationService getSpAffiliationService() {
		return spAffiliationService;
	}

	/**
	 * Sets the sp affiliation remote service.
	 *
	 * @param spAffiliationService the sp affiliation remote service
	 */
	public void setSpAffiliationService(
		science.platform.service.SpAffiliationService spAffiliationService) {
		this.spAffiliationService = spAffiliationService;
	}

	/**
	 * Returns the sp affiliation persistence.
	 *
	 * @return the sp affiliation persistence
	 */
	public SpAffiliationPersistence getSpAffiliationPersistence() {
		return spAffiliationPersistence;
	}

	/**
	 * Sets the sp affiliation persistence.
	 *
	 * @param spAffiliationPersistence the sp affiliation persistence
	 */
	public void setSpAffiliationPersistence(
		SpAffiliationPersistence spAffiliationPersistence) {
		this.spAffiliationPersistence = spAffiliationPersistence;
	}

	/**
	 * Returns the sp domain local service.
	 *
	 * @return the sp domain local service
	 */
	public science.platform.service.SpDomainLocalService getSpDomainLocalService() {
		return spDomainLocalService;
	}

	/**
	 * Sets the sp domain local service.
	 *
	 * @param spDomainLocalService the sp domain local service
	 */
	public void setSpDomainLocalService(
		science.platform.service.SpDomainLocalService spDomainLocalService) {
		this.spDomainLocalService = spDomainLocalService;
	}

	/**
	 * Returns the sp domain remote service.
	 *
	 * @return the sp domain remote service
	 */
	public science.platform.service.SpDomainService getSpDomainService() {
		return spDomainService;
	}

	/**
	 * Sets the sp domain remote service.
	 *
	 * @param spDomainService the sp domain remote service
	 */
	public void setSpDomainService(
		science.platform.service.SpDomainService spDomainService) {
		this.spDomainService = spDomainService;
	}

	/**
	 * Returns the sp domain persistence.
	 *
	 * @return the sp domain persistence
	 */
	public SpDomainPersistence getSpDomainPersistence() {
		return spDomainPersistence;
	}

	/**
	 * Sets the sp domain persistence.
	 *
	 * @param spDomainPersistence the sp domain persistence
	 */
	public void setSpDomainPersistence(SpDomainPersistence spDomainPersistence) {
		this.spDomainPersistence = spDomainPersistence;
	}

	/**
	 * Returns the sp region local service.
	 *
	 * @return the sp region local service
	 */
	public science.platform.service.SpRegionLocalService getSpRegionLocalService() {
		return spRegionLocalService;
	}

	/**
	 * Sets the sp region local service.
	 *
	 * @param spRegionLocalService the sp region local service
	 */
	public void setSpRegionLocalService(
		science.platform.service.SpRegionLocalService spRegionLocalService) {
		this.spRegionLocalService = spRegionLocalService;
	}

	/**
	 * Returns the sp region remote service.
	 *
	 * @return the sp region remote service
	 */
	public science.platform.service.SpRegionService getSpRegionService() {
		return spRegionService;
	}

	/**
	 * Sets the sp region remote service.
	 *
	 * @param spRegionService the sp region remote service
	 */
	public void setSpRegionService(
		science.platform.service.SpRegionService spRegionService) {
		this.spRegionService = spRegionService;
	}

	/**
	 * Returns the sp region persistence.
	 *
	 * @return the sp region persistence
	 */
	public SpRegionPersistence getSpRegionPersistence() {
		return spRegionPersistence;
	}

	/**
	 * Sets the sp region persistence.
	 *
	 * @param spRegionPersistence the sp region persistence
	 */
	public void setSpRegionPersistence(SpRegionPersistence spRegionPersistence) {
		this.spRegionPersistence = spRegionPersistence;
	}

	/**
	 * Returns the sp user local service.
	 *
	 * @return the sp user local service
	 */
	public science.platform.service.SpUserLocalService getSpUserLocalService() {
		return spUserLocalService;
	}

	/**
	 * Sets the sp user local service.
	 *
	 * @param spUserLocalService the sp user local service
	 */
	public void setSpUserLocalService(
		science.platform.service.SpUserLocalService spUserLocalService) {
		this.spUserLocalService = spUserLocalService;
	}

	/**
	 * Returns the sp user remote service.
	 *
	 * @return the sp user remote service
	 */
	public science.platform.service.SpUserService getSpUserService() {
		return spUserService;
	}

	/**
	 * Sets the sp user remote service.
	 *
	 * @param spUserService the sp user remote service
	 */
	public void setSpUserService(
		science.platform.service.SpUserService spUserService) {
		this.spUserService = spUserService;
	}

	/**
	 * Returns the sp user persistence.
	 *
	 * @return the sp user persistence
	 */
	public SpUserPersistence getSpUserPersistence() {
		return spUserPersistence;
	}

	/**
	 * Sets the sp user persistence.
	 *
	 * @param spUserPersistence the sp user persistence
	 */
	public void setSpUserPersistence(SpUserPersistence spUserPersistence) {
		this.spUserPersistence = spUserPersistence;
	}

	/**
	 * Returns the sp user domain local service.
	 *
	 * @return the sp user domain local service
	 */
	public science.platform.service.SpUserDomainLocalService getSpUserDomainLocalService() {
		return spUserDomainLocalService;
	}

	/**
	 * Sets the sp user domain local service.
	 *
	 * @param spUserDomainLocalService the sp user domain local service
	 */
	public void setSpUserDomainLocalService(
		science.platform.service.SpUserDomainLocalService spUserDomainLocalService) {
		this.spUserDomainLocalService = spUserDomainLocalService;
	}

	/**
	 * Returns the sp user domain remote service.
	 *
	 * @return the sp user domain remote service
	 */
	public science.platform.service.SpUserDomainService getSpUserDomainService() {
		return spUserDomainService;
	}

	/**
	 * Sets the sp user domain remote service.
	 *
	 * @param spUserDomainService the sp user domain remote service
	 */
	public void setSpUserDomainService(
		science.platform.service.SpUserDomainService spUserDomainService) {
		this.spUserDomainService = spUserDomainService;
	}

	/**
	 * Returns the sp user domain persistence.
	 *
	 * @return the sp user domain persistence
	 */
	public SpUserDomainPersistence getSpUserDomainPersistence() {
		return spUserDomainPersistence;
	}

	/**
	 * Sets the sp user domain persistence.
	 *
	 * @param spUserDomainPersistence the sp user domain persistence
	 */
	public void setSpUserDomainPersistence(
		SpUserDomainPersistence spUserDomainPersistence) {
		this.spUserDomainPersistence = spUserDomainPersistence;
	}

	/**
	 * Returns the system properties local service.
	 *
	 * @return the system properties local service
	 */
	public science.platform.service.SystemPropertiesLocalService getSystemPropertiesLocalService() {
		return systemPropertiesLocalService;
	}

	/**
	 * Sets the system properties local service.
	 *
	 * @param systemPropertiesLocalService the system properties local service
	 */
	public void setSystemPropertiesLocalService(
		science.platform.service.SystemPropertiesLocalService systemPropertiesLocalService) {
		this.systemPropertiesLocalService = systemPropertiesLocalService;
	}

	/**
	 * Returns the system properties remote service.
	 *
	 * @return the system properties remote service
	 */
	public science.platform.service.SystemPropertiesService getSystemPropertiesService() {
		return systemPropertiesService;
	}

	/**
	 * Sets the system properties remote service.
	 *
	 * @param systemPropertiesService the system properties remote service
	 */
	public void setSystemPropertiesService(
		science.platform.service.SystemPropertiesService systemPropertiesService) {
		this.systemPropertiesService = systemPropertiesService;
	}

	/**
	 * Returns the system properties persistence.
	 *
	 * @return the system properties persistence
	 */
	public SystemPropertiesPersistence getSystemPropertiesPersistence() {
		return systemPropertiesPersistence;
	}

	/**
	 * Sets the system properties persistence.
	 *
	 * @param systemPropertiesPersistence the system properties persistence
	 */
	public void setSystemPropertiesPersistence(
		SystemPropertiesPersistence systemPropertiesPersistence) {
		this.systemPropertiesPersistence = systemPropertiesPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("science.platform.model.SpAffiliation",
			spAffiliationLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"science.platform.model.SpAffiliation");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return SpAffiliation.class;
	}

	protected String getModelClassName() {
		return SpAffiliation.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = spAffiliationPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = science.platform.service.SpAffiliationLocalService.class)
	protected science.platform.service.SpAffiliationLocalService spAffiliationLocalService;
	@BeanReference(type = science.platform.service.SpAffiliationService.class)
	protected science.platform.service.SpAffiliationService spAffiliationService;
	@BeanReference(type = SpAffiliationPersistence.class)
	protected SpAffiliationPersistence spAffiliationPersistence;
	@BeanReference(type = science.platform.service.SpDomainLocalService.class)
	protected science.platform.service.SpDomainLocalService spDomainLocalService;
	@BeanReference(type = science.platform.service.SpDomainService.class)
	protected science.platform.service.SpDomainService spDomainService;
	@BeanReference(type = SpDomainPersistence.class)
	protected SpDomainPersistence spDomainPersistence;
	@BeanReference(type = science.platform.service.SpRegionLocalService.class)
	protected science.platform.service.SpRegionLocalService spRegionLocalService;
	@BeanReference(type = science.platform.service.SpRegionService.class)
	protected science.platform.service.SpRegionService spRegionService;
	@BeanReference(type = SpRegionPersistence.class)
	protected SpRegionPersistence spRegionPersistence;
	@BeanReference(type = science.platform.service.SpUserLocalService.class)
	protected science.platform.service.SpUserLocalService spUserLocalService;
	@BeanReference(type = science.platform.service.SpUserService.class)
	protected science.platform.service.SpUserService spUserService;
	@BeanReference(type = SpUserPersistence.class)
	protected SpUserPersistence spUserPersistence;
	@BeanReference(type = science.platform.service.SpUserDomainLocalService.class)
	protected science.platform.service.SpUserDomainLocalService spUserDomainLocalService;
	@BeanReference(type = science.platform.service.SpUserDomainService.class)
	protected science.platform.service.SpUserDomainService spUserDomainService;
	@BeanReference(type = SpUserDomainPersistence.class)
	protected SpUserDomainPersistence spUserDomainPersistence;
	@BeanReference(type = science.platform.service.SystemPropertiesLocalService.class)
	protected science.platform.service.SystemPropertiesLocalService systemPropertiesLocalService;
	@BeanReference(type = science.platform.service.SystemPropertiesService.class)
	protected science.platform.service.SystemPropertiesService systemPropertiesService;
	@BeanReference(type = SystemPropertiesPersistence.class)
	protected SystemPropertiesPersistence systemPropertiesPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SpAffiliationLocalServiceClpInvoker _clpInvoker = new SpAffiliationLocalServiceClpInvoker();
}