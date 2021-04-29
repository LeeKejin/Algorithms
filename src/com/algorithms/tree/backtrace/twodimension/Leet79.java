package com.algorithms.tree.backtrace.twodimension;

public class Leet79
{
    public boolean exist( char[][] board, String word )
    {
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[ 0 ].length; j++ )
            {
                if ( board[ i ][ j ] == word.charAt( 0 ) )
                {
                    if ( dfs( board, i, j, word, 0 ) ) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs( char[][] board, int i, int j, String word, int index )
    {
        if ( i < 0 || i >= board.length || j < 0 || j >= board[ 0 ].length || index >= word.length()
            || word.charAt( index ) != board[ i ][ j ] )
        {
            return false;
        }
        if ( index + 1 == word.length() )
        {
            return word.charAt( word.length() - 1 ) == board[ i ][ j ];
        }
        char ch = board[ i ][ j ];
        board[ i ][ j ] = '#';
        if ( dfs( board, i - 1, j, word, index + 1 ) ) return true;
        if ( dfs( board, i + 1, j, word, index + 1 ) ) return true;
        if ( dfs( board, i, j - 1, word, index + 1 ) ) return true;
        if ( dfs( board, i, j + 1, word, index + 1 ) ) return true;

        board[ i ][ j ] = ch;
        return false;
    }

    boolean[][] used;

    //    public boolean exist1( char[][] board, String word )
    //    {
    //        if ( board.length == 0 ) return false;
    //        int n = board.length;
    //        int m = board[ 0 ].length;
    //        used = new boolean[ n ][ m ];
    //
    //        for ( int i = 0; i < n; i++ )
    //        {
    //            for ( int j = 0; j < m; j++ )
    //            {
    //
    //                if ( dfs( board, i, j, 0, word ) ) return true;
    //            }
    //        }
    //        return false;
    //    }
    //
    //    private boolean dfs( char[][] board, int i, int j, int index, String word )
    //    {
    //        if ( index + 1 == word.length() )
    //        {
    //            return word.charAt( index ) == board[ i ][ j ];
    //        }
    //        if ( board[ i ][ j ] == word.charAt( index ) )
    //        {
    //            used[ i ][ j ] = true;
    //            if ( i - 1 >= 0 && !used[ i - 1 ][ j ] )
    //            {
    //                if ( dfs( board, i - 1, j, index + 1, word ) ) return true;
    //            }
    //
    //            if ( i + 1 < board.length && !used[ i + 1 ][ j ] )
    //            {
    //                if ( dfs( board, i + 1, j, index + 1, word ) ) return true;
    //            }
    //            if ( j - 1 >= 0 && !used[ i ][ j - 1 ] )
    //            {
    //                if ( dfs( board, i, j - 1, index + 1, word ) ) return true;
    //            }
    //            if ( j + 1 < board[ 0 ].length && !used[ i ][ j + 1 ] )
    //            {
    //                if ( dfs( board, i, j + 1, index + 1, word ) ) return true;
    //            }
    //            used[ i ][ j ] = false;
    //        }
    //        return false;
    //    }
}
