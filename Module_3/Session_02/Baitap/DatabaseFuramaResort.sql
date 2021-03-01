create database FuramaResort;
use FuramaResort;
create table Vitri(
IDVitri int not null primary key auto_increment,
TenViTri varchar(45) not null
);

create table TrinhDo(
IDTrinhDo int not null primary key auto_increment,
TrinhDo varchar(45) not null
);

create table BoPhan(
IDBoPhan int(30) not null primary key auto_increment,
TenBoPhan varchar(45) not null
);

create table NhanVien(
IDNhanVien int(30) not null primary key auto_increment,
HoTen varchar(255) not null,
NgaySinh date not null,
SoCMTND varchar(45) not null,
Luong double not null,
SDT int(45) not null,
Email varchar(45) not null,
DiaChi varchar(45) not null,
IDViTri int, foreign key (IDViTri) references Vitri(IDViTri),
IDTrinhDo int, foreign key (IDTrinhDo) references TrinhDo(IDTrinhDo),
IDBoPhan int, foreign key (IDBoPhan) references BoPhan(IDBoPhan)
);

create table LoaiKhach(
IDLoaiKhach int not null primary key auto_increment,
TenLoaiKhach varchar(45) not null
);

create table KieuThue(
IDKieuThue int not null primary key auto_increment,
TenKieuThue varchar(45) not null,
Gia double
);

create table LoaiDichVu(
IDLoaiDichvu int not null primary key auto_increment,
TenLoaiDichVu varchar(45) not null
);

create table KhachHang(
IDKhachHang int(45) not null primary key auto_increment,
HoTen varchar(45) not null,
NgaySinh date not null,
SoCMTND int(45) not null,
SDT int(45) not null,
Email varchar(45) not null,
DiaChi varchar(45),
IDLoaiKhach int, foreign key (IDLoaiKhach) references LoaiKhach(IDLoaiKhach)
);

create table DichVu(
IDDichVu int(45) not null primary key auto_increment,
TenDichVu varchar(45) not null,
DienTich float not null,
SoTang int not null,
SoNguoiToiDa varchar(45) not null,
ChiPhiThue double not null,
TrangThai varchar(45),
IDKieuThue int, foreign key (IDKieuThue) references KieuThue(IDKieuThue),
IDLoaiDichVu int, foreign key (IDLoaiDichVu) references LoaiDichVu(IDLoaiDichVu)
);


create table DichvuDiKem(
IDDichVuDiKem int not null primary key auto_increment,
TenDichVuDiKem varchar(45) not null,
Gia double not null, 
TrangThaiKhaDung varchar(45)
);
create table HopDongChiTiet(
IDHopDongChiTiet int not null primary key auto_increment,
SoLuong int not null,
IDDichVuDiKem int, foreign key (IDDichVuDiKem) references DichvuDiKem(IDDichVuDiKem)
);

create table HopDong(
IDHopDong int(45) not null primary key auto_increment,
NgayLamHopDong date not null,
NgayKetThuc date not null,
TienDatCoc double not null,
TongTien double not null,
IDNhanVien int, foreign key (IDNhanVien) references NhanVien(IDNhanVien),
IDKhachHang int, foreign key (IDKhachHang) references KhachHang(IDKhachHang),
IDDichvu int, foreign key (IDDichVu) references DichVu(IDDichVu),
IDHopDongChiTiet int, foreign key (IDHopDongChiTiet) references HopDongChiTiet(IDHopDongChiTiet) 
);

