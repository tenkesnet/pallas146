show search_path;
set search_path = auto;

--drop table if exists sz_automarka
create table sz_automarka (
nev text primary key
);

create table sz_autotipus (
azon serial primary key,
megnevezes text,
marka text,
leiras text
);

alter table sz_autotipus add constraint FK_sz_autotipus_sz_automarka foreign key (marka) references sz_automarka(nev) on update set null on delete set null;
--alter table sz_autotipus drop constraint FK_sz_autotipus_sz_automarka;

create table sz_auto (
azon serial primary key,
szin text,
elso_vasarlas_idopontja date,
elso_vasarlasi_ar numeric(20),
tipus_azon int,
rendszam text
);

alter table sz_auto add constraint FK_sz_autotipus_sz_auto foreign key (tipus_azon) references sz_autotipus(azon) on update set null on delete set null;
--alter table sz_auto drop constraint FK_sz_autotipus_sz_auto;

create table sz_autofelertekeles (
auto_azon int,
datum date,
ertek numeric(20),
primary key(auto_azon,datum)
);

alter table sz_autofelertekeles add constraint FK_sz_autofelertekeles_sz_auto foreign key (auto_azon) references sz_auto(azon) on update set null on delete set null;
--alter table sz_autofelertekeles drop constraint FK_sz_autofelertekeles_sz_auto;

create table sz_tulajdonos (
azon serial primary key,
nev text,
cim text
);

create table sz_auto_tulajdonosa (
auto_azon int,
vasarlas_ideje date,
tulaj_azon int,
primary key (auto_azon,vasarlas_ideje)
);

alter table sz_auto_tulajdonosa add constraint FK_sz_auto_tulajdonosa_sz_auto foreign key (auto_azon) references sz_auto(azon) on update set null on delete set null;
alter table sz_auto_tulajdonosa add constraint FK_sz_auto_tulajdonosa_sz_tulajdonos foreign key (tulaj_azon) references sz_tulajdonos(azon) on update set null on delete set null;

create table sz_szerelo(
azon serial primary key,
nev text,
cim text,
telefon text,
szul_dat date,
adoszam text
);
 
create table sz_szerelomuhely(
azon serial primary key,
cim text,
vezeto_azon int,
nev text
);
 
alter table sz_szerelomuhely add constraint FK_sz_szerelomuhely_sz_szerelo foreign key(vezeto_azon) references sz_szerelo(azon) on update set null on delete set null;
 
create table sz_dolgozik(
szerelo_azon int,
muhely_azon int,
munkaviszony_kezdete date,
munkaviszony_vege date,
havi_fizetes numeric(10),
primary key(szerelo_azon,muhely_azon,munkaviszony_kezdete)
);
 
alter table sz_dolgozik add constraint FK_sz_dolgozik_sz_szerelo foreign key(szerelo_azon) references sz_szerelo(azon) on update set null on delete set null;
alter table sz_dolgozik add constraint FK_sz_dolgozik_sz_szerelomuhely foreign key(muhely_azon) references sz_szerelomuhely(azon) on update set null on delete set null;
 
 
create table sz_szereles (
auto_azon int,
muhely_azon int,
szereles_kezdete date,
szereles_vege date,
munkavegzes_ara numeric(10),
primary key(auto_azon,muhely_azon,szereles_kezdete)
);
 
alter table sz_szereles add constraint FK_sz_szereles_sz_auto foreign key(auto_azon) references sz_auto(azon) on update set null on delete set null;
alter table sz_szereles add constraint FK_sz_szereles_sz_szerelomuhely foreign key(muhely_azon) references sz_szerelomuhely(azon) on update set null on delete set null;

insert into sz_automarka values('audi'), ('mercedes'), ('vw'), ('opel'),('suzuki'),('trabant'),	('bmw'),('maserati'),('kia');

insert into sz_autotipus values (1,'bevásárló','opel',null), (2,'bevásárló2','suzuki',null), (3,'luxus','audi',null) ,(4,'old','vw',null),
(5,'sport','bmw',null),	(6,'combi','kia',null),	(7,'luxus','maserati',null);

