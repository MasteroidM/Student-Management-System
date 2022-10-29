package StudentManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;

public class studAssignment extends JFrame implements ActionListener, Runnable {

    JTextField gr;
    JLabel d2;
    JButton addFile;
    int y = 55;
    int lw=80;
    int lh=20;

    studAssignment() {
        System.out.println("studAssignment Page");
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        System.out.println("Thread Priority: " + Thread.currentThread().getPriority());

        setBounds(150, 50, 800, 450);
        addFile = new JButton("Upload file");
        addFile.setBounds(100, 200, 120, 50);
        addFile.addActionListener(this);
        add(addFile);

        gr = new JTextField();
        gr.setBounds(100,100,120,40);
        add(gr);

        d2=new JLabel("Gr .No");
        d2.setBounds(130,y,lw,lh);
        d2.setForeground(Color.DARK_GRAY);
        add(d2);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/books.png"));
        Image i5 = i4.getImage().getScaledInstance(600,400, Image.SCALE_SMOOTH);
        ImageIcon i6= new ImageIcon(i5);
        JLabel j1 = new JLabel(i6);
        j1.setBounds(1,1,600,400);
        add(j1);

        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        setBounds(350,150,600,400);// setting the frame dimensions
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addFile) {
            JFileChooser add = new JFileChooser();
            int result = add.showOpenDialog(null);
            System.out.println(result); // will return 0 if file is choosen successfully
            File selectedFile = add.getSelectedFile();
            String fileName = selectedFile.getName();
            //System.out.println(fileName);
            if (result == JFileChooser.APPROVE_OPTION) {
                String path = selectedFile.getAbsolutePath();
                String grs = this.gr.getText();
                FileInputStream fis = null;
                try {
                    conn c = new conn();
                    fis = new FileInputStream(path);
                    String str = "insert into assignmentdata (grNo, file)  values ('"+grs+"',?) ";
                    PreparedStatement pst = c.c.prepareStatement(str);
                   // c.s.executeUpdate(str);
                    pst.setBinaryStream(1,fis);
                    int record = pst.executeUpdate();
                    if (record ==1)
                    {
                        JOptionPane.showMessageDialog(null,"Successfully Uploaded the file");
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

        public void run() {}

        public static void main (String[]args){
           new Thread(new studAssignment()).start();
        }



}

