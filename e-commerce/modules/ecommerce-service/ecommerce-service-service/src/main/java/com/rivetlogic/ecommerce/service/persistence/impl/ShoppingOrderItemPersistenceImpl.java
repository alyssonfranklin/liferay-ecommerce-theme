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

package com.rivetlogic.ecommerce.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderItemException;
import com.rivetlogic.ecommerce.model.ShoppingOrderItem;
import com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemImpl;
import com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemModelImpl;
import com.rivetlogic.ecommerce.service.persistence.ShoppingOrderItemPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the Shopping Order Item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rivetlogic
 * @see ShoppingOrderItemPersistence
 * @see com.rivetlogic.ecommerce.service.persistence.ShoppingOrderItemUtil
 * @generated
 */
@ProviderType
public class ShoppingOrderItemPersistenceImpl extends BasePersistenceImpl<ShoppingOrderItem>
	implements ShoppingOrderItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ShoppingOrderItemUtil} to access the Shopping Order Item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ShoppingOrderItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ShoppingOrderItemModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the Shopping Order Items where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Order Items where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @return the range of matching Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Shopping Order Items where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findByUuid(String uuid, int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the Shopping Order Items where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findByUuid(String uuid, int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<ShoppingOrderItem> list = null;

		if (retrieveFromCache) {
			list = (List<ShoppingOrderItem>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ShoppingOrderItem shoppingOrderItem : list) {
					if (!Objects.equals(uuid, shoppingOrderItem.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShoppingOrderItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<ShoppingOrderItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ShoppingOrderItem>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first Shopping Order Item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order Item
	 * @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem findByUuid_First(String uuid,
		OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException {
		ShoppingOrderItem shoppingOrderItem = fetchByUuid_First(uuid,
				orderByComparator);

		if (shoppingOrderItem != null) {
			return shoppingOrderItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderItemException(msg.toString());
	}

	/**
	 * Returns the first Shopping Order Item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem fetchByUuid_First(String uuid,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		List<ShoppingOrderItem> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Shopping Order Item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order Item
	 * @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem findByUuid_Last(String uuid,
		OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException {
		ShoppingOrderItem shoppingOrderItem = fetchByUuid_Last(uuid,
				orderByComparator);

		if (shoppingOrderItem != null) {
			return shoppingOrderItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderItemException(msg.toString());
	}

	/**
	 * Returns the last Shopping Order Item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem fetchByUuid_Last(String uuid,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ShoppingOrderItem> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Shopping Order Items before and after the current Shopping Order Item in the ordered set where uuid = &#63;.
	 *
	 * @param itemId the primary key of the current Shopping Order Item
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Shopping Order Item
	 * @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	 */
	@Override
	public ShoppingOrderItem[] findByUuid_PrevAndNext(long itemId, String uuid,
		OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException {
		ShoppingOrderItem shoppingOrderItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			ShoppingOrderItem[] array = new ShoppingOrderItemImpl[3];

			array[0] = getByUuid_PrevAndNext(session, shoppingOrderItem, uuid,
					orderByComparator, true);

			array[1] = shoppingOrderItem;

			array[2] = getByUuid_PrevAndNext(session, shoppingOrderItem, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingOrderItem getByUuid_PrevAndNext(Session session,
		ShoppingOrderItem shoppingOrderItem, String uuid,
		OrderByComparator<ShoppingOrderItem> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ShoppingOrderItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrderItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingOrderItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Shopping Order Items where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ShoppingOrderItem shoppingOrderItem : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(shoppingOrderItem);
		}
	}

	/**
	 * Returns the number of Shopping Order Items where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching Shopping Order Items
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOPPINGORDERITEM_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "shoppingOrderItem.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "shoppingOrderItem.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(shoppingOrderItem.uuid IS NULL OR shoppingOrderItem.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderItemImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ShoppingOrderItemModelImpl.UUID_COLUMN_BITMASK |
			ShoppingOrderItemModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the Shopping Order Item where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchShoppingOrderItemException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching Shopping Order Item
	 * @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem findByUUID_G(String uuid, long groupId)
		throws NoSuchShoppingOrderItemException {
		ShoppingOrderItem shoppingOrderItem = fetchByUUID_G(uuid, groupId);

		if (shoppingOrderItem == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchShoppingOrderItemException(msg.toString());
		}

		return shoppingOrderItem;
	}

	/**
	 * Returns the Shopping Order Item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the Shopping Order Item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ShoppingOrderItem) {
			ShoppingOrderItem shoppingOrderItem = (ShoppingOrderItem)result;

			if (!Objects.equals(uuid, shoppingOrderItem.getUuid()) ||
					(groupId != shoppingOrderItem.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<ShoppingOrderItem> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ShoppingOrderItem shoppingOrderItem = list.get(0);

					result = shoppingOrderItem;

					cacheResult(shoppingOrderItem);

					if ((shoppingOrderItem.getUuid() == null) ||
							!shoppingOrderItem.getUuid().equals(uuid) ||
							(shoppingOrderItem.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, shoppingOrderItem);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ShoppingOrderItem)result;
		}
	}

	/**
	 * Removes the Shopping Order Item where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the Shopping Order Item that was removed
	 */
	@Override
	public ShoppingOrderItem removeByUUID_G(String uuid, long groupId)
		throws NoSuchShoppingOrderItemException {
		ShoppingOrderItem shoppingOrderItem = findByUUID_G(uuid, groupId);

		return remove(shoppingOrderItem);
	}

	/**
	 * Returns the number of Shopping Order Items where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching Shopping Order Items
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHOPPINGORDERITEM_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "shoppingOrderItem.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "shoppingOrderItem.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(shoppingOrderItem.uuid IS NULL OR shoppingOrderItem.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "shoppingOrderItem.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ShoppingOrderItemModelImpl.UUID_COLUMN_BITMASK |
			ShoppingOrderItemModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the Shopping Order Items where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Order Items where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @return the range of matching Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Shopping Order Items where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the Shopping Order Items where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<ShoppingOrderItem> list = null;

		if (retrieveFromCache) {
			list = (List<ShoppingOrderItem>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ShoppingOrderItem shoppingOrderItem : list) {
					if (!Objects.equals(uuid, shoppingOrderItem.getUuid()) ||
							(companyId != shoppingOrderItem.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShoppingOrderItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<ShoppingOrderItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ShoppingOrderItem>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first Shopping Order Item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order Item
	 * @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException {
		ShoppingOrderItem shoppingOrderItem = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (shoppingOrderItem != null) {
			return shoppingOrderItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderItemException(msg.toString());
	}

	/**
	 * Returns the first Shopping Order Item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		List<ShoppingOrderItem> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Shopping Order Item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order Item
	 * @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException {
		ShoppingOrderItem shoppingOrderItem = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (shoppingOrderItem != null) {
			return shoppingOrderItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderItemException(msg.toString());
	}

	/**
	 * Returns the last Shopping Order Item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ShoppingOrderItem> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Shopping Order Items before and after the current Shopping Order Item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param itemId the primary key of the current Shopping Order Item
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Shopping Order Item
	 * @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	 */
	@Override
	public ShoppingOrderItem[] findByUuid_C_PrevAndNext(long itemId,
		String uuid, long companyId,
		OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException {
		ShoppingOrderItem shoppingOrderItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			ShoppingOrderItem[] array = new ShoppingOrderItemImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, shoppingOrderItem,
					uuid, companyId, orderByComparator, true);

			array[1] = shoppingOrderItem;

			array[2] = getByUuid_C_PrevAndNext(session, shoppingOrderItem,
					uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingOrderItem getByUuid_C_PrevAndNext(Session session,
		ShoppingOrderItem shoppingOrderItem, String uuid, long companyId,
		OrderByComparator<ShoppingOrderItem> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ShoppingOrderItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrderItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingOrderItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Shopping Order Items where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ShoppingOrderItem shoppingOrderItem : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(shoppingOrderItem);
		}
	}

	/**
	 * Returns the number of Shopping Order Items where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching Shopping Order Items
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHOPPINGORDERITEM_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "shoppingOrderItem.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "shoppingOrderItem.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(shoppingOrderItem.uuid IS NULL OR shoppingOrderItem.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "shoppingOrderItem.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORDERID = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrderId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID =
		new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrderId",
			new String[] { Long.class.getName() },
			ShoppingOrderItemModelImpl.ORDERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORDERID = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrderId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the Shopping Order Items where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @return the matching Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findByOrderId(long orderId) {
		return findByOrderId(orderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Order Items where orderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param orderId the order ID
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @return the range of matching Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findByOrderId(long orderId, int start,
		int end) {
		return findByOrderId(orderId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Shopping Order Items where orderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param orderId the order ID
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findByOrderId(long orderId, int start,
		int end, OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return findByOrderId(orderId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the Shopping Order Items where orderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param orderId the order ID
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findByOrderId(long orderId, int start,
		int end, OrderByComparator<ShoppingOrderItem> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID;
			finderArgs = new Object[] { orderId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORDERID;
			finderArgs = new Object[] { orderId, start, end, orderByComparator };
		}

		List<ShoppingOrderItem> list = null;

		if (retrieveFromCache) {
			list = (List<ShoppingOrderItem>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ShoppingOrderItem shoppingOrderItem : list) {
					if ((orderId != shoppingOrderItem.getOrderId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

			query.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShoppingOrderItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orderId);

				if (!pagination) {
					list = (List<ShoppingOrderItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ShoppingOrderItem>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first Shopping Order Item in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order Item
	 * @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem findByOrderId_First(long orderId,
		OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException {
		ShoppingOrderItem shoppingOrderItem = fetchByOrderId_First(orderId,
				orderByComparator);

		if (shoppingOrderItem != null) {
			return shoppingOrderItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orderId=");
		msg.append(orderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderItemException(msg.toString());
	}

	/**
	 * Returns the first Shopping Order Item in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem fetchByOrderId_First(long orderId,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		List<ShoppingOrderItem> list = findByOrderId(orderId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Shopping Order Item in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order Item
	 * @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem findByOrderId_Last(long orderId,
		OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException {
		ShoppingOrderItem shoppingOrderItem = fetchByOrderId_Last(orderId,
				orderByComparator);

		if (shoppingOrderItem != null) {
			return shoppingOrderItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orderId=");
		msg.append(orderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderItemException(msg.toString());
	}

	/**
	 * Returns the last Shopping Order Item in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem fetchByOrderId_Last(long orderId,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		int count = countByOrderId(orderId);

		if (count == 0) {
			return null;
		}

		List<ShoppingOrderItem> list = findByOrderId(orderId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Shopping Order Items before and after the current Shopping Order Item in the ordered set where orderId = &#63;.
	 *
	 * @param itemId the primary key of the current Shopping Order Item
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Shopping Order Item
	 * @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	 */
	@Override
	public ShoppingOrderItem[] findByOrderId_PrevAndNext(long itemId,
		long orderId, OrderByComparator<ShoppingOrderItem> orderByComparator)
		throws NoSuchShoppingOrderItemException {
		ShoppingOrderItem shoppingOrderItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			ShoppingOrderItem[] array = new ShoppingOrderItemImpl[3];

			array[0] = getByOrderId_PrevAndNext(session, shoppingOrderItem,
					orderId, orderByComparator, true);

			array[1] = shoppingOrderItem;

			array[2] = getByOrderId_PrevAndNext(session, shoppingOrderItem,
					orderId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingOrderItem getByOrderId_PrevAndNext(Session session,
		ShoppingOrderItem shoppingOrderItem, long orderId,
		OrderByComparator<ShoppingOrderItem> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

		query.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ShoppingOrderItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(orderId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrderItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingOrderItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Shopping Order Items where orderId = &#63; from the database.
	 *
	 * @param orderId the order ID
	 */
	@Override
	public void removeByOrderId(long orderId) {
		for (ShoppingOrderItem shoppingOrderItem : findByOrderId(orderId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(shoppingOrderItem);
		}
	}

	/**
	 * Returns the number of Shopping Order Items where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @return the number of matching Shopping Order Items
	 */
	@Override
	public int countByOrderId(long orderId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORDERID;

		Object[] finderArgs = new Object[] { orderId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOPPINGORDERITEM_WHERE);

			query.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orderId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORDERID_ORDERID_2 = "shoppingOrderItem.orderId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderItemImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByOrderAndProductId",
			new String[] { Long.class.getName(), String.class.getName() },
			ShoppingOrderItemModelImpl.ORDERID_COLUMN_BITMASK |
			ShoppingOrderItemModelImpl.PRODUCTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORDERANDPRODUCTID = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrderAndProductId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or throws a {@link NoSuchShoppingOrderItemException} if it could not be found.
	 *
	 * @param orderId the order ID
	 * @param productId the product ID
	 * @return the matching Shopping Order Item
	 * @throws NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem findByOrderAndProductId(long orderId,
		String productId) throws NoSuchShoppingOrderItemException {
		ShoppingOrderItem shoppingOrderItem = fetchByOrderAndProductId(orderId,
				productId);

		if (shoppingOrderItem == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("orderId=");
			msg.append(orderId);

			msg.append(", productId=");
			msg.append(productId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchShoppingOrderItemException(msg.toString());
		}

		return shoppingOrderItem;
	}

	/**
	 * Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param orderId the order ID
	 * @param productId the product ID
	 * @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem fetchByOrderAndProductId(long orderId,
		String productId) {
		return fetchByOrderAndProductId(orderId, productId, true);
	}

	/**
	 * Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param orderId the order ID
	 * @param productId the product ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem fetchByOrderAndProductId(long orderId,
		String productId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { orderId, productId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
					finderArgs, this);
		}

		if (result instanceof ShoppingOrderItem) {
			ShoppingOrderItem shoppingOrderItem = (ShoppingOrderItem)result;

			if ((orderId != shoppingOrderItem.getOrderId()) ||
					!Objects.equals(productId, shoppingOrderItem.getProductId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

			query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_ORDERID_2);

			boolean bindProductId = false;

			if (productId == null) {
				query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_1);
			}
			else if (productId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_3);
			}
			else {
				bindProductId = true;

				query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orderId);

				if (bindProductId) {
					qPos.add(productId);
				}

				List<ShoppingOrderItem> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ShoppingOrderItemPersistenceImpl.fetchByOrderAndProductId(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ShoppingOrderItem shoppingOrderItem = list.get(0);

					result = shoppingOrderItem;

					cacheResult(shoppingOrderItem);

					if ((shoppingOrderItem.getOrderId() != orderId) ||
							(shoppingOrderItem.getProductId() == null) ||
							!shoppingOrderItem.getProductId().equals(productId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
							finderArgs, shoppingOrderItem);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ShoppingOrderItem)result;
		}
	}

	/**
	 * Removes the Shopping Order Item where orderId = &#63; and productId = &#63; from the database.
	 *
	 * @param orderId the order ID
	 * @param productId the product ID
	 * @return the Shopping Order Item that was removed
	 */
	@Override
	public ShoppingOrderItem removeByOrderAndProductId(long orderId,
		String productId) throws NoSuchShoppingOrderItemException {
		ShoppingOrderItem shoppingOrderItem = findByOrderAndProductId(orderId,
				productId);

		return remove(shoppingOrderItem);
	}

	/**
	 * Returns the number of Shopping Order Items where orderId = &#63; and productId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param productId the product ID
	 * @return the number of matching Shopping Order Items
	 */
	@Override
	public int countByOrderAndProductId(long orderId, String productId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORDERANDPRODUCTID;

		Object[] finderArgs = new Object[] { orderId, productId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHOPPINGORDERITEM_WHERE);

			query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_ORDERID_2);

			boolean bindProductId = false;

			if (productId == null) {
				query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_1);
			}
			else if (productId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_3);
			}
			else {
				bindProductId = true;

				query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orderId);

				if (bindProductId) {
					qPos.add(productId);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORDERANDPRODUCTID_ORDERID_2 = "shoppingOrderItem.orderId = ? AND ";
	private static final String _FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_1 = "shoppingOrderItem.productId IS NULL";
	private static final String _FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_2 = "shoppingOrderItem.productId = ?";
	private static final String _FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_3 = "(shoppingOrderItem.productId IS NULL OR shoppingOrderItem.productId = '')";

	public ShoppingOrderItemPersistenceImpl() {
		setModelClass(ShoppingOrderItem.class);
	}

	/**
	 * Caches the Shopping Order Item in the entity cache if it is enabled.
	 *
	 * @param shoppingOrderItem the Shopping Order Item
	 */
	@Override
	public void cacheResult(ShoppingOrderItem shoppingOrderItem) {
		entityCache.putResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemImpl.class, shoppingOrderItem.getPrimaryKey(),
			shoppingOrderItem);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				shoppingOrderItem.getUuid(), shoppingOrderItem.getGroupId()
			}, shoppingOrderItem);

		finderCache.putResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
			new Object[] {
				shoppingOrderItem.getOrderId(), shoppingOrderItem.getProductId()
			}, shoppingOrderItem);

		shoppingOrderItem.resetOriginalValues();
	}

	/**
	 * Caches the Shopping Order Items in the entity cache if it is enabled.
	 *
	 * @param shoppingOrderItems the Shopping Order Items
	 */
	@Override
	public void cacheResult(List<ShoppingOrderItem> shoppingOrderItems) {
		for (ShoppingOrderItem shoppingOrderItem : shoppingOrderItems) {
			if (entityCache.getResult(
						ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingOrderItemImpl.class,
						shoppingOrderItem.getPrimaryKey()) == null) {
				cacheResult(shoppingOrderItem);
			}
			else {
				shoppingOrderItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Shopping Order Items.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ShoppingOrderItemImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Shopping Order Item.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ShoppingOrderItem shoppingOrderItem) {
		entityCache.removeResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemImpl.class, shoppingOrderItem.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ShoppingOrderItemModelImpl)shoppingOrderItem);
	}

	@Override
	public void clearCache(List<ShoppingOrderItem> shoppingOrderItems) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ShoppingOrderItem shoppingOrderItem : shoppingOrderItems) {
			entityCache.removeResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingOrderItemImpl.class, shoppingOrderItem.getPrimaryKey());

			clearUniqueFindersCache((ShoppingOrderItemModelImpl)shoppingOrderItem);
		}
	}

	protected void cacheUniqueFindersCache(
		ShoppingOrderItemModelImpl shoppingOrderItemModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					shoppingOrderItemModelImpl.getUuid(),
					shoppingOrderItemModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				shoppingOrderItemModelImpl);

			args = new Object[] {
					shoppingOrderItemModelImpl.getOrderId(),
					shoppingOrderItemModelImpl.getProductId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_ORDERANDPRODUCTID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID, args,
				shoppingOrderItemModelImpl);
		}
		else {
			if ((shoppingOrderItemModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderItemModelImpl.getUuid(),
						shoppingOrderItemModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					shoppingOrderItemModelImpl);
			}

			if ((shoppingOrderItemModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderItemModelImpl.getOrderId(),
						shoppingOrderItemModelImpl.getProductId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_ORDERANDPRODUCTID,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
					args, shoppingOrderItemModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ShoppingOrderItemModelImpl shoppingOrderItemModelImpl) {
		Object[] args = new Object[] {
				shoppingOrderItemModelImpl.getUuid(),
				shoppingOrderItemModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((shoppingOrderItemModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					shoppingOrderItemModelImpl.getOriginalUuid(),
					shoppingOrderItemModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				shoppingOrderItemModelImpl.getOrderId(),
				shoppingOrderItemModelImpl.getProductId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_ORDERANDPRODUCTID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID, args);

		if ((shoppingOrderItemModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID.getColumnBitmask()) != 0) {
			args = new Object[] {
					shoppingOrderItemModelImpl.getOriginalOrderId(),
					shoppingOrderItemModelImpl.getOriginalProductId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ORDERANDPRODUCTID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
				args);
		}
	}

	/**
	 * Creates a new Shopping Order Item with the primary key. Does not add the Shopping Order Item to the database.
	 *
	 * @param itemId the primary key for the new Shopping Order Item
	 * @return the new Shopping Order Item
	 */
	@Override
	public ShoppingOrderItem create(long itemId) {
		ShoppingOrderItem shoppingOrderItem = new ShoppingOrderItemImpl();

		shoppingOrderItem.setNew(true);
		shoppingOrderItem.setPrimaryKey(itemId);

		String uuid = PortalUUIDUtil.generate();

		shoppingOrderItem.setUuid(uuid);

		shoppingOrderItem.setCompanyId(companyProvider.getCompanyId());

		return shoppingOrderItem;
	}

	/**
	 * Removes the Shopping Order Item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemId the primary key of the Shopping Order Item
	 * @return the Shopping Order Item that was removed
	 * @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	 */
	@Override
	public ShoppingOrderItem remove(long itemId)
		throws NoSuchShoppingOrderItemException {
		return remove((Serializable)itemId);
	}

	/**
	 * Removes the Shopping Order Item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Shopping Order Item
	 * @return the Shopping Order Item that was removed
	 * @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	 */
	@Override
	public ShoppingOrderItem remove(Serializable primaryKey)
		throws NoSuchShoppingOrderItemException {
		Session session = null;

		try {
			session = openSession();

			ShoppingOrderItem shoppingOrderItem = (ShoppingOrderItem)session.get(ShoppingOrderItemImpl.class,
					primaryKey);

			if (shoppingOrderItem == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShoppingOrderItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(shoppingOrderItem);
		}
		catch (NoSuchShoppingOrderItemException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ShoppingOrderItem removeImpl(ShoppingOrderItem shoppingOrderItem) {
		shoppingOrderItem = toUnwrappedModel(shoppingOrderItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(shoppingOrderItem)) {
				shoppingOrderItem = (ShoppingOrderItem)session.get(ShoppingOrderItemImpl.class,
						shoppingOrderItem.getPrimaryKeyObj());
			}

			if (shoppingOrderItem != null) {
				session.delete(shoppingOrderItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (shoppingOrderItem != null) {
			clearCache(shoppingOrderItem);
		}

		return shoppingOrderItem;
	}

	@Override
	public ShoppingOrderItem updateImpl(ShoppingOrderItem shoppingOrderItem) {
		shoppingOrderItem = toUnwrappedModel(shoppingOrderItem);

		boolean isNew = shoppingOrderItem.isNew();

		ShoppingOrderItemModelImpl shoppingOrderItemModelImpl = (ShoppingOrderItemModelImpl)shoppingOrderItem;

		if (Validator.isNull(shoppingOrderItem.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			shoppingOrderItem.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (shoppingOrderItem.getCreateDate() == null)) {
			if (serviceContext == null) {
				shoppingOrderItem.setCreateDate(now);
			}
			else {
				shoppingOrderItem.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!shoppingOrderItemModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				shoppingOrderItem.setModifiedDate(now);
			}
			else {
				shoppingOrderItem.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (shoppingOrderItem.isNew()) {
				session.save(shoppingOrderItem);

				shoppingOrderItem.setNew(false);
			}
			else {
				shoppingOrderItem = (ShoppingOrderItem)session.merge(shoppingOrderItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ShoppingOrderItemModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((shoppingOrderItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderItemModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { shoppingOrderItemModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((shoppingOrderItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderItemModelImpl.getOriginalUuid(),
						shoppingOrderItemModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						shoppingOrderItemModelImpl.getUuid(),
						shoppingOrderItemModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((shoppingOrderItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderItemModelImpl.getOriginalOrderId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORDERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID,
					args);

				args = new Object[] { shoppingOrderItemModelImpl.getOrderId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORDERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID,
					args);
			}
		}

		entityCache.putResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemImpl.class, shoppingOrderItem.getPrimaryKey(),
			shoppingOrderItem, false);

		clearUniqueFindersCache(shoppingOrderItemModelImpl);
		cacheUniqueFindersCache(shoppingOrderItemModelImpl, isNew);

		shoppingOrderItem.resetOriginalValues();

		return shoppingOrderItem;
	}

	protected ShoppingOrderItem toUnwrappedModel(
		ShoppingOrderItem shoppingOrderItem) {
		if (shoppingOrderItem instanceof ShoppingOrderItemImpl) {
			return shoppingOrderItem;
		}

		ShoppingOrderItemImpl shoppingOrderItemImpl = new ShoppingOrderItemImpl();

		shoppingOrderItemImpl.setNew(shoppingOrderItem.isNew());
		shoppingOrderItemImpl.setPrimaryKey(shoppingOrderItem.getPrimaryKey());

		shoppingOrderItemImpl.setUuid(shoppingOrderItem.getUuid());
		shoppingOrderItemImpl.setItemId(shoppingOrderItem.getItemId());
		shoppingOrderItemImpl.setGroupId(shoppingOrderItem.getGroupId());
		shoppingOrderItemImpl.setCompanyId(shoppingOrderItem.getCompanyId());
		shoppingOrderItemImpl.setUserId(shoppingOrderItem.getUserId());
		shoppingOrderItemImpl.setCreateDate(shoppingOrderItem.getCreateDate());
		shoppingOrderItemImpl.setModifiedDate(shoppingOrderItem.getModifiedDate());
		shoppingOrderItemImpl.setOrderId(shoppingOrderItem.getOrderId());
		shoppingOrderItemImpl.setProductId(shoppingOrderItem.getProductId());
		shoppingOrderItemImpl.setQuantity(shoppingOrderItem.getQuantity());
		shoppingOrderItemImpl.setPrice(shoppingOrderItem.getPrice());

		return shoppingOrderItemImpl;
	}

	/**
	 * Returns the Shopping Order Item with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Shopping Order Item
	 * @return the Shopping Order Item
	 * @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	 */
	@Override
	public ShoppingOrderItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchShoppingOrderItemException {
		ShoppingOrderItem shoppingOrderItem = fetchByPrimaryKey(primaryKey);

		if (shoppingOrderItem == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchShoppingOrderItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return shoppingOrderItem;
	}

	/**
	 * Returns the Shopping Order Item with the primary key or throws a {@link NoSuchShoppingOrderItemException} if it could not be found.
	 *
	 * @param itemId the primary key of the Shopping Order Item
	 * @return the Shopping Order Item
	 * @throws NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	 */
	@Override
	public ShoppingOrderItem findByPrimaryKey(long itemId)
		throws NoSuchShoppingOrderItemException {
		return findByPrimaryKey((Serializable)itemId);
	}

	/**
	 * Returns the Shopping Order Item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Shopping Order Item
	 * @return the Shopping Order Item, or <code>null</code> if a Shopping Order Item with the primary key could not be found
	 */
	@Override
	public ShoppingOrderItem fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingOrderItemImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ShoppingOrderItem shoppingOrderItem = (ShoppingOrderItem)serializable;

		if (shoppingOrderItem == null) {
			Session session = null;

			try {
				session = openSession();

				shoppingOrderItem = (ShoppingOrderItem)session.get(ShoppingOrderItemImpl.class,
						primaryKey);

				if (shoppingOrderItem != null) {
					cacheResult(shoppingOrderItem);
				}
				else {
					entityCache.putResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingOrderItemImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
					ShoppingOrderItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return shoppingOrderItem;
	}

	/**
	 * Returns the Shopping Order Item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemId the primary key of the Shopping Order Item
	 * @return the Shopping Order Item, or <code>null</code> if a Shopping Order Item with the primary key could not be found
	 */
	@Override
	public ShoppingOrderItem fetchByPrimaryKey(long itemId) {
		return fetchByPrimaryKey((Serializable)itemId);
	}

	@Override
	public Map<Serializable, ShoppingOrderItem> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ShoppingOrderItem> map = new HashMap<Serializable, ShoppingOrderItem>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ShoppingOrderItem shoppingOrderItem = fetchByPrimaryKey(primaryKey);

			if (shoppingOrderItem != null) {
				map.put(primaryKey, shoppingOrderItem);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
					ShoppingOrderItemImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ShoppingOrderItem)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (ShoppingOrderItem shoppingOrderItem : (List<ShoppingOrderItem>)q.list()) {
				map.put(shoppingOrderItem.getPrimaryKeyObj(), shoppingOrderItem);

				cacheResult(shoppingOrderItem);

				uncachedPrimaryKeys.remove(shoppingOrderItem.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
					ShoppingOrderItemImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the Shopping Order Items.
	 *
	 * @return the Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Order Items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @return the range of Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Shopping Order Items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findAll(int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the Shopping Order Items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> findAll(int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ShoppingOrderItem> list = null;

		if (retrieveFromCache) {
			list = (List<ShoppingOrderItem>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SHOPPINGORDERITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHOPPINGORDERITEM;

				if (pagination) {
					sql = sql.concat(ShoppingOrderItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ShoppingOrderItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ShoppingOrderItem>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the Shopping Order Items from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ShoppingOrderItem shoppingOrderItem : findAll()) {
			remove(shoppingOrderItem);
		}
	}

	/**
	 * Returns the number of Shopping Order Items.
	 *
	 * @return the number of Shopping Order Items
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SHOPPINGORDERITEM);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ShoppingOrderItemModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the Shopping Order Item persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ShoppingOrderItemImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SHOPPINGORDERITEM = "SELECT shoppingOrderItem FROM ShoppingOrderItem shoppingOrderItem";
	private static final String _SQL_SELECT_SHOPPINGORDERITEM_WHERE_PKS_IN = "SELECT shoppingOrderItem FROM ShoppingOrderItem shoppingOrderItem WHERE itemId IN (";
	private static final String _SQL_SELECT_SHOPPINGORDERITEM_WHERE = "SELECT shoppingOrderItem FROM ShoppingOrderItem shoppingOrderItem WHERE ";
	private static final String _SQL_COUNT_SHOPPINGORDERITEM = "SELECT COUNT(shoppingOrderItem) FROM ShoppingOrderItem shoppingOrderItem";
	private static final String _SQL_COUNT_SHOPPINGORDERITEM_WHERE = "SELECT COUNT(shoppingOrderItem) FROM ShoppingOrderItem shoppingOrderItem WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingOrderItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingOrderItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingOrderItem exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ShoppingOrderItemPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}