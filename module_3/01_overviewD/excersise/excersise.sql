create database if not exists 01_overview;
create table Teacher (
id int (10),
 `name` varchar(50),
age int (10),
country varchar(50)
);

insert into Teacher (id,`name`, age, country)
values (1,"Thao", 25, "VN"), 
(2,"Thao 2" , 21, "My"), 
(3,"Thao 3", 26, "VN");

update Teacher
set `name` = "Thao 1"
where id = 2;

delete from teacher
where id =3;

select *
from Teacher;






