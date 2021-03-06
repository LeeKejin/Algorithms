package com.amazon.interview;

import java.util.HashMap;
import java.util.Map;

public class Leet13
{
    public int romanToInt( String s )
    {
        if ( s.length() == 0 ) return 0;

        Map< Character, Integer > map = new HashMap<>();
        map.put( 'I', 1 );
        map.put( 'V', 5 );
        map.put( 'X', 10 );
        map.put( 'L', 50 );
        map.put( 'C', 100 );
        map.put( 'D', 500 );
        map.put( 'M', 1000 );

        if ( s.length() == 1 ) return map.get( s.charAt( 0 ) );
        int sum = 0;
        int prev = map.get( s.charAt( 0 ) );
        for ( int i = 1; i < s.length(); i++ )
        {
            int num = map.get( s.charAt( i ) );
            if ( num > prev )
            {
                sum -= prev;
            }
            else
            {
                sum += prev;
            }
            prev = num;
        }
        sum += prev;
        return sum;
    }
}
