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
 * Provides a wrapper for {@link SpRegionLocalService}.
 *
 * @author Jerry h. Seo
 * @see SpRegionLocalService
 * @generated
 */
public class SpRegionLocalServiceWrapper implements SpRegionLocalService,
	ServiceWrapper<SpRegionLocalService> {
	public SpRegionLocalServiceWrapper(
		SpRegionLocalService spRegionLocalService) {
		_spRegionLocalService = spRegionLocalService;
	}

	/**
	* Adds the sp region to the database. Also notifies the appropriate model listeners.
	*
	* @param spRegion the sp region
	* @return the sp region that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpRegion addSpRegion(
		science.platform.model.SpRegion spRegion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionLocalService.addSpRegion(spRegion);
	}

	/**
	* Creates a new sp region with the primary key. Does not add the sp region to the database.
	*
	* @param spRegionId the primary key for the new sp region
	* @return the new sp region
	*/
	@Override
	public science.platform.model.SpRegion createSpRegion(long spRegionId) {
		return _spRegionLocalService.createSpRegion(spRegionId);
	}

	/**
	* Deletes the sp region with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spRegionId the primary key of the sp region
	* @return the sp region that was removed
	* @throws PortalException if a sp region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpRegion deleteSpRegion(long spRegionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spRegionLocalService.deleteSpRegion(spRegionId);
	}

	/**
	* Deletes the sp region from the database. Also notifies the appropriate model listeners.
	*
	* @param spRegion the sp region
	* @return the sp region that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpRegion deleteSpRegion(
		science.platform.model.SpRegion spRegion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionLocalService.deleteSpRegion(spRegion);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spRegionLocalService.dynamicQuery();
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
		return _spRegionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spRegionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link science.platform.model.impl.SpRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spRegionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _spRegionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spRegionLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public science.platform.model.SpRegion fetchSpRegion(long spRegionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionLocalService.fetchSpRegion(spRegionId);
	}

	/**
	* Returns the sp region with the primary key.
	*
	* @param spRegionId the primary key of the sp region
	* @return the sp region
	* @throws PortalException if a sp region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpRegion getSpRegion(long spRegionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spRegionLocalService.getSpRegion(spRegionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spRegionLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<science.platform.model.SpRegion> getSpRegions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionLocalService.getSpRegions(start, end);
	}

	/**
	* Returns the number of sp regions.
	*
	* @return the number of sp regions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSpRegionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionLocalService.getSpRegionsCount();
	}

	/**
	* Updates the sp region in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spRegion the sp region
	* @return the sp region that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public science.platform.model.SpRegion updateSpRegion(
		science.platform.model.SpRegion spRegion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionLocalService.updateSpRegion(spRegion);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spRegionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spRegionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spRegionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public science.platform.model.SpRegion createSpRegion(long countryId,
		java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionLocalService.createSpRegion(countryId, regionCode);
	}

	@Override
	public science.platform.model.SpRegion fetchSpRegion(long countryId,
		java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionLocalService.fetchSpRegion(countryId, regionCode);
	}

	@Override
	public java.util.List<science.platform.model.SpRegion> fetchSpRegions(
		long countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionLocalService.fetchSpRegions(countryId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getRegionNames(
		long countryId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionLocalService.getRegionNames(countryId, locale);
	}

	@Override
	public boolean isExist(long countryId, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRegionLocalService.isExist(countryId, regionCode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SpRegionLocalService getWrappedSpRegionLocalService() {
		return _spRegionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSpRegionLocalService(
		SpRegionLocalService spRegionLocalService) {
		_spRegionLocalService = spRegionLocalService;
	}

	@Override
	public SpRegionLocalService getWrappedService() {
		return _spRegionLocalService;
	}

	@Override
	public void setWrappedService(SpRegionLocalService spRegionLocalService) {
		_spRegionLocalService = spRegionLocalService;
	}

	private SpRegionLocalService _spRegionLocalService;
}