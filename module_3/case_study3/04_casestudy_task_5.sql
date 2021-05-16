use casestudy;
-- task 5

-- IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien
-- ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKemen 

select customer.customer_id, customer.customer_name, type_custumer.name_customer, 
contract.contract_id, service.service_name, contract.date_contract, end_contract,
sum(service.price + extra_service.price*contract_detail.amount) as total_price
from customer 
left join type_custumer on customer.type_customer_id = type_custumer.type_customer_id
left join contract on customer.customer_id = contract.customer_id
left join service on service.service_id = contract.service_id
left join contract_detail on contract.contract_id = contract_detail.contract_id
left join extra_service on extra_service.extra_service_id = contract_detail.extra_service_id
group by customer.customer_id, contract.contract_id;




