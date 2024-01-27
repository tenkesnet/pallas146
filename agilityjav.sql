--show search_path;
SET search_path= agility;

create table szerep(
id serial primary key,
nev text
);

INSERT INTO szerep VALUES (1,'tulajdonos') , (2,'felvezető'), (3,'biró');

create table kutyasok (
id serial primary key,
teljesnev text,
cim text,
szuldat date,
kartyaszam numeric(10),
szerep_id int
);

alter table kutyasok add constraint FK_kutyasok_szerep foreign key (szerep_id) references szerep(id) on update set null on delete set null;

insert into kutyasok values (1,'Ács-Kövesi Ágnes', 'Győr', '1970-12-01',00031016, 2), (2,'Hives Dorottya', 'Sülysáp', '1989-08-04',000356,2), (3, 'Kresz Léna', 'Szentendre', '2015-07-20',00033231,2), 
(4, 'Kárpáti Dalma','Budapest','1990-08-14',0003260,3), (5, 'Kovács Nikolett', 'Pomáz','1996-04-06',0003563, 2), (6, 'Richter-Sallay Zsófia', 'Telki', '1990-07-10',00036170,2), (7,'Tóth Vivien', 'Budapest','1991-06-20', 0003569,2),
(8, 'Hidvégi Géza','Monor', '1968-01-12', 3203,1), (9,'Pirity Árpád', 'Győr', '1965-02-17',00035448, 1), (10, 'Juhász Adrienn','Monor', '1978-03-30',2446, 1), (11,'Ember Katalin','Budakeszi','1980-05-06',000354,2),
(12,'Kárász Edit', 'Gyömrő','1985-06-01',3246,2), (13,'Bartos Zsuzsanna', 'Budapest','1992-09-04',5331,1), (14,'Papp Rita','Maglód','1991-01-23',00035,3), (15,'Vincze Zsolt','Békéscsaba','1997-11-11',5841,2),
(16,'Ficzere Csenge','Gyula','1994-01-29',0003151,2), (17,'Balogh-Nagy Réka','Gyula','1989-03-20',000357,3);

create table szintkategoria(
id serial primary key,
szint text
);

insert into szintkategoria values (1,'zsenge'), (2, 'kezdő'), (3, 'A1'), (4, 'A2'), (5, 'A3');

create table meretkategoria(
id serial primary key,
meret text
);

insert into meretkategoria values (1, 'small'), (2, 'medium'), (3, 'intermediate'), (4, 'large');

create table kutyafajtak(
id serial primary key,
kutyafajta text
);

insert into kutyafajtak values (1, 'Border Collie'), (2, 'Uszkár'), (3, 'Pumi'), (4, 'Sheltie'), (5, 'keverék'), (6, 'Malinois'), (7, 'Törpepincser');

create table kutyak(
id serial primary key,
hivonev text,
fajta_id int,
kor numeric(2),
meretkat_id int,
szintkat_id int
);


alter table kutyak add constraint FK_kutyak_meretkategoria foreign key (meretkat_id) references meretkategoria(id) on update set null on delete set null;
alter table kutyak add constraint FK_kutyak_szintkategoria foreign key (szintkat_id) references szintkategoria(id) on update set null on delete set null;
alter table kutyak add constraint FK_kutyak_kutyafajtak foreign key (fajta_id) references kutyafajtak(id) on update set null on delete set null;

insert into kutyak (id, hivonev, fajta_id, kor, meretkat_id,szintkat_id) values (1,'Rhiannon',1,9,3,5), (2,'Szilaj',1,3,4,3), (3,'Ensley',2,7,2,5), (4,'Elvis',2,5,1,4), (5,'Mixi',5,9,2,4), (6,'Lucy',5,7,3,4),
(7,'Hédi',5,6,3,5), (8,'Tengo',1,6,4,5), (9,'Mia',4,2,1,4), (10,'Leon',4,8,2,5), (11,'Wetu',1,2,4,1), (12,'Jiu',1,5,4,5), (13,'Chia',1,5,4,5),
(14,'Durák',3,9,2,3), (15,'Babér',3,4,3,2), (16,'Cinna',1,8,4,5), (17,'Nic',2,5,2,5), (18,'Stic',1,4,4,5), (19,'Ella',4,3,2,3), (20,'Penge',6,1,4,2),
(21,'Boni',5,1,4,2), (22,'Karma',7,2,1,1), (23,'Mars',1,1,4,1), (24,'Tofu',1,1,4,3);


create table futamok(
id int,
kutya_id int,
kutyasok_id int,
kezdo_idopont timestamp,
hiba numeric(2),
ido decimal(5,2),
eredmeny decimal(3),
palyahossz decimal(3),
PRIMARY KEY (id,kutya_id,kezdo_idopont)
);

alter table futamok add constraint FK_futamok_kutyasok foreign key (kutyasok_id) references kutyasok(id) on update set null on delete set null;
alter table futamok add constraint FK_futamok_kutya foreign key (kutya_id) references kutyak(id) on update set null on delete set null;

insert into futamok values (1,1,2, '2023-09-16 08:00:00',0,35.40,1,200), (1,2,2,'2023-09-16 08:00:00',15,38.56,2,200), (1,3,7,'2023-09-16 08:00:00',5,44.50,3,200), (2,4,7,'2023-09-16 09:30:00',20,50.23,2,198), (2,6,3,'2023-09-16 09:30:00',35,78.51,3,198), 
(2,8,6,'2023-09-16 09:30:00',0,37.20,1,198), (3,12,1,'2023-09-16 10:00:00',0,40.11,2,220), (3,16,17,'2023-09-16 10:00:00',0,34.80,1,220), (3,23,5,'2023-09-16 10:00:00',20,41.60,4,220), (3,22,11,'2023-09-16 10:00:00',10,39.75,3,220), 
(4,21,12,'2023-09-16 12:00:00',10,37.75,3,180), (4,20,15,'2023-09-16 12:00:00',0,40.05,1,180), (4,24,16,'2023-09-16 12:00:00',5,42.50,2,180);
