set search_path = ingatlan;
--reate schema ingatlan;
--create table ingatlan (
--hrsz text primary key
--);

create table regio (
	regio_id serial primary key,
	regio_nev text 
);

create table seller (
	seller_id serial primary key,
	nev text
);

create table ingatlan (
	ingatlan_id serial primary key,
	hrsz text,
	varos text,
	utca text,
	alap_terulet int,
	iranyar int,
	regio_id int,
	seller_id int
);

create table viewer (
	id serial primary key,
	nev text,
	ajanlati_ar int,
	ingatlan_id int,
	seller_id int
);

alter table ingatlan add constraint FK_ingatlan_regio foreign key (regio_id) references regio(regio_id) on update set null on delete set null;
alter table ingatlan add constraint FK_ingatlan_seller foreign key (seller_id) references seller(seller_id) on update set null on delete set null;
--alter table seller add constraint FK_seller_adatok foreign key(ing_id) references adatok(id) on update set null on delete set null;

alter table viewer add constraint FK_viewer_ingatlan foreign key (ingatlan_id) references ingatlan(ingatlan_id) on update set null on delete set null;

insert into regio (regio_nev) values ('Baranya') , ('Észak');
insert into seller (nev) values ('Nagy József'), ('Kis Piroska'),('Szabó Géza');

insert into ingatlan (hrsz,varos,regio_id,seller_id) values ('1234/2','Pécs',(select regio_id from regio where regio_nev='Baranya'),(select seller_id from seller where nev='Kis Piroska') );
select * from ingatlan;

--alter table seller add constraint FK_seller_regio foreign key (regio) references regio(nev) on update set null on delete set null;
--alter table regio add constraint FK_regio_seller foreign key (seller_nev) references seller(nev) on update set null on delete set null;
--alter table seller add constraint FK_seller_adatok foreign key(ing_id) references adatok(id) on update set null on delete set null;



alter table viewer add constraint FK_viewer_adatok foreign key (ing_id) references adatok(id) on update set null on delete set null;

insert into ingatlan values ('123'),('230/A/1'),('435/0/B/2'),('5235'),('03134'),('3453/B/2'),
('345/7/3'),('5257/0/A/5'),('342432'),('334'),('643/7'),('546'),('625/87'),('03454'),('543'),('3452');

insert into adatok values (1,'123','Szeged','Kárász utca',120,45000000),(2,'230/A/1','Budapest','Attila út',45,60000000),
(3,'435/0/B/2','Győr','Fő tér',34,32000000),(4,'5235','Békéscsaba','Jamina',4321,21000000),
(5,'03134','Kaposvár','külterület',34000,12000000),(6,'3453/B/2','Pécs','Kossuth utca',23,11000000),
(7,'345/7/3','Cegléd','Vörösmarty utca',230,9000000),(8,'5257/0/A/5','Sopron','Ady Endre utca',76,70000000),
(9,'342432','Baja','Árpád utca',6000,40000000),(10,'334','Zalaegerszeg','Dísz tér',56,45000000),
(11,'643/7','Miskolc','Pereces',45,9900000),(12,'546','Orosháza','Kisködmön utca',34,27000000),
(13,'625/87','Sárospatak','Bem utca',230,60000000),(14,'03454','Nyíregyháza','külterület',65743,23000000),
(15,'543','Dombóvár','Lajos utca',65,32000000),(16,'3452','Szombathely','Göncöl utca',76,56000000);

insert into seller values (1,'Zöld Imre'),(2,'Nagy János'),(3,'Kukta Lajos'),
(4,'Hrutka László'),(5,'Kis Tamás'),(6,'Ördög Péter'),(7,'Zöld Imre'),(8,'Kukta Lajos'),
(9,'Kis Tamás'),(10,'Ördög Péter'),(11,'Kis Tamás'),(12,'Ördög Péter'),(13,'Nagy János'),
(14,'Kukta Lajos'),(15,'Ördög Péter'),(16,null);

insert into viewer values 
('Molnár Árpád',44000000,1),
('Grün Alfonz',24000000,14),
('Magyar Oszkár',42000000,10),
('Pesi Károly',56000000,2);
