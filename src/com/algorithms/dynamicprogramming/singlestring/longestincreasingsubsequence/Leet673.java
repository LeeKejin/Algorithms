package com.algorithms.dynamicprogramming.singlestring.longestincreasingsubsequence;

import java.util.Arrays;

public class Leet673
{
    public int findNumberOfLIS( int[] nums )
    {
        if ( nums.length == 0 ) return 0;
        int[] count = new int[ nums.length ];
        int max = 0;
        int res = 0;
        if ( nums.length == 0 ) return 1;
        int[] dp = new int[ nums.length ];
        Arrays.fill( dp, 1 );
        Arrays.fill( count, 1 );
        for ( int i = 0; i < nums.length; i++ )
        {
            for ( int j = 0; j < i; j++ )
            {
                if ( nums[ i ] > nums[ j ] )
                {
                    if ( dp[ j ] + 1 == dp[ i ] )
                    {
                        count[ i ] += count[ j ];
                    }
                    else if ( ( dp[ j ] + 1 > dp[ i ] ) )
                    {
                        count[ i ] = count[ j ];
                    }
                    dp[ i ] = Math.max( dp[ i ], dp[ j ] + 1 );
                }
            }
            max = Math.max( max, dp[ i ] );
        }

        for ( int i = 0; i < nums.length; i++ )
        {
            if ( dp[ i ] == max )
            {
                res += count[ i ];
            }
        }
        return res;
    }
}
