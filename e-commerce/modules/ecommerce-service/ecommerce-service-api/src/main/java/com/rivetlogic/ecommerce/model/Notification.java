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

package com.rivetlogic.ecommerce.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Notification service. Represents a row in the &quot;rivetlogic_ecommerce_Notification&quot; database table, with each column mapped to a property of this class.
 *
 * @author rivetlogic
 * @see NotificationModel
 * @see com.rivetlogic.ecommerce.model.impl.NotificationImpl
 * @see com.rivetlogic.ecommerce.model.impl.NotificationModelImpl
 * @generated
 */
@ImplementationClassName("com.rivetlogic.ecommerce.model.impl.NotificationImpl")
@ProviderType
public interface Notification extends NotificationModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.rivetlogic.ecommerce.model.impl.NotificationImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Notification, Long> NOTIFICATION_ID_ACCESSOR = new Accessor<Notification, Long>() {
			@Override
			public Long get(Notification notification) {
				return notification.getNotificationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Notification> getTypeClass() {
				return Notification.class;
			}
		};
}