public class LoaiHang {
    private String ten;

    public LoaiHang(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof LoaiHang)) return false;
        LoaiHang other = (LoaiHang) obj;
        return this.ten.equalsIgnoreCase(other.ten);
    }

    @Override
    public int hashCode() {
        return ten.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return ten;
    }
}
