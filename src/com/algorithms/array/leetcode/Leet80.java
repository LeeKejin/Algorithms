package com.algorithms.array.leetcode;

public class Leet80
{
    public int removeDuplicates( int[] nums )
    {
        int index = 1;
        for ( int i = 2; i < nums.length; i++ )
        {
            if ( nums[ i ] != nums[ index - 2 + 1 ] )
            {
                index++;
                nums[ index ] = nums[ i ];
            }
        }
        return index + 1;
    }
}
