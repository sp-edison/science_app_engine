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

import com.kisti.science.platform.app.model.CommonLibrary;
import com.kisti.science.platform.app.model.CommonLibraryModel;
import com.kisti.science.platform.app.model.CommonLibrarySoap;
import com.kisti.science.platform.app.service.persistence.CommonLibraryPK;

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
 * The base model implementation for the CommonLibrary service. Represents a row in the &quot;ScienceApp_CommonLibrary&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.kisti.science.platform.app.model.CommonLibraryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommonLibraryImpl}.
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonLibraryImpl
 * @see com.kisti.science.platform.app.model.CommonLibrary
 * @see com.kisti.science.platform.app.model.CommonLibraryModel
 * @generated
 */
@JSON(strict = true)
public class CommonLibraryModelImpl extends BaseModelImpl<CommonLibrary>
	implements CommonLibraryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a common library model instance should use the {@link com.kisti.science.platform.app.model.CommonLibrary} interface instead.
	 */
	public static final String TABLE_NAME = "ScienceApp_CommonLibrary";
	public static final Object[][] TABLE_COLUMNS = {
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "libName", Types.VARCHAR },
			{ "cLibVer", Types.VARCHAR },
			{ "sysArch", Types.VARCHAR },
			{ "kernelVer", Types.VARCHAR },
			{ "libPath", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ScienceApp_CommonLibrary (groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,libName VARCHAR(75) not null,cLibVer VARCHAR(75) null,sysArch VARCHAR(75) null,kernelVer VARCHAR(75) null,libPath VARCHAR(75) not null,primary key (libName, libPath))";
	public static final String TABLE_SQL_DROP = "drop table ScienceApp_CommonLibrary";
	public static final String ORDER_BY_JPQL = " ORDER BY commonLibrary.id.libName ASC, commonLibrary.id.libPath ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ScienceApp_CommonLibrary.libName ASC, ScienceApp_CommonLibrary.libPath ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.kisti.science.platform.app.model.CommonLibrary"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.kisti.science.platform.app.model.CommonLibrary"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommonLibrary toModel(CommonLibrarySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommonLibrary model = new CommonLibraryImpl();

		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setLibName(soapModel.getLibName());
		model.setCLibVer(soapModel.getCLibVer());
		model.setSysArch(soapModel.getSysArch());
		model.setKernelVer(soapModel.getKernelVer());
		model.setLibPath(soapModel.getLibPath());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommonLibrary> toModels(CommonLibrarySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CommonLibrary> models = new ArrayList<CommonLibrary>(soapModels.length);

		for (CommonLibrarySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.kisti.science.platform.app.model.CommonLibrary"));

	public CommonLibraryModelImpl() {
	}

	@Override
	public CommonLibraryPK getPrimaryKey() {
		return new CommonLibraryPK(_libName, _libPath);
	}

	@Override
	public void setPrimaryKey(CommonLibraryPK primaryKey) {
		setLibName(primaryKey.libName);
		setLibPath(primaryKey.libPath);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new CommonLibraryPK(_libName, _libPath);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((CommonLibraryPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return CommonLibrary.class;
	}

	@Override
	public String getModelClassName() {
		return CommonLibrary.class.getName();
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
		attributes.put("libName", getLibName());
		attributes.put("cLibVer", getCLibVer());
		attributes.put("sysArch", getSysArch());
		attributes.put("kernelVer", getKernelVer());
		attributes.put("libPath", getLibPath());

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

		String libName = (String)attributes.get("libName");

		if (libName != null) {
			setLibName(libName);
		}

		String cLibVer = (String)attributes.get("cLibVer");

		if (cLibVer != null) {
			setCLibVer(cLibVer);
		}

		String sysArch = (String)attributes.get("sysArch");

		if (sysArch != null) {
			setSysArch(sysArch);
		}

		String kernelVer = (String)attributes.get("kernelVer");

		if (kernelVer != null) {
			setKernelVer(kernelVer);
		}

		String libPath = (String)attributes.get("libPath");

		if (libPath != null) {
			setLibPath(libPath);
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
	public String getLibName() {
		if (_libName == null) {
			return StringPool.BLANK;
		}
		else {
			return _libName;
		}
	}

	@Override
	public void setLibName(String libName) {
		_libName = libName;
	}

	@JSON
	@Override
	public String getCLibVer() {
		if (_cLibVer == null) {
			return StringPool.BLANK;
		}
		else {
			return _cLibVer;
		}
	}

	@Override
	public void setCLibVer(String cLibVer) {
		_cLibVer = cLibVer;
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
	public String getKernelVer() {
		if (_kernelVer == null) {
			return StringPool.BLANK;
		}
		else {
			return _kernelVer;
		}
	}

	@Override
	public void setKernelVer(String kernelVer) {
		_kernelVer = kernelVer;
	}

	@JSON
	@Override
	public String getLibPath() {
		if (_libPath == null) {
			return StringPool.BLANK;
		}
		else {
			return _libPath;
		}
	}

	@Override
	public void setLibPath(String libPath) {
		_libPath = libPath;
	}

	@Override
	public CommonLibrary toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CommonLibrary)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommonLibraryImpl commonLibraryImpl = new CommonLibraryImpl();

		commonLibraryImpl.setGroupId(getGroupId());
		commonLibraryImpl.setCompanyId(getCompanyId());
		commonLibraryImpl.setUserId(getUserId());
		commonLibraryImpl.setUserName(getUserName());
		commonLibraryImpl.setCreateDate(getCreateDate());
		commonLibraryImpl.setModifiedDate(getModifiedDate());
		commonLibraryImpl.setLibName(getLibName());
		commonLibraryImpl.setCLibVer(getCLibVer());
		commonLibraryImpl.setSysArch(getSysArch());
		commonLibraryImpl.setKernelVer(getKernelVer());
		commonLibraryImpl.setLibPath(getLibPath());

		commonLibraryImpl.resetOriginalValues();

		return commonLibraryImpl;
	}

	@Override
	public int compareTo(CommonLibrary commonLibrary) {
		CommonLibraryPK primaryKey = commonLibrary.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommonLibrary)) {
			return false;
		}

		CommonLibrary commonLibrary = (CommonLibrary)obj;

		CommonLibraryPK primaryKey = commonLibrary.getPrimaryKey();

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
	public CacheModel<CommonLibrary> toCacheModel() {
		CommonLibraryCacheModel commonLibraryCacheModel = new CommonLibraryCacheModel();

		commonLibraryCacheModel.groupId = getGroupId();

		commonLibraryCacheModel.companyId = getCompanyId();

		commonLibraryCacheModel.userId = getUserId();

		commonLibraryCacheModel.userName = getUserName();

		String userName = commonLibraryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commonLibraryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commonLibraryCacheModel.createDate = createDate.getTime();
		}
		else {
			commonLibraryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commonLibraryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commonLibraryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commonLibraryCacheModel.libName = getLibName();

		String libName = commonLibraryCacheModel.libName;

		if ((libName != null) && (libName.length() == 0)) {
			commonLibraryCacheModel.libName = null;
		}

		commonLibraryCacheModel.cLibVer = getCLibVer();

		String cLibVer = commonLibraryCacheModel.cLibVer;

		if ((cLibVer != null) && (cLibVer.length() == 0)) {
			commonLibraryCacheModel.cLibVer = null;
		}

		commonLibraryCacheModel.sysArch = getSysArch();

		String sysArch = commonLibraryCacheModel.sysArch;

		if ((sysArch != null) && (sysArch.length() == 0)) {
			commonLibraryCacheModel.sysArch = null;
		}

		commonLibraryCacheModel.kernelVer = getKernelVer();

		String kernelVer = commonLibraryCacheModel.kernelVer;

		if ((kernelVer != null) && (kernelVer.length() == 0)) {
			commonLibraryCacheModel.kernelVer = null;
		}

		commonLibraryCacheModel.libPath = getLibPath();

		String libPath = commonLibraryCacheModel.libPath;

		if ((libPath != null) && (libPath.length() == 0)) {
			commonLibraryCacheModel.libPath = null;
		}

		return commonLibraryCacheModel;
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
		sb.append(", libName=");
		sb.append(getLibName());
		sb.append(", cLibVer=");
		sb.append(getCLibVer());
		sb.append(", sysArch=");
		sb.append(getSysArch());
		sb.append(", kernelVer=");
		sb.append(getKernelVer());
		sb.append(", libPath=");
		sb.append(getLibPath());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.kisti.science.platform.app.model.CommonLibrary");
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
			"<column><column-name>libName</column-name><column-value><![CDATA[");
		sb.append(getLibName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cLibVer</column-name><column-value><![CDATA[");
		sb.append(getCLibVer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sysArch</column-name><column-value><![CDATA[");
		sb.append(getSysArch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kernelVer</column-name><column-value><![CDATA[");
		sb.append(getKernelVer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libPath</column-name><column-value><![CDATA[");
		sb.append(getLibPath());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CommonLibrary.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CommonLibrary.class
		};
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _libName;
	private String _cLibVer;
	private String _sysArch;
	private String _kernelVer;
	private String _libPath;
	private CommonLibrary _escapedModel;
}