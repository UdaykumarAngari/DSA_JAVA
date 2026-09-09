# Write your MySQL query statement below
select b.unique_id as unique_id, a.name as name
from employeeS as a
LEFT JOIN employeeUNI as b
on b.id = a.id;

