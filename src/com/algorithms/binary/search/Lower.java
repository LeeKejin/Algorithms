package com.algorithms.binary.search;

public class Lower
{
    public int findLowerValue( int[] arr, int target )
    {
        return findLowerValue( arr, target, -1, arr.length - 1 );
    }

    private int findLowerValue( int[] arr, int target, int l, int r )
    {
        if ( l > r ) return -1;
        if ( l == r ) return l;
        int mid = l + ( r - l + 1 ) / 2;
        if ( arr[ mid ] < target )
        {
            return findLowerValue( arr, target, mid, r );
        }

        return findLowerValue( arr, target, l, mid - 1 );
    }

    public static void main( String[] args )
    {
        int arr[] = new int[] { 1, 1, 3, 3, 5, 5, 5, 7, 7 };
        Lower lower = new Lower();
        System.out.println( lower.findLowerValue( arr, 5 ) );
    }
}
