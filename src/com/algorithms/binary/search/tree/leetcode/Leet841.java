package com.algorithms.binary.search.tree.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet841
{
    public boolean canVisitAllRooms( List< List< Integer > > rooms )
    {
        boolean[] visited = new boolean[ rooms.size() ];
        visited[ 0 ] = true;
        Queue< Integer > queue = new LinkedList<>();
        for ( int key : rooms.get( 0 ) )
        {
            queue.add( key );
        }
        while ( !queue.isEmpty() )
        {
            int key = queue.poll();
            visited[ key ] = true;
            List< Integer > keys = rooms.get( key );
            for ( int k : keys )
            {
                if ( !visited[ k ] )
                {
                    queue.add( k );
                }
            }
        }
        for ( boolean visit : visited )
        {
            if ( !visit ) return false;
        }
        return true;
    }
}
