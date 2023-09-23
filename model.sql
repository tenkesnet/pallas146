drop table if exists AUTO_CSOP CASCADE ; 
drop table if exists TIPUSOK CASCADE ; 
drop table if exists AUTOK CASCADE ;
drop table if exists RENDELES CASCADE ;
drop table if exists UGYFELEK CASCADE ;
drop table if exists RESZLEG CASCADE ; 
drop table if exists ALKALMAZOTT CASCADE ;


/**************************
AUTO_CSOP tábla létrehozása
**************************/


--

create table AUTO_CSOP(
    id serial primary key,
    auto_csop_nev varchar(6) not null,
    km_dij int4,
    napi_dij int8
);

/**************************
AUTO_CSOP tábla feltöltése
**************************/
insert into AUTO_CSOP (auto_csop_nev, km_dij, napi_dij) values ('NORMAL','80','5000');
insert into AUTO_CSOP (auto_csop_nev, km_dij, napi_dij) values ('EXTRA','120','7500');
insert into AUTO_CSOP (auto_csop_nev, km_dij, napi_dij) values ('LUXUS','300','15000');
/*************************/
/*************************/

/**************************
TIPUSOK tábla létrehozása
**************************/

--
create table TIPUSOK(
    id serial primary key,
    tipus_nev varchar(15) not null,
    auto_csop_id serial not null references auto_csop(id),
    leiras varchar(30),
    szerviz_km int8
);
/**************************
TIPUSOK tábla feltöltése
**************************/
insert into TIPUSOK (tipus_nev,auto_csop_id,leiras,szerviz_km) 
values ('FORD ESCORT',(select id from auto_csop where auto_csop_nev='EXTRA'),'CL 1.8 DSL 5-A','15000');
insert into TIPUSOK (tipus_nev,auto_csop_id,leiras,szerviz_km) 
values ('RENAULT 19',(select id from auto_csop where auto_csop_nev='EXTRA'),'RL 1.4 L KAT 3-A','5000');
insert into TIPUSOK (tipus_nev,auto_csop_id,leiras,szerviz_km) 
values ('RENAULT NEVADA',(select id from auto_csop where auto_csop_nev='EXTRA'),'RTD 2.1 L KAT 5-','75000');
insert into TIPUSOK (tipus_nev,auto_csop_id,leiras,szerviz_km) 
values ('RENAULT LAGUNA',(select id from auto_csop where auto_csop_nev='EXTRA'),'RT 2.0 L KAT 5-A','15000');
insert into TIPUSOK (tipus_nev,auto_csop_id,leiras,szerviz_km) 
values ('SKODA LX',(select id from auto_csop where auto_csop_nev='NORMAL'),'FAVORIT 1.3 L KAT','5000');
insert into TIPUSOK (tipus_nev,auto_csop_id,leiras,szerviz_km) 
values ('SKODA CL',(select id from auto_csop where auto_csop_nev='NORMAL'),'FAVORIT 1.3 L KAT COMFORT LINE','5000');
insert into TIPUSOK (tipus_nev,auto_csop_id,leiras,szerviz_km) 
values ('OPEL ASTRA',(select id from auto_csop where auto_csop_nev='EXTRA'),'CL 1.6 I 5-A','10000');
insert into TIPUSOK (tipus_nev,auto_csop_id,leiras,szerviz_km) 
values ('OPEL VECTRA',(select id from auto_csop where auto_csop_nev='LUXUS'),'TURBO 2.0 I 4-A','10000');
insert into TIPUSOK (tipus_nev,auto_csop_id,leiras,szerviz_km) 
values ('W VENTO CL',(select id from auto_csop where auto_csop_nev='EXTRA'),'TD 1.9 L KAT','15000');
insert into TIPUSOK (tipus_nev,auto_csop_id,leiras,szerviz_km) 
values ('OPEL CORSA',(select id from auto_csop where auto_csop_nev='NORMAL'),'CITY 1.2 I 3-A','10000');
insert into TIPUSOK (tipus_nev,auto_csop_id,leiras,szerviz_km) 
values ('RENAULT TWINGO',(select id from auto_csop where auto_csop_nev='EXTRA'),'1.2 L KAT 3-A','75000');
insert into TIPUSOK (tipus_nev,auto_csop_id,leiras,szerviz_km) 
values ('RENAULT ESPACE',(select id from auto_csop where auto_csop_nev='LUXUS'),'RN DT 2.1 L KAT','15000');
/*************************/
/*************************/

