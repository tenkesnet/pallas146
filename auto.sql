show search_path;
set search_path = auto;

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

