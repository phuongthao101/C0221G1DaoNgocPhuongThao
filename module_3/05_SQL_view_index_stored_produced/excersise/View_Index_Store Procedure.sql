create database if not exists demo;
use demo;
create table Products 
( id int auto_increment primary key, 
productCode varchar(45), 
productName varchar (45), 
productPrice int,
productAmount int, 
productDescription varchar (45),
productStatus varchar (45));
 
 insert into Products(productCode,productName,productPrice,productAmount,productDescription,productStatus)
values
('SS', 'samsung', 2000, 50,'red', 'available'),
('IP', 'iphone', 2300, 20,'black', 'available'),
('NK', 'nokia', 500, 30,'white', 'available'),
('OP', 'oppo', 600, 10,'red', 'available');

select*
from Products;

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)

create unique index index_code 
on Products (productCode);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)

create unique index index_code_name_price 
on Products (productName, productPrice);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain 
select*
from Products 
where productCode = 'IP';
explain 
select*
from Products 
where productName = 'Iphone' and productPrice = '2300';
-- Tạo view lấy về các thông tin: productCode,
 -- productName, productPrice, productStatus từ bảng products.
create view product_view 
as
select productName, productPrice, productStatus
from Products;

select*
from product_view;

-- Tiến hành sửa đổi view
update product_view
set productPrice = '3000'
where productName = 'iphone';

 -- Tiến hành xoá view
delete from Products
where productName = 'oppo';

drop view product_view;


-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
 delimiter //
 create procedure product_procedure()
 begin
 select *
 from Products;
 end;// 
 delimiter  ;
 
 -- Tạo store procedure thêm một sản phẩm mới
 delimiter //
 create procedure add_product(
product_Code varchar(45), 
product_Name varchar (45), 
product_Price int,
product_Amount int, 
product_Description varchar (45),
product_Status varchar (45))
 begin
 insert into add_product(productCode,productName,productPrice,productAmount,productDescription,productStatus)
 values (product_Code,product_Name,product_Price,product_Amount,product_Description,product_Status);
 end;// 
 delimiter  ;
-- Tạo store procedure sửa thông tin sản phẩm theo id

 delimiter //
 create procedure update_product(product_Id int , product_Name varchar(45))
 begin
 
 update update_product
 set productName = product_Name
 where productId = product_Id;
 
 end;// 
 delimiter  ;
 
 -- Tạo store procedure xoá sản phẩm theo id
  delimiter //
 create procedure delete_product(product_Id int)
 begin
delete from Products
where productID = product_id;
 end;// 
 delimiter  ;

 












