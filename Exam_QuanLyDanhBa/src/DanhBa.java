public class DanhBa {
    private String ten;
    private String soDienThoai;
    private String diaChi;
    private String email;
    private String faceBook;
    private String gioiTinh;
    private String ngaySinh;

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public DanhBa(){};

    public DanhBa(String ten, String soDienThoai, String diaChi, String email, String faceBook, String gioiTinh, String ngaySinh) {
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.email = email;
        this.faceBook = faceBook;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaceBook() {
        return faceBook;
    }

    public void setFaceBook(String faceBook) {
        this.faceBook = faceBook;
    }

    public String toString(){
        return "Tên: " + ten +
                " / SĐT: " + soDienThoai +
                " / Địa chỉ: " + diaChi +
                " / Email: " + email+
                " / FaceBook: " + faceBook+
                " / Giới tính: " + gioiTinh+
                " / Ngay sinh: " + ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }
}
