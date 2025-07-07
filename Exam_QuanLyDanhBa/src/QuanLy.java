public interface QuanLy<T> {
    boolean add(T obj);
    boolean remove(T obj);
    T remove(int index);
    T edit(int index, T obj);
}
