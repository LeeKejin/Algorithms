package com.algorithms.array.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class Leet340
{
    public int lengthOfLongestSubstringKDistinct( String str, int k )
    {
        int start = 0;
        int res = 0;
        Map< Character, Integer > map = new HashMap<>();
        for ( int i = 0; i < str.length(); i++ )
        {
            char ch = str.charAt( i );
            map.put( ch, map.getOrDefault( ch, 0 ) + 1 );
            while ( map.size() > k )
            {
                char startCh = str.charAt( start );
                map.put( startCh, map.get( startCh ) - 1 );
                if ( map.get( startCh ) == 0 )
                {
                    map.remove( startCh );
                }
                start++;
            }
            res = Math.max( res, i - start + 1 );
        }
        return res;
    }
}
