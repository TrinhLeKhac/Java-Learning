package swing.example.component;

import javax.swing.*;

public class SliderExample extends JFrame {
    public SliderExample() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        // slider.setBounds(50, 50, 150, 30);

        // JPanel is a container class, which provides spaces contains any other component
        JPanel panel = new JPanel();
        panel.add(slider);
        // panel.setBounds(50, 50, 300, 60);

        this.add(panel);

        this.setTitle("Slider Example");
//        this.setLayout(null);  // setLayout null, setBounds for components
//        this.setLayout(new FlowLayout());  // can be commented | default value
//        this.setSize(300, 200);  // setSize, it's wide
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] s) {
        SliderExample frame = new SliderExample();
        frame.pack();  // shrink or expand component to fix
        frame.setVisible(true);
    }
}
