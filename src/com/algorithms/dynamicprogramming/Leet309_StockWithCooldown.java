package com.algorithms.dynamicprogramming;

public class Leet309_StockWithCooldown
{
    public int maxProfit( int[] prices )
    {
        if ( prices.length == 0 || prices.length == 1 ) return 0;
        int[][] dp = new int[ prices.length ][ 2 ];
        dp[ 0 ][ 0 ] = 0;
        dp[ 0 ][ 1 ] = 0 - prices[ 0 ];
        dp[ 1 ][ 0 ] = Math.max( dp[ 0 ][ 0 ], dp[ 0 ][ 1 ] + prices[ 1 ] );
        dp[ 1 ][ 1 ] = Math.max( dp[ 0 ][ 0 ] - prices[ 1 ], dp[ 0 ][ 1 ] );
        for ( int i = 2; i < prices.length; i++ )
        {
            dp[ i ][ 0 ] = Math.max( dp[ i - 1 ][ 0 ], dp[ i - 1 ][ 1 ] + prices[ i ] );
            dp[ i ][ 1 ] = Math.max( dp[ i - 2 ][ 0 ] - prices[ i ], dp[ i - 1 ][ 1 ] );
        }
        return dp[ prices.length - 1 ][ 0 ];
    }

    public int maxProfitSolution1( int[] prices )
    {
        if ( prices.length == 0 || prices.length == 1 ) return 0;
        int length = prices.length;
        int[] noStock = new int[ length ];
        int[] inHand = new int[ length ];
        int[] sold = new int[ length ];

        noStock[ 0 ] = 0;
        inHand[ 0 ] = 0 - prices[ 0 ];
        sold[ 0 ] = 0;
        for ( int i = 1; i < prices.length; i++ )
        {
            noStock[ i ] = Math.max( noStock[ i - 1 ], sold[ i - 1 ] );
            inHand[ i ] = Math.max( inHand[ i - 1 ], noStock[ i - 1 ] - prices[ i ] );
            sold[ i ] = inHand[ i - 1 ] + prices[ i ];
        }
        return Math.max( noStock[ length - 1 ], sold[ length - 1 ] );
    }

    public int maxProfitSolution2( int[] prices )
    {
        //0:sell
        //1:buy
        //2:cool down
        if ( prices.length == 0 || prices.length == 1 ) return 0;
        int dp[][] = new int[ prices.length ][ 3 ];
        dp[ 0 ][ 0 ] = 0;
        dp[ 0 ][ 1 ] = 0 - prices[ 0 ];
        dp[ 0 ][ 2 ] = 0;
        for ( int i = 1; i < prices.length; i++ )
        {
            dp[ i ][ 0 ] = Math.max( dp[ i - 1 ][ 0 ], dp[ i - 1 ][ 1 ] + prices[ i ] );
            dp[ i ][ 1 ] = Math.max( dp[ i - 1 ][ 1 ], dp[ i - 1 ][ 2 ] - prices[ i ] );
            dp[ i ][ 2 ] = dp[ i - 1 ][ 0 ];
        }
        return Math.max( dp[ prices.length - 1 ][ 2 ], dp[ prices.length ][ 0 ] );
    }
}
