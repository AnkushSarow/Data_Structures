/**
 * Class: LinkedList.java
 *
 * The purpose of this class is to practice the implementation of a generic singly linked list.
 *
 */

import java.util.NoSuchElementException;

public class LinkedList<E>
{

    private Node head;
    private int listSize = 0;

    //Private inner class to represent a Node
    private class Node
    {
        E data;
        Node next;

        public Node(E data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }

    public LinkedList()
    {
        Node head = new Node(null,null);
        listSize = 0;
    }


    public int getListSize()
    {
        return listSize;
    }

    //Adds a node to the end of the linked list
    public void add(E data)
    {
        if(head == null)
        {
            addToHead(data);
            return;
        }

        Node current = head;

        while(current.next != null)
        {
            current = current.next;
        }

        Node insertNode = new Node(data,null);
        current.next = insertNode;

        ++listSize;
    }

    //Add to a specific index in the linked list
    //0 = head, 1 = head.next, and so on
    public void add(E data, int index)
    {
        if(index == 0)
        {
            addToHead(data);
            return;
        }

        if(index < 0 || index >= listSize)
        {
            throw new IndexOutOfBoundsException();
        }

        int indexCounter = 0;
        Node current = head;

        while(indexCounter < (index-1))
        {
            current = current.next;
            ++indexCounter;
        }

        Node insertNode = new Node(data, current.next);
        current.next = insertNode;

        ++listSize;
    }

    //Adds a node to the beginning of the linked list
    public void addToHead(E data)
    {
        Node newHead = new Node(data,head);
        head = newHead;

        ++listSize;
    }

    //Remove the head of the linked list
    public void remove()
    {
        if(head == null)
        {
            throw new NoSuchElementException();
        }

        Node current = head.next;
        head = null;
        head = current;

        --listSize;
    }

    //Retrieve the data from the node at the index and remove it front the linked list
    public E remove(int index)
    {
        if(index == 0)
        {
            Node temp = head;
            remove();
            return temp.data;
        }

        if(index < 0 || index >= listSize)
        {
            throw new IndexOutOfBoundsException();
        }

        int indexCounter = 0;
        Node current = head;

        //Loop until one before node to be removed
        while(indexCounter < (index - 1))
        {
            current = current.next;
            ++indexCounter;
        }

        //Create a temporary node to represent the node to be removed
        Node tempNode = current.next;

        //Set the current node to point to the node after the node to be removed
        current.next = current.next.next;

        //Now set the temp node that is meant to be removed to point to null
        tempNode.next = null;

        --listSize;
        return (tempNode.data);
    }

    public E get(int index)
    {
        if(index < 0 || index >= listSize)
        {
            throw new IndexOutOfBoundsException();
        }

        int indexCounter = 0;
        Node current = head;

        while(indexCounter != index)
        {
            current = current.next;
            ++indexCounter;
        }

        return current.data;
    }

    //Clears the linked list
    public void clear()
    {
        while(head != null)
        {
            remove();
        }

        listSize = 0;
    }

    public void printLinkedList()
    {
        Node current = head;

        while(current != null)
        {
            System.out.println(current.data);
            current = current.next;
        }
    }

    //Test the various methods of the linked list class
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<String>();

        System.out.println("Size of linked list: " + list.getListSize());
/*
        try
        {
            list.remove(); //Removal on empty linked list - this throws NoSuchElementException
        }
        catch(NoSuchElementException e)
        {
            System.err.println("Cannot remove from empty linked list");
        }
*/
        String[] months = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};

        for(int i = 0; i < months.length; ++i)
        {
            list.add(months[months.length - (1 + i)],0);
        }

        System.out.println("After adding the months of the year, the elements of the list are: ");
        list.printLinkedList();
/*
        try
        {
            list.remove(12); //Attempting to remove out of range - this throws IndexOutOfBounds exception
        }
        catch(IndexOutOfBoundsException e)
        {
            System.err.println("Cannot remove - index out of bounds");
        }
*/
        //Testing remove(int index)
        list.remove(11);
        list.remove(0);
        for(int i = 0; i < 10; ++i)
        {
            list.remove(0);
        }

        System.out.println("Size of linked list after removals: " + list.getListSize());
        System.out.println("List after removal: ");
        list.printLinkedList();

        //Build the list again and clear it
        for(int i = 0; i < months.length; ++i)
        {
            list.add(months[i]);
        }
        System.out.println("Size of linked list after entering items: " + list.getListSize());

        list.clear();

        list.printLinkedList();
        System.out.println("Size of linked list after clearing: " + list.getListSize());
    }
}
