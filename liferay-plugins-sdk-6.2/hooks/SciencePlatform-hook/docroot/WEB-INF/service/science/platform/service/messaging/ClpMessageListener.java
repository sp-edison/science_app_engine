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

package science.platform.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import science.platform.service.ClpSerializer;
import science.platform.service.SpAffiliationLocalServiceUtil;
import science.platform.service.SpAffiliationServiceUtil;
import science.platform.service.SpDomainLocalServiceUtil;
import science.platform.service.SpDomainServiceUtil;
import science.platform.service.SpRegionLocalServiceUtil;
import science.platform.service.SpRegionServiceUtil;
import science.platform.service.SpUserDomainLocalServiceUtil;
import science.platform.service.SpUserDomainServiceUtil;
import science.platform.service.SpUserLocalServiceUtil;
import science.platform.service.SpUserServiceUtil;
import science.platform.service.SystemPropertiesLocalServiceUtil;
import science.platform.service.SystemPropertiesServiceUtil;

/**
 * @author Jerry h. Seo
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			SpAffiliationLocalServiceUtil.clearService();

			SpAffiliationServiceUtil.clearService();
			SpDomainLocalServiceUtil.clearService();

			SpDomainServiceUtil.clearService();
			SpRegionLocalServiceUtil.clearService();

			SpRegionServiceUtil.clearService();
			SpUserLocalServiceUtil.clearService();

			SpUserServiceUtil.clearService();
			SpUserDomainLocalServiceUtil.clearService();

			SpUserDomainServiceUtil.clearService();
			SystemPropertiesLocalServiceUtil.clearService();

			SystemPropertiesServiceUtil.clearService();
		}
	}
}