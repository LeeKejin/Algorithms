package com.algorithms.array.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class Leet424
{
    public int characterReplacement( String s, int k )
    {
        int count = 0;
        int right = 0;
        int left = 0;
        int len = 0;
        Map< Character, Integer > map = new HashMap<>();

        while ( right < s.length() )
        {
            char ch = s.charAt( right );
            map.put( ch, map.getOrDefault( ch, 0 ) + 1 );
            count = Math.max( count, map.get( ch ) );
            right++;

            if ( right - left > count + k )
            {
                char c = s.charAt( left );
                map.put( c, map.get( c ) - 1 );
                left++;
            }
            len = Math.max( len, right - left );
        }
        return len;
    }
}
