set search_path=kisbolt;

create table termek_csop (
id serial primary key,
tipus char(30)
);

insert into termek_csop (tipus) values ('zoldseg');
insert into termek_csop (tipus) values ('gyumolcs');
insert into termek_csop (tipus) values ('tisztitoszer');
insert into termek_csop (tipus) values ('edesseg');
insert into termek_csop (tipus) values ('udito');
insert into termek_csop (tipus)	values ('alkoholos_ital');
insert into termek_csop (tipus) values ('pekaru');
insert into termek_csop (tipus) values ('husaru');

create table termek (
id serial primary key,
termek_nev varchar(30),
egysegar int,
kiszereles varchar(4),
lejarat date,
termek_csop_id serial not null references termek_csop(id)
);

insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Banán',340,'kg','2023-12-23',(select id from termek_csop where tipus='gyumolcs'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Narancs',424,'kg', '2024-01-10',(select id from termek_csop where tipus='gyumolcs'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Ananasz',799,'db','2023-11-30',(select id from termek_csop where tipus='gyumolcs'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Alma Idared',329,'kg','2024-03-13',(select id from termek_csop where tipus='gyumolcs'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Alma Golden',419,'kg','2024-01-14',(select id from termek_csop where tipus='gyumolcs'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Mango',899,'db','2023-12-19',(select id from termek_csop where tipus='gyumolcs'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Sargarepa',219,'kg','2024-04-13',(select id from termek_csop where tipus='zoldseg'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Feherrepa',799,'kg','2024-03-21',(select id from termek_csop where tipus='zoldseg'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Burgonya',399,'kg','2024-02-12',(select id from termek_csop where tipus='zoldseg'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Cekla',509,'kg','2024-04-10',(select id from termek_csop where tipus='zoldseg'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Paradicsom',499,'kg','2023-12-01',(select id from termek_csop where tipus='zoldseg'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Kapia Paprika',799,'kg','2023-12-09',(select id from termek_csop where tipus='zoldseg'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Uborka',399,'db','2023-12-15',(select id from termek_csop where tipus='zoldseg'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Mososzer',1299,'csom','2024-06-11',(select id from termek_csop where tipus='tisztitoszer'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Szappan',799,'db','2025-06-12',(select id from termek_csop where tipus='tisztitoszer'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Mosogatoszer',699,'db','2024-01-15',(select id from termek_csop where tipus='tisztitoszer'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Gumicukor',599,'db','2024-03-11',(select id from termek_csop where tipus='edesseg'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Ropi',199,'db','2024-01-31',(select id from termek_csop where tipus='edesseg'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Cola',399,'db','2024-04-10',(select id from termek_csop where tipus='udito'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Narancslé',599,'db','2023-12-12',(select id from termek_csop where tipus='udito'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Sör dobozos',319,'db','2024-02-11',(select id from termek_csop where tipus='alkoholos_ital'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Sör üveges',499,'db','2023-12-31',(select id from termek_csop where tipus='alkoholos_ital'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Fehér kenyér',500,'kg','2023-11-14',(select id from termek_csop where tipus='pekaru'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Kakaós csiga',239,'db','2023-11-12', (select id from termek_csop where tipus='pekaru'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Barna kenyér, szeletelt',679,'kg','2023-11-30',(select id from termek_csop where tipus='pekaru'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Csirkemell',999,'kg','2023-11-16',(select id from termek_csop where tipus='husaru'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Párizsi',899,'kg','2023-12-01',(select id from termek_csop where tipus='husaru'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Szalámi',1699,'kg','2023-12-28',(select id from termek_csop where tipus='husaru'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Száraz kolbász',1299,'kg','2024-01-31',(select id from termek_csop where tipus='husaru'));
insert into termek (termek_nev,egysegar,kiszereles,lejarat,termek_csop_id)
values ('Sertésmáj',999,'kg','2023-11-10',(select id from termek_csop where tipus='husaru'));

create table szallito(
id serial primary key,
nev char(50),
termek_csop_id serial not null references termek(id),
telefonszam varchar(12)
);

insert into szallito (nev,termek_csop_id,telefonszam)
values ('Kiss és Társa Kft.',(select id from termek_csop where tipus ='gyumolcs'),'06305478899');
insert into szallito (nev,termek_csop_id,telefonszam)
values ('Italker Kft.', (select id from termek_csop where tipus = 'udito'),'06706974411');
insert into szallito (nev,termek_csop_id,telefonszam)
values ('Italker Kft.', (select id from termek_csop where tipus = 'alkoholos_ital'),'06706974411');
insert into szallito (nev,termek_csop_id,telefonszam)
values ('Kiss és Társa Kft.',(select id from termek_csop where tipus ='zoldseg'),'06305478899');
insert into szallito (nev,termek_csop_id,telefonszam)
values ('Rágcsa Bt.', (select id from termek_csop where tipus ='edesseg'),'06208976985');
insert into szallito (nev,termek_csop_id,telefonszam)
values ('Kiss Péter EV',(select id from termek_csop where tipus ='tisztitoszer'),'06704587936');
insert into szallito (nev,termek_csop_id,telefonszam)
values ('Hentes Kft.',(select id from termek_csop where tipus ='husaru'),'06301458797');
insert into szallito (nev,termek_csop_id,telefonszam)
values ('Friss Pék Bt.',(select id from termek_csop where tipus ='pekaru'),'06204574789');

create table raktar_keszlet (
id serial primary key,
keszlet_id serial not null references termek(id),
mennyiseg int
);

insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id  from termek where termek_nev='Banán'),18);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Narancs'),13);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Ananasz'),9);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Alma Idared'),45);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Alma Golden'),14);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Mango'),45);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Sargarepa'),65);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Feherrepa'),23);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Burgonya'),41);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Cekla'),19);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Paradicsom'), 14);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Kapia Paprika'), 5);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Uborka'),34);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Mososzer'),11);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Szappan'),56);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Mosogatoszer'),23);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Gumicukor'),43);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Ropi'),45);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Cola'),45);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Narancslé'),23);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Sör dobozos'),65);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Sör üveges'),23);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Fehér kenyér'),15);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Kakaós csiga'),23);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Barna kenyér, szeletelt'),18);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Csirkemell'),35);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Párizsi'),16);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Szalámi'),8);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Száraz kolbász'),7);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Száraz kolbász'),7);
insert into raktar_keszlet (keszlet_id, mennyiseg)
values ((select id from termek where termek_nev='Sertésmáj'),6);

