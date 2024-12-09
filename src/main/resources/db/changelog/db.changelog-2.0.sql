--liquibase formatted sql

--changeset dealer:1
insert into dealer.category (body) values ('SEDAN'), ('WAGON'), ('HATCHBACK'), ('CROSSOVER'), ('COUPE')
--changeset dealer:2
insert into dealer.car_showroom (name_of_showroom, address_of_showroom)
values ('Лозанж Lada', 'просп. Дзержинского, 134'), ('Атлант-М Сухарево', 'ул. Шаранговича, 22, корп. 1')
--changeset dealer:3
insert into dealer.client (date_of_registration, name_of_customer)
values ('2022-12-25', 'Иванов Иван Иванович'), ('2024-12-03', 'Сидоров Сидор Сидорович'), ('2021-03-16', 'Петров Петр Петрович')
--changeset dealer:4
insert into dealer.contact (client_id, contacts)
values (1, 'Минск, просп. Мира, 1 этаж 1'), (2, 'Минск, Аэродромная ул., 30, 8 этаж'), (3, 'Минск, ул. Николы Теслы, 18')
--changeset dealer:5
insert into dealer.car (price, year, showroom_id, category_id, car_brand, car_model)
values (1769000, 2009, 1, 4, 'Land Rover', 'Discovery'), (800000, 2018, 2, 3, 'Ford', 'Focus'), (38000000, 2021, 1, 5, 'Ferrary', 'F8 Tributo'),
       (2000000, 2016, 2, 1, 'Toyota', 'Camry XV50'), (270000, 1997, 1, 2, 'Audi', 'A6 C5'), (1650000, 2014, 2, 1, 'Infinity', 'Q50'),
       (30500000, 2010, 1, 5, 'Mercedes', 'SLS AMG'), (500000, 2008, 2, 2, 'Volkswagen', 'Passat B6'), (2550000, 2019, 1, 4, 'Hyandai', 'Tucson 3'),
       (415000, 2015, 2, 1, 'Hyandai', 'Solaris'), (1900000, 2017, 1, 3, 'Skoda', 'Octavia 3')
--changeset dealer:6
insert into dealer.review (rating, car_id, client_id, text_review)
values (7, 11, 1, 'дешевый в обслуживании автомобиль. экономичный двигатель 1.6'), (8, 10, 2, 'Хорошая машина, безотказная'),
       (8, 9, 3, 'Комфортный,экономичный,хорошая шумоизоляция')