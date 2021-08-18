package com.amazon.interview.greedy;

import java.util.HashMap;
import java.util.Map;

public class Leet860
{
    public boolean lemonadeChange( int[] bills )
    {
        Map< Integer, Integer > map = new HashMap<>();
        for ( int i = 0; i < bills.length; i++ )
        {
            if ( bills[ i ] == 5 )
            {
                map.put( 5, map.getOrDefault( 5, 0 ) + 1 );
            }
            else if ( bills[ i ] == 10 )
            {
                map.put( 10, map.getOrDefault( 10, 0 ) + 1 );
                if ( !map.containsKey( 5 ) || map.get( 5 ) == 0 ) return false;
                map.put( 5, map.get( 5 ) - 1 );
            }
            else
            {
                if ( map.get( 10 ) != null && map.get( 10 ) >= 1 && map.get( 5 ) != null && map.get( 5 ) >= 1 )
                {
                    map.put( 10, map.get( 10 ) - 1 );
                    map.put( 5, map.get( 5 ) - 1 );
                }
                else if ( map.get( 5 ) != null && map.get( 5 ) >= 3 )
                {
                    map.put( 5, map.get( 5 ) - 3 );
                }
                else
                {
                    return false;
                }
            }

        }
        return true;
    }
}
