create table rivetlogic_ecommerce_Notification (
	uuid_ VARCHAR(75) null,
	notificationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	orderId LONG,
	subject VARCHAR(75) null,
	body TEXT null,
	sender VARCHAR(75) null,
	recipients VARCHAR(75) null
);

create table rivetlogic_ecommerce_ShoppingOrder (
	uuid_ VARCHAR(75) null,
	orderId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	orderStatus VARCHAR(75) null,
	customerEmail VARCHAR(75) null,
	customerName VARCHAR(75) null,
	customerPhone VARCHAR(75) null,
	shippingAddress1 VARCHAR(75) null,
	shippingAddress2 VARCHAR(75) null,
	shippingCity VARCHAR(75) null,
	shippingPostalCode VARCHAR(75) null,
	shippingStateProvince VARCHAR(75) null,
	shippingCountry VARCHAR(75) null,
	total DOUBLE,
	notes VARCHAR(75) null
);

create table rivetlogic_ecommerce_ShoppingOrderItem (
	uuid_ VARCHAR(75) null,
	itemId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	orderId LONG,
	productId VARCHAR(75) null,
	quantity INTEGER,
	price DOUBLE
);