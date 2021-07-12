#1
SELECT COUNT(id)
FROM wizzard_deposits;

#2
SELECT MAX(magic_wand_size) AS longest_magic_wand
FROM wizzard_deposits;

#3
SELECT deposit_group, MAX(magic_wand_size) AS longest_magic_wand
FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY MAX(magic_wand_size), deposit_group;

#4
SELECT deposit_group #, AVG(magic_wand_size)
FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY AVG(magic_wand_size)
LIMIT 1;

#5
SELECT deposit_group, SUM(deposit_amount) AS total_sum
FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY SUM(deposit_amount);

#6
SELECT deposit_group, SUM(deposit_amount) AS total_sum
FROM wizzard_deposits
WHERE magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
ORDER BY deposit_group;

#7
SELECT deposit_group, SUM(deposit_amount) AS total_sum
FROM wizzard_deposits
WHERE magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
HAVING SUM(deposit_amount)<150000
ORDER BY SUM(deposit_amount) DESC;

#8
SELECT deposit_group, magic_wand_creator, MIN(deposit_charge) AS min_deposit_charge
FROM wizzard_deposits
GROUP BY deposit_group, magic_wand_creator
ORDER BY magic_wand_creator, deposit_group;

#9
SELECT 
		IF(age <= 10, '[0-10]',
        IF(age > 10 && age <= 20, '[11-20]', 
         IF(age > 20 && age <= 30, '[21-30]',
          IF(age > 30 && age <= 40, '[31-40]',
           IF(age > 40 && age <= 50, '[41-50]',
            IF(age > 50 && age <= 60, '[51-60]',
        '[61+]')))))) AS age_group,
	COUNT(id) AS wizard_count
FROM wizzard_deposits
GROUP BY age_group
ORDER BY wizard_count;

#10
SELECT LEFT(first_name,1) AS first_letter
FROM wizzard_deposits
WHERE deposit_group = 'Troll Chest'
GROUP BY first_letter
ORDER BY first_letter;

#11 
SELECT deposit_group, is_deposit_expired, AVG(deposit_interest) AS average_interest
FROM wizzard_deposits
WHERE deposit_start_date > '1985-01-01'
GROUP BY deposit_group, is_deposit_expired
ORDER BY deposit_group DESC, is_deposit_expired;

#12
SELECT SUM(`diff_current_next`) AS sum_difference
FROM(
		SELECT 
			wd1.deposit_amount - 
			(	SELECT wd2.deposit_amount 
				FROM wizzard_deposits wd2 
				WHERE wd2.id = wd1.id+1) AS `diff_current_next`
		FROM wizzard_deposits wd1) AS asd;

#13
SELECT department_id, MIN(salary) AS minimum_salary
FROM employees
WHERE department_id IN (2,5,7) AND hire_date > '2000-01-01'
GROUP BY department_id
ORDER BY department_id ASC;

#14
CREATE TABLE high_paid_employees AS
SELECT *
FROM employees
WHERE salary > 30000;

DELETE
FROM high_paid_employees
WHERE manager_id = 42;

UPDATE high_paid_employees
SET salary = salary + 5000
WHERE department_id = 1;

SELECT department_id, AVG(salary) AS avg_salary
FROM high_paid_employees
GROUP BY department_id
ORDER BY department_id;

#15
SELECT department_id, MAX(salary) AS max_salary
FROM employees
GROUP BY department_id
HAVING MAX(salary) < 30000 OR MAX(salary) > 70000
ORDER BY department_id;

#16
SELECT SUM(salary)
FROM employees
WHERE manager_id IS NULL;

#17
SELECT department_id, salary
FROM employees
GROUP BY department_id
ORDER BY department_id;

#18

#19
SELECT department_id, SUM(salary)
FROM employees
GROUP BY department_id
ORDER BY department_id;



