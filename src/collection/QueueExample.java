package collection;

// The interface Queue is available in the java.util package and does extend the Collection interface.
// It is used to keep the elements that are processed in the First In First Out (FIFO) manner.

// The elements in PriorityQueue must be of Comparable type

// some methods:
// add, remove, poll, element, peek, peekFirst, peekLast, offer, offerFirst, offerLast

import java.util.PriorityQueue;
import java.util.Queue;

class Book implements Comparable<Book> {
    int id;
    String name, author, publisher;
    int quantity;
    public Book (int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Book b) {
        if (this.id > b.id) {
            return 1;
        } else if (this.id < b.id) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class QueueExample {
    public static void main(String[] args) {
        Queue<Book> queue = new PriorityQueue<>();

        // Creating books
        Book b1 = new Book(222, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(111, "Operating System", "Galvin", "Wiley", 6);
        Book b3 = new Book(333, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);

        // Adding books to the queue
        queue.add(b1);
        queue.add(b2);
        queue.add(b3);

        System.out.println("Traversing the queue elements:");
        for (Book b: queue) {
            System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
        }
        queue.remove(); // remove head, poll,

        System.out.println("After removing one book record:");
        for(Book b:queue){
            System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
        }
    }

}
