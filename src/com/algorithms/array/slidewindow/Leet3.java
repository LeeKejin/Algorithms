package com.algorithms.array.slidewindow;

import java.util.HashMap;
import java.util.Map;

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

    public int lengthOfLongestSubstring1( String s )
    {
        if ( s == null || s.length() == 0 ) return 0;
        HashMap< Character, Integer > map = new HashMap<>();
        int max = 0;
        int left = 0;
        for ( int i = 0; i < s.length(); i++ )
        {
            if ( map.containsKey( s.charAt( i ) ) )
            {
                left = Math.max( left, map.get( s.charAt( i ) ) + 1 );
            }
            map.put( s.charAt( i ), i );
            max = Math.max( max, i - left + 1 );
        }
        return max;
    }

    public int lengthOfLongestSubstring2( String s )
    {
        Map< Character, Integer > window = new HashMap<>();
        int left = 0;
        int right = 0;
        int len = Integer.MIN_VALUE;
        while ( right < s.length() )
        {
            char ch = s.charAt( right );

            window.put( ch, window.getOrDefault( ch, 0 ) + 1 );
            right++;
            while ( window.get( ch ) > 1 )
            {
                char c = s.charAt( left );
                left++;
                window.put( c, window.get( c ) - 1 );

            }
            len = Math.max( len, right - left );
        }
        return len == Integer.MIN_VALUE ? 0 : len;
    }

    public int lengthOfLongestSubstring4( String s )
    {
        int right = 0;
        int left = 0;
        int len = 0;
        int start = 0;
        Map< Character, Integer > map = new HashMap<>();
        while ( right < s.length() )
        {
            char ch = s.charAt( right );
            right++;

            map.put( ch, map.getOrDefault( ch, 0 ) + 1 );

            while ( map.get( ch ).intValue() >= 2 )
            {
                char c = s.charAt( left );
                map.put( c, map.get( c ) - 1 );
                left++;
                start = Math.max( start, left );

            }
            len = Math.max( len, right - start );

        }
        if ( map.size() == s.length() ) return s.length();
        return len;
    }
}
