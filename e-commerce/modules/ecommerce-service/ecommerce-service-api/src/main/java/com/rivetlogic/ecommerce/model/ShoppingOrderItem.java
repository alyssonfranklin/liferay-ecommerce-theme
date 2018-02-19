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
 * The extended model interface for the ShoppingOrderItem service. Represents a row in the &quot;rivetlogic_ecommerce_ShoppingOrderItem&quot; database table, with each column mapped to a property of this class.
 *
 * @author rivetlogic
 * @see ShoppingOrderItemModel
 * @see com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemImpl
 * @see com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemModelImpl
 * @generated
 */
@ImplementationClassName("com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemImpl")
@ProviderType
public interface ShoppingOrderItem extends ShoppingOrderItemModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ShoppingOrderItem, Long> ITEM_ID_ACCESSOR = new Accessor<ShoppingOrderItem, Long>() {
			@Override
			public Long get(ShoppingOrderItem shoppingOrderItem) {
				return shoppingOrderItem.getItemId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ShoppingOrderItem> getTypeClass() {
				return ShoppingOrderItem.class;
			}
		};
}