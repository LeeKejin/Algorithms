package com.amazon.interview;

import java.util.PriorityQueue;

public class KthLargest
{
    PriorityQueue< Integer > queue = new PriorityQueue<>();
    int k = 0;

    public KthLargest( int k, int[] nums )
    {
        this.k = k;
        for ( int num : nums )
        {
            if ( queue.size() < k )
            {
                queue.add( num );
            }
            else
            {
                if ( queue.peek() < num )
                {
                    queue.poll();
                    queue.add( num );
                }
            }
        }
    }

    public int add( int val )
    {
        if ( queue.size() < k )
        {
            queue.add( val );
        }
        else if ( val > queue.peek() )
        {
            queue.poll();
            queue.add( val );
        }
        return queue.peek();
    }
}
