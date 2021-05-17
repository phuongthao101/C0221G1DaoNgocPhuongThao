-- task 6
use casestudy;
-- 	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ
--  chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2020 (Quý 1 là tháng 1, 2, 3).

select service.service_id, service.service_name, service.area, service.price, type_service.type_service_name
from service
join type_service on type_service.type_service_id = service.type_service_id
join contract on contract.service_id = service.service_id
group by service.service_id, contract.date_contract
having month(contract.date_contract) not in (1,2,3) and year(contract.date_contract) = 2020;

-- task 7
-- 	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt
 -- phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
 
 select service.service_id, service.service_name, service.area,
 service.number_people,service.price, type_service.type_service_name
 from service
 inner join type_service on type_service.type_service_id = service.type_service_id
 inner join contract on contract.service_id = service.service_id
 where year(contract.date_contract) = '2018'
 and not exists (select date_contract from contract 
 where year(date_contract) = 2019);
 
-- task 8
-- Hiển thị thông tin HoTenKhachHang có trong hệ thống, 
-- với yêu cầu HoThenKhachHang không trùng nhau.
-- Cach 1:
select *
from customer
group by customer_name;
-- Cach 2:
select  DISTINCT customer_name
from customer;

-- Cach 3:
select *
from customer
group by customer_id;

-- task 9
-- 	Thực hiện thống kê doanh thu theo tháng,
 -- nghĩa là tương ứng với mỗi tháng trong năm 2018 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(contract.date_contract) as 'month' , count(*) 'amount'
from contract
join service on service.service_id = contract.service_id
where year(contract.date_contract) = 2018
group by 'month';


 
 

