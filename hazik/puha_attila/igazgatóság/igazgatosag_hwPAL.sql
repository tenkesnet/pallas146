set search_path=igazgatosag;
-- CREATE SCHEMA igazgatosag;

drop table if exists munkaido_es_szabadsag cascade;


create table munkakor (
	munkakor_id bigserial primary key,
	munkakor_nev text,
	munkaido_kezdete time,
	munkaido_vege time,
	support_ido int, --percben megadva
	morningSupport_ido int, --percben megadva
	onsiteSupport_ido int, --percben megadva
	eveningSupport_ido int --percben megadva
);

create table dolgozok (
	dolgozo_id bigserial primary key,
	nev text not null,
	munkakor_id bigint,
	belepesi_datum date,	
	felettes_id bigint
);

create table  munkaido_es_szabadsag (
	munkaido_id bigserial primary key,
	munkaido_kategoria text,
	dolgozo_id bigint,
	nev text not null,
	homeoffice_kategoria_id bigint, 
	homeoffice_kategoria text,	
	checkin time,
	checkout time,
	betegszabadsag bigint,
	torvenyileg_eloirt_szabadsag bigint
);

alter table dolgozok 
add constraint FK_dolgozok_munkakor 
foreign key (munkakor_id) 
references munkakor(munkakor_id) 
on update set null on delete set null;

alter table dolgozok 
add constraint FK_dolgozok_dolgozok 
foreign key (felettes_id) 
references dolgozok(dolgozo_id) 
on update set null on delete set null;

alter table munkaido_es_szabadsag
add constraint FK_munkaido_es_szabadsag_dolgozok
foreign key (homeoffice_kategoria_id)
references dolgozok (dolgozo_id)
on update set null on delete set null;

-- ******INSERT INTO munkakor******
insert into munkakor (munkakor_nev,munkaido_kezdete,munkaido_vege,support_ido) values 
('IT Igazgato','08:00:00','16:00:00',null);

insert into munkakor (munkakor_nev,munkaido_kezdete,munkaido_vege,support_ido) values 
('Infrastructure Management','08:00:00','16:00:00',120);

insert into munkakor (munkakor_nev,munkaido_kezdete,munkaido_vege,support_ido,morningSupport_ido,onsiteSupport_ido,eveningSupport_ido) values 
('Service_Support','05:30:00','23:00:00',120,240,480,120);

insert into munkakor (munkakor_nev,munkaido_kezdete,munkaido_vege,support_ido) values 
('Business Consulting','06:00:00','18:00:00',360);

-- ******INSERT INTO dolgozok******
insert into dolgozok (nev,munkakor_id,belepesi_datum,felettes_id) values 
('Angelica Schwimmer',1,'1997-01-01',null);

insert into dolgozok (nev,munkakor_id,belepesi_datum,felettes_id) values 
('Nagy Tamás',2,'2012-01-01',1);

insert into dolgozok (nev,munkakor_id,belepesi_datum,felettes_id) values 
('Kisvirág Tünde',3,'2009-12-01',2);

insert into dolgozok (nev,munkakor_id,belepesi_datum,felettes_id) values 
('Horváth Tamás',3,'2011-04-20',2);

insert into dolgozok (nev,munkakor_id,belepesi_datum,felettes_id) values 
('Kovács András',2,'2009-08-27',3);

insert into dolgozok (nev,munkakor_id,belepesi_datum,felettes_id) values 
('Szikra Szilveszter',3,'2022-10-10',2);

insert into dolgozok (nev,munkakor_id,belepesi_datum,felettes_id) values 
('Lángoló Frigyes',2,'2012-01-12',1);

insert into dolgozok (nev,munkakor_id,belepesi_datum,felettes_id) values 
('Gyertya Viktor',4,'2022-10-10',2);

-- ******INSERT INTO munkaido_es_szabadsag******
insert into munkaido_es_szabadsag (munkaido_kategoria,nev,homeoffice_kategoria_id,homeoffice_kategoria,checkin,checkout,betegszabadsag,torvenyileg_eloirt_szabadsag) values 
('Normál','Nagy Tamás',1,'Fulltime','07:50:00','17:50:00',20,29);

