/**
 * Test class for Queue.java
 */

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class QueueTest {
    @Test
    public void testQueue_constructor() {
        Queue<String> queue = new Queue<>();

        assertEquals(0, queue.getSize());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueue() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("A");
        assertEquals(1,queue.getSize());
        assertFalse(queue.isEmpty());

        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        assertEquals(4, queue.getSize());
    }

    @Test (expected = NoSuchElementException.class)
    public void testDequeue_emptyQueue() {
        Queue<String> queue = new Queue<>();

        queue.dequeue();
    }

    @Test
    public void testDequeue() {
        Queue<Integer> queue = new Queue<>();

        for (int i = 0; i < 100; ++i) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 30; ++i) {
            queue.dequeue();
        }
        assertEquals(70, queue.getSize());
    }

    @Test
    public void testPeek() {
        Queue<Integer> queue = new Queue<>();

        for (int i = 0; i < 100; ++i) {
            queue.enqueue(i);
        }
        for (int i =0; i < 100; ++i) {
            assertEquals(queue.peek(),queue.dequeue());
        }
        assertTrue(queue.isEmpty());
    }
}