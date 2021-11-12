package com.sarakhman.datastructures.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class LinkedList implements List{
    private int size;
    private Node head;
    private Node tail;


    @Override
    public void add(Object value) {
        add(value, size);

    }

    @Override
    public void add(Object value, int index) {
        throwNullPointerException(value);
        throwIndexOutOfBoundsExceptionForAdd(index);


        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == 0) {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        } else if (index == size) {
            tail.setPrev(tail);
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        } else {
            Node current = fastWayToNode(index);
            newNode.setPrev(current.getPrev());
            newNode.setNext(current);
            current.prev.setNext(newNode);
            current.setPrev(newNode);

        }
        size++;
    }

    @Override
    public Object remove(int index) {
        throwIndexOutOfBoundsExceptionForRemoveGetSet(index);

        Node result;
        if (size == 1) {
            result = head;
            head = tail = new Node(null);
        } else if (index == size - 1) {
            result = tail;
            tail = tail.prev;
            tail.next = null;
        } else if (index == 0) {
            result = head;
            head = head.next;
            head.prev = null;
        } else {
            result = fastWayToNode(index);

            result.next.setPrev(result.getPrev());
            result.prev.setNext(result.getNext());
        }


        size--;

        return result.value;

    }

    @Override
    public Object get(int index) {
        throwIndexOutOfBoundsExceptionForRemoveGetSet(index);

        if (index == 0) {
            return head.value;
        } else if (index == size - 1) {
            return tail.value;
        } else {
            Node result = fastWayToNode(index);
            return result.value;
        }

    }

    @Override
    public Object set(Object value, int index) {
        throwNullPointerException(value);
        throwIndexOutOfBoundsExceptionForRemoveGetSet(index);


        Node newNode = new Node(value);
        Node result = head;
        if (index == 0) {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        } else if (index == size - 1) {
            result = tail;

            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        } else {
            result = fastWayToNode(index);
            result.prev.setNext(newNode);
            result.next.setPrev(newNode);
            newNode.setPrev(result.getPrev());
            newNode.setNext(result.getNext());

        }

        return result.value;

    }

    @Override
    public void clear() {
        head = tail = null;
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
        throwNullPointerException(value);

        return indexOf(value)>=0;
    }

    @Override
    public int indexOf(Object value) {
        throwNullPointerException(value);

        Node current = head;
        int index = 0;
        for (int i = 0; i < size - 1; i++) {
            if (Objects.equals(value, current.value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        throwNullPointerException(value);

        Node current = tail;
        int index = size - 1;
        for (int i = size; i >= 0; i--) {
            if (Objects.equals(value, current.value)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;

    }

    private Node fastWayToNode(int index) {
        Node result;
        if (index <= size / 2) {
            result = head;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        } else {
            result = tail;
            for (int i = size; i > index; i--) {
                result = result.prev;
            }
        }
        return result;
    }

    private void throwNullPointerException(Object value) {
        if (value == null) {
            throw new NullPointerException("You cannot look for null element");
        }
    }

    private void throwIndexOutOfBoundsExceptionForRemoveGetSet(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("There is no element in that index");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("You cannot remove element by negative index!");
        }
    }

    private void throwIndexOutOfBoundsExceptionForAdd(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("There is no element in that index");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("You cannot remove element by negative index!");
        }
    }


    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        Node current = head;
        while (current.next != null) {
            result.add(current.value.toString());
            current = current.next;
        }
        result.add(current.value.toString());
        return result.toString();
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }


    private class MyIterator implements Iterator {
        private Node current = head;


        @Override
        public void remove() {

        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Object value = current.value;
            current = current.next;
            return value;
        }
    }


    private class Node {
        private Object value;
        private Node next;
        private Node prev;


        public Node(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
}

