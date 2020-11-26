package com.algorithms.sort.merge;

import java.util.Arrays;

import com.algorithms.sort.SortingHelper;

public class MergeSortOptimizedByMerge
{
    public void sort( int arr[] )
    {
        int temp[] = Arrays.copyOf( arr, arr.length );
        mergeSortImplement( arr, 0, arr.length - 1, temp );
    }

    public void mergeSortImplement( int arr[], int l, int r, int temp[] )
    {
        if ( l >= r ) return;

        int mid = l + ( r - l ) / 2;
        mergeSortImplement( arr, l, mid, temp );
        mergeSortImplement( arr, mid + 1, r, temp );
        if ( arr[ mid ] > arr[ mid + 1 ] ) merge( arr, l, mid, r, temp );
    }

    private void merge( int[] arr, int l, int mid, int r, int[] copyArr )
    {
        System.arraycopy( arr, l, copyArr, l, r - l + 1 );
        int i = l;
        int j = mid + 1;
        for ( int k = l; k <= r; k++ )
        {
            if ( i > mid )
            {
                arr[ k ] = copyArr[ j ];
                j++;
            }
            else if ( j > r )
            {
                arr[ k ] = copyArr[ i ];
                i++;
            }
            else if ( copyArr[ i ] <= copyArr[ j ] )
            {
                arr[ k ] = copyArr[ i ];
                i++;
            }
            else if ( copyArr[ i ] > copyArr[ j ] )
            {
                arr[ k ] = copyArr[ j ];
                j++;
            }
        }

    }

    public static void main( String[] args )
    {
        int[] arr = new int[] { 6, 5, 4, 3, 2, 1 };
        //        int[] arr = ArrayGeneration.generateRandomArrayWithInt( 10000, 10000 );
        MergeSortOptimizedByMerge sort = new MergeSortOptimizedByMerge();
        sort.sort( arr );
        SortingHelper.isSorted( arr );
    }
}
