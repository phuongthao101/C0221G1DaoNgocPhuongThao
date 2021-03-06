
create database mark_management;
use mark_management;
create table student (
student_id int primary key,
student_name varchar (50),
birthday date,
class varchar (20),
gender varchar (20)
);
create table `subject`(
subject_id int ,
subject_name varchar (45)
);
create table mark (
student_id int,
subject_id int,
mark int,
date_test date,
primary key (student_id, mark_id),
foreign key (student_id) references student (student_id),
foreign key (subject_id) references `subject` (subject_id) 
);
create table teacher (
teacher_id int primary key,
teacher_name varchar (45),
phone varchar (10)

);
