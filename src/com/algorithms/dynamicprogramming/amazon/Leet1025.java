package com.algorithms.dynamicprogramming.amazon;

public class Leet1025
{
    public boolean divisorGame( int N )
    {
        if ( N == 1 ) return false;
        int dp[] = new int[ N + 1 ];
        for ( int i = 2; i <= N; i++ )
        {
            for ( int j = 1; j < i; j++ )
            {
                if ( i % j == 0 )
                {
                    if ( dp[ i - j ] == 0 )
                    {
                        dp[ i ] = 1;
                    }
                }
            }
        }
        return dp[ N ] == 1;
    }
}
