package com.algorithms.sword.means.offer;

public class Offer12
{
    public boolean exist( char[][] board, String word )
    {
        if ( board.length == 0 ) return false;
        boolean visited[][] = new boolean[ board.length ][ board[ 0 ].length ];

        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[ 0 ].length; j++ )
            {
                if ( word.startsWith( String.valueOf( board[ i ][ j ] ) ) )
                {
                    if ( dfs( word, 0, i, j, visited, board ) ) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs( String word, int index, int i, int j, boolean visited[][], char[][] board )
    {
        if ( index == word.length() ) return true;
        String subStr = word.substring( index );
        if ( i < 0 || i >= visited.length || j < 0 || j >= visited[ 0 ].length
            || visited[ i ][ j ]
            || !subStr.startsWith( String.valueOf( board[ i ][ j ] ) ) )
        {
            return false;
        }
        visited[ i ][ j ] = true;
        if ( dfs( word, index + 1, i - 1, j, visited, board )
            || dfs( word, index + 1, i + 1, j, visited, board )
            || dfs( word, index + 1, i, j - 1, visited, board )
            || dfs( word, index + 1, i, j + 1, visited, board ) )
        {
            return true;
        }
        visited[ i ][ j ] = false;
        return false;
    }
}
