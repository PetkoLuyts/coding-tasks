Create table If Not Exists Transactions (id int, country varchar(4), state enum('approved', 'declined'), amount int, trans_date date);
Truncate table Transactions;
insert into Transactions (id, country, state, amount, trans_date) values ('121', 'US', 'approved', '1000', '2018-12-18');
insert into Transactions (id, country, state, amount, trans_date) values ('122', 'US', 'declined', '2000', '2018-12-19');
insert into Transactions (id, country, state, amount, trans_date) values ('123', 'US', 'approved', '2000', '2019-01-01');
insert into Transactions (id, country, state, amount, trans_date) values ('124', 'DE', 'approved', '2000', '2019-01-07');

-- My solution
SELECT DATE_FORMAT(trans_date, '%Y-%m') AS 'month',
	   t.country,
       COUNT(*) AS 'trans_count',
       SUM(IF(state = 'approved', 1, 0)) AS 'approved_count',
       SUM(amount) AS 'trans_total_amount',
       SUM(IF(state = 'approved', 1, 0) * amount) AS 'approved_total_amount'
FROM Transactions AS t
GROUP BY t.country, DATE_FORMAT(trans_date, '%Y-%m');

select
      DATE_FORMAT(trans_date,"%Y-%m") as month,
      country,
      count(id) as trans_count,
      sum(case when state = 'approved' then 1 else 0 end) approved_count,
      sum(amount) as trans_total_amount,
      sum(case when state = 'approved' then amount else 0 end) approved_total_amount
from Transactions
       group by country, month