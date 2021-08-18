package com.amazon.interview.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet332
{
    List< String > res = new ArrayList<>();

    public List< String > findItinerary( List< List< String > > tickets )
    {
        Map< String, PriorityQueue< String > > map = new HashMap<>();
        for ( List< String > ticket : tickets )
        {
            String start = ticket.get( 0 );
            String end = ticket.get( 1 );
            if ( !map.containsKey( start ) )
            {
                PriorityQueue< String > queue = new PriorityQueue<>( ( a, b ) -> a.compareTo( b ) );
                map.put( start, queue );
            }
            map.get( start ).add( end );
        }

        dfs( map, "JFK" );
        Collections.reverse( res );
        return res;
    }

    private void dfs( Map< String, PriorityQueue< String > > map, String place )
    {
        PriorityQueue< String > queue = map.get( place );

        while ( queue != null && !queue.isEmpty() )
        {
            dfs( map, queue.poll() );
        }
        res.add( place );
    }
}
