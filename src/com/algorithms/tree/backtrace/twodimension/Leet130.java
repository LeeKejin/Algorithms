package com.algorithms.tree.backtrace.twodimension;

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

    public static void solveSolution1( char[][] board )
    {
        int columnNum = board[ 0 ].length - 1;
        int rowNum = board.length - 1;

        for ( int i = 0; i < board[ 0 ].length; i++ )
        {
            if ( board[ 0 ][ i ] == 'O' ) dfsSolution( board, 0, i );
            if ( board[ rowNum ][ i ] == 'O' ) dfsSolution( board, rowNum, i );
        }

        for ( int i = 0; i < board.length; i++ )
        {
            if ( board[ i ][ 0 ] == 'O' ) dfsSolution( board, i, 0 );
            if ( board[ i ][ columnNum ] == 'O' ) dfsSolution( board, i, columnNum );
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

    private static void dfsSolution( char[][] board, int row, int column )
    {
        if ( row < 0 || row >= board.length || column < 0 || column >= board[ 0 ].length
            || board[ row ][ column ] != 'O' ) return;
        board[ row ][ column ] = '#';
        dfsSolution( board, row + 1, column );
        dfsSolution( board, row, column + 1 );
        dfsSolution( board, row - 1, column );
        dfsSolution( board, row, column - 1 );

    }

    public static void main( String[] args )
    {
        char[][] board = new char[][]
            { { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        solve( board );
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[ 0 ].length; j++ )
            {
                System.out.print( board[ i ][ j ] );
            }
            System.out.println();
        }
    }
}
