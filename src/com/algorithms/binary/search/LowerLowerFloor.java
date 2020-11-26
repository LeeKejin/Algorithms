package com.algorithms.binary.search;

public class LowerLowerFloor
{
    /*
    if value exists in array, return the lowest index
     */
    public int findLowerLowerFloor( int[] arr, int target )
    {
        return findLowerLowerFloor( arr, target, -1, arr.length - 1 );
    }

    private int findLowerLowerFloor( int[] arr, int target, int l, int r )
    {
        if ( l > r ) return -1;
        if ( l == r )
        {
            if ( l + 1 < arr.length && arr[ l + 1 ] == target ) return l + 1;
            return l;
        }
        int mid = l + ( r - l + 1 ) / 2;
        if ( arr[ mid ] < target )
        {
            return findLowerLowerFloor( arr, target, mid, r );
        }
        return findLowerLowerFloor( arr, target, l, mid - 1 );
    }

    public static void main( String[] args )
    {
        int arr[] = new int[] { 1, 1, 3, 3, 5, 5, 5, 7, 7 };
        LowerLowerFloor lower = new LowerLowerFloor();
        System.out.println( lower.findLowerLowerFloor( arr, 1 ) );
    }
}
