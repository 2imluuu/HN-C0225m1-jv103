import java.util.*;

public class Menu {
    private Scanner scanner;
    private QuanLyDanhBa quanLyDanhBa;
    private FormValidator formValidator = new  FormValidator();
    private DanhBaFileIO danhBaFileIO = new DanhBaFileIO();

    public Menu(Scanner scanner, QuanLyDanhBa quanLyDanhBa) {
        this.scanner = scanner;
        this.quanLyDanhBa = quanLyDanhBa;
    }


    void hienThi(){
        tieuDe("===== HỆ THỐNG QUẢN LÝ DANH BẠ =====");
        System.out.println("1. Hiển thị danh bạ");
        System.out.println("2. Thêm người liên hệ");
        System.out.println("3. Xoá người liên hệ");
        System.out.println("4. Sửa thông tin người liên hệ");
        System.out.println("5. Tìm kiếm liên hệ");
        System.out.println("6. Đọc fileIO");
        System.out.println("7. Ghi fileIO");
        System.out.println("0. Thoát");
        System.out.println("Mời nhập chức năng: ");
    }

    void xemDanhBa(){
        tieuDe("===== HIỂN THỊ DANH SÁCH =====");
        if(quanLyDanhBa.getAll().size() <= 0){
            System.out.println("Danh bạ trống.");
        }
        for(DanhBa danhBa : quanLyDanhBa.getAll()){
            System.out.println(danhBa.toString());
        }
    }

    void themLienHe(){
        tieuDe("===== THÊM NGƯỜI LIÊN HỆ =====");
        DanhBa danhBa = new DanhBa();
        danhBa.setTen(inputStr("Nhập tên người liên hệ: "));
        danhBa.setSoDienThoai(nhapSoDienThoai("Nhập số điện thoại liên hệ: "));
        danhBa.setDiaChi(inputStr("Nhập địa chỉ: "));
        danhBa.setEmail(nhapEmail("Nhập địa chỉ email: "));
        danhBa.setFaceBook(inputStr("Nhập địa chỉ MXH: "));
        danhBa.setGioiTinh(inputStr("Chọn giới tính: "));
        danhBa.setNgaySinh(inputStr("Ngày Tháng Năm Sinh [dd/mm/yy]: "));
        if(quanLyDanhBa.add(danhBa)){
            System.out.println("Thêm thành công");
        } else {
            System.out.println("Xảy ra lỗi");
        }
        hienThi();
    }

    void capNhatDanhBa() {
        tieuDe("---- CẬP NHẬT ----");
        String soDienThoai = inputStr("Nhập vào số điện thoại của danh bạ cần sửa: ");
        DanhBa danhBa = quanLyDanhBa.timTheoSDT(soDienThoai);
        if (danhBa != null) {
            danhBa.setSoDienThoai(nhapSoDienThoai("Nhập số điện thoại: "));
            danhBa.setFaceBook(inputStr("Nhập MXH: "));
            danhBa.setTen(inputStr("Nhập tên: "));
            danhBa.setGioiTinh(inputStr("Nhập Giới tính: "));
            danhBa.setDiaChi(inputStr("Nhập Địa chỉ: "));
            danhBa.setNgaySinh(inputStr("Nhập Ngày sinh [dd/mm/yyy]: "));
            danhBa.setEmail(nhapEmail("Nhập Email: "));
            for (int i = 0; i < quanLyDanhBa.getAll().size(); i++) {
                quanLyDanhBa.edit(i, danhBa);
                System.out.println("Sửa danh bạ thành công!");
            }
        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
        }
    }

    void timKiemDanhBa() {
        tieuDe("---- TÌM KIẾM DANH BẠ ----");
        int choiceSearch;
        do {
            System.out.println("1. Tìm theo số điện thoại");
            System.out.println("2. Tìm theo họ tên");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            choiceSearch = scanner.nextInt();
            scanner.nextLine();
            switch (choiceSearch) {
                case 1:
                    timTheoSoDienThoai();
                    break;
                case 2:
                    timTheoHoTen();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("No choice!");
            }
        } while (choiceSearch != 0);
    }

