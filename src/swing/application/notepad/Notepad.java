package swing.application.notepad;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Notepad extends JFrame implements ActionListener, WindowListener{
    JTextArea jta = new JTextArea();
    File fnameContainer;

    public Notepad() {

        Font fnt=new Font("Arial",Font.PLAIN,15);
        Container con = getContentPane();

        JMenuBar jmb = new JMenuBar();
        JMenu jmfile = new JMenu("File");
        JMenu jmedit = new JMenu("Edit");
        JMenu jmhelp = new JMenu("Help");

        con.setLayout(new BorderLayout());

        JScrollPane sbrText = new JScrollPane(jta);
        sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sbrText.setVisible(true);


        jta.setFont(fnt);
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);

        con.add(sbrText);

        createMenuItem(jmfile,"New");
        createMenuItem(jmfile,"Open");
        createMenuItem(jmfile,"Save");
        jmfile.addSeparator();
        createMenuItem(jmfile,"Exit");

        createMenuItem(jmedit,"Cut");
        createMenuItem(jmedit,"Copy");
        createMenuItem(jmedit,"Paste");

        createMenuItem(jmhelp,"About swing.application.notepad.Notepad");

        jmb.add(jmfile);
        jmb.add(jmedit);
        jmb.add(jmhelp);

        setJMenuBar(jmb);
        setIconImage(Toolkit.getDefaultToolkit().getImage("swing.application.notepad.gif"));
        addWindowListener(this);
        setSize(500,500);
        setTitle("Untitled.txt - swing.application.notepad.Notepad");

        setVisible(true);
    }

    public void createMenuItem(JMenu jm,String txt){
        JMenuItem jmi = new JMenuItem(txt);
        jmi.addActionListener(this);
        jm.add(jmi);
    }

    public void actionPerformed(ActionEvent e){
        JFileChooser jfc = new JFileChooser();

        if(e.getActionCommand().equals("New")){
            this.setTitle("Untitled.txt - swing.application.notepad.Notepad");
            jta.setText("");
            fnameContainer = null;
        } else if(e.getActionCommand().equals("Open")){
            int ret = jfc.showDialog(null,"Open");
            if(ret == JFileChooser.APPROVE_OPTION) {
                try{
                    File file=jfc.getSelectedFile();
                    OpenFile(file.getAbsolutePath());
                    this.setTitle(file.getName()+ " - swing.application.notepad.Notepad");
                    fnameContainer = file;
                } catch (IOException ers) {}
            }

        } else if(e.getActionCommand().equals("Save")){
            if(fnameContainer != null){
                jfc.setCurrentDirectory(fnameContainer);
                jfc.setSelectedFile(fnameContainer);
            }
            else {
                jfc.setSelectedFile(new File("Untitled.txt"));
            }

            int ret = jfc.showSaveDialog(null);
            if(ret == JFileChooser.APPROVE_OPTION){
                try{
                    File file = jfc.getSelectedFile();
                    SaveFile(file.getAbsolutePath());
                    this.setTitle(file.getName()+ " - swing.application.notepad.Notepad");
                    fnameContainer = file;

                } catch (Exception ers2){}
            }

        }else if(e.getActionCommand().equals("Exit")){
            Exiting();
        }else if(e.getActionCommand().equals("Cut")){
            jta.cut();
        }else if(e.getActionCommand().equals("Copy")){
            jta.copy();
        }else if(e.getActionCommand().equals("Paste")){
            jta.paste();
        }else if(e.getActionCommand().equals("About swing.application.notepad.Notepad")){
            JOptionPane.showMessageDialog(this, "Created by: TrinhLK2", "swing.application.notepad.Notepad", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void OpenFile(String fname) throws IOException {
        BufferedReader d=new BufferedReader(new InputStreamReader(new FileInputStream(fname)));
        String line;
        jta.setText("");
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        while((line=d.readLine()) != null) {
            jta.setText(jta.getText() + line + "\r\n");
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        d.close();
    }

    public void SaveFile(String fname) throws IOException {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        DataOutputStream output = new DataOutputStream(new FileOutputStream(fname));
        output.writeBytes(jta.getText());
        output.close();
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    public void Exiting(){
        System.exit(0);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

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
