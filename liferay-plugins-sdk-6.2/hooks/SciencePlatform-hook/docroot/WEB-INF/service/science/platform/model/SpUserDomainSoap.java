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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link science.platform.service.http.SpUserDomainServiceSoap}.
 *
 * @author Jerry h. Seo
 * @see science.platform.service.http.SpUserDomainServiceSoap
 * @generated
 */
public class SpUserDomainSoap implements Serializable {
	public static SpUserDomainSoap toSoapModel(SpUserDomain model) {
		SpUserDomainSoap soapModel = new SpUserDomainSoap();

		soapModel.setSpUserDomainId(model.getSpUserDomainId());
		soapModel.setSpDomainId(model.getSpDomainId());
		soapModel.setSpUserId(model.getSpUserId());
		soapModel.setApActive(model.getApActive());

		return soapModel;
	}

	public static SpUserDomainSoap[] toSoapModels(SpUserDomain[] models) {
		SpUserDomainSoap[] soapModels = new SpUserDomainSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SpUserDomainSoap[][] toSoapModels(SpUserDomain[][] models) {
		SpUserDomainSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SpUserDomainSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SpUserDomainSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SpUserDomainSoap[] toSoapModels(List<SpUserDomain> models) {
		List<SpUserDomainSoap> soapModels = new ArrayList<SpUserDomainSoap>(models.size());

		for (SpUserDomain model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SpUserDomainSoap[soapModels.size()]);
	}

	public SpUserDomainSoap() {
	}

	public long getPrimaryKey() {
		return _spUserDomainId;
	}

	public void setPrimaryKey(long pk) {
		setSpUserDomainId(pk);
	}

	public long getSpUserDomainId() {
		return _spUserDomainId;
	}

	public void setSpUserDomainId(long spUserDomainId) {
		_spUserDomainId = spUserDomainId;
	}

	public long getSpDomainId() {
		return _spDomainId;
	}

	public void setSpDomainId(long spDomainId) {
		_spDomainId = spDomainId;
	}

	public long getSpUserId() {
		return _spUserId;
	}

	public void setSpUserId(long spUserId) {
		_spUserId = spUserId;
	}

	public boolean getApActive() {
		return _apActive;
	}

	public boolean isApActive() {
		return _apActive;
	}

	public void setApActive(boolean apActive) {
		_apActive = apActive;
	}

	private long _spUserDomainId;
	private long _spDomainId;
	private long _spUserId;
	private boolean _apActive;
}