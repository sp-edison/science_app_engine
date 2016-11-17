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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SpRegion. This utility wraps
 * {@link science.platform.service.impl.SpRegionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry h. Seo
 * @see SpRegionLocalService
 * @see science.platform.service.base.SpRegionLocalServiceBaseImpl
 * @see science.platform.service.impl.SpRegionLocalServiceImpl
 * @generated
 */
public class SpRegionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link science.platform.service.impl.SpRegionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the sp region to the database. Also notifies the appropriate model listeners.
	*
	* @param spRegion the sp region
	* @return the sp region that was added
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion addSpRegion(
		science.platform.model.SpRegion spRegion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSpRegion(spRegion);
	}

	/**
	* Creates a new sp region with the primary key. Does not add the sp region to the database.
	*
	* @param spRegionId the primary key for the new sp region
	* @return the new sp region
	*/
	public static science.platform.model.SpRegion createSpRegion(
		long spRegionId) {
		return getService().createSpRegion(spRegionId);
	}

	/**
	* Deletes the sp region with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spRegionId the primary key of the sp region
	* @return the sp region that was removed
	* @throws PortalException if a sp region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion deleteSpRegion(
		long spRegionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSpRegion(spRegionId);
	}

	/**
	* Deletes the sp region from the database. Also notifies the appropriate model listeners.
	*
	* @param spRegion the sp region
	* @return the sp region that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion deleteSpRegion(
		science.platform.model.SpRegion spRegion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSpRegion(spRegion);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static science.platform.model.SpRegion fetchSpRegion(long spRegionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSpRegion(spRegionId);
	}

	/**
	* Returns the sp region with the primary key.
	*
	* @param spRegionId the primary key of the sp region
	* @return the sp region
	* @throws PortalException if a sp region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion getSpRegion(long spRegionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSpRegion(spRegionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<science.platform.model.SpRegion> getSpRegions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSpRegions(start, end);
	}

	/**
	* Returns the number of sp regions.
	*
	* @return the number of sp regions
	* @throws SystemException if a system exception occurred
	*/
	public static int getSpRegionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSpRegionsCount();
	}

	/**
	* Updates the sp region in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spRegion the sp region
	* @return the sp region that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static science.platform.model.SpRegion updateSpRegion(
		science.platform.model.SpRegion spRegion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSpRegion(spRegion);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static science.platform.model.SpRegion createSpRegion(
		long countryId, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createSpRegion(countryId, regionCode);
	}

	public static science.platform.model.SpRegion fetchSpRegion(
		long countryId, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSpRegion(countryId, regionCode);
	}

	public static java.util.List<science.platform.model.SpRegion> fetchSpRegions(
		long countryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSpRegions(countryId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getRegionNames(
		long countryId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRegionNames(countryId, locale);
	}

	public static boolean isExist(long countryId, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().isExist(countryId, regionCode);
	}

	public static void clearService() {
		_service = null;
	}

	public static SpRegionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SpRegionLocalService.class.getName());

			if (invokableLocalService instanceof SpRegionLocalService) {
				_service = (SpRegionLocalService)invokableLocalService;
			}
			else {
				_service = new SpRegionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SpRegionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SpRegionLocalService service) {
	}

	private static SpRegionLocalService _service;
}