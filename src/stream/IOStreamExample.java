package stream;

// FileInputStream: read byte-oriented data (byte streams) such as image, audio, video.
// FileReader: read character-oriented data (character stream) is more efficiently than FileInputStream

// FileOutputStream: write byte-oriented data such as image, audio, video.
// FileWriter: write character-oriented data is more efficiently than FileOutputStream

// BufferedInputStream, BufferedOutputStream: uses a buffer to store data ==> more efficiently, fast

// take input from console:
// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
// Scanner scanner = new Scanner();
// Console c = System.console();

// Serialization is a mechanism of writing the state of an object into a byte stream.
// It is mainly used to traver object's state on the network (marshalling)
// Or when to save the state of an object to a file
// Restoring by using deserialization

// Object serialization
// FileOutputStream fos = new FileOutputStream("test.txt");
// ObjectOutputStream oos = new ObjectOutputStream(fos);
// oos.writeObject(instance);
// oos.close()
// fos.close()

// Object deserialization
// FileInputStream fis = new FileInputStream("test.txt");
// ObjectInputStream ois = new ObjectInputStream(fis);
// ClassName instance = (ClassName) ois.readObject(); // down casting
// ois.close()
// fis.close()

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class IOStreamExample {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6)
        .filter(x -> x % 2 == 0)
        .map(x -> x * 2)
        .forEach(System.out::println);
    }


}
