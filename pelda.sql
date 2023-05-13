-- SQLite
create table szemely (
    id int,
    nev varchar(255),
    szul_ido date
);

drop table szemely;

alter table szemely add COLUMN elo boolean;