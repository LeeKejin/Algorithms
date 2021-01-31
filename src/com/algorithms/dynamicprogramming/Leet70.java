package com.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Leet70
{
    Map< Integer, Integer > map = new HashMap<>();

    public int climbStairs( int n )
    {
        if ( n == 1 )
        {
            map.put( 1, 1 );
            return 1;
        }
        if ( n == 2 )
        {
            map.put( 2, 2 );
            return 2;
        }
        if ( map.containsKey( n ) ) return map.get( n );

        int sum = climbStairs( n - 1 ) + climbStairs( n - 2 );
        map.put( n, sum );
        return map.get( n );

    }

    public int climbStairsSolution2( int n )
    {
        if ( n == 1 )
        {
            return 1;
        }
        if ( n == 2 )
        {
            return 2;
        }
        for ( int i = 1; i <= n; i++ )
        {
            if ( i == 1 )
            {
                map.put( i, 1 );
                continue;
            }
            if ( i == 2 )
            {
                map.put( i, 2 );
                continue;
            }
            int sum = map.get( i - 1 ) + map.get( i - 2 );
            map.put( i, sum );
        }

        return map.get( n );

    }
}
