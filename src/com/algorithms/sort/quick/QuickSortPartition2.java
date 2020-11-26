package com.algorithms.sort.quick;

import java.util.Random;

import com.algorithms.sort.SortingHelper;

public class QuickSortPartition2
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

    private int partition( Integer[] arr, int start, int end )
    {
        if ( start >= end ) return start;

        //        int p = start + random.nextInt( end - start );
        //        swap( arr, start, p );

        int pivot = arr[ start ];
        end--;
        start++;
        while ( true )
        {
            while ( start <= end && arr[ start ] < pivot )
            {
                start++;
            }

            while ( start <= end && arr[ end ] > pivot )
            {
                end--;
            }
            if ( start >= end ) break;

            swap( arr, start, end );
            start++;
            end--;
        }
        return start - 1;
    }

    private void swap( Integer[] arr, int j, int i )
    {
        int temp = arr[ i ];
        arr[ i ] = arr[ j ];
        arr[ j ] = temp;
    }

    public static void main( String[] args )
    {
        //        Integer[] arr = ArrayGeneration.generateRandomArray( 10000, 10000 );
        Integer[] arr = new Integer[] { 4, 6, 2, 3, 1, 5, 7, 8 };
        QuickSortPartition2 partition2 = new QuickSortPartition2();
        Integer[] res = partition2.quickSortImplement( arr, 0, arr.length );
        SortingHelper.isSorted( res );
    }
}
