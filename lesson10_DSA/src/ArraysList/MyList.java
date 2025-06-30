package ArraysList;


import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object element[];

    public MyList(){
        element = new Object[DEFAULT_CAPACITY];
    };

    public MyList(int capacity){
        element = new Object[capacity];
    }

    public void ensurCapacity(int minCapacity){
        if( minCapacity > element.length ){
            element = Arrays.copyOf(element, minCapacity);
        }
    }

    public void add(int index,E e){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("Index:" +index + ", size:" + size);
        }
        if(size == element.length){
            ensurCapacity(element.length * 2);
        }
        for ( int i = size ; i > index ; i-- ){
            element[i] = element[i-1];
        }
        element[index] = e;
        size++;
    }

    public E remove(int index){
        if( index > size || index < 0){
            throw new IndexOutOfBoundsException("Index:" +index + ", size:" + size);
        }

        E removed = (E) element[index];
        for( int i = index ; i < size-1 ; i++ ){
            element[i] = element[i+1];
        }
        element[--size] = null;
        return removed;
    }

    public boolean add(E e){
        if(size == element.length){
            ensurCapacity(element.length * 2);
        }
        element[size++] = e;
        return true;
    }

    public int size(){
        return size;
    }

    public MyList<E> clone(){
        MyList<E> cloneList = new  MyList<>(element.length);
        for ( int i = 0; i < size; i++ ){
            cloneList.add((E) element[i]);
        }
        return cloneList;
    }

    public boolean contains(E o){
        return indexOf(o) >= 0;
    }

    public int indexOf(E o){
        for ( int i = 0; i< size ; i++){
            if( element[i].equals(o) ){
                return i;
            }
        }
        return -1;
    }

    public E get(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index:" +index + ", size:" + size);
        }
        return (E) element[index];
    }

    public void clear(){
        for ( int i = 0; i < size; i++){
            element[i] = null;
        }
        size = 0;
    }

}
