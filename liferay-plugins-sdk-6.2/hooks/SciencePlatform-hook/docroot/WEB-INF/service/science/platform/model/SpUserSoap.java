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
 * This class is used by SOAP remote services, specifically {@link science.platform.service.http.SpUserServiceSoap}.
 *
 * @author Jerry h. Seo
 * @see science.platform.service.http.SpUserServiceSoap
 * @generated
 */
public class SpUserSoap implements Serializable {
	public static SpUserSoap toSoapModel(SpUser model) {
		SpUserSoap soapModel = new SpUserSoap();

		soapModel.setSpUserId(model.getSpUserId());
		soapModel.setSpCountryId(model.getSpCountryId());
		soapModel.setSpRegionId(model.getSpRegionId());
		soapModel.setSpAffiliationId(model.getSpAffiliationId());
		soapModel.setSpUserFullName(model.getSpUserFullName());

		return soapModel;
	}

	public static SpUserSoap[] toSoapModels(SpUser[] models) {
		SpUserSoap[] soapModels = new SpUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SpUserSoap[][] toSoapModels(SpUser[][] models) {
		SpUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SpUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SpUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SpUserSoap[] toSoapModels(List<SpUser> models) {
		List<SpUserSoap> soapModels = new ArrayList<SpUserSoap>(models.size());

		for (SpUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SpUserSoap[soapModels.size()]);
	}

	public SpUserSoap() {
	}

	public long getPrimaryKey() {
		return _spUserId;
	}

	public void setPrimaryKey(long pk) {
		setSpUserId(pk);
	}

	public long getSpUserId() {
		return _spUserId;
	}

	public void setSpUserId(long spUserId) {
		_spUserId = spUserId;
	}

	public long getSpCountryId() {
		return _spCountryId;
	}

	public void setSpCountryId(long spCountryId) {
		_spCountryId = spCountryId;
	}

	public long getSpRegionId() {
		return _spRegionId;
	}

	public void setSpRegionId(long spRegionId) {
		_spRegionId = spRegionId;
	}

	public long getSpAffiliationId() {
		return _spAffiliationId;
	}

	public void setSpAffiliationId(long spAffiliationId) {
		_spAffiliationId = spAffiliationId;
	}

	public String getSpUserFullName() {
		return _spUserFullName;
	}

	public void setSpUserFullName(String spUserFullName) {
		_spUserFullName = spUserFullName;
	}

	private long _spUserId;
	private long _spCountryId;
	private long _spRegionId;
	private long _spAffiliationId;
	private String _spUserFullName;
}