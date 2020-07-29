package com.algorithms.tree.backtrace.twodimension;

public class Leet200
{
    static boolean used[][];
    static int count = 0;

    public static int numIslands( char[][] grid )
    {
        if ( grid == null ) return 0;
        used = new boolean[ grid.length ][ grid[ 0 ].length ];
        for ( int i = 0; i < grid.length; i++ )
        {
            for ( int j = 0; j < grid[ 0 ].length; j++ )
            {
                if ( grid[ i ][ j ] == '1' && !used[ i ][ j ] )
                {
                    count++;
                    findIsland( grid, i, j );
                }
            }
        }
        return count;
    }

    private static void findIsland( char[][] grid, int startX, int startY )
    {
        if ( grid[ startX ][ startY ] == '1' )
        {
            used[ startX ][ startY ] = true;

            //Up
            if ( startY + 1 < grid[ 0 ].length && !used[ startX ][ startY + 1 ] )
            {
                findIsland( grid, startX, startY + 1 );
            }

            //Right
            if ( startX + 1 < grid.length && !used[ startX + 1 ][ startY ] )
            {
                findIsland( grid, startX + 1, startY );
            }

            //Down
            if ( startY - 1 >= 0 && !used[ startX ][ startY - 1 ] )
            {
                findIsland( grid, startX, startY - 1 );
            }

            //Left
            if ( startX - 1 >= 0 && !used[ startX - 1 ][ startY ] )
            {
                findIsland( grid, startX - 1, startY );
            }
        }
        return;
    }

    public static void main( String[] args )
    {
        char[][] board = new char[][]
            { { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        System.out.println( numIslands( board ) );
    }
}
