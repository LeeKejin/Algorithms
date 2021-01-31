package com.algorithms.dynamicprogramming;

public class Leet123_Stock3
{
    public int maxProfit( int[] prices )
    {
        if ( prices.length == 1 || prices.length == 0 ) return 0;
        int[][][] dp = new int[ prices.length ][ 3 ][ 2 ];

        dp[ 0 ][ 0 ][ 0 ] = 0;
        dp[ 0 ][ 1 ][ 0 ] = 0;
        dp[ 0 ][ 2 ][ 0 ] = 0;
        dp[ 0 ][ 0 ][ 1 ] = -1000000000;
        dp[ 0 ][ 1 ][ 1 ] = 0 - prices[ 0 ]; //Impossible to buy after 2 times
        dp[ 0 ][ 2 ][ 1 ] = -1000000000; //Impossible to buy before start

        for ( int i = 1; i < prices.length; i++ )
        {
            dp[ i ][ 2 ][ 0 ] = Math.max( dp[ i - 1 ][ 2 ][ 0 ], dp[ i - 1 ][ 2 ][ 1 ] + prices[ i ] );
            dp[ i ][ 2 ][ 1 ] = Math.max( dp[ i - 1 ][ 2 ][ 1 ], dp[ i - 1 ][ 1 ][ 0 ] - prices[ i ] );

            dp[ i ][ 1 ][ 0 ] = Math.max( dp[ i - 1 ][ 1 ][ 0 ], dp[ i - 1 ][ 1 ][ 1 ] + prices[ i ] );
            dp[ i ][ 1 ][ 1 ] = Math.max( dp[ i - 1 ][ 1 ][ 1 ], dp[ i - 1 ][ 0 ][ 0 ] - prices[ i ] );
        }
        return Math.max( dp[ prices.length - 1 ][ 0 ][ 0 ],
            Math.max( dp[ prices.length - 1 ][ 1 ][ 0 ], dp[ prices.length - 1 ][ 2 ][ 0 ] ) );
    }

}
