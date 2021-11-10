package com.sarakhman.datastructures.queue;

public interface Queue extends Iterable{

    void enqueue(Object value);

    Object dequeue();

    Object peek();

    int size();

    boolean isEmpty();

    boolean contains(Object value);

    void clear();

    String toString();

}
