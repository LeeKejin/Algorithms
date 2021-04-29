package com.algorithms.array.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class Leet395
{
    public int longestSubstring( String s, int k )
    {
        if ( s.length() < k ) return 0;
        Map< Character, Integer > map = new HashMap<>();
        for ( char ch : s.toCharArray() )
        {
            map.put( ch, map.getOrDefault( ch, 0 ) + 1 );
        }
        for ( int i = 0; i < s.length(); i++ )
        {
            if ( map.get( s.charAt( i ) ) < k )
            {
                int res = 0;
                for ( String sub : s.split( String.valueOf( s.charAt( i ) ) ) )
                {
                    res = Math.max( res, longestSubstring( sub, k ) );
                }
                return res;
            }
        }
        return s.length();
    }
}
