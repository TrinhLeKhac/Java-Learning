package swing.application.exam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineTest extends JFrame implements ActionListener {

    JLabel question;
    JRadioButton[] answers = new JRadioButton[5];
    JButton next, bookmark;
    ButtonGroup group;
    int count = 0; // number of right answer
    int current = 0; // current question
    int x = 1; // bookmark position
    int now = 0; //
    int[] m = new int[10]; // bookmark array

    OnlineTest(String title) {
        // Add title
        super(title);

        // question
        question = new JLabel();
        this.add(question);

        // group
        group = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            answers[i] = new JRadioButton();
            this.add(answers[i]);
            group.add(answers[i]);
        }

        // next, bookmark
        next = new JButton("Next");
        next.addActionListener(this);

        bookmark = new JButton("Bookmark");
        bookmark.addActionListener(this);

        this.add(next);
        this.add(bookmark);

        // set question
        set();

        // setBounds
        question.setBounds(30, 40, 450, 20);
        answers[0].setBounds(50, 80, 100, 20);
        answers[1].setBounds(50, 110, 100, 20);
        answers[2].setBounds(50, 140, 100, 20);
        answers[3].setBounds(50, 170, 100, 20);
        next.setBounds(100, 240, 100, 30);
        bookmark.setBounds(270, 240, 100, 30);
        // this.setTitle(title);
        this.setLayout(null);
        this.setLocation(250, 100);
//        this.setSize(600, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(600, 350);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {  // button Next
            if (check()) {
                count += 1;
            }
            current++;
            set();
            if (current == 9) {
                next.setEnabled(false);
                bookmark.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark " + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            this.add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9) {
                bookmark.setText("Result");
            }
            this.setVisible(false);
            this.setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark " + y)) {
                if (check()) {
                    count += 1;
                }
                now = current;
                current = m[y];
                set();
                ((JButton)e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check()) {
                count += 1;
            }
            current++;
            JOptionPane.showMessageDialog(this, "correct ans = " + count);
            System.exit(0);
        }
    }

    public void set() {
        answers[4].setSelected(true);
        if (current == 0) {
            question.setText("Question 1: Which one among these is not a primitive datatype ?");
            answers[0].setText("int");
            answers[1].setText("Float");
            answers[2].setText("boolean");
            answers[3].setText("char");
        } else if (current == 1) {
            question.setText("Question 2: Which class is available to all the class automatically ?");
            answers[0].setText("Swing");
            answers[1].setText("Applet");
            answers[2].setText("Object");
            answers[3].setText("ActionEvent");
        } else if (current == 2) {
            question.setText("Question 3: Which package is directly available to our class without importing it ?");
            answers[0].setText("swing");
            answers[1].setText("applet");
            answers[2].setText("net");
            answers[3].setText("lang");
        }
        else if (current == 3) {
            question.setText("Question 4: String class is defined in which package ?");
            answers[0].setText("lang");
            answers[1].setText("Swing");
            answers[2].setText("Applet");
            answers[3].setText("awt");
        }
        else if (current == 4) {
            question.setText("Question 5: Which institute is best for java coaching ?");
            answers[0].setText("Utek");
            answers[1].setText("Aptech");
            answers[2].setText("SSS IT");
            answers[3].setText("jtek");
        }
        else if (current == 5) {
            question.setText("Question 6: Which one among these is not a keyword ?");
            answers[0].setText("class");
            answers[1].setText("int");
            answers[2].setText("get");
            answers[3].setText("if");
        }
        else if (current == 6) {
            question.setText("Question 7: Which one among these is not a class ?");
            answers[0].setText("Swing");
            answers[1].setText("ActionPerformed");
            answers[2].setText("ActionEvent");
            answers[3].setText("Button");
        }
        else if (current == 7) {
            question.setText("Question 8: Which one among these is not a function of Object class ?");
            answers[0].setText("toString");
            answers[1].setText("finalize");
            answers[2].setText("equals");
            answers[3].setText("getDocumentBase");
        }
        else if (current == 8) {
            question.setText("Question 9: Which function is not present in Applet class ?");
            answers[0].setText("init");
            answers[1].setText("main");
            answers[2].setText("start");
            answers[3].setText("destroy");
        }
        else if (current == 9) {
            question.setText("Question 10: Which one among these is not a valid component ?");
            answers[0].setText("JButton");
            answers[1].setText("JList");
            answers[2].setText("JButtonGroup");
            answers[3].setText("JTextArea");
        }
        question.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i+= 30, j++) {
            answers[j].setBounds(50, 80 + i, 200, 20);
        }
    }

    public boolean check() {
        if (current == 0) {
            return answers[1].isSelected();
        }
        if (current == 1) {
            return answers[2].isSelected();
        }
        if (current == 2) {
            return answers[3].isSelected();
        }
        if (current == 3) {
            return answers[0].isSelected();
        }
        if (current == 4) {
            return answers[2].isSelected();
        }
        if (current == 5) {
            return answers[2].isSelected();
        }
        if (current == 6) {
            return answers[1].isSelected();
        }
        if (current == 7) {
            return answers[3].isSelected();
        }
        if (current == 8) {
            return answers[1].isSelected();
        }
        if (current == 9) {
            return answers[2].isSelected();
        }
        return false;
    }

    public static void main(String[] args) {
        new OnlineTest("Online Test of Java");
    }
}

