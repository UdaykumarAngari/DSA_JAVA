# Write your MySQL query statement below
-- SELECT v.customer_id, COUNT(*) AS count_no_trans
-- FROM Visits AS v
-- WHERE v.visit_id NOT IN (
--     SELECT t.visit_id
--     FROM Transactions AS t
-- )
-- GROUP BY v.customer_id;

SELECT v.customer_id, COUNT(*) AS count_no_trans
FROM Visits AS v
LEFT JOIN Transactions AS t
    ON v.visit_id = t.visit_id
WHERE t.transaction_id IS NULL
GROUP BY v.customer_id;