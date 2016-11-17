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
 * This class is a wrapper for {@link SpAffiliation}.
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpAffiliation
 * @generated
 */
public class SpAffiliationWrapper implements SpAffiliation,
	ModelWrapper<SpAffiliation> {
	public SpAffiliationWrapper(SpAffiliation spAffiliation) {
		_spAffiliation = spAffiliation;
	}

	@Override
	public Class<?> getModelClass() {
		return SpAffiliation.class;
	}

	@Override
	public String getModelClassName() {
		return SpAffiliation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spAffiliationId", getSpAffiliationId());
		attributes.put("spRegionId", getSpRegionId());
		attributes.put("spCountryId", getSpCountryId());
		attributes.put("spAffiliationCode", getSpAffiliationCode());
		attributes.put("spAffiliationName", getSpAffiliationName());
		attributes.put("spActive", getSpActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spAffiliationId = (Long)attributes.get("spAffiliationId");

		if (spAffiliationId != null) {
			setSpAffiliationId(spAffiliationId);
		}

		Long spRegionId = (Long)attributes.get("spRegionId");

		if (spRegionId != null) {
			setSpRegionId(spRegionId);
		}

		Long spCountryId = (Long)attributes.get("spCountryId");

		if (spCountryId != null) {
			setSpCountryId(spCountryId);
		}

		String spAffiliationCode = (String)attributes.get("spAffiliationCode");

		if (spAffiliationCode != null) {
			setSpAffiliationCode(spAffiliationCode);
		}

		String spAffiliationName = (String)attributes.get("spAffiliationName");

		if (spAffiliationName != null) {
			setSpAffiliationName(spAffiliationName);
		}

		Boolean spActive = (Boolean)attributes.get("spActive");

		if (spActive != null) {
			setSpActive(spActive);
		}
	}

	/**
	* Returns the primary key of this sp affiliation.
	*
	* @return the primary key of this sp affiliation
	*/
	@Override
	public long getPrimaryKey() {
		return _spAffiliation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sp affiliation.
	*
	* @param primaryKey the primary key of this sp affiliation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spAffiliation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp affiliation ID of this sp affiliation.
	*
	* @return the sp affiliation ID of this sp affiliation
	*/
	@Override
	public long getSpAffiliationId() {
		return _spAffiliation.getSpAffiliationId();
	}

	/**
	* Sets the sp affiliation ID of this sp affiliation.
	*
	* @param spAffiliationId the sp affiliation ID of this sp affiliation
	*/
	@Override
	public void setSpAffiliationId(long spAffiliationId) {
		_spAffiliation.setSpAffiliationId(spAffiliationId);
	}

	/**
	* Returns the sp region ID of this sp affiliation.
	*
	* @return the sp region ID of this sp affiliation
	*/
	@Override
	public long getSpRegionId() {
		return _spAffiliation.getSpRegionId();
	}

	/**
	* Sets the sp region ID of this sp affiliation.
	*
	* @param spRegionId the sp region ID of this sp affiliation
	*/
	@Override
	public void setSpRegionId(long spRegionId) {
		_spAffiliation.setSpRegionId(spRegionId);
	}

	/**
	* Returns the sp country ID of this sp affiliation.
	*
	* @return the sp country ID of this sp affiliation
	*/
	@Override
	public long getSpCountryId() {
		return _spAffiliation.getSpCountryId();
	}

	/**
	* Sets the sp country ID of this sp affiliation.
	*
	* @param spCountryId the sp country ID of this sp affiliation
	*/
	@Override
	public void setSpCountryId(long spCountryId) {
		_spAffiliation.setSpCountryId(spCountryId);
	}

	/**
	* Returns the sp affiliation code of this sp affiliation.
	*
	* @return the sp affiliation code of this sp affiliation
	*/
	@Override
	public java.lang.String getSpAffiliationCode() {
		return _spAffiliation.getSpAffiliationCode();
	}

	/**
	* Sets the sp affiliation code of this sp affiliation.
	*
	* @param spAffiliationCode the sp affiliation code of this sp affiliation
	*/
	@Override
	public void setSpAffiliationCode(java.lang.String spAffiliationCode) {
		_spAffiliation.setSpAffiliationCode(spAffiliationCode);
	}

	/**
	* Returns the sp affiliation name of this sp affiliation.
	*
	* @return the sp affiliation name of this sp affiliation
	*/
	@Override
	public java.lang.String getSpAffiliationName() {
		return _spAffiliation.getSpAffiliationName();
	}

	/**
	* Returns the localized sp affiliation name of this sp affiliation in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized sp affiliation name of this sp affiliation
	*/
	@Override
	public java.lang.String getSpAffiliationName(java.util.Locale locale) {
		return _spAffiliation.getSpAffiliationName(locale);
	}

	/**
	* Returns the localized sp affiliation name of this sp affiliation in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized sp affiliation name of this sp affiliation. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getSpAffiliationName(java.util.Locale locale,
		boolean useDefault) {
		return _spAffiliation.getSpAffiliationName(locale, useDefault);
	}

	/**
	* Returns the localized sp affiliation name of this sp affiliation in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized sp affiliation name of this sp affiliation
	*/
	@Override
	public java.lang.String getSpAffiliationName(java.lang.String languageId) {
		return _spAffiliation.getSpAffiliationName(languageId);
	}

	/**
	* Returns the localized sp affiliation name of this sp affiliation in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized sp affiliation name of this sp affiliation
	*/
	@Override
	public java.lang.String getSpAffiliationName(java.lang.String languageId,
		boolean useDefault) {
		return _spAffiliation.getSpAffiliationName(languageId, useDefault);
	}

	@Override
	public java.lang.String getSpAffiliationNameCurrentLanguageId() {
		return _spAffiliation.getSpAffiliationNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getSpAffiliationNameCurrentValue() {
		return _spAffiliation.getSpAffiliationNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized sp affiliation names of this sp affiliation.
	*
	* @return the locales and localized sp affiliation names of this sp affiliation
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getSpAffiliationNameMap() {
		return _spAffiliation.getSpAffiliationNameMap();
	}

	/**
	* Sets the sp affiliation name of this sp affiliation.
	*
	* @param spAffiliationName the sp affiliation name of this sp affiliation
	*/
	@Override
	public void setSpAffiliationName(java.lang.String spAffiliationName) {
		_spAffiliation.setSpAffiliationName(spAffiliationName);
	}

	/**
	* Sets the localized sp affiliation name of this sp affiliation in the language.
	*
	* @param spAffiliationName the localized sp affiliation name of this sp affiliation
	* @param locale the locale of the language
	*/
	@Override
	public void setSpAffiliationName(java.lang.String spAffiliationName,
		java.util.Locale locale) {
		_spAffiliation.setSpAffiliationName(spAffiliationName, locale);
	}

	/**
	* Sets the localized sp affiliation name of this sp affiliation in the language, and sets the default locale.
	*
	* @param spAffiliationName the localized sp affiliation name of this sp affiliation
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSpAffiliationName(java.lang.String spAffiliationName,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_spAffiliation.setSpAffiliationName(spAffiliationName, locale,
			defaultLocale);
	}

	@Override
	public void setSpAffiliationNameCurrentLanguageId(
		java.lang.String languageId) {
		_spAffiliation.setSpAffiliationNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized sp affiliation names of this sp affiliation from the map of locales and localized sp affiliation names.
	*
	* @param spAffiliationNameMap the locales and localized sp affiliation names of this sp affiliation
	*/
	@Override
	public void setSpAffiliationNameMap(
		java.util.Map<java.util.Locale, java.lang.String> spAffiliationNameMap) {
		_spAffiliation.setSpAffiliationNameMap(spAffiliationNameMap);
	}

	/**
	* Sets the localized sp affiliation names of this sp affiliation from the map of locales and localized sp affiliation names, and sets the default locale.
	*
	* @param spAffiliationNameMap the locales and localized sp affiliation names of this sp affiliation
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSpAffiliationNameMap(
		java.util.Map<java.util.Locale, java.lang.String> spAffiliationNameMap,
		java.util.Locale defaultLocale) {
		_spAffiliation.setSpAffiliationNameMap(spAffiliationNameMap,
			defaultLocale);
	}

	/**
	* Returns the sp active of this sp affiliation.
	*
	* @return the sp active of this sp affiliation
	*/
	@Override
	public boolean getSpActive() {
		return _spAffiliation.getSpActive();
	}

	/**
	* Returns <code>true</code> if this sp affiliation is sp active.
	*
	* @return <code>true</code> if this sp affiliation is sp active; <code>false</code> otherwise
	*/
	@Override
	public boolean isSpActive() {
		return _spAffiliation.isSpActive();
	}

	/**
	* Sets whether this sp affiliation is sp active.
	*
	* @param spActive the sp active of this sp affiliation
	*/
	@Override
	public void setSpActive(boolean spActive) {
		_spAffiliation.setSpActive(spActive);
	}

	@Override
	public boolean isNew() {
		return _spAffiliation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spAffiliation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spAffiliation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spAffiliation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spAffiliation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spAffiliation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spAffiliation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spAffiliation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spAffiliation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spAffiliation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spAffiliation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _spAffiliation.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _spAffiliation.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_spAffiliation.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_spAffiliation.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new SpAffiliationWrapper((SpAffiliation)_spAffiliation.clone());
	}

	@Override
	public int compareTo(science.platform.model.SpAffiliation spAffiliation) {
		return _spAffiliation.compareTo(spAffiliation);
	}

	@Override
	public int hashCode() {
		return _spAffiliation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<science.platform.model.SpAffiliation> toCacheModel() {
		return _spAffiliation.toCacheModel();
	}

	@Override
	public science.platform.model.SpAffiliation toEscapedModel() {
		return new SpAffiliationWrapper(_spAffiliation.toEscapedModel());
	}

	@Override
	public science.platform.model.SpAffiliation toUnescapedModel() {
		return new SpAffiliationWrapper(_spAffiliation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spAffiliation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spAffiliation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spAffiliation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SpAffiliationWrapper)) {
			return false;
		}

		SpAffiliationWrapper spAffiliationWrapper = (SpAffiliationWrapper)obj;

		if (Validator.equals(_spAffiliation, spAffiliationWrapper._spAffiliation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SpAffiliation getWrappedSpAffiliation() {
		return _spAffiliation;
	}

	@Override
	public SpAffiliation getWrappedModel() {
		return _spAffiliation;
	}

	@Override
	public void resetOriginalValues() {
		_spAffiliation.resetOriginalValues();
	}

	private SpAffiliation _spAffiliation;
}