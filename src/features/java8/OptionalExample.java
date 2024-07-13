package features.java8;

// It is a public final class and used to deal with NullPointerException in Java application

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {

        String[] strArray = new String[10];

        // strArray[5] = "JAVA OPTIONAL CLASS EXAMPLE";
        Optional<String> checkNullable = Optional.ofNullable(strArray[5]);

        System.out.println("----------------Check nullable method 1-----------------------");
        if (checkNullable.isPresent()) {
            String lowerCaseString = strArray[5].toLowerCase();
            System.out.println(lowerCaseString);
        } else {
            System.out.println("String value is not present");
        }
        System.out.println('\n');

        System.out.println("----------------Check nullable method 2----------------------");
        checkNullable.ifPresent(System.out::println);

        // can have error NullPointer Exception
//        System.out.println(checkNullable.get());
//        System.out.println(strArray[5].toLowerCase());
    }
}

class OptionalExampleV2 {
    public static void main(String[] args) {

        String[] str = new String[10];

        // Setting value for 5th index
        str[5] = "JAVA OPTIONAL CLASS EXAMPLE";

        // Empty instance of Optional class
        Optional<String> empty = Optional.empty();
        System.out.println(empty);

        // Non-empty instance of Optional class
        Optional<String> value = Optional.of(str[5]);

        // If value is present, it returns an Optional otherwise returns an empty Optional
        System.out.println("Filtered value: " + value.filter(s -> s.equals("Abc")));
        System.out.println("Filtered value: " + value.filter(s -> s.equals("JAVA OPTIONAL CLASS EXAMPLE")));

        // It returns value of an Optional. if value is not present, it throws an NoSuchElementException
        System.out.println("Getting value: " + value.get());

        // It returns hashCode of the value
        System.out.println("Getting hashCode: " + value.hashCode());

        // It returns true if value is present, otherwise false
        System.out.println("Is value present: " + value.isPresent());

        // It returns non-empty Optional if value is present, otherwise returns an empty Optional
        System.out.println("Nullable Optional: " + Optional.ofNullable(str[5]));

        // It returns value if available, otherwise returns specified value,
        System.out.println("orElse: " + value.orElse("Value is not present"));
        System.out.println("orElse: " + empty.orElse("Value is not present"));

        // printing value by using method reference
        value.ifPresent(System.out::println);
    }
}
