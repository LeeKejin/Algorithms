package com.amazon.interview;

import java.util.Stack;

public class Leet84
{
    public int largestRectangleArea( int[] heights )
    {
        if ( heights.length == 0 ) return 0;
        int[] newHeight = new int[ heights.length + 2 ];
        for ( int i = 1; i < newHeight.length - 1; i++ )
        {
            newHeight[ i ] = heights[ i - 1 ];
        }
        Stack< int[] > stack = new Stack<>();
        int area = 0;
        for ( int i = 0; i < newHeight.length; i++ )
        {
            while ( !stack.isEmpty() && stack.peek()[ 0 ] > newHeight[ i ] )
            {
                int val[] = stack.pop();
                int left[] = stack.peek();
                area = Math.max( ( i - left[ 1 ] - 1 ) * val[ 0 ], area );
            }

            stack.push( new int[] { newHeight[ i ], i } );
        }

        return area;
    }
}
