CREATE TABLE IF NOT EXISTS Taco_Order
(
    id identity,
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
    id identity,
    name varchar(50) not null,
    taco_order bigint not null,
    taco_order_key bigint not null,
    created_at timestamp not null,
    PRIMARY KEY (id),
    FOREIGN KEY (taco_order) REFERENCES Taco_Order(id)
);

CREATE TABLE IF NOT EXISTS Ingredient
(
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Ingredient_Ref
(
    ingredient varchar(4) not null,
    taco bigint not null,
    taco_key bigint not null,
    FOREIGN KEY (ingredient) REFERENCES Ingredient(id)
);
