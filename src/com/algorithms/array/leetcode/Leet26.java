package com.algorithms.array.leetcode;

public class Leet26
{
    public int removeDuplicates( int[] nums )
    {
        int cur = 0;

        for ( int i = 1; i < nums.length; i++ )
        {
            if ( nums[ cur ] != nums[ i ] && nums[ cur ] < nums[ i ] )
            {
                cur++;
                nums[ cur ] = nums[ i ];

            }
        }
        return cur + 1;
    }
}
