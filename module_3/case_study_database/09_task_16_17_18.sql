-- task 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

SET SQL_SAFE_UPDATES = 0;

SET FOREIGN_KEY_CHECKS=0;

delete staff from staff
where staff.staff_id not in (select staff_id from contract where year(contract.date_contract) between 2017 and 2019);

SET FOREIGN_KEY_CHECKS=1;

-- task 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
select*
from customer;

update customer
set customer.type_customer_id = 1
where customer.type_customer_id = 2 and 
(select customer_id 
from contract 
join service on service.service_id = contract.service_id
join contract_detail on contract_detail. contract_id = contract.contract_id
join extra_service on contract_detail.extra_service_id = extra_service.extra_service_id
where contract.customer_id = customer.customer_id
group by contract.customer_id
having sum(service.price + contract_detail. amount * extra_service.price) >=5000);

-- task 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).
select * 
from contract;
SET SQL_SAFE_UPDATES = 0;
delete 
from customer 
where customer.customer_id not in (select contract_id from contract where year(contract.date_contract) >= 2016);

-- task 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
select*
from extra_service;

update extra_service
set price = extra_service.price * 2
where (select extra_service.extra_service_id 
from contract_detail 
where extra_service.extra_service_id = contract_detail.extra_service_id
group by contract_detail.extra_service_id
having count (contract_detail.extra_sevice_id ) >= 10 );




