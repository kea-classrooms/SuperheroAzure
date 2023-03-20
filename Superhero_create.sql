DROP DATABASE IF EXISTS superheroes;
CREATE DATABASE superheroes;
USE superheroes;

drop table if exists superhero;
drop table if exists superpower;
drop table if exists city;
drop table if exists superherosuperpower;

CREATE TABLE city(
id INT NOT NULL auto_increment,
name VARCHAR(50),
PRIMARY KEY(id)
);

CREATE TABLE superhero(
id INT NOT NULL auto_increment,
heroName VARCHAR(50) NULL,
realName VARCHAR(50),
creationYear INT,
city_id INT,
FOREIGN KEY (city_id) REFERENCES city(id),
PRIMARY KEY(id)
); 

CREATE TABLE superpower(
id INT NOT NULL auto_increment,
name VARCHAR(50),
PRIMARY KEY(id)
);

CREATE TABLE superherosuperpower(
superhero_id INT NOT NULL,
superpower_id INT NOT NULL,
FOREIGN KEY (superhero_id) REFERENCES superhero(id),
FOREIGN KEY (superpower_id) REFERENCES superpower(id),
PRIMARY KEY(superhero_id, superpower_id)
);

INSERT INTO city (name) values 
("London"),
("Oslo"),
("New York");

INSERT INTO superhero (heroName, realName, creationYear, city_id) values 
("Dude", "Jeff", 1982, 1),
("Superboy", "Clerk Kant", 1950, 2),
("Paul", "Whooper Jr.", 1994, 3);

INSERT INTO superpower (name) values
("bowling"),
("fly"),
("superstrength"),
("spise");

INSERT INTO superherosuperpower (superhero_id, superpower_id) values 
(1, 1),
(2, 2),
(2, 3),
(3, 4);

