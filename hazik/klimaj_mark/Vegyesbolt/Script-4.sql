show search_path;
set search_path = vegyesbolt;

--drop table if exists ELADO_TER_TERMEKEK CASCADE ;
--drop table if exists RAKTAR_TERMEKEK cascade ;
drop table if exists TERMEKEK cascade;
drop table if exists DOLGOZOK CASCADE ; 
drop table if exists VASARLASOK CASCADE ;
drop table if exists BESZALLITOK cascade;
drop table if exists besz_megrendeles cascade;
drop table if exists besz_termekek cascade;
drop table if exists forselfuse cascade;

CREATE TABLE forselfuse (
    termek_nev TEXT,
    mennyiseg INT
);

CREATE TABLE termekek (
    termek_id SERIAL PRIMARY KEY,
    nev TEXT,
    leiras TEXT,
    keszletmennyiseg NUMERIC(6),
    raktar_mennyiseg INT,
    egysegar NUMERIC(6),
    kategoria TEXT,
    lejarati_datum DATE
);

CREATE TABLE dolgozok (
    id SERIAL PRIMARY KEY,
    nev TEXT,
    munkakor TEXT,
    foglalkoztatas_kezdete DATE NOT NULL,
    foglalkoztatas_vege DATE NULL
);

CREATE TABLE vasarlasok (
    id SERIAL PRIMARY KEY,
    termek_id INT,
    mennyiseg INT8,
    egysegar NUMERIC(6),
    vasarlas_datuma DATE,
    FOREIGN KEY (termek_id) REFERENCES termekek(termek_id) ON UPDATE SET NULL ON DELETE SET NULL
);

CREATE TABLE beszallitok (
    id SERIAL PRIMARY KEY,
    nev TEXT,
    kedvezmeny INT
);

CREATE TABLE besz_megrendeles (
    id SERIAL PRIMARY KEY,
    beszallito_id INT,
    beszallitas_datuma DATE,
    FOREIGN KEY (beszallito_id) REFERENCES beszallitok(id) ON UPDATE SET NULL ON DELETE SET NULL
);

CREATE TABLE besz_termekek (
    besz_megrendeles_id INT,
    termek_id INT,
    mennyiseg INT,
    beszallitoi_ar NUMERIC(6),
    PRIMARY KEY (besz_megrendeles_id, termek_id),
    FOREIGN KEY (besz_megrendeles_id) REFERENCES besz_megrendeles(id) ON UPDATE SET NULL ON DELETE SET NULL,
    FOREIGN KEY (termek_id) REFERENCES termekek(termek_id) ON UPDATE SET NULL ON DELETE SET NULL
);



INSERT INTO TERMEKEK (nev, leiras, kategoria, egysegar, raktar_mennyiseg, lejarati_datum)
VALUES
  ('Alma', 'Friss alma', 'Gyümölcs', 100.80, 50,'2023-12-21'),
  ('Tej', 'Friss tej', 'Tejtermék', 555.99, 30,'2023-11-15'),
  ('Tolltartó', 'Tolttartó doboz', 'Iskolaszerek', 803.99, 40,NULL),
  ('Papír', 'Írópapír', 'Iskolaszerek', 12.99, 25, NULL),
  ('Toll', 'Golyós toll', 'Iskolaszerek', 97.99, 60, NULL),
  ('Lámpa', 'Asztali lámpa', 'Lakberendezés', 1306.99, 35, NULL),
  ('Mobiltelefon', 'Okostelefon', 'Technológia', 39999.99, 75, NULL),
  ('Bicikli', 'Női Kerékpár 24-es', 'Sport és szabadidő', 24000.99, 45, NULL),
  ('Úszósapka', 'Unisex úszósapka M méret', 'Sport és szabadidő', 2500.99, 55, NULL),
  ('Kávé', '1kg Arabica kávé', 'Élelmiszer', 1024.99, 70, '2024-02-15'),
  ('Sütemény', 'Keksz', 'Élelmiszer', 655.99, 20,'2023-11-12'),
  ('Ablakmosó folyadék', 'JAR ablakmosó 1L', 'Tisztítószerek', 1700.99, 15,'2023-12-21'),
  ('Tequila', '0,75l kiszerelés', 'Alkohol', 4590.99, 80, '2025-01-01'),
  ('MR. MUSCLE', 'Lefolyó tisztító', 'Tisztítószerek', 1800.99, 65, '2025-01-01'),
  ('CD Lemez', ' ÜRES 2 oldalú írható lemez 10db', 'Szórakozás', 700.99, 40, NULL);
 
 INSERT INTO TERMEKEK (nev, leiras, kategoria, egysegar, raktar_mennyiseg, lejarati_datum)
