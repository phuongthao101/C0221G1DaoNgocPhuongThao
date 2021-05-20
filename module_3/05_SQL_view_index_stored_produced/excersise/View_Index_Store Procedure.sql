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
 create procedure find_all_product()
 begin
 select *
 from Products;
 end;
 // delimiter  ;
 call find_all_product();
 
 -- Tạo store procedure thêm một sản phẩm mới
 delimiter //
 create procedure add_product( in
product_Code varchar(45), 
product_Name varchar (45), 
product_Price int,
product_Amount int, 
product_Description varchar (45),
product_Status varchar (45))
 begin
 insert into Products
 values (p_product_code, p_product_name, p_product_price, p_product_amount, p_product_description, p_product_status);
 end;
 // delimiter  ;
 
 call add_product('VM', 'Vsmart', 500, 30, 'black', 'available');
 
-- Tạo store procedure sửa thông tin sản phẩm theo id

 delimiter //
 create procedure update_product( p_id int,
    new_product_code varchar(30),
    new_product_name varchar(30),
	new_product_price int,
	new_product_amount int,
	new_product_description varchar(30),
	new_product_status varchar(30))
 begin
 
 update Products
 set product_code = new_product_code, 
		product_name = new_product_name,
        product_price = new_product_price,
        product_amount = new_product_amount,
        product_description = new_product_description,
        product_status = new_product_status
    where id = p_id;
 
 end;
 // delimiter  ;
call editProduct(5,"VM","Vsmart",100,2000,"white ","available");
 
 -- Tạo store procedure xoá sản phẩm theo id
  delimiter //
 create procedure delete_product(in product_Id int)
 begin
delete from Products
where productID = product_id;
 end;// 
 delimiter  ;
call detele_product;

 












