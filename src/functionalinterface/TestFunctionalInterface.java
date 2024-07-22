package functionalinterface;

// Starting with Java SE 8, concrete methods are allowed in interfaces.
// They can be instance methods, in that case, they are called default methods,
// and they can be static methods

// There is a restriction on the type of a lambda expression: it has to be a functional interface
// Functional interface has only one abstract method

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FunctionalInterface
interface Runnable {
    public abstract void run();
}

@FunctionalInterface
interface Consumer<T> {
    void accept(T s);
    default void andThen(Consumer<? super T> after) {
        System.out.println("Implement andThen method");
    };
}

@FunctionalInterface
interface Predicate<T> {
    boolean test(T t);
}

@FunctionalInterface
interface IntSupplier {
    abstract int getAsInt();
}

@FunctionalInterface
interface BiPredicate<T, U> {
    boolean test(T t, U u);
}

@FunctionalInterface
interface Function<T, R> {
    R apply(T t);
}

public class TestFunctionalInterface {
    public static void main(String[] args) {
        System.out.println("----------------Example 1-----------------------");
        // Old way (anonymous class)
        Predicate<String> predicateOldWay = new Predicate<String>() { // remove name of interface because of duplication
            @Override
            public boolean test(String s) { // remove name of method (because we have only 1 abstract method)
                return s.length() == 3;
            } // remove name of method because of having only 1 abstract method
        };

        // Lambda expressions has type of function interface
//        Predicate<String> predicateLongWay = (String s) -> {
//            return s.length() == 3;
//        };

        // Short way
        Predicate<String> predicateShortWay = s -> s.length() == 3;

        List<String> strings = new ArrayList<>(List.of("ABC", "ABCD"));
        List<String> stringOfLength31 = new ArrayList<>();
        List<String> stringOfLength32 = new ArrayList<>();

        for(String s: strings) {
            if (predicateOldWay.test(s)) {
                stringOfLength31.add(s);
            }
        }
        for(String s: strings) {
            if (predicateShortWay.test(s)) {
                stringOfLength32.add(s);
            }
        }
        System.out.println(stringOfLength31);
        System.out.println(stringOfLength32);

        System.out.println("----------------Example 2-----------------------");

        Random random = new Random(1234);
        // Anonymous class
        IntSupplier oldRandom = new IntSupplier() {
            @Override
            public int getAsInt() {
                return random.nextInt();
            }
        };
//        IntSupplier newRandom1 = () -> random.nextInt();  // lambda expression
        IntSupplier newRandom2 = random::nextInt;  // short way
        for (int i = 0; i < 5; i ++) {
            int nextRandom = newRandom2.getAsInt();
            System.out.println("Next random: " + nextRandom);
        }

        System.out.println("----------------Example 3-----------------------");
        Consumer<String> printer = System.out::println;
        for (int i = 0; i < 5; i++) {
            int nextRandom = newRandom2.getAsInt();
            printer.accept("Next random: " + nextRandom);
        }

        System.out.println("----------------Example 4-----------------------");
        Predicate<String> isEvenLength = s -> s.length() % 2 == 0;
        List<String> immutableString = List.of("one", "two", "three", "four", "five");  // immutable
        List<String> results = new ArrayList<>(immutableString);  // mutable
        results.removeIf(isEvenLength::test);  // removeIf mutate this collection
        System.out.println(results);

        System.out.println("----------------Example 5-----------------------");
        BiPredicate<String, Integer> isOfLength = (word, length) -> word.length() == length;
        String word = "ABC";
        int length = 3;
        boolean isLengthOf3 = isOfLength.test(word, length);
        System.out.println(isLengthOf3);

        System.out.println("----------------Example 5-----------------------");
        Function<String ,Integer> toLength = String::length;
        String word2 = "ABCDE";
        int length2 = toLength.apply(word2);
        System.out.println(length2);

        // Sometimes you will be writing lambda expressions that are just calls to specific methods defined somewhere else
        // This is where the method reference syntax comes in.

        // User-defined Functional Interface (Consumer<String>)
        Consumer<String> printer2 = System.out::println;
        printer2.accept("Le Khac Trinh");

        // Functional Interface that is supplied by libs
        IntBinaryOperator maxDefined = Integer::max;
        System.out.println(maxDefined.applyAsInt(1, 2));

        System.out.println("----------------Example 6-----------------------");
        Predicate<String> p = s -> (s != null) && !s.isEmpty() && s.length() < 5;

        Predicate<String> notNull = Objects::nonNull;
        Predicate<String> notEmpty = s -> !s.isEmpty();
        Predicate<String> shorterThan5 = s -> s.length() < 5;

        System.out.println(p.test("ADC"));

        System.out.println("----------------Example 7-----------------------");
        Comparator<String> comparator = Comparator.comparing(String::length);
        Function<String, Integer> toLength2 = String::length;
        Comparator<String> comparator2 = (s1, s2) -> Integer.compare(toLength2.apply(s1), toLength2.apply(s2));
        Comparator<String> comparator3 = Comparator.comparingInt(toLength2::apply);

        String s71 = "ab";
        String s72 = "abc";

        if (comparator.compare(s71, s72) < 0) {
            System.out.println("The string " + s71 + " has length shorter than " + s72);
        } else if (comparator.compare(s71, s72) == 0) {
            System.out.println("The string " + s71 + " has length equal than " + s72);
        } else {
            System.out.println("The string " + s71 + " has length longer than " + s72);
        }

        if (comparator2.compare(s71, s72) < 0) {
            System.out.println("The string " + s71 + " has length shorter than " + s72);
        } else if (comparator2.compare(s71, s72) == 0) {
            System.out.println("The string " + s71 + " has length equal than " + s72);
        } else {
            System.out.println("The string " + s71 + " has length longer than " + s72);
        }

        if (comparator3.compare(s71, s72) < 0) {
            System.out.println("The string " + s71 + " has length shorter than " + s72);
        } else if (comparator3.compare(s71, s72) == 0) {
            System.out.println("The string " + s71 + " has length equal than " + s72);
        } else {
            System.out.println("The string " + s71 + " has length longer than " + s72);
        }

        System.out.println("----------------Example 8-----------------------");
        Comparator<String> byLengthThenAlphabetically = Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder());
        List<String> string8 = Arrays.asList("one", "two", "three", "four", "five");

        System.out.println(string8);

        string8.sort(byLengthThenAlphabetically);
        System.out.println(string8);

        string8.sort(byLengthThenAlphabetically.reversed());
        System.out.println(string8);

        System.out.println("----------------Example 9-----------------------");
        var rand = new Random(209);
        var ints = IntStream.range(0, 8).mapToObj(index -> rand.nextInt()).toList();
        var sorted = ints.stream().sorted(Comparator.comparingInt(i -> i)).toList();
        var sorted2 = ints.stream().sorted((i1, i2) -> i1 < i2 ? -1: i1 == i2 ? 0: 1).toList();
        System.out.println(ints);
        System.out.println(sorted);
        System.out.println(sorted2);
    }
}
