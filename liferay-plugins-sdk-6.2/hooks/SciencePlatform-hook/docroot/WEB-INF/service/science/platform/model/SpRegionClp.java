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
import science.platform.service.SpRegionLocalServiceUtil;

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
public class SpRegionClp extends BaseModelImpl<SpRegion> implements SpRegion {
	public SpRegionClp() {
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
	public long getPrimaryKey() {
		return _spRegionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpRegionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spRegionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSpRegionId() {
		return _spRegionId;
	}

	@Override
	public void setSpRegionId(long spRegionId) {
		_spRegionId = spRegionId;

		if (_spRegionRemoteModel != null) {
			try {
				Class<?> clazz = _spRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setSpRegionId", long.class);

				method.invoke(_spRegionRemoteModel, spRegionId);
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

		if (_spRegionRemoteModel != null) {
			try {
				Class<?> clazz = _spRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCountryId", long.class);

				method.invoke(_spRegionRemoteModel, spCountryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpRegionCode() {
		return _spRegionCode;
	}

	@Override
	public void setSpRegionCode(String spRegionCode) {
		_spRegionCode = spRegionCode;

		if (_spRegionRemoteModel != null) {
			try {
				Class<?> clazz = _spRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setSpRegionCode", String.class);

				method.invoke(_spRegionRemoteModel, spRegionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpRegionName() {
		return _spRegionName;
	}

	@Override
	public String getSpRegionName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSpRegionName(languageId);
	}

	@Override
	public String getSpRegionName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSpRegionName(languageId, useDefault);
	}

	@Override
	public String getSpRegionName(String languageId) {
		return LocalizationUtil.getLocalization(getSpRegionName(), languageId);
	}

	@Override
	public String getSpRegionName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getSpRegionName(), languageId,
			useDefault);
	}

	@Override
	public String getSpRegionNameCurrentLanguageId() {
		return _spRegionNameCurrentLanguageId;
	}

	@Override
	public String getSpRegionNameCurrentValue() {
		Locale locale = getLocale(_spRegionNameCurrentLanguageId);

		return getSpRegionName(locale);
	}

	@Override
	public Map<Locale, String> getSpRegionNameMap() {
		return LocalizationUtil.getLocalizationMap(getSpRegionName());
	}

	@Override
	public void setSpRegionName(String spRegionName) {
		_spRegionName = spRegionName;

		if (_spRegionRemoteModel != null) {
			try {
				Class<?> clazz = _spRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setSpRegionName", String.class);

				method.invoke(_spRegionRemoteModel, spRegionName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setSpRegionName(String spRegionName, Locale locale) {
		setSpRegionName(spRegionName, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setSpRegionName(String spRegionName, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(spRegionName)) {
			setSpRegionName(LocalizationUtil.updateLocalization(
					getSpRegionName(), "SpRegionName", spRegionName,
					languageId, defaultLanguageId));
		}
		else {
			setSpRegionName(LocalizationUtil.removeLocalization(
					getSpRegionName(), "SpRegionName", languageId));
		}
	}

	@Override
	public void setSpRegionNameCurrentLanguageId(String languageId) {
		_spRegionNameCurrentLanguageId = languageId;
	}

	@Override
	public void setSpRegionNameMap(Map<Locale, String> spRegionNameMap) {
		setSpRegionNameMap(spRegionNameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setSpRegionNameMap(Map<Locale, String> spRegionNameMap,
		Locale defaultLocale) {
		if (spRegionNameMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setSpRegionName(LocalizationUtil.updateLocalization(
					spRegionNameMap, getSpRegionName(), "SpRegionName",
					LocaleUtil.toLanguageId(defaultLocale)));
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

		if (_spRegionRemoteModel != null) {
			try {
				Class<?> clazz = _spRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setSpActive", boolean.class);

				method.invoke(_spRegionRemoteModel, spActive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSpRegionRemoteModel() {
		return _spRegionRemoteModel;
	}

	public void setSpRegionRemoteModel(BaseModel<?> spRegionRemoteModel) {
		_spRegionRemoteModel = spRegionRemoteModel;
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

		Class<?> remoteModelClass = _spRegionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spRegionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SpRegionLocalServiceUtil.addSpRegion(this);
		}
		else {
			SpRegionLocalServiceUtil.updateSpRegion(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> spRegionNameMap = getSpRegionNameMap();

		for (Map.Entry<Locale, String> entry : spRegionNameMap.entrySet()) {
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
		String xml = getSpRegionName();

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

		String spRegionName = getSpRegionName(defaultLocale);

		if (Validator.isNull(spRegionName)) {
			setSpRegionName(getSpRegionName(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setSpRegionName(getSpRegionName(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public SpRegion toEscapedModel() {
		return (SpRegion)ProxyUtil.newProxyInstance(SpRegion.class.getClassLoader(),
			new Class[] { SpRegion.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SpRegionClp clone = new SpRegionClp();

		clone.setSpRegionId(getSpRegionId());
		clone.setSpCountryId(getSpCountryId());
		clone.setSpRegionCode(getSpRegionCode());
		clone.setSpRegionName(getSpRegionName());
		clone.setSpActive(getSpActive());

		return clone;
	}

	@Override
	public int compareTo(SpRegion spRegion) {
		long primaryKey = spRegion.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SpRegionClp)) {
			return false;
		}

		SpRegionClp spRegion = (SpRegionClp)obj;

		long primaryKey = spRegion.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{spRegionId=");
		sb.append(getSpRegionId());
		sb.append(", spCountryId=");
		sb.append(getSpCountryId());
		sb.append(", spRegionCode=");
		sb.append(getSpRegionCode());
		sb.append(", spRegionName=");
		sb.append(getSpRegionName());
		sb.append(", spActive=");
		sb.append(getSpActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("science.platform.model.SpRegion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spRegionId</column-name><column-value><![CDATA[");
		sb.append(getSpRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCountryId</column-name><column-value><![CDATA[");
		sb.append(getSpCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spRegionCode</column-name><column-value><![CDATA[");
		sb.append(getSpRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spRegionName</column-name><column-value><![CDATA[");
		sb.append(getSpRegionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spActive</column-name><column-value><![CDATA[");
		sb.append(getSpActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spRegionId;
	private long _spCountryId;
	private String _spRegionCode;
	private String _spRegionName;
	private String _spRegionNameCurrentLanguageId;
	private boolean _spActive;
	private BaseModel<?> _spRegionRemoteModel;
	private Class<?> _clpSerializerClass = science.platform.service.ClpSerializer.class;
}