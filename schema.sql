drop table if exists wyniki;
drop table if exists osoby;
drop table if exists odpowiedzi;
drop table if exists komentarze;
drop table if exists ankiety;

create table ankiety (id integer not null auto_increment, nazwa varchar(255), rodzic_id integer, primary key (id)) engine=InnoDB
create table komentarze (id integer not null auto_increment, komentarz varchar(1000), ankieta_id integer, osoba_id integer, primary key (id)) engine=InnoDB
create table odpowiedzi (id integer not null auto_increment, skala integer, ankieta_id integer, primary key (id)) engine=InnoDB
create table osoby (id integer not null auto_increment, data date, nazwa varchar(45), primary key (id)) engine=InnoDB
create table wyniki (id integer not null auto_increment, wynik integer, ankieta_id integer, osoba_id integer, primary key (id)) engine=InnoDB
alter table ankiety add constraint FK5x1lmbcfjurbd581xxwkd53if foreign key (rodzic_id) references ankiety (id)
alter table komentarze add constraint FKa11rjfo95u6ed3ek1frcq48e8 foreign key (ankieta_id) references ankiety (id)
alter table komentarze add constraint FKhi55obs789v435kd87rldf9lm foreign key (osoba_id) references osoby (id)
alter table odpowiedzi add constraint FKfghli7bcw9hlemc7oftt7gi95 foreign key (ankieta_id) references ankiety (id)
alter table wyniki add constraint FKav2n6vtyo48nwv2xhkeawhqyy foreign key (ankieta_id) references ankiety (id)
alter table wyniki add constraint FKlajrt608hyijqn0cbl27hl3v5 foreign key (osoba_id) references osoby (id)



drop procedure if exists ankiety.ADD_OR_UPDATE_POLL;

DELIMITER //

CREATE PROCEDURE `ankiety`.`ADD_OR_UPDATE_POLL`(IN POLL_ID INT, IN POLL_TEXT VARCHAR(255), IN POLL_PARENT_ID INT)
begin
	declare ac int DEFAULT -1;
	declare pc int DEFAULT -1;

	if POLL_ID is not null then 
		set ac = (select count(*) from ankiety a where a.id = POLL_ID);
	end if;
	
	if POLL_PARENT_ID is not null then 
		set pc = (select count(*) from ankiety a where a.id = POLL_PARENT_ID);
		if (pc = 0) then 
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Rodzic ankiety nie istnieje!';
		end if;
	end if;

	if ac > 0 then begin 
			if (POLL_TEXT is null) then 
				update ankiety set rodzic_id=POLL_PARENT_ID where id=POLL_ID;
			else 
				update ankiety set nazwa=POLL_TEXT,rodzic_id=POLL_PARENT_ID where id=POLL_ID;
			end if;
		end;
	else begin
			if POLL_ID is not null then
				SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Nie ma ankiety o podanym id!';
			end if;
			if POLL_TEXT is null then
				SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Nie mozna dodać pustej ankiety!';
			end if;
			insert into ankiety (nazwa, rodzic_id) values (POLL_TEXT, POLL_PARENT_ID);
		end;
	end if;
end;
//

DELIMITER ;
