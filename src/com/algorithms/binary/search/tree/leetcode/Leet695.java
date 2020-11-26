package com.algorithms.binary.search.tree.leetcode;

public class Leet695
{

    int count = 1;

    public int maxAreaOfIsland( int[][] grid )
    {
        for ( int i = 0; i < grid.length; i++ )
        {
            for ( int j = 0; j < grid[ 0 ].length; j++ )
            {
                if ( grid[ i ][ j ] == 1 )
                {
                    int area = calculateArea( grid, i, j, 0 );
                    count = Math.max( area, count );
                }
            }
        }
        return count;
    }

    private int calculateArea( int[][] grid, int y, int x, int area )
    {
        if ( ( y >= grid.length || x >= grid[ 0 ].length || x < 0 || y < 0 ) || grid[ y ][ x ] != 1 )
        {
            return 0;
        }

        grid[ y ][ x ] = 2;

        return 1 +
            calculateArea( grid, y + 1, x, area )
            + calculateArea( grid, y - 1, x, area )
            + calculateArea( grid, y, x - 1, area )
            + calculateArea( grid, y, x + 1, area );
    }

    int area = 0;
    int res = 0;

    public int maxAreaOfIslandFaster( int[][] grid )
    {
        for ( int i = 0; i < grid.length; i++ )
        {
            for ( int j = 0; j < grid[ 0 ].length; j++ )
            {
                if ( grid[ i ][ j ] == 1 )
                {
                    dfs( grid, i, j, 0 );
                    res = Math.max( res, area );
                    area = 0;
                }
            }
        }
        return res;
    }

    private void dfs( int[][] grid, int y, int x, int area )
    {
        if ( ( y >= grid.length || x >= grid[ 0 ].length || x < 0 || y < 0 ) || grid[ y ][ x ] != 1 )
        {
            return;
        }

        if ( grid[ y ][ x ] == 1 )
        {
            this.area++;
            grid[ y ][ x ] = 2;
        }
        calculateArea( grid, y + 1, x, area );
        calculateArea( grid, y - 1, x, area );
        calculateArea( grid, y, x - 1, area );
        calculateArea( grid, y, x + 1, area );
    }
}
