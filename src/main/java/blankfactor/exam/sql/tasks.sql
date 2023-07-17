create table Kids (
  `Id` Int auto_increment primary key
  ,`First Name` varchar(100)
  ,`Last Name`  varchar(100)
  ,`Birth Date`  datetime
);

create table Toys (
  `Id` Int auto_increment primary key
 ,`Kid Id`  Int
 ,`Name` varchar(100)
 ,`Colour`  varchar(100)
);

SELECT * FROM Kids;
SELECT * FROM Toys;

INSERT INTO Kids 
VALUES (3, 'Marta', 'Geshov', curdate());

INSERT INTO Toys
VALUES(2, 5, 'secondcar', 'blue');

-- 1
SELECT CONCAT(k.`First Name`, ' ', k.`Last Name`) AS 'Full Name',
	   COUNT(*) AS 'Number of Blue Toys'
FROM Kids AS k
JOIN Toys AS t
ON k.`Id` = t.`Kid Id`
WHERE t.`Colour` = 'Blue'
GROUP BY k.`Id`
HAVING COUNT(*) > 2;

-- 2
SELECT CONCAT(k.`First Name`, ' ', k.`Last Name`) AS 'Full Name',
	   DATE_FORMAT(k.`Birth Date`, '%Y-%m-%d') AS 'Birth Date',
	   COUNT(*) AS 'Number of Toys'
FROM Kids AS k
JOIN Toys AS t
ON k.`Id` = t.`Kid Id`
WHERE TIMESTAMPDIFF(YEAR, k.`Birth Date`, CURDATE()) < 5
GROUP BY k.`Id`
HAVING COUNT(*) > 1;

SELECT CONCAT(k.`First Name`, ' ', k.`Last Name`) AS 'Full Name',
	   DATE_FORMAT(k.`Birth Date`, '%Y-%m-%d') AS 'Birth Date',
	   COUNT(*) AS 'Number of Toys'
FROM Kids AS k
JOIN Toys AS t
ON k.`Id` = t.`Kid Id`
WHERE TIMESTAMPDIFF(YEAR, k.`Birth Date`, CURDATE()) < 5
GROUP BY k.`Id`
HAVING COUNT(*) > 1;

-- 3
SELECT CONCAT(k.`First Name`, ' ', COALESCE(k.`Last Name`, "")) AS 'Full Name' 
FROM Kids AS k
LEFT JOIN Toys AS t
ON k.`Id` = t.`Kid Id`
WHERE t.`Id` IS NULL;

-- 4
SELECT CONCAT(k.`First Name`, ' ', k.`Last Name`) AS 'Full Name',
	   DATE_FORMAT(k.`Birth Date`, '%Y-%m-%d') AS 'Birth Date'
FROM Kids AS k
WHERE MONTH(k.`Birth Date`) = 4;

-- 5
SELECT k.`Id` AS 'Kid Id',
	   CONCAT(k.`First Name`, ' ', COALESCE(k.`Last Name`, "")) AS 'Full Name',
       COUNT(k.`Id`) AS 'Number of Toys'
FROM Kids AS k
LEFT JOIN Toys AS t
ON k.`Id` = t.`Kid Id`
GROUP BY k.`Id`, 'Full Name'
HAVING COUNT(k.`Id`) = (
	SELECT COUNT(`Id`) FROM Toys
    GROUP BY `Kid Id`
    ORDER BY COUNT(`Id`) DESC
    LIMIT 1
);

-- 6
SELECT CONCAT(k.`First Name`, ' ', COALESCE(k.`Last Name`, "")) AS 'Full Name',
       COUNT(k.`Id`) AS 'Number of Toys'
FROM Kids AS k
LEFT JOIN Toys AS t
ON k.`Id` = t.`Kid Id`
GROUP BY k.`Id`
ORDER BY COUNT(k.`Id`) DESC;
