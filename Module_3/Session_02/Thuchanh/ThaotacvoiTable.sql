
use session_02;
create table contacts
( contact_id INT(11) NOT NULL auto_increment,
last_name varchar(30) not null,
first_name varchar(25),
birthday date,
constraint contacts_pk primary key (contact_id)
);

create table suppliers
( supplier_id int(11) not null auto_increment,
supplier_name varchar(50) not null,
account_rep varchar(30) not null default 'TBD',
constraint suppliers_pk primary key (supplier_id)
);

alter table contacts
add old_name varchar(40) not null
after contact_id;

