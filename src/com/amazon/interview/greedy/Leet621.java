package com.amazon.interview.greedy;

import java.util.Arrays;

public class Leet621
{
    public int leastInterval( char[] tasks, int n )
    {
        int[] temp = new int[ 26 ];
        for ( char task : tasks )
        {
            temp[ task - 'A' ]++;
        }
        Arrays.sort( temp );

        int maxCount = temp[ 25 ];
        int max = 1;
        for ( int i = 24; i >= 0; i-- )
        {
            if ( temp[ i ] == maxCount )
            {
                max++;
            }
            else
            {
                break;
            }
        }
        int res = ( maxCount - 1 ) * ( n + 1 ) + max;
        return Math.max( res, tasks.length );
    }
}
