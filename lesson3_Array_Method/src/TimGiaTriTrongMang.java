import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] student = {"A","B","C","D","E","F","G","H"};
        System.out.println("nhập vào chứ cần tìm");
        String input = sc.nextLine();
        boolean check = false;
        for( int i = 0; i < student.length; i++) {
            if (student[i].equals(input)) {
                System.out.println("chu can tim la " + input + "tai vi tri " + i);
                check = true;
                break;
            }
        }
        if(!check){
                System.out.println("khong tim thay");
        }
    }
}
