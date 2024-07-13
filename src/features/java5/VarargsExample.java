package features.java5;

// The varargs allows the method to accept zero or multiple arguments
// If we don't know how many argument we will have to pass in the method, varargs is the best approach
// Variable argument (varargs) must be the last argument.

public class VarargsExample {
    static void display(int num, String... values) {
        System.out.println("number is: " + num);
        for(String s: values) {
            System.out.print(s + " ");
        }
        System.out.print('\n');
    }
    public static void main(String[] args) {
        display(100);
        display(500, "hello");
        display(1000, "this", "is", "an", "example", "of", "varargs");
    }
}
