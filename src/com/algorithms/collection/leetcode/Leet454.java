package com.algorithms.collection.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet454
{
    // O(n^2) for both space and time
    public static int fourSumCount( int[] A, int[] B, int[] C, int[] D )
    {
        Map< Integer, Integer > map = new HashMap<>();
        int count = 0;
        for ( int a : A )
        {
            for ( int b : B )
            {
                int sum = a + b;
                map.put( sum, map.getOrDefault( sum, 0 ) + 1 );
            }
        }

        for ( int i = 0; i < C.length; i++ )
        {
            for ( int j = 0; j < D.length; j++ )
            {
                int sum = C[ i ] + D[ j ];
                count += map.getOrDefault( -sum, 0 );

            }
        }

        return count;
    }

    public static void main( String[] args )
    {
        System.out.print(
            fourSumCount( new int[] { -1, -1 }, new int[] { -1, 1 }, new int[] { -1, 1 }, new int[] { 1, -1 } ) );
    }

}
