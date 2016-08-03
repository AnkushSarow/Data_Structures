/**
 * Class: Stack.java
 *
 * The purpose of this class is to implement a generic stack with a linked list as the underlying data structure.
 */

import java.util.NoSuchElementException;

public class Stack<E> {
    private Node stackTop;
    private int size;

    private class Node {
        private Node next;
        private E data;

        public Node(E data) {
            this.next = null;
            this.data = data;
        }

        public Node(E data, Node next) {
            this.next = next;
            this.data = data;
        }
    }

    public Stack() {
        this.stackTop = null;
        this.size = 0;
    }

    public void push(E data) {
        Node newTop = new Node(data, stackTop);
        stackTop = newTop;
        ++size;
    }

    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }

        Node oldTop = stackTop;
        stackTop = stackTop.next;
        --size;

        return oldTop.data;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        return stackTop.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
