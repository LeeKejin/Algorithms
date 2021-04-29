package com.algorithms.dynamicprogramming.amazon;

public class Leet1335
{
    public int minDifficulty( int[] jobDifficulty, int d )
    {
        if ( d > jobDifficulty.length ) return -1;
        int n = jobDifficulty.length;
        int[][] dp = new int[ d ][ n ];
        dp[ 0 ][ 0 ] = jobDifficulty[ 0 ];
        int cur = jobDifficulty[ 0 ];
        for ( int i = 1; i < n; i++ )
        {
            dp[ 0 ][ i ] = Math.max( cur, jobDifficulty[ i ] );
            cur = dp[ 0 ][ i ];
        }

        for ( int i = 1; i < d; i++ )
        {
            for ( int j = i; j < n; j++ )
            {
                int min = -1;
                dp[ i ][ j ] = Integer.MAX_VALUE;
                for ( int k = j; k >= i; k-- )
                {
                    min = Math.max( min, jobDifficulty[ k ] );
                    dp[ i ][ j ] = Math.min( min + dp[ i - 1 ][ k - 1 ], dp[ i ][ j ] );
                }
            }
        }
        return dp[ d - 1 ][ n - 1 ];
    }
}
