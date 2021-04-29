package com.algorithms.array.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class Leet76
{
    public String minWindow( String s, String t )
    {
        Map< Character, Integer > window = new HashMap<>();
        Map< Character, Integer > need = new HashMap<>();

        for ( char ch : t.toCharArray() )
        {
            need.put( ch, need.getOrDefault( ch, 1 ) + 1 );
        }

        int right = 0;
        int left = 0;
        int valid = 0;
        int start = 0;
        int len = s.length() + 1;
        while ( right < s.length() )
        {
            if ( need.containsKey( s.charAt( right ) ) )
            {
                window.put( s.charAt( right ), window.getOrDefault( s.charAt( right ), 1 ) + 1 );
                if ( window.get( s.charAt( right ) ).intValue() == need.get( s.charAt( right ) ).intValue() )
                {
                    valid++;
                }
            }

            right++;

            while ( valid == need.size() )
            {
                if ( ( right - left ) < len )
                {
                    start = left;
                    len = right - left;
                }
                char ch = s.charAt( left );

                if ( need.containsKey( ch ) )
                {
                    if ( need.get( ch ).intValue() == window.get( ch ).intValue() )
                    {
                        valid--;
                    }
                    window.put( ch, window.getOrDefault( ch, 1 ) - 1 );

                }
                left++;
            }
        }
        return len == s.length() + 1 ? "" : s.substring( start, start + len );
    }

    public static String minWindowSolution( String s, String t )
    {
        int r = 0;
        int l = 0;
        int count = t.length();
        int[] freq = new int[ 256 ];
        int length = s.length() + 1;
        int begin = 0;
        for ( char c : t.toCharArray() )
        {
            freq[ c ]++;
        }
        while ( r < s.length() )
        {
            freq[ s.charAt( r ) ]--;
            if ( freq[ s.charAt( r ) ] >= 0 ) count--;

            while ( count == 0 )
            {
                freq[ s.charAt( l ) ]++;
                if ( freq[ s.charAt( l ) ] > 0 )
                {
                    if ( r - l + 1 < length )
                    {
                        begin = l;
                        length = r - l + 1;
                    }

                    count++;
                }
                l++;
            }
            r++;
        }

        return length == ( s.length() + 1 ) ? "" : s.substring( begin, begin + length );

    }
}
