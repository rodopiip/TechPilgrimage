-- Write a SQL query to find the number of all locations where the company has an office.
SELECT l.location_id, l.street_address, COUNT(d.department_id)
FROM locations l
JOIN departments d
ON l.location_id = d.location_id
GROUP BY l.location_id, l.street_address;
-- Write a SQL query to find the number of all departments that has manager.
SELECT d.department_id, d.department_name, m.manager_id
FROM departments d
JOIN employees m
ON d.manager_id = m.manager_id 
GROUP BY d.department_id, d.department_name;
-- Write a SQL query to find the number of all departments that has no manager.
SELECT d.department_id, d.department_name, m.manager_id
FROM departments d
LEFT JOIN employees m
ON d.manager_id = m.manager_id 
WHERE m.manager_id IS NULL;
-- see all departments
SELECT * FROM departments;
-- Write a SQL query to find all departments' names and the average salary for each of them.
SELECT d.department_name AS department, ROUND(AVG(e.salary), 0) AS avg_salary
FROM departments d
JOIN employees e
ON d.department_id = e.department_id
GROUP BY department_name
ORDER BY avg_salary DESC;
-- Write an SQL query to find the count of all employees in each department. Display the
-- name, location and number of employees for each department.
SELECT * FROM locations;

SELECT d.department_name AS department, l.street_address, COUNT(e.employee_id) AS employees
FROM employees e
JOIN departments d
ON d.department_id = e.department_id
JOIN locations l
ON d.location_id = l.location_id
GROUP BY department_name, l.street_address
ORDER BY employees DESC;

-- Write a SQL query to find for each department and for each manager the count of all
-- corresponding employees.
SELECT m.first_name, m.last_name, COUNT(e.employee_id) AS employees, d.department_name
FROM employees m
JOIN employees e
ON e.manager_id = m.employee_id
JOIN departments d
ON e.department_id = d.department_id
GROUP BY m.first_name, m.last_name, d.department_name
ORDER BY employees DESC; 

-- Write a SQL query to find all managers that have exactly 5 employees. Display their
-- names and the name and location of their department.

SELECT m.first_name, m.last_name, COUNT(e.employee_id) AS employees, d.department_name, l.street_address
FROM employees m
JOIN employees e
ON e.manager_id = m.employee_id
JOIN departments d
ON e.department_id = d.department_id
JOIN locations l
ON l.location_id = d.location_id
GROUP BY m.first_name, m.last_name, d.department_name, l.street_address
HAVING COUNT(e.employee_id) = 5; 

-- Write a SQL query to find for each department and for each job title the total number of employees.

SELECT d.department_name, j.job_title, COUNT(e.employee_id)
FROM departments d
JOIN employees e
ON d.department_id = e.department_id
JOIN jobs j
ON j.job_id = e.job_id
GROUP BY d.department_name, j.job_title
ORDER BY COUNT(e.employee_id) DESC;

-- Write a SQL query to find the names and salaries of the employees that
-- take the minimal salary in the company. Use nested SELECT statement.

SELECT first_name, last_name, salary
FROM employees
WHERE salary = (SELECT MIN(salary) FROM employees);

SELECT * FROM employees
ORDER BY salary DESC;

-- Write a SQL query to find the names and salaries of the employees 
-- who earn more than the average salary of their respective department.

SELECT e.first_name, e.last_name, ROUND(e.salary, 0), d.department_name
FROM employees e
JOIN departments d
ON e.department_id = d.department_id
WHERE e.salary > (SELECT AVG(salary) FROM employees);

-- Write a SQL query to find the names and salaries of the employees that
-- get a salary that is up to 10% higher than the minimal salary for the company.

SELECT e.first_name, e.last_name, ROUND(e.salary, 0)
FROM employees e
WHERE e.salary <= (SELECT MIN(salary) FROM employees) * 1.1;

-- Write a SQL that displays all departments and the highest salary for each
-- department along with the name of the employee that takes it. If multiple employees in
-- the same department have highest salary, display the first of them.

