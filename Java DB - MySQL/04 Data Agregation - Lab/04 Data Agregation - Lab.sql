#1
SELECT department_id, COUNT(id) AS 'Number of employees'
FROM employees
GROUP BY department_id
ORDER BY department_id, COUNT(id);

#2
SELECT department_id, ROUND(AVG(salary),2) AS 'Average Salary'
FROM employees
GROUP BY department_id
ORDER BY department_id;

#3
SELECT department_id, MIN(salary) AS 'Min Salary'
FROM employees
GROUP BY department_id
HAVING MIN(salary)>800;

#4
SELECT COUNT(*)
FROM products
WHERE category_id = 2 AND price > 8;

#5
SELECT category_id, 
	ROUND(AVG(price),2) AS 'Average Price', 
    ROUND(MIN(price),2) AS 'Cheapest Product', 
    ROUND(MAX(price),2) AS 'Most Expensive Product'
FROM products
GROUP BY category_id;




