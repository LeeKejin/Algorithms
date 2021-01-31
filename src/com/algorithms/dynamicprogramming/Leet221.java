package com.algorithms.dynamicprogramming;

public class Leet221
{
    public int maximalSquare( char[][] matrix )
    {
        int n = matrix.length;
        int m = matrix[ 0 ].length;
        int dp[][] = new int[ n + 1 ][ m + 1 ];
        int length = 0;
        for ( int i = 1; i <= n; i++ )
        {
            for ( int j = 1; j <= m; j++ )
            {
                if ( matrix[ i - 1 ][ j - 1 ] == '1' )
                {
                    dp[ i ][ j ] = 1 + Math.min( dp[ i - 1 ][ j - 1 ], Math.min( dp[ i - 1 ][ j ], dp[ i ][ j - 1 ] ) );
                    length = Math.max( length, dp[ i ][ j ] );
                }
            }
        }
        return length * length;
    }

}
