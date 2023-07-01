-- Unique
CREATE TABLE contacts (
	name VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL UNIQUE
);
 
INSERT INTO contacts (name, phone)
VALUES ('billybob', '8781213455');
 
-- This insert would result in an error:
INSERT INTO contacts (name, phone)
VALUES ('billybob', '8781213455');

-- Check constraints
CREATE TABLE users (
	username VARCHAR(20) NOT NULL,
    age INT CHECK (age > 0)
);
 
CREATE TABLE palindromes (
  word VARCHAR(100) CHECK(REVERSE(word) = word)
);

-- Named constraints
CREATE TABLE users2 (
	username VARCHAR(20) NOT NULL,
    age INT
    CONSTRAINT age_over_18 CHECK (age > 18)
);

CREATE TABLE palindromes2 (
  word VARCHAR(100)
  CONSTRAINT word_is_palindrome CHECK(REVERSE(word) = word)
);

-- Multi-column checks
CREATE TABLE companies
(
	name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    CONSTRAINT name_address UNIQUE (name, address)
);

CREATE TABLE houses
(
	purchase_price INT NOT NULL,
    sale_price INT NOT NULL,
    CONSTRAINT price CHECK (sale_price >= purchase_price)
);

-- Alter table: Adding columns
ALTER TABLE companies
ADD COLUMN phone VARCHAR(15);

ALTER TABLE companies
ADD COLUMN employee_count INT NOT NULL DEFAULT 1;

-- Alter table: drop column
ALTER TABLE companies
DROP COLUMN phone;

-- Alter table: Renaming
RENAME TABLE companies TO suppliers;

ALTER TABLE suppliers RENAME TO companies;

ALTER TABLE companies
RENAME COLUMN name TO company_name;

-- Alter table: Modifying columns
ALTER TABLE companies
MODIFY company_name VARCHAR(100) NOT NULL DEFAULT ('unknown');

-- rename and modify at once - we use Change
ALTER TABLE companies
CHANGE company_name name VARCHAR(100);

-- Alter table: Constraints
ALTER TABLE houses
ADD CONSTRAINT positive_price CHECK (purchased_price >= 0);

ALTER TABLE houses
DROP CONSTRAINT positive_price;