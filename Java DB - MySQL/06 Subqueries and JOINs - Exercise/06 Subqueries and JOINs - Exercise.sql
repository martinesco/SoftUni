#1
SELECT e.employee_id, e.job_title, e.address_id, a.address_text 
FROM employees e
JOIN addresses a
ON e.address_id = a.address_id
ORDER BY a.address_id
LIMIT 5;

#2
SELECT e.first_name, e.last_name, t.name AS town, a.address_text
FROM employees e
JOIN addresses a
ON e.address_id = a.address_id
JOIN towns t
ON a.town_id = t.town_id
ORDER BY e.first_name, e.last_name
LIMIT 5;

#3
SELECT e.employee_id, e.first_name, e.last_name, d.name
FROM employees e
JOIN departments d
ON e.department_id = d.department_id
WHERE d.name = 'Sales'
ORDER BY e.employee_id DESC;

#4
SELECT e.employee_id, e.first_name, e.salary, d.name AS department_name
FROM employees e
JOIN departments d
ON e.department_id = d.department_id
WHERE e.salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;

#5
SELECT e.employee_id, e.first_name
FROM employees_projects ep
RIGHT JOIN employees e
ON ep.employee_id = e.employee_id
WHERE ep.employee_id IS NULL
ORDER BY e.employee_id DESC
LIMIT 3;

#6
SELECT e.first_name, e.last_name, e.hire_date, d.name AS dept_name
FROM employees e
JOIN departments d
ON e.department_id = d.department_id
WHERE DATE(e.hire_date) >= '1999-01-01' AND d.name IN('Sales', 'Finance')
ORDER BY e.hire_date;

#7
SELECT e.employee_id, e.first_name, p.name AS project_name
FROM employees e
JOIN employees_projects ep
ON e.employee_id = ep.employee_id
JOIN projects p
ON ep.project_id = p.project_id
WHERE DATE(p.start_date) > '2002-08-13' AND p.end_date IS NULL
ORDER BY e.first_name, p.name
LIMIT 5;

#8
SELECT e.employee_id, e.first_name, IF(YEAR(p.start_date) >= 2005, NULL, p.name) AS project_name
FROM employees e
JOIN employees_projects ep
ON e.employee_id = ep.employee_id
JOIN projects p
ON ep.project_id = p.project_id
WHERE e.employee_id = 24
ORDER BY project_name;

#9
SELECT e1.employee_id, e1.first_name, e1.manager_id, e2.first_name AS manager_name
FROM employees e1
JOIN employees e2
ON e1.manager_id = e2.employee_id
WHERE e1.manager_id IN (3,7)
ORDER BY e1.first_name;

#10
SELECT e1.employee_id, 
		concat_ws(' ', e1.first_name, e1.last_name) AS employee_name, 
        concat_ws(' ', e2.first_name, e2.last_name) AS manager_name, 
        d.name AS department_name
FROM employees e1
JOIN employees e2
ON e1.manager_id = e2.employee_id
JOIN departments d
ON e1.department_id = d.department_id
ORDER BY e1.employee_id
LIMIT 5;

#11
SELECT AVG(salary) AS min_average_salary
FROM employees
GROUP BY department_id
ORDER BY AVG(salary)
LIMIT 1;

#12
SELECT c.country_code, m.mountain_range, p.peak_name, p.elevation
FROM countries c
JOIN mountains_countries mc
ON c.country_code = mc.country_code
JOIN mountains m
ON mc.mountain_id = m.id
JOIN peaks p
ON m.id = p.mountain_id
WHERE c.country_code = 'BG' AND p.elevation > 2835
ORDER BY p.elevation DESC;

#13
SELECT c.country_code, COUNT(m.mountain_range) AS mountain_range
FROM countries c
JOIN mountains_countries mc
ON c.country_code = mc.country_code
JOIN mountains m
ON mc.mountain_id = m.id
WHERE c.country_name IN ('United States', 'Russia', 'Bulgaria')
GROUP BY c.country_code 
ORDER BY COUNT(m.mountain_range) DESC;

#14
SELECT c.country_name, r.river_name
FROM countries c
LEFT JOIN countries_rivers cr
ON c.country_code = cr.country_code
LEFT JOIN rivers r
ON cr.river_id = r.id
WHERE c.continent_code = 'AF'
ORDER BY c.country_name
LIMIT 5;

#15 
SELECT c.continent_code, 
		c.currency_code, 
		COUNT(c.currency_code) AS currency_usage
FROM countries c
GROUP BY c.continent_code, c.currency_code
HAVING COUNT(c.currency_code) > 1
	AND COUNT(c.currency_code) = (
			SELECT COUNT(c1.currency_code) AS c_count
			FROM countries AS c1
			WHERE c1.continent_code = c.continent_code
			GROUP BY c1.currency_code
			ORDER BY c_count DESC
			LIMIT 1)
ORDER BY c.continent_code, c.currency_code;

#16
SELECT count(c.country_code) AS country_count
FROM countries c
LEFT JOIN mountains_countries mc
ON c.country_code = mc.country_code
WHERE mc.mountain_id IS NULL;

#17
SELECT 
	c.country_name,
    MAX(p.elevation) AS highest_peak_elevation,
    MAX(r.length) AS longest_river_length
FROM countries c
JOIN mountains_countries mc
ON c.country_code = mc.country_code
JOIN mountains m
ON mc.mountain_id = m.id
JOIN peaks p
ON p.mountain_id = m.id
LEFT JOIN countries_rivers cr
ON c.country_code = cr.country_code
LEFT JOIN rivers r
ON cr.river_id = r.id
GROUP BY c.country_name
ORDER BY highest_peak_elevation DESC, longest_river_length DESC, c.country_name
LIMIT 5;





