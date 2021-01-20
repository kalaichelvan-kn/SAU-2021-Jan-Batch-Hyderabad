package MultiThread;

public class MainClass {
    public static void main(String[] args) {
        Thread t = new Thread(new InFileCounter());
        t.start();
    }
}
