--  Not equal - !=
SELECT title FROM books
WHERE released_year != 2017;

SELECT title, author_lname FROM books
WHERE author_lname != 'Gaiman';

-- Not like
SELECT title FROM books
WHERE title NOT LIKE '% %';

SELECT title, author_fname, author_lname FROM books
WHERE author_fname NOT LIKE 'da%';

SELECT title FROM books
WHERE title NOT LIKE '%e%';

-- Greater than   >
SELECT * FROM books
WHERE released_year > 2005;

SELECT * FROM books
WHERE pages > 500;

-- Less than or equal to  <=  more than or equal to >=
SELECT title, released_year FROM books
WHERE released_year < 2000
ORDER BY released_year;

SELECT title, pages FROM books
WHERE pages < 200;

SELECT title, released_year FROM books
WHERE released_year >= 2010;

SELECT * FROM books
WHERE released_year <= 1985;

-- Logical AND
SELECT title, author_lname, released_year FROM books
WHERE author_lname = 'Eggers' AND released_year > 2010;

SELECT title, author_lname, released_year FROM books
WHERE author_lname = 'Eggers' AND released_year > 2010 AND
title LIKE '%novel%';

SELECT title, pages FROM books
WHERE CHAR_LENGTH(title) > 30 AND pages > 500;

-- Logical OR
SELECT title, author_lname, released_year FROM books
WHERE author_lname = 'Eggers' OR released_year > 2010;

SELECT title, pages FROM books
WHERE pages < 200 OR title LIKE '%stories%';

-- Between
SELECT title, released_year FROM books
WHERE released_year BETWEEN 2004 AND 2015;

SELECT title, pages FROM books
WHERE pages BETWEEN 200 AND 300;

SELECT title, released_year FROM books
WHERE released_year NOT BETWEEN 2004 AND 2015;

SELECT title, pages FROM books
WHERE pages NOT BETWEEN 200 AND 300;

-- Comparing dates
SELECT * FROM people WHERE birthtime 
BETWEEN CAST('12:00:00' AS TIME) 
AND CAST('16:00:00' AS TIME);
 
 
SELECT * FROM people WHERE HOUR(birthtime)
BETWEEN 12 AND 16;

-- In operator
SELECT title, author_lname FROM books
WHERE author_lname IN('Carver', 'Lahiri', 'Smith');

SELECT title, author_lname FROM books
WHERE author_lname NOT IN('Carver', 'Lahiri', 'Smith');

SELECT title, released_year FROM books
WHERE released_year >= 2000 AND released_year NOT IN (2000, 2002, 2004, 2006, 2008, 2010, 2012, 2014, 2016);

SELECT title, released_year FROM books
WHERE released_year >= 2000 AND released_year % 2 != 0;

-- Case
SELECT title, released_year,
	CASE
		WHEN released_year >= 2000 THEN 'Modern Lit'
        ELSE '20th Century Lit'
	END AS genre
FROM books;

SELECT title, stock_quantity,
	CASE
		WHEN stock_quantity BETWEEN 0 AND 40 THEN '*'
        WHEN stock_quantity BETWEEN 41 AND 70 THEN '**'
        WHEN stock_quantity BETWEEN 71 AND 100 THEN '***'
        WHEN stock_quantity BETWEEN 101 AND 140 THEN '****'
        ELSE '*****'
    END AS stock
FROM books;

SELECT title, stock_quantity,
	CASE
		WHEN stock_quantity <= 40 THEN '*'
        WHEN stock_quantity <= 70 THEN '**'
        WHEN stock_quantity <= 100 THEN '***'
        WHEN stock_quantity <= 140 THEN '****'
        ELSE '*****'
    END AS stock
FROM books;

-- Is null
SELECT * FROM books
WHERE author_lname IS NULL;

SELECT * FROM books
WHERE author_lname IS NOT NULL;

DELETE FROM books
WHERE title IS NULL;

-- Exercise
SELECT * FROM books
WHERE released_year < 1980;

SELECT * FROM books
WHERE author_lname IN ('Eggers', 'Chabon');

SELECT * FROM books
WHERE author_lname = 'Eggers' OR author_lname = 'Chabon';

SELECT * FROM books
WHERE author_lname = 'Lahiri' AND released_year > 2000;

SELECT * FROM books
WHERE pages BETWEEN 100 AND 200;

SELECT title, author_lname FROM books
WHERE author_lname LIKE 'C%' OR author_lname LIKE 'S%';

SELECT title, author_lname FROM books
WHERE SUBSTR(author_lname, 1, 1) IN ('C', 'S');

SELECT title, author_lname,
	CASE
		WHEN title LIKE '%stories%' THEN 'Short Stories'
        WHEN title = 'Just Kids' OR title = 'A Heartbreaking Work of Staggering Genius' THEN 'Memoir'
        ELSE 'Novel'
    END AS 'TYPE'
FROM books;

SELECT author_fname, author_lname,
	CASE
		WHEN COUNT(*) = 1 THEN CONCAT(COUNT(*), ' book')
        ELSE CONCAT(COUNT(*), ' books')
    END AS 'COUNT'
FROM books
GROUP BY author_fname, author_lname;