package com.algorithms.sword.means.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Offer59_1
{
    public int[] maxSlidingWindow( int[] nums, int k )
    {
        List< Integer > list = new ArrayList<>();
        PriorityQueue< int[] > queue = new PriorityQueue<>( ( arr1, arr2 ) -> arr2[ 0 ] - arr1[ 0 ] > 0 ? 1 : -1 );
        for ( int i = 0; i < nums.length; i++ )
        {
            int[] arr = new int[ 2 ];
            arr[ 0 ] = nums[ i ];
            arr[ 1 ] = i;
            if ( queue.size() < k )
            {
                queue.add( arr );
                if ( queue.size() == k ) list.add( queue.peek()[ 0 ] );
            }
            else
            {

                queue.add( arr );
                int maxIndex = queue.peek()[ 1 ];
                while ( maxIndex <= ( i - k ) )
                {
                    queue.poll();
                    maxIndex = queue.peek()[ 1 ];

                }
                list.add( queue.peek()[ 0 ] );

            }
        }
        int[] res = new int[ list.size() ];
        for ( int i = 0; i < list.size(); i++ )
        {
            res[ i ] = list.get( i );
        }
        return res;
    }
}
