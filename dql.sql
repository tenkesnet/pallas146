select * from countries;

select c.country_name,r.region_name from countries c,regions r
    where 1=1
    --and c.region_id=1 
    and c.region_id=r.region_id;

select c.country_name,r.region_name 
    from countries c,regions r;

select c.country_name,r.region_name 
    from countries c 
    join regions r on c.region_id=r.region_id;