package com.amazon.interview;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Leet239
{

    // O(nlogn)
    public int[] maxSlidingWindow( int[] nums, int k )
    {
        PriorityQueue< int[] > priorityQueue = new PriorityQueue<>( new Comparator< int[] >()
        {
            @Override
            public int compare( int[] o1, int[] o2 )
            {
                return o1[ 0 ] == o2[ 0 ] ? o2[ 1 ] - o1[ 1 ] : o2[ 0 ] - o1[ 0 ];
            }
        } );

        for ( int i = 0; i < k; i++ )
        {
            priorityQueue.add( new int[] { nums[ i ], i } );
        }
        int[] res = new int[ nums.length - k + 1 ];
        res[ 0 ] = priorityQueue.peek()[ 0 ];
        for ( int i = k; i < nums.length; i++ )
        {
            priorityQueue.add( new int[] { nums[ i ], i } );
            while ( priorityQueue.peek()[ 1 ] <= i - k )
            {
                priorityQueue.poll();
            }
            res[ i - k + 1 ] = priorityQueue.peek()[ 0 ];
        }
        return res;
    }

    //O(n)
    public int[] maxSlidingWindow1( int[] nums, int k )
    {
        if ( nums == null || nums.length < 2 ) return nums;
        LinkedList< Integer > queue = new LinkedList();
        int res[] = new int[ nums.length - k + 1 ];

        for ( int i = 0; i < nums.length; i++ )
        {
            while ( !queue.isEmpty() && nums[ i ] >= nums[ queue.peekLast() ] )
            {
                queue.pollLast();
            }
            queue.addLast( i );
            if ( queue.peek() <= i - k )
            {
                queue.poll();
            }
            if ( i + 1 >= k )
            {
                res[ i + 1 - k ] = nums[ queue.peek() ];
            }
        }
        return res;
    }
}
