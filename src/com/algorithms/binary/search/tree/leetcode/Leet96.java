package com.algorithms.binary.search.tree.leetcode;

public class Leet96
{
    int count = 1;

    public int numTrees( int n )
    {
        if ( n <= 0 ) return 0;
        for ( int i = 0; i < n; i++ )
        {
            count = count * 2 * ( 2 * i + 1 ) / ( i + 2 );
        }

        return ( int ) count;
    }

    //Catalan number -> n3 = n0*n2 + n1*n1 + n2*n0
    public int numTreesDP( int n )
    {
        int dp[] = new int[ n + 1 ];
        dp[ 0 ] = 1;
        dp[ 1 ] = 1;
        for ( int i = 2; i <= n; i++ )
        {
            for ( int j = 0; j < i; j++ )
            {
                dp[ i ] += dp[ j ] * dp[ i - j - 1 ];
            }
        }
        return dp[ n ];
    }

}
