#1
CREATE DATABASE buhtig;
USE buhtig;

CREATE TABLE users(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE repositories(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE repositories_contributors (
	repository_id INT(11) NOT NULL,
    contributor_id INT(11) NOT NULL,
    
    CONSTRAINT fk_repository_id
    FOREIGN KEY (repository_id)
    REFERENCES repositories(id),
    
    CONSTRAINT fk_contributor_id
    FOREIGN KEY (contributor_id)
    REFERENCES users(id)
);

CREATE TABLE issues(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    issue_status VARCHAR(6) NOT NULL,
    repository_id INT(11) NOT NULL,
    assignee_id INT(11) NOT NULL,
    
    CONSTRAINT fk_issues_repositories
    FOREIGN KEY (repository_id)
    REFERENCES repositories(id),
    
    CONSTRAINT fk_issues_users
    FOREIGN KEY (assignee_id)
    REFERENCES users(id)
);

CREATE TABLE commits(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    message VARCHAR(255) NOT NULL,
    issue_id INT(11),
    repository_id INT(11) NOT NULL,
    contributor_id INT(11) NOT NULL,
    
    CONSTRAINT fk_commits_issues
    FOREIGN KEY (issue_id)
    REFERENCES issues(id),
    
    CONSTRAINT fk_commits_repositories
    FOREIGN KEY (repository_id)
    REFERENCES repositories(id),
    
	CONSTRAINT fk_commits_users
    FOREIGN KEY (contributor_id)
    REFERENCES users(id)
);

CREATE TABLE files(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    size DECIMAL(10,2) NOT NULL,
    parent_id INT(11),
    commit_id INT(11),
    
    CONSTRAINT fk_files_files
    FOREIGN KEY (parent_id)
    REFERENCES files(id),
    
    CONSTRAINT fk_files_commits
    FOREIGN KEY (commit_id)
    REFERENCES commits(id)
);


#2
INSERT INTO issues(title, issue_status, repository_id, assignee_id)
	SELECT
		concat('Critical Problem With ', f.name, '!') AS title,
		concat('open') AS issue_status,
		ceil(f.id * 2 / 3) AS repository_id,
		c.contributor_id AS assignee_id
	FROM files f
    JOIN commits c 
    ON c.id = f.commit_id
    WHERE f.id BETWEEN 46 AND 50;
    
    
#3
UPDATE repositories_contributors rs
JOIN(
	SELECT r.id AS repo_id
    FROM repositories r
    WHERE r.id NOT IN(
		SELECT repository_id
        FROM repositories_contributors)
	ORDER BY r.id
    LIMIT 1
    ) AS j
SET repository_id = j.repo_id
WHERE repository_id = contributor_id;


#4
DELETE r
FROM repositories r
LEFT JOIN issues i
ON i.repository_id = r.id
WHERE i.repository_id IS NULL;
    
    
#5
SELECT id, username
FROM users
ORDER BY id;

#6
SELECT *
FROM repositories_contributors
WHERE repository_id = contributor_id
ORDER BY repository_id;

#7
SELECT id, name, size
FROM files
WHERE size > 1000 AND name LIKE '%html%'
ORDER BY size DESC;

#8
SELECT i.id, concat_ws(' : ', u.username, i.title) AS issue_assignee
FROM issues i
JOIN users u
ON i.assignee_id = u.id
ORDER BY i.id DESC;

#9
SELECT f1.id, f1.name, concat(f1.size, 'KB') AS size
FROM files f1
LEFT JOIN files f2
ON f2.parent_id = f1.id
WHERE f2.parent_id IS NULL
ORDER BY f1.id;
    
#10
SELECT r.id, r.name, COUNT(i.id) AS issues
FROM repositories r
JOIN issues i
ON r.id = i.repository_id
GROUP BY r.name
ORDER BY issues DESC;

#11
SELECT r.id, r.name, 
	(
		 SELECT COUNT(*)
		 FROM commits c
		 WHERE c.repository_id = r.id) AS commits,
	COUNT(u.id) AS contributors
FROM repositories r
JOIN repositories_contributors rc 
ON rc.repository_id = r.id
JOIN users u 
ON u.id = rc.contributor_id
GROUP BY r.id, commits
ORDER BY contributors DESC, r.id
LIMIT 1;

#12
SELECT u.id, u.username, SUM(IF(c.contributor_id = u.id, 1, 0)) AS commits
FROM users u
LEFT JOIN issues i 
ON i.assignee_id = u.id
LEFT JOIN commits c 
ON c.issue_id = i.id
GROUP BY u.id
ORDER BY commits DESC, u.id;

#13
SELECT 
	SUBSTRING_INDEX(f1.name, '.', 1) AS file,
    COUNT(nullif(LOCATE(f1.name, c.message), 0)) AS recursive_count
FROM files f1
JOIN files f2
ON f2.parent_id = f1.id
JOIN commits c
WHERE f1.id <> f2.id
	AND f2.parent_id = f1.id
    AND f2.id = f1.parent_id
GROUP BY f1.name
ORDER BY f1.name;

#14
SELECT r.id, r.name, COUNT(DISTINCT(c.contributor_id)) AS users
FROM repositories r
LEFT JOIN commits c
ON c.repository_id = r.id
GROUP BY r.id
ORDER BY users DESC, r.id;

#15
DELIMITER $$
CREATE PROCEDURE udp_commit(
	username VARCHAR(30), 
    password VARCHAR(30),
    message VARCHAR(255),
    issue_id INT)
BEGIN
	DECLARE users_username VARCHAR(30) DEFAULT (SELECT u.username FROM users u WHERE u.username = username);
    DECLARE users_password VARCHAR(30) DEFAULT (SELECT u.password FROM users u WHERE u.password = password);
    DECLARE issues_issue_id INT DEFAULT (SELECT i.id FROM issues i WHERE i.id = issue_id);
	
	START TRANSACTION;
	IF(users_username IS NULL) THEN
		SIGNAL SQLSTATE '45000' 
			SET MESSAGE_TEXT = 'No such user!';
		ROLLBACK;
	ELSEIF(users_password <> password) THEN
		SIGNAL SQLSTATE '45000' 
			SET MESSAGE_TEXT = 'Password is incorrect!';
		ROLLBACK;
    ELSEIF(issues_issue_id IS NULL) THEN
		SIGNAL SQLSTATE '45000' 
			SET MESSAGE_TEXT = 'The issue does not exist!';
		ROLLBACK;
    ELSE   
        INSERT INTO commits(message, issue_id, repository_id, contributor_id)
        VALUES (message, 
				issue_id, 
				(SELECT i.repository_id AS repo_id FROM issues i WHERE i.id = issue_id),
                (SELECT u.id FROM users u WHERE u.username = username AND u.password = password));
        
        UPDATE issues AS i
        SET i.issue_status = 'closed'
        WHERE i.id = issue_id;
        
        COMMIT;
    END IF;
END 
$$
DELIMITER ;

CALL udp_commit(
	'WhoDenoteBel', 
    'ajmISQi*', 
    'Fixed issue: blah', 
    2);
    

#16
DELIMITER $$
CREATE PROCEDURE udp_findbyextension(extension VARCHAR(30))
BEGIN
	SELECT 
		id,
		name AS caption,
		concat(size, 'KB') AS user
	FROM files
	WHERE name LIKE (concat('%', extension))
	ORDER BY id;
END 
$$
DELIMITER ;

CALL udp_findbyextension('html');

    
    