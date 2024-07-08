package swing.example.component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JButtonExampleV1 {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Buttone Example");
        JButton b = new JButton("Click me");
        b.setBounds(50, 100, 95, 30);
        jf.add(b);
        jf.setLayout(null);
        jf.setSize(400, 400);
        jf.setVisible(true);

    }
}


class JButtonExampleV2 {

    public JButtonExampleV2() {
        JFrame frame = new JFrame("Button Example");
        JTextField textField = new JTextField();
        textField.setBounds(50, 50, 200, 20);
        JButton button = new JButton("Click Here");
        button.setBounds(50, 100, 95, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Welcome to my house");
            }
        });
        frame.add(button);
        frame.add(textField);
        frame.setLayout(null);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        JButtonExampleV2 demo = new JButtonExampleV2();
    }
}
