Create table If Not Exists Weather (id int, recordDate date, temperature int);
Truncate table Weather;
insert into Weather (id, recordDate, temperature) values ('1', '2015-01-01', '10');
insert into Weather (id, recordDate, temperature) values ('2', '2015-01-02', '25');
insert into Weather (id, recordDate, temperature) values ('3', '2015-01-03', '20');
insert into Weather (id, recordDate, temperature) values ('4', '2015-01-04', '30');

SELECT w1.id
FROM Weather AS w1 , Weather AS w2
WHERE w1.Temperature > w2.Temperature AND DATEDIFF(w1.recordDate , w2.recordDate) = 1;

SELECT t1.id FROM Weather AS t1
JOIN Weather t2
ON t1.recordDate = DATE_ADD(t2.recordDate, INTERVAL 1 DAY)
WHERE t1.temperature > t2.temperature;