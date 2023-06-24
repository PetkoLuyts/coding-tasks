SHOW databases;

CREATE DATABASE pet_shop;

USE pet_shop;

SELECT database();

DROP DATABASE pet_shop;

CREATE DATABASE pet_shop;
USE pet_shop;

CREATE TABLE cats
(
	name VARCHAR(50),
    age INT
);

CREATE TABLE dogs
(
	name VARCHAR(50),
    breed VARCHAR(50),
    age INT
);

SHOW TABLES;

SHOW COLUMNS FROM cats;

DESC cats;

DROP TABLE dogs;

CREATE TABLE pastries
(
	name VARCHAR(50),
    quantity INT
);

DESC pastries;

DROP TABLE pastries;