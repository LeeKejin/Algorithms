package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet827
{
    List< Integer > areaList = new ArrayList<>();
    int area = 0;

    public int largestIsland( int[][] grid )
    {
        for ( int i = 0; i < grid.length; i++ )
        {
            for ( int j = 0; j < grid[ 0 ].length; j++ )
            {
                if ( grid[ i ][ j ] == 1 )
                {
                    int area = dfs( grid, i, j, areaList.size() + 2 );
                    areaList.add( area );
                }
            }
        }
        if ( areaList.isEmpty() ) return 1;
        int maxArea = Collections.max( areaList );

        for ( int i = 0; i < grid.length; i++ )
        {
            for ( int j = 0; j < grid[ 0 ].length; j++ )
            {
                if ( grid[ i ][ j ] == 0 )
                {
                    area = Math.max( changeSea( grid, grid.length, grid[ 0 ].length, i, j ), area );
                }
            }
        }

        return Math.max( Collections.max( areaList ), area );
    }

    private int changeSea( int[][] grid, int m, int n, int i, int j )
    {
        //Use set to avoid same island
        Set< Integer > set = new HashSet<>();
        int areaSum = 1;
        if ( i - 1 >= 0 ) set.add( grid[ i - 1 ][ j ] );
        if ( i + 1 < m ) set.add( grid[ i + 1 ][ j ] );
        if ( j - 1 >= 0 ) set.add( grid[ i ][ j - 1 ] );
        if ( j + 1 < n ) set.add( grid[ i ][ j + 1 ] );
        for ( Integer index : set )
        {
            if ( index - 2 >= 0 ) areaSum += areaList.get( index - 2 );
        }
        return areaSum;
    }

    private int dfs( int[][] grid, int i, int j, int mark )
    {
        if ( i < 0 || i >= grid.length || j < 0 || j >= grid[ 0 ].length || grid[ i ][ j ] != 1 )
        {
            return 0;
        }

        grid[ i ][ j ] = mark;

        return dfs( grid, i - 1, j, mark ) +
            dfs( grid, i + 1, j, mark ) +
            dfs( grid, i, j - 1, mark ) +
            dfs( grid, i, j + 1, mark ) + 1;

    }

    public static void main( String[] args )
    {
        int[][] grid3 = new int[][] { { 1 } };
        int[][] grid2 = new int[][] {
            { 0, 1, 0, 1, 1 },
            { 1, 1, 1, 0, 0 },
            { 1, 1, 0, 0, 1 },
            { 0, 1, 0, 0, 1 }
        };

        int[][] grid1 = new int[][] {
            { 1, 0, 0 },
            { 0, 1, 0 },
            { 1, 1, 0 }
        };
        int[][] grid4 = new int[][] {
            { 1, 0 },
            { 0, 1 }
        };
        int[][] grid = new int[][] {
            { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
            { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
            { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
        };

        Leet827 t = new Leet827();
        int area = t.largestIsland( grid4 );
        System.out.println( area );
    }
}
