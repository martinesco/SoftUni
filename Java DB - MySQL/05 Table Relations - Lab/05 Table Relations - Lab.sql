#1
CREATE TABLE mountains(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	name VARCHAR(30) NOT NULL
);

CREATE TABLE peaks(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(30) NOT NULL,
    mountain_id INT(11) NOT NULL,
    CONSTRAINT fk_peaks_mountains
    FOREIGN KEY (mountain_id)
    REFERENCES mountains(id)
);

#2
SELECT v.driver_id, 
	v.vehicle_type,
	CONCAT(c.first_name, ' ', c.last_name) AS driver_name
FROM campers c
JOIN vehicles v
ON c.id = v.driver_id;

#3
SELECT starting_point AS route_starting_point,
		end_point AS route_ending_point,
		leader_id,
        CONCAT(c.first_name, ' ', c.last_name) AS leader_name
FROM routes
JOIN campers c
ON routes.leader_id = c.id;

#4
CREATE TABLE mountains(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	name VARCHAR(30) NOT NULL
);

CREATE TABLE peaks(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(30) NOT NULL,
    mountain_id INT(11) NOT NULL,
    CONSTRAINT fk_peaks_mountains
    FOREIGN KEY (mountain_id)
    REFERENCES mountains(id)
    ON DELETE CASCADE
);






