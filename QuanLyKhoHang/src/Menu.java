import java.util.*;


public class Menu {
    private Scanner scanner;
    private QuanLyKhoHang quanLyKhoHang;

    public Menu(Scanner scanner, QuanLyKhoHang quanLyKhoHang) {
        this.scanner = scanner;
        this.quanLyKhoHang = quanLyKhoHang;
    }

    void show() {
        System.out.println("======= Chương Trình Quản Lý Kho Apple =======");
        System.out.println("Nhập chức năng để thao tác:");
        System.out.println("1. Xem kho hàng");
        System.out.println("2. Thêm sản phẩm");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xoá");
        System.out.println("5. Tìm Kiếm");
        System.out.println("6. Thoát");
    }

    void hienThiKho() {
        tieuDe("===== Kho Hàng =====");
        if (quanLyKhoHang.getKhoHang().size() > 0) {
            quanLyKhoHang.hienThiKhoHang();
        } else {
            System.out.println("Kho hàng trống");
        }
        show();
    }

    void themSanPham() {
        tieuDe("===== Thêm Sản Phẩm =====");
        String loai = inputStr("Nhập loại hàng để phân loại:").toLowerCase();
        Apple apple;
        switch (loai) {
            case "iphone":
                apple = new Iphone();
                break;
            case "ipad":
                apple = new Ipad();
                break;
            case "macbook":
                apple = new Macbook();
                break;
            default:
                System.out.println("Không có loại hàng này");
                return;
        }
        LoaiHang loaiHang = new LoaiHang(loai);
        themThongTinSanPham(apple);
        apple.setLoaiHang(loaiHang);
        if(apple instanceof Iphone) {
            boolean checkFID = askYorN("FaceID [y/n]");
            boolean check5G = askYorN("Hỗ trợ 5G [y/n]");
            ((Iphone) apple).setFaceID(checkFID);
            ((Iphone) apple).setHoTro5G(check5G);
        } else if (apple instanceof Ipad){
            boolean checkPen = askYorN("Pen [y/n]");
            ((Ipad) apple).setPen(checkPen);
            ((Ipad) apple).setKichThuoc(kichThuoc("Nhập kích thước màn hình:"));
        } else if (apple instanceof Macbook){
            ((Macbook) apple).setLoaiChip("Loại Chip:");
            ((Macbook) apple).setRamGB(nhapDungLuong("Dung lượng Ram"));
        }

        if (quanLyKhoHang.add(apple)) {
            System.out.println("Thêm sản phẩm thành công");
        } else {
            System.out.println("Có lỗi xảy ra");
        }
        show();
    }

    void capNhapSanPham() {
        tieuDe("===== Cập Nhập Kho =====");
        if (quanLyKhoHang.getKhoHang().isEmpty()) {
            System.out.println("Không có sản phẩm nao");
            return;
        }
        String str = inputStr("Tên sản phẩm muốn update:");

        Apple apple = quanLyKhoHang.timSanPhamTheoTen(str);
        if (apple == null) {
            System.out.println("Không tìm thấy sản phẩm");
            return;
        }
        System.out.println("Bạn Muốn cập nhập thông tin gì:");
        System.out.println("1.Tên");
        System.out.println("2.Giá");
        String choice = inputStr("Nhập lựa chọn:");
        switch(choice){
            case "1":
                apple.setTen(inputStr("Nhập lại tên"));
                break;
                case "2":
                    apple.setGia(nhapGia("Nhập lại giá"));
                    break;
        }
        show();
    }

    void xoaSanPham() {
        tieuDe("===== Xoá Sản Phẩm =====");
        String ten = inputStr("Nhập tên sản phẩm muốn xoá");
        if (quanLyKhoHang.getKhoHang().isEmpty()) {
            System.out.println("Không co sản phẩm nao");
            return;
        }

        Apple apple = quanLyKhoHang.timSanPhamTheoTen(ten);
        if (apple == null) {
            System.out.println("Không tìm thấy sản phẩm");
            return;
        }
        String confirm = inputStr("Bạn muốn xoá sản phẩm này?[Y/N]").toUpperCase();
        if (confirm.equals("Y")) {
            if (quanLyKhoHang.remove(apple)) {
                System.out.println("Xoá thành công!");
            } else {
                System.out.println("Xảy ra lỗi!");
            }
        }
    }

