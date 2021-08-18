package com.amazon.interview.greedy;

import java.util.Arrays;

public class Leet455
{
    public int findContentChildren( int[] g, int[] s )
    {
        Arrays.sort( g );
        Arrays.sort( s );
        int count = 0;
        int j = g.length - 1;
        for ( int i = s.length - 1; i >= 0; i-- )
        {
            while ( j >= 0 && s[ i ] < g[ j ] )
            {
                j--;
            }
            if ( j >= 0 && s[ i ] >= g[ j ] )
            {
                count++;
                j--;
            }
        }
        return count;
    }
}
