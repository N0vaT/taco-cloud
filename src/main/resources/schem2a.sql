DROP TABLE IF EXISTS Taco_Ingredient;
DROP TABLE IF EXISTS Ingredient;
DROP TABLE IF EXISTS Taco;
DROP TABLE IF EXISTS Taco_Order;

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
    PRIMARY KEY (id)
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