    void docTuFile() {
        tieuDe("---- ĐỌC TỪ FILE ----");
        String confirm = inputStr("Cảnh báo: Lựa chọn này sẽ xóa toàn bộ bộ nhớ! [Y/n]: ");
        if (confirm.toUpperCase().equals("Y")) {
            List<DanhBa> docFileList = danhBaFileIO.readCSV("contacts.csv");
            if (docFileList.size() > 0) {
                System.out.println("Đọc từ file \"data/contacts.csv\" thành công!");
                quanLyDanhBa.setDanhBaList(docFileList);
            } else {
                System.out.println("Đã xảy ra lỗi đọc file!");
            }
        }
    }

    void ghiVaoFile() {
        tieuDe("---- GHI VÀO FILE ----");
        String confirm = inputStr("Cảnh báo: Lựa chọn này sẽ ghi đè nội dung mới! [Y/n]: ");
        if (confirm.toUpperCase().equals("Y")) {
            if (danhBaFileIO.writeCSVFile(quanLyDanhBa.getAll(), "contacts.csv")) {
                System.out.println("Ghi vào file \"data/contacts.csv\" thành công!");
            } else {
                System.out.println("Đã xảy ra lỗi ghi file!");
            }
        }
    }


    void thoat() {
        tieuDe("---- THOÁT CHƯƠNG TRÌNH ----");
        System.exit(0);
    }


    private void timTheoSoDienThoai() {
        tieuDe("---- TÌM THEO SỐ ĐIỆN THOẠI ----");
        String soDienThoai = inputStr("Nhập số điện thoại: ");
        List<DanhBa> danhBaList = quanLyDanhBa.timTheoSo(soDienThoai);
        if (danhBaList.size() > 0) {
            System.out.println("Tìm thấy " + danhBaList.size() + " kết quả cho: " + soDienThoai);
            for (DanhBa danhBa: danhBaList) {
                System.out.println(danhBa.toString());
            }
        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
        }
    }

    private void timTheoHoTen() {
        tieuDe("---- TÌM THEO HỌ TÊN ----");
        String hoTen = inputStr("Nhập họ tên: ");
        List<DanhBa> danhBaList = quanLyDanhBa.timTheoDSTen(hoTen);
        if (danhBaList.size() > 0) {
            for (DanhBa danhBa: danhBaList) {
                System.out.println(danhBa.toString());
            }
        } else {
            System.out.println("Không tìm được người liên hệ này");
        }
    }

    void xoaLienHe(){
        tieuDe("===== XOÁ LIÊN HỆ =====");
        String str = inputStr("Nhập số điện thoại muốn xoá:");
        DanhBa danhBa = quanLyDanhBa.timTheoSDT(str);
        if (danhBa != null) {
            String confirm = inputStr("Bạn thực sự muốn xóa danh bạ này? [Y/n]: ");
            if (confirm.toUpperCase().equals("Y")) {
                if (quanLyDanhBa.remove(danhBa)) {
                    System.out.println("Xóa danh bạ thành công!");
                } else {
                    System.out.println("Có lỗi xảy ra, vui lòng thử lại!");
                }
            } else {
                return;
            }
        } else {
            System.out.println("Không tìm được số điện thoại trên");
        }
    }

    void tieuDe(String str){
        System.out.println(str);
    }

    private String inputStr(String title){
        String str;
        while(true){
            System.out.println(title);
            str = scanner.nextLine();
            if(str == ""){
                System.out.println("Không được để trống, nhập lại");
                continue;
            } else {
                break;
            }
        }
        return str;
    }

    private String nhapSoDienThoai(String title){
        String str;
        while(true){
            System.out.println(title);
            str = scanner.nextLine();
            if(str == ""){
                System.out.println("Không được để trống, nhập lại:");
                continue;
            }  else if ( !formValidator.phone(str)){
                System.out.println("Sai định dạng mời nhập lại:");
            } else {
                break;
            }
        }
        return str;
    }

    private String  nhapEmail(String title){
        String str;
        while(true){
            System.out.println(title);
            str = scanner.nextLine();
            if(str == ""){
                System.out.println("Không được để trống, nhập lại:");
                continue;
            }  else if ( !formValidator.email(str)){
                System.out.println("Sai định dạng mời nhập lại:");
            } else {
                break;
            }
        }
        return str;
    }
}
