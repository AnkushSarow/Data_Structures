/**
 * Test class for Stack.java
 */

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class StackTest {
    /**
     * Test empty stack constructor. Ensure size() is 0 and isEmpty() is true
     */
    @Test
    public void testStack_constructor() {
        Stack<Integer> stack = new Stack<>();
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    /**
     * Test peek() on empty stack - Throws NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public void testPeek_emptyStack() {
        Stack<Integer> stack = new Stack<>();
        stack.peek();
    }

    /**
     * Test push() method. peek() will be tested here as well in order to compare the values
     */
    @Test
    public void testPush() {
        Stack<Integer> stack = new Stack<>();

        assertEquals(0, stack.size());
        stack.push(0);
        assertEquals(1, stack.size());
        assertEquals(0, (int) stack.peek());

        for (int i = 1; i < 100; ++i) {
            stack.push(i);
            assertEquals(i, (int) stack.peek());
        }
        assertEquals(100, stack.size());
    }

    /**
     * Test pop() on empty stack - Throws NoSuchElementException
     */
    @Test (expected = NoSuchElementException.class)
    public void testPop_emptyStack() {
        Stack<String> stack = new Stack<>();
        stack.pop();
    }

    /**
     * Test pop() method - peek() will also be used here to compare values
     */
    @Test
    public void testPop() {
        Stack<Character> stack = new Stack<> ();

        stack.push('C');
        stack.push('B');
        stack.push('A');

        assertEquals(stack.peek(),stack.pop());
        assertEquals(2,stack.size());
        assertEquals(stack.peek(),stack.pop());
        assertEquals(1,stack.size());
        assertEquals(stack.peek(),stack.pop());
        assertEquals(0,stack.size());
        assertTrue(stack.isEmpty());
    }

    /**
     * Test size()
     */
    @Test
    public void testSize() {
        Stack<Integer> stack = new  Stack<>();
        assertEquals(0, stack.size());

        for (int i = 0; i < 100; ++i) {
            stack.push(i);
        }
        assertEquals(100, stack.size());

        for (int i = 0; i < 30; ++i) {
            stack.pop();
        }
        assertEquals(70, stack.size());

        while (!stack.isEmpty()) {
            stack.pop();
        }
        assertEquals(0, stack.size());
    }
}

