package com.sarakhman.datastructures.queue;

import java.util.Iterator;

public class ArrayQueue implements Queue, Iterable {
    private int size;
    private Object[] array;

    public ArrayQueue() {
        array = new Object[10];
    }

    public ArrayQueue(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    @Override
    public void enqueue(Object value) {
        throwNullPointerException(value);

        ensureCapacity();

        array[size] = value;
        size++;
    }

    @Override
    public Object dequeue() {
        throwIllegalStateException();
        Object result = array[0];
        System.arraycopy(array,1,array,0,size);
        array[size] = null;
        size--;
        return result;

    }

    @Override
    public Object peek() {
        throwIllegalStateException();
        return array[0];
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
    public boolean contains(Object value) {
        throwNullPointerException(value);
        for (int i = 0; i < size; i++) {
            Object valueInQueue = array[i];
            if (value.equals(valueInQueue))
                return true;
        }
        return false;
    }

    @Override
    public void clear() {
        array = new Object[10];
        size = 0;
    }

    private void throwIllegalStateException(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
    }

    private void throwNullPointerException(Object value){
        if (value == null) {
            throw new NullPointerException("You cannot add null element");
        }
    }

    private void ensureCapacity(){
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
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
            result.append(array[i].toString());
            if (i == size - 1) {
                break;
            } else {
                result.append(", ");
            }
        }
        return "[" + result + "]";
    }

    @Override
    public Iterator iterator() {
        return new MyIterator(size);
    }

    private class MyIterator implements Iterator {
        private int index;
        private int maximalSize;

        public MyIterator(int maximalSize) {
            this.maximalSize = maximalSize;
        }

        @Override
        public boolean hasNext() {
            return index < maximalSize;
        }

        @Override
        public Object next() {
            index++;
            return dequeue();
        }
    }
}
