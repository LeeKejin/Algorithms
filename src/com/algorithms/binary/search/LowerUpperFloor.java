package com.algorithms.binary.search;

public class LowerUpperFloor
{
    /*
   if value exists in array, return the highest index
    */
    public int findLowerUpperFloor( int[] arr, int target )
    {
        return findLowerUpperFloor( arr, target, 0, arr.length - 1 );
    }

    private int findLowerUpperFloor( int[] arr, int target, int l, int r )
    {
        if ( l > r ) return -1;
        if ( l == r ) return l;
        int mid = l + ( r - l + 1 ) / 2;
        if ( arr[ mid ] <= target )
        {
            return findLowerUpperFloor( arr, target, mid, r );
        }
        return findLowerUpperFloor( arr, target, l, mid - 1 );
    }

    public static void main( String[] args )
    {
        int arr[] = new int[] { 1, 1, 3, 3, 5, 5, 5, 7, 7 };
        LowerUpperFloor lower = new LowerUpperFloor();
        System.out.println( lower.findLowerUpperFloor( arr, 3 ) );
    }
}
