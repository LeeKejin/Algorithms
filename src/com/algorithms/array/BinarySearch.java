package com.algorithms.array;

public class BinarySearch
{
    public static int binarySearch( Comparable[] arr, int n, Comparable target )
    {
        int l = 0;
        int r = n - 1; //search target within [r, l]
        while ( l <= r ) //what if only one element in the array, the = cannot be ignored
        {
            int mid = l + ( r - l ) / 2;
            if ( arr[ mid ].compareTo( target ) == 0 ) return mid;
            if ( arr[ mid ].compareTo( target ) < 0 )
            {
                l = mid + 1; // arr[mid] is NOT target, so do mid+1!
            }
            else
            {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearch1( Comparable[] arr, int n, Comparable target )
    {
        int l = 0;
        int r = n; //search target within [r, l)
        while ( l < r ) //[42,42) is illegal, it needs to be [42,43)
        {
            int mid = l + ( r - l ) / 2;
            if ( arr[ mid ].compareTo( target ) == 0 ) return mid;
            if ( arr[ mid ].compareTo( target ) < 0 )
            {
                l = mid + 1; // arr[mid] is NOT target, so do mid+1! The searching range is [l
            }
            else
            {
                r = mid; // arr[mid] is NOT target, searching range is r)
            }
        }
        return -1;
    }

    public static void main( String[] args )
    {
        Integer data[] = Util.generateOrderedArray( 10 );
        Integer[] arr = new Integer[] { 11, 21, 31, 41, 52, 62, 72, 82, 92 };
        System.out.println( "Cannot find " + binarySearch1( arr, 6, 72 ) );
    }
}
