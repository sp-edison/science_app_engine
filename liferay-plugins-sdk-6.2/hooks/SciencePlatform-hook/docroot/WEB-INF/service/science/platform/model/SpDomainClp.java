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
import science.platform.service.SpDomainLocalServiceUtil;

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
public class SpDomainClp extends BaseModelImpl<SpDomain> implements SpDomain {
	public SpDomainClp() {
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
	public long getPrimaryKey() {
		return _spDomainId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpDomainId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spDomainId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSpDomainId() {
		return _spDomainId;
	}

	@Override
	public void setSpDomainId(long spDomainId) {
		_spDomainId = spDomainId;

		if (_spDomainRemoteModel != null) {
			try {
				Class<?> clazz = _spDomainRemoteModel.getClass();

				Method method = clazz.getMethod("setSpDomainId", long.class);

				method.invoke(_spDomainRemoteModel, spDomainId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpDomainCode() {
		return _spDomainCode;
	}

	@Override
	public void setSpDomainCode(String spDomainCode) {
		_spDomainCode = spDomainCode;

		if (_spDomainRemoteModel != null) {
			try {
				Class<?> clazz = _spDomainRemoteModel.getClass();

				Method method = clazz.getMethod("setSpDomainCode", String.class);

				method.invoke(_spDomainRemoteModel, spDomainCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpDomainName() {
		return _spDomainName;
	}

	@Override
	public String getSpDomainName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSpDomainName(languageId);
	}

	@Override
	public String getSpDomainName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSpDomainName(languageId, useDefault);
	}

	@Override
	public String getSpDomainName(String languageId) {
		return LocalizationUtil.getLocalization(getSpDomainName(), languageId);
	}

	@Override
	public String getSpDomainName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getSpDomainName(), languageId,
			useDefault);
	}

	@Override
	public String getSpDomainNameCurrentLanguageId() {
		return _spDomainNameCurrentLanguageId;
	}

	@Override
	public String getSpDomainNameCurrentValue() {
		Locale locale = getLocale(_spDomainNameCurrentLanguageId);

		return getSpDomainName(locale);
	}

	@Override
	public Map<Locale, String> getSpDomainNameMap() {
		return LocalizationUtil.getLocalizationMap(getSpDomainName());
	}

	@Override
	public void setSpDomainName(String spDomainName) {
		_spDomainName = spDomainName;

		if (_spDomainRemoteModel != null) {
			try {
				Class<?> clazz = _spDomainRemoteModel.getClass();

				Method method = clazz.getMethod("setSpDomainName", String.class);

				method.invoke(_spDomainRemoteModel, spDomainName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setSpDomainName(String spDomainName, Locale locale) {
		setSpDomainName(spDomainName, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setSpDomainName(String spDomainName, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(spDomainName)) {
			setSpDomainName(LocalizationUtil.updateLocalization(
					getSpDomainName(), "SpDomainName", spDomainName,
					languageId, defaultLanguageId));
		}
		else {
			setSpDomainName(LocalizationUtil.removeLocalization(
					getSpDomainName(), "SpDomainName", languageId));
		}
	}

	@Override
	public void setSpDomainNameCurrentLanguageId(String languageId) {
		_spDomainNameCurrentLanguageId = languageId;
	}

	@Override
	public void setSpDomainNameMap(Map<Locale, String> spDomainNameMap) {
		setSpDomainNameMap(spDomainNameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setSpDomainNameMap(Map<Locale, String> spDomainNameMap,
		Locale defaultLocale) {
		if (spDomainNameMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setSpDomainName(LocalizationUtil.updateLocalization(
					spDomainNameMap, getSpDomainName(), "SpDomainName",
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

		if (_spDomainRemoteModel != null) {
			try {
				Class<?> clazz = _spDomainRemoteModel.getClass();

				Method method = clazz.getMethod("setSpActive", boolean.class);

				method.invoke(_spDomainRemoteModel, spActive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSpDomainRemoteModel() {
		return _spDomainRemoteModel;
	}

	public void setSpDomainRemoteModel(BaseModel<?> spDomainRemoteModel) {
		_spDomainRemoteModel = spDomainRemoteModel;
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

		Class<?> remoteModelClass = _spDomainRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spDomainRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SpDomainLocalServiceUtil.addSpDomain(this);
		}
		else {
			SpDomainLocalServiceUtil.updateSpDomain(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> spDomainNameMap = getSpDomainNameMap();

		for (Map.Entry<Locale, String> entry : spDomainNameMap.entrySet()) {
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
		String xml = getSpDomainName();

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

		String spDomainName = getSpDomainName(defaultLocale);

		if (Validator.isNull(spDomainName)) {
			setSpDomainName(getSpDomainName(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setSpDomainName(getSpDomainName(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public SpDomain toEscapedModel() {
		return (SpDomain)ProxyUtil.newProxyInstance(SpDomain.class.getClassLoader(),
			new Class[] { SpDomain.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SpDomainClp clone = new SpDomainClp();

		clone.setSpDomainId(getSpDomainId());
		clone.setSpDomainCode(getSpDomainCode());
		clone.setSpDomainName(getSpDomainName());
		clone.setSpActive(getSpActive());

		return clone;
	}

	@Override
	public int compareTo(SpDomain spDomain) {
		long primaryKey = spDomain.getPrimaryKey();

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

		if (!(obj instanceof SpDomainClp)) {
			return false;
		}

		SpDomainClp spDomain = (SpDomainClp)obj;

		long primaryKey = spDomain.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{spDomainId=");
		sb.append(getSpDomainId());
		sb.append(", spDomainCode=");
		sb.append(getSpDomainCode());
		sb.append(", spDomainName=");
		sb.append(getSpDomainName());
		sb.append(", spActive=");
		sb.append(getSpActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("science.platform.model.SpDomain");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spDomainId</column-name><column-value><![CDATA[");
		sb.append(getSpDomainId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spDomainCode</column-name><column-value><![CDATA[");
		sb.append(getSpDomainCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spDomainName</column-name><column-value><![CDATA[");
		sb.append(getSpDomainName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spActive</column-name><column-value><![CDATA[");
		sb.append(getSpActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spDomainId;
	private String _spDomainCode;
	private String _spDomainName;
	private String _spDomainNameCurrentLanguageId;
	private boolean _spActive;
	private BaseModel<?> _spDomainRemoteModel;
	private Class<?> _clpSerializerClass = science.platform.service.ClpSerializer.class;
}