use demo;

create table Products(
 id int not null primary key auto_increment,
 productCode varchar(30) not null,
 productName varchar(50) not null,
 productPrice double not null,
 productAmount int not null,
 productDescription varchar(255) not null,
 productStatus varchar(255) 
);

insert into Products(productCode, productName, productPrice, 
productAmount, productDescription, productStatus)
values 
('Product-01','Iphone X', '11000000', '10', '2018','Available'),
('Product-01','Iphone 12', '25000000', '10', '2020','Available'),
('Product-01','Iphone 7', '5000000', '10', '2017','Available'),
('Product-01','Iphone 6', '3000000', '10', '2016','Available'),
('Product-01','Iphone 11', '17000000', '10', '2019','Available');

select * from Products;
/*
Bước 3:
*/

/* 
Tạo unique index
*/

create unique index customerCode 
on Products(productCode);

/*
Tạo composite index
*/

create index CompositeIndex 
on Products(productName,productPrice);

explain select * from Products;
select * from Products;

/*
Bước 4:
Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
Tiến hành sửa đổi view
Tiến hành xoá view
*/

create view InforProductsView as
select productCode, productName, productPrice, productStatus 
from Products;

select * from InforProductsView;

create or replace view InforProductsView as
select productCode, productName, productPrice, productAmount, productStatus
from Products
where productStatus = 'Available';

select * from InforProductsView;

drop view InforProductsView;

/*
Bước 5:

Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
Tạo store procedure thêm một sản phẩm mới
Tạo store procedure sửa thông tin sản phẩm theo id
Tạo store procedure xoá sản phẩm theo id
*/

DELIMITER //
create procedure FindAllProducts()

BEGIN

 select * from Products;
 
END //

DELIMITER ;

call FindAllProducts();

DELIMITER //
drop procedure if exists AddProduct //
create procedure AddProduct() 
BEGIN
insert into Products(productCode, productName, productPrice, 
productAmount, productDescription, productStatus)
values ('Product-02', 'Iphone 12 Pro', '31000000', '5', '2020', 'Available');

END //
DELIMITER ;
call AddProduct();
select * from Products;

DELIMITER //
create procedure EditProduct(in productCode varchar(30))
begin
update Products
set productCode  = 'Product-03'
where id = '2';

 end //
 DELIMITER ;
call EditProduct(@productCode);
select * from Products;

DELIMITER  //
create procedure DeleteProduct()
begin
delete from Products
where id = '2';

end //

DELIMITER ;
call DeleteProduct();
select * from Products;
