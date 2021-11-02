package com.sarakhman.datastructures.queue;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    public class TestLinkedQueue {




        @Test
        public void testEnqueueAndSizeWorkCorrectly(){
        LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.enqueue("A");
            assertEquals(1,linkedQueue.size());

            linkedQueue.enqueue("B");
            assertEquals(2,linkedQueue.size());

        }
        @Test
        public void testEnqueueAndPeekAndSizeWorkCorrectly(){
            LinkedQueue linkedQueue = new LinkedQueue();

            linkedQueue.enqueue("A");
            assertEquals("A",linkedQueue.peek());
            assertEquals(1,linkedQueue.size());

            linkedQueue.enqueue("B");
            assertEquals("A",linkedQueue.peek());
            assertEquals(2,linkedQueue.size());
        }

        @Test
        public void testEnqueueAndDequeueWorkCorrectly(){
            LinkedQueue linkedQueue = new LinkedQueue();

            linkedQueue.enqueue("A");
            linkedQueue.enqueue("B");
            linkedQueue.enqueue("C");
            linkedQueue.enqueue("D");
            linkedQueue.enqueue("E");
            assertEquals("A",linkedQueue.dequeue());
            assertEquals("B",linkedQueue.dequeue());
            linkedQueue.enqueue("A");
            linkedQueue.enqueue("B");
            assertEquals("C",linkedQueue.dequeue());
            assertEquals("D",linkedQueue.dequeue());
            assertEquals("E",linkedQueue.dequeue());
            assertEquals("A",linkedQueue.dequeue());
            assertEquals("B",linkedQueue.dequeue());
            assertEquals(0,linkedQueue.size());
        }

        @Test
        public void testEnqueueAndDequeueAndSizeWorkCorrectly(){
            LinkedQueue linkedQueue = new LinkedQueue();

            linkedQueue.enqueue("A");
            assertEquals("A",linkedQueue.peek());
            assertEquals(1,linkedQueue.size());

            linkedQueue.enqueue("B");
            assertEquals("A",linkedQueue.peek());
            assertEquals(2,linkedQueue.size());

            assertEquals("A",linkedQueue.dequeue());
            assertEquals("B",linkedQueue.peek());
            assertEquals(1,linkedQueue.size());

            assertEquals("B",linkedQueue.dequeue());
            assertEquals(0,linkedQueue.size());
        }

        @Test
        public void testEnqueueAndDequeueAndPeekAndSizeWorkCorrectly(){
            LinkedQueue linkedQueue = new LinkedQueue();

            linkedQueue.enqueue("A");
            assertEquals(1,linkedQueue.size());

            linkedQueue.enqueue("B");
            assertEquals(2,linkedQueue.size());

            assertEquals("A",linkedQueue.dequeue());
            assertEquals(1,linkedQueue.size());

            assertEquals("B",linkedQueue.dequeue());
            assertEquals(0,linkedQueue.size());
        }
        @Test
        public void testEnqueueOverInitialCapacityAndPeekAndDequeueAndSizeWorkCorrectly(){
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.enqueue("A");
            assertEquals("A",linkedQueue.peek());
            assertEquals(1,linkedQueue.size());

            linkedQueue.enqueue("B");
            assertEquals("A",linkedQueue.peek());
            assertEquals(2,linkedQueue.size());

            linkedQueue.enqueue("C");
            assertEquals("A",linkedQueue.peek());
            assertEquals(3,linkedQueue.size());

            assertEquals("A",linkedQueue.dequeue());
            assertEquals(2,linkedQueue.size());

            assertEquals("B",linkedQueue.dequeue());
            assertEquals(1,linkedQueue.size());

            assertEquals("C",linkedQueue.dequeue());
            assertEquals(0,linkedQueue.size());
        }

        @Test
        public void testContainsReturnFalseOnEmptyQueue(){
            LinkedQueue linkedQueue = new LinkedQueue();
            assertFalse(linkedQueue.contains(new String("A")));
        }

        @Test
        public void testEnqueueAndContainsReturnTrue(){
            LinkedQueue linkedQueue = new LinkedQueue();

            linkedQueue.enqueue("A");
            assertTrue(linkedQueue.contains(new String("A")));
        }

        @Test
        public void testEnqueueAndContainsReturnFalse(){
            LinkedQueue linkedQueue = new LinkedQueue();

            linkedQueue.enqueue("A");
            assertFalse(linkedQueue.contains(new String("B")));
        }

        @Test
        public void testContainsReturnFalseAfterEnqueueAndDequeue(){
            LinkedQueue linkedQueue = new LinkedQueue();

            linkedQueue.enqueue("A");
            linkedQueue.enqueue("B");

            assertEquals("A",linkedQueue.dequeue());
            assertEquals("B",linkedQueue.dequeue());

            assertFalse(linkedQueue.contains("A"));
        }
        @Test
        public void testIsEmptyReturnTruOnNewQueue(){
            LinkedQueue linkedQueue = new LinkedQueue();

            assertTrue(linkedQueue.isEmpty());
        }

        @Test
        public void testIsEmptyReturnTrueAfterClear(){
            LinkedQueue linkedQueue = new LinkedQueue();

            linkedQueue.enqueue("A");
            linkedQueue.clear();
            assertTrue(linkedQueue.isEmpty());
        }
        @Test
        public void testIsEmptyReturnFalseAfterEnqueue(){
            LinkedQueue linkedQueue = new LinkedQueue();

            linkedQueue.enqueue("A");
            assertFalse(linkedQueue.isEmpty());
        }
        @Test
        public void testIsEmptyReturnTrueAfterEnqueueAndDequeue(){
            LinkedQueue linkedQueue = new LinkedQueue();

            linkedQueue.enqueue("A");
            assertEquals("A",linkedQueue.dequeue());
            assertTrue(linkedQueue.isEmpty());
        }

        @Test
        public void testIsEmptyReturnFalseAfterEnqueueAndPeek(){
            LinkedQueue linkedQueue = new LinkedQueue();

            linkedQueue.enqueue("A");
            assertEquals("A",linkedQueue.peek());
            assertFalse(linkedQueue.isEmpty());
        }

        @Test
        public void testThrowIllegalStateExceptionWhenPopOnEmptyStack() {
            LinkedQueue linkedQueue = new LinkedQueue();
            Assertions.assertThrows(IllegalStateException.class, () -> {
                linkedQueue.dequeue();
            });
        }
    }





