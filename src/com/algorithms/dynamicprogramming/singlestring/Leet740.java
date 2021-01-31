package com.algorithms.dynamicprogramming.singlestring;

public class Leet740
{
    public int deleteAndEarn( int[] nums )
    {
        if ( nums.length == 0 ) return 0;
        if ( nums.length == 1 ) return nums[ 0 ];
        int max = Integer.MIN_VALUE;
        for ( int i = 0; i < nums.length; i++ )
        {
            max = Math.max( max, nums[ i ] );
        }
        int[] arr = new int[ max + 1 ];
        for ( int i = 0; i < nums.length; i++ )
        {
            arr[ nums[ i ] ] += 1;
        }

        int[][] dp = new int[ max + 1 ][ 2 ];
        dp[ 0 ][ 0 ] = 0;
        dp[ 0 ][ 1 ] = arr[ 0 ];
        for ( int i = 1; i < arr.length; i++ )
        {
            dp[ i ][ 0 ] = Math.max( dp[ i - 1 ][ 0 ], dp[ i - 1 ][ 1 ] );
            dp[ i ][ 1 ] = arr[ i ] * i + dp[ i - 1 ][ 0 ];
        }
        return Math.max( dp[ max ][ 0 ], dp[ max ][ 1 ] );
    }
}
