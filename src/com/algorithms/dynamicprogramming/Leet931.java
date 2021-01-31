package com.algorithms.dynamicprogramming;

public class Leet931
{
    public int minFallingPathSum( int[][] matrix )
    {
        int n = matrix.length;
        int m = matrix[ 0 ].length;
        int dp[][] = new int[ n ][ m + 2 ];
        int min = Integer.MAX_VALUE;
        for ( int i = 1; i <= m; i++ )
        {
            dp[ n - 1 ][ i ] = matrix[ n - 1 ][ i - 1 ];
        }
        for ( int i = 0; i < n; i++ )
        {
            dp[ i ][ 0 ] = Integer.MAX_VALUE;
            dp[ i ][ m + 1 ] = Integer.MAX_VALUE;
        }
        for ( int i = n - 2; i >= 0; i-- )
        {
            for ( int j = 1; j <= m; j++ )
            {
                dp[ i ][ j ] = matrix[ i ][ j - 1 ] + Math
                    .min( dp[ i + 1 ][ j ], Math.min( dp[ i + 1 ][ j - 1 ], dp[ i + 1 ][ j + 1 ] ) );
            }
        }
        for ( int i = 1; i < m + 1; i++ )
        {
            min = Math.min( min, dp[ 0 ][ i ] );
        }

        return min;
    }
}
