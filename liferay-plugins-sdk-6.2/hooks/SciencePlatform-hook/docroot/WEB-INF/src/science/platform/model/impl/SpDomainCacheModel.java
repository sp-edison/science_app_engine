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

import science.platform.model.SpDomain;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SpDomain in entity cache.
 *
 * @author Jerry h. Seo
 * @see SpDomain
 * @generated
 */
public class SpDomainCacheModel implements CacheModel<SpDomain>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{spDomainId=");
		sb.append(spDomainId);
		sb.append(", spDomainCode=");
		sb.append(spDomainCode);
		sb.append(", spDomainName=");
		sb.append(spDomainName);
		sb.append(", spActive=");
		sb.append(spActive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SpDomain toEntityModel() {
		SpDomainImpl spDomainImpl = new SpDomainImpl();

		spDomainImpl.setSpDomainId(spDomainId);

		if (spDomainCode == null) {
			spDomainImpl.setSpDomainCode(StringPool.BLANK);
		}
		else {
			spDomainImpl.setSpDomainCode(spDomainCode);
		}

		if (spDomainName == null) {
			spDomainImpl.setSpDomainName(StringPool.BLANK);
		}
		else {
			spDomainImpl.setSpDomainName(spDomainName);
		}

		spDomainImpl.setSpActive(spActive);

		spDomainImpl.resetOriginalValues();

		return spDomainImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spDomainId = objectInput.readLong();
		spDomainCode = objectInput.readUTF();
		spDomainName = objectInput.readUTF();
		spActive = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spDomainId);

		if (spDomainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(spDomainCode);
		}

		if (spDomainName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(spDomainName);
		}

		objectOutput.writeBoolean(spActive);
	}

	public long spDomainId;
	public String spDomainCode;
	public String spDomainName;
	public boolean spActive;
}