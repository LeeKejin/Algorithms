package com.algorithms.array.leetcode;

public class Leet27
{
    public int removeElement( int[] nums, int val )
    {
        int noneValueIndex = 0;
        for ( int i = 0; i < nums.length; i++ )
        {
            if ( nums[ i ] != val )
            {
                int temp = nums[ i ];
                nums[ i ] = val;
                nums[ noneValueIndex ] = temp;

                noneValueIndex++;
            }
        }
        return noneValueIndex;
    }

    public int removeElementOptimize( int[] nums, int val )
    {
        int noneValueIndex = 0;
        for ( int i = 0; i < nums.length; i++ )
        {
            if ( nums[ i ] != val )
            {
                nums[ noneValueIndex++ ] = nums[ i ];
            }
        }
        return noneValueIndex;
    }
}
