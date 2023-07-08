# Write your MySQL query statement below

select student.student_id, student.student_name, subject.subject_name, count(exam.subject_name) as attended_exams
from Students as student
join Subjects as subject
left join Examinations as exam
on student.student_id = exam.student_id and subject.subject_name = exam.subject_name
group by student.student_id, subject.subject_name # group for count func
order by student.student_id, subject.subject_name
