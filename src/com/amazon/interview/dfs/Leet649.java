package com.amazon.interview.dfs;

import java.util.HashSet;
import java.util.Set;

public class Leet649
{
    int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int numDistinctIslands( int[][] grid )
    {
        int m = grid.length;
        int n = grid[ 0 ].length;
        boolean[][] visited = new boolean[ m ][ n ];
        Set< String > res = new HashSet<>();
        for ( int i = 0; i < m; i++ )
        {
            for ( int j = 0; j < n; j++ )
            {
                if ( !visited[ i ][ j ] && grid[ i ][ j ] == 1 )
                {
                    StringBuilder stringBuilder = new StringBuilder();
                    dfs( i, j, i, j, visited, grid, stringBuilder );
                    res.add( stringBuilder.toString() );
                }
            }
        }
        return res.size();
    }

    private void dfs( int i, int j, int prevI, int prevJ, boolean[][] visited, int[][] grid,
        StringBuilder stringBuilder )
    {
        if ( i < 0 || i >= grid.length || j < 0 || j >= grid[ 0 ].length || visited[ i ][ j ] || grid[ i ][ j ] != 1 )
            return;
        stringBuilder.append( i - prevI );
        stringBuilder.append( j - prevJ );
        visited[ i ][ j ] = true;
        for ( int[] dir : directions )
        {
            int newX = i + dir[ 0 ];
            int newY = j + dir[ 1 ];
            dfs( newX, newY, prevI, prevJ, visited, grid, stringBuilder );
        }
    }
}
