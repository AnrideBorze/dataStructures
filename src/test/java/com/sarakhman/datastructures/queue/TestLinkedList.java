package com.sarakhman.datastructures.queue;

import com.sarakhman.datastructures.list.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestLinkedList {
    @Test
    public void testToStringReturnGoodText(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("HELLO");
        linkedList.add("ANATOLIY");


        assertEquals("[HELLO, ANATOLIY]", linkedList.toString());

    }


    @Test
    public void testLastIndexOfReturnIndex(){
        LinkedList linkedList = new LinkedList();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("A");
        assertEquals(0, linkedList.lastIndexOf("A"));

    }
    @Test
    public void testLastIndexOfReturnNegativeWhenObjectDoesNotContains(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        assertEquals(-1, linkedList.lastIndexOf("C"));

    }

    @Test
    public void testIndexOfReturnNegativeWhenObjectDoesNotContains(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        assertEquals(-1, linkedList.indexOf("C"));

    }

    @Test
    public void testIndexOfReturnIndex(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("A");
        assertEquals(0, linkedList.indexOf("A"));

    }



    @Test
    public void testContainsReturnTrueWhenObjectContains(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        assertTrue(linkedList.contains("A"));

    }
    @Test
    public void testContainsReturnFalseInEmptylinkedList(){
        LinkedList linkedList = new LinkedList();
        assertFalse(linkedList.contains("A"));

    }

    @Test
    public void testContainsReturnFalseWhenObjectNotContains(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("B");
        linkedList.add("C");
        assertFalse(linkedList.contains("A"));

    }


    @Test
    public void testAddAndSizeWorkCorrectly(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        assertEquals(1,linkedList.size());
        linkedList.add("B");
        assertEquals(2,linkedList.size());
        linkedList.add("C");
        assertEquals(3,linkedList.size());

    }
    @Test
    public void testAddAndSizeAndRemoteWorkCorrectlyWithSecondaryCalling(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        assertEquals(1,linkedList.size());
        linkedList.add("B");
        assertEquals(2,linkedList.size());
        linkedList.add("C");
        assertEquals(3,linkedList.size());
        linkedList.remove(2);
        assertEquals(2,linkedList.size());
        linkedList.remove(1);
        assertEquals(1,linkedList.size());
        linkedList.remove(0);
        assertEquals(0,linkedList.size());
        linkedList.add("A");
        assertEquals(1,linkedList.size());
        linkedList.add("B");
        assertEquals(2,linkedList.size());
        linkedList.add("C");
        assertEquals(3,linkedList.size());
        linkedList.remove(2);
        assertEquals(2,linkedList.size());
        linkedList.remove(1);
        assertEquals(1,linkedList.size());
        linkedList.remove(0);
        assertEquals(0,linkedList.size());
    }

    @Test
    public void testAddAndSizeAndClearWorkAndIsEmptyCorrectly(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        assertEquals(1,linkedList.size());
        linkedList.clear();
        assertTrue(linkedList.isEmpty());
        assertEquals(0,linkedList.size());


    }
    @Test
    public void testAddWithIndexAndRemoveWorkCorrectly(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B",0);
        linkedList.add("C",0);
        linkedList.add("D",0);
        assertEquals("D",linkedList.remove(0));
        assertEquals("C",linkedList.remove(0));
        assertEquals("B",linkedList.remove(0));
        assertEquals("A",linkedList.remove(0));
        assertEquals(0,linkedList.size());



    }

    @Test
    public void testAddWithIndexAndRemoveWorkCorrectlyTwo(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B",0);
        linkedList.add("C",1);
        linkedList.add("D",1);
        assertEquals("B",linkedList.remove(0));
        assertEquals("D",linkedList.remove(0));
        assertEquals("A",linkedList.remove(1));
        assertEquals("C",linkedList.remove(0));
        assertEquals(0,linkedList.size());

    }

    @Test
    public void testAddThrowIndexOutOfBoundsExceptionWhenIndexIsOutOfBounds() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.add("A");
            linkedList.add("D",3);;

        });
    }

    @Test
    public void testAddThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.remove(1);
            linkedList.get(1);
            linkedList.set("A", 1);
        });
    }
    @Test
    public void testGetThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(1);
        });
    }
    @Test
    public void testSetThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.set("A", 1);
        });
    }
    @Test
    public void testRemoveThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.remove(1);
        });
    }

    @Test
    public void testRemoveThrowIndexOutOfBoundsExceptionWhenIndexIsOutOfSize() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.add("A");
            linkedList.add("B");
            linkedList.remove(2);
        });
    }

    @Test
    public void testGetThrowIndexOutOfBoundsExceptionWhenIndexIsOutOfSize() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.add("A");
            linkedList.add("B");
            linkedList.get(2);
        });
    }

    @Test
    public void testSetThrowIndexOutOfBoundsExceptionWhenIndexIsOutOfSize() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.add("A");
            linkedList.add("B");
            linkedList.set("A", 2);
        });
    }

    @Test
    public void testAddAndGetAndSizeWorkCorrectly() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("A",2);
        linkedList.add("B",3);
        assertEquals("A",linkedList.get(0));
        assertEquals(4,linkedList.size());
        assertEquals("B",linkedList.get(1));
        assertEquals(4,linkedList.size());
        assertEquals("A",linkedList.get(2));
        assertEquals(4,linkedList.size());
        assertEquals("B",linkedList.get(3));
        assertEquals(4,linkedList.size());

    }

    @Test
    public void testAddAndSetAndGetWorkCorrectly() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        assertEquals("A",linkedList.get(0));
        assertEquals("B",linkedList.get(1));
        linkedList.set("A",1);
        linkedList.set("B",0);
        assertEquals("B",linkedList.get(0));
        assertEquals("A",linkedList.get(1));


    }
}
