package com.amazon.interview;

import java.util.Stack;

public class Leet85
{
    int max = 0;

    public int maximalRectangle( char[][] matrix )
    {
        if ( matrix.length == 0 ) return 0;
        int[] heights = new int[ matrix[ 0 ].length + 2 ];
        for ( int i = 0; i < matrix.length; i++ )
        {
            for ( int j = 1; j <= matrix[ 0 ].length; j++ )
            {
                if ( matrix[ i ][ j - 1 ] == '0' )
                {
                    heights[ j ] = 0;
                }
                else
                {
                    heights[ j ] += 1;
                }

            }
            findMaxRectangle( heights );
        }
        return max;
    }

    private void findMaxRectangle( int[] heights )
    {
        Stack< Integer > stack = new Stack<>();
        for ( int i = 0; i < heights.length; i++ )
        {
            while ( !stack.isEmpty() && heights[ stack.peek() ] > heights[ i ] )
            {
                int index = stack.pop();
                int left = stack.peek();
                max = Math.max( max, ( i - left - 1 ) * heights[ index ] );
            }
            stack.push( i );
        }
    }
}
