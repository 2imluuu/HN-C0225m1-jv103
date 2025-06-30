import java.util.*;

public class QuanLyKhoHang implements HeThongQuanLy<Apple> {
    Map<LoaiHang, List<Apple>> khoHang = new HashMap<>();

    @Override
    public boolean add(LoaiHang loai, Apple apple){
        List<Apple> list = khoHang.computeIfAbsent(loai, k -> new ArrayList<>());
        if(list.contains(apple)){
            return false;
        } else {
            list.add(apple);
            return true;
        }
    }

    @Override
    public boolean remove(LoaiHang loai, Apple obj){
        List<Apple> list = khoHang.get(loai);
        return list.remove(obj);
    }

    @Override
    public Apple remove(LoaiHang loai, int index){
        List<Apple> list = khoHang.get(loai);
        if(list != null && index >= 0 && index < list.size()){
            return list.remove(index);
        }
        return null;
    }

    @Override
    public Apple edit(LoaiHang loai, int index, Apple obj) {
        List<Apple> list = khoHang.get(loai);
        if (list == null || index < 0 || index > list.size()) {
            return null;
        }
        return list.get(index);
    }


    public void timTheoLoai(LoaiHang loai){
        List<Apple> list = khoHang.get(loai);
        if(list != null && list.size() > 0){
            System.out.println(loai);
            for (Apple apple : list){
                System.out.println(apple + "\n");
            }
        } else {
            System.out.println("Kho hàng trống");
        }
    }



    public Map<LoaiHang, List<Apple>> getKhoHang() {
        return khoHang;
    }

    public void setKhoHang(Map<LoaiHang, List<Apple>> khoHang) {
        this.khoHang = khoHang;
    }

    public void hienThiKhoHang(){
        for(Map.Entry<LoaiHang, List<Apple>> entry : khoHang.entrySet()){
            System.out.println(entry.getKey() + "\n");
            for (Apple apple : entry.getValue()){
                System.out.println(apple + "\n");
            }
        }
    }

    public Map<LoaiHang, List<Apple>> timTheoTen(String ten) {
        Map<LoaiHang, List<Apple>> map = new HashMap<>();
        for(Map.Entry<LoaiHang, List<Apple>> entry : khoHang.entrySet()){
            LoaiHang loai = entry.getKey();
            List<Apple> result = new  ArrayList<>();
            for(Apple apple : entry.getValue()){
                if(apple.getTen().equals(ten)){
                    result.add(apple);
                }
            }
            if(!result.isEmpty()){
                map.put(loai, result);
            }
        }
        return  map;
    }

    public Map<LoaiHang, List<Apple>> timTheoGia(double giamax, double giamin){
        Map<LoaiHang, List<Apple>> map = new HashMap<>();
        for(Map.Entry<LoaiHang, List<Apple>> entry : khoHang.entrySet()){
            LoaiHang loai = entry.getKey();
            List<Apple> result = new  ArrayList<>();
            for(Apple apple : entry.getValue()){
                if(apple.getGia() >= giamin && apple.getGia() <= giamax){
                    result.add(apple);
                }
            }
            if(!result.isEmpty()){
                map.put(loai, result);
            }
        }
        return  map;
    }


    public Map<LoaiHang, List<Apple>> timTheoDungLuong(int dungluong){
        Map<LoaiHang, List<Apple>> map = new HashMap<>();
        for(Map.Entry<LoaiHang, List<Apple>> entry : khoHang.entrySet()) {
            LoaiHang loai = entry.getKey();
            List<Apple> result = new ArrayList<>();
            for (Apple apple : entry.getValue()) {
                if (apple.getDungLuong() == dungluong) {
                    result.add(apple);
                }
            }
            if (!result.isEmpty()) {
                map.put(loai, result);
            }
        }
        return  map;
    }

    public Map<LoaiHang, List<Apple>> timTenTheoLoai(LoaiHang loai){
        Map<LoaiHang, List<Apple>> map = new HashMap<>();
        for(Map.Entry<LoaiHang, List<Apple>> entry : khoHang.entrySet()){
            List<Apple> result = new  ArrayList<>();
            LoaiHang loaiHang = entry.getKey();
            if(entry.getKey().equals(loai)){
                for(Apple apple : entry.getValue()){
                    result.add(apple);
                }
            }
            if(!result.isEmpty()){
                map.put(loai, result);
            }
        }
        return  map;
    }
}