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

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import science.platform.service.ClpSerializer;
import science.platform.service.SpAffiliationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Jerry h. Seo
 */
public class SpAffiliationClp extends BaseModelImpl<SpAffiliation>
	implements SpAffiliation {
	public SpAffiliationClp() {
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
	public long getPrimaryKey() {
		return _spAffiliationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpAffiliationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spAffiliationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSpAffiliationId() {
		return _spAffiliationId;
	}

	@Override
	public void setSpAffiliationId(long spAffiliationId) {
		_spAffiliationId = spAffiliationId;

		if (_spAffiliationRemoteModel != null) {
			try {
				Class<?> clazz = _spAffiliationRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAffiliationId", long.class);

				method.invoke(_spAffiliationRemoteModel, spAffiliationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpRegionId() {
		return _spRegionId;
	}

	@Override
	public void setSpRegionId(long spRegionId) {
		_spRegionId = spRegionId;

		if (_spAffiliationRemoteModel != null) {
			try {
				Class<?> clazz = _spAffiliationRemoteModel.getClass();

				Method method = clazz.getMethod("setSpRegionId", long.class);

				method.invoke(_spAffiliationRemoteModel, spRegionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpCountryId() {
		return _spCountryId;
	}

	@Override
	public void setSpCountryId(long spCountryId) {
		_spCountryId = spCountryId;

		if (_spAffiliationRemoteModel != null) {
			try {
				Class<?> clazz = _spAffiliationRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCountryId", long.class);

				method.invoke(_spAffiliationRemoteModel, spCountryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpAffiliationCode() {
		return _spAffiliationCode;
	}

	@Override
	public void setSpAffiliationCode(String spAffiliationCode) {
		_spAffiliationCode = spAffiliationCode;

		if (_spAffiliationRemoteModel != null) {
			try {
				Class<?> clazz = _spAffiliationRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAffiliationCode",
						String.class);

				method.invoke(_spAffiliationRemoteModel, spAffiliationCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpAffiliationName() {
		return _spAffiliationName;
	}

	@Override
	public String getSpAffiliationName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSpAffiliationName(languageId);
	}

	@Override
	public String getSpAffiliationName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSpAffiliationName(languageId, useDefault);
	}

	@Override
	public String getSpAffiliationName(String languageId) {
		return LocalizationUtil.getLocalization(getSpAffiliationName(),
			languageId);
	}

	@Override
	public String getSpAffiliationName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getSpAffiliationName(),
			languageId, useDefault);
	}

	@Override
	public String getSpAffiliationNameCurrentLanguageId() {
		return _spAffiliationNameCurrentLanguageId;
	}

	@Override
	public String getSpAffiliationNameCurrentValue() {
		Locale locale = getLocale(_spAffiliationNameCurrentLanguageId);

		return getSpAffiliationName(locale);
	}

	@Override
	public Map<Locale, String> getSpAffiliationNameMap() {
		return LocalizationUtil.getLocalizationMap(getSpAffiliationName());
	}

	@Override
	public void setSpAffiliationName(String spAffiliationName) {
		_spAffiliationName = spAffiliationName;

		if (_spAffiliationRemoteModel != null) {
			try {
				Class<?> clazz = _spAffiliationRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAffiliationName",
						String.class);

				method.invoke(_spAffiliationRemoteModel, spAffiliationName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setSpAffiliationName(String spAffiliationName, Locale locale) {
		setSpAffiliationName(spAffiliationName, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setSpAffiliationName(String spAffiliationName, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(spAffiliationName)) {
			setSpAffiliationName(LocalizationUtil.updateLocalization(
					getSpAffiliationName(), "SpAffiliationName",
					spAffiliationName, languageId, defaultLanguageId));
		}
		else {
			setSpAffiliationName(LocalizationUtil.removeLocalization(
					getSpAffiliationName(), "SpAffiliationName", languageId));
		}
	}

	@Override
	public void setSpAffiliationNameCurrentLanguageId(String languageId) {
		_spAffiliationNameCurrentLanguageId = languageId;
	}

	@Override
	public void setSpAffiliationNameMap(
		Map<Locale, String> spAffiliationNameMap) {
		setSpAffiliationNameMap(spAffiliationNameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setSpAffiliationNameMap(
		Map<Locale, String> spAffiliationNameMap, Locale defaultLocale) {
		if (spAffiliationNameMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setSpAffiliationName(LocalizationUtil.updateLocalization(
					spAffiliationNameMap, getSpAffiliationName(),
					"SpAffiliationName", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public boolean getSpActive() {
		return _spActive;
	}

	@Override
	public boolean isSpActive() {
		return _spActive;
	}

	@Override
	public void setSpActive(boolean spActive) {
		_spActive = spActive;

		if (_spAffiliationRemoteModel != null) {
			try {
				Class<?> clazz = _spAffiliationRemoteModel.getClass();

				Method method = clazz.getMethod("setSpActive", boolean.class);

				method.invoke(_spAffiliationRemoteModel, spActive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSpAffiliationRemoteModel() {
		return _spAffiliationRemoteModel;
	}

	public void setSpAffiliationRemoteModel(
		BaseModel<?> spAffiliationRemoteModel) {
		_spAffiliationRemoteModel = spAffiliationRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _spAffiliationRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_spAffiliationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SpAffiliationLocalServiceUtil.addSpAffiliation(this);
		}
		else {
			SpAffiliationLocalServiceUtil.updateSpAffiliation(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> spAffiliationNameMap = getSpAffiliationNameMap();

		for (Map.Entry<Locale, String> entry : spAffiliationNameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getSpAffiliationName();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String spAffiliationName = getSpAffiliationName(defaultLocale);

		if (Validator.isNull(spAffiliationName)) {
			setSpAffiliationName(getSpAffiliationName(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setSpAffiliationName(getSpAffiliationName(defaultLocale),
				defaultLocale, defaultLocale);
		}
	}

	@Override
	public SpAffiliation toEscapedModel() {
		return (SpAffiliation)ProxyUtil.newProxyInstance(SpAffiliation.class.getClassLoader(),
			new Class[] { SpAffiliation.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SpAffiliationClp clone = new SpAffiliationClp();

		clone.setSpAffiliationId(getSpAffiliationId());
		clone.setSpRegionId(getSpRegionId());
		clone.setSpCountryId(getSpCountryId());
		clone.setSpAffiliationCode(getSpAffiliationCode());
		clone.setSpAffiliationName(getSpAffiliationName());
		clone.setSpActive(getSpActive());

		return clone;
	}

	@Override
	public int compareTo(SpAffiliation spAffiliation) {
		int value = 0;

		value = getSpAffiliationName()
					.compareTo(spAffiliation.getSpAffiliationName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SpAffiliationClp)) {
			return false;
		}

		SpAffiliationClp spAffiliation = (SpAffiliationClp)obj;

		long primaryKey = spAffiliation.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{spAffiliationId=");
		sb.append(getSpAffiliationId());
		sb.append(", spRegionId=");
		sb.append(getSpRegionId());
		sb.append(", spCountryId=");
		sb.append(getSpCountryId());
		sb.append(", spAffiliationCode=");
		sb.append(getSpAffiliationCode());
		sb.append(", spAffiliationName=");
		sb.append(getSpAffiliationName());
		sb.append(", spActive=");
		sb.append(getSpActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("science.platform.model.SpAffiliation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spAffiliationId</column-name><column-value><![CDATA[");
		sb.append(getSpAffiliationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spRegionId</column-name><column-value><![CDATA[");
		sb.append(getSpRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCountryId</column-name><column-value><![CDATA[");
		sb.append(getSpCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spAffiliationCode</column-name><column-value><![CDATA[");
		sb.append(getSpAffiliationCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spAffiliationName</column-name><column-value><![CDATA[");
		sb.append(getSpAffiliationName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spActive</column-name><column-value><![CDATA[");
		sb.append(getSpActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spAffiliationId;
	private long _spRegionId;
	private long _spCountryId;
	private String _spAffiliationCode;
	private String _spAffiliationName;
	private String _spAffiliationNameCurrentLanguageId;
	private boolean _spActive;
	private BaseModel<?> _spAffiliationRemoteModel;
	private Class<?> _clpSerializerClass = science.platform.service.ClpSerializer.class;
}