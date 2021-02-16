import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamSortTest {

    public static void main(String[] args) {
        Stream<Integer> s = Arrays.asList(10, 8, 1, 12).stream().map(element -> {
            System.out.println("Map operation performed");
            return element + 1;
        }).sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                System.out.println("Sorting actually happened");
                return t1 - t2;
            }
        });

        System.out.println("Block of intermediate operations finished");

        Optional<Integer> firstElement = s.findFirst();
        System.out.println("Terminal operation finished");
    }
}
/*
Console output

Block of intermediate operations finished
Map operation performed
Map operation performed
Map operation performed
Map operation performed
Sorting actually happened
Sorting actually happened
Sorting actually happened
Sorting actually happened
Sorting actually happened
Terminal operation finished

 */
