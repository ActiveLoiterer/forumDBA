/*Exemples de queries*/

use ProjetForum;

/*Exemple d'usager avec encryption de mot de passe*/

INSERT INTO Usagers (nickname, password) VALUES("Oli",SHA1("AAAaaa111"));

/*Aller chercher ID d'usager d'apres le nickname et mot de passe*/

SELECT id FROM Usagers WHERE nickname="Oli" AND password=SHA1("AAAaaa111");



/*Exemple de sujet*/

/*	titre,
    nb_msg
    date_dernier_msg,
    id_createur
    
    nb_msg et date_dernier_msg peuvent etre NULL*/

INSERT INTO Sujets (titre, id_createur) VALUES(
	
    "Quel est votre cours préféré au CEGEP?",
    (SELECT id FROM Usagers WHERE nickname="Oli")
	
);



/*On ajoute un message*/

/*	text,
    date,
    id_createur,
    id_sujet, */

INSERT INTO Messages (text, date, id_createur, id_sujet) VALUES (

	"DBA!", 
	CURDATE(), 
    (Select id FROM Usagers WHERE nickname="Oli"),
    (Select id FROM Sujets WHERE titre="Quel est votre cours préféré au CEGEP?")/*Je vais chercher le ID d'apres le titre du sujet*/
    
);

/***Il faut ensuite modifier les valeurs dans la table Sujets!!***/

SET @sujet=1; /*variable*/

UPDATE Sujets SET nb_msg=(SELECT COUNT(id) FROM Messages WHERE id_sujet=@sujet), 
					date_dernier_msg=(SELECT MAX(date) FROM Messages)
                    WHERE id=@sujet;
                    
                    
                    
/*Aller chercher les messages d'un sujet*/

SELECT * FROM Messages WHERE id_sujet=1;