package com.algorithms.dynamicprogramming.amazon;

public class MaxSubArray
{
    public int maxSubArray( int[] nums )
    {
        if ( nums.length == 0 ) return 0;
        if ( nums.length == 1 ) return nums[ 0 ];
        int[] dp = new int[ nums.length ];
        dp[ 0 ] = nums[ 0 ];
        int max = nums[ 0 ];
        for ( int i = 1; i < nums.length; i++ )
        {
            dp[ i ] = Math.max( dp[ i - 1 ], 0 ) + nums[ i ];
            if ( dp[ i ] > max ) max = dp[ i ];
        }
        return max;
    }
}
