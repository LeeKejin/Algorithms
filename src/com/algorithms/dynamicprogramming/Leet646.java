package com.algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class Leet646
{
    public int findLongestChain( int[][] pairs )
    {
        int length = pairs.length;
        if ( length == 0 ) return 0;
        if ( length == 1 ) return 1;
        int dp[] = new int[ length ];
        for ( int i = 0; i < length; i++ )
        {
            dp[ i ] = 1;
        }
        Arrays.sort( pairs, Comparator.comparingInt( p -> p[ 0 ] ) );
        int res = 1;
        for ( int i = 1; i < length; i++ )
        {
            for ( int j = 0; j < i; j++ )
            {
                if ( pairs[ i ][ 0 ] > pairs[ j ][ 1 ] )
                {
                    dp[ i ] = Math.max( dp[ j ] + 1, dp[ i ] );
                    res = Math.max( res, dp[ i ] );
                }
            }
        }
        return res;
    }
}
