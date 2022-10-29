package StudentManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class optFields extends JFrame implements ActionListener, Runnable {
    JLabel j1;
    JButton atdnce, marks,details;
    JButton back;
    JLabel b;
    optFields() {
        System.out.println("optFields Page");
        System.out.println("Thread Name: "+Thread.currentThread().getName());
        System.out.println("Thread Priority: "+Thread.currentThread().getPriority());

        setBounds(250, 120, 800, 350);

        j1 = new JLabel();
        j1.setBounds(280, -70, 250, 200);
        j1.setText("Choose the Field");
        j1.setFont(new Font("SERIF", Font.CENTER_BASELINE, 28));
        add(j1);

        atdnce = new JButton("Attendance");
        atdnce.setBounds(35,150,220,80);
        atdnce.addActionListener(this);

        add(atdnce); 
        
        marks = new JButton("Marks");
        marks.setBounds(265,150,220,80);
        marks.addActionListener(this);
        add(marks);

        details = new JButton("Details");
        details.setBounds(500,150,220,80);
        details.addActionListener(this);
        add(details);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(90,50, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        back=new JButton(i3);
        back.setBounds(5,5,60,60);
        back.addActionListener(this);
        add(back);

        back.setLayout(null);
        back.setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/b4.jpg"));
        Image i5 = i4.getImage().getScaledInstance(800,350, Image.SCALE_SMOOTH);
        ImageIcon i6= new ImageIcon(i5);
        JLabel j1 = new JLabel(i6);
        j1.setBounds(0,0,800,350);
        add(j1);

        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {

            new dashboard().setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(false);
            this.dispose();
            System.gc();
        }
        else if(ae.getSource()==details){
            new operation().setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(false);
            this.dispose();
            System.gc();
        }
        if(ae.getSource()==atdnce){
            new _attendance().setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(false);
            this.dispose();
            System.gc();
        }
        if(ae.getSource()==marks){
            new marks().setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(false);
            this.dispose();
            System.gc();
        }
    }

    @Override
    public void run() {}

    public static void main(String[] args) {
        new Thread(new optFields()).start();
    }}
