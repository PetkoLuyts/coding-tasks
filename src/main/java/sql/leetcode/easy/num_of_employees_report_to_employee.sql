Create table If Not Exists Employees(employee_id int, name varchar(20), reports_to int, age int);
Truncate table Employees;
insert into Employees (employee_id, name, reports_to, age) values ('9', 'Hercy', '0', '43');
insert into Employees (employee_id, name, reports_to, age) values ('6', 'Alice', '9', '41');
insert into Employees (employee_id, name, reports_to, age) values ('4', 'Bob', '9', '36');
insert into Employees (employee_id, name, reports_to, age) values ('2', 'Winston', '0', '37');

SELECT e2.employee_id, e2.name, COUNT(*) AS reports_count, ROUND(AVG(e1.age),0) AS average_age
FROM Employees AS e1
JOIN Employees AS e2
ON e1.reports_to = e2.employee_id
GROUP BY e2.employee_id, e2.name
ORDER BY e2.employee_id;