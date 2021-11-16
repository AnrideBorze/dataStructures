package com.sarakhman.datastructures.list;

import java.util.Iterator;

public class ArrayList<T> implements List<T> {
    private int size;
    private T[] array;

    public ArrayList() {
        array = (T[])new Object[10];
    }


    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public void add(T value, int index) {
        throwNullPointerException(value);
        throwIndexOutOfBoundsExceptionForAdd(index);

        insureCapacity();

        size++;
        System.arraycopy(array, index, array, index + 1, size - index - 1);
        array[index] = value;


    }

    @Override
    public T remove(int index) {
        throwIndexOutOfBoundsExceptionForSetGetRemove(index);

        T result = array[index];

//        for (int i = index; i < size - 1; i++) {
//            array[i] = array[i + 1];
//        }
        System.arraycopy(array, index+1, array, index , size - index - 1);
         size--;
        return result;
    }

    @Override
    public T get(int index) {
        throwIndexOutOfBoundsExceptionForSetGetRemove(index);

        return array[index];
    }

    @Override
    public T set(T value, int index) {
        throwNullPointerException(value);
        throwIndexOutOfBoundsExceptionForSetGetRemove(index);

        T result = array[index];
        array[index] = value;
        return result;
    }

    @Override
    public void clear() {
        array = (T[])new Object[10];
        size = 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        throwNullPointerException(value);

        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(T value) {
        throwNullPointerException(value);

        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        throwNullPointerException(value);

        for (int i = size; i >= 0; i--) {
            if (value.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>();
    }


    private class MyIterator<T> implements Iterator<T> {
        private int index;
        private boolean canRemove;

        @Override
        public void remove() {
            if(canRemove){
                ArrayList.this.remove(index-1);
            }
            else{
                throw new IllegalStateException("This element is already removed");
            }
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            index++;
            canRemove = true;
            return (T)get(index - 1);
        }
    }

    private void throwNullPointerException(T value) {
        if (value == null) {
            throw new NullPointerException("You cannot add null element");
        }
    }

    private void throwIndexOutOfBoundsExceptionForSetGetRemove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("There is no element in that index");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("You set element by negative index!");
        }
    }

    private void throwIndexOutOfBoundsExceptionForAdd(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("You cannot add element by that index");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("You cannot add element by negative index!");
        }
    }

    private void insureCapacity() {
        if (size == array.length) {
            T[] newArray = (T[])new Object[(int) (array.length * 1.5)];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i == size - 1) {
                break;
            } else {
                result.append(", ");
            }
        }
        return "[" + result + "]";
    }

}
