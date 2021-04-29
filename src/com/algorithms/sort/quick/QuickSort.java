package com.algorithms.sort.quick;

import java.util.Random;

import com.algorithms.sort.ArrayGeneration;
import com.algorithms.sort.SortingHelper;

public class QuickSort
{
    static Random random = new Random();

    public Integer[] quickSortImplement( Integer[] arr, int l, int r )
    {
        if ( l >= r ) return arr;
        int pivot = partition( arr, l, r );
        swap( arr, l, pivot );
        quickSortImplement( arr, l, pivot );
        quickSortImplement( arr, pivot + 1, r );
        return arr;
    }

    public int partition( Integer[] arr, int start, int end )
    {
        if ( start >= end ) return start;

        //        int pivot = arr[ start ];
        //Random generate p
        int p = start + random.nextInt( end - start );
        swap( arr, start, p );

        int pivot = arr[ start ];

        int j = start + 1;
        for ( int i = start + 1; i <= end; i++ )
        {
            if ( arr[ i ] < pivot )
            {
                swap( arr, j, i );
                j++;
            }
        }
        return j - 1;
    }

    private void swap( Integer[] arr, int j, int i )
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
        Integer[] res =
            quickSort.quickSortImplement( ArrayGeneration.generateRandomArray( 10000, 10000 ), 0, 10000 - 1 );

        SortingHelper.isSorted( res );
        long endTime = System.nanoTime();
        double time = ( endTime - startTime ) / 1000000000.0;
        System.out.println( time );

    }
}
