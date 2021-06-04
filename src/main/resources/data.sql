INSERT INTO ankiety.ankiety (id, nazwa, rodzic_id) VALUES
	 (1, 'Ankieta z 3 pytaniami',NULL),
	 (2, 'Ankieta z 2 pytaniami',NULL) ^;
	 
INSERT INTO ankiety.ankiety (id, nazwa, rodzic_id) VALUES
	 (3, 'Ankieta 3p pytanie 1',1),
	 (4, 'Ankieta 3p pytanie 2',1),
	 (5, 'Ankieta 3p pytanie 3',1) ^;
	
INSERT INTO ankiety.ankiety (id, nazwa, rodzic_id) VALUES
	 (6, 'Ankieta 2p pytanie 1',2),
	 (7, 'Ankieta 2p pytanie 2',2) ^;
	 
	 
	 

INSERT INTO ankiety.ankiety (id, nazwa, rodzic_id) VALUES
	 (8, 'Odp1',6),
	 (9, 'Odp2',6) ^;
	 
INSERT INTO ankiety.ankiety (id, nazwa, rodzic_id) VALUES
	 (10, 'Odp3',7),
	 (11, 'Odp4',7) ^;
	  
INSERT INTO osoby (data, nazwa, haslo, rola) VALUES ('2020-10-11', 'admin', 'Gh3JHJBzJcaScd3wyUS8cg==', 'ROLE_ADMIN') ^;
INSERT INTO osoby (data, nazwa, haslo, rola) VALUES ('2020-10-12', 'user', 'Gh3JHJBzJcaScd3wyUS8cg==', 'ROLE_USER') ^;



