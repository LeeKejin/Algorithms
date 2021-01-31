package com.algorithms.dynamicprogramming;

public class Leet312_Hard
{
    public int maxCoins( int[] nums )
    {
        int n = nums.length + 2;
        int temp[] = new int[ n ];

        int length = nums.length;
        for ( int i = 1; i <= length; i++ )
        {
            temp[ i ] = nums[ i - 1 ];
        }
        temp[ n - 1 ] = 1;
        temp[ 0 ] = 1;
        int dp[][] = new int[ n ][ n ];
        for ( int i = 1; i <= length; i++ )
        {
            for ( int l = 1; l <= length - i + 1; l++ )
            {
                int r = l + ( i - 1 );
                for ( int j = l; j <= r; j++ )
                {
                    dp[ l ][ r ] =
                        Math.max( dp[ l ][ r ],
                            dp[ l ][ j - 1 ] + temp[ l - 1 ] * temp[ j ] * temp[ r + 1 ] + dp[ j + 1 ][ r ] );
                }
            }
        }
        return dp[ 1 ][ length ];
    }

}
