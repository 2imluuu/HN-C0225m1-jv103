package RunnableDemo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RunnableTest {
    public static void main(String[] args) {
        System.out.println("Main thread running...");

        RunnableDemo runnableDemo1 = new RunnableDemo("thread-1-hr-database");
        runnableDemo1.start();

        RunnableDemo runnableDemo2 = new RunnableDemo("thread-2-send-email");
        runnableDemo2.start();

        System.out.println("Main thread stop");
    }
}