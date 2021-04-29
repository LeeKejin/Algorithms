package com.amazon.interview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet976
{
    public int[][] kClosest( int[][] points, int K )
    {
        if ( points.length == 0 ) return new int[ K ][ 2 ];
        Map< int[], Integer > map = new HashMap<>();
        for ( int i = 0; i < points.length; i++ )
        {
            int x = points[ i ][ 0 ];
            int y = points[ i ][ 1 ];
            map.put( points[ i ], x * x + y * y );
        }
        PriorityQueue< int[] > queue = new PriorityQueue<>( new Comparator< int[] >()
        {
            @Override
            public int compare( int[] a, int[] b )
            {
                return map.get( a ) - map.get( b );
            }
        } );

        for ( int[] point : map.keySet() )
        {
            queue.add( point );
        }
        int[][] res = new int[ K ][ 2 ];
        int i = 0;
        while ( !queue.isEmpty() )
        {
            res[ i ] = queue.poll();
            if ( i + 1 == K ) break;
            i++;
        }
        return res;
    }
}
