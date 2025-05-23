package StopWatch;

import java.util.Scanner;

public class DemoStopWatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StopWatch sw = new StopWatch();
        sw.start();
        System.out.println("Nhan enter de dung");
        sc.nextLine();
        sw.stop();
        System.out.println("thoi gian " + sw.getElapsedTime() + " s");
    }
}
