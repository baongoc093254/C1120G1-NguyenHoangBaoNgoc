use FuramaResort;
/*TASK 2: 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
*/ 
select * from NhanVien
where (HoTen  like 'H%' or HoTen like 'T%' or HoTen  like 'K%') and length(HoTen) <= 30;

/*Task 3: 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
*/
select * from KhachHang
where (DiaChi = 'Đà Nẵng' or DiaChi ='Quảng Trị') and timestampdiff(year,NgaySinh,curdate()) >= 18 and timestampdiff(year,NgaySinh,curdate()) < 50;

/*Task 4: 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
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
 