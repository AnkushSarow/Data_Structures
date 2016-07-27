/**
 * Class: ArrayStack.java
 *
 *
 * The purpose of this class is to practice the implementation of an array-based Stack. The stack will be generic
 * and resizable. It will resize to 2x the size if a push is attempted on a full stack. If a remove is attempted
 * and the amount of components in the array is 1/4 the size of the array, the array size will be halved.
 *
 *
 */

import java.util.EmptyStackException;


public class ArrayStack<E>
{

    private E[] stack; //Underlying structure of stack is an array
    private int size; //This variable will represent the number of items in the stack

    ArrayStack()
    {
        stack = (E[]) new Object[1];
        this.size = 0;
    }

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    public E pop()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }

        E removedItem = stack[--size];
        stack[size] = null;

        //Decrease size of array by 1/2 if stack is 1/4 of array size
        if(size > 0 && (size == (stack.length) / 4))
        {
            resize(stack.length/2);
        }

        return removedItem;
    }

    public void push(E item)
    {
        //Resize array to 2x size if stack is full
        if (size == stack.length)
        {
            resize(2 * stack.length);
        }

        stack[size++] = item;
    }


    public E peek()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        return stack[size-1];
    }

    private void resize(int newSize)
    {
        //Create a new temporary array and copy the elements over
        E[] resizedStack = (E[]) new Object[newSize];

        for(int i = 0; i < size; ++i)
        {
            resizedStack[i] = stack[i];
        }

        stack = resizedStack;
    }


    /**
    Main method to test the methods of the ArrayStack class
     */

    public static void main(String[] args)
    {
        ArrayStack<Integer> stackOfInts = new ArrayStack<Integer>();

        System.out.println("Stack size: " + stackOfInts.getSize());

        System.out.println("Stack empty: " + stackOfInts.isEmpty());

        /*
        try
        {
           stackOfInts.pop(); //should throw exception
        }
        catch(EmptyStackException e)
        {
            System.err.println("Cannot pop - Empty stack");
        }
        */

        /*
        try
        {
            stackOfInts.peek(); //should throw exception
        }
        catch(EmptyStackException e)
        {
            System.err.println("Cannot peek - Empty stack");
        }
        */


        //Add 10 elements to the stack - print the stack size - print top of each stack - pop item off stack
        for (int i = 0; i < 11; ++i)
        {
            stackOfInts.push(i);
        }

        System.out.println("Added elements - Stack size is now: " + stackOfInts.getSize());

        int x = stackOfInts.getSize();

        for (int i = 0; i < x; ++i)
        {
            System.out.println("Top of stack is: " + stackOfInts.peek());
            stackOfInts.pop();
        }


        /*
        try
        {
            stackOfInts.pop(); //should throw exception
        }
        catch(EmptyStackException e)
        {
            System.err.println("Cannot pop - Empty stack");
        }
        */

        /*
        try
        {
            stackOfInts.peek(); //should throw exception
        }
        catch(EmptyStackException e)
        {
            System.err.println("Cannot peek - Empty stack");
        }
        */

    }
}
