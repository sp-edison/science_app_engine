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

import com.kisti.science.platform.app.model.PortTypeAnalyzerLink;
import com.kisti.science.platform.app.service.PortTypeAnalyzerLinkLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the PortTypeAnalyzerLink service. Represents a row in the &quot;ScienceApp_PortTypeAnalyzerLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PortTypeAnalyzerLinkImpl}.
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeAnalyzerLinkImpl
 * @see com.kisti.science.platform.app.model.PortTypeAnalyzerLink
 * @generated
 */
public abstract class PortTypeAnalyzerLinkBaseImpl
	extends PortTypeAnalyzerLinkModelImpl implements PortTypeAnalyzerLink {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a port type analyzer link model instance should use the {@link PortTypeAnalyzerLink} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PortTypeAnalyzerLinkLocalServiceUtil.addPortTypeAnalyzerLink(this);
		}
		else {
			PortTypeAnalyzerLinkLocalServiceUtil.updatePortTypeAnalyzerLink(this);
		}
	}
}