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
 * This class is used by SOAP remote services, specifically {@link science.platform.service.http.SpDomainServiceSoap}.
 *
 * @author Jerry h. Seo
 * @see science.platform.service.http.SpDomainServiceSoap
 * @generated
 */
public class SpDomainSoap implements Serializable {
	public static SpDomainSoap toSoapModel(SpDomain model) {
		SpDomainSoap soapModel = new SpDomainSoap();

		soapModel.setSpDomainId(model.getSpDomainId());
		soapModel.setSpDomainCode(model.getSpDomainCode());
		soapModel.setSpDomainName(model.getSpDomainName());
		soapModel.setSpActive(model.getSpActive());

		return soapModel;
	}

	public static SpDomainSoap[] toSoapModels(SpDomain[] models) {
		SpDomainSoap[] soapModels = new SpDomainSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SpDomainSoap[][] toSoapModels(SpDomain[][] models) {
		SpDomainSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SpDomainSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SpDomainSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SpDomainSoap[] toSoapModels(List<SpDomain> models) {
		List<SpDomainSoap> soapModels = new ArrayList<SpDomainSoap>(models.size());

		for (SpDomain model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SpDomainSoap[soapModels.size()]);
	}

	public SpDomainSoap() {
	}

	public long getPrimaryKey() {
		return _spDomainId;
	}

	public void setPrimaryKey(long pk) {
		setSpDomainId(pk);
	}

	public long getSpDomainId() {
		return _spDomainId;
	}

	public void setSpDomainId(long spDomainId) {
		_spDomainId = spDomainId;
	}

	public String getSpDomainCode() {
		return _spDomainCode;
	}

	public void setSpDomainCode(String spDomainCode) {
		_spDomainCode = spDomainCode;
	}

	public String getSpDomainName() {
		return _spDomainName;
	}

	public void setSpDomainName(String spDomainName) {
		_spDomainName = spDomainName;
	}

	public boolean getSpActive() {
		return _spActive;
	}

	public boolean isSpActive() {
		return _spActive;
	}

	public void setSpActive(boolean spActive) {
		_spActive = spActive;
	}

	private long _spDomainId;
	private String _spDomainCode;
	private String _spDomainName;
	private boolean _spActive;
}