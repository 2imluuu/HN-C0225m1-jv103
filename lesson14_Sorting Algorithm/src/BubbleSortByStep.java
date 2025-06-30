import java.awt.*;
import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap kich thuoc mang: ");
        int size = sc.nextInt();
        int[] list = new int[size];
        for ( int i = 0; i < size ; i++){
            System.out.println("nhap vao phan tu thu " + (i+1) +" cua mang: ");
            list[i] = sc.nextInt();
        }
        System.out.println("mang co gia tri:");
        for( int i = 0; i < size ; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println("\n Begin sort processing...");
        bubbleSortByStep(list);
    }

    public static void bubbleSortByStep(int[] list){
        boolean needNextPass = true;
        for ( int i = 1; i < list.length && needNextPass; i++ ){
            needNextPass = false;
            for ( int j = 0; j < list.length - i; j++){
                if(list[j] > list[j+1]){
                    System.out.println("thay doi " + list[j] + " voi " +list[j+1]);
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;

                    needNextPass = true;
                }
            }
            if(needNextPass == false){
                System.out.println("Mang da sap xep va khong can sap xep lai");
                break;
            }
            System.out.println("mang sau khi sap xep lan " + i);
            for ( int j =0 ; j< list.length; j++){
                System.out.println(list[j]+"\t");
            }
            System.out.println();
        }
    }
}
