package com.algorithms.dynamicprogramming.palindrome;

public class Leet647
{
    public int countSubstrings( String s )
    {
        if ( s.length() == 0 ) return 1;
        int res = 1;
        for ( int i = 0; i < ( s.length() * 2 - 1 ); i++ )
        {
            int l = i / 2;
            int r = l + i % 2;
            while ( l >= 0 && r < s.length() && s.charAt( l ) == s.charAt( r ) )
            {
                res++;
                l--;
                r++;
            }
        }
        return res;
    }

    public int countSubstringsDP( String s )
    {
        if ( s.length() == 0 ) return 1;
        int n = s.length();
        boolean[][] dp = new boolean[ n ][ n ];
        int res = 0;
        for ( int i = 0; i < n; i++ )
        {
            dp[ i ][ i ] = true;
        }

        for ( int i = n - 1; i >= 0; i-- )
        {
            for ( int j = i + 1; j < n; j++ )
            {
                if ( s.charAt( i ) == s.charAt( j ) )
                {
                    if ( j - i == 1 || dp[ i + 1 ][ j - 1 ] )
                    {
                        dp[ i ][ j ] = true;
                        res++;
                    }
                }
            }
        }
        return res + s.length();
    }

}
