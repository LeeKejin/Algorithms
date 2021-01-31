package com.algorithms.array.leetcode.vote;

import java.util.HashMap;
import java.util.Map;

public class Leet169
{
    public int majorityElement( int[] nums )
    {
        if ( nums.length == 0 ) return 0;
        if ( nums.length == 1 ) return nums[ 0 ];
        Map< Integer, Integer > map = new HashMap<>();

        int size = nums.length;
        int half;
        if ( size % 2 == 0 )
        {
            half = size / 2;
        }
        else
        {
            half = size / 2 + 1;
        }
        for ( int i = 0; i < nums.length; i++ )
        {
            if ( map.containsKey( nums[ i ] ) )
            {
                int c = map.get( nums[ i ] );
                c++;
                map.put( nums[ i ], c );
                if ( c >= half )
                {
                    return nums[ i ];
                }
            }
            else
            {
                map.put( nums[ i ], 1 );
            }
        }
        return -1;
    }
}
