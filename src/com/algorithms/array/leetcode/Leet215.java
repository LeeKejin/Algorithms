package com.algorithms.array.leetcode;

import java.util.PriorityQueue;

public class Leet215
{
    public static int findKthLargest( int[] nums, int k )
    {
        PriorityQueue< Integer > q = new PriorityQueue< Integer >( k );
        for ( int i : nums )
        {
            q.add( i );

            if ( q.size() > k )
            {
                int j = q.poll();
            }
        }

        return q.peek();
    }

    public static int findKthLargestPivotMethod( int[] nums, int k )
    {
        if ( k < 1 || nums == null )
        {
            return 0;
        }

        return getKth( nums.length - k + 1, nums, 0, nums.length - 1 );
    }

    public static int getKth( int k, int[] nums, int start, int end )
    {
        int left = start;
        int right = end;
        int pivot = nums[ end ];
        while ( true )
        {
            if ( nums[ left ] < pivot && left < right )
            {
                left++;
            }
            if ( nums[ right ] >= pivot && left < right )
            {
                right--;
            }
            if ( right == left )
            {
                break;
            }
            swap( nums, left, right );
        }
        swap( nums, left, end );
        if ( left + 1 == k )
        {
            return pivot;
        }
        else if ( k < left + 1 )
        {
            return getKth( k, nums, start, left - 1 );
        }
        else
        {
            return getKth( k, nums, left + 1, end );
        }

    }

    public static void swap( int[] nums, int n1, int n2 )
    {
        int tmp = nums[ n1 ];
        nums[ n1 ] = nums[ n2 ];
        nums[ n2 ] = tmp;
    }

    public static void main( String[] args )
    {
        int[] test = new int[] { 3, 2, 1, 5, 6, 4 };
        int r = findKthLargestPivotMethod( test, 2 );
        System.out.println( r + "" );
    }
}
