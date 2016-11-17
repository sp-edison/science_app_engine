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

import science.platform.model.SpAffiliation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SpAffiliation in entity cache.
 *
 * @author Jerry h. Seo
 * @see SpAffiliation
 * @generated
 */
public class SpAffiliationCacheModel implements CacheModel<SpAffiliation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{spAffiliationId=");
		sb.append(spAffiliationId);
		sb.append(", spRegionId=");
		sb.append(spRegionId);
		sb.append(", spCountryId=");
		sb.append(spCountryId);
		sb.append(", spAffiliationCode=");
		sb.append(spAffiliationCode);
		sb.append(", spAffiliationName=");
		sb.append(spAffiliationName);
		sb.append(", spActive=");
		sb.append(spActive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SpAffiliation toEntityModel() {
		SpAffiliationImpl spAffiliationImpl = new SpAffiliationImpl();

		spAffiliationImpl.setSpAffiliationId(spAffiliationId);
		spAffiliationImpl.setSpRegionId(spRegionId);
		spAffiliationImpl.setSpCountryId(spCountryId);

		if (spAffiliationCode == null) {
			spAffiliationImpl.setSpAffiliationCode(StringPool.BLANK);
		}
		else {
			spAffiliationImpl.setSpAffiliationCode(spAffiliationCode);
		}

		if (spAffiliationName == null) {
			spAffiliationImpl.setSpAffiliationName(StringPool.BLANK);
		}
		else {
			spAffiliationImpl.setSpAffiliationName(spAffiliationName);
		}

		spAffiliationImpl.setSpActive(spActive);

		spAffiliationImpl.resetOriginalValues();

		return spAffiliationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spAffiliationId = objectInput.readLong();
		spRegionId = objectInput.readLong();
		spCountryId = objectInput.readLong();
		spAffiliationCode = objectInput.readUTF();
		spAffiliationName = objectInput.readUTF();
		spActive = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spAffiliationId);
		objectOutput.writeLong(spRegionId);
		objectOutput.writeLong(spCountryId);

		if (spAffiliationCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(spAffiliationCode);
		}

		if (spAffiliationName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(spAffiliationName);
		}

		objectOutput.writeBoolean(spActive);
	}

	public long spAffiliationId;
	public long spRegionId;
	public long spCountryId;
	public String spAffiliationCode;
	public String spAffiliationName;
	public boolean spActive;
}