/**************************
RESZLEG tábla létrehozása
**************************/

--
create table RESZLEG(
    id serial primary key,
    reszleg_kod int8 not null,
    reszleg_nev varchar(20),
    reszleg_cim varchar(15)
);
/**************************
RESZLEG tábla feltöltése
**************************/
insert into RESZLEG (reszleg_kod,reszleg_nev,reszleg_cim) values ('10','KOZPONT','BUDAPEST');
insert into RESZLEG (reszleg_kod,reszleg_nev,reszleg_cim) values ('20','AUTO-RENAULT','BUDAPEST');
insert into RESZLEG (reszleg_kod,reszleg_nev,reszleg_cim) values ('30','AUTO','GYOR');
insert into RESZLEG (reszleg_kod,reszleg_nev,reszleg_cim) values ('50','LUXUS-AUTO','BUDAPEST');
insert into RESZLEG (reszleg_kod,reszleg_nev,reszleg_cim) values ('60','AUTO','DEBRECEN');
insert into RESZLEG (reszleg_kod,reszleg_nev,reszleg_cim) values ('70','TEHERAUTO','BUDAPEST');
/*************************/
/*************************/

/**************************
ALKALMAZOTT tábla létrehozása
**************************/

--
create table ALKALMAZOTT(
    id serial primary key,
    alk_kod int8 not null,
    alk_nev varchar(20),
    beosztas varchar(16),
    belepes date,
    fizetes int8,
    premium int8,
    reszleg_id serial not null references reszleg(id)
);
/**************************
ALKALMAZOTT tábla feltöltése
**************************/
insert into ALKALMAZOTT (alk_kod,alk_nev,beosztas,belepes,fizetes,premium,reszleg_id)
values ('1234','KOVACS','ELADO','19921210',13000,4000,(select id from reszleg where reszleg_kod='20'));
insert into ALKALMAZOTT (alk_kod,alk_nev,beosztas,belepes,fizetes,premium,reszleg_id)
values ('1235','MOLNAR','SZERELO','19921218',18000, NULL,(select id from reszleg where reszleg_kod='30'));
insert into ALKALMAZOTT (alk_kod,alk_nev,beosztas,belepes,fizetes,premium,reszleg_id)
values ('1236','CSIKOS','ELADO','19930312',13250,5000,(select id from reszleg where reszleg_kod='30'));
insert into ALKALMAZOTT (alk_kod,alk_nev,beosztas,belepes,fizetes,premium,reszleg_id)
values ('1237','TOTH','VIZSGABIZTOS','19930422',20000, NULL,(select id from reszleg where reszleg_kod='20'));
insert into ALKALMAZOTT (alk_kod,alk_nev,beosztas,belepes,fizetes,premium,reszleg_id)
values ('1238','NEMETH','TELEPHELYVEZETO','19931128',29000,14000,(select id from reszleg where reszleg_kod='30'));
insert into ALKALMAZOTT (alk_kod,alk_nev,beosztas,belepes,fizetes,premium,reszleg_id)
values ('1239','SZABO','IGAZGATO','19920501',54000,75000,(select id from reszleg where reszleg_kod='10'));
insert into ALKALMAZOTT (alk_kod,alk_nev,beosztas,belepes,fizetes,premium,reszleg_id)
values ('1240','BALOGH','SZERELO','19920602',22000,5000,(select id from reszleg where reszleg_kod='50'));
insert into ALKALMAZOTT (alk_kod,alk_nev,beosztas,belepes,fizetes,premium,reszleg_id)
values ('1241','TRENCSENI','ELADO','19930620',12100,7200,(select id from reszleg where reszleg_kod='60'));
insert into ALKALMAZOTT (alk_kod,alk_nev,beosztas,belepes,fizetes,premium,reszleg_id)
values ('1244','KIRALY','VIZSGABIZTOS','19930804',21000,8000,(select id from reszleg where reszleg_kod='20'));
insert into ALKALMAZOTT (alk_kod,alk_nev,beosztas,belepes,fizetes,premium,reszleg_id)
values ('1245','HERCEG','ELADO','19931112',11000,6000,(select id from reszleg where reszleg_kod='20'));
insert into ALKALMAZOTT (alk_kod,alk_nev,beosztas,belepes,fizetes,premium,reszleg_id)
values ('1246','BOGNAR','ELADO','19921008',13000,6000,(select id from reszleg where reszleg_kod='50'));
insert into ALKALMAZOTT (alk_kod,alk_nev,beosztas,belepes,fizetes,premium,reszleg_id)
values ('1247','HALASZ','SZERELO','19930523',21000,7000,(select id from reszleg where reszleg_kod='60'));
insert into ALKALMAZOTT (alk_kod,alk_nev,beosztas,belepes,fizetes,premium,reszleg_id)
values ('1248','HORVAT','TELEPHELYVEZETO','19931209',25000,12000,(select id from reszleg where reszleg_kod='60'));
insert into ALKALMAZOTT (alk_kod,alk_nev,beosztas,belepes,fizetes,premium,reszleg_id)
values ('1249','KISS','ELADO','19931223',12500, 9500,(select id from reszleg where reszleg_kod='20'));
/*************************/
/*************************/

