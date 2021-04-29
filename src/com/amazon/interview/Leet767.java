package com.amazon.interview;

import java.util.HashMap;
import java.util.Map;

public class Leet767
{
    public String reorganizeString( String S )
    {
        if ( S == null ) return "";
        Map< Character, Integer > map = new HashMap<>();
        int n = 0;
        char c = '0';
        for ( char ch : S.toCharArray() )
        {
            map.put( ch, map.getOrDefault( ch, 0 ) + 1 );
            if ( map.get( ch ) > n )
            {
                n = map.get( ch );
                c = ch;
            }
        }
        if ( n > ( S.length() + 1 ) / 2 ) return "";
        char[] res = new char[ S.length() ];
        int j;
        for ( j = 0; j < S.length(); j += 2 )
        {
            if ( n == 0 ) break;
            res[ j ] = c;
            n--;
        }
        map.remove( c );
        int index = j;
        for ( char ch : map.keySet() )
        {
            for ( int i = 0; i < map.get( ch ); i++ )
            {
                if ( index >= res.length ) index = 1;
                res[ index ] = ch;
                index += 2;

            }

        }
        return String.valueOf( res );
    }
}
