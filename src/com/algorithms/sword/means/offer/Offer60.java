package com.algorithms.sword.means.offer;

public class Offer60
{
    public double[] dicesProbability( int n )
    {
        double[] dp = new double[ 6 ];
        for ( int i = 0; i < 6; i++ )
        {
            dp[ i ] = 1 / 6.0;
        }

        for ( int i = 1; i < n; i++ )
        {
            double[] temp = new double[ ( i + 1 ) * 6 - i ];
            for ( int j = 0; j < dp.length; j++ )
            {
                for ( int k = j; k < 6 + j; k++ )
                {
                    temp[ k ] += ( dp[ j ] / 6.0 );
                }
            }
            dp = temp;
        }

        return dp;
    }
}
