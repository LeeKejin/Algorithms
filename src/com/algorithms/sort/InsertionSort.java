package com.algorithms.sort;

public class InsertionSort implements Sort
{
    @Override
    public < E extends Comparable< E > > void execute( E[] arr )
    {
        for ( int i = 0; i < arr.length; i++ )
        {
            for ( int j = 0; j < i; j++ )
            {
                if ( arr[ j ].compareTo( arr[ i ] ) > 0 )
                {
                    swap( arr, i, j );
                }
            }
        }
        SortingHelper.isSorted( arr );
        //        for ( E i : arr )
        //        {
        //            System.out.println( i );
        //        }
    }

    public < E extends Comparable< E > > void executeWithoutSwapReverse( E[] arr )
    {
        for ( int i = arr.length - 1; i >= 0; i-- )
        {
            E temp = arr[ i ];
            int j;
            for ( j = arr.length - 1; j - 1 >= i; j-- )
            {
                if ( arr[ j ].compareTo( temp ) < 0 )
                {
                    arr[ j - 1 ] = arr[ j ];
                }
            }
            arr[ j ] = temp;
        }
    }

    public < E extends Comparable< E > > void executeWithoutSwap( E[] arr )
    {
        for ( int i = 0; i < arr.length; i++ )
        {
            E temp = arr[ i ];
            for ( int j = i; j - 1 >= 0; j-- )
            {
                if ( arr[ j - 1 ].compareTo( arr[ j ] ) > 0 )
                {
                    arr[ j ] = arr[ j - 1 ];
                    arr[ j - 1 ] = temp;
                }

            }
        }
        SortingHelper.isSorted( arr );
    }

    public < E extends Comparable< E > > void executeWithoutSwap2( E[] arr )
    {
        for ( int i = 0; i < arr.length; i++ )
        {
            E temp = arr[ i ];
            int j;
            for ( j = i; j - 1 >= 0; j-- )
            {
                if ( arr[ j - 1 ].compareTo( temp ) > 0 )
                {
                    arr[ j ] = arr[ j - 1 ];
                }
                else
                {
                    break;
                }
            }
            arr[ j ] = temp;
        }
        SortingHelper.isSorted( arr );
    }

    private < E extends Comparable< E > > void swap( E[] arr, int i, int j )
    {
        E temp = arr[ i ];
        arr[ i ] = arr[ j ];
        arr[ j ] = temp;
    }

    public static void main( String[] args )
    {
        Integer[] arr = new Integer[] { 6, 4, 2, 3, 5, 1 };

        InsertionSort sort = new InsertionSort();
        sort.executeWithoutSwap2( arr );
        //        sort.executeWithoutSwapReverse( ArrayGeneration.generateRandomArray( 10000, 10000 ) );
    }
}
