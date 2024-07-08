package swing.example.layout;

// The Java CardLayout class manages the components in such a manner that only one component is visible at a time.
// It treats each component as a card that is why it is known as CardLayout.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutExample extends JFrame implements ActionListener {

    private int currCard = 1;
    private final CardLayout layout;
    JButton firstButton, nextButton, previousButton, lastButton;
    JPanel rootPanel, btnPanel;

    public CardLayoutExample() {

        // rootPanel
        rootPanel = new JPanel();   // container
        layout = new CardLayout();  // LayoutManager
        rootPanel.setLayout(layout);  // container contains cards (card is also container)

        JPanel panel1 = new JPanel();  // card
        JPanel panel2 = new JPanel();  // card
        JPanel panel3 = new JPanel();  // card
        JPanel panel4 = new JPanel();  // card

        JLabel label1 = new JLabel("C1");
        JLabel label2 = new JLabel("C2");
        JLabel label3 = new JLabel("C3");
        JLabel label4 = new JLabel("C4");

        panel1.add(label1);
        panel2.add(label2);
        panel3.add(label3);
        panel4.add(label4);

        rootPanel.add(panel1, "1");  // "1" => name for card in container
        rootPanel.add(panel2, "2");
        rootPanel.add(panel3, "3");
        rootPanel.add(panel4, "4");

        // button Panel
        btnPanel = new JPanel();  // container

        firstButton = new JButton("First");
        firstButton.addActionListener(this);

        nextButton = new JButton("->");
        nextButton.addActionListener(this);

        previousButton = new JButton("<-");
        previousButton.addActionListener(this);

        lastButton = new JButton("Last");
        lastButton.addActionListener(this);

        btnPanel.add(firstButton);
        btnPanel.add(nextButton);
        btnPanel.add(previousButton);
        btnPanel.add(lastButton);

        this.setTitle("Card Layout Methods");
        this.setSize(500, 200);

        getContentPane().add(rootPanel, BorderLayout.NORTH);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == firstButton) {
            layout.first(rootPanel);
            currCard = 1;
        } else if (e.getSource() == lastButton) {
            layout.last(rootPanel);
            currCard = 4;
        } else if (e.getSource() == nextButton) {
            if (currCard < 4)
            {
                currCard = currCard + 1;
                layout.show(rootPanel, "" + (currCard));
            }
        } else if (e.getSource() == previousButton) {
            if (currCard > 1)
            {
                currCard = currCard - 1;
                layout.show(rootPanel, "" + (currCard));
            }
        }
    }

    public static void main(String[] args) {
        CardLayoutExample cardLayout = new CardLayoutExample();
        cardLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout.setVisible(true);
    }
}
