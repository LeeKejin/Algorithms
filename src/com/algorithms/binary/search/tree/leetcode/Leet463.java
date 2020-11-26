package com.algorithms.binary.search.tree.leetcode;

public class Leet463
{
    int result = 0;

    public int islandPerimeter( int[][] grid )
    {
        for ( int i = 0; i < grid.length; i++ )
        {
            for ( int j = 0; j < grid[ 0 ].length; j++ )
            {
                if ( grid[ i ][ j ] == 1 )
                {
                    dfs( grid, i, j );
                }
            }
        }
        return result;
    }

    private void dfs( int[][] grid, int i, int j )
    {
        if ( i < 0 || i >= grid.length || j < 0 || j >= grid[ 0 ].length || grid[ i ][ j ] == 0 )
        {
            result++;
            return;
        }
        if ( grid[ i ][ j ] == 2 ) return;
        grid[ i ][ j ] = 2;
        dfs( grid, i - 1, j );
        dfs( grid, i + 1, j );
        dfs( grid, i, j - 1 );
        dfs( grid, i, j + 1 );
    }
}
