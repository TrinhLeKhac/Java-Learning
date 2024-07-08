package swing.example.layout;

// The BorderLayout is used to arrange the components in five regions: north, south, east, west, and center.
// Each region (area) may contain one component only.
// It is the default layout of a frame or window.
// The BorderLayout provides five constants for each region: NORTH, SOUTH, EAST, WEST, CENTER

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample extends JFrame {

    JButton north, south, east, west, center;

    BorderLayoutExample() {

        north = new JButton("NORTH");
        south = new JButton("SOUTH");
        west = new JButton("WEST");
        east = new JButton("EAST");
        center = new JButton("CENTER");

        // ------------------------ Put button in each region with or without gap ------------------------
        // this.setLayout(new BorderLayout(10, 10));  // horizontal gap, vertical gap
        this.add(north, BorderLayout.NORTH);
        this.add(south, BorderLayout.SOUTH);
        this.add(west, BorderLayout.WEST);
        this.add(east, BorderLayout.EAST);
        this.add(center, BorderLayout.CENTER);


//        // Since region is not specified, the gaps are of no use
//        this.setLayout(new BorderLayout(10, 10));
//
//        // Each button covers the whole area
//        // However, the center is the latest button that is added to the frame
//        // Therefore, center  is shown
//        this.add(north);
//        this.add(south);
//        this.add(west);
//        this.add(east);
//        this.add(center);

        this.setTitle("BorderLayout Example");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutExample();
    }
}
