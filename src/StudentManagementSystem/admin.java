package StudentManagementSystem;

public class admin implements Runnable {

    @Override
    public void run() {}

    public static void main(String[] args) {
       Thread t1 =  new Thread(new dashboard());
       Thread t2 =  new Thread(new studDashboard());

       t1.start();
       t2.start();

        System.out.println("Teacher Dashboard Thread : " + t1.getName());
        System.out.println("Student Dashboard Thread : " + t2.getName());
    }
}