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