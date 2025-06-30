package MyThread;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.setName("Thread1");
        thread1.start();

        MyThread thread2 = new MyThread();
        thread2.setName("Thread2");
        thread2.start();

        MyThread thread3 = new MyThread();
        thread3.setName("Thread3");
        thread3.start();
    }
}
