drop database if exists casestudy2;
create database if not exists casestudy2;
use casestudy2;

create table customer_type(
customer_type_idservice_type int auto_increment primary key,
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
foreign key(type_customer_id) references customer_type(customer_type_id));

create table service_type (
service_type_id int  auto_increment primary key,
service_type_name varchar (45)
);

create table rent_type(
rent_type_id int  auto_increment primary key,
rent_type_name varchar (45)
);
alter table rent_type
add rent_type_cost int;

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
foreign key (rent_type_id ) references rent_type(rent_type_id),
foreign key (service_type_id) references service_type(service_type_id)
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
eemployee_phone varchar (45),
employee_email varchar (45),
employee_address varchar(45),
position_id int,
education_degree_id int,
division_id int,
username varchar(45),

foreign key (position_id) references position (position_id),
foreign key (education_degree_id) references education_degree (education_degree_id),
foreign key (division_id) references division (division_id)
);





