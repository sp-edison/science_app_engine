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
 * This class is a wrapper for {@link SpUserDomain}.
 * </p>
 *
 * @author Jerry h. Seo
 * @see SpUserDomain
 * @generated
 */
public class SpUserDomainWrapper implements SpUserDomain,
	ModelWrapper<SpUserDomain> {
	public SpUserDomainWrapper(SpUserDomain spUserDomain) {
		_spUserDomain = spUserDomain;
	}

	@Override
	public Class<?> getModelClass() {
		return SpUserDomain.class;
	}

	@Override
	public String getModelClassName() {
		return SpUserDomain.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spUserDomainId", getSpUserDomainId());
		attributes.put("spDomainId", getSpDomainId());
		attributes.put("spUserId", getSpUserId());
		attributes.put("apActive", getApActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spUserDomainId = (Long)attributes.get("spUserDomainId");

		if (spUserDomainId != null) {
			setSpUserDomainId(spUserDomainId);
		}

		Long spDomainId = (Long)attributes.get("spDomainId");

		if (spDomainId != null) {
			setSpDomainId(spDomainId);
		}

		Long spUserId = (Long)attributes.get("spUserId");

		if (spUserId != null) {
			setSpUserId(spUserId);
		}

		Boolean apActive = (Boolean)attributes.get("apActive");

		if (apActive != null) {
			setApActive(apActive);
		}
	}

	/**
	* Returns the primary key of this sp user domain.
	*
	* @return the primary key of this sp user domain
	*/
	@Override
	public long getPrimaryKey() {
		return _spUserDomain.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sp user domain.
	*
	* @param primaryKey the primary key of this sp user domain
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spUserDomain.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp user domain ID of this sp user domain.
	*
	* @return the sp user domain ID of this sp user domain
	*/
	@Override
	public long getSpUserDomainId() {
		return _spUserDomain.getSpUserDomainId();
	}

	/**
	* Sets the sp user domain ID of this sp user domain.
	*
	* @param spUserDomainId the sp user domain ID of this sp user domain
	*/
	@Override
	public void setSpUserDomainId(long spUserDomainId) {
		_spUserDomain.setSpUserDomainId(spUserDomainId);
	}

	/**
	* Returns the sp domain ID of this sp user domain.
	*
	* @return the sp domain ID of this sp user domain
	*/
	@Override
	public long getSpDomainId() {
		return _spUserDomain.getSpDomainId();
	}

	/**
	* Sets the sp domain ID of this sp user domain.
	*
	* @param spDomainId the sp domain ID of this sp user domain
	*/
	@Override
	public void setSpDomainId(long spDomainId) {
		_spUserDomain.setSpDomainId(spDomainId);
	}

	/**
	* Returns the sp user ID of this sp user domain.
	*
	* @return the sp user ID of this sp user domain
	*/
	@Override
	public long getSpUserId() {
		return _spUserDomain.getSpUserId();
	}

	/**
	* Sets the sp user ID of this sp user domain.
	*
	* @param spUserId the sp user ID of this sp user domain
	*/
	@Override
	public void setSpUserId(long spUserId) {
		_spUserDomain.setSpUserId(spUserId);
	}

	/**
	* Returns the sp user uuid of this sp user domain.
	*
	* @return the sp user uuid of this sp user domain
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getSpUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserDomain.getSpUserUuid();
	}

	/**
	* Sets the sp user uuid of this sp user domain.
	*
	* @param spUserUuid the sp user uuid of this sp user domain
	*/
	@Override
	public void setSpUserUuid(java.lang.String spUserUuid) {
		_spUserDomain.setSpUserUuid(spUserUuid);
	}

	/**
	* Returns the ap active of this sp user domain.
	*
	* @return the ap active of this sp user domain
	*/
	@Override
	public boolean getApActive() {
		return _spUserDomain.getApActive();
	}

	/**
	* Returns <code>true</code> if this sp user domain is ap active.
	*
	* @return <code>true</code> if this sp user domain is ap active; <code>false</code> otherwise
	*/
	@Override
	public boolean isApActive() {
		return _spUserDomain.isApActive();
	}

	/**
	* Sets whether this sp user domain is ap active.
	*
	* @param apActive the ap active of this sp user domain
	*/
	@Override
	public void setApActive(boolean apActive) {
		_spUserDomain.setApActive(apActive);
	}

	@Override
	public boolean isNew() {
		return _spUserDomain.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spUserDomain.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spUserDomain.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spUserDomain.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spUserDomain.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spUserDomain.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spUserDomain.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spUserDomain.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spUserDomain.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spUserDomain.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spUserDomain.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SpUserDomainWrapper((SpUserDomain)_spUserDomain.clone());
	}

	@Override
	public int compareTo(science.platform.model.SpUserDomain spUserDomain) {
		return _spUserDomain.compareTo(spUserDomain);
	}

	@Override
	public int hashCode() {
		return _spUserDomain.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<science.platform.model.SpUserDomain> toCacheModel() {
		return _spUserDomain.toCacheModel();
	}

	@Override
	public science.platform.model.SpUserDomain toEscapedModel() {
		return new SpUserDomainWrapper(_spUserDomain.toEscapedModel());
	}

	@Override
	public science.platform.model.SpUserDomain toUnescapedModel() {
		return new SpUserDomainWrapper(_spUserDomain.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spUserDomain.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spUserDomain.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spUserDomain.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SpUserDomainWrapper)) {
			return false;
		}

		SpUserDomainWrapper spUserDomainWrapper = (SpUserDomainWrapper)obj;

		if (Validator.equals(_spUserDomain, spUserDomainWrapper._spUserDomain)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SpUserDomain getWrappedSpUserDomain() {
		return _spUserDomain;
	}

	@Override
	public SpUserDomain getWrappedModel() {
		return _spUserDomain;
	}

	@Override
	public void resetOriginalValues() {
		_spUserDomain.resetOriginalValues();
	}

	private SpUserDomain _spUserDomain;
}