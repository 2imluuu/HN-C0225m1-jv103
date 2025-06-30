//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LoaiHang iphone = new LoaiHang("Iphone");
        LoaiHang ipad = new LoaiHang("IPad");
        LoaiHang macbook = new LoaiHang("MacBook");

        QuanLyKhoHang khoHang = new QuanLyKhoHang();

        Apple ip1 = new Iphone("16prm",150,16,"vang",true,true);
        Apple ip4 = new Iphone("15prm",210,16,"vang",true,true);
        Apple ip2 = new Ipad("16prm",300,16,"vang",true,32);
        Apple ip3 = new Macbook("air2",200,128,"vang","m4",16);

        khoHang.add(iphone , ip1);
        khoHang.add(ipad , ip2);
        khoHang.add(macbook, ip3);
        khoHang.add(iphone, ip4);

        khoHang.hienThiKhoHang();

        khoHang.timTheoTen("16prm");
    }
}