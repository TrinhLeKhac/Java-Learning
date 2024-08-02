package stream;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// peek(System.out::println) is very useful to follow the elements processed by your stream one by one,
// without having to debug your code.
// Debugging a stream is hard because you need to be careful where you put your breakpoints.
// Most of the time, putting breakpoints on a stream processing will send you to the implementation of the Stream interface

// Remember that the lambda expressions you write should avoid mutating their outside scope.
// Sometimes, mutating outside the state is called conducting side-effects

enum Color {
    RED, BLUE, WHITE, YELLOW
}

enum Engine {
    ELECTRIC, HYBRID, GAS
}

enum Drive {
    WD2, WD4
}

interface Vehicle {}

record Car(Color color, Engine engine, Drive drive, int passegners) implements Vehicle {}

record Truck(Engine engine, Drive drive, int weight) implements Vehicle {}

record Author(String name) implements Comparable<Author>{

    @Override
    public int compareTo(Author o) {
        return this.name.compareTo(o.name);
    }
}
record Article(String title, int inceptionYear, List<Author> authors) {}
record PairOfAuthors(Author first, Author second) {
    public static Optional<PairOfAuthors> of(Author first, Author second) {
        if (first.compareTo(second) > 0) {
            return Optional.of(new PairOfAuthors(first, second));
        } else {
            return Optional.empty();
        }
    }
}




