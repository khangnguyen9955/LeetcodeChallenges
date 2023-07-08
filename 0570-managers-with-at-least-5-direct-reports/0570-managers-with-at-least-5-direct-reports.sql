# Write your MySQL query statement below


select m.name # select manager name
from Employee e join Employee m # self join
on e.managerId = m.id # join that employee has managerId = manager.Id
group by e.managerId # group by employee's managerid
having count(e.id) > 4  # that have more than 4