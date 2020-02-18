CREATE TABLE books
(
	id             INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	title          VARCHAR(64)   NOT NULL,
	author_id      INT UNSIGNED  NOT NULL,

	FOREIGN KEY (author_id)
		REFERENCES authors (id)
		ON DELETE RESTRICT
);

INSERT INTO books (title, author_id)
VALUES ('Martin Eden', 1),
	   ('The Old Man and the Sea', 2),
	   ('A Farewell to Arms', 2),
	   ('For Whom the Bells Tolls', 2),
	   ('The Adventures of Tom Sawyer', 3),
	   ('The Adventures of Huckleberry Finn', 3);
