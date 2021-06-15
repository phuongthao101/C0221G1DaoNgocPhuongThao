use casestudy2;

insert into customer_type(customer_type_name)
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
(4,'Huynh Tan Hai','nam', '1990/12/05', '20123595', '02585696695', 'khoa@gmail.com', 'Quang Tri'),
(5,'Huynh Tan Nam','nam', '1990/12/05', '20123595', '02585696695', 'khoa@gmail.com', 'Quang Tri');

INSERT INTO `position`(position_name)
VALUES ("bảo vệ"),
	("phục vụ"),
	("lễ tân"),
	("quản lý"),
    ("giám đốc");
    insert into education_degree(education_degree_name)
values ("lao động phổ thông "),
("trung cấp "),
("cao đẳng"),
("đại học "),
("sau đại học ");

insert into division(division_name)
values ("bảo an"),
	("nhân sự"),
    ("hành chính"),
    ("quản lí"),
    ("giám đốc");
    insert into `user`
  values ("Thuy hoang1","12345"),
		("Thuy hoang2","12345"),
		("Thuy hoang3","12345");
        insert into employee(  employee_name,position_id,education_degree_id,division_id,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,username )
values ("Duong Thanh Hau",1,1,1,"1997-02-24","194571756",15000000,"0399191054","thanhhau026@gmail.com","quang binh",null),
 ("Nguyen Phuong Nam",2,2,2,"1999-12-12","123456789",10000000,"0333313033","nam11@gmail.com","Da Nang",null),
("Dao Thao",3,3,3,"1993-12-12","123456789",10000000,"03932323223","thao22@gmail.com","quang binh",null),
("Le Phuoc Sy Phu",4,4,4,"1995-12-12","123400789",15000000,"03932323220","phule@gmail.com","Quang Tri",null),
("Nguyen Van cuong",5,5,5,"1997-12-12","10010000100",10000000,"03932323211","thao22@gmail.com","quang binh",null);
insert into rent_type(rent_type_name,rent_type_cost)
values ("6h",500000),
	("12h",200000),
	("24h",400000),
	("48h",800000),
	("72h",3000000);
    
    
insert into service_type(service_type_name)
values  ("room"),
		("house"),
		("villa"),
		("room vp"),
		("villa vp");
    insert into service(service_name,service_area,service_cost,service_max_people,service_type_id,rent_type_id,standard_room,description_other_convenience,pool_area,number_of_floors)
values ("house",20,2,3,1,1,"ok","close",50,3),
	   ("villa1",25,3,3,2,2,"ok","open",60,2),
	   ("villa2",26,3,3,2,2,"ok","open",60,4),
	   ("villa3",27,3,3,2,2,"ok","open",60,2),
	   ("villa5",28,3,3,2,2,"ok","open",55,4);
       insert into contract (employee_id,customer_id,service_id,start_date,end_date,deposit,total_money)values 
       (1,1,11,"2018-08-11","2019-10-10",5000,10000),
		(2,2,12,"2016-11-11","2017-11-11",3000,2000),
		(3,3,13,"2021-10-11","2021-11-11",5000,1000),
		(4,4,14,"2020-11-11","2022-11-11",15000,5000),
		(4,5,15,"2020-11-11","2021-11-11",6000,3000);
        



    


