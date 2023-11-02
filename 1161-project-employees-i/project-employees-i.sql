# Write your MySQL query statement below

SELECT p.project_id, ROUND(AVG(experience_years), 2) as average_years
From Project p
LEFT JOIN Employee e
ON p.employee_id = e.employee_id
GROUP BY p.project_id