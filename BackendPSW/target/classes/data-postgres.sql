insert into users (firstname, password, email, lastname, address, city, country, phone, role) values ('vesna', '123','josipovic.smbb1@gmail.com','karaklic','Dj. Rajkovic 12','Novi Sad','Srbija','066123456','adminKC');
insert into users (firstname, password, email, lastname, address, city, country, phone, role) values ('vesna1', '123','josipovic.smbb6@gmail.com','karaklic1','Dj. Rajkovic 121','Novi Sad','Srbija','0661234561','naCekanju');
insert into users (firstname, password, email, lastname, address, city, country, phone, role) values ('Ve', '123','vesna.karaklic.97@gmail.com','Sna','Dj. Rajkovic 121','NS','Srb','0661234561','pacijent');
insert into users (firstname, password, email, lastname, address, city, country, phone, role) values ('Petar', '123','petar','Petrovic','Bulevar Petra 15','Beograd','Srbija','06612333333','lekar');
insert into users (firstname, password, email, lastname, address, city, country, phone, role) values ('Milan', '123','milan','Milanovic','Bulevar Milana 25','Beograd','Srbija','0661243434','lekar');
insert into users (firstname, password, email, lastname, address, city, country, phone, role) values ('adm', '123','adminK','k','Bulevar Milana 25','Beograd','Srbija','0661243434','adminK');

insert into klinika (naziv, adresa, opis) values ('Klinika Rest', 'Resta Racina 11','Rest klinika za sve.');
insert into klinika (naziv, adresa, opis) values ('Klinika Medic', 'Milosa Obilica 6','Opis klinike medic.');
insert into klinika (naziv, adresa, opis) values ('Moja nega', 'Bulevar Oslobodjenja 25','Opis klinike moja nega.');
insert into klinika (naziv, adresa, opis) values ('Klinika Petrovic', 'Gogoljeva 33','Opis klinike petrovic.');

insert into radnikalendar(id) values(1);
insert into radnikalendar(id) values(2);

insert into termin(datum,radnikalendar_id) values ('Wed Oct 14 00:00:00 CEST 2020',1);
insert into termin(datum,radnikalendar_id) values ('Wed Sep 09 14:00:00 CEST 2020',1);
insert into termin(datum,radnikalendar_id) values ('Thu Sep 17 16:00:00 CEST 2020',1);
insert into termin(datum,radnikalendar_id) values ('Thu Sep 17 18:00:00 CEST 2020',2);
insert into termin(datum,radnikalendar_id) values ('Wed Sep 09 18:00:00 CEST 2020',2);

insert into zdravstvenikarton(dioptrija,alergija,visina,tezina,krvnagrupa) values ('+0,5','Polen','184','77','B+');

insert into pacijent(user_id,zdravstvenikarton_id) values (3,1);

insert into adminklinike(user_id,klinika_id) values (6,1);

insert into lekar(specijalizacija,opis,user_id,klinika_id,radnikalendar_id) values('Lekar Opste Prakse','Opis petra petrovica.',4,1,1);
insert into lekar(specijalizacija,opis,user_id,klinika_id,radnikalendar_id) values('Kardiolog','Opis milana milanovica.',5,1,2);

insert into tippregleda (naziv, opis) values ('Osti Pregled','Opsti pregle pacijenata');
insert into tippregleda (naziv, opis) values ('Kardioloski Pregled','Kardioloski pregle pacijenata');

insert into sala (naziv, klinika_id, brojsale) values ('Glavna Sala', 1,'1');

insert into pregled (termin_id, sala_id, lekar_id, pacijent_id, tippregleda_id) values (1,1,1,1,1);

insert into cenovnik (klinika_id, tippregleda_id, cena, popust) values (1,1,1200.00, 10);

--Unapred definiani pregledi
insert into pregled (termin_id, sala_id, lekar_id, tippregleda_id) values (2,1,1,1);
insert into pregled (termin_id, sala_id, lekar_id, tippregleda_id) values (3,1,1,1);
insert into pregled (termin_id, sala_id, lekar_id, tippregleda_id) values (4,1,2,1);
insert into pregled (termin_id, sala_id, lekar_id, tippregleda_id) values (5,1,2,1);