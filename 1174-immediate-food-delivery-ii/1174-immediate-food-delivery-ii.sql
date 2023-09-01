# Write your MySQL query statement below
# find percentage of immediate in the first order (definition) of a customer 
# step: find the first order and then check whether it is immediate order?
# hint: using min() to find min order-date
select 
round(avg(order_date=customer_pref_delivery_date)*100,2) as immediate_percentage
from Delivery
where (customer_id, order_date) in 
( # find earliest order of a customer 
    select customer_id, min(order_date) as first_order
    from Delivery 
    group by customer_id
)