use student_management;
select*
from student ;
-- Hiển thị danh sách các học viên đang theo học.
select *
from student 
where `status` = true;
-- Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.
select *
from `subject`
where credit <10;
-- Hiển thị danh sách học viên lớp A1

select student.student_name, class.class_name
from student 
inner join class 
on student.class_id = class.class_id
where class.class_name = "A1";

-- Hiển thị điểm môn CF của các học viên

select  mark.mark, student.student_name, `subject`.sub_name, student.student_id
from student
 join mark 
on student.student_id = mark.student_id
join`subject`
on `subject`.sub_id =  mark.sub_id
where `subject`.sub_name = 'CF';










