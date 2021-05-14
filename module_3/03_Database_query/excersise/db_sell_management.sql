
use sell_management;
insert into customer (customer_name, customer_age)
values 
('Minh Quan', 10),
('Ngoc Oanh', 20),
('Hong Ha', 50);
insert into `order` (customer_id, order_date, order_total_price)
values
(1,'2006-3-21',null),
(2,'2006-3-23',null),
(1,'2006-3-16',null);
insert into product(product_name, product_price)
values 
('May giat', 3),
('Tu lanh', 5),
('Dieu hoa', 7),
('Quat', 1),
('Bep dien', 2);
insert into order_detail (order_id, product_id, order_qty)
values
(2,3,7),
(3,3,2),
(4,4,2),
(5,5,8),
(6,6,4);

-- dùng lệnh TRUNCATE TABLE table_name; để xóa dữ liệu trong bảng
truncate table order_detail;
select * from order_detail;


-- Hiển thị các thông tin  gồm oID, oDate, pPrice của tất cả các hóa đơn trong bảng Order
select `order`.order_id,`order`.order_date, product.product_price
from `order`
join order_detail
on `order`.order_id = order_detail.order_id
join product
on product.product_id = order_detail.product_id;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select customer.customer_name, product.product_name, product.product_price
from customer
join `order`
on customer.customer_id = `order`.customer_id
join order_detail 
on order_detail.order_id = `order`.order_id
join product
on order_detail.product_id = product.product_id; 
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select customer.customer_name 
from customer 
left join `order` 
on customer.customer_id = `order`.customer_id
where order_id is null;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice)
select o.order_id, o.order_date, sum (od.order_qty * p.product_price) as total
from `order` o , order_detail od , product p
where o.order_id = od.order_id and od.product_id = p.product_id
group by o.order_id;
-- chua fix dc 





