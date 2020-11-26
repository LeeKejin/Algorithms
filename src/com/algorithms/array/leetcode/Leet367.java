package com.algorithms.array.leetcode;

public class Leet367
{
    public boolean isPerfectSquare( int num )
    {
        long index = findSquare( 1, num, num );
        if ( index == -1 || index * index != num ) return false;
        return true;
    }

    private long findSquare( long l, long r, long num )
    {
        if ( l >= r ) return l;
        long mid = l + ( r - l ) / 2;
        long val = mid * mid;
        if ( val == num ) return mid;
        if ( val < num )
        {
            return findSquare( mid + 1, r, num );
        }
        return findSquare( l, mid - 1, num );
    }

}
