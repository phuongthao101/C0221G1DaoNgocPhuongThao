-- task 21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu”
 -- và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”
 use casestudy;
 drop view  if exists v_staff ;

 create view v_staff as
 select staff.`name`, staff.address, contract.date_contract
 from staff 
 inner join contract on  staff.staff_id = contract.staff_id
 where staff.address = 'Hai Chau' and contract.date_contract = '2019-12-12';

 select *
 from v_staff;
 
 
 -- task 22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
 -- đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
 update v_staff
 set address = 'Lien Chieu';
 
 select *
 from v_staff;
 
-- task 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một 
 -- Khách hàng nào đó với Id Khách hàng được truyền vào như là 1 tham số của Sp_1
 

 delimiter //
create procedure sp_1(in p_id int)
begin
delete from customer
where customer_id = p_id;
end; //
delimiter ;
 -- task 24.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2
 -- phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
 -- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
 
 select *
 from contract;
 drop procedure if exists sp_2;
 delimiter //
create procedure sp_2  (p_contract_id int, p_customer_id int , p_service_id int ,
						p_date_contract date,p_end_contract date, p_deposit int)
begin
insert into contract (contract_id ,customer_id , service_id  ,
						date_contract  ,end_contract , deposit )
values                (p_contract_id , p_customer_id  , p_service_id  ,
						p_date_contract ,p_end_contract , p_deposit   );

end; //
delimiter ;
 
call sp_2(5,4,3,'2020-12-5','2021-12-5',100);
 
 
 
 
 
 
 
 
 