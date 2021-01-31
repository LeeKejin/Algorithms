package com.algorithms.dynamicprogramming.singlestring.longestincreasingsubsequence;

import java.util.Arrays;

public class Leet300
{
    public int lengthOfLIS( int[] nums )
    {
        int[] dp = new int[ nums.length ];
        Arrays.fill( dp, 1 );
        int res = 0;
        if ( nums.length == 0 ) return 1;

        for ( int i = 0; i < nums.length; i++ )
        {
            for ( int j = 0; j < i; j++ )
            {
                if ( nums[ i ] > nums[ j ] )
                {
                    dp[ i ] = Math.max( dp[ i ], dp[ j ] + 1 );
                }
            }
            res = Math.max( res, dp[ i ] );
        }
        return res;
    }

    public static void main( String[] args )
    {
        Leet300 l = new Leet300();
        System.out.println( l.lengthOfLIS( new int[] { 10, 9, 2, 5, 3, 7, 101, 18 } ) );

    }
}
