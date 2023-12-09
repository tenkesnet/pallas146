--show search_path;
drop table if exists tanulo;

create table if not exists tanulo (
id serial primary key,
name text,
birthDate date,
weight double precision
);

insert into tanulo (name,birthDate,weight) values ('Robi','1975-01-20',86),
('Zoli','1980-05-06',76);