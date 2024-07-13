package collection;

// There are two interfaces for implementing Map in java: Map and SortedMap,
// and three classes: HashMap, LinkedHashMap, and TreeMap
// LinkedHashMap maintains insertion order
// TreeMap maintains ascending order

// A Map can't be traversed, so you need to convert it into Set using keySet() or entrySet() method.

// public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable
// constructor:
// 1) HashMap(int capacity)
// 2) HashMap(int capacity, float loadFactor)
// 3) HashMap(Map<? extends K, ? extends V> m)

// methods:
// clear, isEmpty
// keySet, entrySet
// V put(Object key, Object value), V putIfAbsent(K key, V value)
// void putAll(Map m)
// V remove(Object key)
// boolean remove(Object key, Object value)
// V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
// boolean containsKey(Object key), containsValue(Object value)
// void forEach(BiConsumer<? super K, ? super V> action)
// V get(Object key), V getOrDefault(Object key, V defaultValue)
// V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)
// Collection<V> values()
// int size()

// HashSet contains only values whereas HashMap contains an entry(key and value)

// Working of HashMap in Java
// Node<K,V> contains (int hash, K key, V value, Node<K,V> next)
// Insert pair (key, value) to HashMap
// The default capacity of HashMap is n = 16
// int hash = hashcode(key)
// int index = hash & (n - 1)
// Add elements in bucket (capacity = 16) at index position


// TreeMap class is a red-black based implementation. It provides an efficient means of storing key-value pairs in sorted order
// Its contains values based on the key
// Its contains only unique elements
// Its maintains ascending order
// Its non-synchronized
// can not have a null key but can have multiple null values

// Some methods
// Map.Entry<K,V> ceilingEntry(K key)
// returns the key-value pairs having the least key,
// greater than or equal to the specified key, or null if there is no such key

// Similar: Map.Entry<K,V> floorEntry(K key), lowerEntry(K key), higherEntry(K key)

// Map.Entry<K,V> pollFirstEntry(), pollLastEntry()

// K ceilingKey(K key), floorKey(K key), lowerKey(K key), higherKey(K key)

// Comparator<? super K> comparator()
// NavigableSet<K> descendingKeySet()
// NavigableMap<K, V> descendingMap()


import java.util.*;

public class MapExample {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "abc");
        map.put(2, "cde");
        map.put(3, "xyz");

        System.out.println("----------------Example 1: Traversing the map using keySet-----------------------");
        Set<Integer> setInteger = map.keySet();
        for (Integer item: setInteger) {
            System.out.println(item);
        }
        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());
        System.out.println('\n');

        System.out.println("----------------Example 2: Traversing the map using entrySet-----------------------");
        Set<Map.Entry<Integer, String>> setEntry = map.entrySet();
        for (Map.Entry<Integer, String> entry : setEntry) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("All entries: " + map.entrySet());
        System.out.println('\n');

        System.out.println("----------------Example 3: Traversing the map using functional style-----------------------");
        // Set view of the mappings
        map.entrySet()
        // Sequential Stream
        .stream()
        // Sorted according to the provided Comparator
        .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
        // Performs an action for each element of this stream
        .forEach(System.out::println);
        System.out.println('\n');

        System.out.println("----------------Example 4: Using putAll methods example-----------------------");
        map.putIfAbsent(5, "zzz");
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(4, "ooo");
        map2.putAll(map);
        for (Map.Entry<Integer, String> entry: map2.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println('\n');

        System.out.println("----------------Example 5: TreeMap methods-----------------------");
        NavigableMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(100, "Amit");
        treeMap.put(101, "Jane");
        treeMap.put(102, "Burden");
        treeMap.put(103, "Simpson");
        System.out.println("descendingMap: " + treeMap.descendingMap());
        System.out.println("headMap: " + treeMap.headMap(102, true));
        System.out.println("tailMap: " + treeMap.tailMap(102, true));
        System.out.println('\n');
    }
}
