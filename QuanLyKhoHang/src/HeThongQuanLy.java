import java.util.*;

public interface HeThongQuanLy<T> {
        boolean add(LoaiHang loai, T obj);
        boolean remove(LoaiHang loai, T obj);
        T remove(LoaiHang loai, int index);
        T edit( LoaiHang loai, int index, T obj);
}
