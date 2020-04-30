package com.algorithms.array.leetcode;

public class Leet3
{
    public int lengthOfLongestSubstring( String s )
    {
        int left = 0;
        int right = -1;
        int res = 0;
        int[] freq = new int[ 256 ];
        char[] chars = s.toCharArray();
        while ( left < s.length() )
        {
            if ( right + 1 < s.length() && freq[ chars[ right + 1 ] ] == 0 )
            {
                right++;
                freq[ chars[ right ] ]++;
            }
            else
            {
                freq[ chars[ left ] ]--;
                left++;
            }
            res = Math.max( res, right - left + 1 );
        }
        return res;
    }

    public static int lengthOfLongestSubstringSolution2( String s )
    {
        int l = 0;
        int r = 0;
        int[] freq = new int[ 256 ];
        int res = 0;
        while ( r < s.length() )
        {
            if ( freq[ s.charAt( r ) ] == 0 )
            {
                System.out.println( "s.charAt( r ):" + s.charAt( r ) + "-->" + freq[ s.charAt( r ) ] );
                freq[ s.charAt( r ) ]++;
                System.out.println( "s.charAt( r ):" + s.charAt( r ) + "-->" + freq[ s.charAt( r ) ] );
                r++;
                System.out.println( "R:" + r );
                System.out.println();
                System.out.println();

            }
            else
            {
                System.out.println( "s.charAt( l ):" + s.charAt( l ) + "-->" + freq[ s.charAt( l ) ] );
                freq[ s.charAt( l ) ]--;
                System.out.println( "L:" + l );
                System.out.println( "s.charAt( l ):" + s.charAt( l ) + "-->" + freq[ s.charAt( l ) ] );
                l++;
                System.out.println( "*************************************" );
            }
            res = Math.max( res, r - l );
        }
        return res;
    }

    public static void main( String[] args )
    {
        lengthOfLongestSubstringSolution2( "abcabcbb" );
    }
}
