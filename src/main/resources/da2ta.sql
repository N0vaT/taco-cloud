DELETE FROM Taco;
DELETE FROM Taco_Order;
DELETE FROM Ingredient;

INSERT INTO Ingredient (id, name, type) VALUES
(1, 'Мучная лепешка', 'WRAP'),
(2, 'Кукурузная лепешка', 'WRAP'),
(3, 'Говяжий фарш', 'PROTEIN'),
(4, 'Котлета', 'PROTEIN'),
(5, 'Салат', 'VEGGIES'),
(6, 'Чеддер', 'CHEESE'),
(7, 'Сыр Джек', 'CHEESE'),
(8, 'Сальса', 'SAUCE'),
(9, 'Сметана', 'SAUCE');