/**************************
UGYFELEK tábla létrehozása
**************************/

--
create table UGYFELEK(
    id serial primary key,
    ugyfel_szam varchar(3) not null,
    ugyfel_nev varchar(20),
    cim varchar(15),
    varos varchar(10),
    orszag varchar(10),
    iranyito_szam varchar(6),
    megbizott varchar(15),
    fizetesi_mod varchar(1)
);
/**************************
UGYFELEK tábla feltöltése
**************************/
insert into UGYFELEK (ugyfel_szam, ugyfel_nev,cim,varos,orszag,iranyito_szam,megbizott,fizetesi_mod)
values ('342','MOLNÁR PETER','HILTON PRK. 1.','NEW YORK','USA','49928','HILTON','K');
insert into UGYFELEK (ugyfel_szam, ugyfel_nev,cim,varos,orszag,iranyito_szam,megbizott,fizetesi_mod)
values ('343','PAPP ROBERT','PIAC U. 10.','DEBRECEN','MAGYAR','4027','PINTER ATTILA','K');
insert into UGYFELEK (ugyfel_szam, ugyfel_nev,cim,varos,orszag,iranyito_szam,megbizott,fizetesi_mod)
values ('344','ABEL ANETT','WIESZ STR 5','BECS','AUSZTRIA','20800','HILTON','K');
insert into UGYFELEK (ugyfel_szam, ugyfel_nev,cim,varos,orszag,iranyito_szam,megbizott,fizetesi_mod)
values ('345','TIBOR SMITH','LIGNOUN 15.','PARIZS','FRANCIA','140010','HOTEL CIVIS','A');
insert into UGYFELEK (ugyfel_szam, ugyfel_nev,cim,varos,orszag,iranyito_szam,megbizott,fizetesi_mod)
values ('346','PAPP AGNES','VEZER U. 19.','DEBRECEN','MAGYAR','4032',NULL,'A');
insert into UGYFELEK (ugyfel_szam, ugyfel_nev,cim,varos,orszag,iranyito_szam,megbizott,fizetesi_mod)
values ('347','BIRO KATALIN','TESSEDIK U. 6.','DEBRECEN','MAGYAR','4032',NULL,'A');
insert into UGYFELEK (ugyfel_szam, ugyfel_nev,cim,varos,orszag,iranyito_szam,megbizott,fizetesi_mod)
values ('348','KISS VIKTÓRIA','FO U. 8.','BUDAPEST','MAGYAR','1221','NAGY TIBORNE','K');
insert into UGYFELEK (ugyfel_szam, ugyfel_nev,cim,varos,orszag,iranyito_szam,megbizott,fizetesi_mod)
values ('349','LIGETI ZOLTAN','KIRALY U. 88.','BUDAPEST','MAGYAR','1239',NULL,'A');
insert into UGYFELEK (ugyfel_szam, ugyfel_nev,cim,varos,orszag,iranyito_szam,megbizott,fizetesi_mod)
values ('350','TOTH KAROLYNE','DOMB U. 6.','BUDAPEST','MAGYAR','1260',NULL,'A');
/*************************/
/*************************/

/**************************
AUTOK tábla létrehozása
**************************/

