public abstract class Apple {
    private String ten;
    private double gia;
    private int dungLuong;
    private String mau;

    public Apple(){};

    public Apple(String ten, double gia, int dungLuong, String mau) {
        this.ten = ten;
        this.gia = gia;
        this.dungLuong = dungLuong;
        this.mau = mau;
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

    public String toString(){
        return "\nTên : " + this.ten +
                "\nGiá : " + this.gia + "$" +
                "\nDung lượng : " + this.dungLuong + "GB" +
                "\nMàu : " + this.mau;
    }

    public abstract String getLoai();
}
