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

package com.kisti.science.platform.app.model.impl;

import com.kisti.science.platform.app.model.CommonPackage;
import com.kisti.science.platform.app.model.CommonPackageModel;
import com.kisti.science.platform.app.model.CommonPackageSoap;
import com.kisti.science.platform.app.service.persistence.CommonPackagePK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CommonPackage service. Represents a row in the &quot;ScienceApp_CommonPackage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.kisti.science.platform.app.model.CommonPackageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommonPackageImpl}.
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonPackageImpl
 * @see com.kisti.science.platform.app.model.CommonPackage
 * @see com.kisti.science.platform.app.model.CommonPackageModel
 * @generated
 */
@JSON(strict = true)
public class CommonPackageModelImpl extends BaseModelImpl<CommonPackage>
	implements CommonPackageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a common package model instance should use the {@link com.kisti.science.platform.app.model.CommonPackage} interface instead.
	 */
	public static final String TABLE_NAME = "ScienceApp_CommonPackage";
	public static final Object[][] TABLE_COLUMNS = {
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "pkgName", Types.VARCHAR },
			{ "pkgVersion", Types.VARCHAR },
			{ "sysArch", Types.VARCHAR },
			{ "installMethod", Types.VARCHAR },
			{ "installPath", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ScienceApp_CommonPackage (groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,pkgName VARCHAR(75) not null,pkgVersion VARCHAR(75) not null,sysArch VARCHAR(75) null,installMethod VARCHAR(75) null,installPath VARCHAR(75) null,primary key (pkgName, pkgVersion))";
	public static final String TABLE_SQL_DROP = "drop table ScienceApp_CommonPackage";
	public static final String ORDER_BY_JPQL = " ORDER BY commonPackage.id.pkgName ASC, commonPackage.id.pkgVersion ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ScienceApp_CommonPackage.pkgName ASC, ScienceApp_CommonPackage.pkgVersion ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.kisti.science.platform.app.model.CommonPackage"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.kisti.science.platform.app.model.CommonPackage"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommonPackage toModel(CommonPackageSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommonPackage model = new CommonPackageImpl();

		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setPkgName(soapModel.getPkgName());
		model.setPkgVersion(soapModel.getPkgVersion());
		model.setSysArch(soapModel.getSysArch());
		model.setInstallMethod(soapModel.getInstallMethod());
		model.setInstallPath(soapModel.getInstallPath());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommonPackage> toModels(CommonPackageSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CommonPackage> models = new ArrayList<CommonPackage>(soapModels.length);

		for (CommonPackageSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.kisti.science.platform.app.model.CommonPackage"));

	public CommonPackageModelImpl() {
	}

	@Override
	public CommonPackagePK getPrimaryKey() {
		return new CommonPackagePK(_pkgName, _pkgVersion);
	}

	@Override
	public void setPrimaryKey(CommonPackagePK primaryKey) {
		setPkgName(primaryKey.pkgName);
		setPkgVersion(primaryKey.pkgVersion);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new CommonPackagePK(_pkgName, _pkgVersion);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((CommonPackagePK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return CommonPackage.class;
	}

	@Override
	public String getModelClassName() {
		return CommonPackage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("pkgName", getPkgName());
		attributes.put("pkgVersion", getPkgVersion());
		attributes.put("sysArch", getSysArch());
		attributes.put("installMethod", getInstallMethod());
		attributes.put("installPath", getInstallPath());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String pkgName = (String)attributes.get("pkgName");

		if (pkgName != null) {
			setPkgName(pkgName);
		}

		String pkgVersion = (String)attributes.get("pkgVersion");

		if (pkgVersion != null) {
			setPkgVersion(pkgVersion);
		}

		String sysArch = (String)attributes.get("sysArch");

		if (sysArch != null) {
			setSysArch(sysArch);
		}

		String installMethod = (String)attributes.get("installMethod");

		if (installMethod != null) {
			setInstallMethod(installMethod);
		}

		String installPath = (String)attributes.get("installPath");

		if (installPath != null) {
			setInstallPath(installPath);
		}
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getPkgName() {
		if (_pkgName == null) {
			return StringPool.BLANK;
		}
		else {
			return _pkgName;
		}
	}

	@Override
	public void setPkgName(String pkgName) {
		_pkgName = pkgName;
	}

	@JSON
	@Override
	public String getPkgVersion() {
		if (_pkgVersion == null) {
			return StringPool.BLANK;
		}
		else {
			return _pkgVersion;
		}
	}

	@Override
	public void setPkgVersion(String pkgVersion) {
		_pkgVersion = pkgVersion;
	}

	@JSON
	@Override
	public String getSysArch() {
		if (_sysArch == null) {
			return StringPool.BLANK;
		}
		else {
			return _sysArch;
		}
	}

	@Override
	public void setSysArch(String sysArch) {
		_sysArch = sysArch;
	}

	@JSON
	@Override
	public String getInstallMethod() {
		if (_installMethod == null) {
			return StringPool.BLANK;
		}
		else {
			return _installMethod;
		}
	}

	@Override
	public void setInstallMethod(String installMethod) {
		_installMethod = installMethod;
	}

	@JSON
	@Override
	public String getInstallPath() {
		if (_installPath == null) {
			return StringPool.BLANK;
		}
		else {
			return _installPath;
		}
	}

	@Override
	public void setInstallPath(String installPath) {
		_installPath = installPath;
	}

	@Override
	public CommonPackage toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CommonPackage)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommonPackageImpl commonPackageImpl = new CommonPackageImpl();

		commonPackageImpl.setGroupId(getGroupId());
		commonPackageImpl.setCompanyId(getCompanyId());
		commonPackageImpl.setUserId(getUserId());
		commonPackageImpl.setUserName(getUserName());
		commonPackageImpl.setCreateDate(getCreateDate());
		commonPackageImpl.setModifiedDate(getModifiedDate());
		commonPackageImpl.setPkgName(getPkgName());
		commonPackageImpl.setPkgVersion(getPkgVersion());
		commonPackageImpl.setSysArch(getSysArch());
		commonPackageImpl.setInstallMethod(getInstallMethod());
		commonPackageImpl.setInstallPath(getInstallPath());

		commonPackageImpl.resetOriginalValues();

		return commonPackageImpl;
	}

	@Override
	public int compareTo(CommonPackage commonPackage) {
		CommonPackagePK primaryKey = commonPackage.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommonPackage)) {
			return false;
		}

		CommonPackage commonPackage = (CommonPackage)obj;

		CommonPackagePK primaryKey = commonPackage.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<CommonPackage> toCacheModel() {
		CommonPackageCacheModel commonPackageCacheModel = new CommonPackageCacheModel();

		commonPackageCacheModel.groupId = getGroupId();

		commonPackageCacheModel.companyId = getCompanyId();

		commonPackageCacheModel.userId = getUserId();

		commonPackageCacheModel.userName = getUserName();

		String userName = commonPackageCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commonPackageCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commonPackageCacheModel.createDate = createDate.getTime();
		}
		else {
			commonPackageCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commonPackageCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commonPackageCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commonPackageCacheModel.pkgName = getPkgName();

		String pkgName = commonPackageCacheModel.pkgName;

		if ((pkgName != null) && (pkgName.length() == 0)) {
			commonPackageCacheModel.pkgName = null;
		}

		commonPackageCacheModel.pkgVersion = getPkgVersion();

		String pkgVersion = commonPackageCacheModel.pkgVersion;

		if ((pkgVersion != null) && (pkgVersion.length() == 0)) {
			commonPackageCacheModel.pkgVersion = null;
		}

		commonPackageCacheModel.sysArch = getSysArch();

		String sysArch = commonPackageCacheModel.sysArch;

		if ((sysArch != null) && (sysArch.length() == 0)) {
			commonPackageCacheModel.sysArch = null;
		}

		commonPackageCacheModel.installMethod = getInstallMethod();

		String installMethod = commonPackageCacheModel.installMethod;

		if ((installMethod != null) && (installMethod.length() == 0)) {
			commonPackageCacheModel.installMethod = null;
		}

		commonPackageCacheModel.installPath = getInstallPath();

		String installPath = commonPackageCacheModel.installPath;

		if ((installPath != null) && (installPath.length() == 0)) {
			commonPackageCacheModel.installPath = null;
		}

		return commonPackageCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", pkgName=");
		sb.append(getPkgName());
		sb.append(", pkgVersion=");
		sb.append(getPkgVersion());
		sb.append(", sysArch=");
		sb.append(getSysArch());
		sb.append(", installMethod=");
		sb.append(getInstallMethod());
		sb.append(", installPath=");
		sb.append(getInstallPath());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.kisti.science.platform.app.model.CommonPackage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pkgName</column-name><column-value><![CDATA[");
		sb.append(getPkgName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pkgVersion</column-name><column-value><![CDATA[");
		sb.append(getPkgVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sysArch</column-name><column-value><![CDATA[");
		sb.append(getSysArch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>installMethod</column-name><column-value><![CDATA[");
		sb.append(getInstallMethod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>installPath</column-name><column-value><![CDATA[");
		sb.append(getInstallPath());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CommonPackage.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CommonPackage.class
		};
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _pkgName;
	private String _pkgVersion;
	private String _sysArch;
	private String _installMethod;
	private String _installPath;
	private CommonPackage _escapedModel;
}