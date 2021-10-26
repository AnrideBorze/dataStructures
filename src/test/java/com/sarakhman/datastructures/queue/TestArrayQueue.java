package com.sarakhman.datastructures.queue;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayQueue {




    @Test
    public void testEnqueueAndSizeWorkCorrectly(){
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("A");
        assertEquals(1,arrayQueue.size());

        arrayQueue.enqueue("B");
        assertEquals(2,arrayQueue.size());

    }
    @Test
    public void testEnqueueAndPeekAndSizeWorkCorrectly(){
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("A");
        assertEquals("A",arrayQueue.peek());
        assertEquals(1,arrayQueue.size());

        arrayQueue.enqueue("B");
        assertEquals("A",arrayQueue.peek());
        assertEquals(2,arrayQueue.size());
    }



    @Test
    public void testEnqueueAndDequeueAndSizeWorkCorrectly(){
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("A");
        assertEquals("A",arrayQueue.peek());
        assertEquals(1,arrayQueue.size());

        arrayQueue.enqueue("B");
        assertEquals("A",arrayQueue.peek());
        assertEquals(2,arrayQueue.size());

        assertEquals("A",arrayQueue.dequeue());
        assertEquals("B",arrayQueue.peek());
        assertEquals(1,arrayQueue.size());

        assertEquals("B",arrayQueue.dequeue());
        assertEquals(0,arrayQueue.size());
    }

    @Test
    public void testEnqueueAndDequeueAndPeekAndSizeWorkCorrectly(){
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("A");
        assertEquals(1,arrayQueue.size());

        arrayQueue.enqueue("B");
        assertEquals(2,arrayQueue.size());

        assertEquals("A",arrayQueue.dequeue());
        assertEquals(1,arrayQueue.size());

        assertEquals("B",arrayQueue.dequeue());
        assertEquals(0,arrayQueue.size());
    }
    @Test
    public void testEnqueueOverInitialCapacityAndPeekAndDequeueAndSizeWorkCorrectly(){
        ArrayQueue arrayQueue = new ArrayQueue(2);
        arrayQueue.enqueue("A");
        assertEquals("A",arrayQueue.peek());
        assertEquals(1,arrayQueue.size());

        arrayQueue.enqueue("B");
        assertEquals("A",arrayQueue.peek());
        assertEquals(2,arrayQueue.size());

        arrayQueue.enqueue("C");
        assertEquals("A",arrayQueue.peek());
        assertEquals(3,arrayQueue.size());

        assertEquals("A",arrayQueue.dequeue());
        assertEquals(2,arrayQueue.size());

        assertEquals("B",arrayQueue.dequeue());
        assertEquals(1,arrayQueue.size());

        assertEquals("C",arrayQueue.dequeue());
        assertEquals(0,arrayQueue.size());
    }

    @Test
    public void testContainsReturnFalseOnEmptyQueue(){
        ArrayQueue arrayQueue = new ArrayQueue();
        assertFalse(arrayQueue.contains(new String("A")));
    }

    @Test
    public void testEnqueueAndContainsReturnTrue(){
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("A");
        assertTrue(arrayQueue.contains(new String("A")));
    }

    @Test
    public void testEnqueueAndContainsReturnFalse(){
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("A");
        assertTrue(arrayQueue.contains(new String("B")));
    }

    @Test
    public void testContainsReturnFalseAfterEnqueueAndDequeue(){
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertEquals("A",arrayQueue.dequeue());
        assertEquals("B",arrayQueue.dequeue());

        assertFalse(arrayQueue.contains("A"));
    }
    @Test
    public void testIsEmptyReturnTruOnNewQueue(){
        ArrayQueue arrayQueue = new ArrayQueue();

        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueAfterClear(){
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("A");
        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }
    @Test
    public void testIsEmptyReturnFalseAfterEnqueue(){
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("A");
        assertFalse(arrayQueue.isEmpty());
    }
    @Test
    public void testIsEmptyReturnTrueAfterEnqueueAndDequeue(){
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("A");
        assertEquals("A",arrayQueue.dequeue());
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseAfterEnqueueAndPeek(){
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue("A");
        assertEquals("A",arrayQueue.peek());
        assertFalse(arrayQueue.isEmpty());
    }
}
