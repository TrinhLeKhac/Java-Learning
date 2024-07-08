package swing.example.component;

// The JOptionPane class is used to provide standard dialog boxes such as
// message dialog box, confirm dialog box and input dialog box

import javax.swing.*;

class JOptionPaneExample extends JFrame {
    public JOptionPaneExample() {
        JOptionPane.showMessageDialog(this, "Successfully Updated", "Alert", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        new JOptionPaneExample();
    }
}


