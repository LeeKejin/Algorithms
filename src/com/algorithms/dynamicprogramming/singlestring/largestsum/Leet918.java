package com.algorithms.dynamicprogramming.singlestring.largestsum;

public class Leet918
{
    public int maxSubarraySumCircular( int[] A )
    {
        if ( A.length == 0 ) return 0;
        if ( A.length == 1 ) return A[ 0 ];
        int sum = A[ 0 ];
        int maxWithinRange = A[ 0 ];
        int minWithinRange = A[ 1 ];
        int maxRes = A[ 0 ];
        int minRes = A[ 1 ];

        for ( int i = 1; i < A.length; i++ )
        {
            sum += A[ i ];
            maxWithinRange = Math.max( maxWithinRange, 0 ) + A[ i ];
            maxRes = Math.max( maxRes, maxWithinRange );
        }

        for ( int i = 2; i < A.length - 1; i++ )
        {
            minWithinRange = Math.min( minWithinRange, 0 ) + A[ i ];
            minRes = Math.min( minRes, minWithinRange );
        }

        return Math.max( maxRes, sum - minRes );
    }
}
