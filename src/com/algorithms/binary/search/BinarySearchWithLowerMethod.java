package com.algorithms.binary.search;

public class BinarySearchWithLowerMethod
{
    public int binarySearch( int[] arr, int target )
    {
        return binarySearch( arr, target, 0, arr.length );
    }

    private int binarySearch( int[] arr, int target, int l, int r )
    {
        if ( l > r ) return -1;
        if ( l == r )
        {
            if ( arr[ l - 1 ] == target ) return l - 1;
            return -1;
        }
        int mid = l + ( r - l + 1 ) / 2;
        if ( arr[ mid ] <= target )
        {
            return binarySearch( arr, target, mid, r );
        }
        return binarySearch( arr, target, l, mid - 1 );
    }

    public static void main( String[] args )
    {
        int arr[] = new int[] { 1, 1, 3, 3, 5, 5, 5, 7, 7 };
        BinarySearchWithLowerMethod lower = new BinarySearchWithLowerMethod();
        System.out.println( lower.binarySearch( arr, 4 ) );
    }
}
