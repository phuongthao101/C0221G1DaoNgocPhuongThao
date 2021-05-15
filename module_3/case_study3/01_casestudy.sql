drop database if exists casestudy;
create database if not exists casestudy;
use casestudy;
create table type_custumer (
type_customer_id  int auto_increment primary key ,
name_customer varchar (45)
);
create table `position` (
position_id int auto_increment primary key ,
position_name varchar (50));

create table department (
department_id  int auto_increment primary key,
department_name varchar (20));
create table `level` (
level_id int auto_increment primary key,
`level` varchar (45));
create table staff(
staff_id int auto_increment primary key ,
`name` varchar (50),
position_id int ,
level_id int,
department_id int,
birthday date ,
id_card int (45),
salary varchar (45),
phone varchar (45),
email varchar (45),
address varchar (45),
foreign key (position_id) references `position`(position_id),
foreign key(level_id) references `level` (level_id),
foreign key(department_id) references department(department_id) 
);

create table type_rent(
type_rent_id int  auto_increment primary key,
type_rent_name varchar (45)
);
create table type_service (
type_service_id int  auto_increment primary key,
type_service_name varchar (45)
);
create table service (
service_id int auto_increment primary key,
service_name varchar (45),
area int,
number_floor int ,
number_people varchar(45),
price varchar (45),
type_rent_id int,
type_service_id int,
`status` varchar (45),
foreign key (type_rent_id ) references type_rent(type_rent_id),
foreign key (type_service_id) references type_service(type_service_id)
);

create table extra_service (
extra_service_id int auto_increment  primary key,
extra_service_name varchar (45),
price int,
unit int,
`status` varchar (45)
);

create table customer(
customer_id int auto_increment primary key ,
type_customer_id int ,
customer_name varchar (45),
birthday date ,
id_card varchar (45),
phone varchar (45),
email varchar (45),
address varchar (45),
foreign key(type_customer_id) references type_custumer(type_customer_id));
create table contract (
contract_id int auto_increment primary key,
staff_id int,
customer_id int,
service_id int,
date_contract date,
end_contract date,
deposit int,
total_price int,
foreign key (staff_id) references staff (staff_id),
foreign key(customer_id) references customer (customer_id),
foreign key(service_id) references service (service_id)
);

create table contract_detail (
contract_detail_id int auto_increment primary key ,
contract_id int,
extra_service_id int,
amount int,
foreign key (contract_id) references contract(contract_id),
foreign key (extra_service_id) references extra_service(extra_service_id)
);
----------------------------------------------------






