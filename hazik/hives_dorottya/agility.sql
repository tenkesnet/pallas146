--show search_path;


create table tulajdonos(
azon serial primary key,
teljesnev text,
cim text
);

create table szintkategoria(
azon serial primary key,
szint text
);

create table meretkategoria(
azon serial primary key,
meret text
);

create table kutyafajtak(
azon serial primary key,
kutyafajta text
);

create table kutyak(
azon serial primary key,
tulaj_azon int,
hivonev text,
fajta_azon int,
kor numeric(2),
meretkat_azon int,
szintkat_azon int
);

alter table kutyak add constraint FK_kutyak_tulajdonos foreign key (tulaj_azon) references tulajdonos(azon) on update set null on delete set null;
alter table kutyak add constraint FK_kutyak_meretkategoria foreign key (meretkat_azon) references meretkategoria(azon) on update set null on delete set null;
alter table kutyak add constraint FK_kutyak_szintkategoria foreign key (szintkat_azon) references szintkategoria(azon) on update set null on delete set null;
alter table kutyak add constraint FK_kutyak_kutyafajtak foreign key (fajta_azon) references kutyafajtak(azon) on update set null on delete set null;


create table felvezeto(
azon serial primary key,
nev text,
szuldat date,
kartyaszam numeric(10)
);


create table futamok(
azon int,
kutya_azon int,
felvezeto_azon int,
kezdo_idopont timestamp,
hiba numeric(2),
ido decimal(5,2), 
PRIMARY KEY (azon,kutya_azon,kezdo_idopont)
);

alter table futamok add constraint FK_futamok_felvezeto foreign key (felvezeto_azon) references felvezeto(azon) on update set null on delete set null;
alter table futamok add constraint FK_futamok_kutya foreign key (kutya_azon) references kutyak(azon) on update set null on delete set null;


insert into tulajdonos values (1,'Hives Dorottya','Sülysáp'),(2,'Ács-Kövesi Ágnes','Töltéstava'), (3, 'Bartos Zsuzsanna', 'Budapest'), (4, 'Bacsa Nóra', 'Monor'), (5, 'Papp Rita','Maglód'),
(6, 'Pirity Árpád', 'Győr'), (7, 'Szilágyi Anita', 'Székesfehérvár'), (8, 'Balogh-Nagy Réka', 'Gyula'), (9, 'Tóth Vivien', 'Budapest'), (10, 'Kovács Zsuzsanna', 'Szentendre'), 
(11, 'Kovács Ágnes', 'Eger'), (12, 'Csatlós Timea', 'Budapest'), (13, 'Kovács Nikolett', 'Pomáz');

insert into szintkategoria values (1,'zsenge'), (2, 'kezdő'), (3, 'A1'), (4, 'A2'), (5, 'A3');

insert into meretkategoria values (1, 'small'), (2, 'medium'), (3, 'intermediate'), (4, 'large');

insert into kutyafajtak values (1, 'Border Collie'), (2, 'Uszkár'), (3, 'Pumi'), (4, 'Sheltie'), (5, 'keverék'), (6, 'Malinois'), (7, 'Törpepincser');

insert into kutyak values (1,1,'Rhiannon',1,9,3,5), (2,1,'Szilaj',1,3,4,3), (3,9,'Ensley',2,7,2,5), (4,9, 'Elvis',2,5,1,4), (5,9,'Mixi',5,9,2,4), (6,10,'Lucy',5,7,3,4),
(7,10,'Hédi',5,6,3,5), (8,7,'Tengo',1,6,4,5), (9,6,'Mia',4,2,1,4), (10,6,'Leon',4,8,2,5), (11,2,'Wetu',1,2,4,1), (12,2,'Jiu',1,5,4,5), (13,3,'Chia',1,5,4,5),
(14,4,'Durák',3,9,2,3), (15,4,'Babér',3,4,3,2), (16,8,'Cinna',1,8,4,5), (17,8,'Nic',2,5,2,5), (18,5,'Stic',1,4,4,5), (19,5,'Ella',4,3,2,3), (20,11,'Penge',6,1,4,2),
(21,12,'Boni',5,1,4,2), (22,12,'Karma',7,2,1,1), (23,13,'Mars',1,1,4,1), (24,3,'Tofu',1,1,4,3);

insert into felvezeto values (1,'Ács-Kövesi Ágnes', '1970-12-01',00031016), (2,'Hives Dorottya', '1989-08-04',000356), (3, 'Kresz Léna', '2015-07-20',00033231), 
(4, 'Kárpáti Dalma','1990-08-14',0003260), (5, 'Kovács Nikolett', '1996-04-06',0003563), (6, 'Richter-Sallay Zsófia', '1990-07-10',00036170), (7,'Tóth Vivien', '1991-06-20', 0003569),
(8, 'Hidvégi Géza', '1968-01-12', 3203), (9,'Pirity Árpád', '1965-02-17',00035448), (10, 'Juhász Adrienn', '1978-03-30',2446), (11,'Ember Katalin','1980-05-06',000354),
(12,'Kárász Edit','1985-06-01',3246), (13,'Bartos Zsuzsanna','1992-09-04',5331), (14,'Papp Rita','1991-01-23',00035), (15,'Vincze Zsolt','1997-11-11',5841),
(16,'Ficzere Csenge','1994-01-29',0003151), (17,'Balogh-Nagy Réka','1989-03-20',000357);

insert into futamok values (1,1,2,0,35.40), (1,2,2,15,38.56), (1,3,7,5,44.50), (2,4,7,20,50.23), (2,6,3,35,78.51), (2,8,6,0,37.20), (7,12,1,0,40.11), 
(8,16,17,0,34.80), (9,23,5,20,41.60), (10,22,11,10,39.75), (11,21,12,10,37.75), (12,20,15,0,40.05);