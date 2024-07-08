package swing.example.layout;

// The Java GridLayout class is used to arrange the components in a rectangular grid.
// One component is displayed in each rectangle.

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample extends JFrame {
    public  GridLayoutExample() {

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

        // adding buttons to the frame
        // since, we are using the parameterless constructor, therfore;
        // the number of columns is equal to the number of buttons we
        // are adding to the frame. The row count remains one.
        this.add(btn1); this.add(btn2); this.add(btn3);
        this.add(btn4); this.add(btn5); this.add(btn6);
        this.add(btn7); this.add(btn8); this.add(btn9);

        // setting the grid layout using the parameterless constructor
//        this.setLayout(new GridLayout());  // 9 columns and 1 row
        this.setLayout(new GridLayout(3, 3));  // 3 columns and 3 rows
        this.setLayout(new GridLayout(3, 3, 10, 10)); // 3 columns and 3 rows with hgap and vgap
        this.setTitle("GridLayout Example");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new GridLayoutExample();
    }
}
