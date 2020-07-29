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

}
