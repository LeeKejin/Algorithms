package com.algorithms.dynamicprogramming;

public class Leet5
{
    //https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/

    public String longestPalindrome( String s )
    {
        if ( s.length() == 0 || s.length() == 1 ) return s;
        String text1 = new StringBuilder( s ).reverse().toString();
        String text2 = s;
        int dp[][] = new int[ s.length() + 1 ][ s.length() + 1 ];
        int x = 0;
        int max = 0;
        for ( int i = 1; i <= s.length(); i++ )
        {
            for ( int j = 1; j <= s.length(); j++ )
            {
                if ( text1.charAt( i - 1 ) == text2.charAt( j - 1 ) )
                {
                    dp[ i ][ j ] = dp[ i - 1 ][ j - 1 ] + 1;
                }
                if ( dp[ i ][ j ] > max )
                {
                    int beforeRev = s.length() - j;//j is converted index, s.length()-j is the index before revert
                    if ( beforeRev + dp[ i ][ j ] == i )
                    {
                        max = dp[ i ][ j ];
                        x = i;
                    }
                }
            }
        }
        return text1.substring( x - max, x );
    }

    public String longestPalindromeExceedTimeLimit( String s )
    {
        if ( s == null ) return null;
        String[] dp = new String[ s.length() ];
        for ( int i = 0; i < s.length(); i++ )
        {
            dp[ i ] = String.valueOf( s.charAt( i ) );
        }

        for ( int i = 1; i < s.length(); i++ )
        {
            String v = String.valueOf( s.charAt( i ) );
            for ( int j = 0; j < i; j++ )
            {
                if ( dp[ j ].startsWith( v ) )
                {
                    String str = s.substring( j, i + 1 );
                    if ( isPalindrome( str ) )
                    {
                        if ( dp[ i ].length() < str.length() )
                            dp[ i ] = str;
                    }
                }
            }
        }
        String res = dp[ 0 ];
        for ( int i = 0; i < s.length(); i++ )
        {
            if ( res.length() < dp[ i ].length() ) res = dp[ i ];
        }
        return res;

    }

    private boolean isPalindrome( String str )
    {
        StringBuilder sb = new StringBuilder();
        for ( int i = str.length() - 1; i >= 0; i-- )
        {
            sb.append( str.charAt( i ) );
        }
        return sb.toString().equals( str );
    }

    public String longestPalindromeDP( String s )
    {
        if ( s.length() == 1 ) return s;
        if ( s.length() == 2 )
        {
            if ( s.charAt( 0 ) == s.charAt( 1 ) ) return s;
            return String.valueOf( s.charAt( 0 ) );
        }
        int[][] dp = new int[ s.length() ][ s.length() ];
        for ( int i = 0; i < s.length(); i++ )
        {
            for ( int j = 0; j < s.length(); j++ )
            {
                if ( i == j ) dp[ i ][ j ] = 1;
                if ( j == i + 1 )
                {
                    if ( s.charAt( i + 1 ) == s.charAt( i ) )
                    {
                        dp[ i ][ j ] = 1;
                    }
                }
            }
        }
        int start = 2;
        while ( start < s.length() )
        {
            for ( int i = 0; i < s.length(); i++ )
            {
                if ( i + start < s.length() )
                {
                    if ( s.charAt( i ) == s.charAt( i + start ) && dp[ i + 1 ][ i + start - 1 ] == 1 )
                    {
                        dp[ i ][ i + start ] = 1;
                    }
                }
            }
            start++;
        }
        int l = 0;
        int x = 0;
        int y = 0;
        for ( int i = 0; i < s.length(); i++ )
        {
            for ( int j = 0; j < s.length(); j++ )
            {
                if ( dp[ i ][ j ] == 1 )
                {
                    if ( l < Math.abs( j - i ) )
                    {
                        l = Math.abs( j - i );
                        x = i;
                        y = j;
                    }

                }
            }
        }
        return s.substring( x, y + 1 );
    }

}
