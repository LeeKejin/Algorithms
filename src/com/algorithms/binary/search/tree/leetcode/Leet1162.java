package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet1162
{
    int[][] res;
    boolean[][] visited;
    int[][] dir = new int[][] {
        { -1, 0 },
        { 1, 0 },
        { 0, -1 },
        { 0, 1 }
    };
    int min = -1;

    public int maxDistance( int[][] grid )
    {
        visited = new boolean[ grid.length ][ grid[ 0 ].length ];
        res = new int[ grid.length ][ grid[ 0 ].length ];

        Queue< List< Integer > > queue = new LinkedList<>();
        for ( int i = 0; i < grid.length; i++ )
        {
            for ( int j = 0; j < grid[ 0 ].length; j++ )
            {
                if ( grid[ i ][ j ] == 1 )
                {
                    List< Integer > list = new ArrayList<>();
                    list.add( i );
                    list.add( j );
                    queue.add( list );
                    visited[ i ][ j ] = true;
                }
            }
        }

        while ( !queue.isEmpty() )
        {
            List< Integer > position = queue.poll();
            int x = position.get( 0 );
            int y = position.get( 1 );
            for ( int i = 0; i < dir.length; i++ )
            {
                int newX = x + dir[ i ][ 0 ];
                int newY = y + dir[ i ][ 1 ];
                if ( newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[ 0 ].length
                    && !visited[ newX ][ newY ] )
                {
                    res[ newX ][ newY ] = res[ x ][ y ] + 1;
                    visited[ newX ][ newY ] = true;
                    min = Math.max( min, res[ newX ][ newY ] );
                    List< Integer > list = new ArrayList<>();
                    list.add( newX );
                    list.add( newY );
                    queue.add( list );
                }
            }
        }
        return min;
    }
}
