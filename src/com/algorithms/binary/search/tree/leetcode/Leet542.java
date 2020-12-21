package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//1162
public class Leet542
{
    int[][] res;
    boolean[][] visited;
    int[][] dir = new int[][] {
        { -1, 0 },
        { 1, 0 },
        { 0, -1 },
        { 0, 1 }
    };

    public int[][] updateMatrix( int[][] matrix )
    {
        res = new int[ matrix.length ][ matrix[ 0 ].length ];
        visited = new boolean[ matrix.length ][ matrix[ 0 ].length ];
        Queue< List< Integer > > queue = new LinkedList<>();

        for ( int i = 0; i < matrix.length; i++ )
        {
            for ( int j = 0; j < matrix[ 0 ].length; j++ )
            {
                if ( matrix[ i ][ j ] == 0 )
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
                if ( newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[ 0 ].length
                    && !visited[ newX ][ newY ] )
                {
                    visited[ newX ][ newY ] = true;
                    res[ newX ][ newY ] = res[ x ][ y ] + 1;
                    List< Integer > list = new ArrayList<>();
                    list.add( newX );
                    list.add( newY );
                    queue.add( list );
                }
            }
        }
        return res;
    }
}
