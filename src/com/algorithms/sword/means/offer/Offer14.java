package com.algorithms.sword.means.offer;

public class Offer14
{
    public int cuttingRope( int n )
    {
        int dp[] = new int[ n + 1 ];
        dp[ 2 ] = 1;
        for ( int i = 3; i <= n; i++ )
        {
            for ( int j = 2; j < i; j++ )
            {
                dp[ i ] =
                    Math.max( dp[ i ] % 1000000007,
                        Math.max( ( j * ( i - j ) ) % 1000000007, ( j * ( dp[ i - j ] % 1000000007 ) ) ) % 1000000007 );
            }
        }
        return dp[ n ] % 1000000007;
    }
}
