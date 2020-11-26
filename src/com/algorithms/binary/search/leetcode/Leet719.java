package com.algorithms.binary.search.leetcode;

import java.util.Arrays;

public class Leet719
{
    public int smallestDistancePair( int[] nums, int k )
    {
        if ( nums.length == 0 ) return 0;
        Arrays.sort( nums );
        int max = nums[ nums.length - 1 ] - nums[ 0 ];
        int min = 0;
        return smallestDistancePair( nums, min, max, k );
    }

    private int smallestDistancePair( int[] nums, int min, int max, int k )
    {
        if ( min >= max ) return min;
        int mid = min + ( max - min ) / 2;
        int left = 0;
        int count = 0;
        for ( int right = 0; right < nums.length; right++ )
        {
            while ( nums[ right ] - nums[ left ] > mid )
            {
                left++;
            }
            count += right - left;
        }
        if ( count >= k ) return smallestDistancePair( nums, min, mid, k );
        return smallestDistancePair( nums, mid + 1, max, k );
    }
}
