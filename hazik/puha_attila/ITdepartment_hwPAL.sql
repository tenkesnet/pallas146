--drop table if exists
set search_path=igazgatosag;
--CREATE SCHEMA igazgatosag;
drop table munkakor cascade;
create table munkakor (
	munkakor_id bigserial primary key,
	munkakor_nev text,
	munkaido_kezdete time,
	munkaido_vege time,
	support_ido int, --percben van megadva
	morningSupport_ido int, --percet jelent
	onsiteSupport_ido int,
	eveningSupport_ido int
);

drop table if exists dolgozok cascade;
create table dolgozok (
	dolgozo_id bigserial primary key,
	nev text not null,
	munkakor_id bigint,
	belepesi_datum date,	
	felettes_id bigint
);

alter table dolgozok add constraint FK_dolgozok_munkakor foreign key (munkakor_id) references munkakor(munkakor_id) on update set null on delete set null;
alter table dolgozok add constraint FK_dolgozok_dolgozok foreign key (felettes_id) references dolgozok(dolgozo_id) on update set null on delete set null;

insert into munkakor (munkakor_nev,munkaido_kezdete,munkaido_vege,support_ido) values ('IT Igazgato','08:00:00','16:00:00',null);
insert into munkakor (munkakor_nev,munkaido_kezdete,munkaido_vege,support_ido) values ('Infrastructure Management','08:00:00','16:00:00',120);
insert into munkakor (munkakor_nev,munkaido_kezdete,munkaido_vege,support_ido,morningSupport_ido) values ('Service_Support','06:00:00','14:00:00',120,30);
select * from munkakor;


insert into dolgozok (nev,munkakor_id,belepesi_datum,felettes_id) values ('Angelica Schwimmer',1,'1997-01-01',null);
insert into dolgozok (nev,munkakor_id,belepesi_datum,felettes_id) values ('Nagy Tamás',2,'2012-01-01',1);
insert into dolgozok (nev,munkakor_id,belepesi_datum,felettes_id) values ('Kisvirág Tünde',3,'2009-12-01',2);
insert into dolgozok (nev,munkakor_id,belepesi_datum,felettes_id) values ('Horváth Tamás',3,'2011-04-20',2);

create table IT_igazgatosag (
	igazgato_nev text primary key
);

create table Infrastructure_Management (
	osztalyVezeto_nev text primary key,
	szerver_dolgozo_nev text,
	halozati_dolgozo_nev text,
	belepesi_datum date,
	munkaido time,
	support_ido time
);

alter table Infrastructure_Management 
add constraint FK_Infrastructure_Management_IT_igazgatosag 
foreign key (osztalyVezeto_nev) 
references IT_igazgatosag (igazgato_nev) 
on update set null on delete set null;

create table Business_Consulting (
	osztalyVezeto_nev text primary key,
	storeApplications_dolgozo_nev text,
	warehouseApplications_dolgozo_nev text,
	belepesi_datum date,
	munkaido time,
	support_ido time
);

alter table Business_Consulting 
add constraint FK_Business_Consulting_IT_igazgatosag 
foreign key (osztalyVezeto_nev) 
references IT_igazgatosag (igazgato_nev) 
on update set null on delete set null;

create table Service_Support (
	osztalyVezeto_nev text primary key,
	dolgozo_nev text,
	belepesi_datum date,
	munkaido time,
	morningSupport_ido time,
	onsiteSupport_ido time,
	eveningSupport_ido time
);

alter table Service_Support 
add constraint FK_Service_Support_IT_igazgatosag 
foreign key (osztalyVezeto_nev) 
references IT_igazgatosag (igazgato_nev) 
on update set null on delete set null;

insert into IT_igazgatosag values
	('Angelica Schwimmer')
;

insert into Infrastructure_Management values
	('Nagy Tamás','2012-01-01','08:00:00'),
	('Kis Ferenc','2018-03-11','08:00:00'),
	('Molnár Péter','2022-07-30','08:00:00')
;

insert into Business_Consulting values
	('Tóth Jakab','2009-12-01','08:00:00'),
	('Kovács Zsuzsanna','2016-08-21','08:00:00'),
	('Molnár Attila','2022-07-30','08:00:00')
;

insert into Service_Support values
	('Mihályfi Zoltán','Kisvirág Tünde','2009-12-01','08:00:00','05:30:00','14:30:00')
;

