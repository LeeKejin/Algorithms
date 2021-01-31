package com.algorithms.dynamicprogramming;

public class Leet1143
{
    public int longestCommonSubsequence( String text1, String text2 )
    {
        if ( text1.equals( text2 ) || text2.contains( text1 ) ) return text1.length();
        if ( text1.contains( text2 ) ) return text2.length();
        String s1;
        String s2;
        if ( text1.length() >= text2.length() )
        {
            s1 = text1;
            s2 = text2;
        }
        else
        {
            s1 = text2;
            s2 = text1;
        }
        s1 = " " + s1;
        s2 = " " + s2;
        int[][] dp = new int[ s1.length() + 1 ][ s2.length() + 1 ];
        for ( int i = 1; i < s1.length(); i++ )
        {
            char ch1 = s1.charAt( i );
            for ( int j = 1; j < s2.length(); j++ )
            {
                char ch2 = s2.charAt( j );
                if ( ch1 == ch2 )
                {

                    dp[ i ][ j ] = dp[ i - 1 ][ j - 1 ] + 1;
                }
                else
                {
                    dp[ i ][ j ] = Math.max( dp[ i - 1 ][ j ], dp[ i ][ j - 1 ] );
                }
            }
        }
        return dp[ s1.length() - 1 ][ s2.length() - 1 ];
    }
}
