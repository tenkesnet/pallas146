set search_path=auto;
show search_path;

select rendszam from auto.sz_auto as a 
join auto.sz_auto_tulajdonosa ta on a.azon = ta.auto_azon 
join auto.sz_tulajdonos t on ta.tulaj_azon = t.azon  where t.nev =('Nagy József');

select * from sz_automarka am left join sz_autotipus t on t.marka=am.nev;

select szin,max(elso_vasarlasi_ar) from sz_auto group by szin order by szin desc ;

select szin from sz_auto group by szin having count(szin)<5 order by szin;

select t.megnevezes,count(a.azon) from sz_auto a join sz_autotipus t on t.azon=a.tipus_azon group by t.azon having count(a.azon)<5;

select * from sz_auto;
select  * from sz_autotipus sa ;

select rendszam  from sz_auto where elso_vasarlasi_ar = (select max(elso_vasarlasi_ar) from sz_auto);

Ki az utolsó tulajdonosa annak az autónak, amelyikhez a legdrágább autófelértékelés tartozik?

select * from sz_autofelertekeles ertekeles 
	left join sz_auto_tulajdonosa tulaja on ertekeles.auto_azon=tulaja.auto_azon 
	join sz_tulajdonos tulaj on tulaja.tulaj_azon = tulaj.azon
	where 
	ertekeles.ertek = (select max(ertek) from sz_autofelertekeles)
	and tulaja.vasarlas_ideje=(select max(vasarlas_ideje) from sz_auto_tulajdonosa where auto_azon=tulaja.auto_azon);


	select * from sz_auto_tulajdonosa sat ;
select * from sz_tulajdonos st ;
	
Ki volt az autók előző tulajdonosa?

select * from sz_auto a 
	join sz_auto_tulajdonosa aut on aut.auto_azon=a.azon
	join sz_tulajdonos t on t.azon = aut.tulaj_azon
	where aut.vasarlas_ideje = ( select max(aut2.vasarlas_ideje) from sz_auto_tulajdonosa aut2 where aut2.vasarlas_ideje < (select max(vasarlas_ideje) from sz_auto_tulajdonosa aut3
		where aut3.auto_azon=aut.auto_azon) 
		and aut2.auto_azon=aut.auto_azon )
	
	;

9. Melyik az az autótípus, amelyekhez a legtöbb autó tartozik?


select t.megnevezes,count(a.azon) from sz_autotipus t join sz_auto a on a.tipus_azon=t.azon group by t.azon,t.megnevezes
	having count(t.azon) = ( 
		select max(m.tipus_count) from 
			(select count(t2.azon) as tipus_count from sz_auto a2 join sz_autotipus t2 on t2.azon=a2.tipus_azon group by t2.azon ) m 
	) ;
;
select * from sz_autotipus t join sz_auto a on a.tipus_azon=t.azon

select * from sz_auto sa ;

--Színenként melyik a legdrágább első vásárlási árú autó?
select * from sz_auto a where a.elso_vasarlasi_ar = (
	select max(elso_vasarlasi_ar) from sz_auto where szin=a.szin group by szin ) ;

select szin,max(elso_vasarlasi_ar),rendszam,elso_vasarlas_idopontja from sz_auto group by szin,rendszam,elso_vasarlas_idopontja; 

Egy bejövő tábla paraméterből (UDT): @autok (Oszlopai: SZ_AUTO táblával megegyező) beszúrja az
SZ_AUTO táblába azokat a sorokat/vagy módosítja (Kulcs: AZON oszlop), amelyekhez tartozik
megfelelő autótípus, illetve autómárka. Amelyekhez nem, azokat a sorokat a program ne töltse be az
adatbázisba, és dobjon egy figyelmeztető üzenetet.

CREATE TYPE auto AS
   (  	
    azon numeric(5),
	szin varchar(20),
	elso_vasarlas_idopontja date,
	elso_vasarlasi_ar numeric(20),
	tipus_azon numeric(5),
	rendszam varchar(10)
   );

CREATE OR REPLACE FUNCTION insert_auto (p1 auto)
	RETURNS text AS $$
	DECLARE
		marka text;
		markanev text;
	begin
		select megnevezes into marka from sz_autotipus where azon=p1.tipus_azon;
		select nev into markanev from sz_automarka where nev=marka;
		if marka is null and markanev is null then 
			return 'Error message'; 
		end if;
		perform * from sz_auto where azon=p1.azon;
		if not found then
			insert into sz_auto (azon,szin,elso_vasarlas_idopontja,elso_vasarlasi_ar,tipus_azon,rendszam) values (p1.azon,p1.szin,p1.elso_vasarlas_idopontja,p1.elso_vasarlasi_ar,p1.tipus_azon,p1.rendszam);
		else
			update sz_auto set szin=p1.szin,elso_vasarlas_idopontja=p1.elso_vasarlas_idopontja,elso_vasarlasi_ar=p1.elso_vasarlasi_ar,tipus_azon=p1.tipus_azon,rendszam=p1.rendszam where azon=p1.azon ;
		end if;
		return 'Ok';
	END;
$$ LANGUAGE plpgsql;


select insert_auto(row(1,'bordó','2011-12-12',300000,1,'ddc-987'));



  


