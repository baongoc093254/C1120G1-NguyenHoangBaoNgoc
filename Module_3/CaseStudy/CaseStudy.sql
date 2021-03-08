use FuramaResort;
/*TASK 2: 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
*/ 
select * from NhanVien
where (HoTen  like 'H%' or HoTen like 'T%' or HoTen  like 'K%') and length(HoTen) <= 30;

/*Task 3: 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
*/
select * from KhachHang
where (DiaChi = 'Đà Nẵng' or DiaChi ='Quảng Trị') and timestampdiff(year,NgaySinh,curdate()) >= 18 and timestampdiff(year,NgaySinh,curdate()) < 50;

/*Task 4: 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
*/

select count(KhachHang.IDKhachHang) as Count, KhachHang.IDKhachHang,KhachHang.IDLoaiKhach
from KhachHang
inner join HopDong
on KhachHang.IDKhachHang = HopDong.IDKhachHang
group by KhachHang.IDKhachHang
having KhachHang.IDLoaiKhach =1
order by Count asc;

/*Task 5: 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
*/

select 	KhachHang.IDKhachHang as IDKhachHang,
		KhachHang.HoTen,
		LoaiKhach.TenLoaiKhach,
		HopDong.IDHopDong,
		DichVu.TenDichVu,
		HopDong.NgayLamHopDong,
		HopDong.NgayKetThuc,
		sum(DichVu.ChiPhiThue + HopDongChiTiet.SoLuong*DichVuDiKem.Gia)
from KhachHang
left join LoaiKhach on KhachHang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
left join HopDong on KhachHang.IDKhachHang = HopDong.IDKhachHang
left join DichVu on HopDong.IDDichVu = DichVu.IDDichVu
left join HopDongChiTiet on HopDong.IDHopDong = HopDongChiTiet.IDHopDong
left join DichVuDiKem on HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
group by HopDong.IDHopDong;



-- Error Code: 1055. Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column
--  'furamaresort.KhachHang.IDKhachHang' which is not functionally dependent on columns in GROUP BY clause; 
--  this is incompatible with sql_mode=only_full_group_by
-- Error Code: 1046. No database selected Select the default DB to be used by 
-- double-clicking its name in the SCHEMAS list in the sidebar.

-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 
-- (Quý 1 là tháng 1, 2, 3).

select 	DichVu.IDDichVu, 
		DichVu.TenDichVu,
        DichVu.DienTich,
		DichVu.ChiPhiThue, 
		LoaiDichVu.TenLoaiDichVu,
        HopDong.NgayLamHopDong
from DichVu
left join LoaiDichVu on LoaiDichVu.IDLoaiDichVu = DichVu.IDLoaiDichVu
left join HopDong on DichVu.IDDichVu = HopDong.IDDichVu
where DichVu.IDDichVu in (select IDDichVu from HopDong where year(NgayLamHopDong) < 2019) 
group by DichVu.IDDichVu;

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng 
-- trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

select 	DichVu.IDDichVu, 
		DichVu.TenDichVu, 
		DichVu.DienTich, 
		DichVu.SoNguoiToiDa, 
		DichVu.ChiPhiThue,
		LoaiDichVu.TenLoaiDichVu
from DichVu
left join HopDong on DichVu.IDDichVu = HopDong.IDDichVu
left join LoaiDichVu on DichVu.IDLoaiDichVu = LoaiDichVu.IDLoaiDichVu
where DichVu.IDDichVu in (select IDDichVu from HopDong where year(NgayLamHopDong) = 2018)
and DichVu.IDDichVu not in (select IDDichVu from HopDong where year(NgayLamHopDong) = 2019)
group by DichVu.IDDichVu;

-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

-- Cách 1: sử dụng group by
select * from KhachHang
group by HoTen; 

-- Cách 2 : sử dụng distinct
select distinct HoTen
from KhachHang;
-- Cách 3: Sử dụng union
select HoTen from KhachHang
union
select HoTen from KhachHang;

-- 9.	Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select 	month(HopDong.NgayLamHopDong) as Thang,		
		count(HopDong.IDHopDong) as SoLuong
            
