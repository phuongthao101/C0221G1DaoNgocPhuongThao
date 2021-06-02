use casestudy2;

insert into type_custumer(customer_type_name)
values
("Diamond"),
("Platinium"),
("Gold"),
("Silver"),
("Member");


insert into customer (type_customer_id,customer_name, gender,birthday, id_card, phone, email, address)
values
(1,'Huynh Tan', 'nam','1998/5/6', '20123598', '02585696696', 'hong@gmail.com', 'Da Nang'),
(2,'Tran Yen', 'nam','1997/5/8', '20123597', '02585696697', 'khai@gmail.com', 'Quang Tri'),
(3,'Nguyen Hung','nam', '1995/12/09', '20123595', '02585696695', 'huy@gmail.com', 'Quang Nam'),
(4,'Huynh Tan Nam','nam', '1990/12/05', '20123595', '02585696695', 'khoa@gmail.com', 'Quang Tri');


