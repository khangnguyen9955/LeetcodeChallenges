# Write your MySQL query statement below

select s.machine_id, Round(Avg(e.timestamp-s.timestamp),3) as processing_time
from Activity s Join Activity e On
s.machine_id = e.machine_id and s.process_id = e.process_id and
s.activity_type = 'start' and e.activity_type = 'end'
group by s.machine_id
