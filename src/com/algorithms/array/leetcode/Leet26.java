package com.algorithms.array.leetcode;

public class Leet26
{
    //range []
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

    //range [)
    public int removeDuplicates1( int[] nums )
    {
        if ( nums.length == 0 ) return 0;
        int index = 1;
        for ( int i = 1; i < nums.length; i++ )
        {
            if ( nums[ i ] != nums[ index - 1 ] )
            {
                nums[ index ] = nums[ i ];
                index++;
            }
        }
        return index;
    }
}
