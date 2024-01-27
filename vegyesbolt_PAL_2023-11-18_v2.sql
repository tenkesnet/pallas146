--show search_path;
--drop table if exists termekek;
--drop table beszallitok cascade;
--alter table sz_auto drop constraint FK_sz_autotipus_sz_auto;

set search_path = vegyesbolt;

create table termekek(
	termek_id serial primary key,
	termek_megnevezes text,
	beszallito_id int,
	beszallito text,
	termek_tipus text, --tejtermék,gyümölcs,zöldség,péksütemény,ital
	termek_beszerzesi_ar int,
	termek_eladasi_ar int,
	termek_profit int,
	szavatossagi_ido_honap int
);

create table beszallitok(
	beszallito_id serial primary key,
	beszallito_megnevezes text,
	beszallito_regio text, --NyMagyarország,KMagyarország,DMagyarország,ÉMagyarország
	iranyitoszam int,
	varos text,
	utca_hazszam text
);

alter table termekek 
add constraint FK_termekek_beszallitok 
foreign key (beszallito_id) 
references beszallitok(beszallito_id) 
on update set null on delete set null;


create table selejt (
	selejt_id serial primary key,
	selejt_bekerulesi_datum date unique,
	zoldseg_selejt_mennyiseg int,
	tejtermek_selejt_mennyiseg int,
	pekaru_selejt_mennyiseg int,
	gyumolcs_selejt_mennyiseg int,
	hus_selejt_mennyiseg int
);

create table ertekesites (
	ertekesites_id serial primary key,
	ertekesitesi_datum date,
	ertekesitesi_ido time, --reggeli,napközbeni,délutáni
	vasarloi_letszam int,
	bevetel int
);

create table kiadas (
	kiadas_id serial primary key,
	kiadas_datum date,
	beszallito text unique, --fk_termekek(beszallito)_kiadas(beszallito)
	kiadas int 
);

alter table termekek 
add constraint FK_termekek_kiadas
foreign key (beszallito) 
references kiadas (beszallito) 
on update set null on delete set null;

create table forgalom (
	forgalom_id serial primary key,
	datum date, --select ertekesitesi_datum
	napi_bevetel int,
	napi_kiadas int,
	summa_forgalom int --(napi_bevétel)-(napi_kiadas)
);

create table fenntartasi_koltsegek (
	koltseg_id serial primary key,
	koltseg_megnevezes text,
	koltseg_intenzitas text, --havi,negyedéves,féléves,éves
	koltseg_tipus text,
	koltseg_merteke int
);

create table dolgozok (
	dolgozo_id int,
	nev text,
	eletkor int,
	lokacio text,
	netto_ber int,
	brutto_ber int,
	belepes_datuma date,
	ado_kedvezmeny text,
	biztosito_id int, --fk_biztosito(biztosito_id)_dolgozok(biztosito_id)
	bolt_id int, --fk_boltok(bolt_id)_dolgozok(bolt_id)
	primary key(dolgozo_id,nev)	
);

create table boltok (
	bolt_id serial primary key,
	varos text,
	utca_hazszam text,
	biztosito_id int --fk_biztosito(biztosito_id)_boltok(biztosito_id)
);

alter table dolgozok  
add constraint FK_dolgozok_boltok
foreign key (bolt_id) 
references boltok (bolt_id) 
on update set null on delete set null;

create table biztosito (
	biztosito_id serial primary key,
	nev text,
	varos text,
	utca_hazszam text,
	biztositasi_kategoria text, --ingatlan
	biztositas_kezdete date,
	biztositas_lejarata date,
	biztositas_merteke int --százalékos érték
);

alter table boltok  
add constraint FK_boltok_biztosito
foreign key (biztosito_id) 
references biztosito (biztosito_id) 
on update set null on delete set null;

alter table dolgozok 
add constraint FK_dolgozok_biztosito
foreign key (biztosito_id) 
references biztosito (biztosito_id) 
on update set null on delete set null;

alter table dolgozok  
add constraint FK_dolgozok_boltok
foreign key (bolt_id) 
references boltok (bolt_id) 
on update set null on delete set null;

