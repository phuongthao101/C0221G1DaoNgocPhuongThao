create database if not exists  mark_management;
use mark_management;
create table student (
student_id varchar (20) primary key,
student_name varchar (50),
birthday date,
class varchar (20),
gender varchar (20)
);
create table `subject`(
subject_id varchar (20) primary key,
subject_name varchar (45)
);
create table mark (
student_id varchar (20),
subject_id varchar (20),
mark int,
date_test date,
primary key (student_id, subject_id),
foreign key (student_id) references student (student_id),
foreign key (subject_id) references `subject` (subject_id) 
);
create table teacher (
teacher_id varchar(20) primary key,
teacher_name varchar (45),
phone varchar (10)
);
alter table `subject`
add teacher varchar (20);
alter table `subject` 
add constraint FK_teacher_id FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id); 