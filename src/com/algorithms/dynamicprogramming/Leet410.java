package com.algorithms.dynamicprogramming;

public class Leet410
{
    public int splitArray( int[] nums, int m )
    {
        if ( nums.length == 0 ) return 0;
        int dp[][] = new int[ m ][ nums.length ];
        int sum = 0;
        for ( int i = 0; i < nums.length; i++ )
        {
            sum += nums[ i ];
            dp[ 0 ][ i ] = sum;
        }

        for ( int n = 1; n < m; n++ )
        {
            for ( int i = n; i < nums.length; i++ )
            {
                sum = 0;
                int val = 0;
                int min = Integer.MAX_VALUE;
                for ( int j = i; j >= n; j-- )
                {
                    sum += nums[ j ];
                    val = Math.max( dp[ n - 1 ][ j - 1 ], sum );
                    min = Math.min( val, min );
                }
                dp[ n ][ i ] = min;
            }
        }
        return dp[ m - 1 ][ nums.length - 1 ];
    }
}
