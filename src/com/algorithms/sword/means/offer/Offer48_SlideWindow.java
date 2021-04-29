package com.algorithms.sword.means.offer;

import java.util.HashMap;
import java.util.Map;

public class Offer48_SlideWindow
{
    public int lengthOfLongestSubstring( String s )
    {
        if ( s.length() == 0 ) return 0;
        int max = 1;
        Map< Character, Integer > map = new HashMap<>();
        int left = 0;
        for ( int i = 0; i < s.length(); i++ )
        {
            if ( map.containsKey( s.charAt( i ) ) )
            {
                left = Math.max( map.get( s.charAt( i ) ) + 1, left );
            }
            map.put( s.charAt( i ), i );
            max = Math.max( max, i - left + 1 );
        }
        return max;
    }
}
