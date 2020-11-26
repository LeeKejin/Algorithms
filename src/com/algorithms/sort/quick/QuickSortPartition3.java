package com.algorithms.sort.quick;

import java.util.Random;

import com.algorithms.sort.SortingHelper;

public class QuickSortPartition3
{
    static Random random = new Random();

    //    public Integer[] quickSortImplement( Integer[] arr, int l, int r )
    //    {
    //        if ( l >= r ) return arr;
    //        int pivot = partition( arr, l, r );
    //        swap( arr, l, pivot );
    //        quickSortImplement( arr, l, pivot );
    //        quickSortImplement( arr, pivot + 1, r );
    //        return arr;
    //    }

    public void quickSortImplement( Integer[] arr, int start, int end )
    {
        if ( start >= end ) return;
        int l = start;
        int r = end;
        int p = start + random.nextInt( end - start );
        swap( arr, start, p );
        int pivot = arr[ start ];
        start++;
        end--;
        int i = start;
        while ( i <= end )
        {
            if ( pivot == arr[ i ] )
            {
                i++;
            }
            else if ( pivot > arr[ i ] )
            {
                swap( arr, start, i );
                start++;
                i++;
            }
            else
            {
                swap( arr, end, i );
                end--;
            }
        }
        swap( arr, l, start - 1 );
        quickSortImplement( arr, l, start - 1 );
        quickSortImplement( arr, end + 1, r );
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
        Integer[] arr = new Integer[] { 7, 6, 5, 4, 3, 2, 1 };
        QuickSortPartition3 partition3 = new QuickSortPartition3();
        partition3.quickSortImplement( arr, 0, 7 );
        SortingHelper.isSorted( arr );
    }
}
