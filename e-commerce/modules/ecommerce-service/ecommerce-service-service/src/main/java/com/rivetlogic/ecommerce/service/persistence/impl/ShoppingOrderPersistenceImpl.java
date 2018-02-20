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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.rivetlogic.ecommerce.exception.NoSuchShoppingOrderException;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.model.impl.ShoppingOrderImpl;
import com.rivetlogic.ecommerce.model.impl.ShoppingOrderModelImpl;
import com.rivetlogic.ecommerce.service.persistence.ShoppingOrderPersistence;

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
 * The persistence implementation for the Shopping Order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rivetlogic
 * @see ShoppingOrderPersistence
 * @see com.rivetlogic.ecommerce.service.persistence.ShoppingOrderUtil
 * @generated
 */
@ProviderType
public class ShoppingOrderPersistenceImpl extends BasePersistenceImpl<ShoppingOrder>
	implements ShoppingOrderPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ShoppingOrderUtil} to access the Shopping Order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ShoppingOrderImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			ShoppingOrderModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the Shopping Orders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Orders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @return the range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByUuid(String uuid, int start, int end,
		OrderByComparator<ShoppingOrder> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByUuid(String uuid, int start, int end,
		OrderByComparator<ShoppingOrder> orderByComparator,
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

		List<ShoppingOrder> list = null;

		if (retrieveFromCache) {
			list = (List<ShoppingOrder>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ShoppingOrder shoppingOrder : list) {
					if (!Objects.equals(uuid, shoppingOrder.getUuid())) {
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

			query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

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
				query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
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
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first Shopping Order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order
	 * @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder findByUuid_First(String uuid,
		OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = fetchByUuid_First(uuid, orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the first Shopping Order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder fetchByUuid_First(String uuid,
		OrderByComparator<ShoppingOrder> orderByComparator) {
		List<ShoppingOrder> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Shopping Order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order
	 * @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder findByUuid_Last(String uuid,
		OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = fetchByUuid_Last(uuid, orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the last Shopping Order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder fetchByUuid_Last(String uuid,
		OrderByComparator<ShoppingOrder> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ShoppingOrder> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Shopping Orders before and after the current Shopping Order in the ordered set where uuid = &#63;.
	 *
	 * @param orderId the primary key of the current Shopping Order
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Shopping Order
	 * @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 */
	@Override
	public ShoppingOrder[] findByUuid_PrevAndNext(long orderId, String uuid,
		OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = findByPrimaryKey(orderId);

		Session session = null;

		try {
			session = openSession();

			ShoppingOrder[] array = new ShoppingOrderImpl[3];

			array[0] = getByUuid_PrevAndNext(session, shoppingOrder, uuid,
					orderByComparator, true);

			array[1] = shoppingOrder;

			array[2] = getByUuid_PrevAndNext(session, shoppingOrder, uuid,
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

	protected ShoppingOrder getByUuid_PrevAndNext(Session session,
		ShoppingOrder shoppingOrder, String uuid,
		OrderByComparator<ShoppingOrder> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

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
			query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingOrder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Shopping Orders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ShoppingOrder shoppingOrder : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(shoppingOrder);
		}
	}

	/**
	 * Returns the number of Shopping Orders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching Shopping Orders
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "shoppingOrder.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "shoppingOrder.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(shoppingOrder.uuid IS NULL OR shoppingOrder.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ShoppingOrderModelImpl.UUID_COLUMN_BITMASK |
			ShoppingOrderModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the Shopping Order where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchShoppingOrderException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching Shopping Order
	 * @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder findByUUID_G(String uuid, long groupId)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = fetchByUUID_G(uuid, groupId);

		if (shoppingOrder == null) {
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

			throw new NoSuchShoppingOrderException(msg.toString());
		}

		return shoppingOrder;
	}

	/**
	 * Returns the Shopping Order where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the Shopping Order where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ShoppingOrder) {
			ShoppingOrder shoppingOrder = (ShoppingOrder)result;

			if (!Objects.equals(uuid, shoppingOrder.getUuid()) ||
					(groupId != shoppingOrder.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

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

				List<ShoppingOrder> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ShoppingOrder shoppingOrder = list.get(0);

					result = shoppingOrder;

					cacheResult(shoppingOrder);

					if ((shoppingOrder.getUuid() == null) ||
							!shoppingOrder.getUuid().equals(uuid) ||
							(shoppingOrder.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, shoppingOrder);
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
			return (ShoppingOrder)result;
		}
	}

	/**
	 * Removes the Shopping Order where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the Shopping Order that was removed
	 */
	@Override
	public ShoppingOrder removeByUUID_G(String uuid, long groupId)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = findByUUID_G(uuid, groupId);

		return remove(shoppingOrder);
	}

	/**
	 * Returns the number of Shopping Orders where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching Shopping Orders
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "shoppingOrder.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "shoppingOrder.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(shoppingOrder.uuid IS NULL OR shoppingOrder.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "shoppingOrder.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ShoppingOrderModelImpl.UUID_COLUMN_BITMASK |
			ShoppingOrderModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the Shopping Orders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Orders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @return the range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<ShoppingOrder> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<ShoppingOrder> orderByComparator,
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

		List<ShoppingOrder> list = null;

		if (retrieveFromCache) {
			list = (List<ShoppingOrder>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ShoppingOrder shoppingOrder : list) {
					if (!Objects.equals(uuid, shoppingOrder.getUuid()) ||
							(companyId != shoppingOrder.getCompanyId())) {
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

			query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

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
				query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
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
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first Shopping Order in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order
	 * @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the first Shopping Order in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<ShoppingOrder> orderByComparator) {
		List<ShoppingOrder> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Shopping Order in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order
	 * @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the last Shopping Order in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<ShoppingOrder> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ShoppingOrder> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Shopping Orders before and after the current Shopping Order in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param orderId the primary key of the current Shopping Order
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Shopping Order
	 * @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 */
	@Override
	public ShoppingOrder[] findByUuid_C_PrevAndNext(long orderId, String uuid,
		long companyId, OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = findByPrimaryKey(orderId);

		Session session = null;

		try {
			session = openSession();

			ShoppingOrder[] array = new ShoppingOrderImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, shoppingOrder, uuid,
					companyId, orderByComparator, true);

			array[1] = shoppingOrder;

			array[2] = getByUuid_C_PrevAndNext(session, shoppingOrder, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingOrder getByUuid_C_PrevAndNext(Session session,
		ShoppingOrder shoppingOrder, String uuid, long companyId,
		OrderByComparator<ShoppingOrder> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

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
			query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingOrder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Shopping Orders where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ShoppingOrder shoppingOrder : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(shoppingOrder);
		}
	}

	/**
	 * Returns the number of Shopping Orders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching Shopping Orders
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "shoppingOrder.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "shoppingOrder.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(shoppingOrder.uuid IS NULL OR shoppingOrder.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "shoppingOrder.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORDERSTATUSANDUSERID =
		new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrderStatusAndUserId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERSTATUSANDUSERID =
		new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOrderStatusAndUserId",
			new String[] { String.class.getName(), Long.class.getName() },
			ShoppingOrderModelImpl.ORDERSTATUS_COLUMN_BITMASK |
			ShoppingOrderModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORDERSTATUSANDUSERID = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrderStatusAndUserId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the Shopping Orders where orderStatus = &#63; and userId = &#63;.
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @return the matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByOrderStatusAndUserId(String orderStatus,
		long userId) {
		return findByOrderStatusAndUserId(orderStatus, userId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Orders where orderStatus = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @return the range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByOrderStatusAndUserId(String orderStatus,
		long userId, int start, int end) {
		return findByOrderStatusAndUserId(orderStatus, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders where orderStatus = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByOrderStatusAndUserId(String orderStatus,
		long userId, int start, int end,
		OrderByComparator<ShoppingOrder> orderByComparator) {
		return findByOrderStatusAndUserId(orderStatus, userId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders where orderStatus = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByOrderStatusAndUserId(String orderStatus,
		long userId, int start, int end,
		OrderByComparator<ShoppingOrder> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERSTATUSANDUSERID;
			finderArgs = new Object[] { orderStatus, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORDERSTATUSANDUSERID;
			finderArgs = new Object[] {
					orderStatus, userId,
					
					start, end, orderByComparator
				};
		}

		List<ShoppingOrder> list = null;

		if (retrieveFromCache) {
			list = (List<ShoppingOrder>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ShoppingOrder shoppingOrder : list) {
					if (!Objects.equals(orderStatus,
								shoppingOrder.getOrderStatus()) ||
							(userId != shoppingOrder.getUserId())) {
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

			query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

			boolean bindOrderStatus = false;

			if (orderStatus == null) {
				query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_1);
			}
			else if (orderStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_3);
			}
			else {
				bindOrderStatus = true;

				query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_2);
			}

			query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOrderStatus) {
					qPos.add(orderStatus);
				}

				qPos.add(userId);

				if (!pagination) {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order
	 * @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder findByOrderStatusAndUserId_First(String orderStatus,
		long userId, OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = fetchByOrderStatusAndUserId_First(orderStatus,
				userId, orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orderStatus=");
		msg.append(orderStatus);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the first Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder fetchByOrderStatusAndUserId_First(String orderStatus,
		long userId, OrderByComparator<ShoppingOrder> orderByComparator) {
		List<ShoppingOrder> list = findByOrderStatusAndUserId(orderStatus,
				userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order
	 * @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder findByOrderStatusAndUserId_Last(String orderStatus,
		long userId, OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = fetchByOrderStatusAndUserId_Last(orderStatus,
				userId, orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orderStatus=");
		msg.append(orderStatus);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the last Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder fetchByOrderStatusAndUserId_Last(String orderStatus,
		long userId, OrderByComparator<ShoppingOrder> orderByComparator) {
		int count = countByOrderStatusAndUserId(orderStatus, userId);

		if (count == 0) {
			return null;
		}

		List<ShoppingOrder> list = findByOrderStatusAndUserId(orderStatus,
				userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Shopping Orders before and after the current Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	 *
	 * @param orderId the primary key of the current Shopping Order
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Shopping Order
	 * @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 */
	@Override
	public ShoppingOrder[] findByOrderStatusAndUserId_PrevAndNext(
		long orderId, String orderStatus, long userId,
		OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = findByPrimaryKey(orderId);

		Session session = null;

		try {
			session = openSession();

			ShoppingOrder[] array = new ShoppingOrderImpl[3];

			array[0] = getByOrderStatusAndUserId_PrevAndNext(session,
					shoppingOrder, orderStatus, userId, orderByComparator, true);

			array[1] = shoppingOrder;

			array[2] = getByOrderStatusAndUserId_PrevAndNext(session,
					shoppingOrder, orderStatus, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingOrder getByOrderStatusAndUserId_PrevAndNext(
		Session session, ShoppingOrder shoppingOrder, String orderStatus,
		long userId, OrderByComparator<ShoppingOrder> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

		boolean bindOrderStatus = false;

		if (orderStatus == null) {
			query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_1);
		}
		else if (orderStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_3);
		}
		else {
			bindOrderStatus = true;

			query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_2);
		}

		query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_USERID_2);

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
			query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindOrderStatus) {
			qPos.add(orderStatus);
		}

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingOrder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Shopping Orders where orderStatus = &#63; and userId = &#63; from the database.
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 */
	@Override
	public void removeByOrderStatusAndUserId(String orderStatus, long userId) {
		for (ShoppingOrder shoppingOrder : findByOrderStatusAndUserId(
				orderStatus, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(shoppingOrder);
		}
	}

	/**
	 * Returns the number of Shopping Orders where orderStatus = &#63; and userId = &#63;.
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @return the number of matching Shopping Orders
	 */
	@Override
	public int countByOrderStatusAndUserId(String orderStatus, long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORDERSTATUSANDUSERID;

		Object[] finderArgs = new Object[] { orderStatus, userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

			boolean bindOrderStatus = false;

			if (orderStatus == null) {
				query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_1);
			}
			else if (orderStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_3);
			}
			else {
				bindOrderStatus = true;

				query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_2);
			}

			query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOrderStatus) {
					qPos.add(orderStatus);
				}

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_1 =
		"shoppingOrder.orderStatus IS NULL AND ";
	private static final String _FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_2 =
		"shoppingOrder.orderStatus = ? AND ";
	private static final String _FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_3 =
		"(shoppingOrder.orderStatus IS NULL OR shoppingOrder.orderStatus = '') AND ";
	private static final String _FINDER_COLUMN_ORDERSTATUSANDUSERID_USERID_2 = "shoppingOrder.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPORDERSTATUSANDUSERID =
		new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupOrderStatusAndUserId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPORDERSTATUSANDUSERID =
		new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupOrderStatusAndUserId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			ShoppingOrderModelImpl.GROUPID_COLUMN_BITMASK |
			ShoppingOrderModelImpl.ORDERSTATUS_COLUMN_BITMASK |
			ShoppingOrderModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPORDERSTATUSANDUSERID =
		new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupOrderStatusAndUserId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the Shopping Orders where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @return the matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByGroupOrderStatusAndUserId(long groupId,
		String orderStatus, long userId) {
		return findByGroupOrderStatusAndUserId(groupId, orderStatus, userId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Orders where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @return the range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByGroupOrderStatusAndUserId(long groupId,
		String orderStatus, long userId, int start, int end) {
		return findByGroupOrderStatusAndUserId(groupId, orderStatus, userId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByGroupOrderStatusAndUserId(long groupId,
		String orderStatus, long userId, int start, int end,
		OrderByComparator<ShoppingOrder> orderByComparator) {
		return findByGroupOrderStatusAndUserId(groupId, orderStatus, userId,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByGroupOrderStatusAndUserId(long groupId,
		String orderStatus, long userId, int start, int end,
		OrderByComparator<ShoppingOrder> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPORDERSTATUSANDUSERID;
			finderArgs = new Object[] { groupId, orderStatus, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPORDERSTATUSANDUSERID;
			finderArgs = new Object[] {
					groupId, orderStatus, userId,
					
					start, end, orderByComparator
				};
		}

		List<ShoppingOrder> list = null;

		if (retrieveFromCache) {
			list = (List<ShoppingOrder>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ShoppingOrder shoppingOrder : list) {
					if ((groupId != shoppingOrder.getGroupId()) ||
							!Objects.equals(orderStatus,
								shoppingOrder.getOrderStatus()) ||
							(userId != shoppingOrder.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

			query.append(_FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_GROUPID_2);

			boolean bindOrderStatus = false;

			if (orderStatus == null) {
				query.append(_FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_ORDERSTATUS_1);
			}
			else if (orderStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_ORDERSTATUS_3);
			}
			else {
				bindOrderStatus = true;

				query.append(_FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_ORDERSTATUS_2);
			}

			query.append(_FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindOrderStatus) {
					qPos.add(orderStatus);
				}

				qPos.add(userId);

				if (!pagination) {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order
	 * @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder findByGroupOrderStatusAndUserId_First(long groupId,
		String orderStatus, long userId,
		OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = fetchByGroupOrderStatusAndUserId_First(groupId,
				orderStatus, userId, orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", orderStatus=");
		msg.append(orderStatus);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the first Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder fetchByGroupOrderStatusAndUserId_First(long groupId,
		String orderStatus, long userId,
		OrderByComparator<ShoppingOrder> orderByComparator) {
		List<ShoppingOrder> list = findByGroupOrderStatusAndUserId(groupId,
				orderStatus, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order
	 * @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder findByGroupOrderStatusAndUserId_Last(long groupId,
		String orderStatus, long userId,
		OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = fetchByGroupOrderStatusAndUserId_Last(groupId,
				orderStatus, userId, orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", orderStatus=");
		msg.append(orderStatus);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the last Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder fetchByGroupOrderStatusAndUserId_Last(long groupId,
		String orderStatus, long userId,
		OrderByComparator<ShoppingOrder> orderByComparator) {
		int count = countByGroupOrderStatusAndUserId(groupId, orderStatus,
				userId);

		if (count == 0) {
			return null;
		}

		List<ShoppingOrder> list = findByGroupOrderStatusAndUserId(groupId,
				orderStatus, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Shopping Orders before and after the current Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	 *
	 * @param orderId the primary key of the current Shopping Order
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Shopping Order
	 * @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 */
	@Override
	public ShoppingOrder[] findByGroupOrderStatusAndUserId_PrevAndNext(
		long orderId, long groupId, String orderStatus, long userId,
		OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = findByPrimaryKey(orderId);

		Session session = null;

		try {
			session = openSession();

			ShoppingOrder[] array = new ShoppingOrderImpl[3];

			array[0] = getByGroupOrderStatusAndUserId_PrevAndNext(session,
					shoppingOrder, groupId, orderStatus, userId,
					orderByComparator, true);

			array[1] = shoppingOrder;

			array[2] = getByGroupOrderStatusAndUserId_PrevAndNext(session,
					shoppingOrder, groupId, orderStatus, userId,
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

	protected ShoppingOrder getByGroupOrderStatusAndUserId_PrevAndNext(
		Session session, ShoppingOrder shoppingOrder, long groupId,
		String orderStatus, long userId,
		OrderByComparator<ShoppingOrder> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

		query.append(_FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_GROUPID_2);

		boolean bindOrderStatus = false;

		if (orderStatus == null) {
			query.append(_FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_ORDERSTATUS_1);
		}
		else if (orderStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_ORDERSTATUS_3);
		}
		else {
			bindOrderStatus = true;

			query.append(_FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_ORDERSTATUS_2);
		}

		query.append(_FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_USERID_2);

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
			query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindOrderStatus) {
			qPos.add(orderStatus);
		}

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingOrder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Shopping Orders where groupId = &#63; and orderStatus = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param userId the user ID
	 */
	@Override
	public void removeByGroupOrderStatusAndUserId(long groupId,
		String orderStatus, long userId) {
		for (ShoppingOrder shoppingOrder : findByGroupOrderStatusAndUserId(
				groupId, orderStatus, userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(shoppingOrder);
		}
	}

	/**
	 * Returns the number of Shopping Orders where groupId = &#63; and orderStatus = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @return the number of matching Shopping Orders
	 */
	@Override
	public int countByGroupOrderStatusAndUserId(long groupId,
		String orderStatus, long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPORDERSTATUSANDUSERID;

		Object[] finderArgs = new Object[] { groupId, orderStatus, userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

			query.append(_FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_GROUPID_2);

			boolean bindOrderStatus = false;

			if (orderStatus == null) {
				query.append(_FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_ORDERSTATUS_1);
			}
			else if (orderStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_ORDERSTATUS_3);
			}
			else {
				bindOrderStatus = true;

				query.append(_FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_ORDERSTATUS_2);
			}

			query.append(_FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindOrderStatus) {
					qPos.add(orderStatus);
				}

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_GROUPID_2 =
		"shoppingOrder.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_ORDERSTATUS_1 =
		"shoppingOrder.orderStatus IS NULL AND ";
	private static final String _FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_ORDERSTATUS_2 =
		"shoppingOrder.orderStatus = ? AND ";
	private static final String _FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_ORDERSTATUS_3 =
		"(shoppingOrder.orderStatus IS NULL OR shoppingOrder.orderStatus = '') AND ";
	private static final String _FINDER_COLUMN_GROUPORDERSTATUSANDUSERID_USERID_2 =
		"shoppingOrder.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId", new String[] { Long.class.getName() },
			ShoppingOrderModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the Shopping Orders where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Orders where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @return the range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByGroupId(long groupId, int start, int end,
		OrderByComparator<ShoppingOrder> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByGroupId(long groupId, int start, int end,
		OrderByComparator<ShoppingOrder> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ShoppingOrder> list = null;

		if (retrieveFromCache) {
			list = (List<ShoppingOrder>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ShoppingOrder shoppingOrder : list) {
					if ((groupId != shoppingOrder.getGroupId())) {
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

			query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first Shopping Order in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order
	 * @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder findByGroupId_First(long groupId,
		OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = fetchByGroupId_First(groupId,
				orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the first Shopping Order in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder fetchByGroupId_First(long groupId,
		OrderByComparator<ShoppingOrder> orderByComparator) {
		List<ShoppingOrder> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Shopping Order in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order
	 * @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder findByGroupId_Last(long groupId,
		OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the last Shopping Order in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder fetchByGroupId_Last(long groupId,
		OrderByComparator<ShoppingOrder> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ShoppingOrder> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Shopping Orders before and after the current Shopping Order in the ordered set where groupId = &#63;.
	 *
	 * @param orderId the primary key of the current Shopping Order
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Shopping Order
	 * @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 */
	@Override
	public ShoppingOrder[] findByGroupId_PrevAndNext(long orderId,
		long groupId, OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = findByPrimaryKey(orderId);

		Session session = null;

		try {
			session = openSession();

			ShoppingOrder[] array = new ShoppingOrderImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, shoppingOrder,
					groupId, orderByComparator, true);

			array[1] = shoppingOrder;

			array[2] = getByGroupId_PrevAndNext(session, shoppingOrder,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingOrder getByGroupId_PrevAndNext(Session session,
		ShoppingOrder shoppingOrder, long groupId,
		OrderByComparator<ShoppingOrder> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingOrder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Shopping Orders where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ShoppingOrder shoppingOrder : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(shoppingOrder);
		}
	}

	/**
	 * Returns the number of Shopping Orders where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching Shopping Orders
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "shoppingOrder.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDORDERSTATUS =
		new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupIdAndOrderStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDORDERSTATUS =
		new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdAndOrderStatus",
			new String[] { Long.class.getName(), String.class.getName() },
			ShoppingOrderModelImpl.GROUPID_COLUMN_BITMASK |
			ShoppingOrderModelImpl.ORDERSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDANDORDERSTATUS = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndOrderStatus",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the Shopping Orders where groupId = &#63; and orderStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @return the matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByGroupIdAndOrderStatus(long groupId,
		String orderStatus) {
		return findByGroupIdAndOrderStatus(groupId, orderStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Orders where groupId = &#63; and orderStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @return the range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByGroupIdAndOrderStatus(long groupId,
		String orderStatus, int start, int end) {
		return findByGroupIdAndOrderStatus(groupId, orderStatus, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders where groupId = &#63; and orderStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByGroupIdAndOrderStatus(long groupId,
		String orderStatus, int start, int end,
		OrderByComparator<ShoppingOrder> orderByComparator) {
		return findByGroupIdAndOrderStatus(groupId, orderStatus, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders where groupId = &#63; and orderStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findByGroupIdAndOrderStatus(long groupId,
		String orderStatus, int start, int end,
		OrderByComparator<ShoppingOrder> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDORDERSTATUS;
			finderArgs = new Object[] { groupId, orderStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDORDERSTATUS;
			finderArgs = new Object[] {
					groupId, orderStatus,
					
					start, end, orderByComparator
				};
		}

		List<ShoppingOrder> list = null;

		if (retrieveFromCache) {
			list = (List<ShoppingOrder>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ShoppingOrder shoppingOrder : list) {
					if ((groupId != shoppingOrder.getGroupId()) ||
							!Objects.equals(orderStatus,
								shoppingOrder.getOrderStatus())) {
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

			query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_GROUPID_2);

			boolean bindOrderStatus = false;

			if (orderStatus == null) {
				query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_1);
			}
			else if (orderStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_3);
			}
			else {
				bindOrderStatus = true;

				query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindOrderStatus) {
					qPos.add(orderStatus);
				}

				if (!pagination) {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order
	 * @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder findByGroupIdAndOrderStatus_First(long groupId,
		String orderStatus, OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = fetchByGroupIdAndOrderStatus_First(groupId,
				orderStatus, orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", orderStatus=");
		msg.append(orderStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the first Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder fetchByGroupIdAndOrderStatus_First(long groupId,
		String orderStatus, OrderByComparator<ShoppingOrder> orderByComparator) {
		List<ShoppingOrder> list = findByGroupIdAndOrderStatus(groupId,
				orderStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order
	 * @throws NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder findByGroupIdAndOrderStatus_Last(long groupId,
		String orderStatus, OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = fetchByGroupIdAndOrderStatus_Last(groupId,
				orderStatus, orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", orderStatus=");
		msg.append(orderStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the last Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 */
	@Override
	public ShoppingOrder fetchByGroupIdAndOrderStatus_Last(long groupId,
		String orderStatus, OrderByComparator<ShoppingOrder> orderByComparator) {
		int count = countByGroupIdAndOrderStatus(groupId, orderStatus);

		if (count == 0) {
			return null;
		}

		List<ShoppingOrder> list = findByGroupIdAndOrderStatus(groupId,
				orderStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Shopping Orders before and after the current Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63;.
	 *
	 * @param orderId the primary key of the current Shopping Order
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Shopping Order
	 * @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 */
	@Override
	public ShoppingOrder[] findByGroupIdAndOrderStatus_PrevAndNext(
		long orderId, long groupId, String orderStatus,
		OrderByComparator<ShoppingOrder> orderByComparator)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = findByPrimaryKey(orderId);

		Session session = null;

		try {
			session = openSession();

			ShoppingOrder[] array = new ShoppingOrderImpl[3];

			array[0] = getByGroupIdAndOrderStatus_PrevAndNext(session,
					shoppingOrder, groupId, orderStatus, orderByComparator, true);

			array[1] = shoppingOrder;

			array[2] = getByGroupIdAndOrderStatus_PrevAndNext(session,
					shoppingOrder, groupId, orderStatus, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingOrder getByGroupIdAndOrderStatus_PrevAndNext(
		Session session, ShoppingOrder shoppingOrder, long groupId,
		String orderStatus, OrderByComparator<ShoppingOrder> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_GROUPID_2);

		boolean bindOrderStatus = false;

		if (orderStatus == null) {
			query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_1);
		}
		else if (orderStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_3);
		}
		else {
			bindOrderStatus = true;

			query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_2);
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
			query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindOrderStatus) {
			qPos.add(orderStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingOrder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Shopping Orders where groupId = &#63; and orderStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 */
	@Override
	public void removeByGroupIdAndOrderStatus(long groupId, String orderStatus) {
		for (ShoppingOrder shoppingOrder : findByGroupIdAndOrderStatus(
				groupId, orderStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(shoppingOrder);
		}
	}

	/**
	 * Returns the number of Shopping Orders where groupId = &#63; and orderStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @return the number of matching Shopping Orders
	 */
	@Override
	public int countByGroupIdAndOrderStatus(long groupId, String orderStatus) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDANDORDERSTATUS;

		Object[] finderArgs = new Object[] { groupId, orderStatus };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_GROUPID_2);

			boolean bindOrderStatus = false;

			if (orderStatus == null) {
				query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_1);
			}
			else if (orderStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_3);
			}
			else {
				bindOrderStatus = true;

				query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindOrderStatus) {
					qPos.add(orderStatus);
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

	private static final String _FINDER_COLUMN_GROUPIDANDORDERSTATUS_GROUPID_2 = "shoppingOrder.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_1 =
		"shoppingOrder.orderStatus IS NULL";
	private static final String _FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_2 =
		"shoppingOrder.orderStatus = ?";
	private static final String _FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_3 =
		"(shoppingOrder.orderStatus IS NULL OR shoppingOrder.orderStatus = '')";

	public ShoppingOrderPersistenceImpl() {
		setModelClass(ShoppingOrder.class);
	}

	/**
	 * Caches the Shopping Order in the entity cache if it is enabled.
	 *
	 * @param shoppingOrder the Shopping Order
	 */
	@Override
	public void cacheResult(ShoppingOrder shoppingOrder) {
		entityCache.putResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderImpl.class, shoppingOrder.getPrimaryKey(),
			shoppingOrder);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { shoppingOrder.getUuid(), shoppingOrder.getGroupId() },
			shoppingOrder);

		shoppingOrder.resetOriginalValues();
	}

	/**
	 * Caches the Shopping Orders in the entity cache if it is enabled.
	 *
	 * @param shoppingOrders the Shopping Orders
	 */
	@Override
	public void cacheResult(List<ShoppingOrder> shoppingOrders) {
		for (ShoppingOrder shoppingOrder : shoppingOrders) {
			if (entityCache.getResult(
						ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingOrderImpl.class, shoppingOrder.getPrimaryKey()) == null) {
				cacheResult(shoppingOrder);
			}
			else {
				shoppingOrder.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Shopping Orders.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ShoppingOrderImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Shopping Order.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ShoppingOrder shoppingOrder) {
		entityCache.removeResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderImpl.class, shoppingOrder.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ShoppingOrderModelImpl)shoppingOrder);
	}

	@Override
	public void clearCache(List<ShoppingOrder> shoppingOrders) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ShoppingOrder shoppingOrder : shoppingOrders) {
			entityCache.removeResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingOrderImpl.class, shoppingOrder.getPrimaryKey());

			clearUniqueFindersCache((ShoppingOrderModelImpl)shoppingOrder);
		}
	}

	protected void cacheUniqueFindersCache(
		ShoppingOrderModelImpl shoppingOrderModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					shoppingOrderModelImpl.getUuid(),
					shoppingOrderModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				shoppingOrderModelImpl);
		}
		else {
			if ((shoppingOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderModelImpl.getUuid(),
						shoppingOrderModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					shoppingOrderModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ShoppingOrderModelImpl shoppingOrderModelImpl) {
		Object[] args = new Object[] {
				shoppingOrderModelImpl.getUuid(),
				shoppingOrderModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((shoppingOrderModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					shoppingOrderModelImpl.getOriginalUuid(),
					shoppingOrderModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new Shopping Order with the primary key. Does not add the Shopping Order to the database.
	 *
	 * @param orderId the primary key for the new Shopping Order
	 * @return the new Shopping Order
	 */
	@Override
	public ShoppingOrder create(long orderId) {
		ShoppingOrder shoppingOrder = new ShoppingOrderImpl();

		shoppingOrder.setNew(true);
		shoppingOrder.setPrimaryKey(orderId);

		String uuid = PortalUUIDUtil.generate();

		shoppingOrder.setUuid(uuid);

		shoppingOrder.setCompanyId(companyProvider.getCompanyId());

		return shoppingOrder;
	}

	/**
	 * Removes the Shopping Order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orderId the primary key of the Shopping Order
	 * @return the Shopping Order that was removed
	 * @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 */
	@Override
	public ShoppingOrder remove(long orderId)
		throws NoSuchShoppingOrderException {
		return remove((Serializable)orderId);
	}

	/**
	 * Removes the Shopping Order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Shopping Order
	 * @return the Shopping Order that was removed
	 * @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 */
	@Override
	public ShoppingOrder remove(Serializable primaryKey)
		throws NoSuchShoppingOrderException {
		Session session = null;

		try {
			session = openSession();

			ShoppingOrder shoppingOrder = (ShoppingOrder)session.get(ShoppingOrderImpl.class,
					primaryKey);

			if (shoppingOrder == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShoppingOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(shoppingOrder);
		}
		catch (NoSuchShoppingOrderException nsee) {
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
	protected ShoppingOrder removeImpl(ShoppingOrder shoppingOrder) {
		shoppingOrder = toUnwrappedModel(shoppingOrder);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(shoppingOrder)) {
				shoppingOrder = (ShoppingOrder)session.get(ShoppingOrderImpl.class,
						shoppingOrder.getPrimaryKeyObj());
			}

			if (shoppingOrder != null) {
				session.delete(shoppingOrder);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (shoppingOrder != null) {
			clearCache(shoppingOrder);
		}

		return shoppingOrder;
	}

	@Override
	public ShoppingOrder updateImpl(ShoppingOrder shoppingOrder) {
		shoppingOrder = toUnwrappedModel(shoppingOrder);

		boolean isNew = shoppingOrder.isNew();

		ShoppingOrderModelImpl shoppingOrderModelImpl = (ShoppingOrderModelImpl)shoppingOrder;

		if (Validator.isNull(shoppingOrder.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			shoppingOrder.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (shoppingOrder.getCreateDate() == null)) {
			if (serviceContext == null) {
				shoppingOrder.setCreateDate(now);
			}
			else {
				shoppingOrder.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!shoppingOrderModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				shoppingOrder.setModifiedDate(now);
			}
			else {
				shoppingOrder.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (shoppingOrder.isNew()) {
				session.save(shoppingOrder);

				shoppingOrder.setNew(false);
			}
			else {
				shoppingOrder = (ShoppingOrder)session.merge(shoppingOrder);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ShoppingOrderModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((shoppingOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { shoppingOrderModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((shoppingOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderModelImpl.getOriginalUuid(),
						shoppingOrderModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						shoppingOrderModelImpl.getUuid(),
						shoppingOrderModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((shoppingOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERSTATUSANDUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderModelImpl.getOriginalOrderStatus(),
						shoppingOrderModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORDERSTATUSANDUSERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERSTATUSANDUSERID,
					args);

				args = new Object[] {
						shoppingOrderModelImpl.getOrderStatus(),
						shoppingOrderModelImpl.getUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORDERSTATUSANDUSERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERSTATUSANDUSERID,
					args);
			}

			if ((shoppingOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPORDERSTATUSANDUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderModelImpl.getOriginalGroupId(),
						shoppingOrderModelImpl.getOriginalOrderStatus(),
						shoppingOrderModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPORDERSTATUSANDUSERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPORDERSTATUSANDUSERID,
					args);

				args = new Object[] {
						shoppingOrderModelImpl.getGroupId(),
						shoppingOrderModelImpl.getOrderStatus(),
						shoppingOrderModelImpl.getUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPORDERSTATUSANDUSERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPORDERSTATUSANDUSERID,
					args);
			}

			if ((shoppingOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { shoppingOrderModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((shoppingOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDORDERSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderModelImpl.getOriginalGroupId(),
						shoppingOrderModelImpl.getOriginalOrderStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDORDERSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDORDERSTATUS,
					args);

				args = new Object[] {
						shoppingOrderModelImpl.getGroupId(),
						shoppingOrderModelImpl.getOrderStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDORDERSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDORDERSTATUS,
					args);
			}
		}

		entityCache.putResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderImpl.class, shoppingOrder.getPrimaryKey(),
			shoppingOrder, false);

		clearUniqueFindersCache(shoppingOrderModelImpl);
		cacheUniqueFindersCache(shoppingOrderModelImpl, isNew);

		shoppingOrder.resetOriginalValues();

		return shoppingOrder;
	}

	protected ShoppingOrder toUnwrappedModel(ShoppingOrder shoppingOrder) {
		if (shoppingOrder instanceof ShoppingOrderImpl) {
			return shoppingOrder;
		}

		ShoppingOrderImpl shoppingOrderImpl = new ShoppingOrderImpl();

		shoppingOrderImpl.setNew(shoppingOrder.isNew());
		shoppingOrderImpl.setPrimaryKey(shoppingOrder.getPrimaryKey());

		shoppingOrderImpl.setUuid(shoppingOrder.getUuid());
		shoppingOrderImpl.setOrderId(shoppingOrder.getOrderId());
		shoppingOrderImpl.setGroupId(shoppingOrder.getGroupId());
		shoppingOrderImpl.setCompanyId(shoppingOrder.getCompanyId());
		shoppingOrderImpl.setUserId(shoppingOrder.getUserId());
		shoppingOrderImpl.setCreateDate(shoppingOrder.getCreateDate());
		shoppingOrderImpl.setModifiedDate(shoppingOrder.getModifiedDate());
		shoppingOrderImpl.setOrderStatus(shoppingOrder.getOrderStatus());
		shoppingOrderImpl.setCustomerEmail(shoppingOrder.getCustomerEmail());
		shoppingOrderImpl.setCustomerName(shoppingOrder.getCustomerName());
		shoppingOrderImpl.setCustomerPhone(shoppingOrder.getCustomerPhone());
		shoppingOrderImpl.setShippingAddress1(shoppingOrder.getShippingAddress1());
		shoppingOrderImpl.setShippingAddress2(shoppingOrder.getShippingAddress2());
		shoppingOrderImpl.setShippingCity(shoppingOrder.getShippingCity());
		shoppingOrderImpl.setShippingPostalCode(shoppingOrder.getShippingPostalCode());
		shoppingOrderImpl.setShippingStateProvince(shoppingOrder.getShippingStateProvince());
		shoppingOrderImpl.setShippingCountry(shoppingOrder.getShippingCountry());
		shoppingOrderImpl.setTotal(shoppingOrder.getTotal());
		shoppingOrderImpl.setNotes(shoppingOrder.getNotes());

		return shoppingOrderImpl;
	}

	/**
	 * Returns the Shopping Order with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Shopping Order
	 * @return the Shopping Order
	 * @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 */
	@Override
	public ShoppingOrder findByPrimaryKey(Serializable primaryKey)
		throws NoSuchShoppingOrderException {
		ShoppingOrder shoppingOrder = fetchByPrimaryKey(primaryKey);

		if (shoppingOrder == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchShoppingOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return shoppingOrder;
	}

	/**
	 * Returns the Shopping Order with the primary key or throws a {@link NoSuchShoppingOrderException} if it could not be found.
	 *
	 * @param orderId the primary key of the Shopping Order
	 * @return the Shopping Order
	 * @throws NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 */
	@Override
	public ShoppingOrder findByPrimaryKey(long orderId)
		throws NoSuchShoppingOrderException {
		return findByPrimaryKey((Serializable)orderId);
	}

	/**
	 * Returns the Shopping Order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Shopping Order
	 * @return the Shopping Order, or <code>null</code> if a Shopping Order with the primary key could not be found
	 */
	@Override
	public ShoppingOrder fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingOrderImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ShoppingOrder shoppingOrder = (ShoppingOrder)serializable;

		if (shoppingOrder == null) {
			Session session = null;

			try {
				session = openSession();

				shoppingOrder = (ShoppingOrder)session.get(ShoppingOrderImpl.class,
						primaryKey);

				if (shoppingOrder != null) {
					cacheResult(shoppingOrder);
				}
				else {
					entityCache.putResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingOrderImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
					ShoppingOrderImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return shoppingOrder;
	}

	/**
	 * Returns the Shopping Order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param orderId the primary key of the Shopping Order
	 * @return the Shopping Order, or <code>null</code> if a Shopping Order with the primary key could not be found
	 */
	@Override
	public ShoppingOrder fetchByPrimaryKey(long orderId) {
		return fetchByPrimaryKey((Serializable)orderId);
	}

	@Override
	public Map<Serializable, ShoppingOrder> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ShoppingOrder> map = new HashMap<Serializable, ShoppingOrder>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ShoppingOrder shoppingOrder = fetchByPrimaryKey(primaryKey);

			if (shoppingOrder != null) {
				map.put(primaryKey, shoppingOrder);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
					ShoppingOrderImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ShoppingOrder)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SHOPPINGORDER_WHERE_PKS_IN);

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

			for (ShoppingOrder shoppingOrder : (List<ShoppingOrder>)q.list()) {
				map.put(shoppingOrder.getPrimaryKeyObj(), shoppingOrder);

				cacheResult(shoppingOrder);

				uncachedPrimaryKeys.remove(shoppingOrder.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
					ShoppingOrderImpl.class, primaryKey, nullModel);
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
	 * Returns all the Shopping Orders.
	 *
	 * @return the Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @return the range of Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findAll(int start, int end,
		OrderByComparator<ShoppingOrder> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of Shopping Orders
	 */
	@Override
	public List<ShoppingOrder> findAll(int start, int end,
		OrderByComparator<ShoppingOrder> orderByComparator,
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

		List<ShoppingOrder> list = null;

		if (retrieveFromCache) {
			list = (List<ShoppingOrder>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SHOPPINGORDER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHOPPINGORDER;

				if (pagination) {
					sql = sql.concat(ShoppingOrderModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the Shopping Orders from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ShoppingOrder shoppingOrder : findAll()) {
			remove(shoppingOrder);
		}
	}

	/**
	 * Returns the number of Shopping Orders.
	 *
	 * @return the number of Shopping Orders
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SHOPPINGORDER);

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
		return ShoppingOrderModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the Shopping Order persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ShoppingOrderImpl.class.getName());
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
	private static final String _SQL_SELECT_SHOPPINGORDER = "SELECT shoppingOrder FROM ShoppingOrder shoppingOrder";
	private static final String _SQL_SELECT_SHOPPINGORDER_WHERE_PKS_IN = "SELECT shoppingOrder FROM ShoppingOrder shoppingOrder WHERE orderId IN (";
	private static final String _SQL_SELECT_SHOPPINGORDER_WHERE = "SELECT shoppingOrder FROM ShoppingOrder shoppingOrder WHERE ";
	private static final String _SQL_COUNT_SHOPPINGORDER = "SELECT COUNT(shoppingOrder) FROM ShoppingOrder shoppingOrder";
	private static final String _SQL_COUNT_SHOPPINGORDER_WHERE = "SELECT COUNT(shoppingOrder) FROM ShoppingOrder shoppingOrder WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingOrder.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingOrder exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingOrder exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ShoppingOrderPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}