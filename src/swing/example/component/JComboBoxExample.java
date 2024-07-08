package swing.example.component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JComboBoxExample extends JFrame implements ActionListener {
    final JComboBox<String> comboBox;  // parameterized class <E>
    JLabel label;
    JButton button;

    public JComboBoxExample() {

        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(400, 100);

        String[] languages = {"C", "C++", "C#", "Java", "PHP"};
        comboBox = new JComboBox<>(languages);  // parameterized class <E>
        comboBox.setBounds(50, 100, 90, 20);

        button = new JButton("Show");
        button.setBounds(200, 100, 75, 20);
        button.addActionListener(this);

        this.add(comboBox);
        this.add(label);
        this.add(button);

        this.setTitle("JComboBox Example");
        this.setLayout(null);
        this.setSize(350, 350);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String data = "Programming language Selected: " + comboBox.getItemAt(comboBox.getSelectedIndex());
        label.setText(data);
    }

    public static void main(String[] args) {
        new JComboBoxExample();
    }
}