insert into termekek values
	(1,'Tejföl',1,(select beszallito_megnevezes from beszallitok where beszallito_id = 1),'tejtermék',120,150,30,3),
	(2,'Kenyér',2,(select beszallito_megnevezes from beszallitok where beszallito_id = 2),'pékáru',300,450,150,1),
	(3,'Zsemle',2,(select beszallito_megnevezes from beszallitok where beszallito_id = 2),'pékáru',80,120,40,1),
	(4,'Tej 1,5%',1,(select beszallito_megnevezes from beszallitok where beszallito_id = 1),'tejtermék',280,310,30,1),
	(5,'Tej 2,6%',1,(select beszallito_megnevezes from beszallitok where beszallito_id = 1),'tejtermék',280,350,70,1),
	(6,'Paradicsom',3,(select beszallito_megnevezes from beszallitok where beszallito_id = 3),'zöldség',200,350,150,1),
	(7,'Uborka',4,(select beszallito_megnevezes from beszallitok where beszallito_id = 4),'zöldség',100,150,50,2),
	(8,'Saláta',4,(select beszallito_megnevezes from beszallitok where beszallito_id = 4),'zöldség',400,450,50,4),
	(9,'Kifli',2,(select beszallito_megnevezes from beszallitok where beszallito_id = 2),'pékáru',10,30,20,1),
	(10,'Hagyma',4,(select beszallito_megnevezes from beszallitok where beszallito_id = 4),'zöldség',800,1250,450,1),
	(11,'Alma',5,(select beszallito_megnevezes from beszallitok where beszallito_id = 5),'gyümölcs',200,350,150,2),
	(12,'Szőlő',5,(select beszallito_megnevezes from beszallitok where beszallito_id = 5),'gyümölcs',120,150,30,2),
	(13,'Sajt normál',1,(select beszallito_megnevezes from beszallitok where beszallito_id = 1),'tejtermék',220,350,130,1),
	(14,'Sajt laktózmentes',1,(select beszallito_megnevezes from beszallitok where beszallito_id = 1),'tejtermék',220,450,230,1),
	(15,'"Mindent az SQL-ről" - Újság',6,(select beszallito_megnevezes from beszallitok where beszallito_id = 6),'egyéb',1100,1550,450,null),
	(16,'Szalámi',7,(select beszallito_megnevezes from beszallitok where beszallito_id = 7),'hús',420,450,30,1),
	(17,'Sonka',7,(select beszallito_megnevezes from beszallitok where beszallito_id = 7),'hús',190,250,60,1),
	(18,'Párizsi szelet',7,(select beszallito_megnevezes from beszallitok where beszallito_id = 7),'hús',600,750,150,1),
	(19,'Lapocka',7,(select beszallito_megnevezes from beszallitok where beszallito_id = 7),'hús',1200,1500,300,3),
	(20,'Kenőmájas',7,(select beszallito_megnevezes from beszallitok where beszallito_id = 7),'hús',90,350,260,2),
	(21,'Kakaóscsiga',2,(select beszallito_megnevezes from beszallitok where beszallito_id = 2),'pékáru',200,300,100,1),
	(22,'Pizzás csiga',2,(select beszallito_megnevezes from beszallitok where beszallito_id = 2),'pékáru',200,300,100,1),
	(23,'Kuglóf',2,(select beszallito_megnevezes from beszallitok where beszallito_id = 2),'pékáru',360,450,90,2),
	(24,'"Java titánok" - Újság',6,(select beszallito_megnevezes from beszallitok where beszallito_id = 6),'egyéb',2000,2350,350,null),
	(25,'"Pletykamánia" - Újság',6,(select beszallito_megnevezes from beszallitok where beszallito_id = 6),'egyéb',1000,1150,150,null)
;

