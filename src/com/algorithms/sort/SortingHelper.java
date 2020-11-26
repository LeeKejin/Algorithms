package com.algorithms.sort;

public class SortingHelper
{
    public static < E extends Comparable< E > > boolean isSorted( E[] arr )
    {
        for ( int i = 1; i < arr.length; i++ )
        {
            if ( arr[ i - 1 ].compareTo( arr[ i ] ) > 0 )
            {
                throw new RuntimeException( "Error!!!!!" );
            }
        }
        return true;
    }

    public static < E extends Comparable< E > > void sortTest( Sort sort, E[] arr )
    {
        long startTime = System.nanoTime();
        sort.execute( arr );
        long endTime = System.nanoTime();
        double time = ( endTime - startTime ) / 1000000000.0;
        System.out.println( time );
    }

    public static boolean isSorted( int[] arr )
    {
        for ( int i = 1; i < arr.length; i++ )
        {
            if ( arr[ i - 1 ] > arr[ i ] )
            {
                throw new RuntimeException( "Error!!!!!" );
            }
        }
        return true;
    }
}
