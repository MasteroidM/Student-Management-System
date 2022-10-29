package StudentManagementSystem;

import java.sql.*;

    public class conn implements Runnable {
        Connection c;
        Statement s;

        conn(){
            System.out.println("Connection Page");
            System.out.println("Thread Name: "+Thread.currentThread().getName());
            System.out.println("Thread Priority: "+Thread.currentThread().getPriority());

            String url = "jdbc:mysql://localhost:3306/sms3";
            String username = "root";
            String password = "x";
            try {
                c = DriverManager.getConnection(url, username, password);
                s = c.createStatement();

            } catch (Exception e) {
                e.printStackTrace();
            }}

        @Override
        public void run() {}

        public static void main(String[] args) {
            new Thread(new conn()).start();
        }
    }