VALUES
  ('Fogkrém', 'Tartalmas fogkrém', 'Higiénia', 1060.99, 100, '2024-01-30'),
  ('Tűzhely', '4 égős gáz tűzhely', 'Háztartási gépek', 99000.99, 15, NULL),
  ('Kenyér', 'Friss rozsos kenyér', 'Pékáru', 450.99, 40, '2023-11-11'),
  ('Naptej', 'SPF 30 naptej', 'Kozmetikumok', 3000.99, 50, '2024-06-01'),
  ('Virágcsokor', 'Rózsavirágok csokorban', 'Virágok', 8800.99, 10, NULL),
  ('Számítógép', 'Laptop i7 processzorral', 'Technológia', 295000.99, 30, NULL),
  ('Kerékpáros sisak', 'MTB kerékpáros sisak', 'Sport és szabadidő', 36790.99, 25, NULL),
  ('Konzervhal', 'Tonhal konzerv', 'Élelmiszer', 900.49, 60, '2024-04-15'),
  ('Porszívó', 'Ciklonporszívó', 'Háztartási gépek', 15000.99, 20, NULL),
  ('DVD lemez', 'Üres írható DVD 10db', 'Szórakozás', 3500, 50, NULL),
  ('Bor', 'Vörösbor 0,75L', 'Alkohol', 1900.99, 40, '2024-12-31'),
  ('Szappan', 'Frissítő tusfürdő', 'Higiénia', 1500, 80, NULL),
  ('Tűsarkú cipő', 'Női tűsarkú cipő', 'Divat', 12300.99, 15, NULL),
  ('Főzőlap', '4 égős elektromos főzőlap', 'Háztartási gépek', 54990.99, 10, NULL),
  ('Számítógép egér', 'Optikai számítógép egér', 'Technológia', 5490.99, 70, NULL),
  ('Bontott tégla', 'Tégla építkezéshez', 'Építőanyagok', 250.84, 100, NULL);
 
 select * from termekek t;

insert into beszallitok (nev,kedvezmeny) values ('HANSA', 5),('JANKER', 3),('MEDIA MARKT', 2);
select* from beszallitok b ;

insert into besz_megrendeles (beszallito_id,beszallitas_datuma) VALUES((select id from beszallitok where id='1'), '2023-03-17' ),
((select id from beszallitok where id='2'), '2023-01-15' ),
((select id from beszallitok where id='3'), '2023-04-02' ),
((select id from beszallitok where id='2'), '2023-05-03' );

select * from besz_megrendeles bm ;


insert into besz_termekek (besz_megrendeles_id,termek_id,mennyiseg,beszallitoi_ar) VALUES((select id from besz_megrendeles  where beszallitas_datuma = '2023-01-15'),(select termek_id from termekek where termekek.nev = 'Alma'),30,50.99),
((select id from besz_megrendeles  where beszallitas_datuma = '2023-04-02'),(select termek_id from termekek where termekek.nev = 'Lámpa'),15,800.99),
((select id from besz_megrendeles  where beszallitas_datuma = '2023-05-03'),(select termek_id from termekek where termekek.nev = 'Mobiltelefon'),60,25490.99);


