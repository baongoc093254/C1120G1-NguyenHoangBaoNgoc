use session_04;
create table Students(
ID int not null,
TEN varchar(50) not null,
TUOI int not null,
KHOAHOC varchar(30) not null,
SOTIEN int not null
);
insert into Students(ID,TEN,TUOI,KHOAHOC,SOTIEN)
values 
('1', 'Hoang', '21', 'CNTT', '400000'),
('2', 'Viet', '19', 'DTVT', '320000'),
('3', 'Thanh', '18', 'KTDN', '400000'),
('4', 'Nhan', '19', 'CK', '400000'),
('5', 'Huong', '20', 'TCNH', '400000'),
('5', 'Huong', '20', 'CNTT', '500000');

select * from Students
where TEN = 'Huong';

select sum(SOTIEN) as TongTien 
from Students
where TEN = 'Huong';

select distinct TEN from Students;