package com.amazon.interview.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leet1192
{
    List< List< Integer > > list = new ArrayList<>();

    public List< List< Integer > > criticalConnections( int n, List< List< Integer > > connections )
    {
        Map< Integer, Set< Integer > > map = new HashMap<>();
        int[] ids = new int[ n ];
        for ( int i = 0; i < n; i++ )
        {
            map.put( i, new HashSet<>() );
            ids[ i ] = -1;
        }
        for ( List< Integer > connection : connections )
        {
            map.get( connection.get( 0 ) ).add( connection.get( 1 ) );
            map.get( connection.get( 1 ) ).add( connection.get( 0 ) );
        }
        dfs( 0, -1, map, ids, 0 );
        return list;
    }

    private int dfs( int start, int parent, Map< Integer, Set< Integer > > map, int[] ids, int id )
    {
        ids[ start ] = id;
        Set< Integer > set = map.get( start );

        for ( int value : set )
        {
            if ( parent == value ) continue;
            if ( ids[ value ] == -1 )
            {
                ids[ start ] = Math.min( dfs( value, start, map, ids, id + 1 ), ids[ start ] );
            }
            else
            {
                ids[ start ] = Math.min( ids[ start ], ids[ value ] );
            }
        }
        if ( ids[ start ] == id && start != 0 )
        {
            list.add( Arrays.asList( start, parent ) );
        }
        return ids[ start ];
    }
}
