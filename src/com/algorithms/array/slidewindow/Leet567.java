package com.algorithms.array.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class Leet567
{
    public boolean checkInclusion( String s1, String s2 )
    {
        Map< Character, Integer > need = new HashMap<>();
        Map< Character, Integer > window = new HashMap<>();
        for ( char ch : s1.toCharArray() )
        {
            need.put( ch, need.getOrDefault( ch, 0 ) + 1 );
        }

        int right = 0;
        int valid = 0;
        int left = 0;
        int len = s2.length() + 1;
        int start = 0;
        while ( right < s2.length() )
        {
            char ch = s2.charAt( right );
            if ( need.containsKey( ch ) )
            {
                window.put( ch, window.getOrDefault( ch, 0 ) + 1 );
                if ( window.get( ch ).intValue() == need.get( ch ).intValue() )
                {
                    valid++;
                }
            }

            right++;

            while ( valid == need.size() )//shirk window when all chars in s1 has appeared in s2
            {
                if ( right - left < len )
                {
                    len = right - left;
                    start = left;
                }
                char c = s2.charAt( left );
                if ( need.containsKey( c ) )
                {
                    if ( window.get( c ).intValue() == need.get( c ).intValue() )
                    {
                        valid--;
                    }
                    window.put( c, window.get( c ) - 1 );
                }
                left++;
            }
        }

        if ( len == s2.length() + 1 ) return false;
        String res = s2.substring( start, start + len );//cbbbba
        return res.length() == s1.length();
    }

    public boolean checkInclusionSolution( String s1, String s2 )
    {
        Map< Character, Integer > need = new HashMap<>();
        Map< Character, Integer > window = new HashMap<>();
        for ( char ch : s1.toCharArray() )
        {
            need.put( ch, need.getOrDefault( ch, 0 ) + 1 );
        }

        int right = 0;
        int valid = 0;
        int left = 0;
        while ( right < s2.length() )
        {
            char ch = s2.charAt( right );
            if ( need.containsKey( ch ) )
            {
                window.put( ch, window.getOrDefault( ch, 0 ) + 1 );
                if ( window.get( ch ).intValue() == need.get( ch ).intValue() )
                {
                    valid++;
                }
            }

            right++;

            while ( right - left >= s1.length() )//shirk window when size >s1.length
            {
                if ( valid == need.size() )
                {
                    return true;
                }
                char c = s2.charAt( left );
                if ( need.containsKey( c ) )
                {
                    if ( window.get( c ).intValue() == need.get( c ).intValue() )
                    {
                        valid--;
                    }
                    window.put( c, window.get( c ) - 1 );
                }
                left++;
            }
        }

        return false;
    }

}
