package com.algorithms.sword.means.offer;

import java.util.Arrays;

public class Title1
{
    public int findRepeatNumber( int[] nums )
    {
        Arrays.sort( nums );
        for ( int i = 1; i < nums.length; i++ )
        {
            if ( nums[ i ] == nums[ i - 1 ] ) return nums[ i ];
        }
        return -1;
    }

    public int findRepeatNumberSolution1( int[] nums )
    {
        int i = 0;
        while ( i < nums.length )
        {
            if ( nums[ i ] == i )
            {
                i++;
                continue;
            }
            if ( nums[ i ] == nums[ nums[ i ] ] ) return nums[ i ];
            int temp = nums[ i ];
            nums[ i ] = nums[ temp ];
            nums[ temp ] = temp;

        }
        return -1;
    }
}
