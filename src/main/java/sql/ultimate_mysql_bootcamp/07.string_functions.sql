CREATE DATABASE book_shop;

USE book_shop;

SELECT database();

CREATE TABLE books 
	(
		book_id INT NOT NULL AUTO_INCREMENT,
		title VARCHAR(100),
		author_fname VARCHAR(100),
		author_lname VARCHAR(100),
		released_year INT,
		stock_quantity INT,
		pages INT,
		PRIMARY KEY(book_id)
	);
    
DESC books;

INSERT INTO books (title, author_fname, author_lname, released_year, stock_quantity, pages)
VALUES
('The Namesake', 'Jhumpa', 'Lahiri', 2003, 32, 291),
('Norse Mythology', 'Neil', 'Gaiman',2016, 43, 304),
('American Gods', 'Neil', 'Gaiman', 2001, 12, 465),
('Interpreter of Maladies', 'Jhumpa', 'Lahiri', 1996, 97, 198),
('A Hologram for the King: A Novel', 'Dave', 'Eggers', 2012, 154, 352),
('The Circle', 'Dave', 'Eggers', 2013, 26, 504),
('The Amazing Adventures of Kavalier & Clay', 'Michael', 'Chabon', 2000, 68, 634),
('Just Kids', 'Patti', 'Smith', 2010, 55, 304),
('A Heartbreaking Work of Staggering Genius', 'Dave', 'Eggers', 2001, 104, 437),
('Coraline', 'Neil', 'Gaiman', 2003, 100, 208),
('What We Talk About When We Talk About Love: Stories', 'Raymond', 'Carver', 1981, 23, 176),
("Where I'm Calling From: Selected Stories", 'Raymond', 'Carver', 1989, 12, 526),
('White Noise', 'Don', 'DeLillo', 1985, 49, 320),
('Cannery Row', 'John', 'Steinbeck', 1945, 95, 181),
('Oblivion: Stories', 'David', 'Foster Wallace', 2004, 172, 329),
('Consider the Lobster', 'David', 'Foster Wallace', 2005, 92, 343);

-- Concat
SELECT CONCAT(author_fname, ' ', author_lname) AS author_name FROM books;
SELECT CONCAT_WS('-', title, author_fname, author_lname) FROM books;

-- Substring
SELECT SUBSTRING('Hello World', 1, 6);  -- from 1st with length of 6 - Hello
SELECT SUBSTRING('Hello World', 7);   -- from 7th to the end - World
SELECT SUBSTRING('Hello World', -3);  -- rld

SELECT SUBSTRING(title, 1, 10) AS 'short_title' FROM books;

SELECT SUBSTR(author_lname, 1, 1) AS 'initial', author_lname FROM books; -- the first character

-- Combining string functions
SELECT CONCAT(SUBSTR(title, 1, 10), '...') AS short_title FROM books;

SELECT CONCAT(SUBSTR(author_fname, 1, 1), '.', SUBSTR(author_lname, 1, 1), '.') AS author_initials FROM books;

-- Replace
SELECT REPLACE(title, ' ', '-') AS title FROM books;

-- Reverse
SELECT REVERSE(author_fname) FROM books;

SELECT CONCAT(author_fname, REVERSE(author_fname)) FROM books;

-- Char_length
SELECT CHAR_LENGTH(title) AS len, title FROM books;

SELECT CONCAT(author_lname, ' is ', CHAR_LENGTH(author_lname), ' characters long') FROM books;

-- Upper and Lower
SELECT CONCAT('I LOVE ', UPPER(title), ' !!!') from books;

-- Insert, Left, Right, Repeat, Trim
SELECT INSERT('Quadratic', 3, 4, 'What');  -- str, pos, len, newstr

SELECT LEFT('foobarbar', 5); -- fooba
SELECT RIGHT('foobarbar', 3); -- bar

SELECT LEFT(author_fname, 1), author_fname FROM books;

SELECT REPEAT('Wow', 3);

SELECT TRIM('     bar   ');
SELECT TRIM(LEADING 'x' FROM 'xxxbarxxx'); -- barxxx
SELECT TRIM(BOTH 'x' FROM 'xxxbarxxx'); -- bar
SELECT TRIM(TRAILING 'x' FROM 'xxxbarxxx'); -- xxxbar;

-- Exercise
SELECT UPPER(REVERSE('Why does my cat look at me with such hatred?'));

SELECT REPLACE(title, ' ', '->') AS title FROM books;

SELECT author_lname AS forwards, REVERSE(author_lname) AS backwards FROM books;

SELECT UPPER(CONCAT(author_fname, ' ', author_lname)) AS 'full name in caps' FROM books;

SELECT CONCAT(title, ' was released in ', released_year) AS blurb FROM books;

SELECT title, CHAR_LENGTH(title) AS 'character count' FROM books;

SELECT 
    CONCAT(SUBSTR(title, 1, 10), '...') AS 'short title',
    CONCAT(author_lname, ',', author_fname) AS 'author',
    CONCAT(stock_quantity, ' in stock') AS 'quantity'
FROM
    books;