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
import com.liferay.portal.util.PortalUtil;

import science.platform.service.ClpSerializer;
import science.platform.service.SpUserLocalServiceUtil;

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
public class SpUserClp extends BaseModelImpl<SpUser> implements SpUser {
	public SpUserClp() {
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
	public long getPrimaryKey() {
		return _spUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSpUserId() {
		return _spUserId;
	}

	@Override
	public void setSpUserId(long spUserId) {
		_spUserId = spUserId;

		if (_spUserRemoteModel != null) {
			try {
				Class<?> clazz = _spUserRemoteModel.getClass();

				Method method = clazz.getMethod("setSpUserId", long.class);

				method.invoke(_spUserRemoteModel, spUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getSpUserId(), "uuid", _spUserUuid);
	}

	@Override
	public void setSpUserUuid(String spUserUuid) {
		_spUserUuid = spUserUuid;
	}

	@Override
	public long getSpCountryId() {
		return _spCountryId;
	}

	@Override
	public void setSpCountryId(long spCountryId) {
		_spCountryId = spCountryId;

		if (_spUserRemoteModel != null) {
			try {
				Class<?> clazz = _spUserRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCountryId", long.class);

				method.invoke(_spUserRemoteModel, spCountryId);
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

		if (_spUserRemoteModel != null) {
			try {
				Class<?> clazz = _spUserRemoteModel.getClass();

				Method method = clazz.getMethod("setSpRegionId", long.class);

				method.invoke(_spUserRemoteModel, spRegionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpAffiliationId() {
		return _spAffiliationId;
	}

	@Override
	public void setSpAffiliationId(long spAffiliationId) {
		_spAffiliationId = spAffiliationId;

		if (_spUserRemoteModel != null) {
			try {
				Class<?> clazz = _spUserRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAffiliationId", long.class);

				method.invoke(_spUserRemoteModel, spAffiliationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpUserFullName() {
		return _spUserFullName;
	}

	@Override
	public String getSpUserFullName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSpUserFullName(languageId);
	}

	@Override
	public String getSpUserFullName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSpUserFullName(languageId, useDefault);
	}

	@Override
	public String getSpUserFullName(String languageId) {
		return LocalizationUtil.getLocalization(getSpUserFullName(), languageId);
	}

	@Override
	public String getSpUserFullName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getSpUserFullName(),
			languageId, useDefault);
	}

	@Override
	public String getSpUserFullNameCurrentLanguageId() {
		return _spUserFullNameCurrentLanguageId;
	}

	@Override
	public String getSpUserFullNameCurrentValue() {
		Locale locale = getLocale(_spUserFullNameCurrentLanguageId);

		return getSpUserFullName(locale);
	}

	@Override
	public Map<Locale, String> getSpUserFullNameMap() {
		return LocalizationUtil.getLocalizationMap(getSpUserFullName());
	}

	@Override
	public void setSpUserFullName(String spUserFullName) {
		_spUserFullName = spUserFullName;

		if (_spUserRemoteModel != null) {
			try {
				Class<?> clazz = _spUserRemoteModel.getClass();

				Method method = clazz.getMethod("setSpUserFullName",
						String.class);

				method.invoke(_spUserRemoteModel, spUserFullName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setSpUserFullName(String spUserFullName, Locale locale) {
		setSpUserFullName(spUserFullName, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setSpUserFullName(String spUserFullName, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(spUserFullName)) {
			setSpUserFullName(LocalizationUtil.updateLocalization(
					getSpUserFullName(), "SpUserFullName", spUserFullName,
					languageId, defaultLanguageId));
		}
		else {
			setSpUserFullName(LocalizationUtil.removeLocalization(
					getSpUserFullName(), "SpUserFullName", languageId));
		}
	}

	@Override
	public void setSpUserFullNameCurrentLanguageId(String languageId) {
		_spUserFullNameCurrentLanguageId = languageId;
	}

	@Override
	public void setSpUserFullNameMap(Map<Locale, String> spUserFullNameMap) {
		setSpUserFullNameMap(spUserFullNameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setSpUserFullNameMap(Map<Locale, String> spUserFullNameMap,
		Locale defaultLocale) {
		if (spUserFullNameMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setSpUserFullName(LocalizationUtil.updateLocalization(
					spUserFullNameMap, getSpUserFullName(), "SpUserFullName",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	public BaseModel<?> getSpUserRemoteModel() {
		return _spUserRemoteModel;
	}

	public void setSpUserRemoteModel(BaseModel<?> spUserRemoteModel) {
		_spUserRemoteModel = spUserRemoteModel;
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

		Class<?> remoteModelClass = _spUserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SpUserLocalServiceUtil.addSpUser(this);
		}
		else {
			SpUserLocalServiceUtil.updateSpUser(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> spUserFullNameMap = getSpUserFullNameMap();

		for (Map.Entry<Locale, String> entry : spUserFullNameMap.entrySet()) {
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
		String xml = getSpUserFullName();

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

		String spUserFullName = getSpUserFullName(defaultLocale);

		if (Validator.isNull(spUserFullName)) {
			setSpUserFullName(getSpUserFullName(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setSpUserFullName(getSpUserFullName(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public SpUser toEscapedModel() {
		return (SpUser)ProxyUtil.newProxyInstance(SpUser.class.getClassLoader(),
			new Class[] { SpUser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SpUserClp clone = new SpUserClp();

		clone.setSpUserId(getSpUserId());
		clone.setSpCountryId(getSpCountryId());
		clone.setSpRegionId(getSpRegionId());
		clone.setSpAffiliationId(getSpAffiliationId());
		clone.setSpUserFullName(getSpUserFullName());

		return clone;
	}

	@Override
	public int compareTo(SpUser spUser) {
		long primaryKey = spUser.getPrimaryKey();

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

		if (!(obj instanceof SpUserClp)) {
			return false;
		}

		SpUserClp spUser = (SpUserClp)obj;

		long primaryKey = spUser.getPrimaryKey();

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

		sb.append("{spUserId=");
		sb.append(getSpUserId());
		sb.append(", spCountryId=");
		sb.append(getSpCountryId());
		sb.append(", spRegionId=");
		sb.append(getSpRegionId());
		sb.append(", spAffiliationId=");
		sb.append(getSpAffiliationId());
		sb.append(", spUserFullName=");
		sb.append(getSpUserFullName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("science.platform.model.SpUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spUserId</column-name><column-value><![CDATA[");
		sb.append(getSpUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCountryId</column-name><column-value><![CDATA[");
		sb.append(getSpCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spRegionId</column-name><column-value><![CDATA[");
		sb.append(getSpRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spAffiliationId</column-name><column-value><![CDATA[");
		sb.append(getSpAffiliationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spUserFullName</column-name><column-value><![CDATA[");
		sb.append(getSpUserFullName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spUserId;
	private String _spUserUuid;
	private long _spCountryId;
	private long _spRegionId;
	private long _spAffiliationId;
	private String _spUserFullName;
	private String _spUserFullNameCurrentLanguageId;
	private BaseModel<?> _spUserRemoteModel;
	private Class<?> _clpSerializerClass = science.platform.service.ClpSerializer.class;
}