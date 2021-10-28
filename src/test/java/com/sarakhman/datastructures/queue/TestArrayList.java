package com.sarakhman.datastructures.queue;

import com.sarakhman.datastructures.list.ArrayList;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;



public class TestArrayList {
    @Test
    public void testToStringReturnGoodText(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("HELLO");
        arrayList.add("ANATOLIY");


        assertEquals("[HELLO, ANATOLIY]", arrayList.toString());

    }


    @Test
    public void testLastIndexOfReturnIndex(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        assertEquals(2, arrayList.lastIndexOf("A"));

    }
    @Test
    public void testLastIndexOfReturnNegativeWhenObjectDoesNotContains(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        assertEquals(-1, arrayList.lastIndexOf("C"));

    }

    @Test
    public void testIndexOfReturnNegativeWhenObjectDoesNotContains(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        assertEquals(-1, arrayList.indexOf("C"));

    }

    @Test
    public void testIndexOfReturnIndex(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        assertEquals(0, arrayList.indexOf("A"));

    }



    @Test
    public void testContainsReturnTrueWhenObjectContains(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        assertTrue(arrayList.contains("A"));

    }
    @Test
    public void testContainsReturnFalseInEmptyArrayList(){
        ArrayList arrayList = new ArrayList();
        assertFalse(arrayList.contains("A"));

    }

    @Test
    public void testContainsReturnFalseWhenObjectNotContains(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("B");
        arrayList.add("C");
        assertFalse(arrayList.contains("A"));

    }


    @Test
    public void testAddAndSizeWorkCorrectly(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        assertEquals(1,arrayList.size());
        arrayList.add("B");
        assertEquals(2,arrayList.size());
        arrayList.add("C");
        assertEquals(3,arrayList.size());

    }
    @Test
    public void testAddAndSizeAndRemoteWorkCorrectlyWithSecondaryCalling(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        assertEquals(1,arrayList.size());
        arrayList.add("B");
        assertEquals(2,arrayList.size());
        arrayList.add("C");
        assertEquals(3,arrayList.size());
        arrayList.remove(2);
        assertEquals(2,arrayList.size());
        arrayList.remove(1);
        assertEquals(1,arrayList.size());
        arrayList.remove(0);
        assertEquals(0,arrayList.size());
        arrayList.add("A");
        assertEquals(1,arrayList.size());
        arrayList.add("B");
        assertEquals(2,arrayList.size());
        arrayList.add("C");
        assertEquals(3,arrayList.size());
        arrayList.remove(2);
        assertEquals(2,arrayList.size());
        arrayList.remove(1);
        assertEquals(1,arrayList.size());
        arrayList.remove(0);
        assertEquals(0,arrayList.size());
    }

    @Test
    public void testAddAndSizeAndClearWorkAndIsEmptyCorrectly(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        assertEquals(1,arrayList.size());
        arrayList.clear();
        assertTrue(arrayList.isEmpty());
        assertEquals(0,arrayList.size());


    }
    @Test
    public void testAddWithIndexAndRemoveWorkCorrectly(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B",0);
        arrayList.add("C",0);
        arrayList.add("D",0);
        assertEquals("D",arrayList.remove(0));
        assertEquals("C",arrayList.remove(0));
        assertEquals("B",arrayList.remove(0));
        assertEquals("A",arrayList.remove(0));
        assertEquals(0,arrayList.size());



    }

    @Test
    public void testAddWithIndexAndRemoveWorkCorrectlyTwo(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B",0);
        arrayList.add("C",1);
        arrayList.add("D",1);
        assertEquals("B",arrayList.remove(0));
        assertEquals("D",arrayList.remove(0));
        assertEquals("A",arrayList.remove(1));
        assertEquals("C",arrayList.remove(0));
        assertEquals(0,arrayList.size());

    }

    @Test
    public void testAddThrowIndexOutOfBoundsExceptionWhenIndexIsOutOfBounds() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("A");
            arrayList.add("D",3);;

        });
    }

    @Test
    public void testAddThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(1);
            arrayList.get(1);
            arrayList.set("A", 1);
        });
    }
    @Test
    public void testGetThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(1);
        });
    }
    @Test
    public void testSetThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("A", 1);
        });
    }
    @Test
    public void testRemoveThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(1);
        });
    }

    @Test
    public void testRemoveThrowIndexOutOfBoundsExceptionWhenIndexIsOutOfSize() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("A");
            arrayList.add("B");
            arrayList.remove(2);
        });
    }

    @Test
    public void testGetThrowIndexOutOfBoundsExceptionWhenIndexIsOutOfSize() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("A");
            arrayList.add("B");
            arrayList.get(2);
        });
    }

    @Test
    public void testSetThrowIndexOutOfBoundsExceptionWhenIndexIsOutOfSize() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("A");
            arrayList.add("B");
            arrayList.set("A", 2);
        });
    }

    @Test
    public void testAddAndGetAndSizeWorkCorrectly() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A",2);
        arrayList.add("B",3);
        assertEquals("A",arrayList.get(0));
        assertEquals(4,arrayList.size());
        assertEquals("B",arrayList.get(1));
        assertEquals(4,arrayList.size());
        assertEquals("A",arrayList.get(2));
        assertEquals(4,arrayList.size());
        assertEquals("B",arrayList.get(3));
        assertEquals(4,arrayList.size());

    }

    @Test
    public void testAddAndSetAndGetWorkCorrectly() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        assertEquals("A",arrayList.get(0));
        assertEquals("B",arrayList.get(1));
        arrayList.set("A",1);
        arrayList.set("B",0);
        assertEquals("B",arrayList.get(0));
        assertEquals("A",arrayList.get(1));


    }
}
