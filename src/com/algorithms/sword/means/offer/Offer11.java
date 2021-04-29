package com.algorithms.sword.means.offer;

public class Offer11
{
    public int minArray( int[] numbers )
    {
        if ( numbers.length == 1 ) return numbers[ 0 ];
        for ( int i = 1; i < numbers.length; i++ )
        {
            if ( numbers[ i - 1 ] > numbers[ i ] ) return numbers[ i ];
        }
        return numbers[ 0 ];
    }

    public int minArray1( int[] numbers )
    {
        if ( numbers.length == 1 ) return numbers[ 0 ];
        int l = 0;
        int r = numbers.length - 1;
        while ( l < r )
        {
            int mid = l + ( r - l ) / 2;
            if ( numbers[ mid ] > numbers[ r ] )
            {
                l = mid + 1;
            }
            else if ( numbers[ mid ] < numbers[ r ] )
            {
                r = mid;
            }
            else
            {
                r--;
            }
        }
        return numbers[ l ];
    }
}
