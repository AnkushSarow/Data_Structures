/**
 * Class: LinkedList.java
 *
 * The purpose of this class is to practice the implementation of a generic singly linked list.
 *
 */

import java.util.NoSuchElementException;

public class LinkedList<E> {

    private Node head;
    private int size;

    //Private inner class to represent a Node
    private class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkedList() {
        this.head = new Node(null);
        size = 0;
    }

    public void addFirst(E data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        ++size;
    }

    //Adds a node to the end of the linked list
    public void add(E data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            addFirst(data);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

        ++size;
    }

    //Add to a specific index in the linked list
    //0 = head, 1 = head.next, and so on
    public void add(E data, int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        int counter = 0;
        Node current = head;
        while (counter < (index-1)) {
            current = current.next;
            ++counter;
        }
        Node newNode = new Node(data, current.next);
        current.next = newNode;

        ++size;
    }

    //Remove the head of the linked list
    public void remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node current = head;
        head = head.next;
        current.next = null;
        --size;
    }

    //Retrieve the data from the node at the index and remove it front the linked list
    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            Node temp = head;
            remove();
            return temp.data;
        }

        int indexCounter = 0;
        Node current = head;
        //Loop until one before node to be removed
        while (indexCounter < (index - 1)) {
            current = current.next;
            ++indexCounter;
        }
        //Create a temporary node to represent the node to be removed
        Node tempNode = current.next;
        //Set the current node to point to the node after the node to be removed
        current.next = current.next.next;
        //Now set the temp node that is meant to be removed to point to null
        tempNode.next = null;

        --size;
        return (tempNode.data);
    }

    public E get(int index) {
        if( index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        int indexCounter = 0;
        Node current = head;
        while (indexCounter != index) {
            current = current.next;
            ++indexCounter;
        }

        return current.data;
    }

    public int Size() { return size; }

    public boolean isEmpty() { return size == 0; }

    //Clears the linked list
    public void clear() {
        head = null;
        size = 0;
    }

    public void printLinkedList() {
        Node current = head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    //Test the various methods of the linked list class
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<String>();
    }
}
