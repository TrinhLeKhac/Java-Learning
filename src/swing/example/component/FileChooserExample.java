package swing.example.component;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileChooserExample extends JFrame implements ActionListener {
    JLabel label;
    JFileChooser chooser;
    JButton openButton;
    JButton saveButton;

    public FileChooserExample() {

        openButton = new JButton("Open Dialog");
        openButton.addActionListener(this);

        saveButton = new JButton("Save Dialog");
        saveButton.addActionListener(this);

        label = new JLabel("No file selected");

        JPanel container = new JPanel();
        container.add(openButton);
        container.add(saveButton);
        container.add(label);

       this.add(container);
       this.setTitle("FileChooser Example");
       this.setLayout(new FlowLayout());
       this.setSize(800, 200);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        chooser = new JFileChooser(FileSystemView.getFileSystemView());
        int choose;
        if (e.getSource() == openButton) {
            choose = chooser.showOpenDialog(null);
            if (choose == JFileChooser.APPROVE_OPTION) {
                label.setText("Opening file: " + chooser.getSelectedFile().getAbsolutePath());
            }
        } else if (e.getSource() == saveButton) {
            choose = chooser.showSaveDialog(null);
            if (choose == JFileChooser.APPROVE_OPTION) {
                label.setText("Saving file: " + chooser.getSelectedFile().getAbsolutePath());
            }
        }

    }

    public static void main(String[] args) {
        new FileChooserExample();
    }
}
