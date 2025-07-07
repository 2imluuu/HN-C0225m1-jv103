import java.sql.Array;
import java.util.*;

public class QuanLyKhoHang implements HeThongQuanLy<Apple> {
    List<Apple> list = new ArrayList<>();

    @Override
    public boolean add(Apple apple) {
        if (list.contains(apple)) {
            return false;
        } else {
            list.add(apple);
            return true;
        }
    }

    @Override
    public boolean remove(Apple obj) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        return list.remove(obj);
    }

    @Override
    public Apple remove(int index) {
        if (list == null || index < 0 || index > list.size()) {
            return null;
        }
        return list.remove(index);
    }

    @Override
    public Apple edit(int index, Apple obj) {
        if (list == null || index < 0 || index > list.size()) {
            return null;
        }
        return list.get(index);
    }


    public void timTheoLoai(LoaiHang loai) {
        if (list != null && !list.isEmpty()) {
            for (Apple apple : list) {
                if (apple.getLoai().equals(loai)) {
                    System.out.println(apple + "\n");
                }
            }
        } else {
            System.out.println("Kho hàng trống");
        }
    }


    public List<Apple> getKhoHang() {
        return list;
    }

    public void setKhoHang(List<Apple> khoHang) {
        this.list = khoHang;
    }

    public void hienThiKhoHang() {
        for (Apple apple : list) {
            System.out.println(apple + "\n");
        }
    }

    public Apple timSanPhamTheoTen(String ten) {
        List<Apple> filters = new ArrayList<>();
        for (Apple apple : list) {
            if (apple.getTen().equalsIgnoreCase(ten)) {
                return apple;
            }
        }
        return null;
    }

    public List<Apple> timTheoTen(String ten) {
        List<Apple> filters = new ArrayList<>();
        for (Apple apple : list) {
            if (apple.getTen().equalsIgnoreCase(ten)) {
                filters.add(apple);
            }
        }
        return filters;
    }

    public List<Apple> timTheoGia(double giaMax, double giaMin) {
            List<Apple> result = new ArrayList<>();
            for (Apple apple : list) {
                if (apple.getGia() >= giaMin && apple.getGia() <= giaMax) {
                    result.add(apple);
                }
            }
        return result;
    }


    public List<Apple> timTheoDungLuong(int dungLuong) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (apple.getDungLuong() == dungLuong) {
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> timTenTheoLoai(LoaiHang loai) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (apple.getLoaiHang().equals(loai)) {
                result.add(apple);
            }
        }
        return result;
    }
}