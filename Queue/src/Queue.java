/**
 * The purpose of this class is to practice the implementation of a generic queue. Basic methods will be implemented
 * such as enqueue, dequeue, isEmpty, size, and peek. The underlying data structure is a linked list.
 */
import java.util.NoSuchElementException;


public class Queue<E> {
    private Node front;
    private Node rear;
    private int size;

    private class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    /**
     * Data is added to the rear of the queue
     * @param data - holds the element to be added
     */
    public void enqueue(E data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = newNode;
            rear = front;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        ++size;
    }

    /**
     * Data is removed from the front of the queue
     * @return - returns the removed element
     */
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }

        E removedData = front.data;
        front = front.next;
        --size;
        if (isEmpty()) {
            rear = front;
        }

        return removedData;
    }

    /**
     * Retrieve the data at the front of the queue
     * @return - First element in the queue
     */
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }

        return front.data;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
