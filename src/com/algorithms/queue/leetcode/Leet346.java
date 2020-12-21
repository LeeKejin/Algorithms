package com.algorithms.queue.leetcode;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage
{
    int size;
    Queue< Integer > queue = new LinkedList<>();

    public MovingAverage( int size )
    {
        this.size = size;
    }

    double next( int value )
    {
        if ( queue.size() < size )
        {
            queue.add( value );
        }
        else
        {
            queue.poll();
            queue.add( value );
        }
        int sum = 0;
        for ( int i : queue )
        {
            sum += i;
        }
        return sum * 1.0 / queue.size();
    }

    public static void main( String[] args )
    {
        MovingAverage m = new MovingAverage( 3 );
        System.out.println( m.next( 1 ) );
        System.out.println( m.next( 10 ) );
        System.out.println( m.next( 3 ) );
        System.out.println( m.next( 5 ) );
    }
}
