
create database furama_management;
use furama_management;
create table positions(
position_id int not null auto_increment primary key,
position_name varchar(45) not null
);

create table education_degree(
education_degree_id int not null auto_increment primary key,
education_degree_name varchar(45)
);

create table division(
division_id int not null auto_increment primary key,
division_name varchar(255) not null
);

create table role(
role_id int not null primary key,
role_name varchar(255) not null
);

create table user(
`username` varchar(255) primary key,
`password` varchar(255)
);

create table user_role(
role_id int,
`username` varchar(255),
primary key (role_id,username),
foreign key(role_id) references role(role_id) on update cascade on delete cascade,
foreign key(`username`) references user(`username`) on update cascade on delete cascade
);

create table employee(
employee_id int not null auto_increment primary key,
employee_name varchar(45) not null,
employee_birthday date not null,
employee_id_card varchar(45) not null,
employee_salary double,
employee_phone varchar(45),
employee_email varchar(45),
employee_address varchar(45),
position_id int, foreign key(position_id) references positions(position_id) on update cascade on delete cascade,
 education_degree_id int, foreign key(education_degree_id) references education_degree(education_degree_id) on update cascade on delete cascade,
 division_id int, foreign key(division_id) references division(division_id) on update cascade on delete cascade,
 `username` varchar(255), foreign key(`username`) references user(`username`) on update cascade on delete cascade
);


create table customer_type(
customer_type_id int auto_increment not null primary key,
customer_type_name varchar(45) not null
);

create table customer(
customer_id varchar(255) not null primary key,
customer_name varchar(45) not null,
customer_birthday date not null,
customer_gender varchar(10) not null,
customer_id_card varchar(45) not null,
customer_phone varchar(45),
customer_email varchar(45),
customer_address varchar(45),
customer_type_id int, foreign key (customer_type_id) references customer_type(customer_type_id) on update cascade on delete cascade
);


create table service_type(
service_type_id int auto_increment not null primary key,
service_type_name varchar(45)
);


create table rent_type(
rent_type_id int auto_increment not null primary key,
rent_type_name varchar(45) not null,
rent_type_cost double not null
);


create table service(
service_id varchar(255) not null primary key,
service_name varchar(45) not null,
service_area int,
service_cost double,
service_max_people int,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int,
rent_type_id int, foreign key (rent_type_id) references rent_type(rent_type_id) on update cascade on delete cascade, 
service_type_id int, foreign key (service_type_id) references service_type(service_type_id) on update cascade on delete cascade
);

create table attach_service(
attach_service_id int auto_increment not null primary key,
attach_service_name varchar(45) not null,
attach_service_cost double not null,
attach_service_unit varchar(50) not null,
attach_service_status varchar(45)
);


create table contract(
contract_id int auto_increment not null primary key,
contract_start_date datetime,
contract_end_date datetime,
contract_deposit double,
contract_total_money double,
employee_id int, foreign key(employee_id) references employee(employee_id) on update cascade on delete cascade,
customer_id varchar(255), foreign key(customer_id) references customer(customer_id) on update cascade on delete cascade,
service_id varchar(255), foreign key(service_id) references service(service_id) on update cascade on delete cascade
);


create table contract_detail(
contract_detail_id int auto_increment not null primary key,
quantity int,
attach_service_id int, foreign key(attach_service_id) references attach_service(attach_service_id) on update cascade on delete cascade,
contract_id int, foreign key(contract_id) references contract(contract_id) on update cascade on delete cascade
);



insert into positions(position_name)
values ("Lễ Tân"), ("Phục Vụ"), ("Chuyên Viên"),
("Giám sát"),("Quản Lý"), ("Giám đốc");

insert into education_degree(education_degree_name)
values ("Trung Cấp"), ("Cao Đẳng"), 
("Đại học"), ("Sau đại học");

insert into division(division_name)
values ("Sale - Marketing"), ("Hành chính"), 
("Phục vụ"), ("Quản lý");

