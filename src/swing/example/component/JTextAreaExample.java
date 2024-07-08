package swing.example.component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JTextAreaExample extends JFrame implements ActionListener {

    JLabel wordLabel, characterLabel;
    JTextArea textArea;
    JButton button;

    JTextAreaExample() {

        wordLabel = new JLabel("Words: ");
        wordLabel.setBounds(50, 20, 100, 30);

        characterLabel = new JLabel("Characters: ");
        characterLabel.setBounds(350, 20, 150, 30);

        textArea = new JTextArea();
        textArea.setBounds(20, 80, 550, 400);

        button = new JButton("Count Words");
        button.setBounds(250, 500, 100, 40);
        button.addActionListener(this);

        this.add(wordLabel);
        this.add(characterLabel);
        this.add(textArea);
        this.add(button);
        this.setTitle("Word Count Example");
        this.setLayout(null);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText();
        String[] words = text.split("\\s");
        wordLabel.setText("Words: " + words.length);
        characterLabel.setText("Characters: " + text.length());
    }

    public static void main(String[] args) {
        new JTextAreaExample();
    }
}

