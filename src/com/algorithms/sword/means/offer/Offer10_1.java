package com.algorithms.sword.means.offer;

public class Offer10_1
{
    public int fib( int n )
    {
        if ( n == 0 ) return 0;
        if ( n == 1 ) return 1;
        int mod = 1000000007;
        int dp[] = new int[ n + 1 ];
        dp[ 1 ] = 1;
        for ( int i = 2; i <= n; i++ )
        {
            dp[ i ] = ( dp[ i - 1 ] + dp[ i - 2 ] ) % mod;
        }
        return dp[ n ];
    }
}
