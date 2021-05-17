use casestudy;
-- task 10
-- 	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm
--  IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc,
 -- SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).
 
 select contract.contract_id, contract.date_contract, contract.end_contract, contract.deposit, 
 count(contract_detail.contract_detail_id ) as amount_contract_detail
 from contract
 inner join contract_detail on contract.contract_id = contract_detail.contract_id
 group by contract.contract_id;
 
 
 -- task 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng 
 -- có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
 select extra_service. extra_service_name , type_custumer.name_customer, customer.address
 from extra_service
 inner join contract_detail on contract_detail.extra_service_id = extra_service.extra_service_id
 inner join contract on contract.contract_id = contract_detail.contract_id
 inner join customer on contract.customer_id = customer.customer_id
 inner join type_custumer on type_custumer.type_customer_id = customer.type_customer_id
 where type_custumer.name_customer = 'Diamond' and customer.address = 'Da Nang' or 'Quang Tri';
 
 -- task 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
 -- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã
 -- từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
 
 select contract.contract_id, staff.name, customer.customer_name, customer.phone, 
 service.service_name, contract_detail.amount, contract.deposit
 from contract
 join staff on staff.staff_id = contract.staff_id
 join customer on customer.customer_id = contract.customer_id
 join service on service.service_id = contract.service_id
 join contract_detail on contract_detail.contract_id = contract.contract_id
 where contract.date_contract = month(contract.date_contract) not in (1,2,3,4,5,6)  and month(contract.date_contract) in (10,11,12)
 and year(contract.date_contract) = 2018
 group by contract.contract_id;
    
 -- 
 
 