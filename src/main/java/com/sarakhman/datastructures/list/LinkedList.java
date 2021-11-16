package com.sarakhman.datastructures.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class LinkedList<T> implements List<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;


    @Override
    public void add(T value) {
        add(value, size);

    }

    @Override
    public void add(T value, int index) {
        throwNullPointerException(value);
        throwIndexOutOfBoundsExceptionForAdd(index);


        Node<T> newNode = new Node<T>(value);
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
            Node<T> current = fastWayToNode(index);
            newNode.setPrev(current.getPrev());
            newNode.setNext(current);
            current.prev.setNext(newNode);
            current.setPrev(newNode);

        }
        size++;
    }

    @Override
    public T remove(int index) {
        throwIndexOutOfBoundsExceptionForRemoveGetSet(index);

        Node<T> result;
        if (size == 1) {
            result = head;
            head = tail = new Node<T>(null);
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
    public T get(int index) {
        throwIndexOutOfBoundsExceptionForRemoveGetSet(index);

        if (index == 0) {
            return head.value;
        } else if (index == size - 1) {
            return tail.value;
        } else {
            Node<T> result = fastWayToNode(index);
            return result.value;
        }

    }

    @Override
    public T set(T value, int index) {
        throwNullPointerException(value);
        throwIndexOutOfBoundsExceptionForRemoveGetSet(index);


        Node<T> newNode = new Node<T>(value);
        Node<T> result = head;
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
    public boolean contains(T value) {
        throwNullPointerException(value);

        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(T value) {
        throwNullPointerException(value);

        Node<T> current = head;
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
    public int lastIndexOf(T value) {
        throwNullPointerException(value);

        Node<T> current = tail;
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

    private Node<T> fastWayToNode(int index) {
        Node<T> result;
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

    private void throwNullPointerException(T value) {
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
        Node<T> current = head;
        while (current.next != null) {
            result.add(current.value.toString());
            current = current.next;
        }
        result.add(current.value.toString());
        return result.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }


    private class MyIterator implements Iterator<T> {
        private Node<T> current = head;
        private boolean canRemove;


        @Override
        public void remove() {
            if (canRemove) {
                if (size == 1) {
                    head = tail = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else {
                    current.prev.prev.setNext(current);
                    current.setPrev(current.prev.prev);
                }
            }
            canRemove = false;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            canRemove = true;
            return value;
        }
    }


    private class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;


        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }
}

