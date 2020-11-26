package com.algorithms.binary.search;

public class BinarySearchWithUpperMethod
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
        int mid = l + ( r - l ) / 2;
        if ( arr[ mid ] < target )
        {
            return binarySearch( arr, target, mid + 1, r );
        }
        return binarySearch( arr, target, l, mid );
    }

    public static void main( String[] args )
    {
        int arr[] = new int[] { 1, 1, 3, 3, 5, 5, 5, 7, 7 };
        BinarySearchWithUpperMethod lower = new BinarySearchWithUpperMethod();
        System.out.println( lower.binarySearch( arr, 5 ) );
    }
}
