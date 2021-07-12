#1
SELECT first_name, last_name 
FROM employees
WHERE first_name LIKE "sa%"
ORDER BY employee_id;

#2
SELECT first_name, last_name 
FROM employees
WHERE last_name LIKE "%ei%"
ORDER BY employee_id;

#3 
SELECT first_name, hire_date
FROM employees
WHERE department_id IN(3,10) AND YEAR(hire_date)>1995 AND YEAR(hire_date)<2005
ORDER BY employee_id;

#4
SELECT first_name, last_name
FROM employees
WHERE job_title NOT LIKE "%engineer%"
ORDER BY employee_id;

#5 
SELECT * 
FROM towns
WHERE char_length(name) IN(5,6)
ORDER BY name;

#6
SELECT * 
FROM towns
WHERE LEFT(name,1) IN ('m','k','b','e')
ORDER BY name;

#7
SELECT *
FROM towns
WHERE LEFT(name,1) NOT IN('r','b','d')
ORDER BY name;

#8
CREATE VIEW v_employees_hired_after_2000 AS
SELECT first_name, last_name
FROM employees
WHERE YEAR(hire_date) > 2000;

#9
SELECT first_name, last_name
FROM employees
WHERE char_length(last_name)=5;

#10 ?
SELECT country_name, iso_code
FROM countries
WHERE country_name LIKE '%a%a%a%'
ORDER BY iso_code;

#11
SELECT peak_name, river_name, 
	lower(concat(peak_name, RIGHT(river_name, char_length(river_name)-1 ))) AS mix
FROM peaks, rivers
WHERE RIGHT(peak_name,1) = LEFT(river_name,1)
ORDER BY mix;

#12
SELECT name, DATE_FORMAT(start, '%Y-%m-%d') AS start
FROM games
WHERE YEAR(start) IN (2011,2012)
ORDER BY start, name
LIMIT 50;

#13 ``!
SELECT user_name, substring(email, position('@' IN email) +1) AS 'Email Provider'
FROM users
ORDER BY `Email Provider`, user_name;

#14
SELECT user_name, ip_address
FROM users
WHERE ip_address LIKE '___.1%.%.___'
ORDER BY user_name;

#15
SELECT name AS 'game', 
	(CASE
		WHEN HOUR(start) >= 0 && HOUR(start) <12 THEN 'Morning'
		WHEN HOUR(start) >= 12 && HOUR(start) <18 THEN 'Afternoon'
        WHEN HOUR(start) >= 18 && HOUR(start) <24 THEN 'Evening'
	END) AS 'Part of the Day',
    (CASE
		WHEN duration <=3 THEN 'Extra Short'
		WHEN duration > 3 && duration <=6 THEN 'Short'
        WHEN duration > 6 && duration <=10 THEN 'Long'
        ELSE 'Extra Long'
	END) AS 'Duration'
FROM games;

#16
SELECT product_name,
		order_date,
        date_add(order_date, INTERVAL +3 DAY) AS pay_due,
        date_add(order_date, INTERVAL +1 MONTH) AS deliver_due
FROM orders;

