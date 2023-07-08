# Write your MySQL query statement below

# solution 1: using sum
# select signup.user_id, round( (confirmed_request)/ (total_requests)), 2) as 
# confirmation_rate
# confirmed_reuest == action with type 'confirmed'
# total_req = action with both type 'confirmed' and 'timeout'

# select signup.user_id, 
# ifnull(
#     round( 
#         (sum(action='confirmed'))
#         / (sum(action='confirmed' or action='timeout'))
#         ,2)
#     ,0) as 
# confirmation_rate
# from Signups as signup
# left join Confirmations as cf
# on cf.user_id = signup.user_id 
# group by signup.user_id


# solution 2: using avg

select s.user_id, round(avg(if(c.action = 'confirmed',1,0)),2) as confirmation_rate
from Signups as s
left join Confirmations as c
on c.user_id = s.user_id 
group by s.user_id
