package swing.example.layout;

import javax.swing.*;
import java.awt.*;

public class SpringLayoutExample{
    public SpringLayoutExample() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Spring Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(310, 210);

        Container container = frame.getContentPane();
        SpringLayout sprLayout = new SpringLayout();
        frame.setLayout(sprLayout);

        Component btn1 = new JButton("C++");
        Component btn2 = new JButton("Python");
        Component btn3 = new JButton("JAVA");
        Component btn4 = new JButton("NETWORKING");

        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);

        sprLayout.putConstraint(SpringLayout.WEST, btn1, 24, SpringLayout.WEST, container);  // C++
        sprLayout.putConstraint(SpringLayout.NORTH, btn1, 9, SpringLayout.NORTH, container);

        sprLayout.putConstraint(SpringLayout.WEST, btn2, 49, SpringLayout.WEST, container);  // Python
        sprLayout.putConstraint(SpringLayout.NORTH, btn2, 10, SpringLayout.SOUTH, btn1);

        sprLayout.putConstraint(SpringLayout.WEST, btn3, 74, SpringLayout.WEST, container); // Java
        sprLayout.putConstraint(SpringLayout.NORTH, btn3, 9, SpringLayout.SOUTH, btn2);

        sprLayout.putConstraint(SpringLayout.WEST, btn4, 14, SpringLayout.EAST, btn1);  // Networking
        sprLayout.putConstraint(SpringLayout.NORTH, btn4, 9, SpringLayout.NORTH, container);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SpringLayoutExample();
    }
}
