package com.algorithms.dynamicprogramming;

public class Leet265
{
    public int minCostII( int[][] costs )
    {
        if ( costs.length == 0 ) return 0;
        int m = costs.length;
        int n = costs[ 0 ].length;
        int[][] dp = new int[ m ][ n ];
        for ( int i = 0; i < n; i++ )
        {
            dp[ m - 1 ][ i ] = costs[ m - 1 ][ i ];
        }
        for ( int i = m - 2; i >= 0; i-- )
        {
            for ( int j = 0; j < n; j++ )
            {
                int price = Integer.MAX_VALUE;
                for ( int k = 0; k < n; k++ )
                {
                    if ( k == j ) continue;
                    price = Math.min( price, dp[ i + 1 ][ k ] );
                }
                dp[ i ][ j ] = price + costs[ i ][ j ];
            }
        }
        int res = Integer.MAX_VALUE;
        for ( int i = 0; i < n; i++ )
        {
            res = Math.min( res, dp[ 0 ][ i ] );
        }
        return res;
    }
}
