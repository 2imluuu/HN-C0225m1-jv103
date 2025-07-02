import java.util.*;

public interface HeThongQuanLy<T> {
    boolean add(T obj);

    boolean remove(T obj);

    T remove(int index);

    T edit(int index, T obj);
}
