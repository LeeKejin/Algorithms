package com.amazon.interview;

public class Leet1062
{
    public int longestRepeatingSubstring( String S )
    {
        if ( S.length() == 0 ) return 0;
        int dp[][] = new int[ S.length() + 1 ][ S.length() + 1 ];
        int res = 1;
        for ( int i = 1; i <= S.length(); i++ )
        {
            for ( int j = i + 1; j <= S.length(); j++ )
            {
                if ( S.charAt( i - 1 ) == S.charAt( j - 1 ) )
                {
                    dp[ i ][ j ] = dp[ i - 1 ][ j - 1 ] + 1;
                    res = Math.max( res, dp[ i ][ j ] );
                }
            }
        }
        return res;
    }
}
