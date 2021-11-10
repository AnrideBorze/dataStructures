package com.sarakhman.datastructures.queue;

import com.sarakhman.datastructures.list.LinkedList;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class LinkedQueue implements Queue, Iterable {
    Node head;
    int size;

    @Override
    public void enqueue(Object value) {
        if(value==null){
            throw new NullPointerException("You canont add null element");
        }
        if(size==0){
            head = new Node(value);
        }
        else{
            Node current = head;
            while(current.next !=null){
                current = current.next;
            }
            current.next=new Node(value);
        }
        size++;
    }

    @Override
    public Object dequeue() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty!");
        }
        Object result = head.value;
        head = head.next;
        size--;
        return result;
    }

    @Override
    public Object peek() {
        return head.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object value) {
        if(value==null){
            throw new NullPointerException("You cannot look for null element");
        }
        Node current = head;
        for (int i = 0; i < size; i++) {

            if(Objects.equals(current.value,value)){

                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        size=0;
        head=null;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(",","[","]");
        Node current = head;
        while (current.next != null){
            result.add(current.value.toString());
            current=current.next;
        }
        return result.toString();
    }

    @Override
    public Iterator iterator() {

        return new MyIterator(size);
    }

    private class MyIterator implements Iterator{

        private int index;
        private int maximalSize;

        public MyIterator(int maximalSize) {
            this.maximalSize = maximalSize;
        }

        @Override
        public boolean hasNext() {
            return index<maximalSize;
        }

        @Override
        public Object next() {
            index++;
            return dequeue();
        }
    }

    private  class Node {
        Object value;
        Node next;

        public Node(Object value){
            this.value = value;
        }
    }
}
