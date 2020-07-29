package com.algorithms.tree.backtrace.twodimension;

import java.util.ArrayList;
import java.util.List;

public class Leet417
{
    static List< List< Integer > > results = new ArrayList<>();

    public static List< List< Integer > > pacificAtlanticSolution1( int[][] matrix )
    {
        if ( matrix == null || matrix.length == 0 ) return new ArrayList<>();

        int m = matrix.length;
        int n = matrix[ 0 ].length;
        boolean[][] reachP = new boolean[ m ][ n ];
        boolean[][] reachA = new boolean[ m ][ n ];
        for ( int i = 0; i < n; i++ )
        {
            dfs( matrix, 0, i, reachP );
            dfs( matrix, m - 1, i, reachA );
        }
        for ( int i = 0; i < m; i++ )
        {
            dfs( matrix, i, 0, reachP );
            dfs( matrix, i, n - 1, reachA );
        }

        for ( int i = 0; i < m; i++ )
        {
            for ( int j = 0; j < n; j++ )
            {
                if ( reachA[ i ][ j ] && reachP[ i ][ j ] )
                {
                    List< Integer > list = new ArrayList<>();
                    list.add( i );
                    list.add( j );
                    results.add( list );
                }
            }
        }
        return results;
    }

    private static void dfs( int[][] matrix, int x, int y, boolean[][] reach )
    {
        reach[ x ][ y ] = true;

        if ( x - 1 >= 0 && !reach[ x - 1 ][ y ] && matrix[ x ][ y ] <= matrix[ x - 1 ][ y ] )
        {
            dfs( matrix, x - 1, y, reach );
        }
        if ( y - 1 >= 0 && !reach[ x ][ y - 1 ] && matrix[ x ][ y ] <= matrix[ x ][ y - 1 ] )
        {
            dfs( matrix, x, y - 1, reach );
        }
        if ( x + 1 < matrix.length && !reach[ x + 1 ][ y ] && matrix[ x ][ y ] <= matrix[ x + 1 ][ y ] )
        {
            dfs( matrix, x + 1, y, reach );
        }
        if ( y + 1 < matrix[ 0 ].length && !reach[ x ][ y + 1 ] && matrix[ x ][ y ] <= matrix[ x ][ y + 1 ] )
        {
            dfs( matrix, x, y + 1, reach );
        }
    }

    public static void main( String[] args )
    {
        int[][] matrix = new int[][] {
            { 1, 2, 2, 3, 5 },
            { 3, 2, 3, 4, 4 },
            { 2, 4, 5, 3, 1, },
            { 6, 7, 1, 4, 5 },
            { 5, 1, 1, 2, 4, }
        };
    }
}
