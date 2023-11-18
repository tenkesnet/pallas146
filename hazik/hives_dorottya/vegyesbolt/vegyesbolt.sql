set search_path = vegyesbolt;

create table termek_kategoriak(
id serial primary key,
kategoria_nev text
);
create table beszallitok (
id serial primary key,
ceg_nev text,
kapcsolattarto_nev text,
telefonszam numeric(11)
);
create table termekek(
id serial primary key,
nev text,
ar int,
LOT_szam numeric(6),
lejarat date,
kategoria_id serial not null references termek_kategoriak(id)
);
create table leltar(
leltar_datuma date primary key,
termek_id serial not null references termekek(id),
keszlet int
);

create table termek_rendelesek(
id serial primary key,
rendeles_datuma date,
beszallito_id serial not null references beszallitok(id),
termek_id serial not null references termekek(id),
dolgozo_id serial not null references dolgozok(id),
rendelesi_mennyiseg int
);

create table dolgozok(
id serial primary key,
dolgozo_nev text,
munkakor text,
muszak_beosztas text
);

create table vasarlasok (
blokk_id serial primary key,
termek_id serial not null references termekek(id),
dolgozo_id serial not null references dolgozo(id),
vasarolt_mennyiseg int,
egysegar int,
vasarlas_datuma timestamp
);


create table termek_visszahivas(
id serial primary key,
panasz text,
termek_id serial not null references termekek(id)
);

insert into termek_kategoriak values
(1,'Alapvető élelmiszerek'),
(2,'Fagyasztott élelmiszerek'),
(3,'Tejtermékek'),
(4,'Pékáru'),
(5,'Hentespult'),
(6,'Zöldség-gyümölcs'),
(7,'Ital'),
(8,'Háztartási felszerelés')
(9,'Vegyi áru'),
(10,'Elektronika'),
(11,'Állat felszerelés'),
(12,'Kozmetika, illatszer');

insert into beszallitok values
(1,'Media Markt', 'Kovács Péter',06204789532),
(2,'KEDO Eurocosmetics Kft.', 'Szabó Péter',06304532897),
(3,'Tápiócsir Kft', 'Németh Ferenc',06202829132),
(4,'Matusz-Vad', 'Tóth Sándor',0670510331),
(5,'Alphazoo','Vida Noémi',06304521133);

insert into termekek(id serial primary key,nev text,ar int,LOT_szam numeric(6),lejarat date,kategoria_id) values
(1,'Kenyér',800,202305,'2023-11-22',4),
(2,'Tusfürdő',1800,254701,'2025-11-30',12),
(3,'Hamburgerhús pogácsa',1999,547032,'2024-02-12',2),
(4,'Tej 2,8%',519,231147,'2023-12-02',3),
(5,'Pölöskei málnaszörp',699,230547,'2024-12-22',7),
(6,'Kutya nyakörv',1499,598733,null,11);

insert into leltar(id serial primary key,leltar_datuma date,termek_id serial, keszlet int) values
(1,'2023-11-17',1,30),
(2,'2023-11-17',2,100),
(3,'2023-11-17',3,0),
(4,'2023-11-17',4,200),
(5,'2023-11-17',5,20),
(6,'2023-11-17',6,0);

insert into termek_rendelesek(id serial primary key,beszallito_id,termek_id,rendelesi_mennyiseg int) values
(1,4,3,50),
(2,5,6,30);

insert into dolgozok(id serial primary key,dolgozo_nev text,munkakor text,muszak_beosztas text)
(1,'Szabó Lehel','árufeltöltő','délelőttös'),
(2,'Kovács Krisztián','raktáros','délelőttös'),
(3,'Szabó Csilla','árufeltöltő','délutános'),
(4,'Gulyás Gabriella','pénztáros','délutános'),
(5,'Kovács Balázs','raktáros','éjszakás'),
(6,'Tóth Lajos','árufeltöltő','éjszakás');

insert into vasarlasok(blokk_id serial primary key,termek_id, vasarolt_mennyiseg int,egysegar int,vasarlas_datuma timestamp) values
(1,1,2,800,'2023-11-16 08:00:00'),
(2,3,1,1999,'2023-11-16 10:00:00'),
(3,4,6,519,'2023-11-16 12:30:00'),
(4,6,3,1499,'2023-11-16 20:10:00');











