package com.algorithms.sword.means.offer;

import java.util.Arrays;

import com.algorithms.sort.SortingHelper;

public class Leet51
{
    int count = 0;

    public int reversePairs( int[] nums )
    {
        int temp[] = Arrays.copyOf( nums, nums.length );
        mergeSort( nums, 0, nums.length - 1, temp );
        return count;
    }

    public void mergeSort( int[] nums, int l, int r, int[] temp )
    {
        if ( l >= r ) return;
        int mid = l + ( r - l ) / 2;
        mergeSort( nums, l, mid, temp );
        mergeSort( nums, mid + 1, r, temp );
        if ( nums[ mid ] > nums[ mid + 1 ] ) merge( nums, l, mid, r, temp );
    }

    private void merge( int[] nums, int l, int mid, int r, int[] temp )
    {
        System.arraycopy( nums, l, temp, l, r - l + 1 );
        int i = l;
        int j = mid + 1;
        for ( int k = l; k <= r; k++ )
        {
            if ( i > mid )
            {
                nums[ k ] = temp[ j ];
                j++;
            }
            else if ( j > r )
            {
                nums[ k ] = temp[ i ];
                i++;
            }
            else if ( temp[ i ] > temp[ j ] )
            {
                nums[ k ] = temp[ j ];
                j++;
                count += mid - i + 1;
            }
            else
            {
                nums[ k ] = temp[ i ];
                i++;
            }
        }
    }

    public static void main( String[] args )
    {
        int[] arr = new int[] { 7, 5, 6, 4 };
        //        int[] arr = ArrayGeneration.generateRandomArrayWithInt( 10000, 10000 );
        Leet51 sort = new Leet51();
        sort.reversePairs( arr );
        SortingHelper.isSorted( arr );
    }
}
