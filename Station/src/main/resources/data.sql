INSERT INTO `user` (id, username, password, role)
              VALUES (1,'miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','ADMIN');
INSERT INTO `user` (id, username, password, role)
              VALUES (2,'tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','KORISNIK');
INSERT INTO `user` (id, username, password, role)
              VALUES (3,'petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','KORISNIK');

INSERT INTO company(id, name, address, pib) VALUES (1, 'GreyHound', 'Aaa street', 100200300);
INSERT INTO company(id, name, address, pib) VALUES (2, 'Lasta', 'Bbb street', 400200300);
INSERT INTO company(id, name, address, pib) VALUES (3, 'NisExpres', 'Ccc street', 300200300);
INSERT INTO company(id, name, address, pib) VALUES (4, 'PinginExpres', 'Ddd street', 500200300);
INSERT INTO company(id, name, address, pib) VALUES (5, 'Solaris', 'Eee street', 600200300);

INSERT INTO timetable(id, number_of_seats, ticket_price, departure_time, destination, company_id) 
 VALUES (1, 20, 100, '12:00', 'Beograd', 1);
 INSERT INTO timetable(id, number_of_seats, ticket_price, departure_time, destination, company_id) 
 VALUES (2, 30, 110, '13:00', 'Novi Sad', 2);
 INSERT INTO timetable(id, number_of_seats, ticket_price, departure_time, destination, company_id) 
 VALUES (3, 40, 120, '14:00', 'Podgorica', 3);
 INSERT INTO timetable(id, number_of_seats, ticket_price, departure_time, destination, company_id) 
 VALUES (4, 10, 130, '15:00', 'Kopaonik', 4);
 INSERT INTO timetable(id, number_of_seats, ticket_price, departure_time, destination, company_id) 
 VALUES (5, 20, 140, '16:00', 'Zlatibor', 5);

INSERT INTO reservation (id, timetable_id) VALUES (1,1);
INSERT INTO reservation (id, timetable_id) VALUES (2,2);
INSERT INTO reservation (id, timetable_id) VALUES (3,3);
INSERT INTO reservation (id, timetable_id) VALUES (4,4);
INSERT INTO reservation (id, timetable_id) VALUES (5,5);

