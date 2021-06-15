drop database if exists Internship;
create database if not exists Internship;
use Internship;
create table project (	project_id int auto_increment  primary key,
						project_name varchar(30), expense int ,
						place_of_intern varchar(30));
                        
create table faculty (faculty_id int auto_increment primary key,
					  faculty_name varchar (30), phone varchar (10));
                      
create table instructor (instructor_id int auto_increment  primary key,
						instructor_name varchar (10), salary int, 
                        faculty_id int,
						foreign key (faculty_id)  references faculty(faculty_id));
                        
 create table student (student_id int auto_increment  primary key, student_name varchar(40), faculty_id int,
						foreign key (faculty_id) references faculty (faculty_id) ,
                        date_of_birth date, place_of_birth varchar (30));
                        
 create table instructor_student(
								project_id int ,
								instructor_id int,
								student_id int,
								foreign key (student_id ) references student (student_id) ,
								foreign key (project_id) references project (project_id) ,
								foreign key (instructor_id) references instructor (instructor_id),
								grade int);
                                
  -- -----------------------------------------------------------
  insert into project (project_name , expense , place_of_intern)
  values 
  ( 'A', 100, 'Da Nang'),
  ( 'B', 200, 'Quang Tri'),
  ( 'C', 200, 'Quang Nam'),
  ( 'D', 400, 'Da Nang');
  
  insert into faculty (faculty_name , phone )
  values 
  ('DIA LY ', '0902565656'),
  ('QLTN', '0902565656'),
  ('CONG NGHE SINH HOC', '0902565656'),
  ('TOAN', '0902565656');
  
  insert into instructor (instructor_name , salary, faculty_id)
  values
  ('Mr.Hai', 100, 1),
  ('Mr.Tien', 100, 2),
  ('Mr.Trung', 100, 3),
  ('Mr.Chanh', 100, 4);
  
  insert into student (student_name, faculty_id, date_of_birth, place_of_birth)
  values
  ('Thanh Hau', 1, '1997/12/12', 'Quang Binh' ),
  ('Anh Toan', 2, '1997/12/12', 'Quang Nam' ),
  ('Phuong Nam', 3, '1997/12/12', 'Da Nang' ),
  ('Khanh Ha', 4, '1997/12/12', 'Quang Binh' );
  
  insert into instructor_student (project_id, instructor_id, student_id, grade)
  values
  (1,1,1,10),
  (2,2,2,12),
  (3,3,3,9),
  (4,4,4,10);
  -- ---------------------------------------------------------
  -- 1.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của tất cả các giảng viên
select instructor.instructor_id, instructor.instructor_name, faculty.faculty_name
from instructor 
join faculty on faculty.faculty_id = instructor.faculty_id ;

-- 2.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của các giảng viên của khoa ‘DIA LY va QLTN’

select instructor.instructor_id, instructor.instructor_name, faculty.faculty_name
from instructor 
join faculty on faculty.faculty_id = instructor .faculty_id
where faculty.faculty_name between 'DIA LY' and 'QLTN';


-- 3.	Cho biết số sinh viên của khoa ‘CONG NGHE SINH HOC’
select student.student_id , student.student_name, faculty.faculty_name, count(student.student_id)
from student
join faculty on faculty.faculty_id = student.faculty_id
where faculty.faculty_name = 'CONG NGHE SINH HOC'
group by student.student_id;

-- 4.	Đưa ra danh sách gồm mã số, họ tên và tuổi của các sinh viên khoa ‘TOAN’
select student.student_id , student.student_name, student.date_of_birth, faculty.faculty_name
from student
join faculty on faculty.faculty_id = student. faculty_id
where faculty.faculty_name = 'TOAN';

-- 5.	Cho biết số giảng viên của khoa ‘CONG NGHE SINH HOC’
select count(instructor.instructor_id) as instructor_number
from instructor 
join faculty on faculty.faculty_id = instructor.faculty_id
where faculty.faculty_name = 'CONG NGHE SINH HOC';

-- 6.	Cho biết thông tin về sinh viên không tham gia thực tập
select student_name,date_of_birth,place_of_birth
from student
where not exists (select student.student_id from  instructor_student where student.student_id = instructor_student.student_id);

-- 7.	Đưa ra mã khoa, tên khoa và số giảng viên của mỗi khoa
select faculty.faculty_id, faculty.faculty_name, count(faculty.faculty_id) as instuctor_number
from instructor
join faculty on instructor.faculty_id = faculty.faculty_id
group by faculty.faculty_id,faculty.faculty_name ;
select* from student;




















                             
