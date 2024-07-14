package features.java9;

// In Java 9, we can create private methods inside an interface.
// Interface allows us to declare private methods that help to share common code between non-abstract methods.
// We can also create private static methods inside an interface

// Java introduced try-with-resource feature in Java 7 that helps to close resource automatically after being used.
// In Java 7, try-with-resources has a limitation that requires resource to declare locally within its block.

// Java 9 introduced a new feature that allows us to use diamond operator with anonymous classes.
// Using the diamond with anonymous classes was not allowed in Java 7

// Static factory method for List, Set and Map interface.
// These methods are useful to create small number of collection.

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

interface SMT {
    default void say() {  // external
        saySomething();
        sayPolite();
    }
    private void saySomething() { // internal
        System.out.println("Hello.. I'm private method");
    }
    private static void sayPolite() {  // internal
        System.out.println("I'm private static method");
    }
}

abstract class ABCD<T> {
    abstract T show(T a, T b);
}

public class PrivateMethodInterface implements SMT{
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("----------------Example 1: Private Method Interfaces-----------------------");
        SMT s = new PrivateMethodInterface();
        s.say();
        System.out.println('\n');

        System.out.println("----------------Example 2: Try-with-resource in Java 9-----------------------");
        FileOutputStream fout = new FileOutputStream("src/features/java9/test.txt");  // resource can declare outside block
        try(fout) {
            String greeting = "Welcome to my house";
            byte[] b = greeting.getBytes();
            fout.write(b);
            System.out.println("File written");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println('\n');

        System.out.println("----------------Example 3: Diamond operator (<>) when using anonymous class-----------------------");
        ABCD<String> abcd = new ABCD<>() {  // Diamond operator <>
            @Override
            String show(String a, String b) {
                return a + b;
            }
        };
        String result = abcd.show("Java", " 9");
        System.out.println(result);

        System.out.println("----------------Example 4: Factory method-----------------------");
        System.out.println(">>> Old method");
        List<String> oldList = new ArrayList<>();
        oldList.add("Java");
        oldList.add("Spring");
        oldList.add("JavaFX");
        oldList.add("Hibernate");
        oldList.add("JSP");
        for (String item: oldList) {
            System.out.println(item);
        }

        System.out.println(">>> New method for List interface");
        List<String> newList = List.of("Java", "Spring", "JavaFX", "Hibernate", "JSP");
        for (String item: newList) {
            System.out.println(item);
        }

        System.out.println(">>> New method for Map interface V1");
        Map<Integer, String> newMap = Map.of(101, "JavaFX", 102, "Hibernate", 103, "Spring MVC");
        for (Map.Entry<Integer, String> entry: newMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println(">>> New method for Map interface V2");
        Map.Entry<Integer, String> e1 = Map.entry(101, "Java");
        Map.Entry<Integer, String> e2 = Map.entry(102, "Spring MVC");
        Map<Integer, String> newMap2 = Map.ofEntries(e1, e2);
        for (Map.Entry<Integer, String> e: newMap2.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
