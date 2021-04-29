package com.amazon.interview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet347
{
    public int[] topKFrequent( int[] nums, int k )
    {
        if ( nums.length == 0 ) return new int[ k ];
        Map< Integer, Integer > map = new HashMap<>();
        for ( int num : nums )
        {
            if ( map.containsKey( num ) )
            {
                int freq = map.get( num );
                freq++;
                map.put( num, freq );
            }
            else
            {
                map.put( num, 1 );
            }
        }
        PriorityQueue< Integer > priorityQueue = new PriorityQueue<>( new Comparator< Integer >()
        {
            @Override
            public int compare( Integer a, Integer b )
            {
                return map.get( b ) - map.get( a );
            }
        } );

        for ( int key : map.keySet() )
        {
            priorityQueue.add( key );
        }

        int[] res = new int[ k ];
        int i = 0;
        while ( !priorityQueue.isEmpty() )
        {
            res[ i ] = priorityQueue.poll();
            if ( i == k - 1 ) break;
            i++;
        }
        return res;
    }
}
