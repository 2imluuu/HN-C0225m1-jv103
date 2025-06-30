public class Ipad extends Apple {
    private boolean Pen;
    private double kichThuoc;

    public Ipad(){};

    public Ipad(String ten, double gia, int dungLuong, String mau, boolean applePen, double kichThuoc) {
        super(ten, gia, dungLuong, mau);
        this.Pen = applePen;
        this.kichThuoc = kichThuoc;
    }

    public boolean isPen() {
        return Pen;
    }

    public void setPen(boolean pen) {
        Pen = pen;
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
                "\nApplePen : " + this.Pen +
                "\nKích thước màn hình : " +  this.kichThuoc +
                        "\n-----------";
    }

    @Override
    public String getLoai(){
        return "Ipad";
    }
}
