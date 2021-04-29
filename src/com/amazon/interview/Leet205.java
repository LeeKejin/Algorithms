package com.amazon.interview;

import java.util.HashMap;
import java.util.Map;

public class Leet205
{
    public boolean isIsomorphic( String s, String t )
    {
        if ( s.length() != t.length() ) return false;
        Map< Character, Character > stMap = new HashMap<>();
        Map< Character, Character > tsMap = new HashMap<>();
        for ( int i = 0; i < s.length(); i++ )
        {
            if ( ( stMap.containsKey( s.charAt( i ) ) && stMap.get( s.charAt( i ) ) != t.charAt( i ) ) || (
                tsMap.containsKey( t.charAt( i ) ) && tsMap.get( t.charAt( i ) ) != s.charAt( i ) ) )
            {
                return false;
            }
            tsMap.put( t.charAt( i ), s.charAt( i ) );
            stMap.put( s.charAt( i ), t.charAt( i ) );
        }
        return true;
    }

}
