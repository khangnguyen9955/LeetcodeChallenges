# Write your MySQL query statement below

select DATE_FORMAT(trans_date,'%Y-%m') as month,
country,
COUNT(id) as trans_count,
COUNT(if(state ='approved',1,null)) as approved_count,
SUM(amount) as trans_total_amount,
SUM(if(state='approved', amount, 0)) as approved_total_amount
from Transactions

group by month, country
