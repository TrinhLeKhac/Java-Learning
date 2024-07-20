package collection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Polymorphism - the method that is called is based on the runtime type of a REFERENCE
// rather than the compile time type of the REFERENCE of the receiver
// It does not consider the type of the PARAMETERS at runtime. That is resolve at compile time.


record Year(int year) {

    // In a record, you can define a compact constructor without explicitly specifying parameter lists,
    // as the parameters are inferred from the record components
    // Compact constructor allows you to execute logic before the record instance is fully initialized.

    Year {
        // Validate or transform can be placed here
        if (year < 0) {
            throw new RuntimeException("year should not be negative");
        }
        if (year < 100) {
            year = 2000 + year;
        }
        // Additional logic could be placed here
        System.out.println("Year: " + year);
    }
    // Other methods, if necessary, can be added here
}

public class SomeExampleCode {

    public static int transform(int number) {
        System.out.println("transform: " + Thread.currentThread());
        return number * 2;
    }

    public static void print(int number) {
        System.out.println("print: " + Thread.currentThread());
    }

    public static void main(String[] args) {

        System.out.println("----------------Example 1-----------------------");

//        listNumber is a reference of type ArrayList<Integer>
//        List<Integer> listNumber = new ArrayList<>(Arrays.asList(1, 2, 3));

//        listNumber is a reference of type ArrayList<Integer>
        var numberInListDemo1 = new ArrayList<>(Arrays.asList(1, 2, 3));
//        listNumber.remove((Object) 1);
        numberInListDemo1.remove(1);
        System.out.println(numberInListDemo1);

//        listNumber is a reference of type Collection<Integer>
        Collection<Integer> numberInCollectionDemo1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        numberInCollectionDemo1.remove(1);
        System.out.println(numberInCollectionDemo1);
        System.out.println('\n');

        System.out.println("----------------Example 2-----------------------");
        List<Integer> numberInListDemo2 = new ArrayList<>(Arrays.asList(1, 2, 3));

        // Set.of, Map.of, List.of (immutable)
        // doesn't contains null values
//        List<Integer> numbers = List.of(1, 2, 3);

        System.out.println(numberInListDemo2.getClass());

        try {
            numberInListDemo2.add(4);
        } catch (Exception ex) {
            System.out.println("Add unsupported");
        }

        try {
            numberInListDemo2.set(2, 2);
        } catch (Exception exc) {
            System.out.println("Set unsupported");
        }
        System.out.println('\n');

        System.out.println("----------------Example 3-----------------------");
        List<String> nameInListDemo3 = List.of("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");
        System.out.println(nameInListDemo3.getClass());

        List<String> nameInListUpperCaseDemo31 = new ArrayList<>();
        nameInListDemo3.stream().map(String::toUpperCase).forEach(nameInListUpperCaseDemo31::add);  // DON'T DO THIS
        // mutation is OK
        // sharing is a good thing
        // shared mutability is devils work

        List<String> nameInListUpperCaseDemo32 = nameInListDemo3.stream().map(String::toUpperCase).toList();

        System.out.println(nameInListDemo3.size());
        System.out.println(nameInListUpperCaseDemo31.size());
        System.out.println(nameInListUpperCaseDemo32.size());

        System.out.println("----------------Example 4-----------------------");
        // Functional programming relies on lazy evaluation for efficiency
        // Lazy evaluation relies on purity of functions for correctness

        int[] factorListDemo4 = new int[]{2};
        var numberInListDemo4 = List.of(1, 2, 3);
        var streamDemo4 = numberInListDemo4.stream().map(number -> number * factorListDemo4[0]);
        factorListDemo4[0] = 0;
        streamDemo4.forEach(System.out::println);
        System.out.println('\n');

        System.out.println("----------------Example 5-----------------------");

        // Need to make sure that lambdas are pure
        // Rules for purity
        // 1. the function does not make any change that is visible outside
        // 2. the function does not depend on anything that may change from the outside

        List.of(1, 2, 3).parallelStream().map(SomeExampleCode::transform).sequential().forEach(SomeExampleCode::print);

        System.out.println('\n');

        System.out.println("----------------Example 6-----------------------");
        var numberDemo6 = List.of(1, 2, 3);
        var doubledDemo6 = numberDemo6.stream().map(e -> e * 2).collect(Collectors.toList());  // mutable
//                .collect(Collectors.toUnmodifiableList());  // immutable
//                .toList()  // immutable

        System.out.println(doubledDemo6);
        System.out.println(doubledDemo6.getClass());

        System.out.println("----------------Example 7-----------------------");
        System.out.println(new Year(23));
        System.out.println(new Year(2024));

        System.out.println("----------------Example 8-----------------------");
        String[] stringArray = {"one", "two", "three"};
        var stringList = Arrays.asList(stringArray);

        int[] intArray = {1, 2, 3};
//        List<int[]> intList = Arrays.asList(intArray);
        var intList = Arrays.asList(intArray);

        System.out.print(stringList.contains("one") + ", ");
        System.out.print(intList.contains(1));
        System.out.print('\n');

        System.out.println("----------------Example 9-----------------------");
        var ints = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        var subList = ints.subList(0, 0);
        System.out.println(subList);
        subList.addAll(List.of(10, 11, 12));
        System.out.println(ints);

        System.out.println("----------------Example 10-----------------------");
        String[] ss = {"a", "b", "c", null};

//        var strings1 = Stream.of(ss).toList();
//        System.out.println(strings1.size());
//
//        var strings2 = List.of(ss);
//        System.out.println(strings2.size());
//
//        var strings3 = Arrays.asList(ss);
//        strings3.removeIf(Objects::isNull);
//        System.out.println(strings3);

        Map<Integer, String> map = new HashMap<>();
        map.put(4, null);
        System.out.println(map.getOrDefault(4, "four"));
        map.putIfAbsent(4, "four");
        System.out.println(map.get(4));

        var numbers = List.of(-1, 0, 1);
//        Map<Integer, List<Integer>> map2 = new HashMap<>();
//        numbers.forEach(
//                number -> map2.computeIfAbsent(number, initialCapacity -> new ArrayList<Integer>(initialCapacity)) // ArrayList::new
//                        .add(number));
//        System.out.println(map.get(0));

        System.out.println("----------------Example 11-----------------------");
        Set<String> hashSet = new HashSet<>(List.of("a", "b", "c"));
        Set<String> treeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        treeSet.addAll(List.of("A", "B", "C"));
        System.out.println(treeSet.equals(hashSet));
        System.out.println(hashSet.equals(treeSet));

        System.out.println("----------------Example 12-----------------------");
        var map3 = new IdentityHashMap<Integer, String>();
        map3.put(1, "one");
        map3.put(10, "ten");
        map3.put(1, "one again");
        map3.put(10, "ten again");
        System.out.println(map3.size());
    }
}
