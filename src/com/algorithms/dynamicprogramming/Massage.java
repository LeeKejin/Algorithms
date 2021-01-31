package com.algorithms.dynamicprogramming;

public class Massage
{
    int dp[] = new int[ 10000 ];

    public int massage( int[] nums )
    {
        if ( nums.length == 0 ) return 0;
        if ( nums.length == 1 ) return nums[ 0 ];
        dp[ 0 ] = nums[ 0 ];
        for ( int i = 1; i < nums.length; i++ )
        {
            int sum1 = nums[ i ];
            if ( i - 2 >= 0 )
            {
                sum1 += dp[ i - 2 ];
            }
            dp[ i ] = Math.max( dp[ i - 1 ], sum1 );
        }
        return Math.max( dp[ nums.length - 1 ], dp[ nums.length - 2 ] );
    }
}