SELECT d.department_name, e.first_name, e.last_name, e.salary
FROM employees e
JOIN departments d ON d.department_id = e.department_id
WHERE (e.department_id, e.salary) IN 
    (SELECT department_id, MAX(salary) 
     FROM employees
     GROUP BY department_id)
ORDER BY e.salary DESC;

-- Write a SQL query to find the names of all employees whose last name is
-- exactly 5 characters long.

SELECT first_name, last_name
FROM employees
WHERE LENGTH(last_name) = 5;

-- Write a SQL query that displays all departments and the lowest salary 
-- for each department along with the name of the employee that has it. 
-- If multiple employees in the same department have the lowest salary, 
-- display the first of them.

SELECT d.department_name, e.first_name, e.last_name, e.salary
FROM departments d 
JOIN employees e
ON d.department_id = e.department_id
WHERE (d.department_id, e.salary) 
IN (
	SELECT department_id, MIN(salary)
    FROM employees
    GROUP BY department_id
	);
    
-- check the version of MySQL that you're using
SELECT @@version;

-- Write a SQL query to find the names of all employees whose first name
-- and last name start with the same letter.
SELECT first_name, last_name 
FROM employees
WHERE SUBSTRING(first_name, 1, 1) LIKE SUBSTRING(last_name, 1, 1);

-- Display all departments names and their manager's name. For
-- departments without manager display "(No manager)".

SELECT d.department_name, 
COALESCE(CONCAT(m.first_name, ' ', m.last_name), '(no manager)') AS manager
FROM departments d 
LEFT JOIN employees m 
ON d.manager_id = m.employee_id;

-- Display all employees along with their number of directly managed
-- people. For employees not managing anybody display "Just and employee". For
-- employees managing only 1 employee display "Junior manager". .

SELECT CONCAT(m.first_name, ' ', m.last_name) AS employee,
	CASE
		WHEN COUNT(e.employee_id) = 0 THEN 'JUST AN EMPLOYEE'
        WHEN COUNT(e.employee_id) = 1 THEN 'Junior manager'
        ELSE CONVERT(COUNT(e.employee_id), CHAR)
	END AS people_managed
FROM  employees m
LEFT JOIN employees e
ON m.employee_id = e.manager_id
GROUP BY m.first_name, m.last_name
ORDER BY people_managed DESC;

-- 19. Write a SQL query to print the current date and time in the format "
-- hour:minutes:seconds day-month-year". Display also the date coming after a week.
SELECT 
		DATE_FORMAT(NOW(), '%H:%m:%s %d-%m-%Y') AS current_date_time,
		DATE_FORMAT(DATE_ADD(NOW(), INTERVAL 1 week), '%H:%m:%s %d-%m-%Y') AS next_week;

-- 20. Write a SQL statement to create a table USERS. Users should have
-- username, password, full name and last login time. Choose appropriate data types for
-- the fields of the table. Define a primary key column with a primary key constraint.
-- Define a trigger to automatically fill the full name column value before inserting a
-- record.

-- 20.5 
CREATE TABLE books (
	book_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    published_date DATE NOT NULL,
    number_of_pages INT,
    available BOOLEAN,
    PRIMARY KEY (book_id)
);
CREATE TRIGGER availability_trigger
		BEFORE INSERT 
        ON books 
        FOR EACH ROW
        SET NEW.available = TRUE;

-- 21. Write a SQL statement to create a view that displays the users from the
-- USERS table that have been in the system today. Test if the view works correctly.

-- 21.5 Write a SQL statement to create a view that displays the books 
-- from the BOOKS table that have been added to the system within the last 7 days. 
-- Test if the view works correctly.

