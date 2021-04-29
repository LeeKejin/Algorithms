package com.amazon.interview;

import java.util.PriorityQueue;

public class Leet295
{
    PriorityQueue< Integer > maxQueue = new PriorityQueue<>( ( a, b ) -> b - a );
    PriorityQueue< Integer > minQueue = new PriorityQueue<>();
    int count;

    public Leet295()
    {
        count = 0;
    }

    public void addNum( int num )
    {
        count++;
        maxQueue.add( num );
        minQueue.add( maxQueue.poll() );
        if ( count % 2 != 0 )
        {
            maxQueue.add( minQueue.poll() );
        }
    }

    public double findMedian()
    {
        if ( count % 2 == 0 )
        {
            return ( maxQueue.peek() + minQueue.peek() ) / 2.0;
        }
        return maxQueue.peek();
    }

}
