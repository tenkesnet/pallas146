create schema if not exists retail;
set search_path = retail;

create table bolt(
	bolt_id serial primary key,
	bolt_nev text,
	bevetel int,
	raktar_id int,
	dolgozok_szama_bolt int,
	cim text
);
--drop table if exists raktar;
create table raktar(
	raktar_id serial primary key,
	raktar_nev text,
	dolgozok_szama_raktar int,
	cim text,
	kozpont_id int
);

create table beszallito(
	beszallito_id serial primary key,
	beszallito_nev text,
	termek text,
	koltseg int,
	cim text,
	kozpont_id int
);
--drop table if exists kozpont;
create table kozpont(
	kozpont_id serial primary key,
	kozpont_nev text,
	bevetel int,
	kiadas int,
	dolgozok_szama_kozpont int,
	cim text
);

alter table bolt  
add constraint FK_bolt_raktar 
foreign key (raktar_id) 
references raktar(raktar_id) 
on update set null on delete set null;


alter table beszallito 
add constraint FK_beszallito_kozpont 
foreign key (kozpont_id) 
references kozpont(kozpont_id) 
on update set null on delete set null;

alter table raktar 
add constraint FK_raktar_kozpont 
foreign key (kozpont_id) 
references kozpont(kozpont_id) 
on update set null on delete set null;



insert into kozpont (kozpont_nev,bevetel,kiadas,dolgozok_szama_kozpont,cim) values 
	('Siklósi Központ',null,null,82,'Siklós,Kereskedelem utca 1')
;

insert into raktar (raktar_id,raktar_nev,dolgozok_szama_raktar,cim, kozpont_id) values 
	(1,'Keszthelyi Logisztikai Központ',125,'Keszthely,Targoncások útja 1',1),
	(2,'Zalaegerszegi Logisztikai Központ',119,'Zalaegerszeg,Pakoló inasok utca 1',1)
;

insert into bolt (bolt_nev,bevetel,raktar_id,dolgozok_szama_bolt,cim) values 
	('001',5300000,1,15,'Budapest,Nevenincs utca 1'),
	('002',7460000,1,17,'Budapest,Seholsincs út 11'),
	('003',700000,2,9,'Békéscsaba,Valaholvan utca 71'),
	('004',11300000,2,19,'Szeged,Gazdag utca 82'),
	('005',30000,2,4,'Pécs,Szegény köz 2')
;

insert into beszallito (beszallito_nev,termek,koltseg,cim,kozpont_id) values 
	('Tuti Malac Kft.','hús',2250000,'Kecskemét, Hízlalda út 19',1),
	('Everyday Newspaper Inc.','újság',112000,'London, Paper street 59',1),
	('Ivászatgyár Bt.','ital',7531000,'Miskolc, Teletank utca 28',1),
	('Vitamindús Kft.','gyümölcs',311000,'Kecskemét, Kertekalatt út 69',1),
	('Harapnijó 2024 Kft.','zöldség',5550000,'Kecskemét, Kertekalatt út 67',1),
	('Tutikovács Bt.','szerszám',15000,'Sopron, Öntöde köz 167',1)
;

update kozpont set bevetel = (select sum(bevetel) from bolt), kiadas = (select sum(koltseg) from beszallito);







