use student_management;
INSERT INTO Class(class_name, start_date, `status`)
VALUES ('A1', '2008-12-20', 1);
INSERT INTO Class(class_name, start_date, `status`)
VALUES ( 'A2', '2008-12-22', 1);
INSERT INTO Class(class_name, start_date, `status`)
VALUES ( 'B3', '2008-12-23', 0);
INSERT INTO student (student_name, address, phone, `status`, class_id)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO student (student_name, address, phone, `status`, class_id)
VALUES ('Hoa', 'Hai phong', '0905666444',1, 1);

INSERT INTO student (student_name, address, phone, `status`, class_id)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO `subject`(sub_name, credit, `status`)
VALUES ( 'CF', 5, 1),
       ('C', 6, 1),
       ('HDJ', 5, 1),
       ('RDBMS', 10, 1);
INSERT INTO mark (sub_id, student_id, mark, exam_times)
VALUES (1,1,10,1),
 (2,2,8,1),
 (3,3,9,1);


