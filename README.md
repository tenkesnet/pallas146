# Java Beckend + Tester

## Linkek
- [WAMP](https://bitnami.com/stack/wamp/installer)

## Vátozó típusok

Primitívek:

|type|alapérték|hossz|tartomány|
|----|---|----|----|
|byte                    |0               |8  bit |( -128-127 ; -2^7 - 2^7-1)|
|short                    |0               |16 bit |(-32768 - 32767 ; -2^15 - 2^15-1 )|
|int                    |0               |32 bit |(-2^31 - 2^31-1)|
|long                    |0L              |64 bit |(-2^63 - 2^63-1)|
|float                    |0.0f            |32 bit |(1.40239846 x 10^-45 - 3.40282347 x 10^38)|
|double                    |0.0d            |64 bit |(4.9406564584124654 x 10^-324 - 1.7976931348623157 x 10^308)|
|char                    |'\u0000'        |16 bit |(0 - 2^16– 1)|
|boolean                |false           |1  bit |(0-1)|

Referencia Típusok:

String (or any object)   null

## OOP alapelvek

1. Egységbezárás (Encapsulation)

    Azt jelenti, hogy az adatstruktúrákat és az adott struktúrájú adatokat kezelő függvényeket (metódusokat) kombináljuk. Azokat egy egységként kezeljük, és elzárjuk őket a külvilág elől. Az így kapott egységeket objektumoknak nevezzük.

2. Öröklés (Inheritance)

    Azt takarja, hogy a meglévő objektumokból levezetett újabb objektumok öröklik a definiálásukhoz használt alap objektumok egyes adatstruktúráit és függvényeit, ugyanakkor újabb tulajdonságokat is definiálhatnak, vagy régieket újraértelmezhetnek.

3. Többalakúság (polimorfizmus)

    Egy adott tevékenység (metódus) azonosítója közös lehet egy adott objektum hierarchián belül, ugyanakkor a hierarchia minden egyes objektumában a tevékenységeket végrehajtó metódus implementációja az adott objektumra nézve specifikus lehet.

## Szerializáció
```
RandomAccessFile file;
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
try {
    objectMapper.writeValue(new File("korok.json"), korok);
} catch (StreamWriteException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
} catch (DatabindException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
} catch (IOException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
}
```
## Deszerializáció
```
ArrayList<Person> persons = null;
String jsonText = "";
try {
    jsonText = Files.readString(Paths.get("persons.json"));
} catch (Exception e) {
    // TODO: handle exception
}

ObjectMapper objectMapper = new ObjectMapper();

try {

    persons = objectMapper.readValue(jsonText,
            new TypeReference<ArrayList<Person>>() {
            });

} catch (IOException e) {
    e.printStackTrace();
}
```

## SQL alapok

### DDL - Data Definition Language


Azokat az utasításokat nevezzük DDL-nek, melyek a táblát, mint adathalmazt módosítja. Példa DDL utasítások:

```
CREATE EXTENSION "uuid-ossp";

CREATE TABLE IF NOT EXISTS public.student
(
    student_id uuid NOT NULL DEFAULT uuid_generate_v4(),
    name text COLLATE pg_catalog."default" NOT NULL,
    address text COLLATE pg_catalog."default" NOT NULL,
    phone_number text COLLATE pg_catalog."default",
    class text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT student_pkey PRIMARY KEY (student_id)
)

DROP TABLE public.student;

ALTER TABLE student ADD has_chip BOOLEAN;
```