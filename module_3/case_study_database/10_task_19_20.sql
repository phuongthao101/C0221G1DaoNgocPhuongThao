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
-- task 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống,
 -- thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
select staff.staff_id, staff.`name`, staff.email,staff.phone,staff.birthday,staff.address		
from staff
union all
select customer.customer_id,customer.customer_name, customer.email, customer.phone,customer.birthday,customer.address
from customer;
 -- done 


