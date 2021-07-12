#1
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000 ()
BEGIN
	SELECT first_name, last_name
	FROM employees
	WHERE salary > 35000
	ORDER BY first_name, last_name, employee_id;
END
$$

CALL usp_get_employees_salary_above_35000 ();


#2
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above (salary_size INT)
BEGIN
	SELECT first_name, last_name
	FROM employees
	WHERE salary >= salary_size
	ORDER BY first_name, last_name, employee_id;
END
$$

CALL usp_get_employees_salary_above(48100);


#3
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with (prefix VARCHAR(10))
BEGIN
	SELECT name 
	FROM towns
	WHERE LEFT(name, length(prefix)) = prefix
	ORDER BY name;
END
$$

CALL usp_get_towns_starting_with('b');


#4
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town (town_name VARCHAR(20))
BEGIN
	SELECT e.first_name, e.last_name
	FROM employees e
	JOIN addresses a
	ON e.address_id = a.address_id
	JOIN towns t
	ON a.town_id = t.town_id
	WHERE t.name = town_name
	ORDER BY e.first_name, e.last_name, e.employee_id;
END
$$

CALL usp_get_employees_from_town('Sofia');


#5
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level (salary DOUBLE(10,4))
RETURNS VARCHAR(10)
BEGIN
	DECLARE salary_level VARCHAR(10);
	SET salary_level :=
		(CASE
			WHEN salary < 30000 THEN 'Low'
			WHEN salary >= 30000 && salary <=50000 THEN 'Average'
			ELSE 'High'
		END);
    RETURN salary_level;
END
$$

SELECT ufn_get_salary_level(100);


#6
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level_2(salary DOUBLE(10,4))
RETURNS VARCHAR(20)
BEGIN
	DECLARE salary_level VARCHAR(10);
	IF (salary < 30000) THEN SET salary_level = 'Low';
	ELSEIF (salary <= 50000) THEN SET salary_level = 'Average';
	ELSE SET salary_level = 'High';
	END IF;
	RETURN salary_level;
END 
$$

DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level (input_salary_level VARCHAR(10))
BEGIN
	SELECT first_name, last_name
	FROM employees
	WHERE ufn_get_salary_level_2(salary) = input_salary_level
	ORDER BY first_name DESC, last_name DESC;
END
$$

CALL usp_get_employees_by_salary_level('High');


#7
DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50)) 
RETURNS BIT
BEGIN
	DECLARE result BIT;
	DECLARE word_length INT(11);
    DECLARE current_index INT(11);
    
    SET result := 1;
    SET word_length := char_length(word);
    SET current_index = 1;
    
    WHILE(current_index <= word_length) 
    DO 
		IF (set_of_letters NOT LIKE (concat('%', substring(word, current_index, 1), '%'))) 
        THEN SET result := 0;
        END IF;
        
        SET current_index := current_index + 1;
    END WHILE;
    
    RETURN result;
END
$$

SELECT ufn_is_word_comprised('oistmiahf','Sofia');


#8
DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name ()
BEGIN
	SELECT concat_ws(' ', first_name, last_name) AS full_name
	FROM account_holders
	ORDER BY full_name, id;
END
$$


#9
DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than (sum DECIMAL(19,4))
BEGIN
	SELECT ah.first_name, ah.last_name
	FROM account_holders ah
	JOIN accounts a
	ON ah.id = a.account_holder_id
    GROUP BY a.account_holder_id
	HAVING SUM(a.balance) > sum
	ORDER BY ah.first_name, ah.last_name, a.id;
END
$$

CALL usp_get_holders_with_balance_higher_than(7000);


#10
DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(initial_sum DECIMAL(20,4), yearly_interest_rate DECIMAL(20,4), years INT(11))
RETURNS DECIMAL(20,4)
BEGIN
	DECLARE result DECIMAL(20,4);
	SET result := initial_sum * POW(1 + yearly_interest_rate, years);
	RETURN result;
END $$

SELECT ufn_calculate_future_value(1000, 0.1, 5);


#11
DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(initial_sum DECIMAL(20,4), yearly_interest_rate DECIMAL(20,4), years INT)
RETURNS DECIMAL(20,4)
BEGIN
	DECLARE result DECIMAL(20,4);
	SET result := initial_sum * POW(1 + yearly_interest_rate, years);
	RETURN result;
END $$

DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account
	(account_id INT, interest_rate DECIMAL(20,4))
BEGIN
	SELECT a.id, h.first_name, h.last_name, a.balance,
		ufn_calculate_future_value(a.balance, interest_rate, 5) AS balance_in_5_years
	FROM account_holders h
    JOIN accounts AS a ON a.account_holder_id = h.id 
    GROUP BY a.account_holder_id
    HAVING a.id = account_id;
END $$

CALL usp_calculate_future_value_for_account(1, 0.1);


#12
DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(20,4))
BEGIN
	START TRANSACTION;
    
		IF((SELECT id
            FROM accounts
            WHERE id = account_id
            ) IS NULL
        ) THEN ROLLBACK;
        END IF;
        
        IF(money_amount < 0) THEN ROLLBACK;
        END IF;
    
		UPDATE accounts
        SET balance = balance + money_amount
        WHERE id = account_id;
	COMMIT;
END $$


#13
DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(20,4))
BEGIN
	START TRANSACTION;
		CASE WHEN money_amount < 0 
				OR money_amount > 
					(SELECT a.balance 
                     FROM accounts as a
					 WHERE a.id = account_id)
		THEN ROLLBACK;
	ELSE 
		UPDATE accounts a
		SET a.balance = a.balance - money_amount
        WHERE a.id = account_id;
	END CASE;
	COMMIT;
END $$

CALL usp_withdraw_money(1, 10);


#14
DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(20, 4))
BEGIN
	START TRANSACTION;
		CASE WHEN 
			(SELECT a.id FROM accounts as a WHERE a.id = from_account_id) IS NULL
            OR (SELECT a.id FROM accounts as a WHERE a.id = to_account_id) IS NULL
            OR from_account_id = to_account_id
            OR amount < 0
            OR (SELECT a.balance FROM accounts as a WHERE a.id = from_account_id) < amount
		THEN ROLLBACK;
	ELSE 
		UPDATE accounts a
		SET a.balance = a.balance - amount
        WHERE a.id = from_account_id;
        
        UPDATE accounts a
		SET a.balance = a.balance + amount
        WHERE a.id = to_account_id;
	END CASE;
	COMMIT;
END $$

CALL usp_transfer_money(1, 2, 10);


#15
CREATE TABLE logs(
log_id INT(11) PRIMARY KEY AUTO_INCREMENT,
account_id INT(11), 
old_sum DECIMAL(19,4), 
new_sum DECIMAL(19,4)
);

DELIMITER $$
CREATE TRIGGER tr_logs
AFTER UPDATE 
ON accounts
FOR EACH ROW
BEGIN
	INSERT INTO logs(account_id, old_sum, new_sum)
    VALUES(OLD.id, OLD.balance, NEW.balance);
END
$$

UPDATE accounts
SET balance = balance + 10
WHERE id = 1;

SELECT * FROM logs;