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

package science.platform.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import science.platform.model.SpRegion;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SpRegion in entity cache.
 *
 * @author Jerry h. Seo
 * @see SpRegion
 * @generated
 */
public class SpRegionCacheModel implements CacheModel<SpRegion>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{spRegionId=");
		sb.append(spRegionId);
		sb.append(", spCountryId=");
		sb.append(spCountryId);
		sb.append(", spRegionCode=");
		sb.append(spRegionCode);
		sb.append(", spRegionName=");
		sb.append(spRegionName);
		sb.append(", spActive=");
		sb.append(spActive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SpRegion toEntityModel() {
		SpRegionImpl spRegionImpl = new SpRegionImpl();

		spRegionImpl.setSpRegionId(spRegionId);
		spRegionImpl.setSpCountryId(spCountryId);

		if (spRegionCode == null) {
			spRegionImpl.setSpRegionCode(StringPool.BLANK);
		}
		else {
			spRegionImpl.setSpRegionCode(spRegionCode);
		}

		if (spRegionName == null) {
			spRegionImpl.setSpRegionName(StringPool.BLANK);
		}
		else {
			spRegionImpl.setSpRegionName(spRegionName);
		}

		spRegionImpl.setSpActive(spActive);

		spRegionImpl.resetOriginalValues();

		return spRegionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spRegionId = objectInput.readLong();
		spCountryId = objectInput.readLong();
		spRegionCode = objectInput.readUTF();
		spRegionName = objectInput.readUTF();
		spActive = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spRegionId);
		objectOutput.writeLong(spCountryId);

		if (spRegionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(spRegionCode);
		}

		if (spRegionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(spRegionName);
		}

		objectOutput.writeBoolean(spActive);
	}

	public long spRegionId;
	public long spCountryId;
	public String spRegionCode;
	public String spRegionName;
	public boolean spActive;
}