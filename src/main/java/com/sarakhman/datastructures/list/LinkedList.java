package com.sarakhman.datastructures.list;

import java.util.Objects;
import java.util.StringJoiner;

public class LinkedList implements List{
    private int size;
    private Node head;
    private Node tail;




    @Override
    public void add(Object value) {
        if(value==null){
            throw new NullPointerException("You cannot add null element");
        }
        if(size==0){
            Node newNode = new Node(value);
            head = tail = newNode;
            size++;
        }
        else {
            add(value,size);
        }
    }

    @Override
    public void add(Object value, int index) {
        if(value==null){
            throw new NullPointerException("You cannot add null element");
        }
        if(index>size){
            throw new IndexOutOfBoundsException("You cannot add element by that index");
        }
        if(index<0){
            throw new IndexOutOfBoundsException("You cannot add element by negative index!");
        }
        Node newNode = new Node(value);
        if(size==0){
            head = tail = newNode;
        }
        else if (index == 0) {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        else if(index==size){
            tail.setPrev(tail);
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.setPrev(current.getPrev());
            newNode.setNext(current);
            current.prev.setNext(newNode);
            current.setPrev(newNode);

        }
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("There is no element in that index");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("You cannot remove element by negative index!");
        }
        Node result = new Node(null);
        if(size==1){
            result = head;
            head = new Node(null);
        }
        else if(index==size-1){
            result = tail;
            tail = tail.prev;
            tail.next = null;
        }
        else  if(index == 0){
            result = head;
            head = head.next;
            head.prev = null;
        }
        else{
            result = head;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
            result.next.setPrev(result.getPrev());
            result.prev.setNext(result.getNext());
        }



        size--;

        return result.value;

    }

    @Override
    public Object get(int index) {
        if(index>=size){
            throw new IndexOutOfBoundsException("There is no element in that index");
        }
        if(index<0){
            throw new IndexOutOfBoundsException("You cannot get element by negative index!");
        }
        Node result = head;
        if(index==0){
            return result.value;
        }
        else if(index==size-1){
            return tail.value;
        }
        else{
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        }

        return result.value;

    }

    @Override
    public Object set(Object value, int index) {
        if(index>=size){
            throw new IndexOutOfBoundsException("There is no element in that index");
        }
        if(index<0){
            throw new IndexOutOfBoundsException("You cannot remove element by negative index!");
        }
        Node newNode = new Node(value);
        Node result = head;
        if(index==0){
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        else if(index==size-1){
            result = tail;

            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        else{
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
            result.prev.setNext(newNode);
            result.next.setPrev(newNode);
            newNode.setPrev(result.getPrev());
            newNode.setNext(result.getNext());

        }

        return result.value;

    }

    @Override
    public void clear() {
        head = new Node(null);
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
    public boolean contains(Object value) {
        if(value==null){
            throw new NullPointerException("You cannot look for null element");
        }
        Node current = head;
        for (int i = 0; i < size; i++) {
            if(Objects.equals(value,current.value)){
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public int indexOf(Object value) {
        if(value==null){
            throw new NullPointerException("You cannot look for null element");
        }
        Node current = head;
        int index = 0;
        for (int i = 0; i < size-1; i++) {
            if(Objects.equals(value,current.value)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if(value==null){
            throw new NullPointerException("You cannot look for null element");
        }
        Node current = tail;
        int index = 0;
        for (int i = size; i >= 0; i--) {
            if(Objects.equals(value,current.value)){
                return index;
            }
            current = current.prev;
            index++;
        }
        return -1;

    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ","[","]");
        Node current = head;
        while (current.next != null){
            result.add(current.value.toString());
            current=current.next;
        }
        result.add(current.value.toString());
        return result.toString();
    }
}
