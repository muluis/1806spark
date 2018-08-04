--DDL for media_db
DROP TABLE actor;

CREATE TABLE actor (
a_id INT,
name VARCHAR2(4000) NOT NULL UNIQUE,
film VARCHAR2 (4000),
birth_day DATE,
years_acting INT DEFAULT 0,
PRIMARY KEY (a_id)
);


--ALTER...name can be broken down to first_name last_name
ALTER TABLE actor
ADD (first_name VARCHAR2 (4000),
last_name VARCHAR2 (4000));

ALTER TABLE actor
DROP (name);

TRUNCATE TABLE actor;



--Make another table
CREATE TABLE role (
role_id INT,
role_name VARCHAR2 (100),
PRIMARY KEY (role_id)
);




--Create a junction/join table to show the relationship between actors and roles
--They typically follow the naming convention: table1_table2
CREATE TABLE actor_role (
--primary key of both tables 
a_id INT,
role_id INT,
--2 or more column that will be identified
--as the primary key is called a composite key
-- Junction/join table usually have a composite key
PRIMARY KEY (a_id, role_id),
--Now state that the 2 columns are Foreign Keys
--Foreign Key is a primary key in another table
FOREIGN KEY (a_id) REFERENCES actor(a_id),
FOREIGN KEY (role_id) REFERENCES role(role_id)
);

















