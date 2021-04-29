package com.amazon.interview;

import java.util.Arrays;

public class Leet1465
{
    public int maxArea( int h, int w, int[] horizontalCuts, int[] verticalCuts )
    {
        Arrays.sort( horizontalCuts );
        Arrays.sort( verticalCuts );
        long x = horizontalCuts[ 0 ];

        for ( int i = 1; i < horizontalCuts.length; i++ )
        {
            x = Math.max( x, horizontalCuts[ i ] - horizontalCuts[ i - 1 ] );
        }
        x = Math.max( x, h - horizontalCuts[ horizontalCuts.length - 1 ] );

        long y = verticalCuts[ 0 ];

        for ( int i = 1; i < verticalCuts.length; i++ )
        {
            y = Math.max( y, verticalCuts[ i ] - verticalCuts[ i - 1 ] );
        }
        y = Math.max( y, w - verticalCuts[ verticalCuts.length - 1 ] );

        return ( int ) ( ( x * y ) % 1000000007 );

    }
}
