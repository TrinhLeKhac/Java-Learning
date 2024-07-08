package stream;

// Serialization is used to convert an object into a stream of the byte.
// The byte stream consists of the data of the instance as well as the type of data stored in that instance.
// Deserialization performs exactly opposite operation. It converts the byte sequence into original object data

// Serializable is a marker interface (has no data member and method). It is used to "mark" Java classes
// The Serializable interface must be implemented by the class whose object needs to be persisted.
// The String class and all the wrapper classes implement the java.io.Serializable interface by default.

// The ObjectOutputStream class is used to write primitive data types, and Java objects to an OutputStream.
// Only objects that support the java.io.Serializable interface can be written to streams.

// An ObjectInputStream deserializes objects and primitive data written using an ObjectOutputStream

// If there is any static data member in a class, it will not be serialized because static is the part of class not object.
// In case of array or collection, all the objects of array or collection must be serializable.
// If any object is not serializable, serialization will be failed.

// If you don't want to serialize any data member of a class, you can mark it as transient
// If you deserialize the object, you will get the default value for transient variable.

import java.io.*;

class Person implements Serializable {
    int id;
    String name;
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Student extends Person {
    int fee;
    String course;
    public Student(int id, String name, String course, int fee) {
        super(id, name);
        this.course = course;
        this.fee = fee;
    }
}

public class Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Create object
        Student std1 = new Student(211, "trinhlk2", "enginner", 50000);

        // Creating stream and writing the object
        // try-with-resources
        try(
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/stream/serialization.txt"));
        ) {
            out.writeObject(std1);
            out.flush();
        } catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("Success");

        // Creating stream to read the object
        // try-with-resources
        try(
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/stream/serialization.txt"));
        ) {
            Student s = (Student) in.readObject();
            // Printing the data of the serialized object
            System.out.println("(" + s.id + ", " + s.name + ", " + s.course + ", " + s.fee + ")");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
