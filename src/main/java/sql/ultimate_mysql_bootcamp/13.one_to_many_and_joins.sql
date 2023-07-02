-- Foreign key
CREATE DATABASE shop;

USE shop;

CREATE TABLE customers (
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(50)
);

CREATE TABLE orders 
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    order_date DATE,
    amount DECIMAL (8,2),
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

INSERT INTO customers (first_name, last_name, email) 
VALUES ('Boy', 'George', 'george@gmail.com'),
       ('George', 'Michael', 'gm@gmail.com'),
       ('David', 'Bowie', 'david@gmail.com'),
       ('Blue', 'Steele', 'blue@gmail.com'),
       ('Bette', 'Davis', 'bette@aol.com');
       
       
INSERT INTO orders (order_date, amount, customer_id)
VALUES ('2016-02-10', 99.99, 1),
       ('2017-11-11', 35.50, 1),
       ('2014-12-12', 800.67, 2),
       ('2015-01-03', 12.50, 2),
       ('1999-04-11', 450.25, 5);

-- To perform a (kind of useless) cross join:
SELECT * FROM customers, orders;

-- Inner joins
SELECT * FROM customers AS c
JOIN orders AS o
ON c.id = o.customer_id;

SELECT first_name, last_name, order_date, amount FROM customers AS c
JOIN orders AS o
ON c.id = o.customer_id;

SELECT * FROM customers AS c
JOIN orders AS o
ON c.id = o.customer_id
WHERE c.first_name = 'Boy';

SELECT o.amount, c.first_name FROM customers AS c
JOIN orders AS o
ON c.id = o.customer_id;

-- Inner joins with group by
SELECT first_name, last_name, SUM(amount) AS total FROM customers AS c
JOIN orders AS o
ON c.id = o.customer_id
GROUP BY o.customer_id
ORDER BY total;

-- Left join
SELECT first_name, last_name, order_date, amount FROM customers AS c
LEFT JOIN orders AS o
ON c.id = o.customer_id;

-- here the result will be the same as the inner join
-- because we will never have a customer_id in orders that does not exist in the customers table
-- it maps everything. But we can have a customer with no orders
SELECT 
    order_date, amount, first_name, last_name
FROM
    orders
        LEFT JOIN
    customers ON orders.customer_id = customers.id;
    
-- Left join with group by
SELECT first_name, last_name, IFNULL(SUM(amount), 0) AS money_spent FROM customers AS c
LEFT JOIN orders AS o
ON c.id = o.customer_id
GROUP BY first_name, last_name;

-- Right join
SELECT first_name, last_name, order_date, amount FROM customers AS c
RIGHT JOIN orders AS o
ON c.id = o.customer_id;

-- On delete cascade
CREATE TABLE customers (
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(50)
);

CREATE TABLE orders 
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    order_date DATE,
    amount DECIMAL (8,2),
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE
);

-- Exercise
CREATE DATABASE school;

USE school;

CREATE TABLE students
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50)
);

CREATE TABLE papers
(
	title VARCHAR(50),
    grade INT,
    student_id INT,
    FOREIGN KEY (student_id) REFERENCES students(id)
);

INSERT INTO students (first_name) VALUES 
('Caleb'), ('Samantha'), ('Raj'), ('Carlos'), ('Lisa');
 
INSERT INTO papers (student_id, title, grade ) VALUES
(1, 'My First Book Report', 60),
(1, 'My Second Book Report', 75),
(2, 'Russian Lit Through The Ages', 94),
(2, 'De Montaigne and The Art of The Essay', 98),
(4, 'Borges and Magical Realism', 89);

SELECT first_name, title, grade FROM students AS s
JOIN papers AS p
ON s.id = p.student_id
ORDER BY grade DESC;

SELECT first_name, title, grade FROM students AS s
LEFT JOIN papers AS p
ON s.id = p.student_id;

SELECT first_name, IFNULL(title, 'MISSING') AS title, IFNULL(grade, 0) AS grade FROM students AS s
LEFT JOIN papers AS p
ON s.id = p.student_id;

SELECT first_name, IFNULL(AVG(grade), 0) AS average FROM students AS s
LEFT JOIN papers AS p
ON s.id = p.student_id
GROUP BY first_name
ORDER BY average DESC;

SELECT first_name, IFNULL(AVG(grade), 0) AS average,
	CASE
		WHEN IFNULL(AVG(grade), 0) < 75 THEN 'FAILING'
        ELSE 'PASSING'
	END AS passing_status
FROM students AS s
LEFT JOIN papers AS p
ON s.id = p.student_id
GROUP BY first_name
ORDER BY average DESC;

DROP TABLE papers;
DROP TABLE students;

DROP SCHEMA school;