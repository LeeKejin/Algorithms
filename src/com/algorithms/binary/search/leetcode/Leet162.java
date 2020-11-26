package com.algorithms.binary.search.leetcode;

public class Leet162
{
    public int findPeakElement( int[] nums )
    {
        return findPeakElement( nums, 0, nums.length - 1 );
    }

    private int findPeakElement( int[] nums, int l, int r )
    {
        if ( l > r ) return nums[ nums.length - 1 ];
        if ( l == r ) return l;
        int mid = l + ( r - l ) / 2;
        if ( nums[ mid + 1 ] >= nums[ mid ] )
        {
            return findPeakElement( nums, mid + 1, r );

        }

        return findPeakElement( nums, l, mid );
    }

}
