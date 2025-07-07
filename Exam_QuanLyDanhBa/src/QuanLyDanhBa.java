import java.util.*;

public class QuanLyDanhBa implements QuanLy<DanhBa>{
    private List<DanhBa> danhSachDB =  new ArrayList<>();

    @Override
    public boolean add(DanhBa obj) {
        return danhSachDB.add(obj);
    }

    @Override
    public boolean remove(DanhBa obj) {
        return danhSachDB.remove(obj);
    }

    @Override
    public DanhBa edit(int index, DanhBa obj) {
        return danhSachDB.set(index, obj);
    }

    @Override
    public DanhBa remove(int index) {
        return danhSachDB.remove(index);
    }

    public List<DanhBa> getAll() {
        return danhSachDB;
    }

    public DanhBa timTheoTen(String ten) {
        for(DanhBa danhBa : danhSachDB){
            if(danhBa.getTen().equals(ten)){
                return danhBa;
            }
        }
        return null;
    }

    public DanhBa timTheoSDT(String ten) {
        for(DanhBa danhBa : danhSachDB){
            if(danhBa.getTen().equals(ten)){
                return danhBa;
            }
        }
        return null;
    }
    public List<DanhBa> timTheoSo(String soDienThoai) {
        List<DanhBa> list = new ArrayList<>();
        for(DanhBa danhBa : danhSachDB){
            if(danhBa.getSoDienThoai().equals(soDienThoai)){
                list.add(danhBa);
            }
        }
        return list;
    }

    public void setDanhBaList(List<DanhBa> danhBaList) {
        this.danhSachDB = danhBaList;
    }

    public List<DanhBa> timTheoDSTen(String na) {
        List<DanhBa> list = new ArrayList<>();
        for(DanhBa danhBa : danhSachDB){
            if (danhBa.getTen().equalsIgnoreCase(na)){
                list.add(danhBa);
            }
        }
        return list;
    }

}
