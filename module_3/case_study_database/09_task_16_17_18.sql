-- task 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

select *
from contract;

select *
from staff;

SET SQL_SAFE_UPDATES = 0;

SET FOREIGN_KEY_CHECKS=0;

delete staff from staff
where staff.staff_id not in (select staff_id from contract where year(contract.date_contract) between 2017 and 2019);

SET FOREIGN_KEY_CHECKS=1;


-- task 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

select *
from customer;
select *
from type_custumer ;

select * 
from contract_detail;

update customer 
set type_customer_id = 1
where type_custumer_id = 2

