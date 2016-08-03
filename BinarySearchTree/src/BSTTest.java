/**
 * Test class for BST.java
 */

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class BSTTest {
    @Test
    public void testBST_contructor() {
        BST<Integer> bst = new BST<>();
        assertEquals(0, bst.size());
        assertTrue(bst.isEmpty());
    }

    /**
     * Test bst.insert(E data). The number 10 will be inserted first, followed by 5, 15, and 1; Insertion of
     * a duplicate value wil be attempted. It should be silently ignored.
     * The tree should have structure:
     *     10
     *    /  \
     *   5   15
     *  /
     * 1
     * bst.displayLevelOrder() will be used to verify the proper order is printed out: 10 5 15 1
     * bst.displayInOrder() will be used to verify the proper order is printed out: 1 5 10 15
     * bst.displayPostOrder() will be used to verify the proper order is printed out: 1 5 15 10
     */
    @Test
    public void testInsert() {
        BST<Integer> bst = new BST<>();

        bst.insert(10);
        assertEquals(1, bst.size());
        assertEquals(0, bst.height());
        assertFalse(bst.isEmpty());
        assertTrue(bst.search(10));

        bst.insert(5);
        assertEquals(2, bst.size());
        assertEquals(1, bst.height());
        assertFalse(bst.isEmpty());
        assertTrue(bst.search(5));
        assertTrue(bst.search(10));

        bst.insert(15);
        assertEquals(3, bst.size());
        assertEquals(1, bst.height());
        assertFalse(bst.isEmpty());
        assertTrue(bst.search(15));
        assertTrue(bst.search(10));
        assertTrue(bst.search(5));

        bst.insert(1);
        assertEquals(4, bst.size());
        assertEquals(2, bst.height());
        assertFalse(bst.isEmpty());
        assertTrue(bst.search(1));
        assertTrue(bst.search(15));
        assertTrue(bst.search(10));
        assertTrue(bst.search(5));

        //duplicate insertion - should be ignored (no changes in size/height/structure of tree)
        bst.insert(1);
        assertEquals(4, bst.size());
        assertEquals(2, bst.height());
        assertFalse(bst.isEmpty());
        assertTrue(bst.search(1));
        assertTrue(bst.search(15));
        assertTrue(bst.search(10));
        assertTrue(bst.search(5));
/*
        //Print out the list inOrder to make sure it is properly structed
        System.out.print("Level-order: ");
        bst.displayLevelOrder();
        System.out.println();

        System.out.print("In-order: ");
        bst.displayInOrder();
        System.out.println();

        System.out.print("Post-order: ");
        bst.displayPostOrder();
        System.out.println();
*/
    }

    /**
     *
     * First, a tree will be constructed with only one element in it. delete() will be called in order to make sure
     * the tree is empty with a size of 0;
     *
     *
     * Then, the number 10 will be inserted first, followed by 5, 15, 1, 13, and 20;
     * The tree should have structure:
     *     10
     *    /  \
     *   5   15
     *  /   / \
     * 1   13  20
     * bst.displayInOrder() will be used to verify the proper order is printed out: 1 5 10 13 15 20
     *
     * The numbers 5 and 1 will be removed to ensure case 2 and case 1 are tested (5 has one child - after removal, 1
     * will be a leaf.
     *
     * The structure should then be:
     *      10
     *        \
     *        15
     *       /  \
     *      13   20
     * bst.displayInOrder() will be used to verify the proper order is printed out: 10 13 15 20
     *
     * Then, 15 will be removed to test case 3 (node has 2 children)
     *
     * Structure should be:
     *
     *      10
     *        \
     *        20
     *       /
     *      13
     * bst.displayInOrder() will be used to verify the proper order is printed out: 10 13 20
     * Lastly, delete() will be called on the root until there are no items.
     */


    @Test
    public void testDelete() {
        BST<Integer> bst = new BST<>();

        bst.insert(10);
        assertEquals(1,bst.size());
        assertEquals(0,bst.height());
        assertFalse(bst.isEmpty());
        /*
        System.out.print("In-order: ");
        bst.displayInOrder();
        System.out.println(); */

        bst.delete(15); //not in tree, Tree should not change
        assertEquals(1,bst.size());
        assertEquals(0,bst.height());
        assertFalse(bst.isEmpty());

        //Adding exactly one element and removing it
        bst.delete(10);
        assertEquals(0,bst.size());
        assertEquals(0,bst.height());
        assertTrue(bst.isEmpty());
        assertFalse(bst.search(10));
        /*
        System.out.print("In-order: ");
        bst.displayInOrder();
        System.out.println(); */

        //Adding multiple elements now and will delete them in an order to test each case (as described in comments)
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(1);
        bst.insert(13);
        bst.insert(20);
        /*
        System.out.print("In-order: ");
        bst.displayInOrder();
        System.out.println(); */
        bst.delete(5);
        assertEquals(5, bst.size());
        assertEquals(2, bst.height());
        assertFalse(bst.search(5));
        /*
        System.out.print("In-order: ");
        bst.displayInOrder();
        System.out.println(); */
        bst.delete(1);
        assertEquals(4, bst.size());
        assertEquals(2, bst.height());
        assertFalse(bst.search(1));
        /*
        System.out.print("In-order: ");
        bst.displayInOrder();
        System.out.println(); */
        bst.delete(15);
        assertEquals(3, bst.size());
        assertEquals(2, bst.height());
        assertFalse(bst.search(15));
        /*
        System.out.print("In-order: ");
        bst.displayInOrder();
        System.out.println();
        */
        bst.delete(10);
        assertEquals(2, bst.size());
        assertEquals(1, bst.height());
        assertFalse(bst.search(10));
        /*
        System.out.print("In-order: ");
        bst.displayInOrder();
        System.out.println(); */
        bst.delete(13);
        assertEquals(1, bst.size());
        assertEquals(0, bst.height());
        assertFalse(bst.search(13));
        /*
        System.out.print("In-order: ");
        bst.displayInOrder();
        System.out.println();
        */
        bst.delete(20);
        assertEquals(0, bst.size());
        assertEquals(0, bst.height());
        assertFalse(bst.search(20));
        assertTrue(bst.isEmpty());
        /*
        System.out.print("In-order: ");
        bst.displayInOrder();
        System.out.println(); */
        //Add and delete after clearing ^
        bst.insert(10);
        bst.delete(10);
        assertEquals(0, bst.size());
        assertEquals(0, bst.height());
        assertFalse(bst.search(20));
        assertTrue(bst.isEmpty());
    }

    @Test (expected = NoSuchElementException.class)
    public void testMax_emptyBST() {
        BST<Integer> bst = new BST<>();
        bst.max();
    }

    @Test
    public void testMax() {
        BST<Integer> bst = new BST<>();

        bst.insert(10);
        assertEquals(10, (int) bst.max());
        bst.insert(5);
        bst.insert(7);
        bst.insert(4);
        assertEquals(10, (int) bst.max());
        bst.insert(15);
        assertEquals(15, (int) bst.max());
        bst.insert(13);
        assertEquals(15, (int) bst.max());
        bst.insert(20);
        assertEquals(20, (int) bst.max());

        bst.delete(20);
        assertEquals(15, (int) bst.max());
        bst.delete(15);
        assertEquals(13, (int) bst.max());
        bst.delete(10);
        assertEquals(13, (int) bst.max());
        bst.delete(13);
        assertEquals(7, (int) bst.max());
        bst.delete(4);
        assertEquals(7, (int) bst.max());
        bst.delete(7);
        assertEquals(5, (int) bst.max());
    }

    @Test (expected = NoSuchElementException.class)
    public void testMin_emptyBST() {
        BST<Integer> bst = new BST<>();
        bst.min();
    }

    @Test
    public void testMin() {
        BST<Integer> bst = new BST<>();
        bst.insert(10);
        assertEquals(10, (int) bst.min());
        bst.insert(15);
        assertEquals(10, (int) bst.min());
        bst.insert(7);
        assertEquals(7, (int) bst.min());
        bst.insert(4);
        assertEquals(4, (int) bst.min());
        bst.insert(1);
        assertEquals(1, (int) bst.min());

        bst.delete(1);
        assertEquals(4, (int) bst.min());
        bst.delete(10);
        assertEquals(4, (int) bst.min());
        bst.delete(15);
        assertEquals(4, (int) bst.min());
        bst.delete(4);
        assertEquals(7, (int) bst.min());
    }
}