insert into user(`username`,`password`)
values ('bao ngoc', '12345'),
 ('quoc hoang', '12345'),
 ('van phuc', '12345'),
 ('luon sang', '12345'),
 ('le quang', '12345'),
 ('ngoc thuan', '12345');
 
 insert into employee(employee_name,employee_birthday,employee_id_card,
employee_salary,employee_phone,employee_email,employee_address,
position_id, education_degree_id,division_id, username)
values ('Nguyen Hoang Bao Ngoc','1996-12-13','2132323',1000.0,'01233112','nguyenhoangbaongoc@gmail.com','Hue',6,4,2,'bao ngoc'),
		('Tran Quoc Hoang','1994-07-05','2133222',800.0,'02313211','tranquochoang@gmail.com','Quang Nam',2,1,4,'quoc hoang'),
		('Le Van Phuc','1997-11-22','4531223',400.0,'032122323','levanphuc@gmail.com','Tay Ninh',1,3,3,'van phuc'),
		('Tran Hoang Sang','1996-08-28','7989789',400.0,'031213232','tranhoangsang@gmail.com','Nghe An',2,1,1,'luon sang'),
		('Hoang Le Quang','1991-12-23','13232331',900.0,'033211312','hoanglequang@gmail.com','Nghe An',5,4,3,'le quang'),
		('Nguyen Ngoc Thuan','2000-10-03','11333121',200.0,'01233112','ngocthuan@gmail.com','Hoi An',2,3,4,'ngoc thuan');
        
insert into customer_type(customer_type_name)
values ('Diamond'),('Platiumn'),('Gold'),('Silver'),('Member');
insert into customer(customer_id, customer_name, customer_birthday,
customer_gender,customer_id_card, customer_phone, customer_email, customer_address, customer_type_id)
values	('KH-0001','Luon Sang', '1994-02-05', 'Male','32131311', '032132131', 'sanggay@gmail.com', 'Da Nang',1),
		('KH-0002','Nguyen Thanh Tung', '1993-05-21', 'Male','7987978', '051331232', 'nguyenthanhtung@gmail.com', 'Da Nang',2),
		('KH-0003','Nguyen Ngoc Dong', '1999-01-18', 'Female','98799797', '0121323321', 'ngocdong@gmail.com', 'Quang Nam',2),
		('KH-0004','Ho Nhat Long', '1995-11-24', 'Male','98798988', '03213112312', 'nhatlong@gmail.com', 'Quang Ngai',1),
		('KH-0005','Nguyen Tuong Vi', '1994-09-11', 'Female','87879797', '032132131', 'tuongvi@gmail.com', 'Da Nang',1);
insert into service_type(service_type_name)
values ("Villa"), ("House"), ("Room");

insert into rent_type(rent_type_name, rent_type_cost)
values ('BY HOUR', 100),
		('BY DAY', 300),
		('BY MONTH', 400),
		('BY YEAR', 450);
insert into service(service_id,service_name,service_area, service_cost,
service_max_people, standard_room, description_other_convenience,
pool_area, number_of_floors, rent_type_id, service_type_id)
values ('DV-1234','Villa Cassinella',200.0,1000,4,'Vip','excellent',30.0,3,4,1),
		('DV-1111','Villa Poletti',300.0,2000,4,'Presidental','romantic',35.0,3,3,1),
		('DV-2222','Orchard House',75.0,800,5,'Luxurious','peaceful',20.0,1,2,2),
		('DV-2323','Corner House',100,1000,5,'Standard','natural',20.0,2,3,2),
		('DV-3331','Ideation Zone',40,200,2,'Collaborative','nothing',null,1,1,3),
		('DV-1212','Gathering Field',45,250,2,'Social ','nothing',null,1,2,3);
        
insert into attach_service( attach_service_name,
attach_service_cost, attach_service_unit, attach_service_status)
values ('karaoke',10.00,'USD','available'),
		('massage',15.00,'USD', 'available'),
		('car rental',12.00,'USD', 'available'),
		('beverage',5.00,'USD', 'available'),
		('food',8.00,'USD', 'available');
        
insert into contract(contract_start_date, contract_end_date, contract_deposit, 
contract_total_money, employee_id, customer_id, service_id)
values ('2020-01-01', '2020-01-15', 500, 1500, 1, 'KH-0001', 'DV-1234'),
		('2020-03-10', '2020-04-10', 700, 2300, 2, 'KH-0002', 'DV-1111'),
		('2020-11-02', '2020-12-15', 1000, 3500, 3, 'KH-0003', 'DV-2222'),
		('2019-05-20', '2019-07-20', 800, 2300, 5, 'KH-0004', 'DV-2323'),
		('2018-09-01', '2019-09-29', 750, 1800, 4, 'KH-0002', 'DV-3331'),
		('2020-10-20', '2020-10-23', 200, 900, 6, 'KH-0005', 'DV-1212');
        
insert into contract_detail(quantity, attach_service_id, contract_id)
values
			(3,1,1),
			(5,2,2),
			(4,3,3),
			(1,3,4),
			(3,5,5),
			(8,4,5),
			(4,2,6),
			(2,1,6),
			(3,5,4),
			(5,4,4),
			(7,3,2),
			(3,2,2),
			(4,1,1);
