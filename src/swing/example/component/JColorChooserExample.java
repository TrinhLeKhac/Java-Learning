package swing.example.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JColorChooserExample extends JFrame implements ActionListener {

    JButton button;
    Container container;

    JColorChooserExample(){
        container = getContentPane();
        container.setLayout(new FlowLayout());
        button = new JButton("color");
        button.addActionListener(this);
        container.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color initialcolor = Color.RED;
        Color color = JColorChooser.showDialog(this, "Select a color", initialcolor);
        container.setBackground(color);
    }

    public static void main(String[] args) {
        JColorChooserExample colorChooser = new JColorChooserExample();
        colorChooser.setTitle("JColorChooser Example");
        colorChooser.setSize(400,400);
        colorChooser.setVisible(true);
        colorChooser.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
