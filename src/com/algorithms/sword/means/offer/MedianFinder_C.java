package com.algorithms.sword.means.offer;

import java.util.PriorityQueue;

public class MedianFinder_C
{
    PriorityQueue< Integer > maxQueue = new PriorityQueue<>( ( a, b ) -> b > a ? 1 : -1 );
    PriorityQueue< Integer > minQueue = new PriorityQueue<>();

    public MedianFinder_C()
    {

    }

    public void addNum( int num )
    {
        maxQueue.add( num );
        minQueue.add( maxQueue.poll() );
        if ( minQueue.size() - maxQueue.size() >= 2 )
        {
            maxQueue.add( minQueue.poll() );
        }
    }

    public double findMedian()
    {
        if ( ( maxQueue.size() + minQueue.size() ) % 2 == 0 )
        {
            return ( maxQueue.peek() + minQueue.peek() ) / 2.0;
        }
        return minQueue.peek();
    }

    public static void main( String[] args )
    {
        test();
    }

    private static void test()
    {
        MedianFinder_C m = new MedianFinder_C();
        m.addNum( -1 );
        System.out.println( m.findMedian() );
        m.addNum( -2 );
        System.out.println( m.findMedian() );
        m.addNum( -3 );
        System.out.println( m.findMedian() );
        m.addNum( -4 );
        System.out.println( m.findMedian() );
        m.addNum( -5 );
        System.out.println( m.findMedian() );
    }
}
