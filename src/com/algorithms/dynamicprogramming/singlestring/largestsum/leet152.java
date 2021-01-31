package com.algorithms.dynamicprogramming.singlestring.largestsum;

import java.util.Arrays;

public class leet152
{
    int dp[][];

    public int maxProductBetterSolution( int[] nums )
    {
        if ( nums.length == 0 ) return 0;
        if ( nums.length == 1 ) return nums[ 0 ];
        dp = new int[ nums.length ][ 2 ];
        dp[ 0 ][ 0 ] = nums[ 0 ];
        dp[ 0 ][ 1 ] = nums[ 0 ];

        for ( int i = 1; i < nums.length; i++ )
        {
            dp[ i ][ 0 ] =
                Math.min( nums[ i ], Math.min( nums[ i ] * dp[ i - 1 ][ 0 ], nums[ i ] * dp[ i - 1 ][ 1 ] ) );
            dp[ i ][ 1 ] =
                Math.max( nums[ i ], Math.max( nums[ i ] * dp[ i - 1 ][ 1 ], nums[ i ] * dp[ i - 1 ][ 0 ] ) );
        }
        int max = Integer.MIN_VALUE;
        for ( int i = 0; i < nums.length; i++ )
        {
            max = Math.max( dp[ i ][ 1 ], max );
        }
        return max;
    }

    public int maxProduct( int[] nums )
    {
        int dpMax[] = Arrays.copyOf( nums, nums.length );
        int dpMin[] = Arrays.copyOf( nums, nums.length );
        dpMax[ 0 ] = nums[ 0 ];
        dpMin[ 0 ] = nums[ 0 ];
        int dp[] = Arrays.copyOf( nums, nums.length );
        for ( int i = 1; i < nums.length; i++ )
        {
            dpMax[ i ] = Math.max( Math.max( nums[ i ], dpMax[ i - 1 ] * nums[ i ] ), dpMin[ i - 1 ] * nums[ i ] );
            dpMin[ i ] = Math.min( Math.min( nums[ i ], dpMax[ i - 1 ] * nums[ i ] ), dpMin[ i - 1 ] * nums[ i ] );

        }
        int max = Integer.MIN_VALUE;
        for ( int v : dpMax )
        {
            max = Math.max( max, v );
        }
        return max;
    }

}
