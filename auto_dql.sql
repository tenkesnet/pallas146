show search_path;

select rendszam from auto.sz_auto as a 
join auto.sz_auto_tulajdonosa ta on a.azon = ta.auto_azon 
join auto.sz_tulajdonos t on ta.tulaj_azon = t.azon  where t.nev =('Nagy József');

select * from sz_automarka am left join sz_autotipus t on t.marka=am.nev;

select szin,max(elso_vasarlasi_ar) from auto.sz_auto group by szin order by szin desc ;

select szin from sz_auto group by szin having count(szin)<5 order by szin;

select t.megnevezes from sz_auto a join sz_autotipus t on t.azon=a.tipus_azon group by t.megnevezes having count(*)<5;

select rendszam,elso_vasarlasi_ar from sz_auto  where  elso_vasarlasi_ar=(select max(elso_vasarlasi_ar) from sz_auto);

select tulaj.nev from sz_autofelertekeles ertekeles 
	join sz_auto_tulajdonosa tulaja on ertekeles.auto_azon=tulaja.auto_azon 
	join sz_tulajdonos tulaj on tulaja.auto_azon = tulaj.azon 
	where ertekeles.ertek = (select max(ertek) from sz_autofelertekeles)
	and tulaja.vasarlas_ideje=(select max(vasarlas_ideje) from sz_auto_tulajdonosa where tulaj_azon=tulaja.tulaj_azon)
	;

select t.nev from sz_auto a 
	join sz_auto_tulajdonosa aut on aut.auto_azon=a.azon
	join sz_tulajdonos t on t.azon = aut.tulaj_azon
	where aut.vasarlas_ideje = ( select max(vasarlas_ideje) from sz_auto_tulajdonosa where vasarlas_ideje < (select max(vasarlas_ideje) from sz_auto_tulajdonosa ) )
	;

select t.megnevezes,count(t.azon) from sz_autotipus t join sz_auto a on a.tipus_azon=t.azon group by t.azon,t.megnevezes
	having count(t.azon) = ( 
		select max(tipus_count) from 
			(select t.azon,count(t.azon) as tipus_count from sz_auto a join sz_autotipus t on a.tipus_azon=t.azon group by t.azon ) m 
	) ;

select * from sz_auto a where a.elso_vasarlasi_ar = (
	select max(elso_vasarlasi_ar) from sz_auto where szin=a.szin group by szin ) ;

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

drop function insert_auto(auto);
select insert_auto(row(1,'bordo','2011-12-12',300000,1,'ddc-987'));

select * from sz_auto ;

delete from auto.sz_auto where azon=6;




