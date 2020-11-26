package com.algorithms.binary.search.leetcode;

public class Leet69
{
    public int mySqrt( int x )
    {
        return ( int ) mySqrt( 0, x / 2 + 1, x );
    }

    private long mySqrt( long l, long r, long target )
    {
        if ( l >= r ) return l;
        long mid = l + ( r - l + 1 ) / 2;
        long value = mid * mid;
        if ( value <= target )
        {
            return mySqrt( mid, r, target );
        }

        return mySqrt( l, mid - 1, target );

    }
}
