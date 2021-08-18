package com.algorithms.sword.means.offer;

import java.util.Arrays;

public class Test
{

    public static void main( String[] args )
    {
        Test test = new Test();
        int[] res = test.smallestK( new int[] { 1, 3, 5, 7, 2, 4, 6, 8 }, 4 );
        for ( int i : res )
        {
            System.out.println( i );
        }

    }

    public int[] smallestK( int[] arr, int k )
    {
        return quickSort( arr, 0, arr.length - 1, k );
    }

    private int[] quickSort( int[] arr, int start, int end, int k )
    {
        int left = start;
        int right = end;
        int pivot = arr[ start ];
        while ( left < right )
        {
            while ( left < right && arr[ right ] >= pivot )
            {
                right--;
            }
            while ( left < right && arr[ left ] <= pivot )
            {
                left++;
            }

            if ( left != right )
            {
                int temp = arr[ left ];
                arr[ left ] = arr[ right ];
                arr[ right ] = temp;
            }
        }
        int temp = arr[ start ];
        arr[ start ] = arr[ left ];
        arr[ left ] = temp;
        if ( left > k ) return quickSort( arr, start, left - 1, k );
        if ( left < k ) return quickSort( arr, left + 1, end, k );
        return Arrays.copyOf( arr, k );
    }

    private void quickSort( int[] arr, int[] res, int k, int left, int right )
    {
        //快排的实现方式有多种，我们选择了其中的一种
        int start = left;
        int end = right;
        while ( left < right )
        {
            while ( left < right && arr[ right ] >= arr[ start ] )
            {
                right--;
            }
            while ( left < right && arr[ left ] <= arr[ start ] )
            {
                left++;
            }
            if ( left != right )
            {
                int temp = arr[ left ];
                arr[ left ] = arr[ right ];
                arr[ right ] = temp;
            }
        }
        int temp = arr[ start ];
        arr[ start ] = arr[ left ];
        arr[ left ] = temp;
        if ( left > k )
        {
            quickSort( arr, res, k, start, left - 1 );
        }
        else if ( left < k )
        {
            quickSort( arr, res, k, left + 1, end );
        }
        else
        {
            //取前面的k个即可
            for ( int m = 0; m < k; ++m )
            {
                res[ m ] = arr[ m ];
            }
        }
    }

}