insert into beszallitok values
	(1,'Tejtermelő Bocik Kft.','Ny-Magyarország',1111,'Szombathely','Nincstelen u. 12'),
	(2,'Kovászmester Bt.','K-Magyarország',1122,'Debrecen','Végtelen u. 67'),
	(3,'Paradicsom Király Zrt.','Ny-Magyarország',2211,'Sopron','Nincsneve u. 121'),
	(4,'Tóth Jákob EV','D-Magyarország',3300,'Szeged','Árvíz u. 98'),
	(5,'Édenkert Gyümölcsei Kft.','É-Magyarország',6789,'Mátra','Erőmű u. 1'),
	(6,'Magyar Napilap nyomda Zrt.','Ny-Magyarország',1111,'Szombathely','Sas u. 5'),
	(7,'Hentes & Hentes Bt.','É-Magyarország',9999,'Miskolc','Csibész u. 57')
;

insert into dolgozok values
	(1,'Farkas Piroska',72,(select varos from boltok where bolt_id = 1),120000,180000,'2002-02-10','--',(select biztosito_id from biztosito where biztosito_id  = 2),(select bolt_id from boltok where varos = 'Budapest')),
	(2,'Hagy Matilda',71,(select varos from boltok where bolt_id = 1),240000,360000,'2012-05-11','5%',(select biztosito_id from biztosito where biztosito_id  = 2),(select bolt_id from boltok where varos = 'Budapest')),
	(3,'Heggeszt Elek',69,(select varos from boltok where bolt_id = 2),120000,180000,'2022-03-20','--',(select biztosito_id from biztosito where biztosito_id  = 2),(select bolt_id from boltok where varos = 'Békéscsaba')),
	(4,'Makovicsisztó Lajos',72,(select varos from boltok where bolt_id = 1),300000,400000,'2019-12-30','15%',(select biztosito_id from biztosito where biztosito_id  = 2),(select bolt_id from boltok where varos = 'Budapest')),
	(5,'Gélla Károly',67,(select varos from boltok where bolt_id = 2),120000,180000,'2022-07-27','--',(select biztosito_id from biztosito where biztosito_id  = 2),(select bolt_id from boltok where varos = 'Békéscsaba')),
	(6,'Pipacs Jenő',70,(select varos from boltok where bolt_id = 1),180000,240000,'2015-12-10','--',(select biztosito_id from biztosito where biztosito_id  = 2),(select bolt_id from boltok where varos = 'Budapest')),
	(7,'Tut Imre',79,(select varos from boltok where bolt_id = 2),1200000,1800000,'2000-01-01','50%',(select biztosito_id from biztosito where biztosito_id  = 2),(select bolt_id from boltok where varos = 'Békéscsaba')),
	(8,'Vas Pál',66,(select varos from boltok where bolt_id = 2),190000,250000,'2008-11-09','5%',(select biztosito_id from biztosito where biztosito_id  = 2),(select bolt_id from boltok where varos = 'Békéscsaba')),
	(9,'Fá Zoltán',88,(select varos from boltok where bolt_id = 1),90000,140000,'2023-01-10','50%',(select biztosito_id from biztosito where biztosito_id  = 2),(select bolt_id from boltok where varos = 'Budapest')),
	(10,'Boro Mirjam',18,(select varos from boltok where bolt_id = 2),290000,400000,'2022-05-19','--',(select biztosito_id from biztosito where biztosito_id  = 2),(select bolt_id from boltok where varos = 'Békéscsaba'))
;


insert into biztosito values
	(1,'Telelóvé Ingatlanbiztosítási Zrt.','Budapest','Gazdagság u. 1','Ingatlan','2000-01-03','2030-01-03',40),
	(2,'Aranyélet Személy-és vagyonbiztosítási Zrt.','Budapest','Fényűzés u. 2','Személy','2000-01-03','2030-01-03',10)
;	

insert into boltok values
	(1,'Budapest','Régi u. 45',2),
	(2,'Békéscsaba','Új u. 54',2)
;

