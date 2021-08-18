package com.amazon.interview.graph;

public class Leet997
{
    public int findJudge( int n, int[][] trust )
    {
        if ( trust.length == 0 && n == 1 ) return 1;
        if ( trust.length == 0 && n != 1 ) return -1;
        int[] degree = new int[ n ];
        for ( int[] t : trust )
        {
            degree[ t[ 0 ] - 1 ]--;
            degree[ t[ 1 ] - 1 ]++;
        }
        for ( int i = 0; i < n; i++ )
        {
            if ( degree[ i ] == n - 1 )
            {
                return i + 1;
            }
        }
        return -1;
    }
}
