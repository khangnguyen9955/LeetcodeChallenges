# Write your MySQL query statement below

with CTE1 as
(
select player_id,min(event_date) as event_date
from activity
group by player_id
)

select round(
count(distinct a.player_id) / (select count(distinct player_id) from activity )
,2) as fraction
from CTE1 a
inner join activity b
on a.player_id = b.player_id
and datediff(b.event_date,a.event_date) = 1
