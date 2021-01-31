package com.algorithms.dynamicprogramming;

public class Leet831Hard
{
    public double largestSumOfAverages( int[] A, int K )
    {
        double sum = 0.0;

        double dp[][] = new double[ K ][ A.length ];
        for ( int i = 0; i < A.length; i++ )
        {
            sum += A[ i ];
            dp[ 0 ][ i ] = sum / ( i + 1.0 );
        }

        for ( int n = 1; n < K; n++ )
        {
            for ( int i = n; i < A.length; i++ )
            {
                sum = 0.0;
                for ( int j = i; j >= n; j-- )
                {
                    sum += A[ j ];
                    dp[ n ][ i ] = Math.max( dp[ n ][ i ], sum / ( i - j + 1 ) + dp[ n - 1 ][ j - 1 ] );
                }
            }
        }
        return dp[ K - 1 ][ A.length - 1 ];
    }
}
