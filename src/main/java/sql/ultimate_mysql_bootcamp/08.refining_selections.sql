INSERT INTO books
    (title, author_fname, author_lname, released_year, stock_quantity, pages)
    VALUES ('10% Happier', 'Dan', 'Harris', 2014, 29, 256), 
           ('fake_book', 'Freida', 'Harris', 2001, 287, 428),
           ('Lincoln In The Bardo', 'George', 'Saunders', 2017, 1000, 367);
           
-- Distinct
SELECT DISTINCT author_lname FROM books;

SELECT DISTINCT released_year FROM books;

SELECT DISTINCT CONCAT(author_fname, ' ', author_lname) FROM books; -- select distinct full names

SELECT DISTINCT author_fname, author_lname FROM books;

-- Order by
SELECT book_id, author_fname, author_lname FROM books
ORDER BY author_fname;

SELECT book_id, author_fname, author_lname FROM books
ORDER BY author_fname DESC;

SELECT title, pages FROM books
ORDER BY pages DESC;

-- Order by 2 - takes the second listed column
SELECT title, author_fname, author_lname FROM books
ORDER BY 2;

SELECT book_id, author_fname, author_lname, pages FROM books
ORDER BY 4 DESC;

SELECT author_fname, author_lname FROM books
ORDER BY author_lname, author_fname;

SELECT author_lname, released_year, title FROM books
ORDER BY author_lname, released_year DESC;

SELECT CONCAT(author_fname, ' ', author_lname) AS author FROM books
ORDER BY full_name;

-- Limit
SELECT book_id, title, released_year FROM books
ORDER BY released_year DESC
LIMIT 5;

SELECT book_id, title, released_year FROM books
ORDER BY released_year DESC
LIMIT 1, 5; -- start at 1 and go for 5

SELECT book_id, title, released_year FROM books
ORDER BY released_year DESC
LIMIT 3, 2; -- start at 3 and go for 2

-- Like
SELECT author_fname FROM books
WHERE author_fname LIKE '%da%';

SELECT title FROM books
WHERE title LIKE '%:%';

SELECT * FROM books
WHERE author_fname LIKE '____';

SELECT * FROM books
WHERE author_fname LIKE '%n';

SELECT * FROM books
WHERE author_fname LIKE '_a_';

SELECT * FROM books
WHERE title LIKE '%\%%';

SELECT * FROM books
WHERE title LIKE '%\_%';

-- Exercise
SELECT title FROM books
WHERE title LIKE '%stories%';

SELECT title, pages FROM books
ORDER BY pages DESC
LIMIT 1;

SELECT CONCAT(title, ' - ', released_year) AS summary FROM books
ORDER BY released_year DESC
LIMIT 3;

SELECT title, author_lname FROM books
WHERE author_lname LIKE '% %';

SELECT title, released_year, stock_quantity FROM books
ORDER BY stock_quantity ASC, title
LIMIT 3;

SELECT title, author_lname FROM books
ORDER BY author_lname, title;

SELECT UPPER(CONCAT('My favourite author is ', author_fname, ' ', author_lname, '!')) AS yell FROM books
ORDER BY author_lname;