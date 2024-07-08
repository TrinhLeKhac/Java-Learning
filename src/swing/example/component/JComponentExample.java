package swing.example.component;

import javax.swing.*;
import java.awt.*;

// The JComponent class is the base class of all Swing components except top-level containers.
// Swing components whose names begin with "J" are descendants of the JComponent class.
// For swing.example, JButton, JScrollPane, JPanel, JTable etc.
// But, JFrame and JDialog don't inherit JComponent class because they are the child of top-level containers.

public class JComponentExample extends JComponent {

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(30, 30, 100, 100);
    }

    public static void main(String[] args) {

        JComponentExample com = new JComponentExample();
        // create a basic JFrame
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("JComponent Example");
        frame.setSize(300,200);
//        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the JComponent to main frame
        // add before setVisible
        frame.add(com);
        frame.setVisible(true);
    }
}
