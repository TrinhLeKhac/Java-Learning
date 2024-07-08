package hash;
// Search in arbitrary array take O(n)
// Search in sorted array take 0(logn) (binary search)
// Search in array such as {4, 1, 3, 6} which arrange with index {null, 1, null, 3, 4, null, 6} take O(1)
// (Jump directed into index to get values)

// In case array with large values (such as CardID 12 numbers)  ==> take a lot abundant memory

// Solution: hashing

// Method: hashing key
// index = h(key) = key % size
// Example -
// array {5, 1, 10, 26, 99}  ==> size = 10 ==> index {5, 1, 0, 6, 9} ==> {0, 1, null, null, null, 5, 6, null, null, 9}


// Hash table
// It is a generalized form of an array
// It stores the data in form of key-value pair
// It convert key to an index using hash function
// The primary operations -
// put(key, value)
// get(key)
// remove(key)

// Average running time is of O(1)
// Java Collections Framework -
// HashMap class - deal with key-value pair
// HashSet class - deal with only keys

// Collision Resolution Technique (Separate Chaining)
// key-value space: {(5, John), (1, Tom), (105, Mary)}
// size = 10  ==> (5, John) and (105, Mary) is collision
// Solution: Separate chaining (Linkedlist)
// index: 5 -> (5, John) -> (105, Mary)
// New structure HashNode(K key, V value, HashNode next)

// HashTable (HashNode[] buckets)

import java.util.NoSuchElementException;

public class HashTable {
    private final HashNode[] buckets;
    private final int numOfBuckets;  // capacity
    private int size;  // number of key value pairs in hash table or number of hash nodes

    public HashTable() {
        this(10);
    }

    public HashTable(int capacity) {
        this.numOfBuckets = capacity;
        this.size = 0;
        this.buckets = new HashNode[this.numOfBuckets];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getBucketIndex(Integer key) {
        return key % this.numOfBuckets; // bucket.length
    }

    public void put(Integer key, String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value is null!!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode current = this.buckets[bucketIndex];
        while (current != null) {
            if (current.key.equals(key)) { // if key in hashtable
                current.value = value;  // update value and return
                return;
            }
            current = current.next;
        }
        size++;
        current = this.buckets[bucketIndex];
        HashNode node = new HashNode(key, value);  // (key, value) -> null
        node.next = current;
        this.buckets[bucketIndex] = node;
    }

    public String get(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null!!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode current = this.buckets[bucketIndex];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public String remove1(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null!!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode current = this.buckets[bucketIndex];
        if (current.key.equals(key)) {
            this.buckets[bucketIndex] = current.next;
            return current.value;
        }
        HashNode previous = current;
        current = current.next;
        while (current != null) {
            if (current.key.equals(key)) {
                previous.next = current.next;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public String remove2(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null!!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode previous = null;
        HashNode current = this.buckets[bucketIndex];

        while (current != null) {
            if (current.key.equals(key)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        size--;
        if (previous != null) {
            previous.next = current.next;
        } else {
            this.buckets[bucketIndex] = current.next;
        }
        return current.value;
    }

    private static class HashNode {
        private Integer key;  // Can be generic type
        private String value;  // Can be generic type
        private HashNode next;  // Reference to next HashNode

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

    }
    public static void main(String[] args) {
        HashTable table = new HashTable(10);
        System.out.println("----------------Put element into HashTable and check size-----------------------");
        table.put(105, "Tom");
        table.put(21, "Sana");
        table.put(21, "Harry");
        table.put(11, "Beez");
        table.put(1, "Beo");
        System.out.println("Size of hash table: " + table.size());
        System.out.println("----------------Get value from key in HashTable-----------------------");
        System.out.println(table.get(105));
        System.out.println(table.get(41));
        System.out.println("----------------Remove key from HashTable-----------------------");

        int key1 = 21;
        String removeVal1 = table.remove2(key1);
        System.out.println("Value from remove key: " + key1 + " is: " + removeVal1);

        int key2 = 11;
        String removeVal2 = table.remove2(key2);
        System.out.println("Value from remove key: " + key2 + " is: " + removeVal2);

        int key3 = 1;
        String removeVal3 = table.remove2(key3);
        System.out.println("Value from remove key: " + key3 + " is: " + removeVal3);
    }
}
