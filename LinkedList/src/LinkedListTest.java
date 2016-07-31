/**
 * Test class for LinkedList.java
 */

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class LinkedListTest {

    /**
     * Testing empty linked list to ensure size() = 0 and isEmpty returns true
     */
    @Test
    public void testLinkedList_constructor() {
        LinkedList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
        assertEquals(true, list.isEmpty());
    }

    /**
     * Testing addFirst(E data) method. Each element added should be added to the head of the linked list.
     * This test method will use the get(int index) method as well in order to compare the data at the head
     */
    @Test
    public void testAddFirst() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; ++i) {
            list.addFirst(i);
            assertEquals(i, (int) list.get(0));
        }
    }

    /**
     * Testing add(E data) method. Each element added should be added to the tail of the linked list.
     * The get method will be used for comparison.
     */
    @Test
    public void testAdd() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; ++i) {
            list.add(i);
            assertEquals(i, (int) list.get(i));
        }
    }

    /**
     * Testing add(E data, int index) method. The passed in data will be inserted at the passed in index. If the
     * index is out of range, an exception is  thrown (test for this below)
     */
    @Test
    public void testAdd_toIndex() {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        for (int i = 1; i < 10; ++i) {
            list.add(i, i - 1);
            assertEquals(i, (int) list.get(i-1));
        }
    }

    /**
     * Testing for exception when attempting to add an item to index 0 of an empty list
     * This should not be allowed as the list has no items in it. Adding to an index is only allowed
     * if the list has at least one item in it (minimum: index 0 is occupied)
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testAdd_toIndexBeyondRange() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0,0);
    }

    /**
     * Testing remove(). Removes the first item in the linked list.
     */
    @Test
    public void testRemove() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }
        while (!list.isEmpty()) {
            list.remove();
        }
        assertTrue(list.size() == 0);
        assertTrue(list.isEmpty());
    }

    /**
     * Testing remove(int index). Removes the item at the index.
     */
    @Test
    public void testRemove_index() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }
        for (int i = 0; i < 10; ++i) {
            list.remove( 9 - i );
        }
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        for (int i = 0; i < 5; ++i) {
            list.add(i);
        }
        list.remove(4);
        list.remove(2);
        assertEquals(3, list.size());
        assertEquals(3, (int) list.get(2));
    }


    /**
     * Testing for exceptions when attempting to remove from an empty linked list
     */
    @Test (expected = NoSuchElementException.class)
    public void testRemove_emptyLinkedList() {
        LinkedList<String> list = new LinkedList<>();
        list.remove();
    }
    /**
     * Testing for exceptions when attempting to remove from outside the linked list range
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemove_outOfRange() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.remove(3);
    }

    /**
     * Testing for exceptions when attempting to retrieve from an empty linked list
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGet_emptyLinkedList() {
        LinkedList<String> list = new LinkedList<>();
        list.get(0);
    }
    /**
     * Testing for exceptions when attempting to retrieve from outside the linked list range
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGet_outOfRange() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.get(1);
    }

    /**
     * Testing clear - Clears the linked list - sets each node to reference null
     */
    @Test
    public void testClear() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }
}