Create table If Not Exists Customer (id int, name varchar(25), referee_id int);
Truncate table Customer;
insert into Customer (id, name, referee_id) values ('1', 'Will', '0');
insert into Customer (id, name, referee_id) values ('2', 'Jane', '0');
insert into Customer (id, name, referee_id) values ('3', 'Alex', '2');
insert into Customer (id, name, referee_id) values ('4', 'Bill', '0');
insert into Customer (id, name, referee_id) values ('5', 'Zack', '1');
insert into Customer (id, name, referee_id) values ('6', 'Mark', '2');

SELECT name FROM Customer
WHERE COALESCE(referee_id, 0) <> 2;

SELECT name FROM Customer
WHERE referee_id != 2 OR referee_id IS NULL;