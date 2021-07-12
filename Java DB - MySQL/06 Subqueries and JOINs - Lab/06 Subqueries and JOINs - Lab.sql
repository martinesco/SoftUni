#1
SELECT e.employee_id, concat(e.first_name, ' ', e.last_name) AS full_name, 
		d.department_id, d.name AS department_name
FROM employees e
JOIN departments d
ON d.manager_id = e.employee_id
ORDER BY e.employee_id
LIMIT 5;

#2
SELECT t.town_id, t.name AS town_name, a.address_text
FROM towns t
JOIN addresses a
ON t.town_id = a.town_id
WHERE t.name IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY t.town_id, a.address_id;

#3
SELECT employee_id, first_name, last_name, department_id, salary
FROM employees
WHERE manager_id IS NULL;

#4
SELECT COUNT(*)
FROM employees
WHERE salary > 
	(SELECT AVG(salary)
	FROM employees);
