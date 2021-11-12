package com.sarakhman.datastructures.queue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class TestQueue {

    private Queue queue;

    @BeforeEach
    public void before() {
        queue = getQueue();
    }

    protected abstract Queue getQueue();


    @Test
    public void testIteratorWorkCorrectly() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        Object[] array = new Object[3];
        int index = 0;
        for (Object o : queue) {
            array[index] = o;
            index++;
        }
        assertEquals("A", array[0]);
        assertEquals("B", array[1]);
        assertEquals("C", array[2]);


    }

    @Test
    public void testEnqueueAndSizeWorkCorrectly() {
        queue.enqueue("A");
        assertEquals(1, queue.size());

        queue.enqueue("B");
        assertEquals(2, queue.size());

    }


    @Test
    public void testEnqueueAndPeekAndSizeWorkCorrectly() {

        queue.enqueue("A");
        assertEquals("A", queue.peek());
        assertEquals(1, queue.size());

        queue.enqueue("B");
        assertEquals("A", queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    public void testEnqueueAndDequeueWorkCorrectly() {

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals("C", queue.dequeue());
        assertEquals("D", queue.dequeue());
        assertEquals("E", queue.dequeue());
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueueAndDequeueAndSizeWorkCorrectly() {

        queue.enqueue("A");
        assertEquals("A", queue.peek());
        assertEquals(1, queue.size());

        queue.enqueue("B");
        assertEquals("A", queue.peek());
        assertEquals(2, queue.size());

        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.peek());
        assertEquals(1, queue.size());

        assertEquals("B", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueueAndDequeueAndPeekAndSizeWorkCorrectly() {

        queue.enqueue("A");
        assertEquals(1, queue.size());

        queue.enqueue("B");
        assertEquals(2, queue.size());

        assertEquals("A", queue.dequeue());
        assertEquals(1, queue.size());

        assertEquals("B", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueueOverInitialCapacityAndPeekAndDequeueAndSizeWorkCorrectly() {
        queue.enqueue("A");
        assertEquals("A", queue.peek());
        assertEquals(1, queue.size());

        queue.enqueue("B");
        assertEquals("A", queue.peek());
        assertEquals(2, queue.size());

        queue.enqueue("C");
        assertEquals("A", queue.peek());
        assertEquals(3, queue.size());

        assertEquals("A", queue.dequeue());
        assertEquals(2, queue.size());

        assertEquals("B", queue.dequeue());
        assertEquals(1, queue.size());

        assertEquals("C", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void testContainsReturnFalseOnEmptyQueue() {
        assertFalse(queue.contains(new String("A")));
    }

    @Test
    public void testEnqueueAndContainsReturnTrue() {

        queue.enqueue("A");
        assertTrue(queue.contains(new String("A")));
    }

    @Test
    public void testEnqueueAndContainsReturnFalse() {

        queue.enqueue("A");
        assertFalse(queue.contains(new String("B")));
    }

    @Test
    public void testContainsReturnFalseAfterEnqueueAndDequeue() {

        queue.enqueue("A");
        queue.enqueue("B");

        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());

        assertFalse(queue.contains("A"));
    }

    @Test
    public void testIsEmptyReturnTruOnNewQueue() {

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueAfterClear() {

        queue.enqueue("A");
        queue.clear();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseAfterEnqueue() {

        queue.enqueue("A");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueAfterEnqueueAndDequeue() {

        queue.enqueue("A");
        assertEquals("A", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseAfterEnqueueAndPeek() {

        queue.enqueue("A");
        assertEquals("A", queue.peek());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testThrowIllegalStateExceptionWhenPopOnEmptyStack() {
        assertThrows(IllegalStateException.class, () -> {
            queue.dequeue();
        });
    }
}
