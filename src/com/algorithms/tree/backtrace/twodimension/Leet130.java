package com.algorithms.tree.backtrace.twodimension;

import java.util.HashSet;
import java.util.Set;

public class Leet130
{

    public static void solve( char[][] board )
    {
        if ( board == null || board.length == 0 ) return;

        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[ 0 ].length; j++ )
            {
                boolean isEdge = i == 0 || j == 0 || i == board.length - 1 || j == board[ 0 ].length - 1;
                if ( board[ i ][ j ] == 'O' && isEdge )
                {
                    dfs( board, i, j );
                }
            }
        }

        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[ 0 ].length; j++ )
            {
                if ( board[ i ][ j ] == 'O' )
                {
                    board[ i ][ j ] = 'X';
                }
                if ( board[ i ][ j ] == '#' )
                {
                    board[ i ][ j ] = 'O';
                }
            }
        }
    }

    private static void dfs( char[][] board, int startX, int startY )
    {
        if ( startX < 0 || startX >= board.length || startY < 0 || startY >= board[ 0 ].length
            || board[ startX ][ startY ] == 'X' || board[ startX ][ startY ] == '#' )
        {
            return;
        }
        board[ startX ][ startY ] = '#';
        dfs( board, startX - 1, startY );
        dfs( board, startX + 1, startY );
        dfs( board, startX, startY - 1 );
        dfs( board, startX, startY + 1 );
    }

    public void solve1( char[][] board )
    {
        int m = board.length;
        int n = board[ 0 ].length;
        Set< int[] > oPoints = new HashSet<>();
        boolean visited[][] = new boolean[ m ][ n ];
        for ( int j = 0; j < n; j++ )
        {
            if ( board[ 0 ][ j ] == 'O' )
            {
                oPoints.add( new int[] { 0, j } );
            }
            if ( board[ m - 1 ][ j ] == 'O' )
            {
                oPoints.add( new int[] { m - 1, j } );
            }
        }

        for ( int i = 0; i < m; i++ )
        {
            if ( board[ i ][ 0 ] == 'O' )
            {
                oPoints.add( new int[] { i, 0 } );
            }
            if ( board[ i ][ n - 1 ] == 'O' )
            {
                oPoints.add( new int[] { i, n - 1 } );
            }
        }
        for ( int[] point : oPoints )
        {
            int x = point[ 0 ];
            int y = point[ 1 ];
            dfs( x, y, visited, board );
        }
        for ( int i = 0; i < m; i++ )
        {
            for ( int j = 0; j < n; j++ )
            {
                if ( !visited[ i ][ j ] )
                {
                    board[ i ][ j ] = 'X';
                }
            }
        }
    }

    private void dfs( int x, int y, boolean visited[][], char[][] board )
    {
        if ( isInArea( x, y, visited.length, visited[ 0 ].length ) && !visited[ x ][ y ] && board[ x ][ y ] == 'O' )
        {
            visited[ x ][ y ] = true;
            int[][] direction = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

            for ( int[] dir : direction )
            {
                int newX = x + dir[ 0 ];
                int newY = y + dir[ 1 ];
                dfs( newX, newY, visited, board );
            }
        }
    }

    boolean isInArea( int x, int y, int m, int n )
    {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
