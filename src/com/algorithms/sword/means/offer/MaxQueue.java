package com.algorithms.sword.means.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue
{
    Queue< Integer > queue = new LinkedList<>();

    Deque< Integer > stack = new LinkedList<>();

    public MaxQueue()
    {

    }

    public int max_value()
    {
        if ( queue.isEmpty() ) return -1;
        return stack.getFirst();
    }

    public void push_back( int value )
    {
        queue.add( value );

        while ( !stack.isEmpty() && stack.peekLast() < value )
        {
            stack.pollLast();
        }
        stack.addLast( value );

    }

    public int pop_front()
    {
        if ( queue.isEmpty() ) return -1;
        int val = queue.poll();
        if ( val == stack.getFirst() ) stack.pollFirst();
        return val;
    }

    public static void main( String[] args )
    {
        MaxQueue q = new MaxQueue();

        System.out.println( q.pop_front() );
        System.out.println( q.pop_front() );
        System.out.println( q.pop_front() );
        System.out.println( q.pop_front() );
        System.out.println( q.pop_front() );

        q.push_back( 15 );
        System.out.println( q.max_value() );
        q.push_back( 9 );
        System.out.println( q.max_value() );

    }
}
