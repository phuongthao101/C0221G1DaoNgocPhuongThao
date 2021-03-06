drop database if exists casestudy2;
create database if not exists casestudy2;
use casestudy2;

create table customer_type(
customer_type_id int auto_increment primary key,
customer_type_name varchar(45)
);
create table customer(
customer_id int auto_increment primary key ,
type_customer_id int ,
customer_name varchar (45),
gender varchar (45),
birthday date ,
id_card varchar (45),
phone varchar (45),
email varchar (45),
address varchar (45),
foreign key(type_customer_id) references customer_type(customer_type_id) on delete cascade on update cascade) ;

create table service_type (
service_type_id int  auto_increment primary key,
service_type_name varchar (45)
);

create table rent_type(
rent_type_id int  auto_increment primary key,
rent_type_name varchar (45),
rent_type_cost int
);


create table service (
 service_id int auto_increment primary key,
    service_name varchar (45),
    service_area int,
    service_cost double,
   service_max_people int,
 rent_type_id int,
    service_type_id int,
 standard_room varchar (45),
 description_other_convenience varchar(45),
 pool_area double,
   number_of_floors int,
foreign key (rent_type_id ) references rent_type(rent_type_id)on delete cascade on update cascade ,
foreign key (service_type_id) references service_type(service_type_id)on delete cascade on update cascade 
);

create table `position` (
position_id int auto_increment primary key,
position_name varchar(45));

create table education_degree(
education_degree_id int auto_increment primary key,
education_degree_name varchar(45));

create table division(
division_id int auto_increment primary key,
division_name varchar (45));

create table `user` (
username varchar(45),
`password` varchar(45))
;

create table employee(
employee_id int auto_increment primary key,
employee_name varchar (45),
employee_birthday date,
employee_id_card varchar(45),
employee_salary double,
employee_phone varchar (45),
employee_email varchar (45),
employee_address varchar(45),
position_id int,
education_degree_id int,
division_id int,
username varchar(45),

foreign key (position_id) references position (position_id)on delete cascade on update cascade ,
foreign key (education_degree_id) references education_degree (education_degree_id)on delete cascade on update cascade ,
foreign key (division_id) references division (division_id)on delete cascade on update cascade 
);

create table contract (contract_id int auto_increment primary key, start_date date,
 end_date date, deposit int, total_money int, employee_id int ,customer_id int , service_id int ,
 foreign key(employee_id) references employee(employee_id)on delete cascade on update cascade ,
 foreign key(customer_id) references customer(customer_id)on delete cascade on update cascade ,
 foreign key(service_id) references service(service_id)on delete cascade on update cascade );

-- insert into contract (start_date, end_date, deposit, total_money, employee_id,customer_id, service_id)
-- values
--  ('2020/12/04', '2021/12/04', 20,300,4,4,6);

-- SET FOREIGN_KEY_CHECKS=1;

-- delete from service_type
-- where service_type_id between 4 and 6;


create table attach_service(
attach_service_id int auto_increment primary key,
attach_service_name varchar(45),
attach_service_cost double,
attach_service_unit int,
attach_service_status varchar (45)
);

create table contract_detail (
contract_detail_id int auto_increment primary key,
contract_id int,
attach_service_id int,
quantity int,
foreign key (contract_id) references contract(contract_id) on delete cascade,
foreign key(attach_service_id) references attach_service(attach_service_id) on delete cascade);

-- customer, contract, contract_detail, attach_service)
select * from customer;
select * from contract;
select* from contract_detail;
select * from attach_service;
select * from service;

create view customer_view as
select customer.customer_id, customer.customer_name, customer.phone, service.service_name,contract.contract_id, 
contract.start_date,contract.end_date,attach_service.attach_service_name,contract_detail.quantity
from customer 
inner join contract on contract.customer_id = customer.customer_id
inner join service on service.service_id = contract.service_id
inner join contract_detail on contract.contract_id = contract_detail.contract_id
inner join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id
where now() between contract.start_date and contract.end_date
group by contract.contract_id;

select * from customer_view;

create view show_attach_service as
select con.contract_id,att.attach_service_name,cd.quantity
from contract con 
join contract_detail cd on con.contract_id = cd.contract_id
join attach_service att on cd.attach_service_id = att.attach_service_id;
select * from show_attach_service;
select * from customer_view;
SET FOREIGN_KEY_CHECKS=0;
delete from contract where contract_id = 9;

select * from contract;


alter table contract_detail
drop constraint contract_detail_ibfk_1;

alter table contract_detail
add constraint contract_detail_ibfk_1 FOREIGN KEY (contract_id) REFERENCES contract(contract_id)
on delete cascade;
