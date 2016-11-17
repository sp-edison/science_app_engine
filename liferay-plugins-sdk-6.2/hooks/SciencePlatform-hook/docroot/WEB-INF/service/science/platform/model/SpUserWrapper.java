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
 * This class is a wrapper for {@link SpUser}.
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpUser
 * @generated
 */
public class SpUserWrapper implements SpUser, ModelWrapper<SpUser> {
	public SpUserWrapper(SpUser spUser) {
		_spUser = spUser;
	}

	@Override
	public Class<?> getModelClass() {
		return SpUser.class;
	}

	@Override
	public String getModelClassName() {
		return SpUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spUserId", getSpUserId());
		attributes.put("spCountryId", getSpCountryId());
		attributes.put("spRegionId", getSpRegionId());
		attributes.put("spAffiliationId", getSpAffiliationId());
		attributes.put("spUserFullName", getSpUserFullName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spUserId = (Long)attributes.get("spUserId");

		if (spUserId != null) {
			setSpUserId(spUserId);
		}

		Long spCountryId = (Long)attributes.get("spCountryId");

		if (spCountryId != null) {
			setSpCountryId(spCountryId);
		}

		Long spRegionId = (Long)attributes.get("spRegionId");

		if (spRegionId != null) {
			setSpRegionId(spRegionId);
		}

		Long spAffiliationId = (Long)attributes.get("spAffiliationId");

		if (spAffiliationId != null) {
			setSpAffiliationId(spAffiliationId);
		}

		String spUserFullName = (String)attributes.get("spUserFullName");

		if (spUserFullName != null) {
			setSpUserFullName(spUserFullName);
		}
	}

	/**
	* Returns the primary key of this sp user.
	*
	* @return the primary key of this sp user
	*/
	@Override
	public long getPrimaryKey() {
		return _spUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sp user.
	*
	* @param primaryKey the primary key of this sp user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp user ID of this sp user.
	*
	* @return the sp user ID of this sp user
	*/
	@Override
	public long getSpUserId() {
		return _spUser.getSpUserId();
	}

	/**
	* Sets the sp user ID of this sp user.
	*
	* @param spUserId the sp user ID of this sp user
	*/
	@Override
	public void setSpUserId(long spUserId) {
		_spUser.setSpUserId(spUserId);
	}

	/**
	* Returns the sp user uuid of this sp user.
	*
	* @return the sp user uuid of this sp user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getSpUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUser.getSpUserUuid();
	}

	/**
	* Sets the sp user uuid of this sp user.
	*
	* @param spUserUuid the sp user uuid of this sp user
	*/
	@Override
	public void setSpUserUuid(java.lang.String spUserUuid) {
		_spUser.setSpUserUuid(spUserUuid);
	}

	/**
	* Returns the sp country ID of this sp user.
	*
	* @return the sp country ID of this sp user
	*/
	@Override
	public long getSpCountryId() {
		return _spUser.getSpCountryId();
	}

	/**
	* Sets the sp country ID of this sp user.
	*
	* @param spCountryId the sp country ID of this sp user
	*/
	@Override
	public void setSpCountryId(long spCountryId) {
		_spUser.setSpCountryId(spCountryId);
	}

	/**
	* Returns the sp region ID of this sp user.
	*
	* @return the sp region ID of this sp user
	*/
	@Override
	public long getSpRegionId() {
		return _spUser.getSpRegionId();
	}

	/**
	* Sets the sp region ID of this sp user.
	*
	* @param spRegionId the sp region ID of this sp user
	*/
	@Override
	public void setSpRegionId(long spRegionId) {
		_spUser.setSpRegionId(spRegionId);
	}

	/**
	* Returns the sp affiliation ID of this sp user.
	*
	* @return the sp affiliation ID of this sp user
	*/
	@Override
	public long getSpAffiliationId() {
		return _spUser.getSpAffiliationId();
	}

	/**
	* Sets the sp affiliation ID of this sp user.
	*
	* @param spAffiliationId the sp affiliation ID of this sp user
	*/
	@Override
	public void setSpAffiliationId(long spAffiliationId) {
		_spUser.setSpAffiliationId(spAffiliationId);
	}

	/**
	* Returns the sp user full name of this sp user.
	*
	* @return the sp user full name of this sp user
	*/
	@Override
	public java.lang.String getSpUserFullName() {
		return _spUser.getSpUserFullName();
	}

	/**
	* Returns the localized sp user full name of this sp user in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized sp user full name of this sp user
	*/
	@Override
	public java.lang.String getSpUserFullName(java.util.Locale locale) {
		return _spUser.getSpUserFullName(locale);
	}

	/**
	* Returns the localized sp user full name of this sp user in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized sp user full name of this sp user. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getSpUserFullName(java.util.Locale locale,
		boolean useDefault) {
		return _spUser.getSpUserFullName(locale, useDefault);
	}

	/**
	* Returns the localized sp user full name of this sp user in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized sp user full name of this sp user
	*/
	@Override
	public java.lang.String getSpUserFullName(java.lang.String languageId) {
		return _spUser.getSpUserFullName(languageId);
	}

	/**
	* Returns the localized sp user full name of this sp user in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized sp user full name of this sp user
	*/
	@Override
	public java.lang.String getSpUserFullName(java.lang.String languageId,
		boolean useDefault) {
		return _spUser.getSpUserFullName(languageId, useDefault);
	}

	@Override
	public java.lang.String getSpUserFullNameCurrentLanguageId() {
		return _spUser.getSpUserFullNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getSpUserFullNameCurrentValue() {
		return _spUser.getSpUserFullNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized sp user full names of this sp user.
	*
	* @return the locales and localized sp user full names of this sp user
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getSpUserFullNameMap() {
		return _spUser.getSpUserFullNameMap();
	}

	/**
	* Sets the sp user full name of this sp user.
	*
	* @param spUserFullName the sp user full name of this sp user
	*/
	@Override
	public void setSpUserFullName(java.lang.String spUserFullName) {
		_spUser.setSpUserFullName(spUserFullName);
	}

	/**
	* Sets the localized sp user full name of this sp user in the language.
	*
	* @param spUserFullName the localized sp user full name of this sp user
	* @param locale the locale of the language
	*/
	@Override
	public void setSpUserFullName(java.lang.String spUserFullName,
		java.util.Locale locale) {
		_spUser.setSpUserFullName(spUserFullName, locale);
	}

	/**
	* Sets the localized sp user full name of this sp user in the language, and sets the default locale.
	*
	* @param spUserFullName the localized sp user full name of this sp user
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSpUserFullName(java.lang.String spUserFullName,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_spUser.setSpUserFullName(spUserFullName, locale, defaultLocale);
	}

	@Override
	public void setSpUserFullNameCurrentLanguageId(java.lang.String languageId) {
		_spUser.setSpUserFullNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized sp user full names of this sp user from the map of locales and localized sp user full names.
	*
	* @param spUserFullNameMap the locales and localized sp user full names of this sp user
	*/
	@Override
	public void setSpUserFullNameMap(
		java.util.Map<java.util.Locale, java.lang.String> spUserFullNameMap) {
		_spUser.setSpUserFullNameMap(spUserFullNameMap);
	}

	/**
	* Sets the localized sp user full names of this sp user from the map of locales and localized sp user full names, and sets the default locale.
	*
	* @param spUserFullNameMap the locales and localized sp user full names of this sp user
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSpUserFullNameMap(
		java.util.Map<java.util.Locale, java.lang.String> spUserFullNameMap,
		java.util.Locale defaultLocale) {
		_spUser.setSpUserFullNameMap(spUserFullNameMap, defaultLocale);
	}

	@Override
	public boolean isNew() {
		return _spUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _spUser.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _spUser.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_spUser.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_spUser.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new SpUserWrapper((SpUser)_spUser.clone());
	}

	@Override
	public int compareTo(science.platform.model.SpUser spUser) {
		return _spUser.compareTo(spUser);
	}

	@Override
	public int hashCode() {
		return _spUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<science.platform.model.SpUser> toCacheModel() {
		return _spUser.toCacheModel();
	}

	@Override
	public science.platform.model.SpUser toEscapedModel() {
		return new SpUserWrapper(_spUser.toEscapedModel());
	}

	@Override
	public science.platform.model.SpUser toUnescapedModel() {
		return new SpUserWrapper(_spUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SpUserWrapper)) {
			return false;
		}

		SpUserWrapper spUserWrapper = (SpUserWrapper)obj;

		if (Validator.equals(_spUser, spUserWrapper._spUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SpUser getWrappedSpUser() {
		return _spUser;
	}

	@Override
	public SpUser getWrappedModel() {
		return _spUser;
	}

	@Override
	public void resetOriginalValues() {
		_spUser.resetOriginalValues();
	}

	private SpUser _spUser;
}