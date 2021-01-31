package com.algorithms.dynamicprogramming;

public class Leet279
{
    int dp[] = new int[ 10000 ];

    public int numSquares( int n )
    {
        if ( n == 0 ) return 0;

        dp[ 1 ] = 1;
        for ( int i = 2; i <= n; i++ )
        {
            int count = Integer.MAX_VALUE;
            for ( int j = 1; j * j <= i; j++ )
            {
                count = Math.min( dp[ i - j * j ] + 1, count );
            }
            dp[ i ] = count;
        }
        return dp[ n ];
    }

    public int numSquares1( int n )
    {
        if ( n == 0 ) return 0;
        if ( dp[ n ] != 0 ) return dp[ n ];
        int count = Integer.MAX_VALUE;
        for ( int i = 1; i * i <= n; i++ )
        {
            count = Math.min( count, numSquares1( n - i * i ) + 1 );
        }
        dp[ n ] = count;
        return dp[ n ];

    }

}
