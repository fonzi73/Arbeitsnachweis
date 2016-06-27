/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  fonzi
 * Created: 24.06.2016
 */

use arbeitsnachweis;

--------------------------------------------
-- Alle Datensätze in allen Tabellen löschen
--

DELETE FROM bericht;
DELETE FROM nachweis;
DELETE FROM benutzer;
--------------------------------------------
--
-- AUTO_INCREMENT aller Tabellen mit Primärschlüsseln (ID) auf 1 setzen
--
ALTER TABLE benutzer AUTO_INCREMENT=1;
ALTER TABLE nachweis AUTO_INCREMENT=1;
ALTER TABLE bericht AUTO_INCREMENT=1;
--------------------------------------------
--
-- Alle Datensätze der sieben Themenbereiche in die Datenbank einfügen
--
INSERT INTO benutzer VALUES (NULL, "Marco Fontana");
--INSERT INTO benutzer VALUES (NULL, "Paulina Fontana");

INSERT INTO nachweis VALUES (NULL, 1, 1, '2016-07-01'); -- Marco
INSERT INTO nachweis VALUES (NULL, 1, 1, '2016-07-01'); -- Paulina
INSERT INTO nachweis VALUES (NULL, 2, 1, '2016-07-01'); -- Paulina

INSERT INTO bericht VALUES (NULL, "Montag Zeile 1", "02:00:00", 1); -- Marco
INSERT INTO bericht VALUES (NULL, "Zeile 2", "02:00:00", 1); -- Marco
INSERT INTO bericht VALUES (NULL, "Zeile 3", "02:00:00", 1); -- Marco
INSERT INTO bericht VALUES (NULL, "Zeile 4", "02:00:00", 1); -- Marco
INSERT INTO bericht VALUES (NULL, "Zeile 5", "02:00:00", 1); -- Marco
INSERT INTO bericht VALUES (NULL, "Zeile 6", "02:00:00", 1); -- Marco
INSERT INTO bericht VALUES (NULL, "Dienstag Zeile 1", "02:00:00", 1); -- Marco
INSERT INTO bericht VALUES (NULL, "Zeile 2", "02:00:00", 1); -- Marco

INSERT INTO bericht VALUES (NULL, "Montag Zeile 1", "02:00:00", 2); -- Marco
INSERT INTO bericht VALUES (NULL, "Zeile 2", "02:00:00", 2); -- Marco
INSERT INTO bericht VALUES (NULL, "Zeile 3", "02:00:00", 2); -- Marco
INSERT INTO bericht VALUES (NULL, "Zeile 4", "02:00:00", 2); -- Marco
INSERT INTO bericht VALUES (NULL, "Zeile 5", "02:00:00", 2); -- Marco
INSERT INTO bericht VALUES (NULL, "Zeile 6", "02:00:00", 2); -- Marco
INSERT INTO bericht VALUES (NULL, "Dienstag Zeile 1", "02:00:00", 2); -- Marco
INSERT INTO bericht VALUES (NULL, "Zeile 2", "02:00:00", 2); -- Marco