insert into selejt values
	(1,'2023-01-01',
	(select count(*) from termekek where termek_tipus = 'zöldség' and szavatossagi_ido_honap > 2),
	(select count(*) from termekek where termek_tipus = 'tejtermék' and szavatossagi_ido_honap > 1),
	(select count(*) from termekek where termek_tipus = 'pékáru' and szavatossagi_ido_honap > 1),
	(select count(*) from termekek where termek_tipus = 'gyümölcs' and szavatossagi_ido_honap > 2),
	(select count(*) from termekek where termek_tipus = 'hús' and szavatossagi_ido_honap > 3)),
	(2,'2023-01-02',
	(select count(*) from termekek where termek_tipus = 'zöldség' and szavatossagi_ido_honap > 2),
	(select count(*) from termekek where termek_tipus = 'tejtermék' and szavatossagi_ido_honap > 1),
	(select count(*) from termekek where termek_tipus = 'pékáru' and szavatossagi_ido_honap > 1),
	(select count(*) from termekek where termek_tipus = 'gyümölcs' and szavatossagi_ido_honap > 2),
	(select count(*) from termekek where termek_tipus = 'hús' and szavatossagi_ido_honap > 3))
;

insert into fenntartasi_koltsegek values
	(1,'Munkabér','havi','személyügyi költség',(select sum(brutto_ber)from dolgozok)),
	(2,'Áram','negyedéves','rezsi költség',750000),
	(3,'Gáz','negyedéves','rezsi költség',575000),
	(4,'Víz','féléves','rezsi költség',1129000),
	(5,'Adatbázis üzemeltetés','éves','informatikai költség',3490000),
	(6,'Bérleti díj','ingatlan költség','havi',149000),
	(7,'Ingatlan biztosítás','biztosítási költség','havi',90000),
	(8,'Személy-és vagyonbiztosítás','biztosítási költség','havi',215000)
;

insert into ertekesites  values
	(1,'2023-01-02','08:01:10',1,25420),
	(2,'2023-01-02','08:03:10',1,7810),
	(3,'2023-01-02','08:07:10',1,1230),
	(4,'2023-01-02','08:15:10',1,9870),
	(5,'2023-01-02','08:37:10',1,11230),
	(6,'2023-01-02','08:49:10',1,12560),
	(7,'2023-01-02','09:11:10',1,20920),
	(8,'2023-01-02','09:14:10',1,56700),
	(9,'2023-01-02','09:21:10',1,7700),
	(10,'2023-01-02','09:31:10',1,9900),
	(11,'2023-01-02','09:32:10',1,1100),
	(12,'2023-01-02','10:19:10',1,2200),
	(13,'2023-01-02','10:21:10',1,3330),
	(14,'2023-01-02','10:22:10',1,4400),
	(15,'2023-01-02','10:30:10',1,9830),
	(16,'2023-01-02','10:58:10',1,33650),
	(17,'2023-01-02','11:01:10',1,47650),
	(18,'2023-01-02','11:03:10',1,320),
	(19,'2023-01-02','11:04:10',1,4000),
	(20,'2023-01-02','11:06:10',1,580),
	(21,'2023-01-02','11:18:10',1,900),
	(22,'2023-01-02','11:30:10',1,760),
	(23,'2023-01-02','11:32:10',1,9990),
	(24,'2023-01-02','11:40:10',1,7650),
	(25,'2023-01-02','11:55:10',1,89320),
	(26,'2023-01-02','13:01:10',1,8800),
	(27,'2023-01-02','13:10:10',1,4500),
	(28,'2023-01-02','13:21:10',1,1200),
	(29,'2023-01-02','13:30:10',1,1290),
	(30,'2023-01-02','13:31:10',1,1280),
	(31,'2023-01-02','13:41:10',1,9740),
	(32,'2023-01-02','13:51:10',1,7690),
	(33,'2023-01-02','13:56:10',1,4970),
	(34,'2023-01-02','13:59:10',1,26900),
	(35,'2023-01-02','14:01:10',1,4970),
	(36,'2023-01-02','14:11:10',1,3560),
	(37,'2023-01-02','14:13:10',1,890),
	(38,'2023-01-02','14:36:10',1,120),
	(39,'2023-01-02','14:56:10',1,300),
	(40,'2023-01-02','15:01:10',1,3000),
	(41,'2023-01-02','15:03:10',1,4000),
	(42,'2023-01-02','15:21:10',1,5000),
	(43,'2023-01-02','15:23:10',1,7100),
	(44,'2023-01-02','15:33:10',1,9120),
	(45,'2023-01-02','15:43:10',1,2150),
	(46,'2023-01-02','15:59:10',1,22340)
