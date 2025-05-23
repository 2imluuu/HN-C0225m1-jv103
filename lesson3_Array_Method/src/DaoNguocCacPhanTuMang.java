import java.util.Scanner;

public class DaoNguocCacPhanTuMang {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Nhập vào kích của mảng không vượt quá 20");
            size = sc.nextInt();
            if(size < 20){
                System.out.println("Mảng có " + size + "phần tử");
            }
        }while (size > 20);
        array = new int[size];
        int i = 0;
        while(i<array.length){
            System.out.println("Nhập phần tử " + (i+1) + ":");
            array[i] = sc.nextInt();
            i++;
        }
        System.out.println(size + " phần tử trong mảng là :");
        for( int j = 0; j < array.length ; j++){
            System.out.println(array[j]);
        }
        System.out.println("mảng đạo ngược là :");
        for(int j = 0; j< array.length/2;j++){
            int index = array.length-1;
            int tempt = array[j];
            array[j] = array[index - j];
            array[index -j] = tempt;
        }
        for(int j = 0; j< array.length;j++){
            System.out.println(array[j]);
        }
    }
}
