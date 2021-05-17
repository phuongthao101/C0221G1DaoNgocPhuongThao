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


