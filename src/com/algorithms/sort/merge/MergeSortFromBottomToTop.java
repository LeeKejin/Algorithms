package com.algorithms.sort.merge;

import java.util.Arrays;

import com.algorithms.sort.SortingHelper;

public class MergeSortFromBottomToTop
{
    public void sort( int arr[] )
    {
        int temp[] = Arrays.copyOf( arr, arr.length );
        int n = arr.length;
        for ( int sz = 1; sz < n; sz += sz )
        {
            for ( int i = 0; i + sz < n; i += sz + sz )
            {
                if ( arr[ i + sz - 1 ] > arr[ i + sz ] )
                {
                    merge( arr, i, i + sz - 1, Math.min( i + sz + sz - 1, n - 1 ), temp );
                }
            }
        }
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
            else if ( copyArr[ i ] < copyArr[ j ] )
            {
                arr[ k ] = copyArr[ i ];
                i++;
            }
            else
            {
                arr[ k ] = copyArr[ j ];
                j++;
            }
        }
    }

    public static void main( String[] args )
    {
        int[] arr = new int[] { 6, 4, 2, 3, 5, 1 };
        //        int[] arr = ArrayGeneration.generateRandomArrayWithInt( 10000, 10000 );
        MergeSortFromBottomToTop sort = new MergeSortFromBottomToTop();
        sort.sort( arr );
        SortingHelper.isSorted( arr );
    }
}
