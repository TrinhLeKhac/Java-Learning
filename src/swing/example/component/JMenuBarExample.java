package swing.example.component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMenuBarExample extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu file, edit, help;
    JMenuItem cut, copy, paste, selectAll;
    JTextArea textArea;

    JMenuBarExample(){

        // JMenuBar
        menuBar = new JMenuBar();

        // JMenu
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");

        // JMenuItem
        cut=new JMenuItem("Cut");
        copy=new JMenuItem("Copy");
        paste=new JMenuItem("Paste");
        selectAll=new JMenuItem("Select All");

        // Add ActionListener to JMenuItem
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        // Add components
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);

        textArea = new JTextArea();
        textArea.setBounds(5,5,360,320);

//        this.add(menuBar);
        this.add(textArea);
        this.setJMenuBar(menuBar);

        this.setTitle("JMenuBar Example");
        this.setLayout(null);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut) {
            textArea.cut();
        } else if (e.getSource() == copy) {
            textArea.copy();
        } else if (e.getSource() == paste) {
            textArea.paste();
        } else if (e.getSource() == selectAll) {
            textArea.selectAll();
        }
    }

    public static void main(String[] args) {
        new JMenuBarExample();
    }
}
