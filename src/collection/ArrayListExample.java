package collection;

// Java ArrayList class uses a dynamic array for storing the elements.
// It is like an array, but there is no size limit. We can add or remove elements anytime.
// So, it is much more flexible than the traditional array

// ArrayList class can contain duplicate elements.
// ArrayList class maintains insertion order.
// ArrayList class is non synchronized.
// Java ArrayList allows random access because the array works on an index basis.
// In ArrayList, manipulation is a little bit slower than the LinkedList
// because a lot of shifting needs to occur if any element is removed or added from the array list.

// We can not create an array list of the primitive types, such as int, float, char, etc.
// t is required to use the required wrapper class in such cases.

// public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable

// legacy: ArrayList list = new ArrayList();  // creating old non-generic arraylist (non-generic before JDK 1.5)
// ArrayList<String> list = new ArrayList<String>(); //creating new generic arraylist

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.*;

class Student implements Serializable{
    int rollno;
    String name;
    int age;
    Student(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "(" + this.name + ", " + this.age + ", " + this.rollno + ")";
    }
}

public class ArrayListExample {
    public static void main(String[] args) {

        System.out.println("----------------Example 1: Print ArrayList-----------------------");
        List<String> list1 = new ArrayList<>();
        list1.add("Mango");
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Grapes");
        System.out.println(list1);
        System.out.println('\n');

        System.out.println("----------------Example 2: Traversing ArrayList through for loop-----------------------");
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        System.out.println('\n');

        System.out.println("----------------Example 3: Traversing ArrayList through for-each loop-----------------------");
        for (String fruit: list1) {
            System.out.println(fruit);
        }
        System.out.println('\n');

        System.out.println("----------------Example 4: Traversing ArrayList through iterator-----------------------");
        Iterator it = list1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println('\n');

        System.out.println("----------------Example 5: Traversing ArrayList through forEach method (Java 8)-----------------------");
//        list1.forEach(System.out::println);
        list1.forEach(a -> {
            System.out.println(a);
        });
        System.out.println('\n');

        System.out.println("----------------Example 6: Traversing ArrayList through listIterator-----------------------");
        ListIterator<String> listIter = list1.listIterator(list1.size());
        while (listIter.hasNext()) {
            System.out.println(listIter.next());
        }
        System.out.println('\n');

        System.out.println("----------------Example 7: Traversing ArrayList through listIterator(reverse)-----------------------");
        while (listIter.hasPrevious()) {
            System.out.println(listIter.previous());
        }
        System.out.println('\n');

        System.out.println("----------------Example 8: get/set element in ArrayList-----------------------");
        System.out.println("Element at index 1 is: " + list1.get(1));
        // change the element
        list1.set(1, "Tomatoes");
        for (String fruit: list1) {
            System.out.println(fruit);
        }
        System.out.println('\n');

        System.out.println("----------------Example 9: Sort ArrayList-----------------------");
        Collections.sort(list1);
        for (String fruit: list1) {
            System.out.println(fruit);
        }
        System.out.println('\n');

        System.out.println("----------------Example 10: ArrayList of object-----------------------");
        Student s1 = new Student(101, "Blade", 22);
        Student s2 = new Student(102, "Carnal", 21);
        Student s3 = new Student(103, "Daddy", 20);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        Iterator studentIter = students.iterator();
        while (studentIter.hasNext()) {
            Student s = (Student) studentIter.next();
            System.out.println(s.rollno + " " + s.name + " " + s.age);
        }

        System.out.println("----------------Example 11: Serialize and Deserialize ArrayList of Object-----------------------");
        try (
            FileOutputStream fos = new FileOutputStream("src/data/student");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        ){
            // Serialization
            oos.writeObject(students);

            // Deserialization
            FileInputStream fis = new FileInputStream("src/data/student");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Student> deserializedList = (ArrayList<Student>) ois.readObject();
            System.out.println(deserializedList);

        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
