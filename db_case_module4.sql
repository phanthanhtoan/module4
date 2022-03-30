use case_study;
insert into `position` values
(1,'le tan'),
(2, 'phuc vu'),
(3, 'chuyen vien'),
(4,'giam sat'),
(5, 'quan ly'),
(6, 'giam doc');

insert into `education_degree` values
(1,'trung cap'),
(2,'cao dang'),
(3,'dai hoc'),
(4,'sau dai hoc');

insert into `division` values
(1,'sale – marketing'),
(2,'hanh chinh'),
(3,'phuc vu'),
(4,'quan ly');

insert into `role` values
(1,'ROLE_ADMIN'),
(2,'ROLE_USER'),
(3,'ROLE_SHOP');

insert into `user`(username,`password`) values
('toan','12345'),
('toan2','12345'),
('toan3','12345'),
('toan4','12345');

insert into `user_role`values
(1,'toan'),
(2,'toan2'),
(3,'toan3');
insert into `employee`
values
(1, 'Da Nang','2000-12-27','toan123@gmail.com','123123123456','Phan Thanh Toàn','0399885400',10000000,1,1,1,'toan');
-- insert into `employee`
-- values
-- (1, 'Phan Thanh Toàn','2000-12-27','123123123456',10000000,'0399885400','toan123@gmail.com','Da Nang',1,1,1,'toan'),
-- (2, 'Đặng Văn Hiếu','2000-12-27','123123123789',10000000,'0399885400','toan1234@gmail.com','Da Nang',1,2,3,'toan3'),
-- (3, 'Trương Tấn Hải','2000-12-27','123123123123',10000000,'0399885400','toan12345@gmail.com','Da Nang',2,2,2,'toan2'),
-- (4, 'Trương Tấn Hải','2000-12-27','123123123123',10000000,'0399885400','toan12345@gmail.com','Da Nang',2,2,2,'toan2'),
-- (5, 'Trương Tấn Hải','2000-12-27','123123123123',10000000,'0399885400','toan12345@gmail.com','Da Nang',2,2,2,'toan2'),
-- (6, 'Trương Tấn Hải','2000-12-27','123123123123',10000000,'0399885400','toan12345@gmail.com','Da Nang',2,2,2,'toan2');


insert into `customer_type` values
(1,'Diamond'),
(2,'Platinium'),
(3,'Gold'),
(4,'Silver'),
(5,'Member');

insert into `customer`values
(1,'Da Nang','1998-02-02','hai@gmail.com',1,'123123123477','Truong Tan Hai','0957740069',1);
-- insert into `customer`values
-- (1,1,'Truong Tan Hai','1998-02-02',1,'123123123477','0957740069','hai@gmail.com','Da Nang'),
-- (2,2,'Truong Tan Beo','1998-02-02',1,'923123123479','0997740069','hai1@gmail.com','Quang Ngai'),
-- (3,2,'Truong Tan Beo','1998-02-02',1,'923123123470','0997740060','hai0@gmail.com','Quang Ngai'),
-- (4,1,'Truong Tan Vui','1998-02-02',0,'723123123437','0657740059','hai2@gmail.com','Da Nang'),
-- (5,1,'Truong Tan Vui','1998-02-02',0,'723123123437','0657740059','hai2@gmail.com','Da Nang'),
-- (6,1,'Truong Tan Vui','1998-02-02',0,'723123123437','0657740059','hai2@gmail.com','Da Nang'),
-- (7,1,'Truong Tan Vui','1998-02-02',0,'723123123437','0657740059','hai2@gmail.com','Da Nang');

insert into `service_type` values 
(1,'Villa'), 
(2,'House'), 
(3,'Room');

insert into `rent_type` values
(1,'Year', 105000), 
(2,'Month', 35000), 
(3,'Day', 25000),
(4,'Hour', 7984);

insert into `service`
values 
(1,'Villa',50,100000,5,1,1,null,null,null,null),
(2,'House',50,100000,5,2,2,null,null,null,null),
(3,'House',50,100000,5,3,2,null,null,null,null),
(4,'Room',50,100000,5,4,3,null,null,null,null);

insert into `contract` 
values
(1,5000000,'2021-02-24','2021-02-06',  10000000,1, 1, 1);
-- insert into `contract` 
-- values
-- (1,'2021-02-06', '2021-02-24', 5000000,10000000,1, 2, 1),
-- (2,'2021-02-06', '2021-02-24', 5000000,10000000,2, 1, 2),
-- (3,'2020-02-06', '2020-02-24', 5000000,10000000,3, 3, 3);

insert into `attach_service` values
(1, 500000,'massage', 'full',1000 );

-- insert into `attach_service` values
-- (1,'massage', 500000, 1000, 'full'),
-- (2,'karaoke', 500000, 1000, 'full'),
-- (3,'thuc an', 500000, 1000, 'full'),
-- (4,'nuoc uong', 500000, 1000, 'full'),
-- (5,'thue xe', 500000, 1000, 'still');

insert into `contract_detail` values
(1,1,1,1);