package collection;

import java.util.*;

class Range implements Iterable<Integer> {

    private final int start;
    private final int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = start;
            @Override
            public boolean hasNext() {
                return index < end;
            }

            @Override
            public Integer next() {
                if (index >= end) {
                    throw new NoSuchElementException("No such element at index: " + index);
                }
                int currentIndex = index;
                index++;
                return currentIndex;
            }
        };
    }
}
public class RangeExample {
    public static void main(String[] args) {
        Iterable<Integer> range = new Range(1, 5);
        for (Integer i: range) {
            System.out.println(i);
        }
        SortedSet<String> strings = new TreeSet<>(Set.of("A", "B", "C", "D", "E"));
        SortedSet<String> subSet = strings.subSet("B", "D");
        System.out.println(subSet);

        NavigableSet<String> sortedStrings = new TreeSet<>(Set.of("A", "B", "C", "D", "E"));
        System.out.println(sortedStrings.descendingSet());

        List<String> stringExample1 = Arrays.asList("one", "two", "three"); // The same behavior as native array
        List<String> stringExampleResult1 = Collections.unmodifiableList(stringExample1);  // immutable
//        stringExampleResult1.add("four");  // not allowed
//        stringExampleResult1.set(0, "four");  // not allowed

        List<String> stringExample2 = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> stringExampleResult2 = Collections.unmodifiableList(stringExample2);  // immutable
//        stringExampleResult2.add("four");  // not allowed
//        stringExampleResult2.set(0, "four");  // not allowed

        System.out.println("when adding element to mutable collection => it also add element to immutable collection");
        stringExample2.add("four");
        System.out.println(stringExampleResult2);
    }
}