-- populating table with dummy data
INSERT INTO books(book_id, title, author, published_date, number_of_pages, available) VALUES
(1, 'Book1', 'Author1', CURDATE(), 200, TRUE),
(2, 'Book2', 'Author2', DATE_SUB(CURDATE(), INTERVAL 1 DAY), 150, TRUE),
(3, 'Book3', 'Author3', DATE_SUB(CURDATE(), INTERVAL 2 DAY), 300, TRUE),
(4, 'Book4', 'Author4', DATE_SUB(CURDATE(), INTERVAL 3 DAY), 400, TRUE),
(5, 'Book5', 'Author5', DATE_SUB(CURDATE(), INTERVAL 4 DAY), 100, TRUE),
(6, 'Book6', 'Author6', DATE_SUB(CURDATE(), INTERVAL 5 DAY), 500, TRUE),
(7, 'Book7', 'Author7', DATE_SUB(CURDATE(), INTERVAL 6 DAY), 350, TRUE),
(8, 'Book8', 'Author8', DATE_SUB(CURDATE(), INTERVAL 7 DAY), 250, TRUE),
(9, 'Book9', 'Author9', DATE_SUB(CURDATE(), INTERVAL 8 DAY), 450, TRUE),
(10, 'Book10', 'Author10', DATE_SUB(CURDATE(), INTERVAL 9 DAY), 300, TRUE),
(11, 'Book11', 'Author11', DATE_SUB(CURDATE(), INTERVAL 10 DAY), 150, TRUE),
(12, 'Book12', 'Author12', DATE_SUB(CURDATE(), INTERVAL 11 DAY), 200, TRUE),
(13, 'Book13', 'Author13', DATE_SUB(CURDATE(), INTERVAL 12 DAY), 250, TRUE),
(14, 'Book14', 'Author14', DATE_SUB(CURDATE(), INTERVAL 13 DAY), 350, TRUE),
(15, 'Book15', 'Author15', DATE_SUB(CURDATE(), INTERVAL 14 DAY), 400, TRUE),
(16, 'Book16', 'Author16', DATE_SUB(CURDATE(), INTERVAL 15 DAY), 150, TRUE),
(17, 'Book17', 'Author17', DATE_SUB(CURDATE(), INTERVAL 16 DAY), 200, TRUE),
(18, 'Book18', 'Author18', DATE_SUB(CURDATE(), INTERVAL 17 DAY), 300, TRUE),
(19, 'Book19', 'Author19', DATE_SUB(CURDATE(), INTERVAL 18 DAY), 250, TRUE),
(20, 'Book20', 'Author20', DATE_SUB(CURDATE(), INTERVAL 19 DAY), 350, TRUE);

SELECT * FROM books;

-- making the view
CREATE VIEW books_last_7_days AS
SELECT * FROM books
WHERE published_date > DATE_SUB(NOW(), INTERVAL 7 DAY);

-- testing the view
SELECT * FROM books_last_7_days;

-- Write a SQL statement to create a table PUBLISHERS. Publishers should have
-- a unique name (use unique constraint).

CREATE TABLE publishers (
	publisher_id INT NOT NULL,
	title VARCHAR(255) NOT NULL UNIQUE
);
-- adding a pirmary key constraints
ALTER TABLE publishers
ADD PRIMARY KEY (publisher_id);

-- Write a SQL statement to add a column publisher_id to the table BOOKS.
-- Fill some data in this new column and as well in the PUBLISHERS table.
-- Write a SQL statement to add a foreign key constraint between tables BOOKS and PUBLISHERS.

ALTER TABLE books 
ADD publisher_id INT,
ADD CONSTRAINT fk_publisher
FOREIGN KEY (publisher_id)
REFERENCES publishers (publisher_id);

-- Write SQL statements to insert several records in the BOOKS and
-- PUBLISHERS tables.

ALTER TABLE books 
MODIFY COLUMN book_id INT AUTO_INCREMENT;

ALTER TABLE books DROP FOREIGN KEY fk_publisher;

ALTER TABLE publishers 
MODIFY COLUMN publisher_id INT AUTO_INCREMENT;

