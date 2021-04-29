package com.algorithms.sort;

public class SelectionSort
{
    public static void main( String[] args )
    {
        Integer[] arr = new Integer[] { 6, 4, 2, 3, 5, 1 };
        long startTime = System.nanoTime();
        //        sort( ArrayGeneration.generateRandomArray( 10000, 10000 ) );
        //        sort( arr );
        execute( arr );
        long endTime = System.nanoTime();
        double time = ( endTime - startTime ) / 1000000000.0;
        System.out.println( time );
    }

    public static < E extends Comparable< E > > void execute( E[] arr )
    {

        for ( int i = 0; i < arr.length; i++ )
        {
            int minIndex = i;

            for ( int j = i; j < arr.length; j++ )
            {
                if ( arr[ j ].compareTo( arr[ minIndex ] ) <= 0 )
                {
                    minIndex = j;
                }
            }
            E temp = arr[ i ];
            arr[ i ] = arr[ minIndex ];
            arr[ minIndex ] = temp;

        }

        System.out.println( "Sorted: " + SortingHelper.isSorted( arr ) );
    }

    public static < E extends Comparable< E > > void executeReverse( E[] arr )
    {

        for ( int i = arr.length - 1; i >= 0; i-- )
        {
            int minIndex = i;

            for ( int j = i; j >= 0; j-- )
            {
                if ( arr[ j ].compareTo( arr[ minIndex ] ) > 0 )
                {
                    minIndex = j;
                }
            }
            E temp = arr[ i ];
            arr[ i ] = arr[ minIndex ];
            arr[ minIndex ] = temp;
            minIndex = i;

        }

        System.out.println( "Sorted: " + SortingHelper.isSorted( arr ) );
    }

}
