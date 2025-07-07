
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyDanhBa quanLyDanhBa = new QuanLyDanhBa();
        Menu menu = new Menu(scanner, quanLyDanhBa);
        try {
            do {
                menu.hienThi();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        menu.xemDanhBa();
                        break;
                    case 2:
                        menu.themLienHe();
                        break;
                    case 3:
                        menu.xoaLienHe();
                        break;
                    case 4:
                        menu.capNhatDanhBa();
                        break;
                    case 5:
                        menu.timKiemDanhBa();
                        break;
                    case 6:
                        menu.docTuFile();
                        break;
                    case 7:
                        menu.ghiVaoFile();
                        break;
                    case 8:
                        menu.thoat();
                    default:
                        System.out.println("No choice!");
                }
            } while (true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}