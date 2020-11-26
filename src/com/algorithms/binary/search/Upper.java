package com.algorithms.binary.search;

public class Upper
{
    public int findUpperValue( int arr[], int target )
    {
        int r = arr.length;
        int l = 0;
        return findUpperValue( arr, target, l, r );
    }

    private int findUpperValue( int[] arr, int target, int l, int r )
    {
        if ( l > r ) return -1;
        if ( l == r ) return l;
        int mid = l + ( r - l ) / 2;
        if ( arr[ mid ] <= target )
        {
            return findUpperValue( arr, target, mid + 1, r );
        }
        return findUpperValue( arr, target, l, mid );
    }

    public static void main( String[] args )
    {
        Upper upper = new Upper();
        int arr[] = new int[] { 1, 1, 3, 3, 5, 5, 5, 7, 7 };
        System.out.println( upper.findUpperValue( arr, 5 ) );
    }
}
