package com.amazon.interview;

import java.util.PriorityQueue;

public class Leet378
{
    public int kthSmallest( int[][] matrix, int k )
    {
        PriorityQueue< Integer > queue = new PriorityQueue<>( ( a, b ) -> ( b - a ) );
        for ( int i = 0; i < matrix.length; i++ )
        {
            for ( int j = 0; j < matrix[ 0 ].length; j++ )
            {
                queue.add( matrix[ i ][ j ] );
                if ( queue.size() > k )
                {
                    queue.poll();
                }

            }
        }
        return queue.peek();
    }
}
