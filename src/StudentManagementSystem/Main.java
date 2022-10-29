package StudentManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener, Runnable {
    JButton j2,j1;

    Main(){
        System.out.println("Main Page");
        System.out.println("Thread Name: "+Thread.currentThread().getName());
        System.out.println("Thread Priority: "+Thread.currentThread().getPriority());

        setBounds(350,150,600,450);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("jproject_images/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/DBIT.png"));
        Image i4 = i3.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i5 = new ImageIcon(i2);
        ImageIcon i6 = new ImageIcon(i4);

        JLabel l3 = new JLabel(i6);
        l3.setBounds(400,0,150,150);
        add(l3);

        JLabel l1 = new JLabel(i5);
        l1.setBounds(0,0,600,450);
        add(l1);

        JLabel l2 = new JLabel("DBIT");
        l2.setForeground(Color.black);
        l2.setBounds(250,-80,500,300);
        l2.setFont(new Font("Serif",Font.BOLD,34));
        l1.add(l2);

        j1 = new JButton("Teacher Login");
        j1.setBounds(400,300,150,60);
        j1.setBackground(Color.white);
        j1.addActionListener(this);
        l1.add(j1);

        j2 = new JButton("Student Login");
        j2.setBounds(45,300,150,60);
        j2.setBackground(Color.white);
        j2.addActionListener(this);
        l1.add(j2);

        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

public void actionPerformed(ActionEvent l) {
    if (l.getSource() == j1) {
        new login().setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //linking the login page
        this.setVisible(false);
            this.dispose();
            System.gc();
    }
    if (l.getSource() == j2) {
        new studLogin().setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(false);
            this.dispose();
            System.gc();
    }
}
    @Override
    public void run() {}

    public static void main(String[] args) {
        new Thread(new Main()).start();
    }
}
