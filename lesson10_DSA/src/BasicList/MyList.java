package BasicList;

import java.util.Arrays;
public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object element[];

    public MyList(){
        element = new Object[DEFAULT_CAPACITY];
    };

    private void ensureCapa(){
        int newsize = element.length*2;
        element = Arrays.copyOf(element,newsize);
    }

    public void add(E e){
        if(size == element.length){
            ensureCapa();
        }
        element[size++] = e;
    }

    public E get(int i){
        if( i >= size || i < 0){
            throw new IndexOutOfBoundsException("Index"+i+",size"+i);
        }
        return (E) element[i];
    }



}
