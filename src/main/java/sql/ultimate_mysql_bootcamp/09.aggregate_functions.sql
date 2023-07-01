-- Count
SELECT COUNT(*) FROM books;

SELECT COUNT(author_fname) FROM books;

SELECT COUNT(DISTINCT author_fname) FROM books;

SELECT COUNT(DISTINCT released_year) FROM books;

SELECT COUNT(DISTINCT author_lname) FROM books;

SELECT COUNT(*) FROM books
WHERE title LIKE '%the%';

-- Group by
SELECT author_lname, COUNT(*) AS books_written FROM books
GROUP BY author_lname ORDER BY books_written DESC;

SELECT released_year, COUNT(*) FROM books
GROUP BY released_year;

-- Min and max without group by
SELECT MIN(released_year) FROM books;

SELECT MAX(pages) FROM books;

SELECT MIN(author_lname), MAX(author_lname) FROM books;

SELECT MIN(CHAR_LENGTH(author_lname)), MAX(CHAR_LENGTH(author_lname)) FROM books;

-- Subqueries
SELECT * FROM books
WHERE pages = (SELECT MAX(pages) FROM books);

SELECT title, released_year FROM books
WHERE released_year = (SELECT MIN(released_year) FROM books);

-- Grouping by multiple columns
SELECT author_fname, author_lname, COUNT(*) FROM books
GROUP BY author_lname, author_fname;

SELECT CONCAT(author_fname, ' ', author_lname) AS full_name, COUNT(*) FROM books
GROUP BY full_name;

-- Min and max with group by
SELECT author_fname, author_lname, MIN(released_year) AS first_book FROM books
GROUP BY author_fname, author_lname;

SELECT author_fname, author_lname, MAX(released_year), MIN(released_year) FROM books
GROUP BY author_fname, author_lname;

SELECT author_fname, author_lname,
MAX(released_year) AS latest_release, 
MIN(released_year) AS earliest_release, 
MAX(pages) AS max_pages,
COUNT(*) AS books_written FROM books
GROUP BY author_fname, author_lname;

-- Sum
SELECT author_fname, author_lname, SUM(pages) FROM books
GROUP BY author_fname, author_lname;

-- Avg
SELECT AVG(released_year) FROM books;

SELECT author_fname, author_lname, AVG(released_year) FROM books
GROUP BY author_fname, author_lname;

SELECT released_year, AVG(stock_quantity), COUNT(*) FROM books
GROUP BY released_year;

-- Exercise
SELECT COUNT(*) FROM books;

SELECT released_year, COUNT(*) AS books_released FROM books
GROUP BY released_year;

SELECT SUM(stock_quantity) FROM books;

SELECT author_fname, author_lname, AVG(released_year) FROM books
GROUP BY author_fname, author_lname;

SELECT CONCAT(author_fname, ' ', author_lname) AS full_name, pages AS max_pages FROM books
ORDER BY max_pages DESC
LIMIT 1;

SELECT CONCAT(author_fname, ' ', author_lname) AS full_name, pages AS max_pages FROM books
WHERE pages = (SELECT MAX(pages) FROM books);

SELECT released_year AS 'year', COUNT(*) '# books', AVG(pages) AS 'avg pages' FROM books
GROUP BY released_year
ORDER BY released_year;

