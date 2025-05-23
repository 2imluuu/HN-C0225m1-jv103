import java.util.Scanner;

public class TimGiaTriLonNhatTrongMang {
    public static void main(String[] args) {
        int[] numArr;
        int size;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhập số phần tử tối đa của mảng");
            size = sc.nextInt();
            if(size>20){
                System.out.println("không được vượt quá 20");
            }
        } while (size>20);
        numArr = new int[size];
        System.out.println("nhập giá trị cho mảng");
        for ( int i =0; i< numArr.length; i++){
            System.out.println("nhập vào giá trị vị trí " + (i+1));
            numArr[i] = sc.nextInt();
        }
        for( int i:numArr){
            System.out.println(i);
        }
        int maxNum = numArr[0];
        int maxIndex = 0;
        for( int i = 0; i<numArr.length;i++){
            if(maxNum < numArr[i]){
                maxNum = numArr[i];
                maxIndex = i+1;
            }
        }
        System.out.println("giá trị lớn nhất trong chuỗi là: " + maxNum + "tại vị trí " + maxIndex);
    }
}
