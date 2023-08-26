package alapozo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {
    List<String> fruits = Arrays.asList("apple", "banana", "orange", "banana", "apple");
    List<Integer> ints = Arrays.asList(5, 3, 7, 8, 2);
    List<Harcos> harcosok = Arrays.asList(
            new Harcos("Pisti", 20, 2)
            , new Harcos("Jani", 18, 2)
            , new Harcos("Géza", 25, 3)
            , new Harcos("Kata", 20, 1)
    );
    List<Dolgozo> dolgozok = new ArrayList<>();

    public StreamExamples() {
    }

    public void reduce() {

        List<String> pGyumik = fruits.stream().filter((gyumolcs) -> {
            return gyumolcs.length() > 5;
        }).collect(Collectors.toList());
        Stream<Harcos> szurtStream = harcosok.stream()
                //.limit(1)
                .filter(h -> h.getSebzesiEro() > 0)
                .peek(h -> h.setEletEro(h.getEletEro() + 100));

        harcosok.forEach(x -> System.out.println(x));
        szurtStream.collect(Collectors.toList());
        System.out.println("------------------");
        //az accumulator az első elemet kapja meg az item ha a size>1 akkor a másodiktól iterál
        //ha size==1 akkor az accumulator és az item is az első elem értékét veszi fel.
        Optional<Harcos> result = harcosok.stream()
                .reduce((accumlator, item) -> {
                    accumlator = new Harcos("", 0, 0);
                    accumlator.setEletEro(accumlator.getEletEro() + item.getEletEro());
                    return accumlator;
                });
        result.ifPresent(x -> System.out.println(x));
        System.out.println("");
    }

    public void dolgozokBeolvasasa() {
        try {
            List<String> lines = Files.readAllLines(Path.of("file_example_CSV_5000.csv"));
            int sorszam = 1;
            HashMap<String,Country> countries= new HashMap<>();
            for (String line : lines) {
                if (sorszam != 1) {
                    String[] fields = line.split(",");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    countries.putIfAbsent(fields[4],new Country(fields[4]));
                    Dolgozo dolgozo = new Dolgozo(
                            Integer.parseInt(fields[0]),
                            fields[1],
                            fields[2],
                            fields[3],
                            countries.get(fields[4]),
                            Integer.parseInt(fields[5]),
                            sdf.parse(fields[6]),
                            Integer.parseInt(fields[7])
                    );
                    dolgozok.add(dolgozo);
                    System.out.println("");
                }
                sorszam++;
            }
            long kiskoru = dolgozok.stream()
                    .filter(d -> d.getAge() < 30)
                    .count();
            OptionalDouble atlagEletkor = dolgozok.stream()
                    .mapToDouble(x -> x.getAge())
                    .average();
            System.out.println("Átlagéletkor: " + atlagEletkor.getAsDouble());
            List<Dolgozo> idos = dolgozok.stream()
                    .filter(d -> d.getAge() > 50)
                    .collect(Collectors.toList());
            var start = System.currentTimeMillis();
            /*dolgozok.stream().forEach(dolgozo -> {
                if (dolgozo.getCountry().equals("United States")) {
                    dolgozo.setCountry("USA");
                }
            });*/
            var end = System.currentTimeMillis();
            ;
            System.out.println("Futási idő:" + String.valueOf(end - start));

            //Márk filteres és ciklus megoldása
            /*
            OptionalDouble franciadolgozoAVG = dolgozok.stream().filter(x -> x.getCountry().equals("France")).mapToDouble(Dolgozo::getAge).average();
            OptionalDouble amerikadolgozoAVG = dolgozok.stream().filter(x -> x.getCountry().equals("USA")).mapToDouble(Dolgozo::getAge).average();
            OptionalDouble angoldolgozoAVG = dolgozok.stream().filter(x -> x.getCountry().equals("Great Britain")).mapToDouble(Dolgozo::getAge).average();

            System.out.println("Futasi idő: " + (end - start));

            System.out.println("Átlagéletkor:" + atlagEletkor.getAsDouble());
            System.out.println("Francia átlagéletkor:" + franciadolgozoAVG.getAsDouble());
            System.out.println("Amerikai átlagéletkor:" + amerikadolgozoAVG.getAsDouble());
            System.out.println("Angol átlagéletkor:" + angoldolgozoAVG.getAsDouble());
            */
            final double[] franciaAVG = new double[] {0, 0};

            /*dolgozok.stream().forEach(x -> {
                        if (x.getCountry().equals("France")) {
                            franciaAVG[0] = franciaAVG[0] + x.getAge();
                            franciaAVG[1]++;
                        }

                    }
            );

            System.out.println("Francia átlag élétkor: " + (franciaAVG[0] / franciaAVG[1]));
            */
            //Grouping mnegoldás
            Map<Country, Optional<Dolgozo>> atlagEletkorOrszagonkent = dolgozok.stream()
                    .collect(Collectors.groupingBy(
                            Dolgozo::getCountry,
                            Collectors.minBy(Comparator.comparing(Dolgozo::getAge))
                    ));

            System.out.println("Átlagéletkor országonként:");
            atlagEletkorOrszagonkent.forEach((orszag, atlag) -> System.out.println(orszag + ": " + atlag));
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void primitivStreamek() {
        var result = IntStream.rangeClosed(1, 6)
                .reduce((a, b) -> a + b)
                .getAsInt();
        double osszeg = 0;
        double[] osszegTomb = {0};
        Sorszam sorszam = new Sorszam(0);
        AtomicReference<Double> doubleOsszeg = new AtomicReference<>(Double.valueOf(0));
        var start = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1000)
                .forEach(x -> doubleOsszeg.updateAndGet(v -> v + Math.sqrt(x)));
        var end = System.currentTimeMillis();
        ;
        System.out.println("Futási idő:" + String.valueOf(end - start));
        doubleOsszeg.getAndSet(doubleOsszeg.get() + 1);
        start = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            osszeg += Math.sqrt(i);
        }
        end = System.currentTimeMillis();
        ;
        System.out.println("Futási idő:" + String.valueOf(end - start));
        System.out.println("" + osszeg);
    }
}
