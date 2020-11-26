package com.algorithms.sort.quick.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Leet215QuickestSolution
{
    static Random random = new Random();

    public int findKthLargest( int[] nums, int k )
    {
        return quickSort( nums, k, 0, nums.length );
    }

    private int quickSort( int[] nums, int k, int l, int r )
    {
        if ( l >= r ) return nums[ k ];
        List< Integer > list = partition( nums, l, r );
        int p = list.get( 0 );
        swap( nums, p, l );
        if ( p == ( nums.length - k ) ) return nums[ p ];
        if ( p < ( nums.length - k ) )
        {
            return quickSort( nums, k, list.get( 1 ), r );
        }
        else
        {
            return quickSort( nums, k, l, p );
        }

    }

    private List< Integer > partition( int[] nums, int l, int r )
    {
        List< Integer > list = new ArrayList<>();
        int start = l;
        int end = r;
        int p = l + random.nextInt( r - l );
        swap( nums, start, p );
        int pivot = nums[ start ];

        start++;
        end--;

        int i = start;
        while ( i <= end )
        {
            if ( pivot == nums[ i ] )
            {
                i++;
            }
            else if ( pivot < nums[ i ] )
            {
                swap( nums, i, end );
                end--;
            }
            else
            {
                swap( nums, i, start );
                start++;
                i++;
            }
        }
        list.add( start - 1 );
        list.add( end );
        return list;
    }

    private void swap( int[] arr, int j, int i )
    {
        int temp = arr[ i ];
        arr[ i ] = arr[ j ];
        arr[ j ] = temp;
    }

}
