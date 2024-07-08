package swing.example.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class WindowListenerExample extends JFrame implements WindowListener {
    public WindowListenerExample() {

        JLabel label = new JLabel("Demo JOption Pane");
        label.setBounds(50, 50, 150, 30);

        JTextArea area = getTextArea();

        this.addWindowListener(this);

        this.add(label);
        this.add(area);

        this.setTitle("ConfirmClosingPane Example");
        this.setLayout(null);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);

    }

    private static JTextArea getTextArea() {
        JTextArea area = new JTextArea();
        area.setText("""
                When you closing the Frame by click on X button,
                the ConfirmDialog will show up and you need to choose Yes to close the Frame
                """);
        area.setBounds(50, 100, 320, 320);
        area.setFont(new Font("Arial", Font.PLAIN, 14));

        // the line will be wrapped if they are too long
        area.setLineWrap(true);

        // the line will be wrapped at word boundaries (whitespace)
        area.setWrapStyleWord(true);

        area.setEditable(false);
        return area;
    }

    public static void main(String[] args) {
        new WindowListenerExample();
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int choose = JOptionPane.showConfirmDialog(this, "Are you sure");
        if (choose == JOptionPane.YES_NO_OPTION) {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
