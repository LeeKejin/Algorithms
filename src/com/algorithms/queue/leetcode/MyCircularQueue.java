package com.algorithms.queue.leetcode;

public class MyCircularQueue
{
    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    int data[];
    int head = -1;
    int tail = -1;
    int k;

    public MyCircularQueue( int k )
    {
        this.k = k;
        data = new int[ k ];

    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue( int value )
    {
        if ( isFull() ) return false;
        if ( isEmpty() )
        {
            head++;
        }

        tail = ( tail + 1 ) % k;
        data[ tail ] = value;

        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue()
    {
        if ( isEmpty() ) return false;

        if ( head == tail )
        {
            head = -1;
            tail = -1;
            return true;
        }
        head = ( head + 1 ) % k;

        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front()
    {
        if ( isEmpty() ) return -1;
        return data[ head ];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear()
    {
        if ( isEmpty() ) return -1;
        return data[ tail ];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty()
    {
        return ( head == -1 || tail == -1 );
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull()
    {
        return ( tail + 1 == head || tail - head + 1 == k );
    }

    public static void main( String[] args )
    {
        MyCircularQueue queue = new MyCircularQueue( 2 );
        System.out.println( queue.enQueue( 4 ) );
        System.out.println( queue.Rear() );
        System.out.println( queue.enQueue( 9 ) );
        System.out.println( queue.deQueue() );
        System.out.println( queue.Front() );
        System.out.println( queue.deQueue() );
        System.out.println( queue.deQueue() );
        System.out.println( queue.isEmpty() );
        System.out.println( queue.deQueue() );
        System.out.println( queue.enQueue( 6 ) );
        System.out.println( queue.enQueue( 4 ) );
        //        System.out.println( queue.enQueue( 5 ) );
        //        System.out.println( queue.Rear() );
        //        System.out.println( queue.deQueue() );
        //        System.out.println( queue.Front() );
        //        System.out.println( queue.deQueue() );
        //        System.out.println( queue.deQueue() );
        //        System.out.println( queue.deQueue() );

    }
}


