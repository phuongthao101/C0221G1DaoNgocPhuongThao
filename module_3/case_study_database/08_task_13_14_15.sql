-- task 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select es.extra_service_id, es.extra_service_name, count(cd.contract_detail_id) as amount_contract
from extra_service es
inner join contract_detail cd on es.extra_service_id = cd.extra_service_id
group by cd.contract_detail_id 
having count(cd.contract_detail_id) >= all (select count(cd.contract_detail_id) from contract_detail group by es.extra_service_id);


-- task 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
select contract.contract_id, type_service.type_service_name, extra_service.extra_service_name,
 count(contract_detail.contract_detail_id) as amount
from extra_service
inner join contract_detail on contract_detail.extra_service_id = extra_service.extra_service_id
inner join contract on contract.contract_id = contract_detail.contract_id
inner join service on service.service_id = contract.service_id
inner join type_service on type_service.type_service_id = service.type_service_id
group by contract_detail.contract_detail_id
having count(contract_detail.contract_detail_id) = 1;

-- task 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai,
 -- DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select staff.staff_id, staff.`name`, `level`.`level`, department.department_name, staff.phone,staff.address, 
count(contract.staff_id) 
from staff
inner join `level` on `level`.level_id = staff.level_id
inner join department on department.department_id = staff.department_id
inner join contract on contract.staff_id = staff.staff_id
group by contract.staff_id
having count(contract.staff_id) <=3;








 


