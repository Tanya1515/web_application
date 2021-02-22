— заполнение бд

INSERT INTO Employee (name,  surname, phone, e_mail,  education,  home_address, position, work_experience) VALUES
	('Alexandra', 'Bortich', '89632198432', 'bort@gmail.com', 'MSU, Faculty_of_Law', 'st. Angarskaya, 20, 2', 'associate', 10),
	('Yuri', 'Pavlov', '89636357033', 'pavu@gmail.com', 'MGIMO, Faculty_of_Law', 'st. Maroseyka, 25, 3', 'senior_associate', 11),
	('Andrei', 'Aragin', '89032198433', 'arag@gmail.com', 'MSU, Faculty_of_Law', 'st. Lubyanka, 10, 2','associate', 3),
	('Grisha', 'Kologin', '89033398123', 'kolog@gmail.com', 'MGIMO, Faculty_of_Law', 'st. Dmitrovskaya, 1, 1','paralegal', 15),
	('Anna', 'Panikina', '89032598123', 'panika@gmail.com', 'MSU, Faculty_of_Law', 'st. Sadovniki, 45, 3','partner', 20),
	('Vladimir', 'Panikin', '89032198563', 'panika_vlad@gmail.com', 'MGIMO, Faculty_of_Law', 'st. Planernaya, 33, 5','associate', 7),
	('Vladimir', 'Ivanov', '89032198828', 'iv_vlad@gmail.com', 'SPBGU, Faculty_of_Law', 'st. Obuhova, 24, 3','paralegal', 5),
	('Marina', 'Tarakanova', '89032133828', 'mar11@gmail.com', 'MSU, Faculty_of_Law', 'st. Nikolaeva, 13, 1','associate', 8),
	('Oleg', 'Dubov', '89032198881', 'dubdubom@gmail.com', 'SPBGU, Faculty_of_Law', 'st. Dmitrovskaya, 10, 1','associate', 6),
	('Kirill','Fukov', '89032198882','fukov@gmail.com', 'MSU, Faculty_of_Law', 'st. Lodochnaya, 22, 1','legal_advisor', 4),
	('Anna', 'Kologina', '89033311123', 'kologann@gmail.com', 'SPBGU, Faculty_of_Law', 'st. Leskov, 25, 2 ','legal_advisor', 13),
	('Daria','Kern', '89032198879','kernd@gmail.com', 'MSU, Faculty_of_Law', 'st. Aviamotornaya, 13, 2','lawyer', 5),
	('Daria','Vlasova', '89152298879','vlasd@gmail.com', 'SPBGU, Faculty_of_Law', 'st. Aviamotornaya, 25, 4','partner', 23),
	('Igor', 'Popov', '89043198123', 'igorek@gmail.com', 'MGIMO, Faculty_of_Law', 'st. Lubyanka, 13, 5','senior_associate', 17);

INSERT INTO Service (name_of__service, cost_of__service) VALUES
	('consultation', 5000),
	('document_support', 4000),
	('bankruptcy', 6000),
	('issue_of__shares', 7000),
	('transaction_support', 10000),
	('legal_representation', 5500),
	('restoration_of__documents', 4500),
	('document_creation', 3500),
	('loan_consultation', 6500);

INSERT INTO Client (name, surname, phone, e_mail) VALUES 
	('Maria', 'Stepanova', '89035347071', 'masha_1415@gmail.com'),
	('Elena', 'Gavrilina', '8963347071', 'lena_10415@gmail.com'),
	('Ivan', 'Ushakov', '89035107072', 'vanya11415@gmail.com'),
	('Nikita', 'Pusikov', '89035342271', 'nikpuz@gmail.com'),
	('Kirill', 'Lebedev', '89035207071', 'kirkir@gmail.com'),
	('Valeria', 'Stepanova', '89765347071', 'step1415@gmail.com'),
	('Varvara', 'Kochetova', '89035341071', 'varvar@gmail.com'),
	('David', 'Mishin', '89035197071', 'mishka@gmail.com'),
	('Polina', 'Aravina', '89035348911', 'polya5@gmail.com'),
	('Anna', 'Aravina', '89032198123', 'anna_a@gmail.com'),
	('Anna', 'Stepanova', '89032228123', 'anna_step@gmail.com'),
	('Daria', 'Ushakova', '89032198111', 'dasha_ash@gmail.com');

INSERT INTO Contract (id_employee, id_service, id_client, date_of__begining, date_of__end) VALUES
	(1, 5, 11, '2005-06-20', '2005-07-02'),
	(13, 6, 12, '2022-10-29', '2022-11-08'),
	(12, 3, 3, '2020-07-19', '2020-10-08'),
	(7, 6, 10, '2021-07-08', '2021-11-08'),
	(6, 4, 5, '2020-09-08', '2020-10-08'),
	(5, 1, 6, '2010-09-08', '2010-11-08'),
	(13, 9, 7 , '2019-09-08', '2020-11-08'),
	(5, 2, 7, '2020-07-08', '2021-11-08'),
	(7, 2, 8, '2019-06-08', '2021-11-08'),
	(4, 4, 2, '2018-06-08', '2021-07-08'),
	(4, 3, 1, '2020-07-08', '2021-09-22'),
	(3, 5, 4,  '2020-12-10', '2022-03-08'),
	(11, 6, 5, '2018-06-10', '2019-10-08'),
	(6, 7, 10,  '2021-12-10', '2022-10-08'),
	(5, 8, 2, '2020-07-25', '2022-05-16'),
	(3, 8, 7, '2020-10-26', '2021-10-08'),
	(2, 9, 9, '2019-06-10', '2022-10-17'),
	(1, 1, 11, '2020-12-10', '2023-10-08'),
	(13, 4, 2, '2021-03-10', '2022-01-08'),
	(14, 3, 1, '2020-11-10', '2021-02-08');