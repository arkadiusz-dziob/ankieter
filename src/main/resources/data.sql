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
	 
INSERT INTO osoby (data, nazwa, haslo, rola) VALUES ('2020-10-11', 'admin', '$2a$10$8DAbM5UvIR8f.eNFeUuup.wQIVhMSrSt3HcX2UiEi7gq7XH8I8Y5a', 'ROLE_ADMIN') ^;
INSERT INTO osoby (data, nazwa, haslo, rola) VALUES ('2020-10-12', 'user', '$2a$10$8DAbM5UvIR8f.eNFeUuup.wQIVhMSrSt3HcX2UiEi7gq7XH8I8Y5a', 'ROLE_USER') ^;



