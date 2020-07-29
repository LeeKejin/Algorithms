package com.algorithms.dynamicprogramming;

import java.util.List;

public class Leet120
{

    public int minimumTotalRec( List< List< Integer > > triangle )
    {
        return calculate( triangle, 0, 0 );
    }

    private int calculate( List< List< Integer > > triangle, int row, int column )
    {
        if ( row == triangle.size() ) return 0;
        return triangle.get( row ).get( column ) +
            Math.min( calculate( triangle, row + 1, column ), calculate( triangle, row + 1, column + 1 ) );
    }

    //have to calculate from bottom to top!
    public static int minimumTotal( int[][] triangle )
    {
        int n = triangle.length;
        int dp[][] = new int[ n + 1 ][ n + 1 ];
        for ( int i = n - 1; i >= 0; i-- )
        {
            for ( int j = 0; j <= i; j++ )
            {
                dp[ i ][ j ] = Math.min( dp[ i + 1 ][ j ], dp[ i + 1 ][ j + 1 ] ) + triangle[ i ][ j ];
            }
        }
        return dp[ 0 ][ 0 ];
    }

    //optimize space
    public static int minimumTotalOptimize( int[][] triangle )
    {
        int n = triangle.length;
        int dp[] = new int[ n + 1 ];
        for ( int i = n - 1; i >= 0; i-- )
        {
            for ( int j = 0; j <= i; j++ )
            {
                dp[ j ] = Math.min( dp[ j ], dp[ j + 1 ] ) + triangle[ i ][ j ];
            }
        }
        return dp[ 0 ];
    }

    public static void main( String[] args )
    {
        int grid[][] = new int[][] { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
        System.out.print( minimumTotal( grid ) );
    }
}
