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
 * This class is a wrapper for {@link SpDomain}.
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpDomain
 * @generated
 */
public class SpDomainWrapper implements SpDomain, ModelWrapper<SpDomain> {
	public SpDomainWrapper(SpDomain spDomain) {
		_spDomain = spDomain;
	}

	@Override
	public Class<?> getModelClass() {
		return SpDomain.class;
	}

	@Override
	public String getModelClassName() {
		return SpDomain.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spDomainId", getSpDomainId());
		attributes.put("spDomainCode", getSpDomainCode());
		attributes.put("spDomainName", getSpDomainName());
		attributes.put("spActive", getSpActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spDomainId = (Long)attributes.get("spDomainId");

		if (spDomainId != null) {
			setSpDomainId(spDomainId);
		}

		String spDomainCode = (String)attributes.get("spDomainCode");

		if (spDomainCode != null) {
			setSpDomainCode(spDomainCode);
		}

		String spDomainName = (String)attributes.get("spDomainName");

		if (spDomainName != null) {
			setSpDomainName(spDomainName);
		}

		Boolean spActive = (Boolean)attributes.get("spActive");

		if (spActive != null) {
			setSpActive(spActive);
		}
	}

	/**
	* Returns the primary key of this sp domain.
	*
	* @return the primary key of this sp domain
	*/
	@Override
	public long getPrimaryKey() {
		return _spDomain.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sp domain.
	*
	* @param primaryKey the primary key of this sp domain
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spDomain.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp domain ID of this sp domain.
	*
	* @return the sp domain ID of this sp domain
	*/
	@Override
	public long getSpDomainId() {
		return _spDomain.getSpDomainId();
	}

	/**
	* Sets the sp domain ID of this sp domain.
	*
	* @param spDomainId the sp domain ID of this sp domain
	*/
	@Override
	public void setSpDomainId(long spDomainId) {
		_spDomain.setSpDomainId(spDomainId);
	}

	/**
	* Returns the sp domain code of this sp domain.
	*
	* @return the sp domain code of this sp domain
	*/
	@Override
	public java.lang.String getSpDomainCode() {
		return _spDomain.getSpDomainCode();
	}

	/**
	* Sets the sp domain code of this sp domain.
	*
	* @param spDomainCode the sp domain code of this sp domain
	*/
	@Override
	public void setSpDomainCode(java.lang.String spDomainCode) {
		_spDomain.setSpDomainCode(spDomainCode);
	}

	/**
	* Returns the sp domain name of this sp domain.
	*
	* @return the sp domain name of this sp domain
	*/
	@Override
	public java.lang.String getSpDomainName() {
		return _spDomain.getSpDomainName();
	}

	/**
	* Returns the localized sp domain name of this sp domain in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized sp domain name of this sp domain
	*/
	@Override
	public java.lang.String getSpDomainName(java.util.Locale locale) {
		return _spDomain.getSpDomainName(locale);
	}

	/**
	* Returns the localized sp domain name of this sp domain in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized sp domain name of this sp domain. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getSpDomainName(java.util.Locale locale,
		boolean useDefault) {
		return _spDomain.getSpDomainName(locale, useDefault);
	}

	/**
	* Returns the localized sp domain name of this sp domain in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized sp domain name of this sp domain
	*/
	@Override
	public java.lang.String getSpDomainName(java.lang.String languageId) {
		return _spDomain.getSpDomainName(languageId);
	}

	/**
	* Returns the localized sp domain name of this sp domain in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized sp domain name of this sp domain
	*/
	@Override
	public java.lang.String getSpDomainName(java.lang.String languageId,
		boolean useDefault) {
		return _spDomain.getSpDomainName(languageId, useDefault);
	}

	@Override
	public java.lang.String getSpDomainNameCurrentLanguageId() {
		return _spDomain.getSpDomainNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getSpDomainNameCurrentValue() {
		return _spDomain.getSpDomainNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized sp domain names of this sp domain.
	*
	* @return the locales and localized sp domain names of this sp domain
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getSpDomainNameMap() {
		return _spDomain.getSpDomainNameMap();
	}

	/**
	* Sets the sp domain name of this sp domain.
	*
	* @param spDomainName the sp domain name of this sp domain
	*/
	@Override
	public void setSpDomainName(java.lang.String spDomainName) {
		_spDomain.setSpDomainName(spDomainName);
	}

	/**
	* Sets the localized sp domain name of this sp domain in the language.
	*
	* @param spDomainName the localized sp domain name of this sp domain
	* @param locale the locale of the language
	*/
	@Override
	public void setSpDomainName(java.lang.String spDomainName,
		java.util.Locale locale) {
		_spDomain.setSpDomainName(spDomainName, locale);
	}

	/**
	* Sets the localized sp domain name of this sp domain in the language, and sets the default locale.
	*
	* @param spDomainName the localized sp domain name of this sp domain
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSpDomainName(java.lang.String spDomainName,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_spDomain.setSpDomainName(spDomainName, locale, defaultLocale);
	}

	@Override
	public void setSpDomainNameCurrentLanguageId(java.lang.String languageId) {
		_spDomain.setSpDomainNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized sp domain names of this sp domain from the map of locales and localized sp domain names.
	*
	* @param spDomainNameMap the locales and localized sp domain names of this sp domain
	*/
	@Override
	public void setSpDomainNameMap(
		java.util.Map<java.util.Locale, java.lang.String> spDomainNameMap) {
		_spDomain.setSpDomainNameMap(spDomainNameMap);
	}

	/**
	* Sets the localized sp domain names of this sp domain from the map of locales and localized sp domain names, and sets the default locale.
	*
	* @param spDomainNameMap the locales and localized sp domain names of this sp domain
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSpDomainNameMap(
		java.util.Map<java.util.Locale, java.lang.String> spDomainNameMap,
		java.util.Locale defaultLocale) {
		_spDomain.setSpDomainNameMap(spDomainNameMap, defaultLocale);
	}

	/**
	* Returns the sp active of this sp domain.
	*
	* @return the sp active of this sp domain
	*/
	@Override
	public boolean getSpActive() {
		return _spDomain.getSpActive();
	}

	/**
	* Returns <code>true</code> if this sp domain is sp active.
	*
	* @return <code>true</code> if this sp domain is sp active; <code>false</code> otherwise
	*/
	@Override
	public boolean isSpActive() {
		return _spDomain.isSpActive();
	}

	/**
	* Sets whether this sp domain is sp active.
	*
	* @param spActive the sp active of this sp domain
	*/
	@Override
	public void setSpActive(boolean spActive) {
		_spDomain.setSpActive(spActive);
	}

	@Override
	public boolean isNew() {
		return _spDomain.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spDomain.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spDomain.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spDomain.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spDomain.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spDomain.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spDomain.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spDomain.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spDomain.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spDomain.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spDomain.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _spDomain.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _spDomain.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_spDomain.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_spDomain.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new SpDomainWrapper((SpDomain)_spDomain.clone());
	}

	@Override
	public int compareTo(science.platform.model.SpDomain spDomain) {
		return _spDomain.compareTo(spDomain);
	}

	@Override
	public int hashCode() {
		return _spDomain.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<science.platform.model.SpDomain> toCacheModel() {
		return _spDomain.toCacheModel();
	}

	@Override
	public science.platform.model.SpDomain toEscapedModel() {
		return new SpDomainWrapper(_spDomain.toEscapedModel());
	}

	@Override
	public science.platform.model.SpDomain toUnescapedModel() {
		return new SpDomainWrapper(_spDomain.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spDomain.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spDomain.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spDomain.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SpDomainWrapper)) {
			return false;
		}

		SpDomainWrapper spDomainWrapper = (SpDomainWrapper)obj;

		if (Validator.equals(_spDomain, spDomainWrapper._spDomain)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SpDomain getWrappedSpDomain() {
		return _spDomain;
	}

	@Override
	public SpDomain getWrappedModel() {
		return _spDomain;
	}

	@Override
	public void resetOriginalValues() {
		_spDomain.resetOriginalValues();
	}

	private SpDomain _spDomain;
}