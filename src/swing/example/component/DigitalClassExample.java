package swing.example.component;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DigitalClassExample extends JFrame {

    JLabel label;
    String timeString = "";

    public DigitalClassExample() {

        label = new JLabel();
        label.setBounds(100, 100, 100, 50);
        this.add(label);

        this.setTitle("DigitalClock Example");
        this.setLayout(null);
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void showTime() {
        try {
            while (true) {
                Calendar calendar = Calendar.getInstance();
                Date time = calendar.getTime();
                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                timeString = formatter.format(time);
                label.setText(timeString);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException ignored) {}
    }


    public static void main(String[] args) {
        DigitalClassExample digitalClock = new DigitalClassExample();
        digitalClock.showTime();
    }
}
