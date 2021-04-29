package com.algorithms.sword.means.offer;

public class Offer21
{
    public int[] exchange1( int[] nums )
    {
        if ( nums.length == 0 ) return nums;

        int j = 0;
        for ( int i = 0; i < nums.length; i++ )
        {
            if ( nums[ i ] % 2 == 1 )
            {
                swap( nums, i, j );
                j++;
            }

        }
        return nums;
    }

    public int[] exchange( int[] nums )
    {
        if ( nums.length == 0 ) return nums;

        int i = 0;
        int j = nums.length - 1;
        while ( i < j )
        {
            if ( nums[ i ] % 2 != 0 )
            {
                i++;
                continue;
            }
            if ( nums[ j ] % 2 == 0 )
            {
                j--;
                continue;
            }
            if ( i < j ) swap( nums, i, j );
        }
        return nums;
    }

    private void swap( int nums[], int i, int j )
    {
        int temp = nums[ i ];
        nums[ i ] = nums[ j ];
        nums[ j ] = temp;
    }
}
