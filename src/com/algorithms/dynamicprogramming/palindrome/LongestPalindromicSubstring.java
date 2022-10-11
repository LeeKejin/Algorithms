package com.algorithms.dynamicprogramming.palindrome;

import java.util.Arrays;

public class LongestPalindromicSubstring
{
    public String longestPalindrome( String s )
    {
        if ( s.length() == 0 ) return "";
        int n = s.length();
        boolean dp[][] = new boolean[ n ][ n ];
        int start = 0;
        int length = 1;
        for ( int i = 0; i < n; i++ )
        {
            Arrays.fill( dp[ i ], false );
        }

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
                    if ( i + 1 == j ) //如果i j相邻就不需要看中间的元素  dp[ i + 1 ][ j - 1 ]指中间元素是否为回文串
                    {
                        dp[ i ][ j ] = true;
                    }
                    else
                    {
                        dp[ i ][ j ] = dp[ i + 1 ][ j - 1 ];
                    }
                }
                if ( dp[ i ][ j ] )
                {
                    int l = j - i + 1;
                    if ( l > length )
                    {
                        length = l;
                        start = i;
                    }
                }
            }
        }
        return s.substring( start, start + length );
    }

    public String longestPalindromeWithCenterPoint( String s )
    {
        String res = "";
        for ( int center = 0; center < 2 * s.length() - 1; center++ )
        {
            int left = center / 2;
            int right = left + center % 2;
            while ( left >= 0 && right < s.length() && s.charAt( left ) == s.charAt( right ) )
            {
                String str = s.substring( left, right + 1 );
                if ( res.length() < str.length() )
                {
                    res = str;

                }
                left--;
                right++;
            }
        }
        return res;
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
}