insert into sz_auto values (1,'kék','2008-10-20',1200000,1,'AAA-001'),(2,'fehér','2002-02-10',800000,2,'ABA-001'),(3,'fekete','2000-05-10',600000,1,'AVV-004'),
(4,'piros','2020-07-10',8000000,3,'KEZ-873'),(5,'kék','2020-01-12',25000000,7,'SAS-111'),	(6,'zold','2017-07-10',6000000,6,'JAJ-009'),(7,'barna','2023-09-29',60000000,4,'ZAJ-999');
 
insert into sz_tulajdonos values (1,'Kiss Kálmán','Budapest'),(2,'Nagy József','Debrecen'),(3,'Erdős Nikolett','Szekszárd'),
(4,'Papp Lajos','Győr'),(5,'Öreg László','Nyíregyháza'),(6,'Tóth Ottó','Piliscsaba'),(7,'Józan Krisztina','Békéscsaba'),
(8,'Kovács László','Szeged'),(9,'Szabó Attila','Pécs'),(10,'Fiatal Katalin','Szombathely'),(11,'Kádár Mónika','Veszprém'),
(12,'Magas Béla','Miskolc'),(13,'Vajda Erika','Salgótarján'),(14,'Boros Levente','Eger'),(15,'Kerek Matild', 'Szentendre'),
(16,'Magyar Oszkár','Zalaegerszeg'),(17,'Tóth András','Verőce'),(18,'John Smith','Sopron'),(19,'Molnár Géza','Szeghalom'),
(20,'Mészáros Árpád','Mórahalom');

insert into sz_auto_tulajdonosa values (1,'2008-10-20',2),(1,'2010-10-20',3),(6,'2010-11-20',3),(6,'2008-10-20',2),(2,'2004-10-20',3),(3,'2008-10-20',4),(4,'2008-10-20',5),(5,'2008-10-20',6);

insert into sz_szerelo values (1, 'Kovács János','Budapest',null,'1989-08-04',null), (2, 'Szilágyi Gyula','Gödöllő',null,'1969-01-24',null), (3, 'Tarcsa Mihály','Szolnok',null,'1994-08-20',null),
(4, 'Sebők István','Debrecen',null,'1972-10-12',null), (5, 'Tóth Pál','Nagytarcsa',null,'1980-03-15',null), (6, 'Jakus László','Szolnok',null,'1978-04-04',null), (7, 'Kovács László','Budapest',null,'1980-07-08',null),
(8, 'Szabó Tamás','Gödöllő',null,'1975-12-24',null);


insert into sz_AUTOFELERTEKELES values 
(1, '2010-09-15', 3000),
(2, '2015-09-23', 2111),
(3, '2018-09-05', 2400),
(4, '2021-09-05', 4000),
(5, '2016-09-01', 2500),
(1, '2019-09-19', 4500),
(5, '2025-09-09', 3333),
(3, '2023-09-11', 4490),
(5, '2023-09-30', 3200);

insert into sz_szerelomuhely values
(1,'Budapest',1,'Gumis'),(2,'Győr',2,'Karburátoros'),(3,'Szeged',3,'Fékes'),(4,'Szekszárd',4,'Üveges'),(5,'Gyál',5,'Lakatos'),(6,'Szekszárd',2,'Karburátoros'),
(7,'Pécs',1,'Gumis'),(8,'Budapest',5,'Lakatos'),(9,'Vecsés',3,'Fékes'),(10,'Jászjákóhalma',1,'Gumis');

insert into sz_szereles values (1,2,'2023-09-06', '2023-09-15', 250000), (2,8,'2023-08-26', '2023-09-05', 100000), (3,7,'2023-08-06', '2023-08-25', 500000), (4,1,'2023-09-20', '2023-09-21', 12000),
(5,5,'2023-09-16', '2023-09-21', 600000), (6,9,'2023-09-23', '2023-09-25', 50000), (7,3,'2023-09-01', '2023-09-12', 1250000);

insert into sz_dolgozik values
(1, 1, '2000-02-01',null,'350000'),
(3, 2, '2005-02-01',null,'780000'),
(5, 6, '2015-02-01','2020-12-31','615000'),
(4, 4, '2019-02-01',null,'389000'),
(7, 5, '2021-02-01',null,'490000'),
(8, 1, '2008-02-01',null,'336000'),
(2, 10, '2011-02-01',null,'315000'),
(6, 9, '1990-02-01','2018-05-31','597000');

 
