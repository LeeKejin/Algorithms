package com.algorithms.dynamicprogramming;

public class WineProblem
{
    public int wineProblem( int[] nums )
    {
        return calculate( nums, 1, 0, nums.length - 1 );
    }

    private int calculate( int[] nums, int year, int start, int end )
    {
        if ( start == end ) return year * nums[ start ];
        int left = nums[ start ] * year + calculate( nums, year + 1, start + 1, end );
        int right = nums[ end ] * year + calculate( nums, year + 1, start, end - 1 );
        return Math.max( left, right );
    }
}
