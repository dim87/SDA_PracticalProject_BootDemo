CREATE TABLE authors
(
	id         INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	name       VARCHAR(32) NOT NULL,
	surname    VARCHAR(32) NOT NULL,
	birth_date DATE        NOT NULL
);

INSERT INTO authors (name, surname, birth_date)
VALUES ('Jack', 'London', '1876-01-12'),
	   ('Ernest', 'Hemingway', '1899-07-21'),
	   ('Mark', 'Twain', '1835-11-30'),
	   ('Oscar', 'Wilde', '1854-10-16'),
	   ('Charles', 'Dickens', '1812-02-07');
