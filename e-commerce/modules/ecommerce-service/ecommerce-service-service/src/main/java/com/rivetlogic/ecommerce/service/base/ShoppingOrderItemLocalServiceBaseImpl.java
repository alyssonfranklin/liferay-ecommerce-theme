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

package com.rivetlogic.ecommerce.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.rivetlogic.ecommerce.model.ShoppingOrderItem;
import com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalService;
import com.rivetlogic.ecommerce.service.persistence.NotificationPersistence;
import com.rivetlogic.ecommerce.service.persistence.ShoppingOrderItemPersistence;
import com.rivetlogic.ecommerce.service.persistence.ShoppingOrderPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the Shopping Order Item local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rivetlogic.ecommerce.service.impl.ShoppingOrderItemLocalServiceImpl}.
 * </p>
 *
 * @author rivetlogic
 * @see com.rivetlogic.ecommerce.service.impl.ShoppingOrderItemLocalServiceImpl
 * @see com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class ShoppingOrderItemLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ShoppingOrderItemLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil} to access the Shopping Order Item local service.
	 */

	/**
	 * Adds the Shopping Order Item to the database. Also notifies the appropriate model listeners.
	 *
	 * @param shoppingOrderItem the Shopping Order Item
	 * @return the Shopping Order Item that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ShoppingOrderItem addShoppingOrderItem(
		ShoppingOrderItem shoppingOrderItem) {
		shoppingOrderItem.setNew(true);

		return shoppingOrderItemPersistence.update(shoppingOrderItem);
	}

	/**
	 * Creates a new Shopping Order Item with the primary key. Does not add the Shopping Order Item to the database.
	 *
	 * @param itemId the primary key for the new Shopping Order Item
	 * @return the new Shopping Order Item
	 */
	@Override
	public ShoppingOrderItem createShoppingOrderItem(long itemId) {
		return shoppingOrderItemPersistence.create(itemId);
	}

	/**
	 * Deletes the Shopping Order Item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemId the primary key of the Shopping Order Item
	 * @return the Shopping Order Item that was removed
	 * @throws PortalException if a Shopping Order Item with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ShoppingOrderItem deleteShoppingOrderItem(long itemId)
		throws PortalException {
		return shoppingOrderItemPersistence.remove(itemId);
	}

	/**
	 * Deletes the Shopping Order Item from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shoppingOrderItem the Shopping Order Item
	 * @return the Shopping Order Item that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ShoppingOrderItem deleteShoppingOrderItem(
		ShoppingOrderItem shoppingOrderItem) {
		return shoppingOrderItemPersistence.remove(shoppingOrderItem);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ShoppingOrderItem.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return shoppingOrderItemPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return shoppingOrderItemPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return shoppingOrderItemPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return shoppingOrderItemPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return shoppingOrderItemPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ShoppingOrderItem fetchShoppingOrderItem(long itemId) {
		return shoppingOrderItemPersistence.fetchByPrimaryKey(itemId);
	}

	/**
	 * Returns the Shopping Order Item matching the UUID and group.
	 *
	 * @param uuid the Shopping Order Item's UUID
	 * @param groupId the primary key of the group
	 * @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem fetchShoppingOrderItemByUuidAndGroupId(
		String uuid, long groupId) {
		return shoppingOrderItemPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the Shopping Order Item with the primary key.
	 *
	 * @param itemId the primary key of the Shopping Order Item
	 * @return the Shopping Order Item
	 * @throws PortalException if a Shopping Order Item with the primary key could not be found
	 */
	@Override
	public ShoppingOrderItem getShoppingOrderItem(long itemId)
		throws PortalException {
		return shoppingOrderItemPersistence.findByPrimaryKey(itemId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(shoppingOrderItemLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ShoppingOrderItem.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("itemId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(shoppingOrderItemLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ShoppingOrderItem.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("itemId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(shoppingOrderItemLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ShoppingOrderItem.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("itemId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType,
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType,
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(dynamicQuery,
						"modifiedDate");
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<ShoppingOrderItem>() {
				@Override
				public void performAction(ShoppingOrderItem shoppingOrderItem)
					throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						shoppingOrderItem);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(ShoppingOrderItem.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return shoppingOrderItemLocalService.deleteShoppingOrderItem((ShoppingOrderItem)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return shoppingOrderItemPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the Shopping Order Items matching the UUID and company.
	 *
	 * @param uuid the UUID of the Shopping Order Items
	 * @param companyId the primary key of the company
	 * @return the matching Shopping Order Items, or an empty list if no matches were found
	 */
	@Override
	public List<ShoppingOrderItem> getShoppingOrderItemsByUuidAndCompanyId(
		String uuid, long companyId) {
		return shoppingOrderItemPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of Shopping Order Items matching the UUID and company.
	 *
	 * @param uuid the UUID of the Shopping Order Items
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching Shopping Order Items, or an empty list if no matches were found
	 */
	@Override
	public List<ShoppingOrderItem> getShoppingOrderItemsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ShoppingOrderItem> orderByComparator) {
		return shoppingOrderItemPersistence.findByUuid_C(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	 * Returns the Shopping Order Item matching the UUID and group.
	 *
	 * @param uuid the Shopping Order Item's UUID
	 * @param groupId the primary key of the group
	 * @return the matching Shopping Order Item
	 * @throws PortalException if a matching Shopping Order Item could not be found
	 */
	@Override
	public ShoppingOrderItem getShoppingOrderItemByUuidAndGroupId(String uuid,
		long groupId) throws PortalException {
		return shoppingOrderItemPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the Shopping Order Items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @return the range of Shopping Order Items
	 */
	@Override
	public List<ShoppingOrderItem> getShoppingOrderItems(int start, int end) {
		return shoppingOrderItemPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of Shopping Order Items.
	 *
	 * @return the number of Shopping Order Items
	 */
	@Override
	public int getShoppingOrderItemsCount() {
		return shoppingOrderItemPersistence.countAll();
	}

	/**
	 * Updates the Shopping Order Item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param shoppingOrderItem the Shopping Order Item
	 * @return the Shopping Order Item that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ShoppingOrderItem updateShoppingOrderItem(
		ShoppingOrderItem shoppingOrderItem) {
		return shoppingOrderItemPersistence.update(shoppingOrderItem);
	}

	/**
	 * Returns the notification local service.
	 *
	 * @return the notification local service
	 */
	public com.rivetlogic.ecommerce.service.NotificationLocalService getNotificationLocalService() {
		return notificationLocalService;
	}

	/**
	 * Sets the notification local service.
	 *
	 * @param notificationLocalService the notification local service
	 */
	public void setNotificationLocalService(
		com.rivetlogic.ecommerce.service.NotificationLocalService notificationLocalService) {
		this.notificationLocalService = notificationLocalService;
	}

	/**
	 * Returns the notification persistence.
	 *
	 * @return the notification persistence
	 */
	public NotificationPersistence getNotificationPersistence() {
		return notificationPersistence;
	}

	/**
	 * Sets the notification persistence.
	 *
	 * @param notificationPersistence the notification persistence
	 */
	public void setNotificationPersistence(
		NotificationPersistence notificationPersistence) {
		this.notificationPersistence = notificationPersistence;
	}

	/**
	 * Returns the Shopping Order local service.
	 *
	 * @return the Shopping Order local service
	 */
	public com.rivetlogic.ecommerce.service.ShoppingOrderLocalService getShoppingOrderLocalService() {
		return shoppingOrderLocalService;
	}

	/**
	 * Sets the Shopping Order local service.
	 *
	 * @param shoppingOrderLocalService the Shopping Order local service
	 */
	public void setShoppingOrderLocalService(
		com.rivetlogic.ecommerce.service.ShoppingOrderLocalService shoppingOrderLocalService) {
		this.shoppingOrderLocalService = shoppingOrderLocalService;
	}

	/**
	 * Returns the Shopping Order persistence.
	 *
	 * @return the Shopping Order persistence
	 */
	public ShoppingOrderPersistence getShoppingOrderPersistence() {
		return shoppingOrderPersistence;
	}

	/**
	 * Sets the Shopping Order persistence.
	 *
	 * @param shoppingOrderPersistence the Shopping Order persistence
	 */
	public void setShoppingOrderPersistence(
		ShoppingOrderPersistence shoppingOrderPersistence) {
		this.shoppingOrderPersistence = shoppingOrderPersistence;
	}

	/**
	 * Returns the Shopping Order Item local service.
	 *
	 * @return the Shopping Order Item local service
	 */
	public ShoppingOrderItemLocalService getShoppingOrderItemLocalService() {
		return shoppingOrderItemLocalService;
	}

	/**
	 * Sets the Shopping Order Item local service.
	 *
	 * @param shoppingOrderItemLocalService the Shopping Order Item local service
	 */
	public void setShoppingOrderItemLocalService(
		ShoppingOrderItemLocalService shoppingOrderItemLocalService) {
		this.shoppingOrderItemLocalService = shoppingOrderItemLocalService;
	}

	/**
	 * Returns the Shopping Order Item persistence.
	 *
	 * @return the Shopping Order Item persistence
	 */
	public ShoppingOrderItemPersistence getShoppingOrderItemPersistence() {
		return shoppingOrderItemPersistence;
	}

	/**
	 * Sets the Shopping Order Item persistence.
	 *
	 * @param shoppingOrderItemPersistence the Shopping Order Item persistence
	 */
	public void setShoppingOrderItemPersistence(
		ShoppingOrderItemPersistence shoppingOrderItemPersistence) {
		this.shoppingOrderItemPersistence = shoppingOrderItemPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.rivetlogic.ecommerce.model.ShoppingOrderItem",
			shoppingOrderItemLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.rivetlogic.ecommerce.model.ShoppingOrderItem");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ShoppingOrderItemLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ShoppingOrderItem.class;
	}

	protected String getModelClassName() {
		return ShoppingOrderItem.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = shoppingOrderItemPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rivetlogic.ecommerce.service.NotificationLocalService.class)
	protected com.rivetlogic.ecommerce.service.NotificationLocalService notificationLocalService;
	@BeanReference(type = NotificationPersistence.class)
	protected NotificationPersistence notificationPersistence;
	@BeanReference(type = com.rivetlogic.ecommerce.service.ShoppingOrderLocalService.class)
	protected com.rivetlogic.ecommerce.service.ShoppingOrderLocalService shoppingOrderLocalService;
	@BeanReference(type = ShoppingOrderPersistence.class)
	protected ShoppingOrderPersistence shoppingOrderPersistence;
	@BeanReference(type = ShoppingOrderItemLocalService.class)
	protected ShoppingOrderItemLocalService shoppingOrderItemLocalService;
	@BeanReference(type = ShoppingOrderItemPersistence.class)
	protected ShoppingOrderItemPersistence shoppingOrderItemPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}