    void timKiemSanPham() {
        tieuDe("===== Tìm Sản Phẩm====");
        int choice;
        do {
            System.out.println("1.Tìm theo tên");
            System.out.println("2.Tìm theo dung lượng");
            System.out.println("3.Tìm theo loại");
            System.out.println("4.Tìm theo giá");
            System.out.println("0.Thoát");
            System.out.println("Nhập lựa chọn:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    timTheoGiaSP();
                    break;
                case 2:
                    timTheoDungLuongSP();
                    break;
                case 3:
                    timTheoLoaiSP();
                    break;
                case 4:
                    timTheoGiaSP();
                    break;
                default:
                    System.out.println("không lựa chọn");
                    break;
            }
        } while (choice != 0);
        show();
    }

    private void timTheoGiaSP() {
        tieuDe("----- Tìm theo giá -----");
        System.out.println("Nhập vào khoảng giá bạn muốn tìm");
        System.out.println("Giá thấp nhất:");
        double giamin = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Giá cao nhất:");
        double giamax = scanner.nextDouble();
        scanner.nextLine();
        List<Apple> list = quanLyKhoHang.timTheoGia(giamin, giamax);
        if (list == null || list.isEmpty()) {
            System.out.println("Không có sản phẩm nao");
            return;
        }
        for (Apple apple : list) {
            System.out.println(apple.toString());
        }
    }

    private void timTheoLoaiSP() {
        tieuDe("----- Tìm Theo Loai -----");
        String str = inputStr("Nhập loại muốn tìm");
        LoaiHang loaiHang = new LoaiHang(str);
        List<Apple> list = quanLyKhoHang.timTenTheoLoai(loaiHang);
        if (list == null || list.isEmpty()) {
            System.out.println("Không co sản phẩm nao");
            return;
        }
        for (Apple apple : list) {
            System.out.println(apple.toString());
        }
    }

    private void timTheoDungLuongSP() {
        tieuDe("----- Tìm Theo Dung Lượng -----");
        System.out.println("Nhập dung lượng cần tìm:");
        int dungluong = scanner.nextInt();
        scanner.nextLine();

        List<Apple> list = quanLyKhoHang.timTheoDungLuong(dungluong);
        if (list == null || list.isEmpty()) {
            System.out.println("Không co sản phẩm nao");
            return;
        }
        for (Apple apple : list) {
            System.out.println(apple.toString());
        }
    }

    private void timTheoTenSP() {
        tieuDe("----- Tìm Theo Tên -----");
        String str = inputStr("Nhập tên sản phẩm cần tìm");

        List<Apple> list = quanLyKhoHang.timTheoTen(str);
        if (list == null || list.isEmpty()) {
            System.out.println("Không co sản phẩm nao");
            return;
        }
        for (Apple apple : list) {
            System.out.println(apple.toString());
        }
    }

    private int nhapDungLuong(String title) {
        String str;
        while (true) {
            System.out.println(title);
            str = scanner.nextLine();
            if (!isInteger(str)) {
                System.out.println("Nhập sai định dạng vui lòng nhập lại");
                continue;
            } else {
                return Integer.parseInt(str);
            }
        }
    }

    private Double nhapGia(String title) {
        String str;
        while (true) {
            System.out.println(title);
            str = scanner.nextLine();
            if (!isDouble(str)) {
                System.out.println("Nhập sai giá nhập lại bằng số thực");
            } else {
                return Double.parseDouble(str);
            }
        }
    }

    private Double kichThuoc(String title) {
        String str;
        while (true) {
            System.out.println(title);
            str = scanner.nextLine();
            if (!isDouble(str)) {
                System.out.println("Nhập sai giá nhập lại bằng số thực");
            } else {
                return Double.parseDouble(str);
            }
        }
    }

    private String inputStr(String title) {
        String str;
        while (true) {
            System.out.print(title);
            str = scanner.nextLine();
            if (str == "") {
                System.out.println("Trường dữ liệu không được bỏ trống. Vui lòng nhập lại!");
                continue;
            } else {
                break;
            }
        }
        return str;
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    void tieuDe(String title) {
        System.out.println(title);
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    void themThongTinSanPham(Apple apple) {
        apple.setTen(inputStr("Nhập tên sản phẩm:"));
        apple.setSoLuong(nhapDungLuong("Nhập số lượng:"));
        apple.setDungLuong(nhapDungLuong("Dung lượng máy:"));
        apple.setMau(inputStr("Nhập màu sắc:"));
        apple.setGia(nhapGia("Nhập giá sản phẩm:"));
    }

    private boolean askYorN(String message){
        String input = inputStr(message).trim().toLowerCase();
        return input.equals("y");
    }
}

