package com.algorithms.dynamicprogramming;

public class Leet343
{
    int[] dp = new int[ 60 ];

    public int integerBreakDP( int n )
    {
        int val = 0;
        dp[ 1 ] = 1;

        if ( n == 1 )
        {
            return 1;
        }
        for ( int i = 2; i <= n; i++ )
        {
            for ( int j = 1; j < i; j++ )
            {
                dp[ i ] = max( dp[ i ], j * ( i - j ), j * dp[ i - j ] );
            }

        }
        return dp[ n ];
    }

    public int integerBreak( int n )
    {
        int val = 0;
        dp[ 1 ] = 1;

        if ( n == 1 )
        {
            return 1;
        }
        for ( int i = 1; i < n; i++ )
        {
            if ( dp[ n - i ] != 0 )
            {
                val = max( val, i * ( n - i ), i * dp[ n - i ] );
            }
            else
            {
                val = max( val, i * ( n - i ), i * integerBreak( n - i ) );
            }

        }
        return val;
    }

    private int max( int val, int i, int i1 )
    {
        return Math.max( val, Math.max( i, i1 ) );
    }

}
