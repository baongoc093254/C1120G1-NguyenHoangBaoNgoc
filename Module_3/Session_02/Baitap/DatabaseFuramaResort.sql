create database FuramaResort;
use FuramaResort;
create table Vitri(
IDVitri int not null primary key auto_increment,
TenViTri varchar(45) not null
);
insert into ViTri(TenViTri)
values
('Lễ Tân'), ('Phục Vụ'), ('Chuyên Viên'),
('Giám sát'), ('Quản Lý'), ('Giám Đốc'); 


create table TrinhDo(
IDTrinhDo int not null primary key auto_increment,
TrinhDo varchar(45) not null
);
insert into TrinhDo(TrinhDo)
values
('Trung Cấp'), ('Cao Đẳng'), ('Đại Học'), ('Sau Đại Học');

create table BoPhan(
IDBoPhan int(30) not null primary key auto_increment,
TenBoPhan varchar(45) not null
);
insert into BoPhan(TenBoPhan)
values
('Sale - Marketing'), ('Hành Chính'), ('Phục Vụ'), ('Quản Lý');

create table NhanVien(
IDNhanVien int(30) not null primary key auto_increment,
HoTen varchar(255) not null,
NgaySinh date not null,
SoCMTND varchar(45) not null,
Luong double not null,
SDT int(45) not null,
Email varchar(45) not null,
DiaChi varchar(45) not null,
IDViTri int, foreign key (IDViTri) references Vitri(IDViTri) on update cascade on delete cascade,
IDTrinhDo int, foreign key (IDTrinhDo) references TrinhDo(IDTrinhDo) on update cascade on delete cascade,
IDBoPhan int, foreign key (IDBoPhan) references BoPhan(IDBoPhan) on update cascade on delete cascade
);
insert into NhanVien(HoTen,NgaySinh,SoCMTND,Luong,SDT,Email,DiaChi,IDViTri,IDTrinhDo,IDBoPhan)
values
('Trần Quốc Hoàng', '1995/12/12', 123123123, 300000, 0909123111, 'hoangtq@gmail.com', 'Quảng Nam', 1, 2, 2),
('Trần Hoàng', '2001/12/05', 123123456, 350000, 0909123123, 'hoangtq@gmail.com', 'Đà Nẵng', 3, 2, 1),
('Ngọc Thuần', '2000/10/05', 123123444, 400000, 0909123121, 'thuanng@gmail.com', 'TP HCM', 5, 2, 1),
('Lê Quang', '1998/02/11', 123123555, 900000, 0909123345, 'quangle@gmail.com', 'Đà Nẵng', 6, 3, 4),
('Trần Hoàng Sang', '1995/04/04', 123123777, 300000, 0909123333, 'sangth@gmail.com', 'Quảng Trị', 1, 2, 3),
('Bùi Khoa', '1999/04/25', 123123999, 250000, 0909123222, 'khoa@gmail.com', 'Quảng Trị', 2, 3, 2),
('Nguyễn Nghĩa', '1996/05/05', 123123000, 500000, 0909123444, 'nghia@gmail.com', 'Đà Nẵng', 3, 2, 2),
('Bảo Long', '1997/07/07', 123123333, 670000, 0909123555, 'long123@gmail.com', 'Đà Nẵng', 3, 1, 1);

create table LoaiKhach(
IDLoaiKhach int not null primary key auto_increment,
TenLoaiKhach varchar(45) not null
);
insert into LoaiKhach(TenLoaiKhach)
values 
('Diamond'),('Platinum'),('Gold'),('Silver'),('Member');

create table KieuThue(
IDKieuThue int not null primary key auto_increment,
TenKieuThue varchar(45) not null,
Gia double
);
insert into KieuThue(TenKieuThue)
values
('Thuê theo giờ'),('Thuê theo ngày'),('Thuê theo tháng'),('Thuê theo năm');

create table LoaiDichVu(
IDLoaiDichvu int not null primary key auto_increment,
TenLoaiDichVu varchar(45) not null
);
insert into LoaiDichVu(TenLoaiDichVu)
values
('Villa'),('House'),('Room'),('Dịch vụ đi kèm');


