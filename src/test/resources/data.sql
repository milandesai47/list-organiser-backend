--CATEGORIES
INSERT INTO category (category_Name) VALUES
    ('chilled veg');
INSERT INTO category (category_Name) VALUES
    ('dairy');
INSERT INTO category (category_Name) VALUES
    ('meat');
INSERT INTO category (category_Name) VALUES
    ('fruit');
INSERT INTO category (category_Name) VALUES
    ('baking');
INSERT INTO category (category_Name) VALUES
    ('beverage');
INSERT INTO category (category_Name) VALUES
    ('canned');
INSERT INTO category (category_Name) VALUES
    ('hygiene');
INSERT INTO category (category_Name) VALUES
    ('alcohol');
INSERT INTO category (category_Name) VALUES
    ('other');

--ITEMS veg
INSERT INTO item ( category_id ,item_name) VALUES
  (1 , 'tomatoes');
INSERT INTO item ( category_id ,item_name) VALUES
  (1 , 'carrot');
INSERT INTO item ( category_id ,item_name) VALUES
  (1 , 'spinach');
INSERT INTO item ( category_id ,item_name) VALUES
  (1 , 'beans');
INSERT INTO item ( category_id ,item_name) VALUES
  (1 , 'lettuce');

--ITEMS dairy
INSERT INTO item ( category_id ,item_name) VALUES
  (2 , 'milk');
INSERT INTO item ( category_id ,item_name) VALUES
  (2 , 'cheese');
INSERT INTO item ( category_id ,item_name) VALUES
  (2 , 'butter');


--ITEMS meat
INSERT INTO item ( category_id ,item_name) VALUES
  (3 , 'chicken');
INSERT INTO item ( category_id ,item_name) VALUES
  (3 , 'bacon');
INSERT INTO item ( category_id ,item_name) VALUES
  (3 , 'beef');
INSERT INTO item ( category_id ,item_name) VALUES
  (3 , 'pork');
INSERT INTO item ( category_id ,item_name) VALUES
  (3 , 'lamb');


--ITEMS fruit
INSERT INTO item ( category_id ,item_name) VALUES
  (4 , 'apple');
INSERT INTO item ( category_id ,item_name) VALUES
  (4 , 'mango');
INSERT INTO item ( category_id ,item_name) VALUES
  (4 , 'blueberries');
INSERT INTO item ( category_id ,item_name) VALUES
  (4 , 'strawberries');
INSERT INTO item ( category_id ,item_name) VALUES
  (4 , 'orange');


--ITEMS baking
INSERT INTO item ( category_id ,item_name) VALUES
    (5 , 'flour');
INSERT INTO item ( category_id ,item_name) VALUES
    (5 , 'sugar');
INSERT INTO item ( category_id ,item_name) VALUES
    (5 , 'baking powder');
INSERT INTO item ( category_id ,item_name) VALUES
    (5 , 'cornstarch');


--ITEMS beverages
INSERT INTO item ( category_id ,item_name) VALUES
    (6 , 'water');
INSERT INTO item ( category_id ,item_name) VALUES
    (6 , 'coke');
INSERT INTO item ( category_id ,item_name) VALUES
    (6 , 'juice');
INSERT INTO item ( category_id ,item_name) VALUES
    (6 , 'coffee');
INSERT INTO item ( category_id ,item_name) VALUES
    (6 , 'tea');
INSERT INTO item ( category_id ,item_name) VALUES
    (6 , 'smoothie');


--ITEMS canned
INSERT INTO item ( category_id ,item_name) VALUES
    (7 , 'soup');
INSERT INTO item ( category_id ,item_name) VALUES
    (7 , 'pasta sauce');

--ITEMS hygiene
INSERT INTO item ( category_id ,item_name) VALUES
    (8 , 'toilet tissue');
INSERT INTO item ( category_id ,item_name) VALUES
    (8 , 'garbage bags');
INSERT INTO item ( category_id ,item_name) VALUES
    (8 , 'hand-wash');


--ITEMS alcohol
INSERT INTO item ( category_id ,item_name) VALUES
    (9 , 'cider');
INSERT INTO item ( category_id ,item_name) VALUES
    (9 , 'beer');
INSERT INTO item ( category_id ,item_name) VALUES
    (9 , 'vodka');
INSERT INTO item ( category_id ,item_name) VALUES
    (9 , 'whisky');
INSERT INTO item ( category_id ,item_name) VALUES
    (9 , 'wine');
