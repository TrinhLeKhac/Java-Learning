package features.java7;

// Java allows you to catch multiple type exceptions in a single catch block.
// It was introduced in Java 7 and helps to optimize code.
//You can use vertical bar (|) to separate multiple exceptions in catch block.

import java.io.FileOutputStream;

public class CatchMultipleException {
    public static void main(String[] args) {
        System.out.println("----------------Example 1: Multiple catch exception-----------------------");
        try {
            int[] array = new int[10];
            array[10] = 30/0;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("----------------Example 2: Multiple catch exception-----------------------");
        try {
            int[] array2 = new int[10];
            array2[10] = 30/0;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}


