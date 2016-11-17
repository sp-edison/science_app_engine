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
 * Provides a wrapper for {@link SpAffiliationLocalService}.
 *
 * @author Jerry h. Seo
 * @see SpAffiliationLocalService
 * @generated
 */
public class SpAffiliationLocalServiceWrapper
	implements SpAffiliationLocalService,
		ServiceWrapper<SpAffiliationLocalService> {
	public SpAffiliationLocalServiceWrapper(
		SpAffiliationLocalService spAffiliationLocalService) {
		_spAffiliationLocalService = spAffiliationLocalService;
	}

	/**
	* Adds the sp affiliation to the database. Also notifies the appropriate model listeners.
	*
	* @param spAffiliation the sp affiliation
	* @return the sp affiliation that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpAffiliation addSpAffiliation(
		science.platform.model.SpAffiliation spAffiliation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.addSpAffiliation(spAffiliation);
	}

	/**
	* Creates a new sp affiliation with the primary key. Does not add the sp affiliation to the database.
	*
	* @param spAffiliationId the primary key for the new sp affiliation
	* @return the new sp affiliation
	*/
	@Override
	public science.platform.model.SpAffiliation createSpAffiliation(
		long spAffiliationId) {
		return _spAffiliationLocalService.createSpAffiliation(spAffiliationId);
	}

	/**
	* Deletes the sp affiliation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAffiliationId the primary key of the sp affiliation
	* @return the sp affiliation that was removed
	* @throws PortalException if a sp affiliation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpAffiliation deleteSpAffiliation(
		long spAffiliationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.deleteSpAffiliation(spAffiliationId);
	}

	/**
	* Deletes the sp affiliation from the database. Also notifies the appropriate model listeners.
	*
	* @param spAffiliation the sp affiliation
	* @return the sp affiliation that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpAffiliation deleteSpAffiliation(
		science.platform.model.SpAffiliation spAffiliation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.deleteSpAffiliation(spAffiliation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spAffiliationLocalService.dynamicQuery();
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
		return _spAffiliationLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _spAffiliationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spAffiliationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public science.platform.model.SpAffiliation fetchSpAffiliation(
		long spAffiliationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.fetchSpAffiliation(spAffiliationId);
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
	public science.platform.model.SpAffiliation getSpAffiliation(
		long spAffiliationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.getSpAffiliation(spAffiliationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<science.platform.model.SpAffiliation> getSpAffiliations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.getSpAffiliations(start, end);
	}

	/**
	* Returns the number of sp affiliations.
	*
	* @return the number of sp affiliations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSpAffiliationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.getSpAffiliationsCount();
	}

	/**
	* Updates the sp affiliation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spAffiliation the sp affiliation
	* @return the sp affiliation that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpAffiliation updateSpAffiliation(
		science.platform.model.SpAffiliation spAffiliation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.updateSpAffiliation(spAffiliation);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spAffiliationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spAffiliationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spAffiliationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public science.platform.model.SpAffiliation createSpAffiliation(
		long countryId, long regionId, java.lang.String affiliationCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.createSpAffiliation(countryId,
			regionId, affiliationCode);
	}

	@Override
	public java.util.List<science.platform.model.SpAffiliation> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.getAll();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getAllAffiliationsJSON(
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.getAllAffiliationsJSON(locale);
	}

	@Override
	public java.util.List<science.platform.model.SpAffiliation> getSpAffiliationListByCountryId(
		long countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.getSpAffiliationListByCountryId(countryId);
	}

	@Override
	public java.util.List<science.platform.model.SpAffiliation> getSpAffiliationListByRegionId(
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.getSpAffiliationListByRegionId(regionId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getAffiliationNamesByCountryId(
		long countryId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.getAffiliationNamesByCountryId(countryId,
			locale);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getAffiliationNamesByRegionId(
		long regionId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.getAffiliationNamesByRegionId(regionId,
			locale);
	}

	@Override
	public boolean isExist(long regionId, java.lang.String affiliationCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAffiliationLocalService.isExist(regionId, affiliationCode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SpAffiliationLocalService getWrappedSpAffiliationLocalService() {
		return _spAffiliationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSpAffiliationLocalService(
		SpAffiliationLocalService spAffiliationLocalService) {
		_spAffiliationLocalService = spAffiliationLocalService;
	}

	@Override
	public SpAffiliationLocalService getWrappedService() {
		return _spAffiliationLocalService;
	}

	@Override
	public void setWrappedService(
		SpAffiliationLocalService spAffiliationLocalService) {
		_spAffiliationLocalService = spAffiliationLocalService;
	}

	private SpAffiliationLocalService _spAffiliationLocalService;
}