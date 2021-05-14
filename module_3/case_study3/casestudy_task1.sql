use casestudy;
insert into `level` (`level`)
values 
('trung cap'),
('cao dang'),
('dai hoc'),
("Sau Dai Hoc");

insert into `position` (position_name)
values 
('le tan'),
('phuc vu'),
('chuyen vien'),
('giam sat'),
('quan ly'),
('giam doc');
insert into type_rent (type_rent_name)
values 
("Nam",1200),
("Thang",150),
("Ngay",10),
("Gio",2);
insert into type_custumer(name_customer)
values
("Diamond"),
("Platinium"),
("Gold"),
("Silver"),
("Member");
insert into extra_service (extra_service_name, price, unit, `status`)
values 
('massage', 100, 1, 'co san'),
('karaoke', 100, 1, 'co san'),
('thức ăn', 100, 1, 'co san'),
('nước uống', 100, 1, 'co san'),
('thuê xe di chuyển', 100, 1, 'co san');
insert into department (department_name)
values 
('Ban hang'),
('hanh chinh'),
('phuc vu'),
('quan ly');
insert into type_service (type_service_name)
values ('villa'),
('house'),
('room');


insert into customer (type_customer_id,customer_name, birthday, id_card, phone, email, address)
values
(1,'Huynh Tan', '1998/5/6', '20123598', '02585696696', 'hong@gmail.com', 'Da Nang'),
(2,'Tran Yen', '1997/5/8', '20123597', '02585696697', 'khai@gmail.com', 'Quang Tri'),
(3,'Nguyen Hung', '1995/12/09', '20123595', '02585696695', 'huy@gmail.com', 'Quang Nam'),
(4,'Huynh Tan Nam', '1990/12/05', '20123595', '02585696695', 'khoa@gmail.com', 'Quang Tri');

insert into staff(`name`,position_id, level_id, department_id, birthday, id_card, salary, phone, email, address)
values 
('Nguyen Tran Phan',1,1,1, '1998/5/5', 0215593478, '500','0956565669', 'nguyenA@gmail.com', 'Quang Nam' ),
('Pham Dong',2,2,2, '1998/6/5', 0215593478, '400','0956565236', 'nguyenB@gmail.com', 'Da Nang' ),
('Nguyen Anh Huy ',3,3,3, '1998/6/5', 0215593478, '400','0956565236', 'nguyenB@gmail.com', 'Nam Dinh' ),
('Huynh Anh Hao',4,4,4, '1998/6/5', 0215593478, '400','0956565236', 'nguyenB@gmail.com', 'Binh Dinh' );

insert into service (service_name, area, number_floor, number_people, price,type_rent_id, type_service_id, `status`)
values 
('villa1', 50, 20,'100', '2500',1,1, 'co san' ),
('house1', 50, 20,'100', '1500',2,2, 'co san' ),
('room1', 50, 20,'100', '1500',2,2, 'co san' );


insert into contract (staff_id, customer_id, service_id,date_contract,  end_contract, deposit, total_price)
values 
(1,1,1,'2021/12/5', '2022/12/5', 100,2000),
 (2,2,2,'2021/12/5', '2022/12/5', 200,2000),
 (3,3,3,'2021/12/5', '2022/12/5', 300,5000),
 (4,4,4,'2021/12/5', '2022/12/5', 400,3000);
 

insert into contract_detail (contract_id, extra_service_id,amount)
values 
(1,1,100),
(2,2,200),
(3,3,200),
(4,4,200);