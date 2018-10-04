use RecipeBook;
insert into role values
  (1,'ADMIN');


insert into recipes (name, cooking) values
  ('Pasta la Italiano', 'Cooking Pasta'),
  ('Borsch', 'Cooking borsch'),
  ('Pelmeni', 'Cooking pelmeni');

insert into foodstuff (name, unit) values
  ('Pasta Barilla','g.'),
  ('tomato','pc.'),
  ('cheese','g.'),
  ('water','ml.'),
  ('milk','ml.'),
  ('pork','g.'),
  ('beef','g.'),
  ('onion','pc.'),
  ('carrot','pc.'),
  ('beet','g.'),
  ('potatos','pc.'),
  ('cabbage','pc.'),
  ('salt','g.'),
  ('pepper','g.'),
  ('pain','g.'),
  ('eggs','pc.');

insert into ingredients (recipe_id, foodstuff_id, quantity) values
  (1, 1, 500),
  (1, 2, 200),
  (1, 3, 200),
  (1, 4, 2),
  (2, 4, 5),
  (2, 7, 2),
  (2, 8, 2),
  (2, 9, 2),
  (2, 10, 2),
  (2, 11, 1),
  (2, 12, 1),
  (2, 13, 5),
  (2, 14, 1),
  (3, 4, 5),
  (3, 15, 1),
  (3, 16, 2),
  (3, 7, 5),
  (3, 6, 5),
  (3, 8, 2),
  (3, 13, 5),
  (3, 14, 5);