package com.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
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
    public int minimumTotal( List< List< Integer > > triangle )
    {
        List< Integer > results = new ArrayList<>();
        int size = triangle.size() - 1;
        results.addAll( triangle.get( size ) );
        for ( int i = size - 1; i >= 0; i-- )
        {
            for ( int j = 0; j < triangle.get( i ).size(); j++ )
            {
                int val = Math.min( results.get( j ), results.get( j + 1 ) ) + triangle.get( i ).get( j );
                results.set( j, val );
            }
        }
        return results.get( 0 );
    }

    public int minimumTotalTopToBottom( List< List< Integer > > triangle )
    {
        List< List< Integer > > triangleResults = new ArrayList<>();
        for ( List< Integer > list : triangle )
        {
            List< Integer > result = new ArrayList<>();
            for ( int v : list )
            {
                result.add( Integer.MAX_VALUE );
            }
            triangleResults.add( result );
        }
        int initialVal = triangle.get( 0 ).get( 0 );
        triangleResults.get( 0 ).set( 0, initialVal );
        for ( int i = 1; i < triangle.size(); i++ )
        {
            List< Integer > previousValues = triangleResults.get( i - 1 );
            List< Integer > values = triangle.get( i );
            List< Integer > results = triangleResults.get( i );
            for ( int j = 0; j < previousValues.size(); j++ )
            {
                results.set( j, Math.min( values.get( j ) + previousValues.get( j ), results.get( j ) ) );
                results.set( j + 1, Math.min( values.get( j + 1 ) + previousValues.get( j ), results.get( j + 1 ) ) );
            }
        }
        int last = triangleResults.size() - 1;
        return Collections.min( triangleResults.get( last ) );

    }

    public static void main( String[] args )
    {
        int grid[][] = new int[][] { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
        System.out.print( minimumTotal( grid ) );
    }
}
