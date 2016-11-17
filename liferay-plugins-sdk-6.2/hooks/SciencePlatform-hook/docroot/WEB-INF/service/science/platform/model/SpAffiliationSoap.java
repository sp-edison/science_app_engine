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
 * This class is used by SOAP remote services, specifically {@link science.platform.service.http.SpAffiliationServiceSoap}.
 *
 * @author Jerry h. Seo
 * @see science.platform.service.http.SpAffiliationServiceSoap
 * @generated
 */
public class SpAffiliationSoap implements Serializable {
	public static SpAffiliationSoap toSoapModel(SpAffiliation model) {
		SpAffiliationSoap soapModel = new SpAffiliationSoap();

		soapModel.setSpAffiliationId(model.getSpAffiliationId());
		soapModel.setSpRegionId(model.getSpRegionId());
		soapModel.setSpCountryId(model.getSpCountryId());
		soapModel.setSpAffiliationCode(model.getSpAffiliationCode());
		soapModel.setSpAffiliationName(model.getSpAffiliationName());
		soapModel.setSpActive(model.getSpActive());

		return soapModel;
	}

	public static SpAffiliationSoap[] toSoapModels(SpAffiliation[] models) {
		SpAffiliationSoap[] soapModels = new SpAffiliationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SpAffiliationSoap[][] toSoapModels(SpAffiliation[][] models) {
		SpAffiliationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SpAffiliationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SpAffiliationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SpAffiliationSoap[] toSoapModels(List<SpAffiliation> models) {
		List<SpAffiliationSoap> soapModels = new ArrayList<SpAffiliationSoap>(models.size());

		for (SpAffiliation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SpAffiliationSoap[soapModels.size()]);
	}

	public SpAffiliationSoap() {
	}

	public long getPrimaryKey() {
		return _spAffiliationId;
	}

	public void setPrimaryKey(long pk) {
		setSpAffiliationId(pk);
	}

	public long getSpAffiliationId() {
		return _spAffiliationId;
	}

	public void setSpAffiliationId(long spAffiliationId) {
		_spAffiliationId = spAffiliationId;
	}

	public long getSpRegionId() {
		return _spRegionId;
	}

	public void setSpRegionId(long spRegionId) {
		_spRegionId = spRegionId;
	}

	public long getSpCountryId() {
		return _spCountryId;
	}

	public void setSpCountryId(long spCountryId) {
		_spCountryId = spCountryId;
	}

	public String getSpAffiliationCode() {
		return _spAffiliationCode;
	}

	public void setSpAffiliationCode(String spAffiliationCode) {
		_spAffiliationCode = spAffiliationCode;
	}

	public String getSpAffiliationName() {
		return _spAffiliationName;
	}

	public void setSpAffiliationName(String spAffiliationName) {
		_spAffiliationName = spAffiliationName;
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

	private long _spAffiliationId;
	private long _spRegionId;
	private long _spCountryId;
	private String _spAffiliationCode;
	private String _spAffiliationName;
	private boolean _spActive;
}