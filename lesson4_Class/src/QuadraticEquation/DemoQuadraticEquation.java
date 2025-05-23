package QuadraticEquation;

import java.util.Scanner;

public class DemoQuadraticEquation {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Nhập vào a");
        double a = sc.nextDouble();
        System.out.println("nhập vào b");
        double b = sc.nextDouble();
        System.out.println("nhập vào c");
        double c = sc.nextDouble();
        System.out.println("kết quả của phương trình bậc 2 là:");
        QuadraticEquation quadra = new  QuadraticEquation(a,b,c);
        double delta = quadra.getDiscriminant(a,b,c);
        if(delta > 0 ){
            System.out.println(quadra.getRoot1(a,b,c));
            System.out.println(quadra.getRoot2(a,b,c));
        } else if(delta == 0 ){
            System.out.println(quadra.getRoot3(a,b,c));
        } else {
            System.out.println("vô nghiệm");
        }
    }
}
