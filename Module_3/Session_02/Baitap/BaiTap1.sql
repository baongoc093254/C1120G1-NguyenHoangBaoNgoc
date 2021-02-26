
use homework_01;

create table company(
departmentCode int(50) not null primary key,
nameDepartment varchar(50) not null
);
create table Employees(
id_employee int(50) not null primary key,
lastName varchar(50) not null,
firstName varchar(50) not null,
dayofbirth date not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50), 
gender varchar(15) not null,
city varchar(50) not null,
state varchar(50) not null, 
country varchar(50) not null,
departmentCode int(50), foreign key (departmentCode) references company(departmentCode)
);

create table BaoHiem(
id_baohiem int(50) not null primary key,
rangeDate date not null,
periodTime date not null,
id_employee int(50), foreign key (id_employee) references Employees(id_employee)
);


create table Constructions(
id_construction int(50) not null primary key,
nameConstruction varchar(255) not null, 
locationConstruction1 varchar(50) not null,
locationConstruction2 varchar(50) not null,
dateLicense date not null,
dateCommencement date not null,
finishDay date not null
);

create table Assignment(
id_employee int not null,
id_construction int not null,
dateStart date not null,
primary key(id_employee,id_construction),
foreign key(id_employee) references Employees(id_employee),
foreign key(id_construction) references Constructions(id_construction)
);


 