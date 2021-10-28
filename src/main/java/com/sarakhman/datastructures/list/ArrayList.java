package com.sarakhman.datastructures.list;

public class ArrayList implements List{
    private int size;
    private Object[] array;

    public ArrayList(){
        array = new Object[10];
    }


    @Override
    public void add(Object value) {
        if(value==null){
            throw new NullPointerException("You cannot add null element");
        }
        if(size == array.length){
            Object[] newArray = new Object[(int)(array.length*1.5)];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array=newArray;
        }
        array[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if(value==null){
            throw new NullPointerException("You cannot add null element");
        }
        if(index>size){
            throw new IndexOutOfBoundsException("You cannot add element by that index");
        }
        else if(size == array.length){
            Object[] newArray = new Object[(int)(array.length*1.5)];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array=newArray;
        }
        size++;
        Object temp = array[index];
        Object temp2;
        array[index] = value;
        for(int i = index+1; i < size; i++){
            temp2 = array[i];
            array[i] = temp;
            temp = temp2;
        }


    }

    @Override
    public Object remove(int index) {
        if(index>=size){
            throw new IndexOutOfBoundsException("There is no element in that index");
        }
        Object result = array[index];
        for(int i =0; i<index;i++){
            array[i] = array[i];
        }
        for(int i =index; i<size-1;i++){
            array[i] = array[i+1];
        }
        size--;
        return result;
    }

    @Override
    public Object get(int index) {
        if(index>=size){
            throw new IndexOutOfBoundsException("There is no element in that index");
        }
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        if(value==null){
            throw new NullPointerException("You cannot set element on null");
        }
        if(index>=size){
            throw new IndexOutOfBoundsException("There is no element in that index");
        }
        Object result = array[index];
        array[index] = value;
        return result;
    }

    @Override
    public void clear() {
        array = new Object[10];
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
        for (int i = 0; i < size; i++) {
            if(value.equals(array[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        if(value==null){
            throw new NullPointerException("You cannot look for null element");
        }
        for (int i = 0; i < size; i++) {
            if(value.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if(value==null){
            throw new NullPointerException("You cannot look for null element");
        }
        for (int i = size; i >= 0; i--) {
            if(value.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if(i==size-1){
                break;
            }
            else{
                result.append(", ");
            }
        }
        return "[" + result + "]";
    }
}
