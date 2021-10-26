package com.sarakhman.datastructures.queue;

public class ArrayQueue implements Queue{


    public ArrayQueue() {
        ArrayQueue[] arrayQueue = new ArrayQueue[10];
    }

    public ArrayQueue(int initialCapacity) {
        ArrayQueue[] arrayQueue = new ArrayQueue[initialCapacity];
    }

    @Override
    public void enqueue(Object value) {

    }

    @Override
    public Object dequeue() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        arrayQueue
        return super.toString();
    }
}
