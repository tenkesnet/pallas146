package alapozo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAdvanced {
    public static void illegalStateException(){
        Stream<String> elements =
                Stream.of("a", "b", "c").filter(element -> element.contains("b"))
                        ;
        Optional<String> anyElement = elements.findAny();
        //IllegalStateException
        Optional<String> firstElement = elements.findAny();

        /**
         * Megoldás:
         * List<String> elements =
         *   Stream.of("a", "b", "c").filter(element -> element.contains("b"))
         *     .collect(Collectors.toList());
         * Optional<String> anyElement = elements.stream().findAny();
         * Optional<String> firstElement = elements.stream().findFirst();
         */
    }
}
