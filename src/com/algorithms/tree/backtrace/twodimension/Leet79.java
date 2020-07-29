package com.algorithms.tree.backtrace.twodimension;

import java.util.ArrayList;
import java.util.List;

public class Leet79
{
    static int[][] d = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static List< List< Boolean > > visited = new ArrayList<>();

    public static boolean exist( char[][] board, String word )
    {
        if ( word == null ) return false;
        for ( int i = 0; i < board.length; i++ )
        {
            List< Boolean > list = new ArrayList<>();
            for ( int j = 0; j < board[ 0 ].length; j++ )
            {
                list.add( false );
            }
            visited.add( list );
        }
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[ 0 ].length; j++ )
            {
                if ( searchWord( board, word, 0, i, j ) )
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean searchWord( char[][] board, String word, int index, int startX, int startY )
    {
        //Last character in word
        if ( index == word.length() - 1 )
        {
            return board[ startX ][ startY ] == word.charAt( index );
        }
        if ( board[ startX ][ startY ] == word.charAt( index ) )
        {
            visited.get( startX ).set( startY, true );
            for ( int i = 0; i < 4; i++ )
            {
                int newX = startX + d[ i ][ 0 ];
                int newY = startY + d[ i ][ 1 ];
                if ( inArea( newX, newY, board ) && !visited.get( newX ).get( newY ) )
                {
                    if ( searchWord( board, word, index + 1, newX, newY ) )
                    {
                        return true;
                    }
                }
            }
            visited.get( startX ).set( startY, false ); // This is trace back!!!

        }
        return false;
    }

    private static boolean inArea( int newX, int newY, char[][] board )
    {
        return newX >= 0 && newX < board.length && newY >= 0 && newY < board[ 0 ].length;
    }

    public static void main( String[] args )
    {
        char[][] board = new char[][]
            { { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' } };
        System.out.println( exist( board, "SEE" ) );
    }

    static boolean[][] used;

    public static boolean existFaster( char[][] board, String word )
    {
        if ( word == null ) return false;

        used = new boolean[ board.length ][ board[ 0 ].length ];

        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[ 0 ].length; j++ )
            {
                used[ i ][ j ] = false;
            }
        }

        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[ 0 ].length; j++ )
            {
                if ( findWord( board, word, 0, i, j ) )
                {
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean findWord( char[][] board, String word, int index, int startX, int startY )
    {
        if ( index == word.length() - 1 )
        {
            return board[ startX ][ startY ] == word.charAt( index );
        }
        if ( board[ startX ][ startY ] == word.charAt( index ) )
        {
            used[ startX ][ startY ] = true;
            //Up
            if ( startY + 1 < board[ 0 ].length && !used[ startX ][ startY - 1 ] )
            {
                if ( findWord( board, word, index + 1, startX, startY + 1 ) )
                {
                    return true;
                }
            }

            //Right
            if ( startX + 1 < board.length && !used[ startX + 1 ][ startY ] )
            {
                if ( findWord( board, word, index + 1, startX + 1, startY ) )
                {
                    return true;
                }
            }

            //Left
            if ( startX - 1 >= 0 && !used[ startX - 1 ][ startY ] )
            {
                if ( findWord( board, word, index + 1, startX - 1, startY ) )
                {
                    return true;
                }
            }

            //Down
            if ( startY - 1 >= 0 && !used[ startX ][ startY - 1 ] )
            {
                if ( findWord( board, word, index + 1, startX, startY - 1 ) )
                {
                    return true;
                }
            }
            used[ startX ][ startY ] = false;

        }
        return false;
    }
}
