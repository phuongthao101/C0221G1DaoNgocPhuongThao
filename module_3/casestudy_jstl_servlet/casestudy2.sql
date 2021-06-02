drop database if exists casestudy2;
create database if not exists casestudy2;
use casestudy2;

create table type_custumer (
type_customer_id  int auto_increment primary key ,
customer_type_name varchar (45)
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
foreign key(type_customer_id) references type_custumer(type_customer_id));
