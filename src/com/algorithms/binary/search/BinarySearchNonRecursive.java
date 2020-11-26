package com.algorithms.binary.search;

public class BinarySearchNonRecursive
{
    public int search( int[] arr, int target )
    {
        int l = 0;
        int r = arr.length - 1;
        while ( l <= r )
        {
            int mid = l + ( r - l ) / 2;
            if ( arr[ mid ] == target ) return mid;
            else if ( arr[ mid ] > target )
            {
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static void main( String[] args )
    {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        BinarySearchNonRecursive binarySearch = new BinarySearchNonRecursive();
        System.out.println( binarySearch.search( nums, 7 ) );
    }
}
