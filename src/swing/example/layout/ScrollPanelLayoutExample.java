package swing.example.layout;

import javax.swing.*;
import java.awt.*;

public class ScrollPanelLayoutExample extends JFrame {

    JScrollPane scrollPane;

    public ScrollPanelLayoutExample() {
        this.setTitle("JScrollPane Rating Display");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inner();
        this.setVisible(true);
    }

    public void inner() {
        JRadioButton[][] matrix = new JRadioButton[12][5];
        String[] subjects = {
            "CCNA", "Design Patterns", "Java",
            "Python", "Algorithms",
            "JAVASCRIPT", "Operating System", "CS Subject",
            "Data Structure", "PHP language", "Concurrency", "C #"
        };
        String[] ratings = {
                "RATING", "Very bad", "Bad", "Normal",
                "Good", "VeryGood"
        };

        JPanel panel = new JPanel();
        panel.setSize(600, 400);
        panel.setLayout(new GridLayout(13, 6, 10, 0));

        for (int r = 0; r < 13; r++) {
            ButtonGroup group = new ButtonGroup();
            for (int c = 0; c < 6; c++) {
                if (r == 0) {
                    panel.add(new JLabel(ratings[c]));
                }
                else if (c == 0) {
                    panel.add(new JLabel(subjects[r - 1]));
                }
                else {
                    matrix[r-1][c-1] = new JRadioButton();
                    group.add(matrix[r-1][c-1]);
                    panel.add(matrix[r-1][c-1]);
                }
            }
        }
        scrollPane = new JScrollPane(panel);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        new ScrollPanelLayoutExample();
    }
}
