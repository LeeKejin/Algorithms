package com.algorithms.dynamicprogramming;

public class Leet174
{
    public int calculateMinimumHP( int[][] dungeon )
    {
        int n = dungeon.length;
        int m = dungeon[ 0 ].length;
        int[][] dp = new int[ n ][ m ];

        for ( int i = n - 1; i >= 0; i-- )
        {
            for ( int j = m - 1; j >= 0; j-- )
            {
                if ( i == n - 1 && j == m - 1 )
                {
                    dp[ i ][ j ] = dungeon[ i ][ j ] < 0 ? dungeon[ i ][ j ] : 0;
                }
                else if ( i == n - 1 )
                {
                    int val = dungeon[ i ][ j ] + dp[ i ][ j + 1 ];

                    dp[ i ][ j ] = val > 0 ? 0 : val;
                }
                else if ( j == m - 1 )
                {
                    int val = dungeon[ i ][ j ] + dp[ i + 1 ][ j ];
                    dp[ i ][ j ] = val > 0 ? 0 : val;
                }
                else
                {
                    int val = Math.max( dp[ i + 1 ][ j ], dp[ i ][ j + 1 ] ) + dungeon[ i ][ j ];
                    dp[ i ][ j ] = val > 0 ? 0 : val;
                }
            }
        }
        return 0 - dp[ 0 ][ 0 ] + 1;
    }

}
