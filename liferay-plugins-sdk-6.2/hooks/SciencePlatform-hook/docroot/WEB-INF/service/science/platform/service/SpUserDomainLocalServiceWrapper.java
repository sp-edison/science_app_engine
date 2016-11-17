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
 * Provides a wrapper for {@link SpUserDomainLocalService}.
 *
 * @author Jerry h. Seo
 * @see SpUserDomainLocalService
 * @generated
 */
public class SpUserDomainLocalServiceWrapper implements SpUserDomainLocalService,
	ServiceWrapper<SpUserDomainLocalService> {
	public SpUserDomainLocalServiceWrapper(
		SpUserDomainLocalService spUserDomainLocalService) {
		_spUserDomainLocalService = spUserDomainLocalService;
	}

	/**
	* Adds the sp user domain to the database. Also notifies the appropriate model listeners.
	*
	* @param spUserDomain the sp user domain
	* @return the sp user domain that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpUserDomain addSpUserDomain(
		science.platform.model.SpUserDomain spUserDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainLocalService.addSpUserDomain(spUserDomain);
	}

	/**
	* Creates a new sp user domain with the primary key. Does not add the sp user domain to the database.
	*
	* @param spUserDomainId the primary key for the new sp user domain
	* @return the new sp user domain
	*/
	@Override
	public science.platform.model.SpUserDomain createSpUserDomain(
		long spUserDomainId) {
		return _spUserDomainLocalService.createSpUserDomain(spUserDomainId);
	}

	/**
	* Deletes the sp user domain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spUserDomainId the primary key of the sp user domain
	* @return the sp user domain that was removed
	* @throws PortalException if a sp user domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpUserDomain deleteSpUserDomain(
		long spUserDomainId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainLocalService.deleteSpUserDomain(spUserDomainId);
	}

	/**
	* Deletes the sp user domain from the database. Also notifies the appropriate model listeners.
	*
	* @param spUserDomain the sp user domain
	* @return the sp user domain that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpUserDomain deleteSpUserDomain(
		science.platform.model.SpUserDomain spUserDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainLocalService.deleteSpUserDomain(spUserDomain);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spUserDomainLocalService.dynamicQuery();
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
		return _spUserDomainLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpUserDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spUserDomainLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpUserDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spUserDomainLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _spUserDomainLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spUserDomainLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public science.platform.model.SpUserDomain fetchSpUserDomain(
		long spUserDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainLocalService.fetchSpUserDomain(spUserDomainId);
	}

	/**
	* Returns the sp user domain with the primary key.
	*
	* @param spUserDomainId the primary key of the sp user domain
	* @return the sp user domain
	* @throws PortalException if a sp user domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpUserDomain getSpUserDomain(
		long spUserDomainId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainLocalService.getSpUserDomain(spUserDomainId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<science.platform.model.SpUserDomain> getSpUserDomains(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainLocalService.getSpUserDomains(start, end);
	}

	/**
	* Returns the number of sp user domains.
	*
	* @return the number of sp user domains
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSpUserDomainsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainLocalService.getSpUserDomainsCount();
	}

	/**
	* Updates the sp user domain in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spUserDomain the sp user domain
	* @return the sp user domain that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpUserDomain updateSpUserDomain(
		science.platform.model.SpUserDomain spUserDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainLocalService.updateSpUserDomain(spUserDomain);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spUserDomainLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spUserDomainLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spUserDomainLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public science.platform.model.SpUserDomain createSpUserDomain(
		long spUserId, long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainLocalService.createSpUserDomain(spUserId, spDomainId);
	}

	@Override
	public java.util.List<science.platform.model.SpUserDomain> createSpUserDomains(
		long spUserId, long[] spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainLocalService.createSpUserDomains(spUserId,
			spDomainId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getDomainNames(
		long userId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainLocalService.getDomainNames(userId, locale);
	}

	@Override
	public boolean isExist(long spUserId, long spDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomainLocalService.isExist(spUserId, spDomainId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SpUserDomainLocalService getWrappedSpUserDomainLocalService() {
		return _spUserDomainLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSpUserDomainLocalService(
		SpUserDomainLocalService spUserDomainLocalService) {
		_spUserDomainLocalService = spUserDomainLocalService;
	}

	@Override
	public SpUserDomainLocalService getWrappedService() {
		return _spUserDomainLocalService;
	}

	@Override
	public void setWrappedService(
		SpUserDomainLocalService spUserDomainLocalService) {
		_spUserDomainLocalService = spUserDomainLocalService;
	}

	private SpUserDomainLocalService _spUserDomainLocalService;
}