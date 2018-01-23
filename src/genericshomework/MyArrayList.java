package genericshomework;

import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] array = {};
    private int size = 0;

    public MyArrayList() {
    }

    public boolean add(T value){
        array = Arrays.copyOf(array, ++size);
        array[size-1] = value;
        return true;
    }
    public  T remove(int index){
        T removedElement = get(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(array, index+1, array, index,
                    numMoved);
        array[--size] = null;
        return removedElement;
    }
    public void clear() {
        for (int i = 0; i < size; i++)
            array[i] = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }else return (T) array[index];
    }
}
