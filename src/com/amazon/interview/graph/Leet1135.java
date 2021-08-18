package com.amazon.interview.graph;

import java.util.PriorityQueue;

public class Leet1135
{
    class UnionClass
    {
        int[] parents;
        int time = 0;

        public UnionClass( int n )
        {
            parents = new int[ n ];
            for ( int i = 0; i < n; i++ )
            {
                parents[ i ] = i;
            }
        }

        void merge( int x, int y )
        {
            int rootX = find( x );
            int rootY = find( y );
            if ( rootX != rootY )
            {
                parents[ rootX ] = rootY;
                time++;
            }
        }

        private int find( int x )
        {
            if ( x != parents[ x ] )
            {
                parents[ x ] = find( parents[ x ] );
            }

            return parents[ x ];
        }

        boolean isConnected( int x, int y )
        {
            return find( x ) == find( y );
        }
    }

    //conections[i] = [city1, city2, cost]
    public int minimumCost( int n, int[][] connections )
    {
        PriorityQueue< int[] > queue = new PriorityQueue<>( ( a, b ) -> ( a[ 2 ] - b[ 2 ] ) );
        for ( int[] connection : connections )
        {
            queue.add( connection );
        }
        int count = 0;
        UnionClass unionClass = new UnionClass( n + 1 );

        while ( !queue.isEmpty() )
        {
            if ( unionClass.time == n - 1 ) break;
            int[] connection = queue.poll();
            if ( !unionClass.isConnected( connection[ 0 ], connection[ 1 ] ) )
            {
                unionClass.merge( connection[ 0 ], connection[ 1 ] );
                count += connection[ 2 ];
            }
        }
        if ( unionClass.time != n - 1 ) return -1;
        return count;
    }
}
