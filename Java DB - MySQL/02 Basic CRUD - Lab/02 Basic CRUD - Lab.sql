
#1
SELECT id, first_name, last_name, job_title
FROM employees
ORDER BY id;

#2
SELECT id, concat_ws(' ',`first_name`,`last_name`) AS 'Full name', job_title, salary
FROM employees
WHERE salary>1000
ORDER BY id;

#3 
#SET SQL_SAFE_UPDATES = 0;
UPDATE employees
SET salary = salary * 1.1
WHERE job_title = 'Therapist';
SELECT salary FROM employees
ORDER BY salary;

#4
CREATE VIEW v_top_paid_employee AS
SELECT * FROM employees
WHERE salary=(SELECT MAX(salary) FROM employees);
SELECT * FROM v_top_paid_employee;

#5
SELECT * FROM employees
WHERE department_id = 4 AND salary >= 1600
ORDER BY id;

#6
DELETE FROM employees
WHERE department_id = 1 OR department_id = 2;
SELECT * FROM employees
ORDER BY id;

