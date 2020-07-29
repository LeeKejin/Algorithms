package com.algorithms.tree.backtrace.twodimension;

public class Leet37
{
    static boolean b = false;

    public static void solveSudoku( char[][] board )
    {
        putNumberInBoard( board, 0, 0 );
    }

    private static void putNumberInBoard( char[][] board, int row, int column )
    {
        if ( board[ row ][ column ] == '.' )
        {
            int[] block = findBlock( row, column );
            for ( int i = 1; i < 10; i++ )
            {
                if ( !findInThreeByThreeGrid( board, block, Character.forDigit( i, 10 ) )
                    && !sameColumnOrRow( board, row, column, Character.forDigit( i, 10 ) ) )
                {
                    board[ row ][ column ] = Character.forDigit( i, 10 );
                    if ( row == 8 && column == 8 )
                    {
                        b = true;
                        return;
                    }

                    if ( !b ) nextStep( board, row, column );
                }
            }
            if ( !b ) board[ row ][ column ] = '.';
        }
        else
        {
            if ( !b ) nextStep( board, row, column );
        }
    }

    private static void nextStep( char[][] board, int row, int column )
    {
        if ( column == 8 )
        {
            if ( row == 8 ) return;
            if ( !b ) putNumberInBoard( board, row + 1, 0 );
        }
        else
        {
            if ( !b ) putNumberInBoard( board, row, column + 1 );
            if ( row == 8 && column + 1 == 8 ) return;
        }
    }

    private static boolean findInThreeByThreeGrid( char[][] board, int[] block, char num )
    {
        for ( int i = block[ 0 ]; i < block[ 0 ] + 3; i++ )
        {
            for ( int j = block[ 1 ]; j < block[ 1 ] + 3; j++ )
            {
                if ( num == board[ i ][ j ] )
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean sameColumnOrRow( char[][] board, int row, int column, char num )
    {
        //row
        for ( int i = 0; i < 9; i++ )
        {
            if ( board[ row ][ i ] == num )
            {
                return true;
            }
        }
        //column
        for ( int i = 0; i < 9; i++ )
        {
            if ( board[ i ][ column ] == num )
            {
                return true;
            }
        }
        return false;
    }

    public static int[] findBlock( int row, int column )
    {
        if ( row >= 0 && row < 3 )
        {
            if ( column >= 0 && column < 3 )
            {
                return new int[] { 0, 0 };
            }
            else if ( column >= 3 && column < 6 )
            {
                return new int[] { 0, 3 };
            }
            else
            {
                return new int[] { 0, 6 };
            }
        }
        if ( row >= 3 && row < 6 )
        {
            if ( column >= 0 && column < 3 )
            {
                return new int[] { 3, 0 };
            }
            else if ( column >= 3 && column < 6 )
            {
                return new int[] { 3, 3 };
            }
            else
            {
                return new int[] { 3, 6 };
            }
        }
        else
        {
            if ( column >= 0 && column < 3 )
            {
                return new int[] { 6, 0 };
            }
            else if ( column >= 3 && column < 6 )
            {
                return new int[] { 6, 3 };
            }
            else
            {
                return new int[] { 6, 6 };
            }
        }
    }

    public static void main( String[] args )
    {
        char board[][] = new char[][] {
            { '.', '.', '9', '7', '4', '8', '.', '.', '.' }, { '7', '.', '.', '.', '.', '.', '.', '.', '.' },
            { '.', '2', '.', '1', '.', '9', '.', '.', '.' }, { '.', '.', '7', '.', '.', '.', '2', '4', '.' },
            { '.', '6', '4', '.', '1', '.', '5', '9', '.' }, { '.', '9', '8', '.', '.', '.', '3', '.', '.' },
            { '.', '.', '.', '8', '.', '3', '.', '2', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '6' },
            { '.', '.', '.', '2', '7', '5', '9', '.', '.' }
        };
        solveSudoku( board );
        for ( int i = 0; i < 9; i++ )
        {
            for ( int j = 0; j < 9; j++ )
            {
                System.out.print( board[ i ][ j ] + "," );
            }
            System.out.println();
        }

    }
}
