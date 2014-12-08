/*Création de la base de données*/
/*utf8_unicode_ci ou utf8_general_ci? Faut décider!*/

CREATE DATABASE IF NOT EXISTS ProjetForum character set utf8 collate utf8_general_ci;

use ProjetForum;

/*drop les tables*/

DROP TABLE IF EXISTS Messages;
DROP TABLE IF EXISTS Sujets;
DROP TABLE IF EXISTS Usagers;

/*Création des tables*/

CREATE TABLE Usagers(

	id INT AUTO_INCREMENT,
    nickname VARCHAR(30) NOT NULL,
    password VARCHAR(40) NOT NULL, /*SHA1 ENCRYPTION*/
	CONSTRAINT id PRIMARY KEY (id, nickname)
    
) ENGINE=innodb character set utf8 collate utf8_general_ci;

CREATE TABLE Sujets(

	id INT AUTO_INCREMENT,
    titre VARCHAR(50),
    nb_msg INT,
    date_dernier_msg DATE, /*date du derner message*/
    id_createur INT NOT NULL,
	CONSTRAINT id PRIMARY KEY (id),
    FOREIGN KEY (id_createur) REFERENCES Usagers(id)
    
) ENGINE=innodb character set utf8 collate utf8_general_ci;

CREATE TABLE Messages(

	id INT AUTO_INCREMENT,
    text VARCHAR(250) NOT NULL, /*Peut rajouter des characteres si nécessaire*/
    date DATE NOT NULL, /*On peut extraire l'heure d'une date avec HOUR()*/
    id_createur INT NOT NULL,
    id_sujet INT NOT NULL,
    CONSTRAINT id PRIMARY KEY (id),
    FOREIGN KEY (id_createur) REFERENCES Usagers(id),
    FOREIGN KEY (id_sujet) REFERENCES Sujets(id)
    
)ENGINE=innodb character set utf8 collate utf8_general_ci;