create table selejt (
id serial primary key,
selejt_id serial not null references termek(id)
);

create table akcio (
id serial primary key,
akcios_termek_id serial not null references termek(id),
akcios_ar int
);

insert into akcio (akcios_termek_id, akcios_ar)
select id, egysegar*0.8 from termek 
where EXTRACT(day FROM age(current_date-termek.lejarat::date )) < 5;

create table forgalom (
id serial primary key,
termek_id serial not null references termek(id),
eladott_mennyiseg int
);

insert into forgalom (termek_id, eladott_mennyiseg)
values ((select id from termek where termek_nev='Fehér kenyér'),7);
insert into forgalom (termek_id, eladott_mennyiseg)
values ((select id from termek where termek_nev='Kakaós csiga'),18);
insert into forgalom (termek_id, eladott_mennyiseg)
values ((select id from termek where termek_nev='Szalámi'),3);



create table dolgozo (
id serial primary key,
nev char(30),
fizetes int,
beosztas char(30),
munkaviszony_kezdet date
);

insert into dolgozo (nev,fizetes,beosztas,munkaviszony_kezdet)
values ('Kiss Lajos',350000,'Zoldseges','2013-01-02');
insert into dolgozo (nev,fizetes,beosztas,munkaviszony_kezdet)
values ('Nagy Ádám',370000,'Raktáros','2020-06-01');
insert into dolgozo (nev,fizetes,beosztas,munkaviszony_kezdet)
values ('Kovács Marika',390000,'Pénztáros','2008-07-01');
insert into dolgozo (nev,fizetes,beosztas,munkaviszony_kezdet)
values ('Szabó Márton',220000,'Gyakornok','2023-09-03');

create table rendeles (
id serial primary key,
rendelt_termek_id serial not null references termek(id),
szallito_id serial not null references szallito(id),
rendelo_id serial not null references dolgozo(id),
rendelt_mennyiseg int,
beszerzesi_ar int,
fizetve char(1),
beerkezes date
);

insert into rendeles (rendelt_termek_id,szallito_id,rendelo_id,rendelt_mennyiseg,beszerzesi_ar,fizetve,beerkezes)
values ((select id from termek where termek_nev='Ananasz'),
(select id from szallito where termek_csop_id=1),(select id from dolgozo where beosztas='Zoldseges'),10,599,'I','2023-11-18');
insert into rendeles (rendelt_termek_id,szallito_id,rendelo_id,rendelt_mennyiseg,beszerzesi_ar,fizetve,beerkezes)
values ((select id from termek where termek_nev='Sör üveges'),
(select id from szallito where termek_csop_id=6),(select id from dolgozo where beosztas='Raktáros'),200,229,'N','2023-11-16');
