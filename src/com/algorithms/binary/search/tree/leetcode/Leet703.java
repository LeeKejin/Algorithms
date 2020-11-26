package com.algorithms.binary.search.tree.leetcode;

import java.util.PriorityQueue;

public class Leet703
{
    PriorityQueue< Integer > queue = new PriorityQueue<>();
    int k;

    public Leet703( int k, int[] nums )
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
                int pre = queue.peek();
                if ( pre < num )
                {
                    queue.poll();
                    queue.add( num );
                }
            }
        }
    }

    public int add( int val )
    {
        if ( queue.isEmpty() || queue.size() < k )
        {
            queue.add( val );
            return queue.peek();
        }
        int pre = queue.peek();
        if ( pre < val )
        {
            queue.poll();
            queue.add( val );
        }
        return queue.peek();
    }
}
