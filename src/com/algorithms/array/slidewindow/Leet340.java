package com.algorithms.array.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class Leet340
{
    public int lengthOfLongestSubstringKDistinct( String s, int k )
    {
        if ( k == 0 ) return 0;
        if ( s.length() < k ) return s.length();
        Map< Character, Integer > map = new HashMap<>();
        int right = 0;
        int left = 0;
        int valid = 0;
        int len = 0;
        while ( right < s.length() )
        {
            char ch = s.charAt( right );
            if ( !map.containsKey( ch ) || map.get( ch ) == 0 )
            {
                valid++;
            }
            map.put( ch, map.getOrDefault( ch, 0 ) + 1 );
            right++;

            if ( valid == k )
            {
                len = Math.max( len, right - left );
            }
            else if ( valid > k )
            {
                char c = s.charAt( left );
                map.put( c, map.get( c ) - 1 );
                if ( map.get( c ) == 0 )
                {
                    valid--;
                }
                left++;
            }
        }
        return len == 0 ? s.length() : len;
    }
}
