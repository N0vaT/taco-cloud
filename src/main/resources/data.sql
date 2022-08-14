DELETE FROM Ingredient_Ref;
DELETE FROM Taco;
DELETE FROM Taco_Order;
DELETE FROM Ingredient;

INSERT INTO Ingredient (id, name, type) VALUES
('FLTO', 'Мучная лепешка', 'WRAP'),
('COTO', 'Кукурузная лепешка', 'WRAP'),
('GRBF', 'Говяжий фарш', 'PROTEIN'),
('CARN', 'Котлета', 'PROTEIN'),
('TMTO', 'Салат', 'VEGGIES'),
('CHED', 'Чеддер', 'CHEESE'),
('JACK', 'Сыр Джек', 'CHEESE'),
('SLSA', 'Сальса', 'SAUCE'),
('SRCR', 'Сметана', 'SAUCE');
