use student_management;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *
from `subject` sj
group by sj.sub_id
having sj.credit >=all (select credit from `subject`);


-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select *
from `subject`
inner join mark on mark.sub_id = `subject`.sub_id
group by `subject`.sub_id
having mark.mark >= all (select mark from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select student.student_id, student.student_name, AVG(mark)
from student
inner join mark on mark.student_id = student.student_id
group by student.student_id
order by mark.mark DESC;
-- done
