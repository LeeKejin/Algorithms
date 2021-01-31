package com.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class FindCatalan
{
    static Map< Integer, Integer > map = new HashMap<>();
    static int sum = 0;

    private static int findCatalan( int n )
    {
        if ( n == 0 || n == 1 )
        {
            map.put( n, 1 );
            return 1;
        }
        if ( map.containsKey( n ) ) return map.get( n );
        for ( int i = 0; i < n; i++ )
        {
            sum += findCatalan( i ) * findCatalan( n - i - 1 );
            map.put( n, sum );
        }

        return map.get( n );
    }

    //val = c3c0+c2c1+c1c2+c0c3;
    private static int findCatalanDP( int n )
    {
        int dp[] = new int[ n + 1 ];
        dp[ 0 ] = 1;
        dp[ 1 ] = 1;

        for ( int i = 2; i <= n; i++ )
        {
            for ( int j = 0; j < i; j++ )
            {
                dp[ i ] += dp[ j ] * dp[ i - 1 - j ];
            }

        }
        return dp[ n ];
    }
}
