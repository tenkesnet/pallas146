select * from countries;

select c.country_name,r.region_name from countries c,regions r
    where 1=1
    --and c.region_id=1 
    and c.region_id=r.region_id;

select c.country_name,r.region_name 
    from countries c,regions r;

select *
    from countries c 
    join regions r on c.region_id=r.region_id
    join locations l on l.country_id=c.country_id
    --where c.country_id is null;

select j.job_title,count(*),sum(e.salary),avg(e.salary) from employees e
    join jobs j on e.job_id=j.job_id
    group by j.job_title
    ;

select * from employees e order by e.salary desc;


SELECT 2024 AS year, 
    CASE WHEN strftime('%d',2024 || '-02-29') IS NOT NULL 
    THEN 'leap' ELSE 'normal' END AS szokoev_e;    