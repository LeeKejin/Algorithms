package com.amazon.interview.hashtable;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test
{
    public static int findFirstUnique( int[] arr )
    {
        Map< Integer, Integer > map = new LinkedHashMap<>();
        for ( int i : arr )
        {
            map.put( i, map.getOrDefault( i, 0 ) + 1 );
        }

        for ( int k : map.keySet() )
        {
            if ( map.get( k ) == 1 ) return k;
        }
        return -1;
    }
}
