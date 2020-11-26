package com.algorithms.binary.search.leetcode;

public class Leet33
{
    public int search( int[] nums, int target )
    {
        return search( nums, target, 0, nums.length - 1 );

    }

    private int search( int[] nums, int target, int l, int r )
    {
        if ( l > r ) return -1;
        int mid = l + ( r - l ) / 2;
        if ( nums[ mid ] == target ) return mid;
        if ( nums[ mid ] >= nums[ l ] )
        {
            if ( target == nums[ l ] ) return l;
            if ( target > nums[ l ] && target < nums[ mid ] )
            {
                return search( nums, target, l + 1, mid - 1 );
            }
            if ( target < nums[ l ] || target > nums[ mid ] )
            {
                return search( nums, target, mid + 1, r );
            }
        }

        if ( target == nums[ r ] ) return r;
        if ( target > nums[ mid ] && target < nums[ r ] )
        {
            return search( nums, target, mid + 1, r - 1 );
        }

        return search( nums, target, l, mid - 1 );

    }

    public static void main( String[] args )
    {
        int[] arr = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        //        int[] arr = ArrayGeneration.generateRandomArrayWithInt( 10000, 10000 );
        Leet33 sort = new Leet33();
        System.out.println( sort.search( arr, 2 ) );
        //        SortingHelper.isSorted( arr );
    }
}
