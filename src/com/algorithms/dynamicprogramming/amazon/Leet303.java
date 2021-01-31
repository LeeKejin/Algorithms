package com.algorithms.dynamicprogramming.amazon;

public class Leet303
{
    int[] nums;
    int dp[];

    public Leet303( int[] nums )
    {
        if ( nums.length == 0 ) dp = new int[] {};
        else
        {
            nums = nums;
            dp = new int[ nums.length ];
            dp[ 0 ] = nums[ 0 ];
            for ( int i = 1; i < nums.length; i++ )
            {
                dp[ i ] = dp[ i - 1 ] + nums[ i ];
            }
        }

    }

    public int sumRange( int i, int j )
    {
        if ( dp.length == 0 ) return 0;
        if ( i == 0 ) return dp[ j ];
        return dp[ j ] - dp[ i - 1 ];
    }
}
