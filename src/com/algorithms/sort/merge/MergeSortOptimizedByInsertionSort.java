package com.algorithms.sort.merge;

import java.util.Arrays;

import com.algorithms.sort.ArrayGeneration;
import com.algorithms.sort.SortingHelper;

public class MergeSortOptimizedByInsertionSort
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
        if ( r - l < 15 )
        {
            insertionSort( arr, l, r );
            return;
        }
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
            else if ( copyArr[ i - l ] <= copyArr[ j - l ] )
            {
                arr[ k ] = copyArr[ i - l ];
                i++;
            }
            else if ( copyArr[ i - l ] > copyArr[ j - l ] )
            {
                arr[ k ] = copyArr[ j - l ];
                j++;
            }
        }

    }

    private void insertionSort( int[] arr, int l, int r )
    {
        for ( int i = l; i <= r; i++ )
        {
            int temp = arr[ i ];
            int j = i;
            for ( ; j - 1 >= l; j-- )
            {
                if ( arr[ j - 1 ] > temp )
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
    }

    public static void main( String[] args )
    {
        int[] arr = ArrayGeneration.generateRandomArrayWithInt( 10000, 10000 );

        MergeSortOptimizedByInsertionSort sort = new MergeSortOptimizedByInsertionSort();
        sort.mergeSortImplement( arr, 0, 10000 - 1 );
        SortingHelper.isSorted( arr );
    }
}
