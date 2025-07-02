public class Ipad extends Apple {
    private boolean pen;
    private double kichThuoc;

    public Ipad() {
    }

    ;

    public Ipad(String ten, double gia, int dungLuong, String mau, boolean applePen, double kichThuoc) {
        super(ten, gia, dungLuong, mau);
        this.pen = applePen;
        this.kichThuoc = kichThuoc;
    }

    public Ipad(String ten, double gia, int dungLuong, String mau, LoaiHang loaiHang, boolean pen, double kichThuoc) {
        super(ten, gia, dungLuong, mau, loaiHang);
        this.pen = pen;
        this.kichThuoc = kichThuoc;
    }

    public boolean isPen() {
        return pen;
    }

    public void setPen(boolean pen) {
        this.pen = pen;
    }

    public double getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(double kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    @Override
    public String toString() {
        return
                super.toString() +
                        "\nApplePen : " + this.pen +
                        "\nKích thước màn hình : " + this.kichThuoc +
                        "\n-----------";
    }

    @Override
    public String getLoai() {
        return "Ipad";
    }
}
