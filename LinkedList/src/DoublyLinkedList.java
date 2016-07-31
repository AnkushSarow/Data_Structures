/**
 * Class: DoublyLinkedList.java
 *
 * The purpose of this class is to practice the implementation of a generic doubly linked list.
 *
 */

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    private int size;
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
        size = 0;
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
            addFirst(data);
            return;
        }

        Node insertNode = new Node(data, tail.next, tail);
        tail.next = insertNode;
        tail = insertNode;
        ++size;
    }

    /**
     * Adds a specific element to the given index
     * @param data - Holds tehe element to be added
     * @param index - Position in which the desired element is to be added (First index is 0)
     */
    public void add(E data, int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node current = findNode(index);
        Node newNode = new Node(data, current, current.previous);
        current.previous.next = newNode;
        current.previous = newNode;
        ++size;
    }

    /**
     * Add an element to the head of the linked list
     *
     * @param data - Holds the element to be added
     */
    public void addFirst(E data) {
        Node insertNode = new Node();

        //Adding to an empty list
        if (isEmpty()) {
            insertNode.data = data;
            insertNode.previous = null;
            insertNode.next = null;
            head = insertNode;
            tail = head;
        } else {
            insertNode.data = data;
            insertNode.next = head;
            insertNode.previous = head.previous;
            head.previous = insertNode;
            head = insertNode;
        }
        ++size;
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

        if (size > 1) {
            head.previous = null;
        }

        if (size == 1) {
            tail = head;
        }
        --size;
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
        --size;
    }

    /**
     * Removes a specific element at a given index
     * @param index - position in which the element resides (First element resides at index 0)
     */
    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            E data = head.data;
            removeFirst();
            return data;
        }

        if (index == size - 1) {
            E data = tail.data;
            removeLast();
            return data;
        }

        Node current = findNode(index);

        (current.previous).next = current.next;
        (current.next).previous = current.previous;
        current.next = null;
        current.previous = null;
        --size;

        return current.data;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return findNode(index).data;
    }

    /**
     * Clear the doubly linked list
     */
    public void clear() {
        while (head != null) {
            removeFirst();
        }
        size = 0;
    }

    /**
     * @return - Returns the list size
     */
    public int size() {
        return size;
    }

    /**
     * Determine if the linked list is empty
     *
     * @return - True if list is empty, false if not
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Print the list elements
     */
    public void print() {
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
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index < size()/2) {
            Node current = head;
            int indexCounter = 0;
            while (indexCounter != index) {
                current = current.next;
                ++indexCounter;
            }
            return current;
        } else {
            Node current = tail;
            int indexCounter = size() - 1;
            while (indexCounter != index) {
                current = current.previous;
                --indexCounter;
            }
            return current;
        }
    }
}




