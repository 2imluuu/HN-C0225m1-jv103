import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        LoaiHang iphone = new LoaiHang("Iphone");
//        LoaiHang ipad = new LoaiHang("IPad");
//        LoaiHang macbook = new LoaiHang("MacBook");
//
//        QuanLyKhoHang khoHang = new QuanLyKhoHang();
//
//        Apple ip1 = new Iphone("16prm", 150, 16, "vang", iphone, true, true);
//        Apple ip4 = new Iphone("15prm", 210, 16, "vang", iphone, true, true);
//        Apple ip2 = new Ipad("16prm", 300, 16, "vang", ipad, true, 32);
//        Apple ip3 = new Macbook("air2", 200, 128, "vang", ipad, "m4", 16);
//
//        khoHang.add(ip1);
//        khoHang.add(ip2);
//        khoHang.add(ip3);
//        khoHang.add(ip4);
//
//        khoHang.hienThiKhoHang();
//
//        khoHang.timTheoTen("16prm");


        QuanLyKhoHang quanLyKho = new QuanLyKhoHang();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner, quanLyKho);
        menu.hienThi();
        int choice;
        do {
            System.out.println("Nhập lựa chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    menu.hienThiKho();
                    break;
                case 2:
                    menu.themSanPham();
                    break;
                case 3:
                    menu.capNhapSanPham();
                    break;
                case 4:
                    menu.xoaSanPham();
                    break;
                case 5:
                    menu.timKiemSanPham();
                    break;
                case 6:
                    menu.docTuFile();
                    break;
                case 7:
                    menu.ghiVaoFile();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn lại chức năng");
                    break;
            }
        } while (true);
    }
}