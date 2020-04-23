package com.algorithms.array;

public class BinarySearch
{
    public  static int binarySearch(Comparable[] arr, int n, Comparable target)
    {
        int l = 0;
        int r = n - 1;
        while ( l <= r )
        {
            int mid = l + ( r - l ) / 2;
            if ( arr[ mid ].compareTo( target ) == 0 ) return mid;
            if ( arr[ mid ].compareTo( target ) < 0 )
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int n = (int)Math.pow( 10,7 );
        Integer data[] =Util.generateOrderedArray(10);

//        for(int i = 0;i< n;i++){

                 System.out.println( "Cannot find "+binarySearch(data, 10, 1000) );

//        }
    }
}
