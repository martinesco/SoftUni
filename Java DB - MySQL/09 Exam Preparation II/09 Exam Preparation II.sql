#1
CREATE DATABASE instagraph_db;
USE instagraph_db;

CREATE TABLE pictures(
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    path VARCHAR(255) NOT NULL,
    size DECIMAL(10,2) NOT NULL
);

CREATE TABLE users(
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    profile_picture_id INT(11),
    
    CONSTRAINT fk_users_pictures
    FOREIGN KEY (profile_picture_id)
    REFERENCES pictures(id)
);

CREATE TABLE posts(
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    caption VARCHAR(255) NOT NULL,
    user_id INT(11) NOT NULL,
    picture_id INT(11) NOT NULL,
    
    CONSTRAINT fk_posts_users
    FOREIGN KEY (user_id)
    REFERENCES users(id),
    
    CONSTRAINT fk_posts_pictures
    FOREIGN KEY (picture_id)
    REFERENCES pictures(id)
);

CREATE TABLE comments(
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    content VARCHAR(255) NOT NULL,
    user_id INT(11) NOT NULL,
    post_id INT(11) NOT NULL,

	CONSTRAINT fk_comments_users
    FOREIGN KEY (user_id)
    REFERENCES users(id),
    
    CONSTRAINT fk_comments_posts
    FOREIGN KEY (post_id)
    REFERENCES posts(id)
);

CREATE TABLE users_followers(
    user_id INT(11) NOT NULL,
    follower_id INT(11) NOT NULL,
    
    CONSTRAINT fk_users_followers_users
    FOREIGN KEY (user_id)
    REFERENCES users(id),
    
    CONSTRAINT fk_users_followers_follower
    FOREIGN KEY (follower_id)
    REFERENCES users(id)
);


#2
INSERT INTO comments (content, user_id, post_id)
	SELECT  
			(concat('Omg!', u.username, '!This is so cool!')) AS content,
			(ceil(p.id * 3 / 2)) AS user_id,
            (p.id) AS post_id
    FROM users u
    JOIN posts p
    ON u.id = p.user_id
	WHERE p.id BETWEEN 1 AND 10;

SELECT * FROM comments;


#3
UPDATE users u
JOIN
		(SELECT *, COUNT(DISTINCT(uf.follower_id)) AS count_followers
        FROM users u
        LEFT JOIN users_followers uf
        ON u.id = uf.user_id
        GROUP BY u.id
        HAVING u.profile_picture_id IS NULL
        ) AS j
SET u.profile_picture_id = 
			IF(j.count_followers > 0, j.count_followers, u.id)
WHERE u.id = j.id;


#4
DELETE u
FROM users u
LEFT JOIN users_followers uf
ON u.id = uf.user_id
WHERE uf.user_id IS NULL AND uf.follower_id IS NULL;


#5
SELECT id, username 
FROM users
ORDER BY id;

#6
SELECT u.id, u.username
FROM users u
JOIN users_followers uf
ON u.id = uf.user_id
WHERE uf.user_id = uf.follower_id
ORDER BY u.id;

#7
SELECT *
FROM pictures
WHERE size > 50000 
	AND (path LIKE ('%jpeg') OR path LIKE('%png%'))
ORDER BY size DESC;

#8
SELECT c.id, concat(u.username, ' : ', c.content) AS full_coment
FROM users u
JOIN comments c
ON u.id = c.user_id
ORDER BY c.id DESC;

#9
SELECT u.id, u.username, concat(p.size, 'KB')
FROM users u
JOIN pictures p
ON u.profile_picture_id = p.id
WHERE 1 < 
		(SELECT COUNT(*) FROM users u2 WHERE u2.profile_picture_id = u.profile_picture_id)
ORDER BY u.id;

#10
SELECT p.id, p.caption, COUNT(c.id) AS comments
FROM posts p
JOIN comments c
ON p.id = c.post_id
GROUP BY p.caption
ORDER BY COUNT(c.id) DESC, p.id
LIMIT 5;

#11
SELECT u.id, u.username, count(p.id) AS posts, 
		(SELECT count(uf.follower_id) 
		FROM users_followers uf
        WHERE u.id = uf.user_id
		GROUP BY uf.user_id) AS followers
FROM users u
JOIN posts p
ON u.id = p.user_id
GROUP BY u.id
ORDER BY followers DESC
LIMIT 1;

#12
SELECT u.id, u.username, count(c.content) AS my_comments
FROM users u
LEFT JOIN comments c
ON u.id = c.user_id
LEFT JOIN posts p
ON p.id = c.post_id
WHERE u.id = p.user_id 
GROUP BY u.id
ORDER BY my_comments DESC, u.id;

#13
SELECT u_id, user_username, post_caption
FROM(
		SELECT u.id AS u_id,
				u.username AS user_username,
				p.id,
				p.caption AS post_caption,
				p.user_id,
				count(c.id)
		FROM users u
		JOIN posts p
		ON u.id = p.user_id
		LEFT JOIN comments c
		ON c.post_id = p.id
		GROUP BY p.id
        ORDER BY count(c.id), p.id) AS asd
GROUP BY u_id
ORDER BY u_id;

#14
SELECT p.id, p.caption, count(DISTINCT(c.user_id)) AS users
FROM posts p
LEFT JOIN comments c
ON p.id = c.post_id
GROUP BY p.id
ORDER BY users DESC, p.id;


#15
DELIMITER $$
CREATE PROCEDURE udp_post (
		username VARCHAR(30),
        password VARCHAR(30),
        caption VARCHAR(255),
        path VARCHAR(255))
BEGIN
	IF ((SELECT u.password FROM users u WHERE u.username = username) <> password) 
    THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Password is incorrect!';
    ELSEIF (SELECT count(p.id) FROM pictures p WHERE p.path = path)
		THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The picture does not exist!';
	ELSE 
		INSERT INTO posts(caption, user_id, picture_id)
        VALUES 
			(caption, 
			(SELECT u.id FROM users u WHERE u.username = username),
			(SELECT p.id FROM pictures p WHERE p.path = path)
			);
    END IF;
END 
$$

CALL udp_post('UnderSinduxrein','gosho','fdsfds','fdsfds');


#16
DELIMITER $$
CREATE PROCEDURE udp_filter(hashtag VARCHAR(30))
BEGIN
	SELECT p.id, p.caption, u.username
	FROM posts p
    JOIN users u 
    ON u.id = p.user_id
	WHERE p.caption LIKE (concat('%', hashtag, '%'))
	ORDER BY p.id;
END $$
DELIMITER ;

CALL udp_filter('cool');


