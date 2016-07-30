/**
 * Class: DoublyLinkedList.java
 *
 * The purpose of this class is to practice the implementation of a generic doubly linked list.
 *
 */

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    private int listSize;
    private Node head;
    private Node tail;

    //Private node inner class
    private class Node {
        E data;
        Node next;
        Node previous;

        public Node() {
            this.data = null;
            this.next = null;
            this.previous = null;
        }

        public Node(E data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    public DoublyLinkedList() {
        listSize = 0;
        head = new Node();
        tail = new Node();
    }

    /**
     * Add an element to the end of the linked list
     *
     * @param data - Holds the element to be added
     */
    public void add(E data) {
        if (isEmpty()) {
            addToHead(data);
            return;
        }

        Node insertNode = new Node(data, tail.next, tail);
        tail.next = insertNode;
        tail = insertNode;

        ++listSize;
    }

    /**
     * Adds a specific element to the given index
     * @param data - Holds tehe element to be added
     * @param index - Position in which the desired element is to be added (First index is 0)
     */
    public void add(E data, int index) {
        if (index < 0 || index > listSize - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addToHead(data);
            return;
        }

        Node current = findNode(index);
        Node newNode = new Node(data, current, current.previous);
        current.previous.next = newNode;
        current.previous = newNode;

        ++listSize;
    }

    /**
     * Add an element to the head of the linked list
     *
     * @param data - Holds the element to be added
     */
    public void addToHead(E data) {
        Node insertNode = new Node();

        //Adding to an empty list
        if (isEmpty()) {
            insertNode.data = data;
            insertNode.previous = null;
            insertNode.next = null;
            head = insertNode;
            tail = head;
        }
        else {
            insertNode.next = head;
            insertNode.previous = head.previous;
            head.previous = insertNode;
            head = insertNode;
        }
        ++listSize;
    }

    /**
     * Removes the first element of the doubly linked list
     */
    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node current = head;
        head = head.next;
        current.previous = null;
        current.next = null;

        if (listSize == 1) {
            tail = head;
        }

        --listSize;
    }

    /**
     * Removes the last element of the doubly linked list. If there is only one element, it calls removeFirst()
     */
    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (tail == head) {
            removeFirst();
            return;
        }

        Node current = tail.previous;
        current.next = null;
        tail.previous = null;
        tail = current;

        --listSize;
    }

    /**
     * Removes a specific element at a given index
     * @param index - position in which the element resides (First element resides at index 0)
     */
    public E remove(int index) {
        if (index < 0 || index > listSize - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            E data = head.data;
            removeFirst();
            return data;
        }

        if (index == listSize - 1) {
            E data = tail.data;
            removeLast();
            return data;
        }

        Node current = findNode(index);

        current.previous.next = current.next;
        current.next.previous = current.previous;
        current.next = null;
        current.previous = null;

        --listSize;
        return current.data;
    }

    public E get(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException();
        }
        return findNode(index).data;
    }

    /**
     * Clear the doubly linked list
     */
    public void clearDoublyLinkedList() {
        head = null;
        tail = null;
        listSize = 0;
    }

    /**
     * @return - Returns the list size
     */
    public int getListSize()
    {
        return listSize;
    }

    /**
     * Determine if the linked list is empty
     *
     * @return - True if list is empty, false if not
     */
    public boolean isEmpty()
    {
        return (listSize == 0);
    }

    /**
     * Print the list elements
     */
    public void printDoublyLinkedList() {
        Node current = head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    /**
     * Retrieve element at specific index
     */
    private Node findNode(int index) {
        if (index < 0 || index > listSize - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index < getListSize()/2) {
            Node current = head;
            int indexCounter = 0;
            while (indexCounter != index) {
                current = current.next;
                ++indexCounter;
            }
            return current;
        }
        else {
            Node current = tail;
            int indexCounter = getListSize() - 1;
            while (indexCounter != index) {
                current = current.previous;
                --indexCounter;
            }
            return current;
        }
    }

    //Test the various methods of the DoublyLinkedList class
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
    }
}




