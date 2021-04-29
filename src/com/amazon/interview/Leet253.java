package com.amazon.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leet253
{
    public int minMeetingRooms( int[][] intervals )
    {
        if ( intervals.length == 0 ) return 0;
        Arrays.sort( intervals, new Comparator< int[] >()
        {
            @Override
            public int compare( int[] o1, int[] o2 )
            {
                return o1[ 0 ] - o2[ 0 ];
            }
        } );

        PriorityQueue< int[] > queue = new PriorityQueue<>( ( a, b ) -> a[ 1 ] - b[ 1 ] );
        int room = 1;
        for ( int[] interval : intervals )
        {
            if ( !queue.isEmpty() && queue.peek()[ 0 ] <= interval[ 0 ] && interval[ 0 ] < queue.peek()[ 1 ] )
            {
                room++;
            }
            else if ( !queue.isEmpty() )
            {
                queue.poll();
            }
            queue.add( interval );
        }
        return room;
    }
}
