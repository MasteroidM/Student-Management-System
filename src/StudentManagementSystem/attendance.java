package StudentManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//truncate
public class attendance extends JFrame implements  ActionListener, Runnable {
    JButton Add,UPDATE,calculate,home;
    attendance()
    {
        System.out.println("attendance Page");
        System.out.println("Thread Name: "+Thread.currentThread().getName());
        System.out.println("Thread Priority: "+Thread.currentThread().getPriority());

        setBounds(300,100,1200,1000);
        Add= new JButton("ADD");
        Add.setFont(new Font("SERIF",Font.BOLD,20));
        Add.setForeground(Color.BLACK);
        Add.setBounds(200,550,200,80);
        //Add.addActionListener(this);
        add(Add);

//        UPDATE = new JButton("UPDATE");
//        UPDATE.setForeground(Color.BLACK);
//        UPDATE.setFont(new Font("SERIF",Font.BOLD,20));
//        UPDATE.setBounds(500,550,200,80);
//        add(UPDATE);

        calculate = new JButton("DELETE");
        calculate.setForeground(Color.BLACK);
        calculate.setFont(new Font("SERIF",Font.BOLD,20));
        calculate.setBounds(550, 550, 200,80);
        add(calculate);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(40,30, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        home=new JButton(i3);
        home.setBounds(5,5,35,30);
        home.addActionListener(this);
        add(home);

        home.setLayout(null);
        home.setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== home) {
            new optFields().setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(false);
            this.dispose();
            System.gc();
        }
    }

    @Override
    public void run() {}

    public static void main(String[] args) {
        new Thread(new attendance()).start();
    }
}
