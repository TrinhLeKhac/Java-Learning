package swing.example.component;

import javax.swing.*;

class ProgressBarExample extends JFrame{
    JProgressBar progress;
    int i = 0;

    ProgressBarExample(){

        progress = new JProgressBar(0, 2000);
        progress.setBounds(40, 40, 160, 30);
        progress.setValue(200);

        // Show percentage
        progress.setStringPainted(true);

        this.add(progress);

        this.setTitle("ProgressBar Example");
        this.setSize(250, 150);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void iterate(){
        i = progress.getValue();
        while(i <= 2000){
            progress.setValue(i);
            i = i + 20;
            try{
                Thread.sleep(150);
            }
            catch (Exception exc) {}
        }
    }

    public static void main(String[] args) {
        ProgressBarExample bar = new ProgressBarExample();
        bar.setVisible(true);
        bar.iterate();
    }
}
