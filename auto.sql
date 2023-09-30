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
 