ALTER TABLE books
ADD CONSTRAINT fk_publisher
FOREIGN KEY (publisher_id)
REFERENCES publishers (publisher_id);


SELECT * FROM publishers;

-- Insert into publishers
INSERT INTO publishers(title)
VALUES ('Publisher 1'), ('Publisher 2'), ('Publisher 3'), ('Publisher 4'), ('Publisher 5');

-- Then, insert into books. Note that you don't need to specify the book_id and publisher_id, as they are auto-incremented.
INSERT INTO books(title, author, published_date, number_of_pages, available, publisher_id)
VALUES ('Book 20', 'Author 20', '2023-01-01', 200, 1, 1),
       ('Book 21', 'Author 21', '2023-02-01', 210, 1, 2),
       ('Book 22', 'Author 22', '2023-03-01', 220, 1, 3),
       ('Book 23', 'Author 23', '2023-04-01', 230, 1, 4),
       ('Book 24', 'Author 24', '2023-05-01', 240, 1, 5);
       
SELECT * FROM books;

-- versions
SHOW VARIABLES LIKE "%version%";

-- Write SQL statements to insert in the USERS table the names of all
-- employees from the employees table. Combine the first and last names as a full name.
-- For user name use the email column from employees. Use blank password.

-- ALTERED 
-- Write SQL statements to add a 'website' column to the PUBLISHERS table. 
-- After that, insert into this new column, the respective websites for each publisher.
-- Also add a 'contact_person' column, which should be filled with the full names (first name and last name combined)
-- of the respective contact person from the EMPLOYEES table.
-- If the publisher does not have a designated contact person, leave it as NULL.
ALTER TABLE publishers
ADD website VARCHAR(100);

ALTER TABLE publishers
ADD contact_person VARCHAR(100);

UPDATE publishers 
SET website = 'www.example.com';

SELECT * FROM publishers;

INSERT INTO publishers (title)
SELECT last_name 
FROM employees; 

INSERT INTO publishers (contact_person)
SELECT CONCAT(first_name, ' ', last_name)
FROM employees
WHERE employee_id % 2 = 0;

INSERT INTO publishers (title, contact_person)
SELECT CONCAT(last_name, '_', employee_id), 
       CASE
         WHEN employee_id % 2 = 0 THEN CONCAT(first_name, ' ', last_name)
         ELSE NULL
       END
FROM employees;

DESCRIBE publishers;

ALTER TABLE publishers
ALTER COLUMN contact_person SET DEFAULT 'blank',
ALTER COLUMN website SET DEFAULT 'www.blank.com',
ALTER COLUMN title SET DEFAULT 'no-title';

INSERT INTO publishers(title)
VALUES ('MariaRadeva');

SELECT * FROM publishers;

UPDATE publishers 
SET contact_person = COALESCE(contact_person, 'default_value');

-- Run the above 10 times to generate enough testing data for the USERS table.

INSERT INTO publishers (title, contact_person)
SELECT CONCAT(employee_id, '_', last_name), 
       CASE
         WHEN employee_id % 2 <> 0 THEN CONCAT(first_name, ' ', last_name)
         ELSE NULL
       END
FROM employees;

UPDATE publishers 
SET contact_person = COALESCE(contact_person, 'no-contact');

SELECT * FROM publishers;


-- Write a SQL statement that changes the password to NULL for all
-- USERS that have not been in the system since 10.03.2006. Select table data to see the
-- changes.

-- ALTERNATIVE for books & publishers:
-- Write a SQL statement that changes the 'available' to FALSE for all
-- BOOKS that have not been 'published_date' since 01.05.2023. 
-- Select table data to see the changes.

SELECT * FROM books;

DESCRIBE books;

DESCRIBE publishers;

UPDATE books
SET available = FALSE
WHERE published_date < '2023-05-01';

-- Write a SQL statement that deletes all BOOKS without a 'publisher_id' (NULL or
-- empty 'publisher_id'). Select table data to see the changes.

DELETE FROM books
WHERE publisher_id IS NULL;




