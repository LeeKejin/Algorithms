package com.amazon.interview.greedy;

import java.util.PriorityQueue;

public class Leet1046
{
    public int lastStoneWeight( int[] stones )
    {
        PriorityQueue< Integer > queue = new PriorityQueue<>( ( a, b ) -> b - a );
        for ( int stone : stones )
        {
            queue.add( stone );
        }
        while ( queue.size() >= 2 )
        {
            int v1 = queue.poll();
            int v2 = queue.poll();
            queue.add( v1 - v2 );
        }
        if ( queue.isEmpty() ) return 0;
        return queue.poll();
    }
}
