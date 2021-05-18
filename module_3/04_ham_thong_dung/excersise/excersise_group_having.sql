use student_management;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *, max(sj.credit)
from `subject` sj
group by sj.sub_id
having max(sj.credit)  >=all (select max(sj.credit)  from `subject` sj group by sj.sub_id);


-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select `subject`.sub_id, `subject`.sub_name, mark.mark
from `subject`
inner join mark on mark.sub_id = `subject`.sub_id
group by `subject`.sub_id, mark .mark
having mark.mark >= all (select mark from mark group by mark.sub_id);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select student.student_id, student.student_name, AVG(mark.mark )
from student
left join mark on mark.student_id = student.student_id
group by student.student_id
order by mark.mark DESC;
-- done
