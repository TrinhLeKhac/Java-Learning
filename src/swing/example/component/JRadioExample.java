package swing.example.component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JRadioExample extends JFrame implements ActionListener {
    JRadioButton radio1, radio2;
    JButton button;

    public JRadioExample() {

        radio1 = new JRadioButton("Male");
        radio1.setBounds(100, 50, 100, 30);

        radio2 = new JRadioButton("Female");
        radio2.setBounds(100, 100, 100, 30);

        button = new JButton("Click");
        button.setBounds(100, 150, 80, 30);
        button.addActionListener(this);

        // Add radio button to one group (select only one in a group)
        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);

        this.add(radio1);
        this.add(radio2);
        this.add(button);

        this.setTitle("JRadioButton Example");
        this.setLayout(null);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (radio1.isSelected()) {
            JOptionPane.showMessageDialog(this, "You are Male");
        } else if (radio2.isSelected()) {
            JOptionPane.showMessageDialog(this, "You are Female");
        }
    }

    public static void main(String[] args) {
        new JRadioExample();
    }
}
