package features.java5;

// Generics vs Non-Generics
// Type-safety: Hold only a single type of objects in generics
// There is no need to typecast the object
// Compile-time checking: It is checked at compile time so problem will not occur at runtime

// Generics class
// A class that can refer to any type is known as generic class
// Type parameters: T - Type, E - Element, K - Key, N - Number, V - Value

// Wildcard in Java Generics
// The ? symbol represents the wildcard element. It means any type.
// If we write <? extends Number>, it means any child class of Number, e.g Integer, Float and Double
// Now we can call the method of Number class through any child class object


// <? extends T>: Upper bound wildcard
// <? super T>: Lower bound wildcard

import java.util.ArrayList;
import java.util.List;

class MyGen<T> {
    T obj;
    void set(T obj) {
        this.obj = obj;
    }
    T get() {
        return this.obj;
    }
}

abstract class Shape {
    abstract void draw();
}
class Rectangle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing rectangle");
    }
}
class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing circle");
    }
}

public class GenericExample {

    public static <E> void printArray(E[] elements) {
        for (E e: elements) {
            System.out.println(e);
        }
        System.out.println();
    }

    public static void drawShapes(List<? extends Shape> li) {
        for(Shape s: li) {  // upcasting
            s.draw();
        }
    }
    public static void main(String[] args) {
        System.out.println("----------------Example 1: Any type-----------------------");
        MyGen<Integer> m = new MyGen<>();
        m.set(2);
        System.out.println(m.get());
        System.out.println('\n');

        System.out.println("----------------Example 2: Print array of any type-----------------------");
        Integer[] intArr = {10, 20, 30, 40, 50};
        Character[] charArr = {'J', 'A', 'V', 'A'};

        System.out.println("Printing Integer Array");
        printArray(intArr);

        System.out.println("Printing Character Array");
        printArray(charArr);
        System.out.println('\n');

        System.out.println("----------------Example 3: draw any shape-----------------------");
        List<Shape> listShapes = new ArrayList<>();
        listShapes.add(new Rectangle()); // upcasting
        listShapes.add(new Circle());
        listShapes.add(new Circle());

        drawShapes(listShapes);
    }
}
