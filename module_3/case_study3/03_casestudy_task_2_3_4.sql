-- task 2.	Hiển thị thông tin của tất cả 
-- nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
use casestudy;
select *
from staff 
where (`name` like 'H%' or 'T%' or 'K%')and length (`name`) <= 15;

-- task 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi 
-- từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select*
from customer
 where (year(curdate()) - year(birthday) between 18 and 50) and (address in ("Da Nang","Quang Tri"));
 
-- task  4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp 
-- xếp tăng dần theo số lần đặt phòng của khách hàng.
 -- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select customer.customer_id, customer.customer_name, count(contract.contract_id) as total_contract
from customer 
inner join contract 
on customer.customer_id = contract.customer_id
 -- where type_custumer.type_customer_id = 'diamond'
group by customer.customer_name
order by total_contract ASC;

-- done




