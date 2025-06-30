package MyThread;

public class MyThread extends Thread {
    @Override
    public void run() {
        for ( int i = 0; i < 5 ; i++){
            System.out.println(Thread.currentThread().getName() + "đang chạy " + i);
            /*try {
                Thread.sleep(500);
            } catch  (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "<UNK>");
            }*/
        }
    }
}
