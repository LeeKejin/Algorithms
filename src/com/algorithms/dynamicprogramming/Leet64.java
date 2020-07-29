package com.algorithms.dynamicprogramming;

public class Leet64
{
    //Slow solution
    public static int minPathSum( int[][] grid )
    {
        int n = grid.length;
        int m = grid[ 0 ].length;
        int dp[][] = new int[ n + 1 ][ m + 1 ];

        for ( int i = n - 1; i >= 0; i-- )
        {
            for ( int j = m - 1; j >= 0; j-- )
            {
                int right = 0;

                if ( i == n - 1 && j == m - 1 )
                {
                    dp[ i ][ j ] = grid[ i ][ j ];
                }
                else if ( i == n - 1 )
                {
                    dp[ i ][ j ] = grid[ i ][ j ] + dp[ i ][ j + 1 ];
                }
                else
                {
                    if ( j == m - 1 )
                    {
                        dp[ i ][ j ] = dp[ i + 1 ][ j ] + grid[ i ][ j ];
                    }
                    else
                    {
                        dp[ i ][ j ] = Math.min( dp[ i + 1 ][ j ], dp[ i ][ j + 1 ] ) + grid[ i ][ j ];
                    }
                }

            }
        }
        return dp[ 0 ][ 0 ];
    }

    public static int minPathSumSolution1( int[][] grid )
    {
        int n = grid.length;
        int m = grid[ 0 ].length;
        int dp[][] = new int[ n + 1 ][ m + 1 ];
        for ( int i = n - 1; i >= 0; i-- )
        {
            dp[ i ][ m - 1 ] = grid[ i ][ m - 1 ] + dp[ i + 1 ][ m - 1 ];
        }

        for ( int i = m - 1; i >= 0; i-- )
        {
            dp[ n - 1 ][ i ] = grid[ n - 1 ][ i ] + dp[ n - 1 ][ i + 1 ];
        }
        for ( int i = n - 2; i >= 0; i-- )
        {
            for ( int j = m - 2; j >= 0; j-- )
            {
                dp[ i ][ j ] = Math.min( dp[ i + 1 ][ j ], dp[ i ][ j + 1 ] ) + grid[ i ][ j ];
            }
        }
        return dp[ 0 ][ 0 ];
    }

    public static void main( String[] args )
    {
        int grid[][] = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        //        int grid[][] = new int[][] { { 1, 2, 5 }, { 3, 2, 1 } };

        System.out.print( minPathSum( grid ) );
    }
}
