use session_02;
create table customerProducts(
customerNumber int(30) not null primary key,
customerName varchar(255) not null,
contactLastName varchar(50) not null,
contactFirstName varchar(50) not null,
phone int(20) not null,
addressLine1 varchar(50) not null, 
addressLine2 varchar(50),
city varchar(50) not null,
state varchar(50) not null,
postalCode varchar(15) not null,
country varchar(50) not null,
creditLimit double
);

create table productsLines(
productLine varchar(50) not null,
textDescription text,
image text
);

create table productCars(
productCode varchar(15) not null,
productName varchar(70) not null,
productScale varchar(10) not null,
productDEscription text not null,
quantityInStock int not null,
buyPrice double not null,
MSRP double not null
);

create table orderProducts(
orderNumber int not null,
orderDate date not null,
requiredDate date,
status varchar(15) not null,
comments text,
quantityOdered int not null,
priceEach double not null,
customerNumber int(30),  foreign key (customerNumber) references customerProducts(customerNumber)
);

create table paymentsProduct(
customerNumber int not null,
checkNumber varchar(50) not null,
paymentDate date not null,
amount double not null
);

create table employees(
id_employees int not null,
name_employees varchar(255) not null,
email varchar(255) not null,
name_work varchar(50) not null
);

create table offices(
officeCode varchar(10) not null,
city varchar(50) not null,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50),
state varchar(50),
country varchar(50) not null,
postalCode varchar(15) not null
);