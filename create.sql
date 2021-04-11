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