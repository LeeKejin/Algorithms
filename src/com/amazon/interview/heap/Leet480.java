package com.amazon.interview.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leet480
{
    public double[] medianSlidingWindowMaxHeapHasMoreValue( int[] nums, int k )
    {
        int index = 0;
        double[] res = new double[ nums.length - k + 1 ];
        PriorityQueue< Integer > minHeap = new PriorityQueue<>();
        PriorityQueue< Integer > maxHeap = new PriorityQueue<>( Collections.reverseOrder() );

        while ( index < nums.length )
        {
            if ( maxHeap.isEmpty() || maxHeap.peek() >= nums[ index ] )
            {
                maxHeap.add( nums[ index ] );
            }
            else
            {
                minHeap.add( nums[ index ] );
            }

            rebalance( minHeap, maxHeap );

            if ( index - k + 1 >= 0 )
            {
                if ( maxHeap.size() == minHeap.size() )
                {
                    res[ index - k + 1 ] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                }
                else
                {
                    res[ index - k + 1 ] = maxHeap.peek() / 2.0;
                }

                int start = nums[ index - k + 1 ];
                if ( start <= maxHeap.peek() )
                {
                    maxHeap.remove( start );
                }
                else
                {
                    minHeap.remove( start );
                }
                rebalance( minHeap, maxHeap );
            }
            index++;
        }
        return res;
    }

    private void rebalance( PriorityQueue< Integer > minHeap, PriorityQueue< Integer > maxHeap )
    {
        if ( maxHeap.size() - minHeap.size() >= 2 )
        {
            minHeap.add( maxHeap.poll() );
        }
        else if ( maxHeap.size() < minHeap.size() )
        {
            maxHeap.add( minHeap.poll() );
        }
    }

    /*
    MinHeap has more values
     */

    public double[] medianSlidingWindow( int[] nums, int k )
    {
        int index = 0;
        double[] res = new double[ nums.length - k + 1 ];
        PriorityQueue< Integer > minHeap = new PriorityQueue<>();
        PriorityQueue< Integer > maxHeap = new PriorityQueue<>( Collections.reverseOrder() );

        while ( index < nums.length )
        {
            maxHeap.add( nums[ index ] );
            minHeap.add( maxHeap.poll() );
            if ( minHeap.size() - maxHeap.size() >= 2 )
            {
                maxHeap.add( minHeap.poll() );
            }

            if ( index - k + 1 >= 0 )
            {
                if ( maxHeap.size() == minHeap.size() )
                {
                    res[ index - k + 1 ] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                }
                else
                {
                    res[ index - k + 1 ] = minHeap.peek();
                }

                int start = nums[ index - k + 1 ];

                if ( start >= minHeap.peek() )
                {
                    minHeap.remove( start );
                }
                else
                {
                    maxHeap.remove( start );
                }

                if ( minHeap.size() - maxHeap.size() >= 2 )
                {
                    maxHeap.add( minHeap.poll() );
                }
            }
            index++;
        }
        return res;
    }

}
