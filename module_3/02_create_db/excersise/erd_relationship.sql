create database if not exists ERD_relationship;
use ERD_relationship;
create table supplier (
supplier_id int primary key,
supplier_name varchar (50),
address varchar (50),
phone varchar (20)
);
create table `order` (
order_id int primary key,
order_date date,
supplier_id int,
foreign key (supplier_id) references supplier (supplier_id)
);
create table product(
product_id int primary key,
product_name varchar(50)
);
create table `export`(
export_id int primary key,
export_date date
);
create table `import` (
import_id int primary key,
import_date date
);
create table export_product(
export_id int,
product_id int,
constraint pk_export_product primary key (export_id, product_id),
foreign key (export_id) references `export` (export_id),
foreign key(product_id) references product (product_id), 
export_price varchar(50),
amount_export varchar (50)
);
create table import_product(
import_id int,
product_id int,
constraint pk_import_product primary key (import_id, product_id),
foreign key (import_id) references `import` (import_id),
foreign key(product_id) references product (product_id), 
inport_price varchar(50),
amount_inport varchar (50)
);
create table order_product(
order_id int,
product_id int,
constraint pk_order_product primary key (order_id, product_id),
foreign key (order_id) references `order` (order_id),
foreign key(product_id) references product (product_id)
);







