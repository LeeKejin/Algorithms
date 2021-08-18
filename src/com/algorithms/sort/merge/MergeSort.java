package com.algorithms.sort.merge;

import java.util.Arrays;

import com.algorithms.sort.SortingHelper;

public class MergeSort
{
    public void mergeSortImplement( int arr[], int l, int r )
    {
        if ( l >= r ) return;

        int mid = l + ( r - l ) / 2;
        mergeSortImplement( arr, l, mid );
        mergeSortImplement( arr, mid + 1, r );
        if ( arr[ mid ] > arr[ mid + 1 ] ) merge( arr, l, mid, r );
    }

    private void merge( int[] arr, int l, int mid, int r )
    {
        int[] copyArr = Arrays.copyOfRange( arr, l, r + 1 );
        int i = l;
        int j = mid + 1;
        for ( int k = l; k <= r; k++ )
        {
            if ( i > mid )
            {
                arr[ k ] = copyArr[ j - l ];
                j++;
            }
            else if ( j > r )
            {
                arr[ k ] = copyArr[ i - l ];
                i++;
            }
            else if ( copyArr[ i - l ] >= copyArr[ j - l ] )
            {
                arr[ k ] = copyArr[ j - l ];
                j++;
            }
            else if ( copyArr[ i - l ] < copyArr[ j - l ] )
            {
                arr[ k ] = copyArr[ i - l ];
                i++;
            }
        }

    }

    public static void main( String[] args )
    {
        int[] arr = new int[] { 3, 2, 4 };
        //        int[] arr = ArrayGeneration.generateRandomArrayWithInt( 10000, 10000 );
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSortImplement( arr, 0, arr.length - 1 );
        SortingHelper.isSorted( arr );
    }
}
