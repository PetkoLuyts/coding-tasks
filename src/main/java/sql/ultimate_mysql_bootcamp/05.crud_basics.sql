CREATE TABLE cats
(
	cat_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    breed VARCHAR(100),
    age INT
);

INSERT INTO cats (name, breed, age) 
VALUES ('Ringo', 'Tabby', 4),
       ('Cindy', 'Maine Coon', 10),
       ('Dumbledore', 'Maine Coon', 11),
       ('Egg', 'Persian', 4),
       ('Misty', 'Tabby', 13),
       ('George Michael', 'Ragdoll', 9),
       ('Jackson', 'Sphynx', 7);

SELECT * FROM cats;
SELECT name FROM cats;
SELECT name, age FROM cats;

SELECT name, age FROM cats WHERE age = 4;
SELECT * FROM cats WHERE name = 'Egg';

SELECT cat_id FROM cats;
SELECT name, breed FROM cats;
SELECT name, age FROM cats WHERE breed = 'Tabby';
SELECT cat_id, age FROM cats WHERE cat_id = age;

SELECT cat_id AS id, name FROM cats;

SET SQL_SAFE_UPDATES = 0;

UPDATE cats
SET breed = 'Shorthair'
WHERE breed = 'Tabby';

UPDATE employees
SET current_status = 'laid-off', last_name = 'who_cares';

UPDATE cats
SET age = 14
WHERE name = 'Misty';

UPDATE cats
SET name = 'Jack'
WHERE name = 'Jackson';

UPDATE cats
SET breed = 'British Shorthair'
WHERE name = 'Ringo';

UPDATE cats
SET age = 12
WHERE breed = 'Maine Coon';

DELETE FROM cats WHERE name = 'Egg';

DELETE FROM cats WHERE age = 4;

DELETE FROM cats WHERE cat_id = age;