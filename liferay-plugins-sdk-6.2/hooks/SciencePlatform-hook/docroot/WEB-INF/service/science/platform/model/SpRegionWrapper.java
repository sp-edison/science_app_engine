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

package science.platform.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SpRegion}.
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpRegion
 * @generated
 */
public class SpRegionWrapper implements SpRegion, ModelWrapper<SpRegion> {
	public SpRegionWrapper(SpRegion spRegion) {
		_spRegion = spRegion;
	}

	@Override
	public Class<?> getModelClass() {
		return SpRegion.class;
	}

	@Override
	public String getModelClassName() {
		return SpRegion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spRegionId", getSpRegionId());
		attributes.put("spCountryId", getSpCountryId());
		attributes.put("spRegionCode", getSpRegionCode());
		attributes.put("spRegionName", getSpRegionName());
		attributes.put("spActive", getSpActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spRegionId = (Long)attributes.get("spRegionId");

		if (spRegionId != null) {
			setSpRegionId(spRegionId);
		}

		Long spCountryId = (Long)attributes.get("spCountryId");

		if (spCountryId != null) {
			setSpCountryId(spCountryId);
		}

		String spRegionCode = (String)attributes.get("spRegionCode");

		if (spRegionCode != null) {
			setSpRegionCode(spRegionCode);
		}

		String spRegionName = (String)attributes.get("spRegionName");

		if (spRegionName != null) {
			setSpRegionName(spRegionName);
		}

		Boolean spActive = (Boolean)attributes.get("spActive");

		if (spActive != null) {
			setSpActive(spActive);
		}
	}

	/**
	* Returns the primary key of this sp region.
	*
	* @return the primary key of this sp region
	*/
	@Override
	public long getPrimaryKey() {
		return _spRegion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sp region.
	*
	* @param primaryKey the primary key of this sp region
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spRegion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp region ID of this sp region.
	*
	* @return the sp region ID of this sp region
	*/
	@Override
	public long getSpRegionId() {
		return _spRegion.getSpRegionId();
	}

	/**
	* Sets the sp region ID of this sp region.
	*
	* @param spRegionId the sp region ID of this sp region
	*/
	@Override
	public void setSpRegionId(long spRegionId) {
		_spRegion.setSpRegionId(spRegionId);
	}

	/**
	* Returns the sp country ID of this sp region.
	*
	* @return the sp country ID of this sp region
	*/
	@Override
	public long getSpCountryId() {
		return _spRegion.getSpCountryId();
	}

	/**
	* Sets the sp country ID of this sp region.
	*
	* @param spCountryId the sp country ID of this sp region
	*/
	@Override
	public void setSpCountryId(long spCountryId) {
		_spRegion.setSpCountryId(spCountryId);
	}

	/**
	* Returns the sp region code of this sp region.
	*
	* @return the sp region code of this sp region
	*/
	@Override
	public java.lang.String getSpRegionCode() {
		return _spRegion.getSpRegionCode();
	}

	/**
	* Sets the sp region code of this sp region.
	*
	* @param spRegionCode the sp region code of this sp region
	*/
	@Override
	public void setSpRegionCode(java.lang.String spRegionCode) {
		_spRegion.setSpRegionCode(spRegionCode);
	}

	/**
	* Returns the sp region name of this sp region.
	*
	* @return the sp region name of this sp region
	*/
	@Override
	public java.lang.String getSpRegionName() {
		return _spRegion.getSpRegionName();
	}

	/**
	* Returns the localized sp region name of this sp region in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized sp region name of this sp region
	*/
	@Override
	public java.lang.String getSpRegionName(java.util.Locale locale) {
		return _spRegion.getSpRegionName(locale);
	}

	/**
	* Returns the localized sp region name of this sp region in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized sp region name of this sp region. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getSpRegionName(java.util.Locale locale,
		boolean useDefault) {
		return _spRegion.getSpRegionName(locale, useDefault);
	}

	/**
	* Returns the localized sp region name of this sp region in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized sp region name of this sp region
	*/
	@Override
	public java.lang.String getSpRegionName(java.lang.String languageId) {
		return _spRegion.getSpRegionName(languageId);
	}

	/**
	* Returns the localized sp region name of this sp region in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized sp region name of this sp region
	*/
	@Override
	public java.lang.String getSpRegionName(java.lang.String languageId,
		boolean useDefault) {
		return _spRegion.getSpRegionName(languageId, useDefault);
	}

	@Override
	public java.lang.String getSpRegionNameCurrentLanguageId() {
		return _spRegion.getSpRegionNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getSpRegionNameCurrentValue() {
		return _spRegion.getSpRegionNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized sp region names of this sp region.
	*
	* @return the locales and localized sp region names of this sp region
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getSpRegionNameMap() {
		return _spRegion.getSpRegionNameMap();
	}

	/**
	* Sets the sp region name of this sp region.
	*
	* @param spRegionName the sp region name of this sp region
	*/
	@Override
	public void setSpRegionName(java.lang.String spRegionName) {
		_spRegion.setSpRegionName(spRegionName);
	}

	/**
	* Sets the localized sp region name of this sp region in the language.
	*
	* @param spRegionName the localized sp region name of this sp region
	* @param locale the locale of the language
	*/
	@Override
	public void setSpRegionName(java.lang.String spRegionName,
		java.util.Locale locale) {
		_spRegion.setSpRegionName(spRegionName, locale);
	}

	/**
	* Sets the localized sp region name of this sp region in the language, and sets the default locale.
	*
	* @param spRegionName the localized sp region name of this sp region
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSpRegionName(java.lang.String spRegionName,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_spRegion.setSpRegionName(spRegionName, locale, defaultLocale);
	}

	@Override
	public void setSpRegionNameCurrentLanguageId(java.lang.String languageId) {
		_spRegion.setSpRegionNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized sp region names of this sp region from the map of locales and localized sp region names.
	*
	* @param spRegionNameMap the locales and localized sp region names of this sp region
	*/
	@Override
	public void setSpRegionNameMap(
		java.util.Map<java.util.Locale, java.lang.String> spRegionNameMap) {
		_spRegion.setSpRegionNameMap(spRegionNameMap);
	}

	/**
	* Sets the localized sp region names of this sp region from the map of locales and localized sp region names, and sets the default locale.
	*
	* @param spRegionNameMap the locales and localized sp region names of this sp region
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSpRegionNameMap(
		java.util.Map<java.util.Locale, java.lang.String> spRegionNameMap,
		java.util.Locale defaultLocale) {
		_spRegion.setSpRegionNameMap(spRegionNameMap, defaultLocale);
	}

	/**
	* Returns the sp active of this sp region.
	*
	* @return the sp active of this sp region
	*/
	@Override
	public boolean getSpActive() {
		return _spRegion.getSpActive();
	}

	/**
	* Returns <code>true</code> if this sp region is sp active.
	*
	* @return <code>true</code> if this sp region is sp active; <code>false</code> otherwise
	*/
	@Override
	public boolean isSpActive() {
		return _spRegion.isSpActive();
	}

	/**
	* Sets whether this sp region is sp active.
	*
	* @param spActive the sp active of this sp region
	*/
	@Override
	public void setSpActive(boolean spActive) {
		_spRegion.setSpActive(spActive);
	}

	@Override
	public boolean isNew() {
		return _spRegion.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spRegion.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spRegion.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spRegion.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spRegion.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spRegion.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spRegion.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spRegion.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spRegion.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spRegion.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spRegion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _spRegion.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _spRegion.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_spRegion.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_spRegion.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new SpRegionWrapper((SpRegion)_spRegion.clone());
	}

	@Override
	public int compareTo(science.platform.model.SpRegion spRegion) {
		return _spRegion.compareTo(spRegion);
	}

	@Override
	public int hashCode() {
		return _spRegion.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<science.platform.model.SpRegion> toCacheModel() {
		return _spRegion.toCacheModel();
	}

	@Override
	public science.platform.model.SpRegion toEscapedModel() {
		return new SpRegionWrapper(_spRegion.toEscapedModel());
	}

	@Override
	public science.platform.model.SpRegion toUnescapedModel() {
		return new SpRegionWrapper(_spRegion.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spRegion.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spRegion.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spRegion.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SpRegionWrapper)) {
			return false;
		}

		SpRegionWrapper spRegionWrapper = (SpRegionWrapper)obj;

		if (Validator.equals(_spRegion, spRegionWrapper._spRegion)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SpRegion getWrappedSpRegion() {
		return _spRegion;
	}

	@Override
	public SpRegion getWrappedModel() {
		return _spRegion;
	}

	@Override
	public void resetOriginalValues() {
		_spRegion.resetOriginalValues();
	}

	private SpRegion _spRegion;
}