--
create table AUTOK(
    id serial primary key,
    rendszam varchar(7) not null,
    tipusok_id serial not null references tipusok(id),
    auto_csop_id serial not null references auto_csop(id),
    vasarlas_datuma date,
    ar float8,
    futott_km int8,
    ut_szerviz int8,
    allapot varchar(1),
    reszleg_id serial not null references reszleg(id),
    alkalmazott_id serial not null references alkalmazott(id)
);
/**************************
AUTOK tábla feltöltése
**************************/
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('ABR-047',(select id from tipusok where tipus_nev='FORD ESCORT'),(select id from auto_csop where auto_csop_nev='EXTRA'),'19930102','1300000','151003','141410','F',(select id from reszleg where reszleg_kod=30),(select id from alkalmazott where alk_kod=1236));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('ABR-115',(select id from tipusok where tipus_nev='RENAULT 19'),(select id from auto_csop where auto_csop_nev='EXTRA'),'19930102','1200000','145097','139600','X',(select id from reszleg where reszleg_kod=20),(select id from alkalmazott where alk_kod=1234));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('CDE-324',(select id from tipusok where tipus_nev='RENAULT NEVADA'),(select id from auto_csop where auto_csop_nev='EXTRA'),'19930601','2473000','42040','15901','F',(select id from reszleg where reszleg_kod=20),(select id from alkalmazott where alk_kod=1234));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('DHV-123',(select id from tipusok where tipus_nev='RENAULT LAGUNA'),(select id from auto_csop where auto_csop_nev='EXTRA'),'19930605','2346000','73621','53600','A',(select id from reszleg where reszleg_kod=20),(select id from alkalmazott where alk_kod=1245));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('PHD-100',(select id from tipusok where tipus_nev='RENAULT 19'),(select id from auto_csop where auto_csop_nev='EXTRA'),'19930630','1329000','151441','140507','X',(select id from reszleg where reszleg_kod=20),(select id from alkalmazott where alk_kod=1249));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('PHD-610',(select id from tipusok where tipus_nev='RENAULT NEVADA'),(select id from auto_csop where auto_csop_nev='EXTRA'),'19930720','2473000','39066','30009','F',(select id from reszleg where reszleg_kod=20),(select id from alkalmazott where alk_kod=1249));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('ABC-021',(select id from tipusok where tipus_nev='SKODA LX'),(select id from auto_csop where auto_csop_nev='NORMAL'),'19931001','827000','123212','120509','F',(select id from reszleg where reszleg_kod=30),(select id from alkalmazott where alk_kod=1236));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('ABC-022',(select id from tipusok where tipus_nev='SKODA CL'),(select id from auto_csop where auto_csop_nev='NORMAL'),'19931001','917000','97081','95310','S',(select id from reszleg where reszleg_kod=30),(select id from alkalmazott where alk_kod=1236));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('ABC-123',(select id from tipusok where tipus_nev='OPEL ASTRA'),(select id from auto_csop where auto_csop_nev='EXTRA'),'19931111','1239000','101978','93710','A',(select id from reszleg where reszleg_kod=30),(select id from alkalmazott where alk_kod=1236));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('BAH-115',(select id from tipusok where tipus_nev='OPEL VECTRA'),(select id from auto_csop where auto_csop_nev='LUXUS'),'19931011','3977000','51007','49620','A',(select id from reszleg where reszleg_kod=50),(select id from alkalmazott where alk_kod=1246));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('CIC-312',(select id from tipusok where tipus_nev='W VENTO CL'),(select id from auto_csop where auto_csop_nev='EXTRA'),'19931201','1650000','100021','83701','F',(select id from reszleg where reszleg_kod=60),(select id from alkalmazott where alk_kod=1241));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('COD-705',(select id from tipusok where tipus_nev='W VENTO CL'),(select id from auto_csop where auto_csop_nev='EXTRA'),'19931201','1650000','91970','79600','S',(select id from reszleg where reszleg_kod=60),(select id from alkalmazott where alk_kod=1241));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('CBN-301',(select id from tipusok where tipus_nev='OPEL CORSA'),(select id from auto_csop where auto_csop_nev='NORMAL'),'19931201','917000','28001','25444','A',(select id from reszleg where reszleg_kod=60),(select id from alkalmazott where alk_kod=1241));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('CBN-302',(select id from tipusok where tipus_nev='OPEL ASTRA'),(select id from auto_csop where auto_csop_nev='EXTRA'),'19931201','1239000','87111','80001','S',(select id from reszleg where reszleg_kod=60),(select id from alkalmazott where alk_kod=1241));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('CDD-115',(select id from tipusok where tipus_nev='FORD ESCORT'),(select id from auto_csop where auto_csop_nev='EXTRA'),'19940102','1400000','15901','15501','A',(select id from reszleg where reszleg_kod=30),(select id from alkalmazott where alk_kod=1236));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('DCD-324',(select id from tipusok where tipus_nev='RENAULT LAGUNA'),(select id from auto_csop where auto_csop_nev='EXTRA'),'19940102','2346000','41061','28861','A',(select id from reszleg where reszleg_kod=20),(select id from alkalmazott where alk_kod=1245));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('PDP-101',(select id from tipusok where tipus_nev='RENAULT ESPACE'),(select id from auto_csop where auto_csop_nev='LUXUS'),'19940102','3530000','7911',NULL,'S',(select id from reszleg where reszleg_kod=20),(select id from alkalmazott where alk_kod=1249));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('CBN-001',(select id from tipusok where tipus_nev='W VENTO CL'),(select id from auto_csop where auto_csop_nev='EXTRA'),'19940102','1999000','152311','150600','F',(select id from reszleg where reszleg_kod=60),(select id from alkalmazott where alk_kod=1241));
insert into AUTOK (rendszam,tipusok_id,auto_csop_id,vasarlas_datuma,ar,futott_km,ut_szerviz,allapot,reszleg_id,alkalmazott_id)
values ('CDD-115',(select id from tipusok where tipus_nev='RENAULT TWINGO'),(select id from auto_csop where auto_csop_nev='NORMAL'),'19940103','955000','8307',NULL,'S',(select id from reszleg where reszleg_kod=20),(select id from alkalmazott where alk_kod=1234));
/*************************/
/*************************/

