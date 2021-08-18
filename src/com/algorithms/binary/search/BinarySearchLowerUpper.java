package com.algorithms.binary.search;

public class BinarySearchLowerUpper
{
    static int res = -1;

    public static int searchFloorOfANumber( int[] arr, int key )
    {
        if ( arr[ 0 ] > key ) return -1;
        binarySearch( 0, arr.length - 1, arr, key );
        return res;
    }

    private static void binarySearch( int l, int r, int[] arr, int key )
    {
        if ( l >= r )
        {
            res = l;
            return;
        }
        int mid = l + ( r - l + 1 ) / 2;
        if ( arr[ mid ] == key )
        {
            res = mid;
            return;
        }
        if ( arr[ mid ] > key )
        {
            binarySearch( l, mid - 1, arr, key );
        }
        else
        {
            binarySearch( mid, r, arr, key );
        }
    }

    public static int searchCeilingOfANumber( int[] arr, int key )
    {
        search( 0, arr.length - 1, key, arr );
        return arr[ res ] >= key ? res : -1;
    }

    private static void search( int l, int r, int key, int[] arr )
    {
        if ( l >= r )
        {
            res = r;
            return;
        }
        int mid = l + ( r - l ) / 2;
        if ( arr[ mid ] == key )
        {
            res = mid;
            return;
        }
        if ( arr[ mid ] < key )
        {
            search( mid + 1, r, key, arr );
        }
        else
        {
            search( l, mid, key, arr );
        }
    }
}
