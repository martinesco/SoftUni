CREATE DATABASE table_relations;
USE table_relations;

#1
CREATE TABLE persons(
	person_id INT(11) AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    salary DOUBLE NOT NULL,
    passport_id INT(11) NOT NULL UNIQUE
);

CREATE TABLE passports(
	passport_id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    passport_number VARCHAR(30) NOT NULL UNIQUE
);

INSERT INTO persons VALUES
(1, 'Roberto', 43300.00, 102),
(2, 'Tom', 56100.00, 103),
(3, 'Yana', 60200.00, 101);

INSERT INTO passports VALUES
(101, 'N34FG21B'),
(102, 'K65LO4R7'),
(103, 'ZE657QP2');

ALTER TABLE persons
MODIFY person_id INT PRIMARY KEY AUTO_INCREMENT;

ALTER TABLE persons
ADD CONSTRAINT fk_persons_passports
FOREIGN KEY (passport_id)
REFERENCES passports(passport_id);


#2
CREATE TABLE manufactures(
	manufacturer_id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(30) NOT NULL,
    established_on DATE NOT NULL
);

INSERT INTO manufactures VALUES
(1, 'BMW', '1916-03-01'),
(2, 'Tesla', '2003-01-01'),
(3, 'Lada', '1966-05-01');

CREATE TABLE models(
	model_id INT(11) PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL,
    manufacturer_id INT(11),
    CONSTRAINT fk_models_manufacturers
    FOREIGN KEY (manufacturer_id)
    REFERENCES manufactures(manufacturer_id)
);

INSERT INTO models VALUES
(101, 'X1', '1'),
(102, 'i6', '1'),
(103, 'Model S', '2'),
(104, 'Model X', '2'),
(105, 'Model 3', '2'),
(106, 'Nova', '3');


#3
CREATE TABLE students(
	student_id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE exams(
	exam_id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE students_exams(
	student_id INT(11) NOT NULL,
    exam_id INT(11) NOT NULL,
    
    CONSTRAINT pk_students_exams
    PRIMARY KEY (student_id, exam_id),
    
    CONSTRAINT fk_student_id
    FOREIGN KEY (student_id)
    REFERENCES students(student_id),
    
    CONSTRAINT fk_exam_id
    FOREIGN KEY (exam_id)
    REFERENCES exams(exam_id)
);

INSERT INTO students VALUES
(1, 'Mila'),
(2, 'Toni'),
(3, 'Ron');

INSERT INTO exams VALUES
(101,'Spring MVC'),
(102,'Neo4j'),
(103,'Oracle 11g');

INSERT INTO students_exams VALUES 
(1,101),
(1,102),
(2,101),
(3,103),
(2,102),
(2,103);


#4
CREATE TABLE teachers(
	teacher_id INT(11) PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL,
    manager_id INT(11),
    CONSTRAINT fk_manager_teacher
    FOREIGN KEY (manager_id)
    REFERENCES teachers(teacher_id)
);

INSERT INTO teachers(teacher_id, name) VALUES
(101,'John'),
(102,'Maya'),
(103,'Silvia'),
(104,'Ted'),
(105,'Mark'),
(106,'Greta');

UPDATE teachers
SET manager_id = 
CASE
	WHEN teacher_id = 102 THEN 106
	WHEN teacher_id = 103 THEN 106
	WHEN teacher_id = 104 THEN 105
	WHEN teacher_id = 105 THEN 101
	WHEN teacher_id = 106 THEN 101
END
WHERE teacher_id IS NOT NULL;


#5
CREATE DATABASE online_store_db;
USE online_store_db;

CREATE TABLE cities (
	city_id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE customers (
	customer_id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    birthday DATE,
    city_id INT(11),
    CONSTRAINT fk_customers_cities
    FOREIGN KEY (city_id)
    REFERENCES cities(city_id)
);

CREATE TABLE orders (
	order_id INT(11) PRIMARY KEY AUTO_INCREMENT,
    customer_id INT(11),
    CONSTRAINT fk_orders_customers
    FOREIGN KEY (customer_id)
    REFERENCES customers(customer_id)
);

CREATE TABLE item_types (
	item_type_id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE items (
	item_id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    item_type_id INT(11),
    CONSTRAINT fk_items_item_types
    FOREIGN KEY (item_type_id)
    REFERENCES item_types(item_type_id)
);

CREATE TABLE order_items (
	order_id INT(11),
    item_id INT(11),
    CONSTRAINT pk_orders_items
    PRIMARY KEY(order_id, item_id),
    
    CONSTRAINT fk_orders_items_orders
    FOREIGN KEY(order_id)
    REFERENCES orders(order_id),
    
	CONSTRAINT fk_orders_items_items
    FOREIGN KEY(item_id)
    REFERENCES items(item_id)
);


#6
CREATE DATABASE university;
USE university;

CREATE TABLE majors(
	major_id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(50)
);

CREATE TABLE students(
	student_id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    student_number VARCHAR(12),
    student_name VARCHAR(50),
    major_id INT(11),
    CONSTRAINT fk_students_majors
    FOREIGN KEY (major_id)
    REFERENCES majors(major_id)
);

CREATE TABLE payments(
	payment_id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    payment_date DATE,
    payment_amount DECIMAL(8,2),
    student_id INT(11),
    CONSTRAINT fk_payments_students
    FOREIGN KEY (student_id)
    REFERENCES students(student_id)
);

CREATE TABLE subjects(
	subject_id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    subject_name VARCHAR(50)
);

CREATE TABLE agenda(
	student_id INT(11),
	subject_id INT(11),
    
    CONSTRAINT pk_students_subjects
    PRIMARY KEY (student_id, subject_id),
    
    CONSTRAINT fk_students_id
    FOREIGN KEY (student_id)
    REFERENCES students(student_id),
    
    CONSTRAINT fk_subjects_id
    FOREIGN KEY (subject_id)
    REFERENCES subjects(subject_id)
);


#9
SELECT m.mountain_range, p.peak_name, p.elevation AS peak_elevation
FROM mountains m
JOIN peaks p
ON m.id = p.mountain_id
WHERE m.mountain_range = 'Rila'
ORDER BY peak_elevation DESC;


