show search_path;

select rendszam from auto.sz_auto as a 
join auto.sz_auto_tulajdonosa ta on a.azon = ta.auto_azon 
join auto.sz_tulajdonos t on ta.tulaj_azon = t.azon  where t.nev =('Nagy József');

select * from sz_automarka am left join sz_autotipus t on t.marka=am.nev;

select szin,max(elso_vasarlasi_ar) from sz_auto group by szin order by szin;

select szin from sz_auto group by szin having count(szin)=1 order by szin;

select t.megnevezes from sz_auto a join sz_autotipus t on t.azon=a.tipus_azon group by t.megnevezes having count(*)<2;

select * from sz_auto a left join sz_autotipus t on t.azon=a.tipus_azon;