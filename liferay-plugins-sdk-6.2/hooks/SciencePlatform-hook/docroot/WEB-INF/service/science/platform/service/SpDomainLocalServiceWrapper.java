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

package science.platform.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SpDomainLocalService}.
 *
 * @author Jerry h. Seo
 * @see SpDomainLocalService
 * @generated
 */
public class SpDomainLocalServiceWrapper implements SpDomainLocalService,
	ServiceWrapper<SpDomainLocalService> {
	public SpDomainLocalServiceWrapper(
		SpDomainLocalService spDomainLocalService) {
		_spDomainLocalService = spDomainLocalService;
	}

	/**
	* Adds the sp domain to the database. Also notifies the appropriate model listeners.
	*
	* @param spDomain the sp domain
	* @return the sp domain that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpDomain addSpDomain(
		science.platform.model.SpDomain spDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.addSpDomain(spDomain);
	}

	/**
	* Creates a new sp domain with the primary key. Does not add the sp domain to the database.
	*
	* @param spDomainId the primary key for the new sp domain
	* @return the new sp domain
	*/
	@Override
	public science.platform.model.SpDomain createSpDomain(long spDomainId) {
		return _spDomainLocalService.createSpDomain(spDomainId);
	}

	/**
	* Deletes the sp domain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spDomainId the primary key of the sp domain
	* @return the sp domain that was removed
	* @throws PortalException if a sp domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpDomain deleteSpDomain(long spDomainId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.deleteSpDomain(spDomainId);
	}

	/**
	* Deletes the sp domain from the database. Also notifies the appropriate model listeners.
	*
	* @param spDomain the sp domain
	* @return the sp domain that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpDomain deleteSpDomain(
		science.platform.model.SpDomain spDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.deleteSpDomain(spDomain);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spDomainLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public science.platform.model.SpDomain fetchSpDomain(long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.fetchSpDomain(spDomainId);
	}

	/**
	* Returns the sp domain with the primary key.
	*
	* @param spDomainId the primary key of the sp domain
	* @return the sp domain
	* @throws PortalException if a sp domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpDomain getSpDomain(long spDomainId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.getSpDomain(spDomainId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<science.platform.model.SpDomain> getSpDomains(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.getSpDomains(start, end);
	}

	/**
	* Returns the number of sp domains.
	*
	* @return the number of sp domains
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSpDomainsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.getSpDomainsCount();
	}

	/**
	* Updates the sp domain in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spDomain the sp domain
	* @return the sp domain that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpDomain updateSpDomain(
		science.platform.model.SpDomain spDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.updateSpDomain(spDomain);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spDomainLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spDomainLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spDomainLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public science.platform.model.SpDomain createSpDomain(
		java.lang.String domainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.createSpDomain(domainCode);
	}

	@Override
	public void addUserDomain(long userId, long domainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_spDomainLocalService.addUserDomain(userId, domainId);
	}

	@Override
	public void addUserDomains(long userId, long[] domainIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_spDomainLocalService.addUserDomains(userId, domainIds);
	}

	@Override
	public java.util.List<science.platform.model.SpDomain> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.getAll();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getAllDomainsJSON(
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.getAllDomainsJSON(locale);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getDomainNamesByUserId(
		long userId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.getDomainNamesByUserId(userId, locale);
	}

	@Override
	public boolean isExist(java.lang.String domainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDomainLocalService.isExist(domainCode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SpDomainLocalService getWrappedSpDomainLocalService() {
		return _spDomainLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSpDomainLocalService(
		SpDomainLocalService spDomainLocalService) {
		_spDomainLocalService = spDomainLocalService;
	}

	@Override
	public SpDomainLocalService getWrappedService() {
		return _spDomainLocalService;
	}

	@Override
	public void setWrappedService(SpDomainLocalService spDomainLocalService) {
		_spDomainLocalService = spDomainLocalService;
	}

	private SpDomainLocalService _spDomainLocalService;
}