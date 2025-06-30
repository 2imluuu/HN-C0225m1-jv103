import java.util.*;


public class Menu {
  private Scanner scanner;
  private QuanLyKhoHang quanLyKhoHang;

  public Menu(Scanner scanner, QuanLyKhoHang quanLyKhoHang) {
      this.scanner = scanner;
      this.quanLyKhoHang = quanLyKhoHang;
  }

  void show(){
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
      }
      else {
          System.out.println("Kho hàng trống");
      }
  }

  void themSanPham(){
      tieuDe("===== Thêm Sản Phẩm =====");
      String loai = inputStr("Nhập loại hàng để phân loại:").toLowerCase();
      Apple apple;
      switch (loai){
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

      apple.setTen(inputStr("Nhập tên sản phẩm:"));
      apple.setDungLuong(nhapDungLuong("Dung lượng máy:"));
      apple.setMau(inputStr("Nhập màu sắc:"));
      apple.setGia(nhapGia("Nhập giá sản phẩm:"));

      if( quanLyKhoHang.add(loaiHang,apple) ){
          System.out.println("Thêm sản phẩm thành công");
      } else {
          System.out.println("Có lỗi xảy ra");
      }
  }

  void capNhapSanPham(){
      tieuDe("===== Cập Nhập Kho =====");
      String str = inputStr("Tên sản phẩm muốn update:");
      Map<LoaiHang, List<Apple>> map = quanLyKhoHang.timTheoTen(str);

      if( map == null){
          System.out.println("Không tìm thấy sản phẩm");
          return;
      }

      for(Map.Entry<LoaiHang, List<Apple>> entry : map.entrySet()){
          LoaiHang loai = entry.getKey();
          List<Apple> list = entry.getValue();
          for ( Apple apple : list) {
              System.out.println("Cập nhật sản phẩm...");
              apple.setTen(inputStr("Nhập tên sản phẩm:"));
              apple.setDungLuong(nhapDungLuong("Dung lượng máy:"));
              apple.setMau(inputStr("Nhập màu sắc:"));
              apple.setGia(nhapGia("Nhập giá sản phẩm:"));
              System.out.println("Cập nhập thành công");
              System.out.println(apple);
          }
      }
  }

  void xoaSanPham(){
      tieuDe("===== Xoá Sản Phẩm =====");
      String ten = inputStr("Nhập tên sản phẩm muốn xoá");
      Map<LoaiHang, List<Apple>> map = quanLyKhoHang.timTheoTen(ten);
      if(map == null || map.isEmpty()){
          System.out.println("không có sản phẩm này!");
          return;
      }
      for( Map.Entry<LoaiHang, List<Apple>> entry : map.entrySet()){
          LoaiHang loai = entry.getKey();
          List<Apple> list = entry.getValue();
          for( Apple apple : list){
              if(apple.getTen().equals(ten)){
                  String comfirm = inputStr("Bạn muốn xoá sản phẩm này?[Y/N]").toUpperCase();
                  if(comfirm.equals("Y")){
                      if(quanLyKhoHang.remove(loai,apple)){
                          System.out.println("Xoá thành công!");
                      } else {
                          System.out.println("Xảy ra lỗi!");
                      }
                  }
              }
          }
      }
  }

  void timKiemSanPham(){
      tieuDe("===== Tìm Sản Phẩm====");
      int choice;
      do {
          System.out.println("1.Tìm theo tên");
          System.out.println("2.Tìm theo dung lượng");
          System.out.println("3.Tìm theo loại");
          System.out.println("4.Tìm theo giá");
          System.out.println("Nhập lựa chọn:");
          choice = scanner.nextInt();
          scanner.nextLine();
          switch(choice){
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
        Map<LoaiHang, List<Apple>> map = quanLyKhoHang.timTheoGia(giamin, giamax);
        if(map.size() > 0){
            for( Map.Entry<LoaiHang, List<Apple>> entry : map.entrySet()){
                for( Apple apple : entry.getValue()){
                    System.out.println(apple.toString());
                }
            }
        }

    }

    private void timTheoLoaiSP() {
      tieuDe("----- Tìm Theo Loai -----");
        String str = inputStr("Nhập loại muốn tìm");
        LoaiHang loaiHang = new LoaiHang(str);
        Map<LoaiHang, List<Apple>> map =  quanLyKhoHang.timTenTheoLoai(loaiHang);
        if( map.size() > 0){
            for( Map.Entry<LoaiHang, List<Apple>> entry : map.entrySet()){
                for( Apple apple : entry.getValue()){
                    System.out.println(apple.toString());
                }
            }
        }
    }

    private void timTheoDungLuongSP() {
      tieuDe("----- Tìm Theo Dung Lượng -----");
      System.out.println("Nhập dung lượng cần tìm:");
      int dungluong = scanner.nextInt();
      scanner.nextLine();
      Map<LoaiHang, List<Apple>> map = quanLyKhoHang.timTheoDungLuong(dungluong);
      if( map.size() > 0){
          for( Map.Entry<LoaiHang, List<Apple>> entry : map.entrySet()){
              for(Apple apple : entry.getValue()){
                  System.out.println(apple.toString());
              }
          }
      }
    }

    private void timTheoTenSP() {
      tieuDe("----- Tìm Theo Tên -----");
      String str = inputStr("Nhập tên sản phẩm cần tìm");
      Map<LoaiHang, List<Apple>> map = quanLyKhoHang.timTheoTen(str);
      if(map.size() > 0){
          for( Map.Entry<LoaiHang, List<Apple>> entry : map.entrySet()){
              for(Apple apple : entry.getValue()){
                  System.out.println(apple.toString());
              }
          }
      } else {
          System.out.println("Không tìm thấy sản phẩm");
      }
    }

    private int nhapDungLuong(String title){
      String str;
      while(true){
          System.out.println(title);
          str = scanner.nextLine();
          if ( !isInteger(str)){
              System.out.println("Nhập sai định dạng vui lòng nhập lại");
              continue;
          } else {
              return Integer.parseInt(str);
          }
      }
  }

  private Double nhapGia(String title){
      String str;
      while(true){
          System.out.println(title);
          str = scanner.nextLine();
          if ( !isDouble(str)){
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

  public static boolean isDouble(String str){
      try {
          Double.parseDouble(str);
          return true;
      }
      catch (NumberFormatException e) {
          return false;
      }
  }
  void tieuDe(String title){
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
}

