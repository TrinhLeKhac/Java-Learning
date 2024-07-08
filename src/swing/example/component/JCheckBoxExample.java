package swing.example.component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class JCheckBoxExample extends JFrame implements ActionListener, ItemListener {
    JLabel label;
    JCheckBox checkbox1, checkbox2;

    JCheckBoxExample() {

        label = new JLabel("Checkbox");
        label.setBounds(250, 100, 300, 40);

        checkbox1 = new JCheckBox("C++");
        checkbox1.setBounds(280, 400, 20, 20);
        checkbox1.addItemListener(this);

        checkbox2 = new JCheckBox("Java");
        checkbox2.setBounds(280, 450, 20, 20);
        checkbox2.addItemListener(this);

        this.add(label);
        this.add(checkbox1);
        this.add(checkbox2);
        this.setTitle("Checkbox Example");
        this.setLayout(null);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JCheckBoxExample();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkbox1) {
            label.setText("C++ Checkbox: checked");
        } else if (e.getSource() == checkbox2) {
            label.setText("Java checkbox: checked");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == checkbox1) {
            label.setText("C++ Checkbox: " + (e.getStateChange() == ItemEvent.SELECTED ? "checked" : "unchecked"));
        } else if (e.getSource() == checkbox2) {
            label.setText("Java Checkbox: " + (e.getStateChange() == ItemEvent.SELECTED ? "checked" : "unchecked"));
        }
    }
}
