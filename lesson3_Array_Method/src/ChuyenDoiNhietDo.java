import java.util.Scanner;

public class ChuyenDoiNhietDo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double fahrenheit;
        double celsius;
        int choice;
        do{
            System.out.println("Chọn nhiệt độ bạn muốn chuyển đổi");
            System.out.println("1. Chuyển từ độ F sang độ C");
            System.out.println("2. Chuyển từ độ C sang độ F");
            System.out.println("0. Exit");
            choice = sc.nextInt();
            switch(choice){
                case 1:{
                    System.out.println("nhập độ F:");
                    fahrenheit = sc.nextDouble();
                    System.out.println("độ C bằng " + fahrenheitToCelsius(fahrenheit));
                    break;
                }
                case 2:{
                    System.out.println("nhập độ C");
                    celsius = sc.nextDouble();
                    System.out.println("độ F bằng: " + celsiusToFahrenheit(celsius));
                    break;
                }
                case 0:{
                    break;
                }
            }
        } while (choice != 0);
    }

    public static double celsiusToFahrenheit(double celsius){
        double fahrenheit = (celsius * 9)/5 + 32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double farenheit){
        double celsius = (5.0/9)*(farenheit - 32);
        return celsius;
    }
}