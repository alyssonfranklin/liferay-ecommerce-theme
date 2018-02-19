create index IX_11014B9A on rivetlogic_ecommerce_Notification (orderId);
create index IX_7C7A0173 on rivetlogic_ecommerce_Notification (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_E76A48B5 on rivetlogic_ecommerce_Notification (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D2AC51DE on rivetlogic_ecommerce_ShoppingOrder (groupId, orderStatus[$COLUMN_LENGTH:75$], userId);
create index IX_419C748C on rivetlogic_ecommerce_ShoppingOrder (orderStatus[$COLUMN_LENGTH:75$], userId);
create index IX_F1C845F2 on rivetlogic_ecommerce_ShoppingOrder (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_802DA0F4 on rivetlogic_ecommerce_ShoppingOrder (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D4121772 on rivetlogic_ecommerce_ShoppingOrderItem (orderId, productId[$COLUMN_LENGTH:75$]);
create index IX_51BD01A5 on rivetlogic_ecommerce_ShoppingOrderItem (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1973AD67 on rivetlogic_ecommerce_ShoppingOrderItem (uuid_[$COLUMN_LENGTH:75$], groupId);