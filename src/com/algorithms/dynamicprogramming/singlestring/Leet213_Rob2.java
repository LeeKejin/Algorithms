package com.algorithms.dynamicprogramming.singlestring;

import java.util.HashMap;
import java.util.Map;

public class Leet213_Rob2
{
    public int rob( int[] nums )
    {
        if ( nums.length == 0 ) return 0;
        if ( nums.length == 1 ) return nums[ 0 ];
        if ( nums.length == 2 ) return Math.max( nums[ 0 ], nums[ 1 ] );

        if ( nums.length == 1 ) return nums[ 0 ];

        int c1 = calculateWithRange( nums, 0, nums.length - 1 );
        int c2 = calculateWithRange( nums, 1, nums.length );

        return Math.max( c1, c2 );
    }

    private int calculateWithRange( int[] nums, int start, int end )
    {
        Map< Integer, Integer > map = new HashMap<>();
        map.put( start, nums[ start ] );
        for ( int i = start + 1; i < end; i++ )
        {
            int sum1 = map.get( i - 1 );
            int sum2 = nums[ i ];
            if ( map.get( i - 2 ) != null )
            {
                sum2 += map.get( i - 2 );
            }
            map.put( i, Math.max( sum1, sum2 ) );
        }
        return Math.max( map.get( end - 1 ), map.get( end - 2 ) );
    }

    int dp1[][];
    int dp2[][];

    public int robBetterSolution( int[] nums )
    {
        if ( nums.length == 0 ) return 0;
        if ( nums.length == 1 ) return nums[ 0 ];
        if ( nums.length == 2 ) return Math.max( nums[ 0 ], nums[ 1 ] );
        dp1 = new int[ nums.length ][ 2 ];
        dp2 = new int[ nums.length ][ 2 ];

        dp1[ 0 ][ 0 ] = 0;
        dp2[ 1 ][ 0 ] = 0;

        dp1[ 0 ][ 1 ] = nums[ 0 ];
        dp2[ 1 ][ 1 ] = nums[ 1 ];

        for ( int i = 1; i < nums.length - 1; i++ )
        {
            dp1[ i ][ 0 ] = Math.max( dp1[ i - 1 ][ 0 ], dp1[ i - 1 ][ 1 ] );
            dp1[ i ][ 1 ] = dp1[ i - 1 ][ 0 ] + nums[ i ];
        }

        for ( int i = 2; i < nums.length; i++ )
        {
            dp2[ i ][ 0 ] = Math.max( dp2[ i - 1 ][ 0 ], dp2[ i - 1 ][ 1 ] );
            dp2[ i ][ 1 ] = dp2[ i - 1 ][ 0 ] + nums[ i ];
        }

        int max = Math.max( Math.max( dp1[ nums.length - 2 ][ 1 ], dp1[ nums.length - 3 ][ 1 ] ),
            Math.max( dp2[ nums.length - 1 ][ 1 ], dp2[ nums.length - 2 ][ 1 ] ) );

        return max;
    }
}
