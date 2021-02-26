use session_02;
create table customersbank(
customer_number int(255) not null primary key,
fullname varchar(50) not null,
address varchar(50) not null,
email varchar(255) not null,
phone int(30) not null
);

create table accounts(
account_number int(30) not null primary key,
account_type varchar(20) not null,
open_card date,
balance double,
customer_number int, foreign key (customer_number) references customers(customer_number)
);

create table transactions(
tran_number int(50) not null primary key,
date_transaction date,
amount double,
descriptions varchar(255),
account_number int(30), foreign key (account_number) references accounts(account_number)
);


