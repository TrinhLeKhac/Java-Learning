package collection;


// Local class: Use it if you need to create more than one instance of a class, access its constructor,
// or introduce a new, named type (because, for example, you need to invoke additional methods later).

// Anonymous class: Use it if you need to declare fields or additional methods.

// Lambda expression:
// Use it if you are encapsulating a single unit of behavior that you want to pass to other code.
// For example, you would use a lambda expression if you want a certain action performed on each element of a collection,
// when a process is completed, or when a process encounters an error.

// Use it if you need a simple instance of a functional interface
// and none of the preceding criteria apply (for example, you do not need a constructor, a named type, fields, or additional methods).

// Nested class: Use it if your requirements are similar to those of a local class,
// you want to make the type more widely available,
// and you don't require access to local variables or method parameters.

// Use a non-static nested class (or inner class) if you require access to an enclosing instance's non-public fields and methods.
// Use a static nested class if you don't require this access.


public class OuterClass {

    String outerField = "Outer field";
    static String staticOuterField = "Static outer field";

    class InnerClass {
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            System.out.println(outer.outerField);
//            System.out.println(outerField); // Non-static field 'outerField' cannot be referenced from a static context
            System.out.println(staticOuterField);
        }
    }

    public static void main(String[] args) {
        System.out.println("Inner class:");
        System.out.println("------------");
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.accessMembers();

        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        StaticNestedClass staticNestedObject = new StaticNestedClass();
        staticNestedObject.accessMembers(outerObject);

    }
}

// This example defines three variables named x:
// the member variable of the class ShadowTest,
// the member variable of the inner class FirstLevel,
// and the parameter in the method methodInFirstLevel()
// The variable x defined as a parameter of the method methodInFirstLevel() shadows the variable of the inner class FirstLevel

class ShadowTest {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}


class DataStructure {

    // Create an array
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];

    public DataStructure() {
        // fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }

    public void printEven() {

        // Print out values of even indices of the array
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    interface DataStructureIterator extends java.util.Iterator<Integer> { }

    // Inner class implements the DataStructureIterator interface,
    // which extends the Iterator<Integer> interface

    private class EvenIterator implements DataStructureIterator {

        // Start stepping through the array from the beginning
        private int nextIndex = 0;

        public boolean hasNext() {

            // Check if the current element is the last in the array
            return (nextIndex <= SIZE - 1);
        }

        public Integer next() {

            // Record a value of an even index of the array
            Integer retValue = arrayOfInts[nextIndex];

            // Get the next even element
            nextIndex += 2;
            return retValue;
        }
    }

    public static void main(String s[]) {

        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure ds = new DataStructure();
        ds.printEven();
    }
}

// You can define a local class inside any block (see Expressions, Statements, and Blocks for more information).
// For example, you can define a local class in a method body, a for loop, or an if clause.
// A local class has access to the members of its enclosing class
// Local classes are non-static because they have access to instance members of the enclosing block.
// the PhoneNumber() constructor accesses the member LocalClassExample.regularExpression

class LocalClassExample {

    static String regularExpression = "[^0-9]";

    public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {

        final int numberLength = 10;

        class PhoneNumber { // Local Class

            String formattedPhoneNumber = null;

            PhoneNumber(String phoneNumber){
                String currentNumber = phoneNumber.replaceAll(regularExpression, "");
                if (currentNumber.length() == numberLength)
                    formattedPhoneNumber = currentNumber;
                else
                    formattedPhoneNumber = null;
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        if (myNumber1.getNumber() == null)
            System.out.println("First number is invalid");
        else
            System.out.println("First number is " + myNumber1.getNumber());
        if (myNumber2.getNumber() == null)
            System.out.println("Second number is invalid");
        else
            System.out.println("Second number is " + myNumber2.getNumber());

    }

    public static void main(String... args) {
        validatePhoneNumber("123-456-7890", "456-7890");
    }
}