package features.java8;

// Method reference is used to refer method of functional interface. It is compact and easy form of lambda expression
// References to a static method
// Reference to an instance method
// Reference to a constructor

import java.util.function.BiFunction;

class Arithmetic {
    public static int add(int a, int b) {
        return a + b;
    }
    public static float add(int a, float b) {
        return a + b;
    }
    public static float add(float a, float b) {
        return a + b;
    }
}
interface SaySomething {
    void say();
}

interface Messageable {
    Message getMessage(String msg);
}

class Message {
    Message(String msg) {
        System.out.println(msg);
    }
}

public class MethodReferencesExample {

    public static void saidFromClass() {
        System.out.println("This is a static method.");
    }

    public void saidFromInstance() {
        System.out.println("This is an instance method.");
    }

    public static void main(String[] args) {

        System.out.println("----------------Example 1: Reference to a static method-----------------------");
        BiFunction<Integer, Integer, Integer> adder1 = Arithmetic::add;
        BiFunction<Integer, Float, Float> adder2 = Arithmetic::add;
        BiFunction<Float, Float, Float> adder3 = Arithmetic::add;

        int result1 = adder1.apply(10, 20);
        float result2 = adder2.apply(10, 20.0f);
        float result3 = adder3.apply(10.0f, 20.0f);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println('\n');

        System.out.println("----------------Example 2: Another example-----------------------");
        SaySomething saySomethingFromClass = MethodReferencesExample::saidFromClass;
        saySomethingFromClass.say();
        System.out.println('\n');

        System.out.println("----------------Example 3: Reference to an instance method-----------------------");

        System.out.println(">>> Using explicit object");
        MethodReferencesExample instance = new MethodReferencesExample();
        SaySomething saySomethingFromInstance = instance::saidFromInstance;
        saySomethingFromInstance.say();
        System.out.println('\n');

        System.out.println(">>>Using anonymous object");
        SaySomething saySomethingFromInstance2 = new MethodReferencesExample()::saidFromInstance;;
        saySomethingFromInstance2.say();
        System.out.println('\n');

        System.out.println("----------------Example 4: Reference to a constructor-----------------------");
        Messageable hello = Message::new;
        hello.getMessage("hello");
    }
}
