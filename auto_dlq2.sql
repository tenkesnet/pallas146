set search_path=auto;
show search_path;

select rendszam from auto.sz_auto as a 
join auto.sz_auto_tulajdonosa ta on a.azon = ta.auto_azon 
join auto.sz_tulajdonos t on ta.tulaj_azon = t.azon  where t.nev =('Nagy József');

select * from sz_automarka am left join sz_autotipus t on t.marka=am.nev;

select szin,max(elso_vasarlasi_ar) from sz_auto group by szin order by szin desc ;

select szin from sz_auto group by szin having count(szin)<5 order by szin;

5. Melyek azok az autótípusok, amelyekhez 5-nél kevesebb autó tartozik?
select t.megnevezes,count(a.azon) from sz_auto a join sz_autotipus t on t.azon=a.tipus_azon group by t.azon having count(a.azon)<5;

select rendszam  from sz_auto where elso_vasarlasi_ar = (select max(elso_vasarlasi_ar) from sz_auto);

7. Ki az utolsó tulajdonosa annak az autónak, amelyikhez a legdrágább autófelértékelés tartozik?

select tulaj.nev from sz_autofelertekeles ertekeles 
	left join sz_auto_tulajdonosa tulaja on ertekeles.auto_azon=tulaja.auto_azon 
	join sz_tulajdonos tulaj on tulaja.tulaj_azon = tulaj.azon
	where 
	ertekeles.ertek = (select max(ertek) from sz_autofelertekeles)
	and tulaja.vasarlas_ideje=(select max(tulaja2.vasarlas_ideje) from sz_auto_tulajdonosa tulaja2 where tulaja2.auto_azon=tulaja.auto_azon);


	select * from sz_auto_tulajdonosa sat ;
select * from sz_tulajdonos st ;
	
8. Ki volt az autók előző tulajdonosa?

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

select * from sz_autotipus t join sz_auto a on a.tipus_azon=t.azon

select * from sz_auto sa ;

--Színenként melyik a legdrágább első vásárlási árú autó?
select * from sz_auto a where a.elso_vasarlasi_ar = (
	select max(elso_vasarlasi_ar) from sz_auto where szin=a.szin group by szin ) ;

select szin,max(elso_vasarlasi_ar),rendszam,elso_vasarlas_idopontja from sz_auto group by szin,rendszam,elso_vasarlas_idopontja; 

11.Tárolteljárás létrehozása:
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
		marka_tmp text;
		markanev text;
	begin
		select marka into marka_tmp from sz_autotipus where azon=p1.tipus_azon;
		select nev into markanev from sz_automarka where nev=marka_tmp;
		if marka_tmp is null or markanev is null then 
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

CREATE TYPE dolgozo AS
   (  	
    dolgozo_id bigserial,
	nev text ,
	munkakor text,
	belepesi_datum date,	
	felettes text
   );

  CREATE OR REPLACE FUNCTION insert_dolgozo (p1 dolgozo)
	RETURNS text AS $$
	DECLARE
		munkakor_id bigint;
		markanev text;
	begin
		select munkakor into munkakor_id from munkakor where munkakor_nev=p1.munkakor;
		select nev into markanev from sz_automarka where nev=marka_tmp;
		if marka_tmp is null or markanev is null then 
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
  
  
select insert_auto(row(11,'keki','2022-12-20',30000000,7,'SOLYOM-111'));
select insert_dolgozo(row(11,'Péter','Infrastructure Management'));
select * from sz_auto ;



  


