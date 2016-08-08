INSERT into public.tester (id, first_name, last_name, country, last_login) VALUES ('1','Miguel','Bautista','US','2013-08-04 23:57:38')
INSERT into public.tester (id, first_name, last_name, country, last_login) VALUES ('2','Michael','Lubavin','US','2013-07-12 13:27:18')
INSERT into public.tester (id, first_name, last_name, country, last_login) VALUES ('3','Leonard','Sutton','GB','2013-07-16 21:17:28')
INSERT into public.tester (id, first_name, last_name, country, last_login) VALUES ('4','Taybin','Rutkin','US','2013-01-01 10:57:38')
INSERT into public.tester (id, first_name, last_name, country, last_login) VALUES ('5','Mingquan','Zheng','JP','2013-08-04 22:07:38')
INSERT into public.tester (id, first_name, last_name, country, last_login) VALUES ('6','Stanley','Chen','GB','2013-08-04 21:57:38')
INSERT into public.tester (id, first_name, last_name, country, last_login) VALUES ('7','Lucas','Lowry','JP','2013-07-12 23:57:38')
INSERT into public.tester (id, first_name, last_name, country, last_login) VALUES ('8','Sean','Wellington','JP','2013-08-05 13:27:38')
INSERT into public.tester (id, first_name, last_name, country, last_login) VALUES ('9','Darshini','Thiagarajan','GB','2013-08-05 15:00:38')



INSERT into public.device (id, description) VALUES('1','iPhone 4');
INSERT into public.device (id, description) VALUES('2','iPhone 4S');
INSERT into public.device (id, description) VALUES('3','iPhone 5');
INSERT into public.device (id, description) VALUES('4','Galaxy S3');
INSERT into public.device (id, description) VALUES('5','Galaxy S4');
INSERT into public.device (id, description) VALUES('6','Nexus 4');
INSERT into public.device (id, description) VALUES('7','Droid Razor');
INSERT into public.device (id, description) VALUES('8','Droid DNA');
INSERT into public.device (id, description) VALUES('9','HTC One');
INSERT into public.device (id, description) VALUES('10','iPhone 3');

INSERT into public.experience (tester_id, device_id, experience_points) values ('1','1', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('1','2', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('1','3', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('1','10', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('2','4', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('2','5', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('2','6', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('2','7', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('2','8', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('2','9', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('3','3', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('3','4', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('3','5', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('3','6', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('4','1', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('4','2', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('5','5', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('5','6', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('5','7', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('5','1', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('5','10', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('6','3', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('7','4', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('7','5', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('7','6', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('7','7', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('7','8', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('8','1', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('8','3', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('8','6', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('8','9', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('8','10', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('9','5', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('9','6', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('9','8', '0' );
INSERT into public.experience (tester_id, device_id, experience_points) values ('9','9', '0' );

--TODO ADD bugs