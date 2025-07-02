public abstract class Apple {
    private String ten;
    private double gia;
    private int dungLuong;
    private String mau;
    private LoaiHang loaiHang;
    private int soLuong;

    public Apple() {
    }

    ;

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Apple(String ten, int soLuong, LoaiHang loaiHang, String mau, int dungLuong, double gia) {
        this.ten = ten;
        this.soLuong = soLuong;
        this.loaiHang = loaiHang;
        this.mau = mau;
        this.dungLuong = dungLuong;
        this.gia = gia;
    }

    public Apple(String ten, double gia, int dungLuong, String mau) {
        this.ten = ten;
        this.gia = gia;
        this.dungLuong = dungLuong;
        this.mau = mau;
    }

    public Apple(String ten, double gia, int dungLuong, String mau, LoaiHang loaiHang) {
        this.ten = ten;
        this.gia = gia;
        this.dungLuong = dungLuong;
        this.mau = mau;
        this.loaiHang = loaiHang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }


    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(int dungLuong) {
        this.dungLuong = dungLuong;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public LoaiHang getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(LoaiHang loaiHang) {
        this.loaiHang = loaiHang;
    }

    public String toString() {
        return "\nTên : " + this.ten +
                "\nGiá : " + this.gia + "$" +
                "\nDung lượng : " + this.dungLuong + "GB" +
                "\nMàu : " + this.mau +
                "\nLoại : " + this.loaiHang.getTen();
    }

    public abstract String getLoai();
}
