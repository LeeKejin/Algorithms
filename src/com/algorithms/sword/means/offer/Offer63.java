package com.algorithms.sword.means.offer;

public class Offer63
{
    public int maxProfit( int[] prices )
    {
        if ( prices.length <= 0 ) return 0;
        int buy = -prices[ 0 ];
        int sell = 0;
        for ( int i = 1; i < prices.length; i++ )
        {
            buy = Math.max( -prices[ i ], buy );
            sell = Math.max( sell, prices[ i ] + buy );
        }
        return sell;
    }

}
