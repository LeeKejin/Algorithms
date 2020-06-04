package com.algorithms.others;

import java.util.Arrays;

public class Leet287
{
    public int findDuplicate( int[] nums )
    {
        int cur = nums[ 0 ];
        for ( int i = 1; i < nums.length; i++ )
        {
            for ( int j = i; j < nums.length; j++ )
            {
                if ( cur == nums[ j ] ) return cur;
            }
            cur = nums[ i ];
        }
        return -1;
    }

    public int findDuplicateSolution1( int[] nums )
    {
        Arrays.sort( nums );
        int cur = nums[ 0 ];
        for ( int i = 1; i < nums.length; i++ )
        {
            if ( nums[ i ] == nums[ i - 1 ] ) return nums[ i ];
        }
        return -1;
    }
}
