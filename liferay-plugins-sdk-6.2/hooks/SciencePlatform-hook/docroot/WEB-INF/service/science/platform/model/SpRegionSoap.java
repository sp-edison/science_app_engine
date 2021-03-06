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
 * This class is used by SOAP remote services, specifically {@link science.platform.service.http.SpRegionServiceSoap}.
 *
 * @author Jerry h. Seo
 * @see science.platform.service.http.SpRegionServiceSoap
 * @generated
 */
public class SpRegionSoap implements Serializable {
	public static SpRegionSoap toSoapModel(SpRegion model) {
		SpRegionSoap soapModel = new SpRegionSoap();

		soapModel.setSpRegionId(model.getSpRegionId());
		soapModel.setSpCountryId(model.getSpCountryId());
		soapModel.setSpRegionCode(model.getSpRegionCode());
		soapModel.setSpRegionName(model.getSpRegionName());
		soapModel.setSpActive(model.getSpActive());

		return soapModel;
	}

	public static SpRegionSoap[] toSoapModels(SpRegion[] models) {
		SpRegionSoap[] soapModels = new SpRegionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SpRegionSoap[][] toSoapModels(SpRegion[][] models) {
		SpRegionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SpRegionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SpRegionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SpRegionSoap[] toSoapModels(List<SpRegion> models) {
		List<SpRegionSoap> soapModels = new ArrayList<SpRegionSoap>(models.size());

		for (SpRegion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SpRegionSoap[soapModels.size()]);
	}

	public SpRegionSoap() {
	}

	public long getPrimaryKey() {
		return _spRegionId;
	}

	public void setPrimaryKey(long pk) {
		setSpRegionId(pk);
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

	public String getSpRegionCode() {
		return _spRegionCode;
	}

	public void setSpRegionCode(String spRegionCode) {
		_spRegionCode = spRegionCode;
	}

	public String getSpRegionName() {
		return _spRegionName;
	}

	public void setSpRegionName(String spRegionName) {
		_spRegionName = spRegionName;
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

	private long _spRegionId;
	private long _spCountryId;
	private String _spRegionCode;
	private String _spRegionName;
	private boolean _spActive;
}