# Write your MySQL query statement below
SELECT person_name
FROM Queue q1
WHERE q1.turn = (
    SELECT MAX(q2.turn)
    FROM Queue q2
    WHERE (
        SELECT SUM(q3.weight)
        FROM Queue q3
        WHERE q3.turn <= q2.turn
    ) <= 1000
);