insert into munkaido_es_szabadsag (munkaido_kategoria,nev,homeoffice_kategoria_id,homeoffice_kategoria,checkin,checkout,betegszabadsag,torvenyileg_eloirt_szabadsag) values 
('Normál','Kisvirág Tünde',2,'2days/week','08:10:00','14:45:00',2,31);

insert into munkaido_es_szabadsag (munkaido_kategoria,nev,homeoffice_kategoria_id,homeoffice_kategoria,checkin,checkout,betegszabadsag,torvenyileg_eloirt_szabadsag) values 
('Részmunkaidő','Kovács András',1,'Fulltime','07:50:00','16:55:00',4,12);

delete from munkaido_es_szabadsag where nev='Angelica Schwimmer';
insert into munkaido_es_szabadsag (munkaido_kategoria,nev,homeoffice_kategoria_id,homeoffice_kategoria,checkin,checkout,betegszabadsag,torvenyileg_eloirt_szabadsag) values 
('Normál','Angelica Schwimmer',3,'4days/week','05:00:00','23:00:00',0,24);

insert into munkaido_es_szabadsag (munkaido_kategoria,nev,homeoffice_kategoria_id,homeoffice_kategoria,checkin,checkout,betegszabadsag,torvenyileg_eloirt_szabadsag) values 
('Részmunkaidő','Gyertya Viktor',4,'--','12:30:00','13:30:00',0,2);

insert into munkaido_es_szabadsag (munkaido_kategoria,nev,homeoffice_kategoria_id,homeoffice_kategoria,checkin,checkout,betegszabadsag,torvenyileg_eloirt_szabadsag) values 
('Részmunkaidő','Lángoló Frigyes',2,'2days/week','09:15:00','18:10:00',17,10);

insert into munkaido_es_szabadsag (munkaido_kategoria,nev,homeoffice_kategoria_id,homeoffice_kategoria,checkin,checkout,betegszabadsag,torvenyileg_eloirt_szabadsag) values 
('Normál','Szikra Szilveszter',1,'Fulltime','04:15:00','10:20:00',1,28);

insert into munkaido_es_szabadsag (munkaido_kategoria,nev,homeoffice_kategoria_id,homeoffice_kategoria,checkin,checkout,betegszabadsag,torvenyileg_eloirt_szabadsag) values 
('Normál','Horváth Tamás',4,'--','08:15:00','18:15:00',7,14);

-- ******SELECT scripts******

--1. lekérdezés: Listázd ki, hogy milyen munkaidő kategóriában dolgoznak az egyes munkavállalók!

select nev,munkaido_kategoria from munkaido_es_szabadsag mes;

--2. lekérdezés: Listázd ki, hogy az egyes dolgozóknak ki a vezetője!

select nev,felettes_id from dolgozok;

--3. lekérdezés: Listázd ki, hogy hány olyan dolgozó van a cégnél, aki teljes home officeban dolgozhat!

select munkaido_kategoria,nev,homeoffice_kategoria from munkaido_es_szabadsag mes
where homeoffice_kategoria = 'Fulltime';

--4. lekérdezés: Listázd ki azokat a dolgozókat, akiknek 2 nap home office elérhető!

select munkaido_kategoria,nev,homeoffice_kategoria from munkaido_es_szabadsag mes
where homeoffice_kategoria = '2days/week';

--5. lekérdezés: Melyik az a dolgozó, akihez a legtöbb betegszabadság tartozik?

select nev,betegszabadsag from munkaido_es_szabadsag mes
where mes.betegszabadsag = (select max (betegszabadsag) from munkaido_es_szabadsag mes2);

--6. lekérdezés: Kik azok a dolgozók, akik 2022 előtt léptek be a céghez?

select nev, belepesi_datum from dolgozok d
where d.belepesi_datum < '2022-01-01';

--7. lekérdezés: Hányan dolgoznak a vállalatnál?

select count(dolgozo_id) from dolgozok d;

--8. lekérdezés: Melyik az az osztály, amelynek a support ideje több, mint 4 óra?

select munkakor_nev from munkakor m
where support_ido > 240;











































