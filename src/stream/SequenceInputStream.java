package stream;

import java.io.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStream {

    public static void firstDemo() throws IOException {
        FileInputStream fin1 = new FileInputStream("src/stream/input1.txt");
        FileInputStream fin2 = new FileInputStream("src/stream/input2.txt");
        java.io.SequenceInputStream sin = new java.io.SequenceInputStream(fin1, fin2);
        FileOutputStream fout = new FileOutputStream("src/stream/outputFirstDemo.txt");
        int j;
        while ((j = sin.read()) != -1) {
//            System.out.print((char)j);
            fout.write(j);
        }
        fin1.close();
        fin2.close();
        sin.close();
        fout.close();
        System.out.println("Success...");
    }

    public static void secondDemo() throws IOException {
        // Using enumerate from Vector.elements when read sequenceInputStream from more than 2 files
        FileInputStream fin1 = new FileInputStream("src/stream/input1.txt");
        FileInputStream fin2 = new FileInputStream("src/stream/input2.txt");
        FileInputStream fin3 = new FileInputStream("src/stream/input3.txt");
        FileInputStream fin4 = new FileInputStream("src/stream/input4.txt");
        FileOutputStream fout = new FileOutputStream("src/stream/outputSecondDemo.txt");
        Vector<FileInputStream> v = new Vector<>();
        v.add(fin1);
        v.add(fin2);
        v.add(fin3);
        v.add(fin4);
        Enumeration<FileInputStream> enumFileInputStream = v.elements();
        java.io.SequenceInputStream sin = new java.io.SequenceInputStream(enumFileInputStream);
        int j;
        // read byte to byte
        while ((j = sin.read()) != -1) {
            System.out.print((char)j);
            fout.write(j);
        }
        // close resources
        fin1.close();
        fin2.close();
        fin3.close();
        fin4.close();
        fout.close();
        sin.close();
        System.out.println("Success...");
    }

    public static void thirdDemo() throws IOException {
        // try-with-resources
        try (
                FileInputStream fin1 = new FileInputStream("src/stream/input1.txt");
                FileInputStream fin2 = new FileInputStream("src/stream/input2.txt");
                FileInputStream fin3 = new FileInputStream("src/stream/input3.txt");
                FileInputStream fin4 = new FileInputStream("src/stream/input4.txt");
                FileOutputStream fout = new FileOutputStream("src/stream/outputThirdDemo.txt");

                // Using enumerate from Vector.elements when read sequenceInputStream from more than 2 files
                java.io.SequenceInputStream sin = new java.io.SequenceInputStream(new Vector<>(Arrays.asList(fin1, fin2, fin3, fin4)).elements())
        ) {
            int j;
            while ((j = sin.read()) != -1) {
                System.out.print((char)j);
                fout.write(j);
            }
        } // automatically close in there
        System.out.println("Success...");
    }

    public static void fourthDemo() throws IOException {
        // try-with-resources
        try (
                FileOutputStream fout1 = new FileOutputStream("src/stream/outputFourthDemo1.txt");
                FileOutputStream fout2 = new FileOutputStream("src/stream/outputFourthDemo2.txt");
                ByteArrayOutputStream bout = new ByteArrayOutputStream(); // buffer
                ) {
            bout.write(65);
            bout.writeTo(fout1);
            bout.writeTo(fout2);
            bout.flush();
            System.out.println("Success...");
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("-----------------firstDemo----------------------");
        firstDemo();
        System.out.println('\n');

        System.out.println("-----------------secondeDemo----------------------");
        secondDemo();
        System.out.println('\n');

        System.out.println("-----------------thirdDemo----------------------");
        thirdDemo();
        System.out.println('\n');

        System.out.println("-----------------fourthDemo----------------------");
        fourthDemo();
        System.out.println('\n');
    }
}
