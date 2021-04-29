package com.amazon.interview;

import java.util.PriorityQueue;

public class Leet973
{
    public int[][] kClosest( int[][] points, int k )
    {
        if ( points.length == 0 ) return new int[][] {};
        int res[][] = new int[ k ][ 2 ];
        PriorityQueue< int[] > queue = new PriorityQueue<>(
            ( a, b ) -> a[ 0 ] * a[ 0 ] + a[ 1 ] * a[ 1 ] > b[ 0 ] * b[ 0 ] + b[ 1 ] * b[ 1 ] ? -1 : 1 );
        for ( int i = 0; i < points.length; i++ )
        {
            queue.add( points[ i ] );
        }
        for ( int i = 0; i < k; i++ )
        {
            res[ i ] = queue.poll();
        }
        return res;
    }
}
