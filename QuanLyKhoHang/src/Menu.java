import java.util.*;


public class Menu {
    private Scanner scanner;
    private QuanLyKhoHang quanLyKhoHang;
    private AppleFileIO appleFileIo = new AppleFileIO();

    public Menu(Scanner scanner, QuanLyKhoHang quanLyKhoHang) {
        this.scanner = scanner;
        this.quanLyKhoHang = quanLyKhoHang;
    }

    void hienThi() {
        System.out.println("======= Chương Trình Quản Lý Kho Apple =======");
        System.out.println("Nhập chức năng để thao tác:");
        System.out.println("1. Xem kho hàng");
        System.out.println("2. Thêm sản phẩm");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xoá");
        System.out.println("5. Tìm Kiếm");
        System.out.println("6. Đọc file");
        System.out.println("7. Ghi file");
        System.out.println("0. Thoát");
    }

    void hienThiKho() {
        tieuDe("===== Kho Hàng =====");
        if (quanLyKhoHang.getKhoHang().size() > 0) {
            quanLyKhoHang.hienThiKhoHang();
        } else {
            System.out.println("Kho hàng trống");
        }
        hienThi();
    }

    void themSanPham() {
        tieuDe("===== Thêm Sản Phẩm =====");
        Apple apple;
        String loai = inputStr("Nhập loại hàng để phân loại (Iphone/Ipad/Macbook):").toLowerCase();
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
                System.out.println("Nhập sai loại");
                return;
        }

        LoaiHang loaiHang = new LoaiHang(loai);
        themThongTinSanPham(apple);
        apple.setLoaiHang(loaiHang);
        if (apple instanceof Iphone) {
            boolean checkFID = kiemTraDungSai("FaceID [y/n]");
            boolean check5G = kiemTraDungSai("Hỗ trợ 5G [y/n]");
            ((Iphone) apple).setFaceID(checkFID);
            ((Iphone) apple).setHoTro5G(check5G);
        } else if (apple instanceof Ipad) {
            boolean checkPen = kiemTraDungSai("Pen [y/n]");
            ((Ipad) apple).setPen(checkPen);
            ((Ipad) apple).setKichThuoc(soNguyen("Nhập kích thước màn hình:"));
        } else if (apple instanceof Macbook) {
            ((Macbook) apple).setLoaiChip(inputStr("Loai chip:"));
            ((Macbook) apple).setRamGB(soNguyen("Dung lượng Ram"));
        }

        if (quanLyKhoHang.add(apple)) {
            System.out.println("Thêm sản phẩm thành công");
        } else {
            System.out.println("Có lỗi xảy ra");
        }
        hienThi();
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
        int choice;
        do {
            System.out.println("Bạn Muốn cập nhập thông tin gì:");
            System.out.println("1.Tên");
            System.out.println("2.Giá");
            System.out.println("3.Số Lượng");
            System.out.println("0.Thoát");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    apple.setTen(inputStr("Cập nhập tên:"));
                    break;
                case 2:
                    apple.setGia(soThuc("Cập nhập giá:"));
                    break;
                case 3:
                    apple.setSoLuong(soNguyen("Cập nhập số lượng:"));
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
            }
            for (int i = 0; i < quanLyKhoHang.getKhoHang().size(); i++) {
                quanLyKhoHang.edit(i, apple);
                System.out.println("Cập nhập thành công, bạn có muốn cập nhập thêm thông tin:");
            }
        } while (choice != 0);
        hienThi();
    }

    void xoaSanPham() {
        tieuDe("===== Xoá Sản Phẩm =====");
        String ten = inputStr("Nhập tên sản phẩm muốn xoá");
        if (quanLyKhoHang.getKhoHang().isEmpty()) {
            System.out.println("Không co sản phẩm nao");
            return;
        }

        Apple apple = (Apple) quanLyKhoHang.timSanPhamTheoTen(ten);
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
        hienThi();
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
        hienThi();
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

    private int soNguyen(String title) {
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

    private Double soThuc(String title) {
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

    void docTuFile() {
        tieuDe("---- ĐỌC TỪ FILE ----");
        String confirm = inputStr("Cảnh báo: Lựa chọn này sẽ xóa toàn bộ bộ nhớ! [Y/n]: ");
        if (confirm.toUpperCase().equals("Y")) {
            List<Apple> docFileList = appleFileIo.readCSV("contacts.csv");
            if (docFileList.size() > 0) {
                System.out.println("Đọc từ file \"data/contacts.csv\" thành công!");
                quanLyKhoHang.setKhoHang(docFileList);
            } else {
                System.out.println("Đã xảy ra lỗi đọc file!");
            }
        }
    }

    void ghiVaoFile() {
        tieuDe("---- GHI VÀO FILE ----");
        String confirm = inputStr("Cảnh báo: Lựa chọn này sẽ ghi đè nội dung mới! [Y/n]: ");
        if (confirm.toUpperCase().equals("Y")) {
            if (appleFileIo.writeCSVFile(quanLyKhoHang.getKhoHang(), "contacts.csv")) {
                System.out.println("Ghi vào file \"data/contacts.csv\" thành công!");
            } else {
                System.out.println("Đã xảy ra lỗi ghi file!");
            }
        }
    }
    void themThongTinSanPham(Apple apple) {
        apple.setTen(inputStr("Nhập tên sản phẩm:"));
        apple.setSoLuong(soNguyen("Nhập số lượng:"));
        apple.setDungLuong(soNguyen("Dung lượng máy:"));
        apple.setMau(inputStr("Nhập màu sắc:"));
        apple.setGia(soThuc("Nhập giá sản phẩm:"));
    }

    private boolean kiemTraDungSai(String message) {
        String input = inputStr(message).trim().toLowerCase();
        return input.equals("y");
    }
}

