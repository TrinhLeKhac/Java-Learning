package swing.example.component;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JTableExample extends JFrame {
    final JTable table;
    JLabel label;

    public JTableExample() {

        label = new JLabel();
        // Set the bounds for the label
        label.setBounds(20, 400, 300, 30);
        String[][] data = {
                {"101","Amit","670000"},
                {"102","Jai","780000"},
                {"101","Sachin","700000"}
        };
        String[] column = {"ID", "NAME", "SALARY"};

        table = new JTable(data, column);
        table.setCellSelectionEnabled(true);

        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String data = null;
                int[] row = table.getSelectedRows();
                int[] cols = table.getSelectedColumns();
                for (int i = 0; i < row.length; i++) {
                    for (int j = 0; j < cols.length; j++) {
                        data = (String)table.getValueAt(row[i], cols[j]);
                    }
                }
                label.setText("Table element selected is: " + data);
            }
        });

        JScrollPane scroll = new JScrollPane(table);
        // Set the bounds for the scroll pane
        scroll.setBounds(20, 20, 450, 350);

        // this.add(scroll, BorderLayout.CENTER);
        this.add(scroll);
        this.add(label);

        this.setTitle("JTable Example");
        // when setLayout null, you must manually set the bounds for each component
         this.setLayout(null);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new JTableExample();
    }
}