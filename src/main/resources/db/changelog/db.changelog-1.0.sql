--liquidbase formatted sql

--changeset dealer:1
CREATE TABLE dealer.category (
                                 category_id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
                                 body varchar(255) NULL,
                                 CONSTRAINT category_body_check CHECK (((body)::text = ANY ((ARRAY['SEDAN'::character varying, 'WAGON'::character varying, 'HATCHBACK'::character varying, 'CROSSOVER'::character varying, 'COUPE'::character varying])::text[]))),
                                 CONSTRAINT category_pkey PRIMARY KEY (category_id)
);
--changeset dealer:2
CREATE TABLE dealer.car_showroom (
                                     showroom_id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
                                     address_of_showroom varchar(255) NULL,
                                     name_of_showroom varchar(255) NULL,
                                     CONSTRAINT car_showroom_pkey PRIMARY KEY (showroom_id)
);
--changeset dealer:3
CREATE TABLE dealer.client (
                               date_of_registration date NULL,
                               client_id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
                               name_of_customer varchar(255) NULL,
                               CONSTRAINT client_pkey PRIMARY KEY (client_id)
);
--changeset dealer:4
CREATE TABLE dealer.contact (
                                client_id int8 NOT NULL,
                                contacts varchar(255) NULL,
                                CONSTRAINT fkt0lxtgfimywi23cewqbmgdu62 FOREIGN KEY (client_id) REFERENCES dealer.client(client_id)
);
--changeset dealer:5
CREATE TABLE dealer.car (
                            price numeric(38, 2) NULL,
                            "year" int4 NOT NULL,
                            car_id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
                            category_id int8 NULL,
                            showroom_id int8 NULL,
                            car_brand varchar(255) NULL,
                            car_model varchar(255) NULL,
                            CONSTRAINT car_pkey PRIMARY KEY (car_id),
                            CONSTRAINT fk377w213doepxacos5ptnph70e FOREIGN KEY (category_id) REFERENCES dealer.category(category_id),
                            CONSTRAINT fk8fs0ec17lxfosjwi0dfr23owc FOREIGN KEY (showroom_id) REFERENCES dealer.car_showroom(showroom_id)
);
--changeset dealer:6
CREATE TABLE dealer.car_client (
                                   car_id int8 NOT NULL,
                                   client_id int8 NOT NULL,
                                   CONSTRAINT fk9utyys3shhy4vsr6ewx3byd6x FOREIGN KEY (car_id) REFERENCES dealer.car(car_id),
                                   CONSTRAINT fkgpx1jgi5drr4q9twtmaksv90r FOREIGN KEY (client_id) REFERENCES dealer.client(client_id)
);
--changeset dealer:7
CREATE TABLE dealer.review (
                               rating int4 NOT NULL,
                               car_id int8 NULL,
                               client_id int8 NULL,
                               review_id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
                               text_review varchar(255) NULL,
                               CONSTRAINT review_pkey PRIMARY KEY (review_id),
                               CONSTRAINT fkhr2oxqr7hu3upmi4hvg9g0ghp FOREIGN KEY (client_id) REFERENCES dealer.client(client_id),
                               CONSTRAINT fkoie88l9xdqjv41ym8c1s7valq FOREIGN KEY (car_id) REFERENCES dealer.car(car_id)
);