/**************************
RENDELES tábla létrehozása
**************************/

create table RENDELES
(
    
id serial primary key,
rendeles_szam varchar(5) not null,
ugyfelek_id serial not null references ugyfelek(id),
rendeles_datum date,
rendelo_szemely varchar(12),
kolcson_kezdete date,
napok int8,
rendszam_id serial not null references autok(id),
--tipus_nev varchar(15),
tipusok_id serial not null references tipusok(id),
km_kezdet int8,
km_veg int8,
kolcson_dij int8,
fizetes varchar(1)
);
/**************************
RENDELES tábla feltöltése
**************************/

insert into RENDELES (rendeles_szam,ugyfelek_id,rendeles_datum,rendelo_szemely,kolcson_kezdete,napok,rendszam_id,tipusok_id,km_kezdet,km_veg,kolcson_dij,fizetes)
values ('12334',(select id from ugyfelek where ugyfel_szam='348'),'19931201','NAGY TIBORNE','19940401','5',(select id from autok where rendszam='ABC-123'),(select id from tipusok where tipus_nev='OPEL ASTRA'),'95308','101978','558600','Y');
insert into RENDELES (rendeles_szam,ugyfelek_id,rendeles_datum,rendelo_szemely,kolcson_kezdete,napok,rendszam_id,tipusok_id,km_kezdet,km_veg,kolcson_dij,fizetes)
values ('12335',(select id from ugyfelek where ugyfel_szam='342'),'19940202','HOTEL CIVIS','19940305','2',(select id from autok where rendszam='ABR-115'),(select id from tipusok where tipus_nev='RENAULT 19'),'144102','145097','134400','Y');
insert into RENDELES (rendeles_szam,ugyfelek_id,rendeles_datum,rendelo_szemely,kolcson_kezdete,napok,rendszam_id,tipusok_id,km_kezdet,km_veg,kolcson_dij,fizetes)
values ('12336',(select id from ugyfelek where ugyfel_szam='342'),'19940202','HOTEL CIVIS','19940202','21',(select id from autok where rendszam='PHD-100'),(select id from tipusok where tipus_nev='RENAULT 19'),'150871','151441','225900','Y');
insert into RENDELES (rendeles_szam,ugyfelek_id,rendeles_datum,rendelo_szemely,kolcson_kezdete,napok,rendszam_id,tipusok_id,km_kezdet,km_veg,kolcson_dij,fizetes)
values ('12337',(select id from ugyfelek where ugyfel_szam='344'),'19940330','HILTON','19940405','30',(select id from autok where rendszam='ABR-047'),(select id from tipusok where tipus_nev='FORD ESCORT'),'141413','151003','1375800','N');
insert into RENDELES (rendeles_szam,ugyfelek_id,rendeles_datum,rendelo_szemely,kolcson_kezdete,napok,rendszam_id,tipusok_id,km_kezdet,km_veg,kolcson_dij,fizetes)
values ('12338',(select id from ugyfelek where ugyfel_szam='343'),'19940330','MATAV IG.','19940405','5',(select id from autok where rendszam='ABC-123'),(select id from tipusok where tipus_nev='OPEL ASTRA'),'101978','104965','395940','N');
insert into RENDELES (rendeles_szam,ugyfelek_id,rendeles_datum,rendelo_szemely,kolcson_kezdete,napok,rendszam_id,tipusok_id,km_kezdet,km_veg,kolcson_dij,fizetes)
values ('12339',(select id from ugyfelek where ugyfel_szam='348'),'19940402','APEH IG.','19940410','1',(select id from autok where rendszam='BAH-115'),(select id from tipusok where tipus_nev='OPEL VECTRA'),'50609','51007','55260','N');
insert into RENDELES (rendeles_szam,ugyfelek_id,rendeles_datum,rendelo_szemely,kolcson_kezdete,napok,rendszam_id,tipusok_id,km_kezdet,km_veg,kolcson_dij,fizetes)
values ('12340',(select id from ugyfelek where ugyfel_szam='345'),'19940203','HOTEL CIVIS','19940501','5',(select id from autok where rendszam='ABR-047'),(select id from tipusok where tipus_nev='FORD ESCORT'),'151003',NULL,NULL,'Y');
insert into RENDELES (rendeles_szam,ugyfelek_id,rendeles_datum,rendelo_szemely,kolcson_kezdete,napok,rendszam_id,tipusok_id,km_kezdet,km_veg,kolcson_dij,fizetes)
values ('12341',(select id from ugyfelek where ugyfel_szam='349'),'19940404','IBUSZ IG.','19940501','10',(select id from autok where rendszam='ABC-123'),(select id from tipusok where tipus_nev='W VENTO CL'),'152311',NULL,NULL,'Y');
insert into RENDELES (rendeles_szam,ugyfelek_id,rendeles_datum,rendelo_szemely,kolcson_kezdete,napok,rendszam_id,tipusok_id,km_kezdet,km_veg,kolcson_dij,fizetes)
values ('12342',(select id from ugyfelek where ugyfel_szam='344'),'19940404','HILTON','19940502','5',(select id from autok where rendszam='PHD-610'),(select id from tipusok where tipus_nev='RENAULT NEVADA'),'39066',NULL,NULL,'Y');
insert into RENDELES (rendeles_szam,ugyfelek_id,rendeles_datum,rendelo_szemely,kolcson_kezdete,napok,rendszam_id,tipusok_id,km_kezdet,km_veg,kolcson_dij,fizetes)
values ('12343',(select id from ugyfelek where ugyfel_szam='348'),'19940504','NAGY TIBORNE','19940410','7',(select id from autok where rendszam='CDE-324'),(select id from tipusok where tipus_nev='RENAULT NEVADA'),'42040',NULL,NULL,'N');
insert into RENDELES (rendeles_szam,ugyfelek_id,rendeles_datum,rendelo_szemely,kolcson_kezdete,napok,rendszam_id,tipusok_id,km_kezdet,km_veg,kolcson_dij,fizetes)
values ('12344',(select id from ugyfelek where ugyfel_szam='343'),'19940420','KOOS TIBOR','19940503','10',(select id from autok where rendszam='ABC-123'),(select id from tipusok where tipus_nev='SKODA LX'),'123212',NULL,NULL,'N');
insert into RENDELES (rendeles_szam,ugyfelek_id,rendeles_datum,rendelo_szemely,kolcson_kezdete,napok,rendszam_id,tipusok_id,km_kezdet,km_veg,kolcson_dij,fizetes)
values ('12345',(select id from ugyfelek where ugyfel_szam='342'),'19940421','HILTON','19940503','3',(select id from autok where rendszam='CIC-312'),(select id from tipusok where tipus_nev='W VENTO CL'),'100021',NULL,NULL,'Y');