create table KhachHang(
IDKhachHang int not null primary key auto_increment,
HoTen varchar(45) not null,
NgaySinh date not null,
SoCMTND int(45) not null,
SDT int(45) not null,
Email varchar(45) not null,
DiaChi varchar(45),
IDLoaiKhach int, foreign key (IDLoaiKhach) references LoaiKhach(IDLoaiKhach) on update cascade on delete cascade
);
insert into KhachHang (HoTen,NgaySinh,SoCMTND,SDT,Email,DiaChi,IDLoaiKhach)
values
('Thanh Tùng','1995-04-05','345345345',0908111222,'tungth@gmail.com','Đà Nẵng',3),
('Bảo Ngọc','2000-03-05','111222333',0908111333,'ngoc@gmail.com','Quảng Trị',3),
('Cẩm Vân','2001-11-11','343444555',0908111444,'tungth@gmail.com','Quảng Bình',2),
('Ngọc Đông','2001-04-05','111111111',0908111545,'tungth@gmail.com','Đà Nẵng',1),
('Lươn Sang','1994-12-12','020202021',0908111666,'tungth@gmail.com','Đà Nẵng',2),
('Bảo Nhân','2002-07-07','123123123',0908111212,'tungth@gmail.com','Nha Trang',3),
('Thanh Dũng','1999-10-10','777777000',0908111232,'tungth@gmail.com','Hà Nội',4),
('Thanh Long','2000-10-10','777777000',0908111232,'tungth@gmail.com','Đà Nẵng',1),
('Thanh Bình','2000-10-10','777777000',0908111232,'tungth@gmail.com','Quảng Trị',1),
('Sang Bong','2001-10-10','777777000',0908111232,'tungth@gmail.com','Quảng Trị',2);


create table DichVu(
IDDichVu int not null primary key auto_increment,
TenDichVu varchar(45) not null,
DienTich float not null,
SoTang int not null,
SoNguoiToiDa varchar(45) not null,
ChiPhiThue double not null,
TrangThai varchar(45),
IDKieuThue int, foreign key (IDKieuThue) references KieuThue(IDKieuThue) on update cascade on delete cascade,
IDLoaiDichVu int, foreign key (IDLoaiDichVu) references LoaiDichVu(IDLoaiDichVu) on update cascade on delete cascade
);
insert into DichVu (TenDichVu,DienTich,SoTang,SoNguoiToiDa,ChiPhiThue,TrangThai,IDKieuThue,IDLoaiDichVu)
values
('Villa 1','300',2,6,2000000,'Available',2,1),
('House 1','250',2,5,2700000,'Not Available',4,2),
('Room','150','01',6,1000000,'Available',3,3),
('Villa 2','300','03','5',2500000,'Not Available',2,1),
('Villa VIP','500',4,10,8000000,'Available',2,1);


create table DichvuDiKem(
IDDichVuDiKem int not null primary key auto_increment,
TenDichVuDiKem varchar(45) not null,
Gia double not null,
DonVi int not null, 
TrangThaiKhaDung varchar(45)
);
insert into DichVuDiKem(TenDichVuDiKem,Gia,DonVi,TrangThaiKhaDung)
values 
('Massage', 100000,3,'Available'),
('Karaoke',50000,5,'Available'),
('Food', 40000,20,'Available'),
('Water', 10000,20,'Available'),
('Car',150000,7,'Available');


create table HopDong(
IDHopDong int not null primary key auto_increment,
NgayLamHopDong date not null,
NgayKetThuc date not null,
TienDatCoc double not null,
TongTien double not null,
IDNhanVien int, foreign key (IDNhanVien) references NhanVien(IDNhanVien) on update cascade on delete cascade,
IDKhachHang int, foreign key (IDKhachHang) references KhachHang(IDKhachHang) on update cascade on delete cascade,
IDDichVu int, foreign key (IDDichVu) references DichVu(IDDichVu) on update cascade on delete cascade
);
insert into HopDong(NgayLamHopDong,NgayKetThuc,TienDatCoc,TongTien,IDNhanVien,IDKhachHang,IDDichVu)
values
('2020-05-07','2020-05-10',200000,23000000,1,2,1),
('2020-10-07','2020-10-10',150000,25000000,2,5,2),
('2021-01-30','2021-02-10',50000,15000000,3,3,3),
('2020-03-10','2020-04-10',50000,700000,4,4,3),
('2018-10-12','2018-12-15',100000,900000,5,6,4),
('2019-11-11','2019-11-15',100000,900000,3,7,2),
('2019-04-04','2019-04-10',100000,11000000,2,8,1),
('2019-10-12','2020-10-15',100000,12000000,3,9,1),
('2019-10-13','2020-10-15',100000,10000000,2,6,1),
('2019-04-12','2020-04-17',100000,10000000,2,7,1),
('2015-12-12','2015-12-17',100000,12000000,2,7,1),
('2016-10-24','2015-10-25',100000,1000000,2,4,2),
('2019-10-24','2019-10-25',100000,1000000,5,3,2),
('2019-05-24','2019-05-25',100000,1000000,4,10,2);


create table HopDongChiTiet(
IDHopDongChiTiet int not null primary key auto_increment,
SoLuong int not null,
IDDichVuDiKem int, foreign key (IDDichVuDiKem) references DichvuDiKem(IDDichVuDiKem) on update cascade on delete cascade,
IDHopDong int, foreign key (IDHopDong) references HopDong(IDHopDong) on update cascade on delete cascade
);
insert into HopDongChiTiet(SoLuong,IDDichVuDiKem,IDHopDong) 
values
(5,5,1),
(2,2,2),
(2,1,4),
(1,4,3),
(3,3,5),
(6,2,6),
(7,1,7),
(8,5,8),
(5,4,5),
(4,2,9),
(3,1,10);
