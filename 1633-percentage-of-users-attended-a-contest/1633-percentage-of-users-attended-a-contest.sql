# Write your MySQL query statement below
select contest_id, ROUND(COUNT(user_id)*100 / (SELECT COUNT(*) FROM USERS), 2) as percentage
from register
group by contest_id
order by percentage desc, contest_id asc;