/**
 * Test class for DoublyLinkedList.java. Many of the tests are similar to those of the LinkedListTest.java class
 */

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    /**
     * Testing newly created doubly linked list to ensure size() = 0 and isEmpty returns true
     */
    @Test
    public void testDoublyLinkedListConstructor() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertEquals(0, list.size());
        assertEquals(true, list.isEmpty());
    }

    /**
     * Testing addFirst(E data) method. Each element added should be added to the front of the doubly linked list.
     * This test method will use the get(int index) method as well in order to compare the data at the head
     */
    @Test
    public void testAddFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        for (int i = 0; i < 10; ++i) {
            list.addFirst(i);
            assertEquals(i, (int) list.get(0));
        }
    }

    /**
     * Testing add(E data) method. Each element added should be added to the end of the doubly linked list.
     * The get method will be used for comparison.
     */
    @Test
    public void testAdd() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

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
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

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
    public void testAdd_toIndexOutOfRange() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0,0);
    }

    /**
     * Testing removeFirst(). Removes the first item in the doubly linked list.
     */
    @Test
    public void testRemoveFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }
        while (!list.isEmpty()) {
            list.removeFirst();
        }
        assertTrue(list.size() == 0);
        assertTrue(list.isEmpty());
    }

    /**
     * Testing removeLast(). Removes the last item in the doubly linked list.
     */
    @Test
    public void testRemoveLast() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }
        while (!list.isEmpty()) {
            list.removeLast();
        }
        assertTrue(list.size() == 0);
        assertTrue(list.isEmpty());

        for (int i = 0; i < 5; ++i) {
            list.add(i);
        }
        list.removeLast();
        list.removeLast();
        assertTrue(list.size() == 3);
        assertEquals(2, (int) list.get(2));
    }

    /**
     * Testing remove(int index). Removes the item at the index.
     */
    @Test
    public void testRemove_index() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

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
        list.remove(3);
        assertEquals(3, list.size());
        assertEquals(2, (int) list.get(2));
    }


    /**
     * Testing for exceptions when attempting to remove from an empty doubly linked list
     */
    @Test (expected = NoSuchElementException.class)
    public void testRemoveFirst_emptyList() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.removeFirst();
    }
    /**
     * Testing for exceptions when attempting to remove from outside the doubly linked list range
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemove_outOfRange() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("A");
        list.add("B");
        list.remove(3);
    }

    /**
     * Testing for exceptions when attempting to retrieve from an empty doubly linked list
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGet_emptyList() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.get(0);
    }
    /**
     * Testing for exceptions when attempting to retrieve from outside the doubly linked list range
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGet_outOfRange() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("A");
        list.get(1);
    }

    /**
     * Testing clear - Clears the doubly linked list - sets each node to reference null
     */
    @Test
    public void testClear() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }
}