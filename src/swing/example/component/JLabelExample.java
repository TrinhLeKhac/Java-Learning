package swing.example.component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

class JLabelExampleV1 {
    public JLabelExampleV1(){
        JFrame frame = new JFrame("JLabel Demo");
        JTextField textField = new JTextField();
        textField.setBounds(60, 40, 200, 20);

        JLabel label = new JLabel();
        label.setBounds(60, 120, 500, 20);

        JButton button = new JButton("Find IP");
        button.setBounds(60, 200, 100, 40);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String urlTExt = textField.getText();
                try {
                    String host = textField.getText();
                    String ip = java.net.InetAddress.getByName(host).getHostAddress();
                    label.setText("IP of " + host + " is : " + ip);
                } catch (Exception exc) {
                    System.out.println(exc);
                }
            }
        });

        frame.add(textField);
        frame.add(label);
        frame.add(button);
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JLabelExampleV1();
    }
}

class JLabelExampleV2 extends JFrame implements ActionListener{
    JTextField field;
    JLabel label;
    JButton button;

    public JLabelExampleV2() {

        field = new JTextField();
        field.setBounds(60, 60, 160, 30);

        label = new JLabel();
        label.setBounds(60, 180, 300, 30);

        button = new JButton("Find IP");
        button.setBounds(60, 300, 100, 40);
        button.addActionListener(this);

        this.add(field);
        this.add(label);
        this.add(button);
        this.setLayout(null);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String host = field.getText();
        try {
            String ip = java.net.InetAddress.getByName(host).getHostAddress();
            label.setText("IP of " + host + " is: " + ip);
        } catch (UnknownHostException ex) {
            label.setText("Wrong host information");
        }
    }

    public static void main(String[] args) {
        new JLabelExampleV2();
    }
}

class JLabelExampleV3 implements ActionListener{

    JTextField tf1,tf2,tf3;
    JButton b1,b2;

    public JLabelExampleV3(){

        JFrame f= new JFrame();
        tf1=new JTextField();
        tf1.setBounds(50,50,150,20);

        tf2=new JTextField();
        tf2.setBounds(50,100,150,20);

        tf3=new JTextField();
        tf3.setBounds(50,150,150,20);
        tf3.setEditable(false);

        b1=new JButton("+");
        b1.setBounds(50,200,50,50);

        b2=new JButton("-");
        b2.setBounds(120,200,50,50);

        b1.addActionListener(this);
        b2.addActionListener(this);

        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.add(b1);
        f.add(b2);

        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s1 = tf1.getText();
        String s2 = tf2.getText();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = 0;
        if(e.getSource() == b1){
            c = a + b;
        }else if(e.getSource() == b2){
            c = a - b;
        }
        String result = String.valueOf(c);
        tf3.setText(result);
    }
    public static void main(String[] args) {
        new JLabelExampleV3();
    } }
