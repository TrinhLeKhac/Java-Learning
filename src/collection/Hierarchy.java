package collection;

// Framework
// It provides readymade architecture.
// It represents a set of classes and interfaces.

// Hierarchy of Collection Framework
// The java.util package contains all the classes and interfaces for the Collection framework.

// Iterable >> Collection >> {List, Queue, Set}
// List >> {ArrayList, LinkedList, Vector}, Vector >> Stack
// Queue >> {PriorityQueue, Deque}, Deque >> {LinkedList, ArrayQueue}
// Set >> {HashSet, LinkedHashSet, SortedSet}, SortedSet >> TreeSet

// common methods of Collection Framework

// public boolean add(E e)
// public boolean addAll(Collection <? extends E> c)

// public remove(Object element)
// public removeAll(Collection<?> c)

// default boolean removeIf(Predicate<? super E> filter)
// public boolean retainALl(Collection <?> c)

// public int size()
// public void clear()

// public boolean contains(Object e)
// public boolean containsAll(Collection<?> c)

// public Iterator iterator()
// public Object[] toArray()
// public <T> T[] toArray(T[] a): it converts into array with type of the specified array

// public boolean isEmpty()

// default Stream<E> parallelStream()
// default Stream<E> stream()
// default Spliterator<E> spliterator()

// public boolean equals(Object e)
// public int hashCode()

// Iterator interface
// three methods
// public boolean hasNext()
// public Object next()
// public void remove() // It removes the last elements returned by the iterator. It is less used

// Iterable interface is the root interface for all the collection classes
// The Collection interface extends the Iterable interface
// and therefore all the subclasses of Collection interface also implement the Iterable interface.
// Iterator <T> iterator()

// Collection interface
// methods: add, addAll, clear, isEmpty

// List interface
// It is implemented by the classes ArrayList, LinkedList, Vector, and Stack.
// List <data-type> list1 = new ArrayList();
// List <data-type> list2 = new LinkedList();
// List <data-type> list3 = new Vector();
// List <data-type> list4 = new Stack();


// ArrayList
// It uses a dynamic array to store the duplicate element of different data types
// It maintains the insertion order and is non-synchronized
// The elements stored in the ArrayList class can be randomly accessed

// Queue
// The PriorityQueue class implements the Queue interface. It holds the elements or objects which are to be processed by their priorities.
// PriorityQueue doesn't allow null values to be stored in the queue.

// In Deque, we can remove and add the elements from both the side
// Deque can be instantiated as (ArrayDeque class implements the Deque interface):
// Deque d = new ArrayDeque()

// It facilitates us to use the Deque.
// ArrayDeque is faster than ArrayList and Stack and has no capacity restrictions

// Set Interface
//  It represents the unordered set of elements which doesn't allow us to store the duplicate items.
//  We can store at most one null value in Set.
//  It is implemented by HashSet, LinkedHashSet, and TreeSet.

// HashSet
// It represents the collection that uses a hash table for storage.
// Hashing is used to store the elements in the HashSet. It contains unique items.

// LinkedHash Set
// It extends the HashSet class and implements Set interface.
// Like HashSet, It also contains unique elements.
// It maintains the insertion order and permits null elements.

import java.util.*;

public class Hierarchy {
    public static void listExample() {
        List<String> arrList = new ArrayList<>();  // also the same for LinkedList, Vector
        arrList.add("One");
        arrList.add("Two");
        arrList.add("Three");

        Iterator<String> iter = arrList.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static void stackExample() {
        Stack<String> stack = new Stack<>(); // not using List<String>
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        Iterator<String> iter = stack.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static void priorityQueueExample() {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("One");
        queue.add("Two");
        queue.add("Three");
        queue.add("Four");
        System.out.println("The first element is: " + queue.element());
        System.out.println("The first element is: " + queue.peek());

        Iterator<String> iter = queue.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("Removing elements from queue...");
        queue.remove();
        queue.poll();

        System.out.println("After removing element from queue");
        Iterator<String> iter2 = queue.iterator();
        while(iter2.hasNext()) {
            System.out.println(iter2.next());
        }
    }

    public static void dequeExample() {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("One");
        deque.add("Two");
        deque.add("Three");
        for (String str: deque) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        System.out.println("----------------List Example-----------------------");
        listExample();
        System.out.println("----------------Stack Example-----------------------");
        stackExample();
        System.out.println("----------------Queue Example-----------------------");
        priorityQueueExample();
        System.out.println("----------------Deque Example-----------------------");
        dequeExample();
    }
}
