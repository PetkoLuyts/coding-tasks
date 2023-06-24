INSERT INTO cats (name, age)
VALUES ('Jetson', 7);

SELECT * FROM cats;

INSERT INTO cats (name, age)
VALUES  ('Meatball', 5),
		('Turkey', 1),
        ('Potato Face', 15);
        
CREATE TABLE people
(
	first_name VARCHAR(20),
    last_name VARCHAR(20),
    age INT
);

INSERT INTO people (first_name, last_name, age)
VALUES ('Tina', 'Belcher', 13);

INSERT INTO people (first_name, last_name, age)
VALUES ('Bob', 'Belcher', 42);

INSERT INTO people (first_name, last_name, age)
VALUES ('Linda', 'Belcher', 45),
	   ('Philip', 'Frond', 38),
       ('Calvin', 'Fischoeder', 70);
       
SELECT * FROM people;

DROP TABLE people;

CREATE TABLE cats2
(
	name VARCHAR(50) NOT NULL,
    age INT NOT NULL
);

DESC cats2;

CREATE TABLE cats3
(
	name VARCHAR(50) NOT NULL DEFAULT 'unnamed',
    age INT DEFAULT 99
);

DESC cats3;

CREATE TABLE unique_cats
(
	id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT NOT NULL
);

DESC unique_cats;

CREATE TABLE unique_cats2
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    age INT NOT NULL
);

INSERT INTO unique_cats2 (name, age)
VALUES ('Boingo', 3),
	   ('Alfred', 2);
       
SELECT * FROM unique_cats2;

CREATE TABLE employees
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    middle_name VARCHAR(100),
    last_name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    current_status VARCHAR(100) NOT NULL DEFAULT 'employed'
);

INSERT INTO employees (first_name,last_name, age)
VALUES ('thomas', 'chickenman', 87);

SELECT * FROM employees;








