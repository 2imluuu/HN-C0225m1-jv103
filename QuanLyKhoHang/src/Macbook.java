public class Macbook extends Apple {
    private String loaiChip;
    private int ramGB;

    public Macbook(){};
    public Macbook(String ten, double gia, int dungLuong, String mau, String loaiChip, int ramGB) {
        super(ten, gia, dungLuong, mau);
        this.loaiChip = loaiChip;
        this.ramGB = ramGB;
    }

    public String getLoaiChip() {
        return loaiChip;
    }

    public void setLoaiChip(String loaiChip) {
        this.loaiChip = loaiChip;
    }

    public int getRamGB() {
        return ramGB;
    }

    public void setRamGB(int ramGB) {
        this.ramGB = ramGB;
    }

    @Override
    public String toString() {
        return
                super.toString() +
                "\nChip : " + this.loaiChip +
                "\nRam : " + this.ramGB + "GB"+
                        "\n-----------";
    }

    @Override
    public String getLoai(){
        return "Macbook";
    }
}
