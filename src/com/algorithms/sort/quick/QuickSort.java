package com.algorithms.sort.quick;

import java.util.Random;

import com.algorithms.sort.ArrayGeneration;
import com.algorithms.sort.SortingHelper;

public class QuickSort
{
    static Random random = new Random();

    int[] sort( int[] arr )
    {
        quickSort( arr, 0, arr.length - 1 );
        return arr;
    }

    private void quickSort( int[] arr, int l, int r )
    {
        if ( l > r ) return;
        int pivot = partition( arr, l, r );
        swap( arr, l, pivot );
        quickSort( arr, l, pivot - 1 );
        quickSort( arr, pivot + 1, r );
    }

    private int partition( int[] arr, int l, int r )
    {

        int pivot = arr[ l ];
        int j = l + 1;
        for ( int i = l + 1; i <= r; i++ )
        {
            if ( arr[ i ] < pivot )
            {
                swap( arr, i, j );
                j++;
            }
        }
        return j - 1;
    }

    private void swap( int[] arr, int j, int i )
    {
        int temp = arr[ i ];
        arr[ i ] = arr[ j ];
        arr[ j ] = temp;
    }

    public static void main( String[] args )
    {
        long startTime = System.nanoTime();

        QuickSort quickSort = new QuickSort();
        //        Integer[] arr = ArrayGeneration.generateRandomArray( 10000, 1 );
        Integer[] arr = new Integer[] { 7, 6, 5, 4, 3, 2, 1 };
        QuickSort quickSort1 = new QuickSort();

        int[] res = quickSort1.sort( ArrayGeneration.generateRandomArrayWithInt( 10000, 10000 ) );

        SortingHelper.isSorted( res );
        long endTime = System.nanoTime();
        double time = ( endTime - startTime ) / 1000000000.0;
        System.out.println( time );

    }
}
