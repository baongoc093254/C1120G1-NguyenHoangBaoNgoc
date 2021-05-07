
create database test2;
create table Product(
idproduct int not null auto_increment primary key,
nameproduct varchar(50) not null,
price double not null,
discount double not null,
stock int not null
);

create table Employee(
id_Employee int not null auto_increment primary key,
nameEmployee varchar(50) not null,
dobEmployee date not null,
phoneEmployee int not null,
addressEmployee varchar(50) not null,
email varchar(255) not null
);

create table Customer(
id_customer int not null auto_increment primary key,
namecustomer varchar(50) not null,
dobCustomer date not null,
phoneCustomer int not null,
addressCustomer varchar(50) not null,
emailCustomer varchar(255) not null
);

create table Contract(
idContract int not null auto_increment primary key,
contract_type_pay varchar(50) not null,
dateOrder date not null,
dateSend date not null,
addressSend varchar(255) not null,
id_Employee int, foreign key (id_Employee) references Employee(id_Employee) on update cascade on delete cascade,
id_customer int, foreign key (id_customer) references Customer(id_customer) on update cascade on delete cascade,
idproduct int, foreign key(idproduct) references Product(idproduct) on update cascade on delete cascade
);


insert into Product(nameproduct,price,discount,stock)
values ('Iphone1',500,20,30),
		('Iphone2',600,15,20),
        ('Iphone3',700,5,20),
        ('Iphone4',800,10,20),
        ('Iphone5',850,10,20),
        ('Iphone6',900,15,60),
        ('Iphone7',1000,10,40),
        ('Iphone8',1200,5,25),
        ('Iphone9',1350,5,12),
        ('IphoneX',1400,15,23);
        
insert into Employee(nameEmployee,dobEmployee,phoneEmployee,addressEmployee,email)
values ('Hoang','1997/05/05',0909123123,'Hue','hoang@gmail.com'),
		('Thuan','1997/06/05',0909123123,'Quang Nam','hoang@gmail.com'),
        ('Phuc','1998/08/05',0909123123,'Da Nang','hoang@gmail.com'),
        ('Quang','2001/10/05',0909123123,'Da Nang','hoang@gmail.com'),
        ('Vi','2000/09/05',0909123123,'Nha Trang','hoang@gmail.com'),
        ('Sang','1997/03/05',0909123123,'Ha Noi','hoang@gmail.com'),
        ('Long','1997/04/05',0909123123,'Hue','hoang@gmail.com'),
        ('Nghia','1997/02/05',0909123123,'Quang Tri','hoang@gmail.com'),
        ('Ngoc','1997/01/05',0909123123,'Quang Tri','hoang@gmail.com'),
        ('Dong','1997/11/05',0909123123,'Hue','hoang@gmail.com');
        
        
insert into Customer(namecustomer,dobCustomer,phoneCustomer,addressCustomer,emailCustomer)
values ('Ha','2000/12/12','0909111222','Quang Nam','ha@gmail.com'),
		('Hue','2002/12/12','0909111222','Quang Tri','ha1@gmail.com'),
        ('Trung','2001/12/12','0909111222','Quang Hue','ha2@gmail.com'),
        ('Linh','2003/12/12','0909111222','Quang Tri','ha3@gmail.com'),
        ('Loan','2004/11/12','0909111222','Da Nang','ha4@gmail.com'),
        ('Long','2005/12/12','0909111222','Ha Noi','ha5@gmail.com'),
        ('Chanh','1999/12/12','0909111222','Hai Duong','ha6@gmail.com'),
        ('Nhan','2002/12/12','0909111222','Ha Noi','ha7@gmail.com'),
        ('Anh','2001/12/12','0909111222','Nha Trang','ha8@gmail.com'),
        ('Hai','2005/12/12','0909111222','Quang Nam','ha9@gmail.com');
        
insert into Contract(contract_type_pay,dateOrder,dateSend,addressSend,id_Employee,id_customer,idproduct)
values ('The ATM','2021/01/01','2021/01/10','Da Nang',1,1,1),
		('Tien Mat','2021/01/01','2021/01/10','Da Nang',2,2,1),
        ('The ATM','2021/01/01','2021/01/10','Da Nang',3,3,2),
        ('The ATM','2021/01/01','2021/01/10','Da Nang',5,2,2),
        ('Tien Mat','2021/01/01','2021/01/10','Da Nang',4,1,3),
        ('Tien Mat','2021/01/01','2021/01/10','Da Nang',6,5,3),
        ('The ATM','2021/01/01','2021/01/10','Da Nang',7,4,3),
        ('Tien Mat','2021/01/01','2021/01/10','Da Nang',8,6,3),
        ('The ATM','2021/01/01','2021/01/10','Da Nang',9,8,5),
        ('Tien Mat','2021/01/01','2021/01/10','Da Nang',7,2,6);
        
        
        
        
        SELECT * FROM test2.Contract;

select Product.idproduct, Product.nameproduct, Product.price, Product.discount, Product.stock, count(Contract.idproduct) as tong
from Product
inner join Contract on Contract.idproduct = Product.idproduct
group by Contract.idproduct
order by tong desc
limit 3;

select Product.idproduct, Product.nameproduct, Product.price, Product.discount, Product.stock
from Product
inner join Contract on Contract.idproduct = Product.idproduct
where Contract.dateOrder between ? and ?;

-- String startDay = request.getParameter("start");
-- String endDay = request.getParameter("end");
-- Date start = startDay.toString();
-- Date end = endDay.toString();

-- format(yyyy-MM-dd);

-- List<Product> listProduct = this.productService.distance(start, end);

-- List<Product> distance(Date start, Date end);

-- statement.setDate(1, start);
-- statement.setDate(2, end);





	
        