insert into besz_termekek (besz_megrendeles_id,termek_id,mennyiseg,beszallitoi_ar) VALUES((select id from besz_megrendeles  where beszallitas_datuma = '2023-01-15'),(select termek_id from termekek where termekek.nev = 'Tej'),30,500.99),
((select id from besz_megrendeles where beszallitas_datuma = '2023-03-17'),(select termek_id from termekek where termekek.nev = 'Tolltartó'),40,507.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-05-03'),(select termek_id from termekek where termekek.nev = 'Papír'),25,8.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-04-02'),(select termek_id from termekek where termekek.nev = 'Toll'),60,65.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-05-03'),(select termek_id from termekek where termekek.nev = 'Bicikli'),45,18504.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-05-03'),(select termek_id from termekek where termekek.nev = 'Úszósapka'),55,1504.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-01-15'),(select termek_id from termekek where termekek.nev = 'Kávé'),70,584.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-05-03'),(select termek_id from termekek where termekek.nev = 'Sütemény'),20,504.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-01-15'),(select termek_id from termekek where termekek.nev = 'Ablakmosó folyadék'),15,1203.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-05-03'),(select termek_id from termekek where termekek.nev = 'Tequila'),80,3580.70),
((select id from besz_megrendeles where beszallitas_datuma = '2023-01-15'),(select termek_id from termekek where termekek.nev = 'MR. MUSCLE'),65,1034.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-05-03'),(select termek_id from termekek where termekek.nev = 'CD Lemez'),40,804.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-01-15'),(select termek_id from termekek where termekek.nev = 'Fogkrém'),100,1044.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-05-03'),(select termek_id from termekek where termekek.nev = 'Tűzhely'),15,64504.32),
((select id from besz_megrendeles where beszallitas_datuma = '2023-05-03'),(select termek_id from termekek where termekek.nev = 'Kenyér'),40,484.70),
((select id from besz_megrendeles where beszallitas_datuma = '2023-03-17'),(select termek_id from termekek where termekek.nev = 'Naptej'),50,2684.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-03-17'),(select termek_id from termekek where termekek.nev = 'Virágcsokor'),10,6600.00),
((select id from besz_megrendeles where beszallitas_datuma = '2023-05-03'),(select termek_id from termekek where termekek.nev = 'Számítógép'),30,214580.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-05-03'),(select termek_id from termekek where termekek.nev = 'Kerékpáros sisak'),25,21200.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-04-02'),(select termek_id from termekek where termekek.nev = 'Konzervhal'),60,505.60),
((select id from besz_megrendeles where beszallitas_datuma = '2023-04-02'),(select termek_id from termekek where termekek.nev = 'Porszívó'),20,12504.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-03-17'),(select termek_id from termekek where termekek.nev = 'DVD lemez'),50,3104.21),
((select id from besz_megrendeles where beszallitas_datuma = '2023-04-02'),(select termek_id from termekek where termekek.nev = 'Bor'),40,1607.10),
((select id from besz_megrendeles where beszallitas_datuma = '2023-01-15'),(select termek_id from termekek where termekek.nev = 'Szappan'),80,1414.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-05-03'),(select termek_id from termekek where termekek.nev = 'Tűsarkú cipő'),15,10504.80),
((select id from besz_megrendeles where beszallitas_datuma = '2023-05-03'),(select termek_id from termekek where termekek.nev = 'Főzőlap'),10,35591.99),
((select id from besz_megrendeles where beszallitas_datuma = '2023-01-15'),(select termek_id from termekek where termekek.nev = 'Számítógép egér'),70,2409.37),
((select id from besz_megrendeles where beszallitas_datuma = '2023-03-17'),(select termek_id from termekek where termekek.nev = 'Bontott tégla'),100,103.74);



select * from besz_termekek bt;

insert into forselfuse VALUES('Alma',5),('Lámpa',3), ('Ablakmosó folyadék', 3), ('MR. MUSCLE', 1);

insert into dolgozok (nev,munkakor,foglalkoztatas_kezdete,foglalkoztatas_vege) values ('Kati néni', 'ELADO','2023-01-01', NULL), ('Zoltán','Főnök','2022-09-01', NULL), ('Jani a beugrós', 'ELADO','2023-04-01','2023-04-11'), ('Jani a beugrós', 'LEADO', '2023-06-05', '2023-10-14');

select * from dolgozok;

INSERT INTO VASARLASOK (termek_id, mennyiseg, egysegar, vasarlas_datuma)
VALUES
  ((SELECT termek_id FROM TERMEKEK WHERE nev = 'Alma'), 5, 504, '2023-11-01'),
  ((SELECT termek_id FROM TERMEKEK WHERE nev = 'Tej'), 2, 1111.98, '2023-11-02'),
  ((SELECT termek_id FROM TERMEKEK WHERE nev = 'Tolltartó'), 3, 2411.97, '2023-11-03'),
  ((SELECT termek_id FROM TERMEKEK WHERE nev = 'Papír'), 4, 51.96, '2023-11-04'),
  ((SELECT termek_id FROM TERMEKEK WHERE nev = 'Toll'), 2, 195.98, '2023-11-05'),
  ((SELECT termek_id FROM TERMEKEK WHERE nev = 'Lámpa'), 1, 1306.99, '2023-11-06'),
  ((SELECT termek_id FROM TERMEKEK WHERE nev = 'Mobiltelefon'), 3, 119999.97, '2023-11-07'),
  ((SELECT termek_id FROM TERMEKEK WHERE nev = 'Bicikli'), 1, 24000.99, '2023-11-08'),
  ((SELECT termek_id FROM TERMEKEK WHERE nev = 'Úszósapka'), 2, 501.98, '2023-11-09'),
  ((SELECT termek_id FROM TERMEKEK WHERE nev = 'Kávé'), 5, 5124.95, '2023-11-10'),
  ((SELECT termek_id FROM TERMEKEK WHERE nev = 'Sütemény'), 4, 2623.96, '2023-11-11'),
  ((SELECT termek_id FROM TERMEKEK WHERE nev = 'Ablakmosó folyadék'), 2, 3401.98, '2023-11-12'),
  ((SELECT termek_id FROM TERMEKEK WHERE nev = 'Tequila'), 1, 4590.99, '2023-11-13');
 
 select * from vasarlasok v;