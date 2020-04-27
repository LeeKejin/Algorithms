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
        char[] subChars = new char[ s.length() ];
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
}
