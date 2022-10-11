package com.amazon.interview.greedy;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class QueueReconstructionByHeight
{
    public int[][] reconstructQueue( int[][] people )
    {
        LinkedList< int[] > list = new LinkedList<>();

        PriorityQueue< int[] > queue =
            new PriorityQueue<>( new Comparator< int[] >()
            {
                @Override
                public int compare( int[] o1, int[] o2 )
                {
                    if ( o1[ 0 ] == o2[ 0 ] ) return o1[ 1 ] - o2[ 1 ];
                    return o2[ 0 ] - o1[ 0 ];
                }
            } );

        for ( int[] person : people )
        {
            queue.add( person );
        }
        list.add( queue.poll() );
        while ( !queue.isEmpty() )
        {
            int[] person = queue.poll();

            list.add( person[ 1 ], person );

        }
        int[][] res = new int[ people.length ][ 2 ];
        for ( int i = 0; i < people.length; i++ )
        {
            res[ i ] = list.get( i );
        }
        return res;
    }

}
