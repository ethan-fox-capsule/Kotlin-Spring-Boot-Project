DROP TABLE IF EXISTS person;

CREATE TABLE IF NOT EXISTS person(
	id UUID,
	name VARCHAR(255),
	age INT,
	gender VARCHAR(255)
);