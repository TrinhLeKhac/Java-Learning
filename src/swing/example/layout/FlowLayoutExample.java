package swing.example.layout;

// The Java FlowLayout class is used to arrange the components in a line, one after another (in a flow).
// It is the default layout of the applet or panel.

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample extends JFrame{
    public FlowLayoutExample() {

        // creating 9 buttons
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btn10 = new JButton("10");

        // Adding the buttons to frame
        this.add(btn1); this.add(btn2); this.add(btn3);
        this.add(btn4); this.add(btn5); this.add(btn6);
        this.add(btn7); this.add(btn8); this.add(btn9); this.add(btn10);

//        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 25));

        this.setTitle("FlowLayout Example");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new FlowLayoutExample();
    }
}
