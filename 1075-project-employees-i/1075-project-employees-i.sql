# Write your MySQL query statement below
# get total employee's exp / count employees on that project id

select project_id, ROUND((sum(e.experience_years) / count(e.experience_years)),2) as average_years
from Project p
join Employee e on p.employee_id = e.employee_id
group by project_id