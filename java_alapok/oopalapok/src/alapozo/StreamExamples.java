package alapozo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {
    List<String> fruits = Arrays.asList("apple", "banana", "orange", "banana", "apple");
    List<Integer> ints = Arrays.asList(5, 3, 7, 8, 2);
    List<Harcos> harcosok = Arrays.asList(
            new Harcos("Pisti", 20, 2)
            ,new Harcos("Jani", 18, 2)
            ,new Harcos("Géza", 25, 3)
            ,new Harcos("Kata", 20, 1)
    );
    List<Dolgozo> dolgozok;
    public StreamExamples() {
    }
    public void reduce(){

        List<String> pGyumik = fruits.stream().filter((gyumolcs) -> {
            return gyumolcs.length() > 5;
        }).collect(Collectors.toList());
        Stream<Harcos> szurtStream=harcosok.stream()
                //.limit(1)
                .filter(h -> h.getSebzesiEro() >0)
                .peek(h -> h.setEletEro(h.getEletEro()+100));

        harcosok.forEach(x-> System.out.println(x));
        szurtStream.collect(Collectors.toList());
        System.out.println("------------------");
        //az accumulator az első elemet kapja meg az item ha a size>1 akkor a másodiktól iterál
        //ha size==1 akkor az accumulator és az item is az első elem értékét veszi fel.
        Optional<Harcos> result = harcosok.stream()
                .reduce((accumlator, item) -> {
                    accumlator = new Harcos("",0,0);
                    accumlator.setEletEro(accumlator.getEletEro()+ item.getEletEro());
                    return accumlator;
                } );
        result.ifPresent(x-> System.out.println(x));
        System.out.println("");
    }
    public void dolgozokBeolvasasa(){
        try {
            List<String> lines =Files.readAllLines(Path.of("file_example_CSV_5000.csv"));
            Sorszam sorszam= new Sorszam(1);
            lines.stream().forEach(x -> {
                if(sorszam.get()!=1) {
                    String[] fields = x.split(",");
                    System.out.println("");
                }
                sorszam.increment();
            });


            System.out.println("");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
