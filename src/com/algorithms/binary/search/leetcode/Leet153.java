package com.algorithms.binary.search.leetcode;

public class Leet153
{
    public int findMinInitial( int[] nums )
    {
        if ( nums.length == 1 ) return nums[ 0 ];
        return findMinInitial( nums, 0, nums.length - 1 );
    }

    private int findMinInitial( int[] nums, int l, int r )
    {
        if ( l > r )
        {
            return nums[ 0 ];
        }
        if ( l == r ) return nums[ l ];
        int mid = l + ( r - l ) / 2;
        if ( nums[ mid ] < nums[ mid + 1 ] && nums[ mid ] < nums[ nums.length - 1 ] )
        {
            return findMin( nums, l, mid );
        }
        return findMin( nums, mid + 1, r );
    }

    /////////////////////////////////////////////
    public int findMin( int[] nums )
    {
        if ( nums.length == 1 ) return nums[ 0 ];
        return findMin( nums, 0, nums.length - 1 );
    }

    private int findMin( int[] nums, int l, int r )
    {
        if ( l > r )
        {
            return nums[ 0 ];
        }
        if ( l == r ) return nums[ l ];
        int mid = l + ( r - l ) / 2;
        if ( nums[ mid ] < nums[ r ] )
        {
            return findMin( nums, l, mid );
        }
        return findMin( nums, mid + 1, r );
    }
}
