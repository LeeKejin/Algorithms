package com.amazon.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet56
{
    public int[][] merge( int[][] intervals )
    {
        if ( intervals.length == 0 ) return new int[][] {};
        if ( intervals.length == 1 ) return intervals;
        Arrays.sort( intervals, ( ( o1, o2 ) -> ( o1[ 0 ] - o2[ 0 ] ) ) );
        List< int[] > list = new ArrayList<>();
        list.add( intervals[ 0 ] );

        for ( int i = 1; i < intervals.length; i++ )
        {
            int[] existing = list.get( list.size() - 1 );
            if ( existing[ 1 ] >= intervals[ i ][ 0 ] )
            {
                existing[ 1 ] = Math.max( existing[ 1 ], intervals[ i ][ 1 ] );
            }
            else
            {
                list.add( intervals[ i ] );
            }
        }
        int[][] res = new int[ list.size() ][ 2 ];
        for ( int i = 0; i < list.size(); i++ )
        {
            res[ i ] = list.get( i );
        }
        return res;
    }
}
