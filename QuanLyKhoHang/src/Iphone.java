public class Iphone extends Apple {
    private boolean hoTro5G;
    private boolean faceID;

    public Iphone() {
    }

    public Iphone(String ten, int soLuong, double gia, int dungLuong, String mau, LoaiHang loaiHang, boolean hoTro5G, boolean faceID) {
        super(ten, soLuong, loaiHang, mau, dungLuong, gia);
        this.hoTro5G = hoTro5G;
        this.faceID = faceID;
    }

    public boolean isHoTro5G() {
        return hoTro5G;
    }

    public void setHoTro5G(boolean hoTro5G) {
        this.hoTro5G = hoTro5G;
    }

    public boolean isFaceID() {
        return faceID;
    }

    public void setFaceID(boolean faceID) {
        this.faceID = faceID;
    }

    @Override
    public String toString() {
        return
                super.toString() +
                        "\nFaceID : " + this.faceID +
                        "\n5G : " + this.hoTro5G +
                        "\n-----------"
                ;
    }

    @Override
    public String getLoai() {
        return "Iphone";
    }
}
