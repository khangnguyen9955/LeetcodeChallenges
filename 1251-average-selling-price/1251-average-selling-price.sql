# Write your MySQL query statement below
# find product sold in range date from (p.start_date to p.end_date)
# => (take p.price * unit sold) / total (count unitsold of product Id)


select p.product_id, ROUND(SUM(p.price*u.units)/SUM(u.units),2) as average_price
from Prices as p
join UnitsSold as u
on p.product_id = u.product_id and (u.purchase_date between p.start_date and p.end_date)
group by p.product_id