public class StreamExample {
    public static void main(String[] args) {

        System.out.println("----------------Example 1: Debugs stream-----------------------");
        List<String> stringExample1 = List.of("one", "two", "three", "four");
        List<String> result = stringExample1.stream().peek(s -> System.out.println("Starting with = " + s))
                .filter(s -> s.startsWith("t"))
                .peek(s -> System.out.println("Filtered = " + s))
                .map(String::toUpperCase)
                .peek(s -> System.out.println("Mapped = " + s))
                .collect(Collectors.toList());
        System.out.println("Result = " + result);

        System.out.println("----------------Example 2: Creating stream from a supplier-----------------------");
        Stream<String> generated = Stream.generate(() -> "+");
        List<String> stringExample2 = generated.limit(10).collect(Collectors.toList());
        System.out.println("String is: " + stringExample2);

        System.out.println("----------------Example 3.1: Creating stream from a UnaryOperator and a Seed-----------------------");
        Stream<String> iterated = Stream.iterate("+", s -> s + "+");
        iterated.limit(5L).forEach(System.out::println);

        System.out.println("----------------Example 3.2: Creating stream from a UnaryOperator, a Seed and a Predicate-----------------------");
        Stream<String> iteratedWithPredicate = Stream.iterate("+", s -> s.length() < 5, s -> s + "+");
        iteratedWithPredicate.forEach(System.out::println);

        System.out.println("----------------Example 4: Creating stream from a Range-----------------------");
        String[] letters = {"A", "B", "C", "D"};
        List<String> listLetters = IntStream.range(0, 10).mapToObj(index -> letters[index % letters.length]).collect(Collectors.toList());
        System.out.println("List Letters: " + listLetters);

        System.out.println("----------------Example 5: Random to generate a stream-----------------------");
        // Randomly create a stream of 50% A, 30% B, 10% C and 10% D
        Random random = new Random(314L);
        List<String> randomLetters = random.doubles(100_000L, 0d, 1d).mapToObj(
                rand ->
                        rand < 0.5 ? "A":
                                rand < 0.8 ? "B":
                                        rand < 0.9 ? "C": "D"
        ).collect(Collectors.toList());
        Map<String, Long> map = randomLetters.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.forEach((letter, number) -> System.out.println(letter + ":: " + number));

        System.out.println("----------------Example 6: Reduce-----------------------");
        Stream<String> stringExample6 = Stream.of("one", "two", "three", "four");
        Function<String, Integer> mapperExample6 = String::length;
        BinaryOperator<Integer> combiner = Integer::sum;
        BiFunction<Integer, String, Integer> accumulator = (partialReduction, element) -> partialReduction + mapperExample6.apply(element);
        int resultExample6 = stringExample6.reduce(0, accumulator, combiner);
        System.out.println("sum = " + resultExample6);

        System.out.println("----------------Example 7: Reduce-----------------------");
        List<String> stringExample7 = List.of("one", "two", "three", "four", "five", "six", "seven");
        String resultExample7 = stringExample7.stream()
                .unordered()
                .parallel()
                .filter(s -> s.length() == 3)
                .findFirst()
                .orElseThrow();
        System.out.println("first = " + resultExample7);

        System.out.println("----------------Example 8: Reduce-----------------------");
        List<String> stringExample8 = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
        boolean notBlank = stringExample8.stream().allMatch(Predicate.not(String::isBlank));
        boolean oneGT3 = stringExample8.stream().anyMatch(s -> s.length() > 3);
        boolean allLT10 = stringExample8.stream().noneMatch(s -> s.length() > 10);
        System.out.println("noBlank = " + notBlank);
        System.out.println("oneGT3 = " + oneGT3);
        System.out.println("allLT10 = " + allLT10);

        System.out.println("----------------Example 9: Partition-----------------------");
        List<String> stringExample9 = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
        Map<Boolean, List<String>> mapExample9 = stringExample9.stream().collect(Collectors.partitioningBy(s -> s.length() > 4));
        mapExample9.forEach((key, value) -> System.out.println(key + ":: " + value));

        System.out.println("----------------Example 10: Grouping-----------------------");
        List<String> stringExample10 = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        Map<Integer, List<String>> mapExample101 = stringExample10.stream().collect(Collectors.groupingBy(String::length));
        mapExample101.forEach((key, value) -> System.out.println(key + ":: " + value));

        Map<Integer, Long> mapExample102 = stringExample10.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        mapExample102.forEach((key, value) -> System.out.println(key + ":: " + value));

        Map<Integer, String> mapExample103 = stringExample10.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(", ")));
        mapExample103.forEach((key, value) -> System.out.println(key + ":: " + value));
        System.out.println('\n');

        Map<Integer, String> mapExample104 = stringExample10.stream()
                .collect(
                        Collectors.toMap(
                                String::length,
                                element -> element,
                                (element1, element2) -> element1 + " >> " + element2));
        mapExample104.forEach((key, value) -> System.out.println(key + ":: " + value));

        System.out.println("----------------Example 11: collectingAndThen method-----------------------");
        List<String> stringExample11 = List.of("two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve");
        Function<Map<Integer, Long>, Map.Entry<Integer, Long>> mapper = mapExample -> mapExample.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
        Map.Entry<Integer, Long> maxValue = stringExample11.stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.groupingBy(
                                        String::length,
                                        Collectors.counting()),
                                mapper
                        ));
        System.out.println("maxValue: " + maxValue);

        System.out.println("----------------Example 12: teeing method-----------------------");
        List<Vehicle> vehicles = new ArrayList<>(List.of(
                new Truck(Engine.ELECTRIC, Drive.WD2, 2000),
                new Car(Color.RED, Engine.ELECTRIC, Drive.WD2, 5),
                new Car(Color.BLUE, Engine.HYBRID, Drive.WD4, 3)
                ));
        List<Vehicle> electricVehicle = vehicles.stream()
                .collect(
                        Collectors.teeing( // merge two results
                                Collectors.filtering(
                                        vehicle -> vehicle instanceof Car car && car.engine() == Engine.ELECTRIC,
                                        Collectors.toList()
                                ),
                                Collectors.filtering(
                                        vehicle -> vehicle instanceof Truck truck && truck.engine() == Engine.ELECTRIC,
                                        Collectors.toList()
                                ),
                                (cars, trucks) -> {
                                    cars.addAll(trucks);
                                    return cars;
                                }
                        )
                );
        System.out.println(electricVehicle);

        System.out.println("----------------Example 13: PairOfAuthor Example-----------------------");
        List<Article> articles = List.of(
                new Article("ABC", 2000, List.of(new Author("trinhlk2"), new Author("beez"))),
                new Article("DEF", 2001, List.of(new Author("john"), new Author("tony"))),
                new Article("XYZ", 2020, List.of(new Author("alex"), new Author("smith"))),
                new Article("XYZ", 2020, List.of(new Author("trinhlk2"), new Author("truonglk")))
        );
        BiFunction<Article, Author, Stream<PairOfAuthors>> buildPairOfAuthors =
                (article, firstAuthor) ->
                        article.authors().stream().flatMap(
                                secondAuthor -> PairOfAuthors.of(firstAuthor, secondAuthor).stream());  // return Optional<PairOfAuthor>, need flatMap

        Function<Article, Stream<PairOfAuthors>> toPairOfAuthors =
                article -> article.authors().stream().flatMap(firstAuthor -> buildPairOfAuthors.apply(article, firstAuthor));

        Stream<PairOfAuthors> pairsOfAuthors = articles.stream().flatMap(toPairOfAuthors);

        Map<PairOfAuthors, Long> numberOfAuthorsTogether =
                articles.stream()
                        .flatMap(toPairOfAuthors)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        ));

        Function<Map<PairOfAuthors, Long>, Map.Entry<PairOfAuthors, Long>> maxExtractor =
                mapExample13 -> mapExample13.entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .orElseThrow();

        System.out.println("Number of author together: " + numberOfAuthorsTogether);
    }
}
