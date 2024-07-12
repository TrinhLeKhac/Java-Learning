package collection;

// HashSet stores the elements by using a mechanism called hashing.
// contains unique elements only
// allows null value
// is non synchronized
// doesn't maintain the insertion order. Here, elements are inserted on the basis of their hashcode
// HashSet is the best approach for search operations
// The initial default capacity of HashSet is 16 and the load factor is 0.75

// ------------------------------------------------------------------------------

// LinkedHashSet contains unique elements only like HashSet
// It permits null elements
// is non-synchronized
// maintains insertion order

// ------------------------------------------------------------------------------

// SortedSet is an interface that extends the Set interface
// and provides additional operations for handling elements in a sorted order

// Key Characteristics:
// The elements are maintained in ascending order
// It doesn't permit null elements
// It provides method to get a comparator (comparator), view subsets (subSet), headSet, tailSet, first, last

// ------------------------------------------------------------------------------

// NavigableSet is an interface that extends SortedSet
// and provides navigation methods to traverse the set in a more flexible manner
// Key Characteristics:
// It provides methods for closest matches (ceiling, floor, higher, lower)
// It supports reverse order view (descendingSet)
// It provides methods to retrieve and remove the first and last elements (pollFirst, pollLast)
// It allows to create sub-set with range views (subSet, headSet, tailSet) including or excluding endpoints

// ------------------------------------------------------------------------------

// TreeSet is being implemented using a binary search tree, which is self-balancing
// Therefore, operations such as a search, remove, and add consume O(log(N)) time
// Tt is one of the efficient data structures in order to keep the large data that is sorted and also to do operations on it.

// TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable
// It maintains elements in a sorted order based on their natural ordering or by a provided comparator

// When you need a set with sorting and advanced navigation capabilities, use TreeSet.
// If you need more flexibility and are working with custom implementations, you might use NavigableSet or SortedSet interfaces.

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetExample {
    public static void main(String[] args) {
        System.out.println("----------------Example 1: HashSet-----------------------");

        HashSet<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Tomatoes");
        System.out.println("An initial list of elements: " + set);

        //Removing specific element from HashSet
        set.remove("Tomatoes");
        System.out.println("After invoking remove(object) method: " + set);

        HashSet<String> set1 = new HashSet<>();
        set1.add("Kiwi");
        set1.add("Blueberry");
        set.addAll(set1);
        System.out.println("Updated list: " + set);

        //Removing all the new elements from HashSet
        set.removeAll(set1);
        System.out.println("After invoking removeAll() method: " + set);

        //Removing elements on the basis of specified condition
        set.removeIf(str -> str.contains("Banana"));
        System.out.println("After invoking removeIf() method: " + set);

        //Removing all the elements available in the set
        set.clear();
        System.out.println("After invoking clear() method: " + set);

        System.out.println("----------------Example 2: HashSet-----------------------");
        TreeSet<String> setDemo = new TreeSet<>();
        setDemo.add("A");
        setDemo.add("B");
        setDemo.add("C");
        setDemo.add("D");
        setDemo.add("E");
        System.out.println("Initial set is: " + setDemo);
        System.out.println("Reverse set is: " + setDemo.descendingSet());
        System.out.println("Head set of element is: " + setDemo.headSet("C", true)); // inclusive = true
        System.out.println("Subset of element is: " + setDemo.subSet("A", false, "D", true));
        System.out.println("Tail set of element is: " + setDemo.tailSet("B", false));
    }
}
