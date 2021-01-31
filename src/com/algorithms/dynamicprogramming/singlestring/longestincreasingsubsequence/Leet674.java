package com.algorithms.dynamicprogramming.singlestring.longestincreasingsubsequence;

import java.util.Arrays;

public class Leet674
{
    public int findLengthOfLCIS( int[] nums )
    {
        if ( nums.length == 0 ) return 0;
        if ( nums.length == 1 ) return 1;
        int[] dp = new int[ nums.length ];
        Arrays.fill( dp, 1 );
        int res = 0;
        for ( int i = 1; i < nums.length; i++ )
        {
            if ( nums[ i ] > nums[ i - 1 ] )
            {
                dp[ i ] = Math.max( dp[ i - 1 ] + 1, dp[ i ] );
            }

            res = Math.max( res, dp[ i ] );
        }
        return res;
    }
}
