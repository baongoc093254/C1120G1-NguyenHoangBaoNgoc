/*
Tạo View có tên customer_views truy vấn dữ liệu từ bảng customers để lấy các dữ liệu:
 customerNumber, customerName, phone bằng câu lệnh SELECT:
*/

create view customer_views 
as
select customerNumber, customerName, phone
from customers;

/*
Kết quả, ta sẽ có 1 bảng ảo customer_views, và sau đó chúng ta hoàn toàn có thể lấy dữ liệu từ bảng ảo này bằng lệnh:
*/

select * from customer_views;


/*
Cập nhật view
*/
create or replace view customer_views as
select customerNumber, customerName, contactFirstName, contactLastName, phone
from customers
where city = 'Nantes';

select * from customer_views;

/*
 Delete view
*/

drop view customer_views;

