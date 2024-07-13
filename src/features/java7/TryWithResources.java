package features.java7;

//The try-with-resources statement is a try statement that declares one or more resources.
// The resource is as an object that must be closed after finishing the program.
// The try-with-resources statement ensures that each resource is closed at the end of the statement execution.

import java.io.FileOutputStream;

public class TryWithResources {
    public static void main(String args[]){
        // Using try-with-resources  
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/features/java7/test.txt")) {
            String msg = "Welcome to my house!";
            
            //converting string into byte array  
            byte[] byteArray = msg.getBytes();   
            
            fileOutputStream.write(byteArray);
            System.out.println("Message written to file successfully!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
