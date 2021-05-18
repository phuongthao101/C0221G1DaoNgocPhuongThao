-- task 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

SET SQL_SAFE_UPDATES = 0;

SET FOREIGN_KEY_CHECKS=0;

delete staff from staff
where staff.staff_id not in (select staff_id from contract where year(contract.date_contract) between 2017 and 2019);

SET FOREIGN_KEY_CHECKS=1;

-- task 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

update customer 
set type_customer_id =1 
where type_customer_id = 2
and customer_id in (select a.id from (
	select customer.customer_id as id, 
	sum(service.price + extra_service.price*contract_detail.amount) as total_price
	from customer 
		left join type_custumer on customer.type_customer_id = type_custumer.type_customer_id
		left join contract on customer.customer_id = contract.customer_id
		left join service on service.service_id = contract.service_id
		left join contract_detail on contract.contract_id = contract_detail.contract_id
		left join extra_service on extra_service.extra_service_id = contract_detail.extra_service_id
		 where year(contract.date_contract) = 2019 
		group by customer.customer_id
		having total_price >= 5000) as a);

-- task 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).
select * 
from contract;
SET SQL_SAFE_UPDATES = 0;
delete 
from customer 
where customer.customer_id not in (select contract_id from contract where year(contract.date_contract) >= 2016);

-- done 


























