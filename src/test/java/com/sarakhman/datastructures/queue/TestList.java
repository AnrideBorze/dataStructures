package com.sarakhman.datastructures.queue;

import com.sarakhman.datastructures.list.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class TestList {
    private List list;

    @BeforeEach
    public void before() {
        list = getList();
    }

    protected abstract List getList();


    @Test
    public void testIteratorWorkCorrectly() {
        list.add("HELLO");
        list.add("ANATOLIY");
        int count = 1;
        for (Object o : list) {
            if (count == 1) {                            //первая итерация
                assertEquals("HELLO", o);
                count++;
            } else if (count == 2) {                      // вторая итерация
                assertEquals("ANATOLIY", o);
            }

        }


    }


    @Test
    public void testToStringReturnGoodText() {
        list.add("HELLO");
        list.add("ANATOLIY");


        assertEquals("[HELLO, ANATOLIY]", list.toString());

    }


    @Test
    public void testLastIndexOfReturnIndex() {

        list.add("A");
        list.add("B");
        list.add("A");
        list.add("C");

        assertEquals(2, list.lastIndexOf("A"));

    }

    @Test
    public void testLastIndexOfReturnNegativeWhenObjectDoesNotContains() {
        list.add("A");
        list.add("B");
        assertEquals(-1, list.lastIndexOf("C"));

    }

    @Test
    public void testIndexOfReturnNegativeWhenObjectDoesNotContains() {
        list.add("A");
        list.add("B");
        assertEquals(-1, list.indexOf("C"));

    }

    @Test
    public void testIndexOfReturnIndex() {
        list.add("A");
        list.add("B");
        list.add("A");
        assertEquals(0, list.indexOf("A"));

    }


    @Test
    public void testContainsReturnTrueWhenObjectContains() {
        list.add("A");
        list.add("B");
        assertTrue(list.contains("A"));

    }

    @Test
    public void testContainsReturnFalseInEmptylinkedList() {
        assertFalse(list.contains("A"));

    }

    @Test
    public void testContainsReturnFalseWhenObjectNotContains() {
        list.add("B");
        list.add("C");
        assertFalse(list.contains("A"));

    }


    @Test
    public void testAddAndSizeWorkCorrectly() {
        list.add("A");
        assertEquals(1, list.size());
        list.add("B");
        assertEquals(2, list.size());
        list.add("C");
        assertEquals(3, list.size());

    }

    @Test
    public void testAddAndSizeAndRemoteWorkCorrectlyWithSecondaryCalling() {
        list.add("A");
        assertEquals(1, list.size());
        list.add("B");
        assertEquals(2, list.size());
        list.add("C");
        assertEquals(3, list.size());
        list.remove(2);
        assertEquals(2, list.size());
        list.remove(1);
        assertEquals(1, list.size());
        list.remove(0);
        assertEquals(0, list.size());
        list.add("A");
        assertEquals(1, list.size());
        list.add("B");
        assertEquals(2, list.size());
        list.add("C");
        assertEquals(3, list.size());
        list.remove(2);
        assertEquals(2, list.size());
        list.remove(1);
        assertEquals(1, list.size());
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void testAddAndSizeAndClearWorkAndIsEmptyCorrectly() {
        list.add("A");
        assertEquals(1, list.size());
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());


    }

    @Test
    public void testAddWithIndexAndRemoveWorkCorrectly() {
        list.add("A");
        list.add("B", 0);
        list.add("C", 0);
        list.add("D", 0);
        assertEquals("D", list.remove(0));
        assertEquals("C", list.remove(0));
        assertEquals("B", list.remove(0));
        assertEquals("A", list.remove(0));
        assertEquals(0, list.size());


    }

    @Test
    public void testAddWithIndexAndRemoveWorkCorrectlyTwo() {
        list.add("A");
        list.add("B", 0);
        list.add("C", 1);
        list.add("D", 1);
        assertEquals("B", list.remove(0));
        assertEquals("D", list.remove(0));
        assertEquals("A", list.remove(1));
        assertEquals("C", list.remove(0));
        assertEquals(0, list.size());

    }

    @Test
    public void testAddThrowIndexOutOfBoundsExceptionWhenIndexIsOutOfBounds() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("A");
            list.add("D", 3);
            ;

        });
    }

    @Test
    public void testAddThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(1);
            list.get(1);
            list.set("A", 1);
        });
    }

    @Test
    public void testGetThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(1);
        });
    }

    @Test
    public void testSetThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set("A", 1);
        });
    }

    @Test
    public void testRemoveThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(1);
        });
    }

    @Test
    public void testRemoveThrowIndexOutOfBoundsExceptionWhenIndexIsOutOfSize() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("A");
            list.add("B");
            list.remove(2);
        });
    }

    @Test
    public void testGetThrowIndexOutOfBoundsExceptionWhenIndexIsOutOfSize() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("A");
            list.add("B");
            list.get(2);
        });
    }

    @Test
    public void testSetThrowIndexOutOfBoundsExceptionWhenIndexIsOutOfSize() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("A");
            list.add("B");
            list.set("A", 2);
        });
    }

    @Test
    public void testAddAndGetAndSizeWorkCorrectly() {
        list.add("A");
        list.add("B");
        list.add("A", 2);
        list.add("B", 3);
        assertEquals("A", list.get(0));
        assertEquals(4, list.size());
        assertEquals("B", list.get(1));
        assertEquals(4, list.size());
        assertEquals("A", list.get(2));
        assertEquals(4, list.size());
        assertEquals("B", list.get(3));
        assertEquals(4, list.size());

    }

    @Test
    public void testAddAndSetAndGetWorkCorrectly() {
        list.add("A");
        list.add("B");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        list.set("A", 1);
        list.set("B", 0);
        assertEquals("B", list.get(0));
        assertEquals("A", list.get(1));


    }
}

