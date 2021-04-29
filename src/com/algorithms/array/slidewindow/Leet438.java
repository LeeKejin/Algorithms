package com.algorithms.array.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet438
{
    public List< Integer > findAnagrams( String s, String p )
    {
        List< Integer > res = new ArrayList<>();
        Map< Character, Integer > need = new HashMap<>();
        Map< Character, Integer > window = new HashMap<>();
        for ( char ch : p.toCharArray() )
        {
            need.put( ch, need.getOrDefault( ch, 0 ) + 1 );
        }

        int right = 0;
        int left = 0;
        int len = s.length() + 1;
        int valid = 0;
        while ( right < s.length() )
        {
            char ch = s.charAt( right );
            if ( need.containsKey( ch ) )
            {
                window.put( ch, window.getOrDefault( ch, 0 ) + 1 );
                if ( window.get( ch ).intValue() == need.get( ch ).intValue() )
                {
                    valid++;
                }
            }
            right++;
            while ( valid == need.size() )
            {
                if ( right - left == p.length() )
                {
                    res.add( left );
                }
                char c = s.charAt( left );
                if ( need.containsKey( c ) )
                {
                    if ( need.get( c ).intValue() == window.get( c ).intValue() )
                    {
                        valid--;
                    }
                    window.put( c, window.get( c ) - 1 );
                }
                left++;
            }
        }
        return res;
    }

}