from HopDong
where year(NgayLamHopDong) = 2019
group by month(HopDong.NgayLamHopDong);

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
-- (được tính dựa trên việc count các IDHopDongChiTiet).

select 	HopDong.IDHopDong, 
		HopDong.NgayLamHopDong, 
		HopDong.NgayKetThuc, 
		HopDong.TienDatCoc, 
		HopDongChiTiet.SoLuong
from HopDong
left join HopDongChiTiet on HopDong.IDHopDong = HopDongChiTiet.IDHopDong
group by HopDong.IDHopDong;


-- 11.	Hiển thị thông tin các Dịch vụ đi kèm 
-- đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

select	DichVuDiKem.TenDichVuDiKem, 
        KhachHang.HoTen,
        DichVuDiKem.TrangThaiKhaDung
	
from DichVuDiKem
right join HopDongChiTiet on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
right join HopDong on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
right join KhachHang on HopDong.IDKhachHang = KhachHang.IDKhachHang
right join LoaiKhach on KhachHang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
where KhachHang.DiaChi in ('Quảng Trị','Đà Nẵng') and LoaiKhach.TenLoaiKhach = 'Diamond';

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, 
-- SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- (được tính dựa trên tổng Hợp đồng chi tiết), 
-- TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

select 	HopDong.IDHopDong, 
		NhanVien.HoTen, 
		KhachHang.HoTen, 
		KhachHang.SDT, 
		DichVu.TenDichVu, 
		HopDongChiTiet.SoLuong,
        HopDong.NgayLamHopDong
from HopDong
left join HopDongChiTiet on HopDong.IDHopDong = HopDongChiTiet.IDHopDong
left join KhachHang on HopDong.IDKhachHang = KhachHang.IDKhachHang
left join NhanVien on HopDong.IDNhanVien = NhanVien.IDNhanVien
left join DichVu on HopDong.IDDichVu = DichVu.IDDichVu
where year(HopDong.NgayLamHopDong) = 2019 and month(HopDong.NgayLamHopDong) IN  (10,11,12)
group by HopDong.IDHopDong;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất 
-- bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select 	DichVuDiKem.IDDichVuDiKem,
		DichVuDiKem.TenDichVuDiKem, 
		sum(HopDongChiTiet.SoLuong) as SoLuong
from DichVuDiKem
inner join HopDongChiTiet on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
group by HopDongChiTiet.IDDichVuDiKem
order by sum(HopDongChiTiet.SoLuong) desc;

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select HopDong.IDHopDong,
LoaiDichVu.TenLoaiDichVu,
DichVuDiKem.TenDichVuDiKem,
HopDongChiTiet.SoLuong
from HopDong
left join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
left join DichVuDiKem on HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
left join DichVu on HopDong.IDDichVu = DichVu.IDDichVu
left join LoaiDichVu on DichVu.IDLoaiDichVu = LoaiDichVu.IDLoaiDichVu
group by DichVuDiKem.IDDichVuDiKem
having count(HopDongChiTiet.IDDichVuDiKem) = 1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm 
-- IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select 		NhanVien.IDNhanVien, 
			NhanVien.HoTen, 
			TrinhDo.TrinhDo,
			NhanVien.SDT, 
			NhanVien.DiaChi,
            count(HopDong.IDNhanVien) as SoLuong
from NhanVien
left join TrinhDo on NhanVien.IDTrinhDo = TrinhDo.IDTrinhDo
left join HopDong on HopDong.IDNhanVien = NhanVien.IDNhanVien 
where year(HopDong.NgayLamHopDong) IN ('2018','2019')
group by HopDong.IDNhanVien
having count(HopDong.IDNhanVien) <= 3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
create temporary table DeleteEmployee
select 		HopDong.IDHopDong, 
			HopDong.IDNhanVien,
			NhanVien.HoTen,
            HopDong.NgayLamHopDong
from HopDong
left join NhanVien on HopDong.IDNhanVien = NhanVien.IDNHanVien
where year(HopDong.NgayLamHopDong) >= 2018 and year(HopDong.NgayLamHopDong) <= 2021
group by HopDong.IDHopDong;


select * from DeleteEmployee;




