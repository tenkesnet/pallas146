set search_path = pallas;


drop table words;

create table words (
id serial primary key,
szo text,
lemma text,
szofaj text,
szotagszam int,
cv text,
szo_gyakorisag int,
lemma_gyakorisag int
);

select count(*) from words;

truncate words;
vacuum words;
commit;

SELECT version();