;

insert into kiadas values
	(1,'2023-01-02',(select beszallito_megnevezes from beszallitok where beszallito_megnevezes = 'Tejtermelő Bocik Kft.'),134520),
	(2,'2023-01-02',(select beszallito_megnevezes from beszallitok where beszallito_megnevezes = 'Kovászmester Bt.'),80950),
	(3,'2023-01-02',(select beszallito_megnevezes from beszallitok where beszallito_megnevezes = 'Paradicsom Király Zrt.'),25000),
	(4,'2023-01-02',(select beszallito_megnevezes from beszallitok where beszallito_megnevezes = 'Tóth Jákob EV'),115000),
	(5,'2023-01-02',(select beszallito_megnevezes from beszallitok where beszallito_megnevezes = 'Édenkert Gyümölcsei Kft.'),75890),
	(6,'2023-01-02',(select beszallito_megnevezes from beszallitok where beszallito_megnevezes = 'Magyar Napilap nyomda Zrt.'),19500),
	(7,'2023-01-02',(select beszallito_megnevezes from beszallitok where beszallito_megnevezes = 'Hentes & Hentes Bt.'),136780)
;
/*delete from forgalom ;*/
insert into forgalom values
	(1,'2023-01-02',
	(select sum (bevetel)from ertekesites where ertekesitesi_datum = '2023-01-02'),
	(select sum (kiadas)from kiadas where kiadas_datum = '2023-01-02'),
	(select napi_bevetel - napi_kiadas from forgalom where datum = '2023-01-02')) 
;

update forgalom set summa_forgalom = (select napi_bevetel - napi_kiadas from forgalom where datum = '2023-01-02');

create table masterdata (
	masterdata_id serial primary key,
	termek_id int,
	beszallito_id int,
	selejt_id int
);

alter table masterdata 
add constraint FK_masterdata_termekek
foreign key (termek_id) 
references termekek (termek_id) 
on update set null on delete set null;

alter table masterdata 
add constraint FK_masterdata_beszallitok
foreign key (beszallito_id) 
references beszallitok (beszallito_id) 
on update set null on delete set null;

alter table masterdata 
add constraint FK_masterdata_selejt
foreign key (selejt_id) 
references selejt (selejt_id) 
on update set null on delete set null;

create table financial (
	financial_id serial primary key,
	kiadas_id int,
	forgalom_id int,
	ertekesites_id int,
	koltseg_id int
);

alter table financial 
add constraint FK_financial_kiadas
foreign key (kiadas_id) 
references kiadas (kiadas_id) 
on update set null on delete set null;

alter table financial 
add constraint FK_financial_forgalom
foreign key (forgalom_id) 
references forgalom (forgalom_id) 
on update set null on delete set null;

alter table financial 
add constraint FK_financial_ertekesites
foreign key (ertekesites_id) 
references ertekesites (ertekesites_id) 
on update set null on delete set null;

alter table financial 
add constraint FK_financial_fenntartasi_koltsegek
foreign key (koltseg_id) 
references fenntartasi_koltsegek (koltseg_id) 
on update set null on delete set null;

create table other_costs (
	other_costs_id serial primary key,
	dolgozo_id int,
	bolt_id int,
	biztosito_id int
);

alter table other_costs 
add constraint FK_other_costs_dolgozo
foreign key (dolgozo_id) 
references dolgozok (dolgozo_id) 
on update set null on delete set null;

alter table other_costs 
add constraint FK_other_costs_biztosito
foreign key (biztosito_id) 
references biztosito (biztosito_id) 
on update set null on delete set null;

alter table other_costs 
add constraint FK_other_costs_boltok
foreign key (bolt_id) 
references boltok (bolt_id) 
on update set null on delete set null;

