-- select * from DeleteEmployee;
-- drop temporary table DeleteEmployee;
-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng 
-- với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

-- create view TongThanhToan_View as
-- select 	HopDong.IDHopDong,
-- 		HopDong.NgayLamHopDong, 
-- 		HopDong.TongTien,
-- 		HopDong.IDKhachHang, 
-- 		LoaiKhach.TenLoaiKhach
-- from HopDong
-- left join KhachHang on KhachHang.IDKhachHang = HopDong.IDKhachHang
-- left join LoaiKhach on KhachHang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
-- group by HopDong.IDHopDong;
-- drop view TongThanhToan_View;
-- select * from TongThanhToan_View;

create temporary table TongThanhToan
select HopDong.IDHopDong,
		HopDong.NgayLamHopDong, 
		HopDong.TongTien,
		HopDong.IDKhachHang, 
		LoaiKhach.TenLoaiKhach
from HopDong
left join KhachHang on KhachHang.IDKhachHang = HopDong.IDKhachHang
left join LoaiKhach on KhachHang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
where year(HopDong.NgayLamHopDong) = 2019
group by HopDong.IDHopDong
having sum(HopDong.TongTien);

select * from TongThanhToan;
drop temporary table TongThanhToan;

update KhachHang
set KhachHang.IDloaikhach = (select IDLoaiKhach from LoaiKhach where LoaiKhach.TenLoaiKhach = 'Diamond')
where (IDLoaiKhach = (select IDLoaiKhach from LoaiKhach where LoaiKhach.TenLoaiKhach = 'Platinum') 
and IDLoaiKhach in ( select IDLoaiKhach from TongThanhToan));



-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
create temporary table DeleteCustomer
select 		HopDong.IDKhachHang,
			KhachHang.HoTen, 
			HopDong.NgayLamHopDong, 
			HopDong.IDDichVu
from HopDong
left join KhachHang on KhachHang.IDKhachHang = HopDong.IDKhachHang
group by HopDong.IDHopDong;

select * from DeleteCustomer;

-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
create temporary table PriceServices
select 	DichVuDiKem.IDDichVuDiKem,
		DichVuDiKem.TenDichVuDiKem,
		DichVuDiKem.Gia,
        DichVuDiKem.TrangThaiKhaDung,
        HopDong.NgayLamHopDong
from DichVuDiKem
left join HopDongChiTiet on HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
left join HopDong on HopDong.IDHopDong = HopDongChiTiet.IDHopDong
where year(HopDong.NgayLamHopDong) = 2019 
group by DichVuDiKem.IDDichVuDiKem;
select * from PriceServices;
	update DichVuDiKem
    set DichVuDiKem.Gia = DichVuDiKem.Gia * 2
    where IDDichVuDiKem in (select IDDichVuDiKem from PriceServices );
-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng
--  có trong hệ thống, thông tin hiển thị bao gồm 
--  ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
select NhanVien.IDNhanVien as ID, NhanVien.HoTen,NhanVien.Email,NhanVien.SDT,
NhanVien.NgaySinh,NhanVien.DiaChi,
'NhanVien' as position
from NhanVien
union
select KhachHang.IDKhachHang as ID, KhachHang.HoTen,KhachHang.Email,
KhachHang.SDT,KhachHang.NgaySinh,KhachHang.DiaChi,
'KhachHang' as position

from KhachHang;
-- 21.	Tạo khung nhìn có tên là V_NHANVIEN 
-- để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu”
--  và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với 
-- ngày lập hợp đồng là “12/12/2019”
create view view_NhanVien as
select * 
from NhanVien
where NhanVien.DiaChi = 'Đà Nẵng' and exists (select HopDong.IDNhanVien 
from HopDong 
where year(HopDong.NgayLamHopDong) = 2020 and HopDong.IDNhanVien = NhanVien.IDNhanVien
group by HopDong.IDNhanVien
having count(HopDong.IDNhanVien) > 0);

select * from view_NhanVien; 
-- task 22 :Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
-- đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này. 
update view_NhanVien
set DiaChi = 'Liên Chiểu';




-- Check update view table
select table_name, is_updatable
from information_schema.views
where table_schema = 'FuramaResort';
