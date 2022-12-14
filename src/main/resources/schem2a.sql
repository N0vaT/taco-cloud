DROP TABLE IF EXISTS Taco_User;
DROP TABLE IF EXISTS Taco_Ingredient;
DROP TABLE IF EXISTS Ingredient;
DROP TABLE IF EXISTS Taco;
DROP TABLE IF EXISTS Taco_Order;

CREATE TABLE IF NOT EXISTS Taco_User
(
    user_id serial,
    user_name varchar(20) not null,
    user_password varchar(100) not null,
    user_ful_name varchar(60) not null,
    user_street varchar(50) not null,
    user_city varchar(30) not null,
    user_state varchar(30) not null,
    user_zip varchar(10) not null,
    user_phone_number varchar(20) not null,
    PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS Taco_Order
(
    id serial,
    delivery_name varchar(50) not null,
    delivery_street varchar(50) not null,
    delivery_city varchar(50) not null,
    delivery_state varchar(30) not null,
    delivery_zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_CVV varchar(3) not null,
    placed_at timestamp not null,
    user_id integer not null,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES Taco_User(user_id)
);

CREATE TABLE IF NOT EXISTS Taco
(
    id serial,
    name varchar(50) not null,
    taco_order_id integer,
    created_at timestamp not null,
    PRIMARY KEY (id),
    FOREIGN KEY (taco_order_id) REFERENCES Taco_Order(id)
);


CREATE TABLE IF NOT EXISTS Ingredient
(
    id serial,
    name varchar(25) not null,
    type varchar(10) not null,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Taco_Ingredient
(
    taco_id integer not null,
    ingredient_id serial not null,
    PRIMARY KeY (taco_id, ingredient_id),
    CONSTRAINT FK_Taco FOREIGN KEY (taco_id) REFERENCES Taco (id),
    CONSTRAINT FK_Ingredient FOREIGN KEY (ingredient_id) REFERENCES Ingredient (id)
);
