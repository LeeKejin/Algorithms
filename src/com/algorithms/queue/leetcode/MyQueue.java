package com.algorithms.queue.leetcode;

import java.util.Stack;

public class MyQueue
{
    Stack< Integer > stack1 = new Stack<>();
    Stack< Integer > stack2 = new Stack<>();

    public MyQueue()
    {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push( int x )
    {
        while ( !stack2.isEmpty() )
        {
            stack1.push( stack2.pop() );
        }
        stack1.push( x );

        while ( !stack1.isEmpty() )
        {
            stack2.push( stack1.pop() );
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop()
    {
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek()
    {
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty()
    {
        return stack2.isEmpty();
    }

    public static void main( String[] args )
    {
        MyQueue queue = new MyQueue();
        queue.push( 1 );
        queue.push( 2 );
        System.out.println( queue.peek() );
        System.out.println( queue.pop() );
        System.out.println( queue.empty() );
    }
}

