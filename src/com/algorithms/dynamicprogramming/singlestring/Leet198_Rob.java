package com.algorithms.dynamicprogramming.singlestring;

import java.util.HashMap;
import java.util.Map;

public class Leet198_Rob
{
    Map< Integer, Integer > map = new HashMap<>();
    int dp[][];

    public int robBetterDP( int[] nums )
    {
        if ( nums.length == 0 ) return 0;
        if ( nums.length == 1 ) return nums[ 0 ];
        dp = new int[ nums.length ][ 2 ];
        dp[ 0 ][ 0 ] = 0;
        dp[ 0 ][ 1 ] = nums[ 0 ];
        for ( int i = 1; i < nums.length; i++ )
        {
            dp[ i ][ 0 ] = Math.max( dp[ i - 1 ][ 0 ], dp[ i - 1 ][ 1 ] );
            dp[ i ][ 1 ] = nums[ i ] + dp[ i - 1 ][ 0 ];
        }

        return Math.max( dp[ nums.length - 1 ][ 1 ], dp[ nums.length - 1 ][ 0 ] );
    }

    public int robDp( int[] nums )
    {
        if ( nums.length == 0 ) return 0;
        map.put( 0, nums[ 0 ] );
        for ( int i = 1; i < nums.length; i++ )
        {
            map.put( i, 0 );
        }

        if ( nums.length == 1 ) return nums[ 0 ];

        for ( int i = 1; i < nums.length; i++ )
        {
            int sum1 = map.get( i - 1 );
            int sum2 = nums[ i ];
            if ( map.get( i - 2 ) != null )
            {
                sum2 += map.get( i - 2 );
            }
            map.put( i, Math.max( sum1, sum2 ) );
        }

        return Math.max( map.get( nums.length - 1 ), map.get( nums.length - 2 ) );
    }

    public int rob( int[] nums )
    {
        if ( nums.length == 0 ) return 0;

        return amount( nums, nums.length - 1 );
    }

    private int amount( int[] nums, int n )
    {
        if ( n == 0 )
        {
            return nums[ 0 ];
        }

        int sum1 = nums[ n ];
        int sum2 = 0;
        int val = 0;
        if ( n - 2 >= 0 )
        {
            if ( map.containsKey( n - 2 ) )
            {
                val = map.get( n - 2 );
            }
            else
            {
                val = amount( nums, n - 2 );
                map.put( n - 2, val );
            }

        }
        sum1 += val;
        if ( n - 1 >= 0 )
        {
            if ( map.containsKey( n - 1 ) )
            {
                sum2 = map.get( n - 1 );
            }
            else
            {
                sum2 = amount( nums, n - 1 );
                map.put( n - 1, sum2 );
            }
        }

        return Math.max( sum1, sum2 );
    }
}
