package com.algorithms.dynamicprogramming.knapsack;

public class Knapsack01
{
    public int knapsack01( int[] w, int[] v, int capacity )
    {
        int n = w.length;
        return bestValue( w, v, capacity, n - 1 );
    }

    private int bestValue( int[] w, int[] v, int capacity, int index )
    {
        if ( index < 0 || capacity <= 0 ) return 0;
        int excludeVal = bestValue( w, v, capacity, index - 1 );
        if ( capacity - w[ index ] >= 0 )
        {
            int includeVal = v[ index ] + bestValue( w, v, capacity - w[ index ], index - 1 );
            return Math.max( excludeVal, includeVal );
        }
        return excludeVal;
    }

    public int knapsack01DP( int[] w, int[] v, int capacity )
    {
        int[] dp = new int[ capacity + 1 ];
        for ( int i = 0; i <= capacity; i++ )
        {
            if ( i >= w[ 0 ] ) dp[ i ] = v[ 0 ];
        }

        for ( int i = 1; i < v.length; i++ )
        {
            //it has to be reversed!!! cuz the dp[] will be modified from back to forth.
            // If it's start from 0, the later value will be calculated based on the previous value, but the previous value has been changed!!!
            for ( int j = capacity; j >= 0; j-- )
            {
                int v1 = dp[ j ];
                int v2 = 0;
                if ( j - w[ i ] >= 0 )
                {
                    v2 = v[ i ] + dp[ j - w[ i ] ];
                }
                dp[ j ] = Math.max( v2, v1 );
            }

        }
        return dp[ capacity ];
    }

    public static void main( String[] args )
    {
        int[] w = new int[] { 1, 2, 3 };
        int[] v = new int[] { 6, 10, 12 };
        Knapsack01 k = new Knapsack01();
        System.out.println( k.knapsack01DP( w, v, 5 ) );
    }
}
