Create table If Not Exists MyNumbers (num int);
Truncate table MyNumbers;
insert into MyNumbers (num) values ('8');
insert into MyNumbers (num) values ('8');
insert into MyNumbers (num) values ('3');
insert into MyNumbers (num) values ('3');
insert into MyNumbers (num) values ('7');
insert into MyNumbers (num) values ('7');
insert into MyNumbers (num) values ('7');
insert into MyNumbers (num) values ('7');

SELECT(
  SELECT num
  FROM MyNumbers
  GROUP BY num
  HAVING COUNT(*) = 1
  ORDER BY num DESC
  LIMIT 1
) as num;