package com.amazon.interview.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Leet1167
{
    public int connectSticks( int[] sticks )
    {
        if ( sticks.length == 1 ) return 0;
        PriorityQueue< Integer > queue = new PriorityQueue<>();
        for ( int stick : sticks )
        {
            queue.add( stick );
        }
        List< Integer > list = new ArrayList<>();
        while ( queue.size() > 1 )
        {
            int a = queue.poll();
            int b = queue.poll();
            list.add( a + b );
            queue.add( a + b );
        }
        int sum = 0;
        for ( int v : list )
        {
            sum += v;
        }
        return sum;
    }
}
