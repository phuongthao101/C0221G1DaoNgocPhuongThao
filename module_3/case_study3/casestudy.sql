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
insert into contract (date_contract, end_contract, deposit, total_price)
values 
('2021/12/5', '2022/12/5', 100,2000),
 ('2021/12/5', '2022/12/5', 200,2000),
 ('2021/12/5', '2022/12/5', 100,3000);

insert into contract_detail (amount)
values 
(100),
(200),
(100);
insert into customer (customer_name, birthday, id_card, phone, email, address)
values
('Nguyen Hong', '1998/5/6', '20123598', '02585696696', 'hong@gmail.com', 'da nang'),
('Nguyen Khai', '1997/5/8', '20123597', '02585696697', 'khai@gmail.com', 'da nang'),
('Nguyen Tin', '1996/5/7', '20123595', '02585696695', 'tin@gmail.com', 'da nang');
insert into department (department_name)
values 
('Ban hang'),
('hanh chinh'),
('phuc vu'),
('quan ly');
insert into extra_service (extra_service_name, price, unit, `status`)
values 
('massage', 100, 1, 'co san'),
('karaoke', 100, 1, 'co san'),
('thức ăn', 100, 1, 'co san'),
('nước uống', 100, 1, 'co san'),
('thuê xe di chuyển', 100, 1, 'co san');

insert into `level` (`level`)
values 
('trung cap'),
('cao dang'),
('dai hoc');

insert into `position` (position_name)
values 
('le tan'),
('phuc vu'),
('chuyen vien'),
('giam sat'),
('quan ly'),
('giam doc');
insert into service (service_name, area, number_floor, number_people, price, `status`)
values 
('villa', 50, 20,' 100', '2500', 'co san' ),
('house', 50, 20,' 100', '1500', 'co san' ),
('room', 50, 20,' 100', '500', 'co san' );
insert into staff(`name`, birthday, id_card, salary, phone, email, address)
values 
('Nguyen A', '1998/5/5', 0215593478, '500','0956565669', 'nguyenA@gmail.com', 'Quang Nam' ),
('Nguyen B', '1998/6/5', 0215593478, '400','0956565236', 'nguyenB@gmail.com', 'Binh Dinh' );
insert into type_customer(name_customer)
values
('Diamond'),
('Platinium'),
('Gold');

insert into type_rent (type_rent_name)
values 
('Ngan han'),
('Dai han');
insert into type_service (type_service_name)
values ('Cao cap'),
('Trung cap');
