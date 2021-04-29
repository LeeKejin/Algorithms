package com.algorithms.dynamicprogramming.prefix;

public class Leet304
{
    int dp[][];

    public Leet304( int[][] matrix )
    {
        int n = matrix.length;

        if ( n == 0 )
        {
            dp = new int[ 1 ][ 1 ];
        }
        else
        {
            int m = matrix[ 0 ].length;
            dp = new int[ n + 1 ][ m + 1 ];
            for ( int i = 1; i <= n; i++ )
            {
                for ( int j = 1; j <= m; j++ )
                {
                    int sum = 0;
                    for ( int k = 1; k < i; k++ )
                    {
                        sum += matrix[ k - 1 ][ j - 1 ];
                    }
                    if ( j - 1 >= 0 ) dp[ i ][ j ] += dp[ i ][ j - 1 ];
                    dp[ i ][ j ] += sum + matrix[ i - 1 ][ j - 1 ];
                }
            }
        }
    }

    public int sumRegion( int row1, int col1, int row2, int col2 )
    {
        return dp[ row2 + 1 ][ col2 + 1 ] - dp[ row1 ][ col2 + 1 ] - ( dp[ row2 + 1 ][ col1 ] - dp[ row1 ][ col1 ] );

    }
}
