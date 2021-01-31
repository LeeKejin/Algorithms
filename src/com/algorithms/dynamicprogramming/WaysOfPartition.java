package com.algorithms.dynamicprogramming;

public class WaysOfPartition
{
    public int waysOfPartitionDP( int n, int k )
    {
        if ( k > n ) return 0;
        if ( k == 1 || k == n ) return 1;
        int dp[][] = new int[ k + 1 ][ n + 1 ];
        for ( int i = 1; i <= k; i++ )
        {
            dp[ i ][ i ] = 1;
        }
        for ( int i = 1; i <= n; i++ )
        {
            dp[ 1 ][ i ] = 1;
        }
        for ( int i = 2; i <= k; i++ )
        {
            for ( int j = i + 1; j <= n; j++ )
            {
                dp[ i ][ j ] = i * dp[ i ][ j - 1 ] + dp[ i - 1 ][ j - 1 ];
            }
        }
        return dp[ k ][ n ];
    }

    public int waysOfPartition( int n, int k )
    {
        if ( k > n ) return 0;
        if ( k == 1 || k == n ) return 1;
        return k * waysOfPartition( n - 1, k ) + waysOfPartition( n - 1, k - 1 );
    }
}
