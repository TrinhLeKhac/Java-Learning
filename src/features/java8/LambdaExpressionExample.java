package features.java8;

// Lambda Expression
// It provides a clear and concise way to represent one method interface using an expression.
// It helps to iterate, filter and extract data from collection.
// (argument-list) -> {body}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

interface Drawable {  // 1 method interface
    void draw();
}
interface Addable {
    int add(int a, int b);
}
interface Sayable {
    String say(String message);
}

class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class LambdaExpressionExample {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("----------------Example 1: Lambda expression-----------------------");
        System.out.println('\n');

        System.out.println(">>> Instead create class implement interface and create new instance from that class");
        System.out.println(">>> We're using Class Anonymous (borrowed name from interface");
        Drawable d = new Drawable() {
            @Override
            public void draw() {
                System.out.println("Drawing");
            }
        };
        d.draw();
        System.out.println('\n');

        System.out.println(">>> Using Lambda Expression");
        Drawable d1 = () -> {
            System.out.println("Drawing");
        };
        d1.draw();

        System.out.println('\n');
        System.out.println(">>> Addable Example");
        Addable addable = (a, b) -> a + b;
        System.out.println(addable.add(1, 2));

        System.out.println('\n');
        System.out.println(">>> Sayable Example");
        Sayable sayable = (message) -> {
            String s1 = "I would like to say: ";
            return s1 + message;
        };
        System.out.println(sayable.say("Time is precious"));

        System.out.println('\n');
        System.out.println(">>> Thread Example");
        System.out.println("Thread without lambda");
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thead r1 is running...");
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();

        System.out.println("Thread with lambda");
        Runnable r2 = () -> {
            System.out.println("Thread r2 is running...");
        };
        Thread t2 = new Thread(r2);
        t2.start();

        Thread.sleep(1000);
        System.out.println('\n');

        System.out.println(">>> Sorting");
        List<Product> products = new ArrayList<>();

        //Adding Products
        products.add(new Product(1, "HP Laptop", 25000f));
        products.add(new Product(3, "Keyboard", 300f));
        products.add(new Product(2, "Dell Mouse", 150f));

        System.out.println("Sorting using Anonymous Class");
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        for (Product product: products) {
            System.out.println(product.id + " " + product.name + " " + product.price);
        }
        System.out.println('\n');

        System.out.println("Sorting using Lambda Expression V1");
        products.sort((Product o1, Product o2) -> {
            return o1.name.compareTo(o2.name);
        });
        for (Product product: products) {
            System.out.println(product.id + " " + product.name + " " + product.price);
        }
        System.out.println('\n');

        System.out.println("Sorting using Lambda Expression V2");
        products.sort(Comparator.comparing((Product o) -> o.name));
        for (Product product: products) {
            System.out.println(product.id + " " + product.name + " " + product.price);
        }
        System.out.println('\n');

        System.out.println("Filter using Lambda Expression");
        List<Product> listItems = new ArrayList<>();
        listItems.add(new Product(1, "Samsung A5", 17000f));
        listItems.add(new Product(3, "Iphone 6S", 65000f));
        listItems.add(new Product(2, "Sony Xperia", 25000f));
        listItems.add(new Product(4, "Nokia Lumia", 15000f));
        listItems.add(new Product(5, "Redmi4 ", 26000f));
        listItems.add(new Product(6, "Lenevo Vibe",19000f));
        Stream<Product> filtered_items = listItems.stream().filter(p -> p.price > 20000);
        filtered_items.forEach(
                product -> System.out.println(product.name + ": " + product.price)
        );
    }
}
