package com.algorithms.array.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class Leet159
{
    public int lengthOfLongestSubstringTwoDistinct( String s )
    {
        if ( s.length() < 2 ) return 1;
        Map< Character, Integer > map = new HashMap<>();
        int valid = 0;
        int right = 0;
        int left = 0;
        int len = 0;
        while ( right < s.length() )
        {
            char ch = s.charAt( right );
            if ( !map.containsKey( ch ) || map.get( ch ) == 0 ) valid++;
            map.put( ch, map.getOrDefault( ch, 0 ) + 1 );
            right++;
            if ( valid == 2 )
            {
                len = Math.max( len, right - left );
            }
            while ( valid > 2 )
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
